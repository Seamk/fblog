package com.fulei.fblog.controller.chat;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author fulei
 * @Title: ChatController
 * @ProjectName fblog
 * @Description: TODO
 * @date 2019/12/3 11:18
 */
@RestController
public class ChatController {

  @RequestMapping("/chat/{cid}")
  public void chat(@PathVariable String cid,String message){
        WebSocketServer.sendInfo(message,cid);
  }

}
