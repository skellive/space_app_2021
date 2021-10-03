/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.biz.metodos.generales;

import com.biz.objetos.ObjBitacora;
import com.google.gson.Gson;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.json.JsonObject;
import org.json.JSONObject;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

/**
 *
 * @author anderson
 */
@Configuration
@EnableWebSocketMessageBroker
public abstract class WebSocket extends AbstractWebSocketMessageBrokerConfigurer{


    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.enableSimpleBroker("/topic");
        config.setApplicationDestinationPrefixes("/app");
    }
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
         registry.addEndpoint("/chat");
         registry.addEndpoint("/chat").withSockJS();
    }

@MessageMapping("/chat")
@SendTo("/topic/messages")
public JSONObject send(ObjBitacora message) throws Exception {
    String time = new SimpleDateFormat("HH:mm").format(new Date());
    JSONObject json = new JSONObject(message.toJson());
    return json;
}

}
