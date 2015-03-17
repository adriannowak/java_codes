import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.websocket.CloseReason;
import javax.websocket.Encoder;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

public class SimpleMessage  {


	private String login;
	private String text;
	private Long date;
	
	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	public Long getDate() {
		return date;
	}
	
	public void setDate(Long date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "SimpleMessage [login=" + login + ", text=" + text + ", date="
				+ date + "]";
	}



}
