package edu.uwec.cs.sheaffmc.program4;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.SocketException;

public class PainterListener implements Runnable {
	
	private ObjectInputStream ois;
	private Painter p;
	
	public PainterListener(ObjectInputStream ois, Painter p) {
		this.ois = ois;
		this.p = p;
	}

	@Override
	public void run() {
		PaintingPrimative sentPrim;
		while (true) {
			try {
				System.out.println("thread started in socket painter");
				Object o = ois.readObject();
				
				if (o instanceof PaintingPrimative) {
					sentPrim = (PaintingPrimative) o;
					System.out.println("object recieved");
				
					p.addToPanel(sentPrim);
					p.repaintPanel();	// repaint called here instead of when mouse is released
					
				} else if (o instanceof String) {
					String text = (String) o;
					p.addToChat(text);
				}
				
			} catch (SocketException e) {
				System.exit(0);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
	}

}
