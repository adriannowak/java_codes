import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JToggleButton;
import javax.websocket.DeploymentException;
import javax.websocket.EncodeException;

import org.glassfish.tyrus.server.Server;

import com.google.gson.Gson;


public class ChatMainApp {
	
	
	public static void main(String ... arg0) {
		
		
		
        final Server server = new Server("localhost", 31337, "/mainApp", ChatWebSocket.class);
        try {
			
        	
        	server.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            
            final JFrame jframe = new JFrame();
            jframe.setSize(200,100);
            final String [] msg = new String [] { "Włącz","Wyłącz" };
            final JToggleButton text = new JToggleButton(msg[0]);
            text.setSelected(false);
            jframe.add(text);
            text.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					if(text.isSelected()) {
						text.setText(msg[1]);
						try {
							server.start();
						} catch (DeploymentException e1) {
							e1.printStackTrace();
						}
					}else {
						server.stop();
						text.setText(msg[0]);

					}
				}
			});
            jframe.setVisible(true);
		} catch (DeploymentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	}
}
