package edu.uwec.cs.sheaffmc.program4;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;

public class Painter implements ActionListener {

	//Instance variables for painter
	private PaintingPrimative currentPrimative;
	private PaintingPrimative primativeBeingUsed;
	private PaintingPrimative lastPrimativeDrawn;
	private PaintingPanel pPanel;
	private Color currentColor;
	private Point startPoint;
	private Point endPoint;
	private JTextField tf;
	private JScrollPane sp;
	private JTextArea jt;
	

	//Instance variables for sockets
	private InputStream is;
	private OutputStream os;
	private	ObjectInputStream ois;
	private ObjectOutputStream oos;
	
	public static void main(String[] args) {
		new Painter();
	}

	public Painter() {

		/*
		 * PAINTER
		 */

		// creating the frame
		JFrame f = new JFrame();
		f.setSize(new Dimension (500,725));
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setResizable(false);

		// creating the main panel which will be placed on the frame
		JPanel p = new JPanel();
		p.setSize(new Dimension(500,726));
		p.setBackground(Color.RED);
		p.setLayout(new FlowLayout(0,0,0));

		// creating a base panel for the paint components
		JPanel paintPanel = new JPanel();
		paintPanel.setPreferredSize(new Dimension(500,500));
		paintPanel.setLayout(new BorderLayout());

		// creating a panel for the shapes
		JPanel topPanel = new JPanel();
		topPanel.setLayout(new GridLayout(1, 3)); // 1 by 2

		// creating a panel for the color
		JPanel leftPanel = new JPanel();
		leftPanel.setLayout(new GridLayout(3, 1)); // 3 by 1

		// Creating the panel to be painted on
		pPanel = new PaintingPanel();
		pPanel.setBackground(Color.WHITE);
		pPanel.addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseDragged(MouseEvent e) {
				Point p = e.getPoint();
				if (currentPrimative.toString().equals("line")) {
					Line l = new Line(currentColor, startPoint, p);
					pPanel.setTempPrimative(l);
				} else if (currentPrimative.toString().equals("circle")) {
					Circle c = new Circle(currentColor, startPoint, p);
					pPanel.setTempPrimative(c);
				} else if (currentPrimative.toString().equals("rectangle")) {
					Rectangle r = new Rectangle(currentColor, startPoint, p);
					pPanel.setTempPrimative(r);
				}
			}

			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO auto-generated stub
			}

		});

		// CHANGED FROM ORIGINAL PAINT PROGRAM
		// instead of adding to the list of objects to draw,
		// object is sent to the hub. the object is not painted
		// at this point in the code.
		pPanel.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent arg0) {
				endPoint = arg0.getPoint();
				try {
					if (currentPrimative.toString().equals("line")) {
						Line l = new Line(currentColor, startPoint, endPoint);
						oos.writeObject(l);
					} else if (currentPrimative.toString().equals("circle")) {
						Circle c = new Circle(currentColor, startPoint, endPoint);
						oos.writeObject(c);
					} else if (currentPrimative.toString().equals("rectangle")) {
						Rectangle r = new Rectangle(currentColor, startPoint, endPoint);
						oos.writeObject(r);
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//				pPanel.repaint();
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				startPoint = arg0.getPoint();

				pPanel.repaint();
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});


		// creating buttons for color button panel
		// add red Paint Button
		JButton redPaint = new JButton();
		redPaint.setBackground(Color.RED);
		redPaint.setActionCommand("red");
		redPaint.addActionListener(this);
		leftPanel.add(redPaint); // Added in next open cell in the grid

		// add green Paint Button
		JButton greenPaint = new JButton();
		greenPaint.setBackground(Color.GREEN);
		greenPaint.setActionCommand("green");
		greenPaint.addActionListener(this);
		leftPanel.add(greenPaint);

		// add blue Paint Button
		JButton bluePaint = new JButton();
		bluePaint.setBackground(Color.BLUE);
		bluePaint.setActionCommand("blue");
		bluePaint.addActionListener(this);
		leftPanel.add(bluePaint);


		// creating buttons for shape button panel
		// add "line" button
		JButton lineButton = new JButton("Line");
		lineButton.setActionCommand("line");
		lineButton.addActionListener(this);
		topPanel.add(lineButton);

		// add "circle" button
		JButton circleButton = new JButton("Circle");
		circleButton.setActionCommand("circle");
		circleButton.addActionListener(this);
		topPanel.add(circleButton);

		// add "rectangle" button
		JButton rectButton = new JButton("Rectangle");
		rectButton.setActionCommand("rectangle");
		rectButton.addActionListener(this);
		topPanel.add(rectButton);

		// Adding the color and shape panels to painting panel
		paintPanel.add(leftPanel, BorderLayout.WEST);
		paintPanel.add(topPanel, BorderLayout.NORTH);
		paintPanel.add(pPanel, BorderLayout.CENTER);

		
		/*
		 * CHAT PANEL
		 */
		
		final String name = JOptionPane.showInputDialog("Enter your name");
		
		// creating a base panel for the chat components
		JPanel chatPanel = new JPanel();
		chatPanel.setBackground(Color.DARK_GRAY);
		chatPanel.setPreferredSize(new Dimension(500,200));
		chatPanel.setLayout(new FlowLayout());

		// creating a text box for the chat
		jt = new JTextArea(6,36);
		sp = new JScrollPane(jt);	// makes a new scrolling window inside the text area
		sp.setPreferredSize(new Dimension(400, 150));
		sp.setBackground(Color.WHITE);

		// creating a text box for the users lines
		tf = new JTextField(36);
		tf.setFocusable(true);
		// the KeyListener waits for the enter key (key code = 10)
		// to be pressed. once pressed, text from textField is sent off
		// and the text in the TextField is returned to null
		tf.addKeyListener(new KeyListener() {
			
			@Override
			public void keyPressed(KeyEvent arg0) {
				int keyCode = arg0.getKeyCode();
				if (keyCode == 10) {
					String text = tf.getText();
					try {
						oos.writeObject(name + ": " + text);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					tf.setText("");
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});

		chatPanel.add(sp);
		chatPanel.add(tf);

		p.add(paintPanel);
		p.add(chatPanel, -1);
		
		
		
		/*
		 * SOCKETS AND CONNECTIONS
		 */
		
		try {
			// creates a connection to the hub
			Socket s = new Socket("localhost", 7000);

			is = s.getInputStream();
			ois = new ObjectInputStream(is);

			os = s.getOutputStream();
			oos = new ObjectOutputStream(os);

			// forks off a new thread to only deal with the listening for
			// incoming objects
			PainterListener tl = new PainterListener(ois, this);

			Thread th = new Thread(tl);
			th.start();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		
		f.setContentPane(p);
		f.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		// determines what action to take depending on what button is pressed.
		String action = e.getActionCommand();

		if (action.equals("red")) {
			System.out.println("red");
			currentColor = Color.RED;
		} else if (action.equals("green")) {
			System.out.println("green");
			currentColor = Color.GREEN;
		} else if (action.equals("blue")) {
			System.out.println("blue");
			currentColor = Color.BLUE;
		} else if (action.equals("line")) {
			System.out.println("line");
			currentPrimative = new Line();
		} else if (action.equals("circle")) {
			System.out.println("circle");
			currentPrimative = new Circle();
		} else if (action.equals("rectangle")) {
			System.out.println("rectangle");
			currentPrimative = new Rectangle();
		}
	}

	public void setPPanelList(ArrayList<PaintingPrimative> paintList) {
		pPanel.setList(paintList);
	}

	public void repaintPanel() {
		pPanel.repaint();
	}
	
	public void addToPanel(PaintingPrimative p) {
		pPanel.addPrimative(p);
	}
	
	public void addToChat(String s) {
		jt.append(s + "\n");
	}
	
	public void closeThread(Thread t) {
		
	}
}