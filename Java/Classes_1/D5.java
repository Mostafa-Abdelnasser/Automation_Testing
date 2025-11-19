/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

// this class take from other classes like D42 and person 
package DayFive;
    
/**
 *
 * @author Mostafa
 */
public class D5 {
    
    // this whrere we inherit from other classes
    public static void main(String[] args) {
        //why objects (Less lines of codes ,most effecinecy ,less in maintainance)
        //using an object to access functions in other class
        D42 obj = new D42();
        obj.sum(3,1);
        
        //using person class 
        Person p = new Person();
        p.name = "Ali";  // directly accessing the field in person and setting  the value
        p.sleep(10, 40, 50); // prints null as the name is defined in the other class not here 
       
        
        
    }
    
}
