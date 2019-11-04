/*
Student Name: Amir Aminzadeh
Student Number: 126554187
Date: 2019-10-26
*/

package com.senecacollege.task1.java;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Task1 extends JPanel {// JPanel is a generic lightweight container

	private List<Point> fillCells;// Defining a list that named fillCells

	public Task1() {// This constructor will create a new list with 8 ArrayList for the number of
					// squares in each row
		fillCells = new ArrayList<>(8);
	}

	// This method is needed to draw something on JPanel other than drawing the
	// background color.
	// This method already exists in a JPanel class so that we need to use the super
	// declaration
	// to add something to this method and takes Graphics objects as parameters
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);// The super.paintComponent() which represents the normal the paintComponent()
								// method of the JPanel which can only handle the background of the panel
		for (Point fillCell : fillCells) {// for loop is useful when you want to iterate Array
			int cellX = 40 + (fillCell.x * 40);// for setting the start point of the black color on x axis
			int cellY = 40 + (fillCell.y * 40);// for setting the start point of the black color on y axis
			g.setColor(Color.BLACK);// Sets this graphics context's current color to the specified color
			g.fillRect(cellX, cellY, 40, 40);// Fills the specified rectangle ==> void java.awt.Graphics.fillRect
												// (int x,int y, int width, int height)
		}
		g.setColor(Color.BLACK);// Sets this graphics context's current color to the specifiedcolor
								// ==> void java.awt.Graphics.setColor(Color c)
		g.drawRect(40, 40, 320, 320);// Draws the outline of the specified rectangle
										// ==> void java.awt.Graphics.drawRect(int x, int y, int width, int height)
		for (int i = 40; i <= 320; i += 40) {// This for loop for drawing the lines on x axis
			g.drawLine(i, 40, i, 360);// Draws a line, using the current color, between the points (x1, y1)and(x2,y2)
										// ==> void java.awt.Graphics.drawLine(int x1, int y1, int x2, int y2)
		}

		for (int i = 40; i <= 320; i += 40) {// This for loop for drawing the lines on y axis
			g.drawLine(40, i, 360, i);
		}
	}

	public void fillCell(int x, int y) {// This function for adding the new point to the fillCells and repaint the
										// colors
		fillCells.add(new Point(x, y)); // Appends the specified element to the end of this list
		repaint();// Repaints this component
	}

	public static void main(String[] a) {
		// EventQueue.invokeLater comes into play. It posts an event (your Runnable) at
		// the end of Swings
		// event list and is processed after all previous GUI events are processed
		EventQueue.invokeLater(new Runnable() { // Causes runnable to have its run method
												// void java.awt.EventQueue.invokeLater(Runnable runnable)
			public void run() {
				try {
					// The look and feel can be specified in two distinct ways: by specifying the
					// fully
					// qualified name of the class for the look and feel, or by creating an instance
					// of
					// LookAndFeel and passing it to setLookAndFeel
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
						| UnsupportedLookAndFeelException ex) {
				}

				Task1 grid = new Task1();// creating a new object from Task1 that named grid for executing the
											// constructor
				JFrame window = new JFrame("Chess Board");// creating the new object from JFrame that named window
				window.setSize(420, 420);// This is the size of my frame
				window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// To Close
				window.add(grid);// Invoking the add method
				window.setVisible(true);// The setVisible() method in Java makes the GUI component visible to the
										// user depending on the Boolean parameter you pass in the function

				for (int i = 0; i < 8; i++) {// This for loop is for placing the color into squares
					for (int m = 0, j = 2; m < 4; m++, j = j + 2)
						if (i % 2 == 0) {
							grid.fillCell(j - 1, i);
						} else {
							grid.fillCell(j - 2, i);
						}
				}
			}
		});
	}
}
