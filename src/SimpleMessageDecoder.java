import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.sound.midi.SysexMessage;
import javax.websocket.CloseReason;
import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import com.google.gson.Gson;

public class SimpleMessageDecoder implements Decoder.Text<BaseVO> {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(EndpointConfig arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public BaseVO decode(String arg0) throws DecodeException {
		System.err.println(arg0);
		Gson gson = new Gson();
		return gson.fromJson(arg0,BaseVO.class);
	}

	@Override
	public boolean willDecode(String arg0) {
		return true;
	}



}
