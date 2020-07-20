package kr.or.ddit.controller.websocket.client;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/client/wsclient/")
public class WebSocketClient {
	@RequestMapping("/chatting")
	public String wsClientUIChatting(){
		return "client/wsclientChatting";
	}
	// IE 브라우저 활용(웹캠, 스냅샷)
	@RequestMapping("/webCamSnapShotIE")
	public String wsClientUIWebCamSnapShotIE(){
		return "client/webCamSnapShotIE";
	}

	// 크롬 브라우저 활용
	@RequestMapping("/webCamIEetc")
	public String wsClientUIWebCamIEetc(){
		return "client/webCamIEetc";
	}
	
	
}
