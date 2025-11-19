/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DayFive;






/**
 *
 * @author Mostafa
 */
public class Person {
    
    
    
String name ;
int age;
static String Nationality ;


public Person (){

    System.out.println("Hello team ");
} // this will run the function each time i construct an object 


//// constructor overloading 
//public Person (String x, int y , String z ){
// name = x  ;
// age = y ;
// Nationality = z  ;
// 
//} // this will run the function each time i construct an object 

// constructor overloading 
/**
 * Constructs a new Person object.
 * @param name The name of the person.
 * @param age The age of the person.
 * @param Nationality The nationality of the person.
 */
public Person (String name, int age , String Nationality ){
 this.name = name  ;
 this.age = age ;
 this.Nationality = Nationality  ;
 
} // this will run the function each time i construct an obje


public void sleep (int hour , int minute , int sec) {

  System.out.println(name + " is sleeping at "+hour+":"+minute+":"+sec);
    
}

//Overloading using the same function but with different argument
    public void sleep() {

System.out.println("Person is sleeping at 7:00") ;

}

public void eating() {

System.out.println("Person is eating meat") ;

}


public static void main(String[] args) {
// making obj    
Person obj = new Person();
//assigning values to globla variables in the same class 
obj.name = "Ahmed" ;
obj.age = 18 ;
obj.Nationality = "canadian" ;
// calling function at the same class by object (as it's not static)
obj.sleep();

System.out.println(obj.name);
System.out.println(obj.age);
System.out.println(obj.Nationality);

obj.sleep(10,40,30);


// making obj 2   & will use the constructor overlaoding will not use the folloing assignment  
Person obj2 = new Person("Ahmed",25,"Morocan");
//obj2.name = "ALi" ;
//obj2.age = 20 ;
//obj2.Nationality = "Egyptian" ;

System.out.println(obj2.name);
System.out.println(obj2.age);
System.out.println(obj2.Nationality);

obj2.sleep(10,50,20);
// object 3
Person obj3 = new Person();

// object 4
Person obj4 = new Person();

// but what if 

    obj.Nationality = "canadian" ;
    obj2.Nationality = "Egyptian" ;
    obj3.Nationality = "saudi" ;  // if changed nationality to static it will diaplay saudi in all  of them 
    // that means it will take the last value saved as it's shared 
    System.out.println(obj.Nationality);
    System.out.println(obj2.Nationality);
    System.out.println(obj3.Nationality);
    System.out.println(obj4.Nationality); // even the object with no nationality setting took saudi 
    
    
//    // thaking object from string class  just to prove that String is variable and a class 
//    String y = new String();
//    y.

}





    
}
