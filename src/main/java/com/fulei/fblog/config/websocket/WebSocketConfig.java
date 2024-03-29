package com.fulei.fblog.config.websocket;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * @author fulei
 * @Title: WebSocketConfig
 * @ProjectName fblog
 * @Description: WebSocketConfig
 * @date 2019/12/2 18:31
 */
@Configuration
public class WebSocketConfig {

  @Bean
  public ServerEndpointExporter serverEndpointExporter(){
    return new ServerEndpointExporter();
  }

}
