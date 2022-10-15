public class Employee {

    private String name;
    private double salary;
    private int workHours;
    private int hireYear;
    private double taxAmount = 0;
    private double bonusAmount = 0;
    private double raiseAmount = 0;

    public Employee(String name, double salary, int workHours, int hireYear) {
        this.name = name;
        this.salary = salary;
        this.workHours = workHours;
        this.hireYear = hireYear;
        tax();
        bonus();

        try {
            raiseSalary();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getWorkHours() {
        return workHours;
    }

    public void setWorkHours(int workHours) {
        this.workHours = workHours;
    }

    public int getHireYear() {
        return hireYear;
    }

    public void setHireYear(int hireYear) {
        this.hireYear = hireYear;
    }

    public void tax() {
        if (getSalary() > 1000) {
            this.taxAmount = getSalary() * 0.03;
        }
    }

    public void bonus() {
        if (getWorkHours() > 40) {
            this.bonusAmount = (getWorkHours() - 40) * 30;
        }
    }

    public void raiseSalary() throws Exception {
        int currentYear = 2021;
        int yearsOfExprerience = currentYear - getHireYear();

        if (yearsOfExprerience < 0)
            throw new Exception("Years of experience cannot be negative.");

        double newSalary = 0;

        if (yearsOfExprerience > 19) {
            this.raiseAmount = getSalary() * 0.15;
        } else if (yearsOfExprerience > 9 && yearsOfExprerience < 20) {
            this.raiseAmount = getSalary() * 0.1;
        } else if (yearsOfExprerience < 10) {
            this.raiseAmount = getSalary() * 0.05;
        }

        newSalary = getSalary() + this.raiseAmount + this.bonusAmount - this.taxAmount;
        setSalary(newSalary);
    }

    @Override
    public String toString() {
        return "Name: " + getName() +
                "\nSalary: " + getSalary() +
                "\nTax: " + this.taxAmount +
                "\nBonus: " + this.bonusAmount +
                "\nRaise: " + this.raiseAmount +
                "\nWork Hours: " + getWorkHours() + " hours (" + (getWorkHours() - 40) + " hours more)" +
                "\nHire Year: " + getHireYear() + " (Working for " + (2021 - getHireYear()) + " years)";
    }
}