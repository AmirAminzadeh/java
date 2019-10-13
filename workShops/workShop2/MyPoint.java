//Student Name:  Amir Aminzadeh
//Student Number:  126554187
//Date: 2019-09-27

package com.senecacollege.workshop2.java;


//This class is for representing a point with x and y coordinates
public class MyPoint {
	
	private double px;
	private double py;
	
	
	//The constructor for creating a point
	public MyPoint() {
		//this.px = 0;
		this.setPx(0);
		this.setPy(0);
	}
	
	// This constructor for creating a point with x and y coordinates
	public MyPoint(double px, double py) {
		this.setPx(px);
		this.setPy(py);
	}
	
	
	// The distance from this point to another point for a specified point with MyPoint type
	public double distance(MyPoint point) {
		return distance(point.getPx(), point.getPy());
	}
	
	
	//The distance from this point to another point with x and y coordinates
	public double distance(double px, double py) {
		//The formula of distance
		//d(P, Q) = √ (x2 − x1)2 + (y2 − y1)2
		
		return Math.sqrt(Math.pow(px - this.getPx(), 2) + Math.pow(py - this.getPy(), 2));
		
	}


	
	public double getPy() {
		return py;
	}


	
	private void setPy(double py) {
		this.py = py;
	}


	
	public double getPx() {
		return px;
	}


	
	private void setPx(double px) {
		this.px = px;
	}
	
	

	

}
