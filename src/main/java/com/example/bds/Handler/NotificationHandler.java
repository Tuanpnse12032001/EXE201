package com.example.bds.Handler;

import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;
@Service
public class NotificationHandler extends TextWebSocketHandler {
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        // Xử lý tin nhắn từ client và gửi lại thông báo
        String payload = message.getPayload();
        session.sendMessage(new TextMessage("New message : " + payload));
    }
}
