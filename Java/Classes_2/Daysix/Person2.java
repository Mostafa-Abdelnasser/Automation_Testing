/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Daysix;

/**
 *
 * @author Mostafa
 */
public class Person2 {
    //gobla variables 
    String name;
    public int age ;
    String Nationality ; 
//final String Nationality = "Candada" (this is constant now) ; // if it done this way you can't assign any other value to the variable 
    private float height ;
    
    
    public void setheight(float height){
        
        this.height = height;
    
    
    }
    
    public void getheight(){
        
        System.out.println(this.height); 
    
    
    }
    
    
    //Over loading constructor 
    
    // defualt Constructor 
    public Person2(){
        System.out.println("Hello from constructor 1");
    
    }
    
    
    public Person2(String x){
        // this() : is chaining constructor when we want to use a the default construcor for intializing things
         this(); // wil run the defualt constructor first 
        System.out.println("Hello from constructor 2");
    
    }
    
    
    public Person2(String x , String y){
        // this() : is chaining constructor when we want to use a the default construcor for intializing things
         this("x"); // wil run second constructor
        System.out.println("Hello from constructor 3");
    
    }
    
    
    // functions == Methods 
    public void sleep(){
    
        System.out.println(name+" is sleeping (fromperson2)");
    }
    
    public void eat(){
    
        System.out.println(name+" is Eating");
    }
    
    
    
    
    
    public static void main(String[] args) {
        
        //        
//        // this need the type of age to be static 
//        age = 12;
//        System.out.println("this person age is "+age);
//        
        
        
        // creating an object from class person2 (to use the global variables in the main as they are not static) 
        Person2 obj = new Person2();
        obj.age = 12;
        obj.name = "ahmed";
        obj.Nationality ="Egyptian";
        System.out.println(obj.age);
        
        obj.sleep();
        
        //Creating second object 
        Person2 obj2 = new Person2("x"); // second constructor 
        obj2.age = 12;
        obj2.name = "Elol";
        obj2.Nationality = "American" ;
        System.out.println(obj2.name);
        obj2.sleep();
        
        // third object with nothing
        Person2 obj3 = new Person2("x","y");
        System.out.println("object 3"); // just for clarification in printing 
        System.out.println(obj3.name); // will print null as there is no intialization for the third object 
        // if name is static it would have the value of last intialization which is Elol
       
        // comparing the values in nationlity in obj1 and obj2 
        System.out.println(obj.Nationality);
        System.out.println(obj2.Nationality); // each value diplayed as each object has it's own memory
        //but 
         obj.Nationality ="Morocan";
         System.out.println(obj.Nationality); // the value will be over written as it's only got one place in memory
         
         // now let's jump to D6 to use another concepts we will try to access it put it won't as it's private
        
    }


}
