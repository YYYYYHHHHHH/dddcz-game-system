package com.example.demo.serviceImpl;

import java.io.Console;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.component.WebSocketServer;
import com.example.demo.entity.AuthUser;
import com.example.demo.entity.GroupChat.Chat;
import com.example.demo.entity.GroupChat.ChatUserInfo;
import com.example.demo.entity.GroupChat.SocketData;
import com.example.demo.service.GroupChatService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroupChatServiceImpl implements GroupChatService {
    @Autowired
    private WebSocketServer wServer;
    @Autowired
    private AuthUserServiceImpl authUserServiceImpl;

    private List<Chat> chats = new ArrayList<>();

    private List<AuthUser> lUsers = null;

    @Override
    public List<ChatUserInfo> getChatUsers() {
        lUsers = authUserServiceImpl.getUsers();
        List<Integer> userIds = wServer.getUserIdsOnLine();
        List<ChatUserInfo> chatUserInfos = new ArrayList<ChatUserInfo>();

        lUsers.forEach(user -> {
            boolean isOnLine = userIds.contains(user.getId());
            chatUserInfos.add(new ChatUserInfo(user, isOnLine));
        });

        return chatUserInfos;
    }

    @Override
    public List<Chat> getChatByLimit(int start, int num) {
        // int length = chats.size();
        // if(start > length - 1 || length == 0) 
        //     return chats; 
        
        // return chats.subList(start, start + num > length ? length : start + num);

        // 先不做分页
        return chats;
    }

    @Override
    public void sendChat(int userId, String mes) {
        AuthUser user = lUsers.get(lUsers.indexOf(new AuthUser(userId)));
        Chat chat = new Chat(user, mes, new Date(System.currentTimeMillis()));
        chats.add(chat);
        // 群发消息
        returnChat(new SocketData(3, chat));
    }

    @Override
    public void returnChat(SocketData data) {
        wServer.sendInfoAllOnLine(JSONObject.toJSONString(data));
    }
    
}
