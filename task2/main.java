import java.util.*;
// import java.util.Scanner;


// public class table {
    
//     public static void main(String [] args){
//         Scanner sc = new Scanner(System.in);
//         System.out.print("enter any number:" );
//         int num= sc.nextInt();
//         sc.close();
//         for(int i=1;i<=10;i++){
//             System.out.println(num + " * " + i + " = " + (num*i) );
//         }
//     }
// }

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
