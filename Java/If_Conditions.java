/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
// importing 





package Daytwo;
import java.util.Scanner;  // Import the Scanner class import come always after the package

/**
 *
 * @author Mostafa
 */
public class Daytwo {
    
    
    
    
    
    public static void main(String[] args) {
        
        
        
//        
//        // making a code to differentiate between even and odd code
//        
//        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
//        System.out.println("Enter number");
//        int x = myObj.nextInt();  // Read user input
//        if (x%2 ==0){
//        
//        
//            System.out.println(x+" is even number");
//        }
//        
//        else{
//        
//        
//            System.out.println(x+" is not even");
//       
//        }
        
        
        
        // creating grading system
        //100-90A,89-80B,79-70C,69-60D,<60F dont accept numbers above 100 or below 0
        
        int y =40;
        if (y>100 || y<0){
        
            System.out.println("Please enter a valid grade");
        
        
        }
        
        else{
            
             if (y>=90){
        
            System.out.println("your grade is A");
        
             }
             
             else if (y>=80){
        
            System.out.println("your grade is B");
        
             }
             
             else if (y>=70){
        
            System.out.println("your grade is C");
        
             }
             
             else if (y>=60){
        
            System.out.println("your grade is D");
        
             }
             
             
             
             else{
                 System.out.println("your grade is F");
              
             }
        
        }
             
             
        
        
        
        
    }
    
    
    
}
