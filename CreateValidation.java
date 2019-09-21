
package com.senecacollege.java;
import java.util.Scanner;


//It is a class for creating validation in credit cards
public class CreateValidation {

    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
		System.out.println("Enter a credit card number as a long integer: ");
		String creditNumberStr = input.nextLine();
        
		
                if(ValidLenght(creditNumberStr)) {
                    if(ValidStartDigit(creditNumberStr) != "Invalid"){
                    	System.out.println("Card is "+ValidStartDigit(creditNumberStr));
                        
                    	//Now, check the 4 conditions
                    	if(isValid(creditNumberStr)) {
                    		System.out.println("The Card number: "+creditNumberStr+" is valid");
                    	}else {
                    		System.out.println("The Card number: "+creditNumberStr+" is invalid");
                    	}
                    	
                    	
                    	
                    }else {
                        System.out.println("Invalid First digit of number!");
                    }
                }
                else
                {
                  System.out.println("Invalid length of Number!");
                }
                
                input.close();
                
    }
    
    
    
    	//This method validate the numbers of the input number
        public static boolean ValidLenght(String creditNumberStr)
        {
            if(creditNumberStr.length()>=13 && creditNumberStr.length()<=16) {
            	return true;
            }else { 
            	return false;
            }
        }
        
        
        
        //This method validate the start number of the input number for checking the kind of card
        public static String ValidStartDigit(String creditNumberStr)
        {
            if(creditNumberStr.startsWith("4")) return "Visa card";
            else if(creditNumberStr.startsWith("5")) return "Master card";
            else if(creditNumberStr.startsWith("37")) return "American Express card";
            else if(creditNumberStr.startsWith("6")) return "Discover card";
            else return "Invalid";
        }
        
	
        
        //Double every second digit from right to left. If doubling of a digit results in a 
        //two-digit number, add up the two digits to get a single-digit number
        public static int sumOfDoubleEvenPlace(String creditNumberStr) {
        	int result = 0;
                
			for(int i=creditNumberStr.length()-2;i>=0;i-=2){
				String StrDigit=creditNumberStr.substring(i, i+1);
                Long Digit=Long.parseLong(StrDigit);
                Digit=Digit*2;
                if(Digit<10) {
                	result+=Digit;
                }else {
                    Digit=1+(Digit-10);
                    result+=Digit;
                }
            }
			return result;
        }
        
        
        
        //all digits in the odd places from right to left in the card number
        public static int sumOfOddPlace(String creditNumberStr) {
        	int result = 0;
                
        	for(int i=creditNumberStr.length()-1;i>=0;i-=2){
                    Long Digit=Long.parseLong(creditNumberStr.substring(i, i+1));
                    result+=Digit;
            }
			return result;
        }
        
        
        
        //This method check the sum of the results from Step sumOfDoubleEvenPlace and Step sumOfOddPlace
        public static boolean isValid(String creditNumberStr)
        {
            int Sum=sumOfDoubleEvenPlace(creditNumberStr)+sumOfOddPlace(creditNumberStr);
            if((Sum % 10) == 0) {
            	return true;
            }else { 
            	return false;
            }
        }
    
}
