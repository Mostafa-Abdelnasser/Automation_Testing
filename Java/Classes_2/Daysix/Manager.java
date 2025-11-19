/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Daysix;

/**
 *
 * @author Mostafa
 */

// this class extneds from person 2
public class Manager extends Person2  { //extends (class name ) this is inheritance 
    
    String name = "Ahemd" ;
    
    
    // functions == Methods 
    
    // This will override the real function in the real class in case of  polymorphism and makeing object for the child
    @Override
    public void sleep(){
    
        System.out.println("Sleeping from manager");
    }
    
    
    
    
    // creating a method (function)
    
    
    
    public static void main(String[] args) {
        
        //make an object to access the variable in person 2 as they are not static as the main fucnction 
        Person2 obj = new Manager(); // this polymorphism using the instances (fields) and Methods both of Person2  Manager (make override if needed)
        System.out.println(obj.name); // name has no value in person 2 class 
        obj.sleep();
        
        
        //Another way to run this part of code 
        Manager obj2 = new Manager(); // will always run the defualt constructo of the parent 
        System.out.println(obj2.name); // Will print the name ahemd as it's using it's own methods and fields if threre is no name it will print null as parent
        obj2.sleep();
        // Now let's return to D62
        
        
        // okay now to access variable which is heigt in person2 
        // we will use setters and getters as it's private (there is a functions for the setter and getters in person2)
        obj2.setheight(20);
        obj2.getheight();
        
        //Now let's make abstract class 
        
    }
    
    
}
