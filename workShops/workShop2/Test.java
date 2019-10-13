//Student Name:  Amir Aminzadeh
//Student Number:  126554187
//Date: 2019-09-27


package com.senecacollege.workshop2.java;


//This class for representing decimal for a double number
import java.text.DecimalFormat;

public class Test {

	public static void main(String[] args) {
		
		
		
		DecimalFormat df = new DecimalFormat("0.00");
		
		
		//This is t1 object with Triangle2D type
		Triangle2D t1 = new Triangle2D(new MyPoint(2.5, 2), new MyPoint(4.2, 3), new MyPoint(5, 3.5));
		System.out.println("For t1 object, area is : " + df.format(t1.getArea()) );
		System.out.println("For t1 object, perimeter is : " + df.format(t1.getPerimeter()));
		
		
		
		
		//Checking the t1 for being inside or outside the triangle
		boolean result = t1.contains(new MyPoint(3 ,3));
		if(result == true) {
			System.out.println("The point is inside the triangle");
			
		}else{
			System.out.println("The point is not inside the triangle");
		}
		
		
		
		
		//Checking the t1 as a triangle for being inside or outside the another triangle
		result = t1.contains(new Triangle2D(new MyPoint(2.9, 2), new MyPoint(4, 1), new MyPoint(1, 3.4)));
		if(result == true) {
			System.out.println("The triangle is inside.");
			
		}else{
			System.out.println("The triangle is not inside");
		}
		
		//Checking the t1 base on overlapping
		result = t1.overlaps(new Triangle2D(new MyPoint(2, 5.5), new MyPoint(4, -3), new MyPoint(2, 6.5)));
		if(result == false) {
			System.out.println("The triangle is overlaps.");
			
		}else{
			System.out.println("The triangle is not overlaps");
		}
		
		////////////////////////////////////////////////////////////////////////////////////////////////
		System.out.println("===================================");
		////////////////////////////////////////////////////////////////////////////////////////////////
		
		//This is t2 object with Triangle2D type
		Triangle2D t2 = new Triangle2D(new MyPoint(0, 0), new MyPoint(0, 2), new MyPoint(2, 0));
		System.out.println("For t2 object, area is : " + t2.getArea());
		System.out.println("For t2 object, perimeter is : " + t2.getPerimeter());
		
		
		
		result = t2.contains(new MyPoint(1 ,1));
		if(result == true) {
			System.out.println("The point is inside the triangle");
			
		}else{
			System.out.println("The point is not inside the triangle");
		}
		
		
		
		
		result = t2.contains(new Triangle2D(new MyPoint(4, 5), new MyPoint(10.5, 3.2), new MyPoint(-0.5, -10.5)));
		if(result == true) {
			System.out.println("The triangle is inside.");
			
		}else{
			System.out.println("The triangle is not inside");
		}
		
		result = t2.overlaps(new Triangle2D(new MyPoint(1, 1.7), new MyPoint(-1, 1.7), new MyPoint(0, -3)));
		if(result == false) {
			System.out.println("The triangle is overlaps.");
			
		}else{
			System.out.println("The triangle is not overlaps");
		}
		
		
	}

}
