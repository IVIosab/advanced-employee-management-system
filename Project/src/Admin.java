import java.util.ArrayList;

/**
 * This is the Admin Class
 * It extends the class Employee
 * It has all the actions that only the admin can execute
 */
public class Admin extends Employee {
    protected int id;
    protected double salary;

    Admin(String username, String password, int age, String firstName, String surName, double salary) {
        this.username = username;
        this.password = password;
        this.age = age;
        this.firstName = firstName;
        this.surName = surName;
        this.id = makeID();
        this.salary = salary;
    }

    /**
     * this method shows the list of actions the Admin can do
     */
    public void showHelp() {
        System.out.println("You are an Admin, you can:\n1)Change Company Name.\n2)Change Company Revenue.\n3)Change User salary.\n4)Change User leave status.\n5)Add User.\n6)Get Team salary.\n7)Get Team info.\n8)Logout");
        System.out.println("Please enter the number of the Action: ");
    }

    /**
     * @return first name of the Admin
     */
    public String getName() {
        return firstName;
    }

    /**
     * @return The salary of the Admin
     */
    public double getSalary() {
        return salary;
    }

    /**
     * This method changes the leave status of an employee
     *
     * @param company
     * @param id
     */
    void changeLeaveStatus(Company company, Integer id) {
        company.dbConnection.getUsers().get(id).leaveStatus = !company.dbConnection.getUsers().get(id).leaveStatus;
    }

    /**
     * This method changes the salary for an employee
     *
     * @param company
     * @param id
     * @param newSalary
     */
    void changeSalary(Company company, Integer id, double newSalary) {
        company.dbConnection.getUsers().get(id).salary = newSalary;
    }

    /**
     * This method allows the Admin to add a new User to the company
     *
     * @param company
     * @param eUsername
     * @param ePassword
     * @param eAge
     * @param eFirstName
     * @param eSurName
     * @param eSalary
     * @param eLeaveStatus
     */
    void addUser(Company company, String eUsername, String ePassword, int eAge, String eFirstName, String eSurName, double eSalary, Boolean eLeaveStatus) {
        User newUser = new User(eUsername, ePassword, eAge, eFirstName, eSurName, eSalary, eLeaveStatus);
        company.dbConnection.addUser(newUser);
    }

    /**
     * This method allows the Admin to add a new Team to the company
     *
     * @param company
     * @param tName
     */
    void addTeam(Company company, String tName) {
        Team newTeam = new Team(tName);
        company.dbConnection.addTeam(newTeam);
    }

    /**
     * This method allows the Admin to change the company name
     *
     * @param company
     * @param newName
     */
    public void setCompanyName(Company company, String newName) {
        company.dbConnection.setCompanyName(newName);
    }

    /**
     * This method allows the Admin to change the company revenue
     *
     * @param company
     * @param newRevenue
     */
    public void setCompanyRevenue(Company company, int newRevenue) {
        company.dbConnection.setCompanyRevenue(newRevenue);
    }

    /**
     * This method allows the Admin to add a company holiday
     *
     * @param company
     * @param holiday
     */
    public void addCompanyHoliday(Company company, String holiday) {
        company.addCompanyHoliday(holiday);
    }

}