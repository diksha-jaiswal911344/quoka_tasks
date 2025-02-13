// **********Class & Object****************

Class:- Class is the blueprint of an object. It is used to create objects.

Object:- An object is an instance of the class.

For example:
//class

class Student{
    int roll_no;
    String name;
    
    void setNameAndRollno(String newName, int roll){
        name=newName;
        roll_no=roll;
    }
    
    String getName(){return name;}
    int getRoll(){return roll_no;}
    }
    
    public class main{
        public static void main(String [] args){
            Student sd = new Student(); // this is student object
            sd.setNameAndRollno("a",1);
            String namee= sd.getName();
            int getroll= sd.getRoll();
            System.out.println(namee + getroll);
        }
    }

*****************Constructor & Types*******************
Constructor:- Constructoris a special type of method that is used to initialize the object.
             Every time an object is created using the new() keyword, at least one constructor is called.
             It is having the same name as class.

Types:-
Default Constructor:-A constructor that has no parameters is known as default constructor. A default constructor is invisible.
                    It is being overloaded and called a parameterized constructor.The default constructor can be implicit or explicit.
                    Implicit Default Constructor:- If no constructor is defined in a class, the Java compiler automatically provides a default constructor. 
                    Explicit Default Constructor:- If we define a constructor that takes no parameters, it’s called an explicit default constructor.

Parameterized Constructor:-A constructor that has parameters is known as parameterized constructor. If we want to initialize fields of the class with our own values,
                         then use a parameterized constructor.

Copy Constructor:- Unlike other constructors copy constructor is passed with another object which copies the data available from the passed object to the newly created object.
                    There are two types of copy constructors, deep copy and shallow copy.
                    A shallow copy shares references with the original object, while a deep copy creates a new object that is independent of the original. 

***************************This Keyword****************************
'this' keyword:- ‘this’ is a reference variable that refers to the current object.It can be used to call current class methods and fields, to pass an instance 
                 of the current class as a parameter, and to differentiate between the local and instance variables. Using “this” reference can improve code readability 
                 and reduce naming conflicts.

***************************Access Modifiers (`public`, `private`, `protected`, `default`)*************

Access modifiers:- helps to restrict the scope of a class, constructor, variable, method, or data member

Types of Access Modifiers:-
There are 4 types of access modifiers available in Java: 
1.Default – No keyword required

//Example 
// default access modifier 
package p1; 

// Class code is having 
// Default access modifier 
class Code 
{ 
    void display() 
    { 
        System.out.println("Hello World!"); 
    } 
} 

2.Private:-The methods or data members declared as private are accessible only within
         the class in which they are declared.
3.Protected:- The methods or data members declared as protected are accessible within the same 
         package or subclasses in different packages.
4.Public:- The methods or data members declared as protected are accessible within the same package or 
         subclasses in different packages.

********************************Inheritance (`extends` keyword)************************
Inheritance:- In Inheritance, child class inherits the properties of parent class
The extends keyword extends a class, indicates that a class is inherited from another class.

********************************Method Overriding************************************
Method Overriding:- In method overriding the method in the child class must have the same signature as in the parent class. 
                    It allows the child class to modify the inherited methods.

*********************************Super keyword*****************************************           
Super keyword:- super keyword is used to refer to the parent class of a subclass.

*********************************Polymorphism****************************************
Polymorphism:- The word ‘polymorphism’ means ‘having many forms’. In Java, polymorphism refers to the ability of a message to be 
                 displayed in more than one form.

                It is of two types :-
    1.Compiletime Polymorphism:- is also known as static polymorphism. This type of polymorphism is achieved by function overloading or operator overloading.
                                Method overloading in Java means when there are multiple functions with the same name but different parameters then these functions are said to be overloaded. 
    2.Runtime Polymorphism:- After inheritence, when an object of a child class is created, then the method inside the child class is called. This is because the method in the parent class is
                             overridden by the child class. 

