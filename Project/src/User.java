import java.util.ArrayList;

/**
 * This is the User class
 * It extends the Employee class
 * It has all the actions the user can perform
 */
public class User extends Employee {
    protected int id;
    protected double salary;
    protected boolean leaveStatus;

    User(String username, String password, int age, String firstName, String surName, double salary, Boolean leaveStatus) {
        this.username = username;
        this.password = password;
        this.age = age;
        this.firstName = firstName;
        this.surName = surName;
        this.salary = salary;
        this.leaveStatus = leaveStatus;
        this.id = makeID();
    }

    /**
     * @return the leave status of the user
     */
    boolean checkLeaveStatus() {
        return leaveStatus;
    }

    /**
     * @return the salary of the user
     */
    public double getSalary() {
        return salary;
    }

    /**
     * @return the first name of the user
     */
    public String getName() {
        return firstName;
    }

    /**
     * This method shows the list of actions the user can do
     */
    public void showHelp() {
        System.out.println("You are a User, you can:\n1)Check leave status.\n2)View salary.\n3)View yearly holidays.\n4)Voice Grievance.\n5)Resign.\n6)Logout");
        System.out.println("Please enter the number of the Action: ");
    }

    /**
     * @param company
     * @return list of company holidays
     */
    ArrayList<String> checkHoliday(Company company) {
        return company.getCompanyHolidays();
    }

    /**
     * This method allows the user to file a complaint which will be added the company grievances list
     *
     * @param company
     * @param report
     */
    void voiceGrievance(Company company, String report) {
        company.addCompanyGrievances(report);
    }

    /**
     * This method allows the user to resign from the company
     *
     * @param company
     * @param id
     */
    void resign(Company company, int id) {
        company.dbConnection.getUsers().remove(id);
    }

}