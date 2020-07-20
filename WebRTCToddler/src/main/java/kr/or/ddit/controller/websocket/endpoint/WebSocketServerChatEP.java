package kr.or.ddit.controller.websocket.endpoint;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.RemoteEndpoint.Basic;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import kr.or.ddit.filter.PrincipalWithSession;

@ServerEndpoint("/wschat")
public class WebSocketServerChatEP {
	private static ArrayList<Session> sessionList = new ArrayList<Session>(); 
	private HttpSession httpSession;
	
	@OnOpen 
	public void onOpen(Session webSocketSession){ 
		// javax.websocket.Session을 통한 HttpSession 취득
		httpSession = ((PrincipalWithSession)webSocketSession.getUserPrincipal()).getSession();
		// 클라이언트의 WebSocket 생성시 콜백.
	    try{ 
	        sessionList.add(webSocketSession); 
	        // 신규 접근 클라이언트 대상 메세지 전송.
	        webSocketSession.getBasicRemote().sendText("WebSocket 서버에 접속되었습니다.!"); 
	    }catch(IOException e){} 
	} 
	 
	@OnClose 
	public void onClose(Session session){ 
		// 클라이언트의 웹소켓 리소스 close() 호출에따라 콜백.
	    sessionList.remove(session); 
	} 
	 
	@OnMessage
	public void onMessage(String msg){ 
		// 클라이언트의 WebSocket.send() 호출에따라 콜백.
	    try{ 
	    	// 브로드캐스팅(모든 세션 대상 메세지 송신)
	        for(Session session : sessionList){ 
	        	Basic clientBase = session.getBasicRemote();
	        	// HttpSession ID값을 매개로 생성된 javax.websocket.Session의 ID 속성값 취득 및
	        	// 유니캐스팅, 멀티캐스팅에 활용
	        	System.out.println("ID : " + session.getId());
	            clientBase.sendText(msg); 
	        } 
	    }catch(IOException e){} 
	} 
	
    @OnError
    public void onError(Throwable exception) throws Throwable {
        System.out.println("Chat Error: " + exception.toString());
    }
}
