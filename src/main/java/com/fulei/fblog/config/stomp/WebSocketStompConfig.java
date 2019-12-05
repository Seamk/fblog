package com.fulei.fblog.config.stomp;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * @author fulei
 * @Title: WebSocketStompConfig
 * @ProjectName fblog
 * @Description: WebSocket的stomp实现
 * @date 2019/12/5 14:38
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketStompConfig implements WebSocketMessageBrokerConfigurer {

  @Override
  public void registerStompEndpoints(StompEndpointRegistry registry) {
    registry.addEndpoint("/stomp").withSockJS();
  }

  @Override
  public void configureMessageBroker(MessageBrokerRegistry registry) {

  }

}
