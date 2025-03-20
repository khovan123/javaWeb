package com.chat.websocket;

import jakarta.websocket.*;
import jakarta.websocket.server.*;
import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

@ServerEndpoint("/chatendpoint/{roomId}")
public class ChatWebSocket {

    private static final Map<String, Map<Session, String>> rooms = Collections.synchronizedMap(new HashMap<>());
    private static final Map<String, List<String>> messageStore = Collections.synchronizedMap(new HashMap<>());

    @OnOpen
    public void onOpen(Session session, @PathParam("roomId") String roomId) {
        Map<Session, String> roomClients = rooms.computeIfAbsent(roomId, k -> Collections.synchronizedMap(new HashMap<>()));
        roomClients.put(session, roomId);
        List<String> messages = messageStore.getOrDefault(roomId, new ArrayList<>());
        for (String msg : messages) {
            try {
                session.getBasicRemote().sendText(msg);
            } catch (IOException ex) {
                Logger.getLogger(ChatWebSocket.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @OnMessage
    public void onMessage(String message, Session session, @PathParam("roomId") String roomId) throws IOException {
        List<String> messages = messageStore.computeIfAbsent(roomId, k -> Collections.synchronizedList(new ArrayList<>()));
        messages.add(message);
        // Gửi tin nhắn tới các client trong cùng phòng
        Map<Session, String> roomClients = rooms.get(roomId);
        if (roomClients != null) {
            for (Session client : roomClients.keySet()) {
                if (client.isOpen()) {
                    client.getBasicRemote().sendText(message);
                }
            }
        }
    }

    @OnClose
    public void onClose(Session session, @PathParam("roomId") String roomId) {
        Map<Session, String> roomClients = rooms.get(roomId);
        if (roomClients != null) {
            roomClients.remove(session);
            if (roomClients.isEmpty()) {
                rooms.remove(roomId);
            }
        }
    }
}
