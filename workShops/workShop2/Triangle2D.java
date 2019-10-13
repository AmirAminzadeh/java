//Student Name:  Amir Aminzadeh
//Student Number:  126554187
//Date: 2019-09-27


package com.senecacollege.workshop2.java;

//This class for the calculation
import java.awt.geom.Line2D;

public class Triangle2D extends MyPoint {
	
	

	private MyPoint p1;
	private MyPoint p2;
	private MyPoint p3;

	
	public Triangle2D(MyPoint p1, MyPoint p2, MyPoint p3) {
		this.setP1(p1);
		this.setP2(p2);
		this.setP3(p3);
	}

	
	//This constructor creates a default triangle with the points
	public Triangle2D() {
		this.setP1(new MyPoint(0, 0));
		this.setP2(new MyPoint(1, 1));
		this.setP3(new MyPoint(2, 5));
	}

	
	public MyPoint getP1() {
		return p1;
	}

	
	public void setP1(MyPoint p1) {
		this.p1 = p1;
	}

	
	public MyPoint getP2() {
		return p2;
	}

	
	public void setP2(MyPoint p2) {
		this.p2 = p2;
	}

	
	public MyPoint getP3() {
		return p3;
	}

	
	public void setP3(MyPoint p3) {
		this.p3 = p3;
	}
	

	// s = (side1 + side2 + side3)/2
	// area = square(s * (s - side1) * (s - side2) * (s - side3))
	public double getArea() {
		double area = 0;
		double side1 = distance(getP1());
		double side2 = distance(getP2());
		double side3 = distance(getP3());

		double s = (side1 + side2 + side3) / 2;
		area = Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));

		return area;
	}

	
	//This method is for showing the amount of Perimeter  
	public double getPerimeter() {
		double side1 = distance(getP1());
		double side2 = distance(getP2());
		double side3 = distance(getP3());

		return side1 + side2 + side3;
	}

	
	
	//This method returns true if the point of p is inside this triangle
	public boolean contains(MyPoint p) {

		MyPoint pA = this.p1;      //pA is px1, py1
	    MyPoint pB = this.p2;      //pB is px2, py2
	    MyPoint pC = this.p3;      //pC is px3, py3

	    //This Line2D (Class Line2D) represents a line segment in (x,y) coordinate space
	    //Line2D.double ==>  A line segment specified with double coordinates
	    Line2D.Double lineAB = new Line2D.Double(pA.getPx(), pA.getPy(), pB.getPx(), pB.getPy());
	    Line2D.Double lineBC = new Line2D.Double(pB.getPx(), pB.getPy(), pC.getPx(), pC.getPy());
	    Line2D.Double lineCA = new Line2D.Double(pC.getPx(), pC.getPy(), pA.getPx(), pA.getPy());

	    // For checking the new point with different aspects of the triangle. We want to create a virtual line with the previous points (pA, pB, pC)
	    Line2D.Double LinePA = new Line2D.Double(p.getPx(), p.getPy(), pA.getPx(), pA.getPy());
	    Line2D.Double LinePB = new Line2D.Double(p.getPx(), p.getPy(), pB.getPx(), pB.getPy());
	    Line2D.Double LinePC = new Line2D.Double(p.getPx(), p.getPy(), pC.getPx(), pC.getPy());
	    
	    
	    //public boolean intersectsLine(Line2D l){};
	    //Tests if the specified line segment intersects this line segment.
	    //true if this line segment and the specified line segment intersect each other; false otherwise.
	    boolean PAIntersects = LinePA.intersectsLine(lineAB) || LinePA.intersectsLine(lineBC) || LinePA.intersectsLine(lineCA);
	    boolean PBIntersects = LinePB.intersectsLine(lineAB) || LinePB.intersectsLine(lineBC) || LinePB.intersectsLine(lineCA);
	    boolean PCIntersects = LinePC.intersectsLine(lineAB) || LinePC.intersectsLine(lineBC) || LinePC.intersectsLine(lineCA);

	    //This statement checks that if there are at least two intersections then the point is outside
	    return !(PAIntersects || PBIntersects || PCIntersects); 
	   
	    
	}

	
	
	//returns true if the specified triangle is inside this triangle
	public boolean contains(Triangle2D t) {

		boolean p1Flag = contains(t.getP1());
		boolean p2Flag = contains(t.getP2());
		boolean p3Flag = contains(t.getP3());
		if (p1Flag && p2Flag && p3Flag)
			return true;
		else
			return false;

	}

	
	//returns true if the specified triangle overlaps with this triangle
	public boolean overlaps(Triangle2D t) {

		return this.contains(t);
	}

}
