package com.fulei.fblog.controller.chat;

import com.fulei.fblog.server.WebSocketServer;
import org.springframework.http.HttpStatus;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author fulei
 * @Title: ChatController
 * @ProjectName fblog
 * @Description: ChatController
 * @date 2019/12/3 11:18
 */
@RestController
public class ChatController {

  /**
   * 提供客户端发送消息
   * @param cid
   * @param message
   */
  @PostMapping("/send/{cid}")
  @ResponseStatus(HttpStatus.OK)
  public void chat(@PathVariable String cid,String message){
        //TODO 登录完成后，cid去除
        WebSocketServer.sendInfo(message,cid);
  }

  @MessageMapping("/send")
  @SendTo("/topic")
  public void send(){

  }

}
