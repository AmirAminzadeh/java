
/*
Student Name: Amir Aminzadeh
Student Number: 126554187
Date: 2019-10-26
*/
package com.senecacollege.task3.java;

import java.awt.*;//Java AWT (Abstract Window Toolkit) is an API to develop GUI or window-based applications in java
import java.awt.event.*;//The members of this package fall into three categories: 1.Events, 2.Listeners, 3.Adapters
import java.awt.geom.*;//Provides the Java 2D classes for defining and performing operations on objects related to two-dimensional geometry

public class Task3 extends Canvas {// Canvas class is a part of Java AWT. Canvas is a blank rectangular area where
									// the user can draw or trap input from the user
	Frame myFrame;// A Frame is a top-level window with a title and a border
	TextField myText;// A TextField object is a text component that allows for the editing of a
						// single line of text
	Font myFont;// The Font class represents fonts
	Color myTextColor;// The Color class is used to encapsulate colors in the defaults RGB
						// (RedGreenBlue) color

	public Task3() {// This is the constructor for new object
		this("Serif", Font.BOLD, 45, Color.WHITE, Color.BLACK);// ==>(its font, the fond as a bold words,the size of the
																// font,
																// the color of background, the color of frame)
	}

	public Task3(String ff, int fs, int fz, Color bg, Color fg) {// This is the constructor with 5 elements
		setBackground(bg);// background color
		myTextColor = fg;// the text color
		myFont = new Font(ff, fs, fz);// the font with 3 parts such as the kind of font, being bold, and size
		myText = new TextField("   Welcome   To   Java   ");// the text into central of frame
		myFrame = new Frame("Welcome to Java");// the name of frame
		myFrame.add(this, BorderLayout.CENTER);// A border layout lays out a container, arranging and resizing its
												// components to fit in five regions:north, south, east, west, and
												// center.
		myFrame.setSize(new Dimension(500, 500));// Size of my frame

		myFrame.addWindowListener(new WindowAdapter() {// Adds the specified window listener to receive window events
														// from this window.If l is null, no exception is thrown and no
														// action is performed.
			public void windowClosing(WindowEvent we) {// This function is for closing the frame
				System.exit(0);
			}
		});

		myText.addActionListener(new ActionListener() {// Adds the specified action listener to receive action events
														// from this text field
			public void actionPerformed(ActionEvent ae) {
				repaint();
			}
		});
		myFrame.setVisible(true);// The setVisible() method in Java makes the GUI component visible to the
									// user depending on the Boolean parameter you pass in the function

	}

	// This method for texting the string on a circle that the circle designed into
	// drawCircleText method
	public void paint(Graphics g) {
		String st = myText.getText();
		if (st.length() == 0)
			return;
		if (g instanceof Graphics2D) {
			Dimension cd = getSize();
			Point pt = new Point(cd.width / 2, cd.height / 2);
			int radius = (int) (pt.x * .34);
			g.setColor(myTextColor);
			g.setFont(myFont);
			drawCircleText((Graphics2D) g, st, pt, radius, -Math.PI / 1, 1.0);
		} else {
			System.out.println("Cannot draw curved text without a Graphics2D");
		}
	}

	// This method is for drawing the circle text
	// ==> void com.senecacollege.task3.java.Task3.drawCircleText(Graphics2D g,
	// String st, Point center, double r, double a1, double af)
	static void drawCircleText(Graphics2D g, String st, Point center, double r, double a1, double af) {
		double curangle = a1;
		Point2D c = new Point2D.Double(center.x, center.y);
		char ch[] = st.toCharArray();
		FontMetrics fm = g.getFontMetrics();
		AffineTransform xform1, cxform;
		xform1 = AffineTransform.getTranslateInstance(c.getX(), c.getY());
		for (int i = 0; i < ch.length; i++) {
			double cwid = (double) (getWidth(ch[i], fm));
			if (!(ch[i] == ' ' || Character.isSpaceChar(ch[i]))) {
				cwid = (double) (fm.charWidth(ch[i]));
				cxform = new AffineTransform(xform1);
				cxform.rotate(curangle, 0.0, 0.0);
				String chstr = new String(ch, i, 1);
				g.setTransform(cxform);
				g.drawString(chstr, (float) (-cwid / 2), (float) (-r));
			}

			if (i < (ch.length - 1)) {
				double adv = cwid / 2.0 + fm.getLeading() + getWidth(ch[i + 1], fm) / 2.0;
				curangle += Math.sin(adv / r);
			}
		}
	}

	// This method is for placing each character with specified size than together
	static int getWidth(char c, FontMetrics fm) {
		if (c == ' ' || Character.isSpaceChar(c)) {
			return fm.charWidth('n');
		} else {
			return fm.charWidth(c);
		}
	}

	public static void main(String args[]) {
		Task3 design = new Task3();// creating a new object from Task3 class and invoking the constructor with no
									// input
	}
}