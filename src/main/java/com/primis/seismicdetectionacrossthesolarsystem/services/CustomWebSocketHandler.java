package com.primis.seismicdetectionacrossthesolarsystem.services;

import io.micrometer.common.lang.NonNullApi;
import org.springframework.web.socket.BinaryMessage;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@NonNullApi
public class CustomWebSocketHandler extends TextWebSocketHandler {

    // TODO: implement this
    @Override
    protected void handleBinaryMessage(WebSocketSession session, BinaryMessage message) {

        System.out.println("Please man, hear me out!");
    }

    //! DON'T TOUCH
    @Override
    public void afterConnectionEstablished(WebSocketSession session) {
        System.out.println("Connection ESTABLISHED successfully!");
    }

    //! DON'T TOUCH
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) {
        System.out.println("Connection CLOSED successfully!");
    }

}
