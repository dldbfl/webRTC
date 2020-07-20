package kr.or.ddit.controller.websocket.endpoint;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.RemoteEndpoint.Basic;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import javax.websocket.server.ServerEndpointConfig;
import javax.websocket.server.ServerEndpointConfig.Configurator;

import kr.or.ddit.filter.PrincipalWithSession;

@ServerEndpoint("/wscam")
public class WebSocketServerCamEP {
	@OnOpen
	public void onOpen(Session session){
		System.out.println("WebSock Sever Open : " + session.toString());
	}
	
	@OnMessage(maxMessageSize=5242880)
	public void onMessage(Session session, byte[] imgBytes){
		System.out.println("서버 ByteBuffer 사이즈 : " + imgBytes.length);
		ByteBuffer buffer = ByteBuffer.wrap(imgBytes);
		try {
			Basic basic = session.getBasicRemote();
			
			if(session.isOpen()){
				session.getBasicRemote().sendBinary(buffer);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@OnClose
	public void onClose(Session session){
		try {
			System.out.println("웹캡 서버 웹 소켓 종료");
			session.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@OnError
	public void onError(Session session, Throwable t){
		System.out.println("에러 : " + t.toString());
	}
}








