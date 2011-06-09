package edu.uwec.cs.sheaffmc.program4;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;

public class Hub {

	private ArrayList<ObjectOutputStream> objectOutputStreams;
	private ArrayList<ObjectInputStream> objectInputStreams;
	private ArrayList<PaintingPrimative> paintingPrimativesList;
	private ArrayList<String> chatList;
	private ArrayList<Thread> hubThreadList;

	public static void main(String[] args) {
		new Hub();
	}

	public Hub() {	

		objectOutputStreams = new ArrayList<ObjectOutputStream>();
		objectInputStreams = new ArrayList<ObjectInputStream>();
		paintingPrimativesList = new ArrayList<PaintingPrimative>();
		chatList = new ArrayList<String>();
		hubThreadList = new ArrayList<Thread>();


		try {
			ServerSocket ss = new ServerSocket(7000);
			while (true) {
				final Socket s = ss.accept();

				OutputStream os = s.getOutputStream();
				ObjectOutputStream oos = new ObjectOutputStream(os);
				objectOutputStreams.add(oos);

				InputStream is = s.getInputStream();
				ObjectInputStream ois = new ObjectInputStream(is);
				objectInputStreams.add(ois);

				Thread thListen = new Thread(new HubListener(ois, oos));
				thListen.start();
				hubThreadList.add(thListen);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private class HubListener implements Runnable {

		private ObjectInputStream in;
		private ObjectOutputStream out;

		public HubListener(ObjectInputStream ins, ObjectOutputStream outs) {
			this.in = ins;
			this.out = outs;
		}

		@Override
		public void run() {
			try {
				for (PaintingPrimative ppp: paintingPrimativesList) {
					out.writeObject(ppp);	
				}
				for (String s: chatList) {
					out.writeObject(s);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			boolean keepRunning = true;
			
			while (keepRunning) {
				try {
					System.out.println("thread started in hub");

					Object o = in.readObject();

					if (o instanceof PaintingPrimative) {
						PaintingPrimative pp =(PaintingPrimative) o;
						paintingPrimativesList.add(pp);
					} else if ( o instanceof String) {
						String c = (String) o;
						chatList.add(c);
					}


					for (ObjectOutputStream oos2: objectOutputStreams) {
						oos2.writeObject(o);
					}

				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SocketException e) {
					objectOutputStreams.remove(out);
					objectInputStreams.remove(in);
					hubThreadList.remove(this);
					

					if (objectOutputStreams.isEmpty()){
						System.exit(0);
					}

					keepRunning = false;
					
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}

	}			
}
