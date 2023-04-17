package com.example.websocket;

import jakarta.websocket.*;
import jakarta.websocket.server.PathParam;
import jakarta.websocket.server.ServerEndpoint;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

@Component
@ServerEndpoint(value = "/socket/{id}")
@Slf4j
public class WebSocketServer {

    //与某个客户端连接会话，存放了和客户端连接对应的websocket对象
    private Session session;

    //线程安全的集合
    public static ConcurrentHashMap<Integer,WebSocketServer> map=new ConcurrentHashMap<>();


    //统计在线连接数
    private static  int onlineCount=0;

    private Integer id;

    @OnOpen
    public void onOpen(@PathParam(value = "id")Integer id, Session session){
        log.info("连接成功");
        this.id=id;
        this.session=session;
        map.put(id,this);
        addOnlineCount();
        log.info("有新的连接加入，当前在线人数为:"+getOnlineCount());
        sendMessage("----连接已经成功建立");
    }

    //收到客户端发送的消息，调用的方法
    @OnMessage
    public void onMessage(Session session,String msg){
        log.info("接收到客户端发送的消息:"+msg);
        broadcastMsg(msg);
    }


    @OnClose
    public void onClose(){
        log.info("有连接关闭");
        map.remove(this.id);
        subOnlineCount();
        log.info("有连接关闭,当前在线人数为:"+getOnlineCount());
    }


    @OnError
    public void onError(Session session,Throwable error){
        log.error(error.getMessage());
        error.printStackTrace();
    }


    //发送消息
    private void sendMessage(String msg){
        Session session1 = getSession();
        try {
            session1.getBasicRemote().sendText(msg);
        } catch (IOException e) {
            log.error(e.getMessage());        }
    }

    //私聊
    private void sendMessageById(Integer id,String msg){
        WebSocketServer webSocketServer = map.get(id);
        if(webSocketServer!=null){
            webSocketServer.sendMessage(msg);
        }
        else {
            log.info("客户端已下线，不能发送消息");
        }
    }

    //群发消息
    private void broadcastMsg(String msg){
        for (WebSocketServer server:map.values()){
            server.sendMessage(msg);
        }
    }

    public Session getSession(){
        return session;
    }


    //加锁，实现线程安全
    public static synchronized  void  addOnlineCount(){
        WebSocketServer.onlineCount++;
    }


    //加锁，实现线程安全
    public static synchronized  void  subOnlineCount(){
        WebSocketServer.onlineCount--;
    }


    //加锁，实现线程安全
    public static synchronized  int  getOnlineCount(){
        return WebSocketServer.onlineCount;
    }
}
