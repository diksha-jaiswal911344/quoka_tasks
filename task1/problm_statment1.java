public class problm_statment1 {
    public static void main(String[] args) {
        // declared and initialized variables
        double baseSal = 45000.0;
        double allowance = 7000.0;

        // calculated Gross Salary
        double grossSal = baseSal + allowance;

        // determine tax rate using a mathematical expression and ternary operator
        double taxRate = (grossSal > 50000) ? 0.10 : 0.0;

        // calculated tax amount
        double taxAmount = grossSal * taxRate;

        // calculated Net Salary
        double netSal = grossSal - taxAmount;

        // displayed results using string concatenation
        System.out.println("Base Salary: " + baseSal);
        System.out.println("Allowance: " + allowance);
        System.out.println("Gross Salary: " + grossSal);
        System.out.println("Tax Applied: " + taxAmount);
        System.out.println("Net Salary: " + netSal);
    }
}
