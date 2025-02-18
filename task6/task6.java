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
        System.out.println("ID: " + this.id +  "\n"+ "Name: "  + this.name + "\n" +"Department: " + this.department+ "\n"  +"Salary: $"  + this.salary + "\n");
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
        System.out.println(this.teamSize + "\n");
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
        System.out.println( "Recruitments Handled: " + requirementHandled + "\n");
    }

}

public class task6 {
    public static void displayEmpDetails(Employee e){
        e.displayDetails();
    }
    public static void main(String [] args){
        // Created emp objeict
        Employee emp= new Employee(101,"Alice",60000,"IT");
        // Created manager object
        Manager mgr= new Manager(102, "Bob", 80000, "IT", 5);
        //Created hr object
        Hr hr=new Hr(103, "Charlie", 70000, "Human Resources", 20);

        // calling display details for each object
        System.out.println("Employe Details:");
        displayEmpDetails(emp);
        System.out.println("Manager Details:");
        displayEmpDetails(mgr);
        System.out.println("Hr Details:");
        displayEmpDetails(hr);
    }
}
