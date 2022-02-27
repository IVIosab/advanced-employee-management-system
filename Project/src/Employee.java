/**
 * This is the Employee Class
 * It represents all employees in the company whether it is an Admin or a User
 */
class Employee implements CompanyUnit {
    protected int age;
    protected String username, password, firstName, surName;
    private static int cnt = 0;

    Employee() {
    }

    Employee(String username, String password, int age, String firstName, String surName) {
        this.username = username;
        this.password = password;
        this.age = age;
        this.firstName = firstName;
        this.surName = surName;
    }

    /**
     * this method helps with keeping track of the employees in the database by assigning one unique id to each employee
     *
     * @return a unique ID
     */
    public int makeID() {
        return cnt++;
    }

    public String getName() {
        return "";
    }

    public double getSalary() {
        return 0;
    }

    public void showHelp() {
        System.out.println("You are an Employee");
    }
}