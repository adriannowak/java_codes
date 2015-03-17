import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.sound.midi.SysexMessage;
import javax.websocket.CloseReason;
import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import com.google.gson.Gson;

public class SimpleMessageEncoder implements Encoder.Text<BaseVO> {

	@Override
	public void destroy() {

	}

	@Override
	public void init(EndpointConfig arg0) {

	}


	@Override
	public String encode(BaseVO arg0) throws EncodeException {
		Gson json = new Gson();
		String response = json.toJson(arg0);
		System.err.println(response);
		return response;
	}

}
