package com.fulei.fblog.server;

import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author fulei
 * @Title: WebSocketServer
 * @ProjectName fblog
 * @Description: 提供给客户端连接websocket
 * @date 2019/12/3 10:07
 */
@ServerEndpoint("/websocket/{sid}")
@Component
@Slf4j
public class WebSocketServer {

  private static int onlineCount = 0;

  private static CopyOnWriteArraySet<WebSocketServer> webSocketSet = new CopyOnWriteArraySet<>();

  private Session session;

  private String sid = "";

  @OnOpen
  public void open(Session session, @PathParam("sid") String sid){
      this.session = session;
      webSocketSet.add(this);
      addOnlineCount();
      log.info("有新窗口开启监听：{},当前在线人数为:{}",sid,getOnlineCount());
      this.sid = sid;
      sendMessage("连接成功");
  }

  @OnClose
  public void close(){
    webSocketSet.remove(this);
    subOnlineCount();
    log.info("有一连接关闭，当前在线人数为:{}",getOnlineCount());
  }

  @OnMessage
  public void message(String message){
      for(WebSocketServer webSocketServer:webSocketSet){
        webSocketServer.sendMessage(message);
      }
  }

  @OnError
  public void error(Session session,Throwable error){
    log.error("发生错误");
    error.printStackTrace();
  }

  @SneakyThrows(IOException.class)
  private void sendMessage(String message){
    this.session.getBasicRemote().sendText(message);
  }

  public static synchronized  int getOnlineCount(){
    return onlineCount;
  }

  private static synchronized void addOnlineCount(){
    onlineCount++;
  }

  private static synchronized void subOnlineCount(){
    onlineCount--;
  }

  public static void sendInfo(String message,String sid){
    for(WebSocketServer webSocketServer:webSocketSet){
      if(sid == null){
        webSocketServer.sendMessage(message);
      }else if(webSocketServer.sid.equals(sid)){
        webSocketServer.sendMessage(message);
      }
    }
  }
}
