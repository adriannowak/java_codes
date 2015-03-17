import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import javax.websocket.CloseReason;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import com.google.gson.Gson;

@ServerEndpoint(value = "/mainApp/{nick}")
public class ChatWebSocket {

	private static final Map<Session,Join> sessions = Collections.synchronizedMap(new HashMap<Session,Join>());
	Gson json = new Gson();

	@OnOpen
	public void onOpen(Session session,@PathParam("nick") final String nick) {
		System.err.println(this.sessions.size());
		Join join = new Join();
		join.setTimestamp(new Date().getTime());
		join.setSrc(getNick(nick));
		
		String hello = json.toJson(join);

		for(Session sess : sessions.keySet()) {
			sess.getAsyncRemote().sendText(hello);
		}

		String response = json.toJson(new BuddyList(sessions.values(),join.getSrc()));
		session.getAsyncRemote().sendText(response);
		sessions.put(session, join);
		
	}
	
	private String getNick(String nick) {
		for(Join join : sessions.values()) {
			if(join.getSrc().equals(nick)) {
				return getNick(nick + new Random().nextInt(100));
			}
		}
		
		return nick;
	}

	@OnMessage
	public String onMessage(String message, Session session) throws IOException {

		BaseVO base = json.fromJson(message, BaseVO.class);
		
		if(base.getType().equals(TYPE.HTMLCONTENT)) {
			HtmlContent content = json.fromJson(message, HtmlContent.class);
			content.setContent("xxxxxxxx");
			
			
	        URL yahoo = new URL(content.getUrl());
	        URLConnection yc = yahoo.openConnection();
	        BufferedReader in = new BufferedReader(
	                                new InputStreamReader(
	                                yc.getInputStream()));
	        String inputLine;
	        String result = "";
	        while ((inputLine = in.readLine()) != null) 
	        	result += inputLine;
	        
	        content.setContent(result);
			return json.toJson(content);
		}
		for (Session session1 : this.sessions.keySet()) {
			session1.getAsyncRemote().sendText(message);
		}

		return null;
	}

	@OnClose
	public void onClose(Session session, CloseReason closeReason) {
		Join join = this.sessions.get(session);
		Leave leave = new Leave(join);
		sessions.remove(session);

		String response = json.toJson(leave);

		for (Session session1 : this.sessions.keySet()) {
			session1.getAsyncRemote().sendText(response);
		}

	}

}
