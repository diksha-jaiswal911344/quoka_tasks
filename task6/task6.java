class Employee {
    int id;
    String name;
    private long salary;
    String department;
    String role;
   
    public void setSal(long salary){
        this.salary=salary;
    }

    public long getSal(){
        return salary;
    }

    Employee(int id, String name,long salary, String department){
        this.id=id;
        this.name=name;
        this.salary=salary;
        this.department=department;
    }
    
    void displayDetails(){
        System.out.println("ID: " + this.id +  "\n"+ "Name: "  + this.name + "\n" +"Department: " + this.department+ "\n"  +"Salary: $"  + this.salary );
    }
}

class Manager extends Employee{
    int teamSize;

    Manager(int id, String name,long salary, String department, int teamSize){
        super(id,name,salary,department);
        this.teamSize=teamSize;
    }
    @Override
    void displayDetails(){
        super.displayDetails();
        System.out.println("Team Size :"+ this.teamSize);
    }
}

class Hr extends Employee{
    int requirementHandled;

    Hr(int id, String name,long salary, String department, int requirementHandled){
        super(id, name, salary, department);
        this.requirementHandled=requirementHandled;
    }

    void displayDetails(){
        super.displayDetails();
        System.out.println( "Recruitments Handled: " + requirementHandled );
    }

}

public class task6 {
    
    public static void main(String [] args){
        // Created emp objeict
        Employee emp= new Employee(101,"Alice",60000,"IT");
        // Created manager object
        Manager mgr= new Manager(102, "Bob", 80000, "IT", 5);
        //Created hr object
        Hr hr=new Hr(103, "Charlie", 70000, "Human Resources", 20);

        // calling display details for each object
        System.out.println("Employe Details:");
        emp.displayDetails();
        System.out.print("\n");
        System.out.println("Manager Details:");
        mgr.displayDetails();
        System.out.print("\n");
        System.out.println("Hr Details:");
        hr.displayDetails();
        System.out.print("\n");
    }
}
