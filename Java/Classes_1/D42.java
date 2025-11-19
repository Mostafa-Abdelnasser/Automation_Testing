/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


//this was copied from day four for helping in the current class
package DayFive;
import java.util.Scanner;  // Import the Scanner class import come always after the package


/**
 *
 * @author Mostafa
 */
public class D42 {
    
    
    static int glob1 ;
    
    static void sum(int x,int y){
        int result = x+y ;
        System.out.println(result);
    
    
    }
    
    
    static int mlti(int x,int y){
        int result = x*y ;
        System.out.println(result);
    
        return result;
    }
    
    //same function but with different name (Overloading)
    static void sum(String x,int y){
        System.out.println(x+" "+y);
        
        
        
    
    }
    
    static void sum(int y,String x){
        System.out.println(y+" "+x);
        
        
        
    
    }
    public static void main(String[] args) {
        sum(8,6);
        mlti(6,6);
        sum("ahmed",8);
        sum(8,"ahmed");
        int glob1 = 20;
        System.out.println(D42.glob1);
        
        //making arrays
         
        String arr[] =  {"sdfasdfsdf","sdfas","23423d"};
        System.out.println(arr[0]);
        
        int arr2 [] = {1,4,5,63};
        System.out.println(arr2[0]);
        System.out.println(arr2.length);
        System.out.println(arr2[(arr2.length)-1]); // printed the last one not the one befor it as lenght function get the num of elements not index
      
        
        
//        // array with only specified values        
//        int x [] = new int [10] ;
//            x[0] = 1 ;
//            x[1] = 2 ;
//            x[2] = 3 ;
//            x[3] = 4 ;
//            for (int i = 0; i <= 9; i++) {
//            System.out.println(x[i]);
//              }
//            
            
            
//  making function that takes the input from a user and put them in the array 
//        
//        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
//        int x [] = new int [10] ;
//        System.out.println("Enter 10 numbers in the array"); 
//        // takibg the values from the user
//        for (int i = 0; i <= 9; i++) {
//            
//            x[i] = myObj.nextInt();
//        }
//        
//        System.out.println("you entered this values");
//        //printing the array
//        for (int i = 0; i <= 9; i++) {
//        System.out.print(x[i]);
//         System.out.print(" ");
//        
//    }
//        
//        
        
   // making a max and min functions     
 int arr6 [] = {1,2,3,4,5,0,-7,25,17,5,6} ;

int max = arr6[0] ;
int min = arr6[0];

for (int i = 0; i < (arr6.length) - 1; i++) {

            if (arr6[i] > max) {
                    max = arr6[i] ;
            }
            
            
            if(arr6[i]<min){
             min = arr6[i];
            
            }

}

        System.out.println("the max number of arr is " + max) ;
        System.out.println("the min number is"+min); 
    
    //using functions on by string class 
    String h ="Ahmed";
        System.out.println(h.concat(" omar"));
        System.out.println(h.charAt(0)); //it's working even if there is a red line uder the charat
    
    
}
    
}
