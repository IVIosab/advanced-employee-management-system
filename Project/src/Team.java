import java.util.ArrayList;

/**
 * This is the Team class
 * It represents the Composite in out composite design pattern
 * it implements the component and has a list of CompanyUnits inside it
 */
public class Team implements CompanyUnit {
    protected String name;
    protected ArrayList<CompanyUnit> teams;
    protected ArrayList<Employee> users;

    Team(String name) {
        this.name = name;
        this.teams = new ArrayList<>();
        this.users = new ArrayList<>();

    }

    /**
     * This method is an example of how the composite pattern is useful in this project where we need something from a whole group of people and this method handles it on its own
     *
     * @return the combined salary of the whole team
     */
    public double getSalary() {
        int salary = 0;
        for (int i = 0; i < teams.size(); i++) {
            CompanyUnit ithTeam = teams.get(i);
            salary += ithTeam.getSalary();
        }
        for (int i = 0; i < users.size(); i++) {
            Employee ithUser = users.get(i);
            salary += ithUser.getSalary();
        }
        return salary;
    }

    /**
     * This method is an example of how the Chain of responsibility patter useful in this project
     * it is used to show information about the team and if that team consists of multiple teams it
     * delegates the work to that team
     * in the end you will be shown all information about that team and what it consists of
     */
    public void showHelp() {
        System.out.println("This is the " + name + " team");
        if (teams.size() != 0) {
            System.out.println("It consists of the following teams:");
            for (int i = 0; i < teams.size(); i++) {
                System.out.println((i + 1) + ":");
                teams.get(i).showHelp();
                System.out.println();
            }

        }
        if (users.size() != 0) {
            System.out.println("and it consists of the following employees:");
            for (int i = 0; i < users.size(); i++) {
                System.out.println((i + 1) + "-" + users.get(i).getName());
            }
        }
    }

    /**
     * @return the name of the team
     */
    public String getName() {
        return this.name;
    }

    /**
     * this method adds a team to the Teams Database
     *
     * @param companyUnit
     */
    public void addTeam(CompanyUnit companyUnit) {
        this.teams.add(companyUnit);
    }

    /**
     * this method removes a team from the Teams Database
     *
     * @param companyUnit
     */
    public void removeTeam(CompanyUnit companyUnit) {
        this.teams.remove(companyUnit);
    }

    /**
     * this method adds and employee to the employee database
     *
     * @param employee
     */
    public void addUser(Employee employee) {
        this.users.add(employee);
    }

    /**
     * this method removes an employee from the employee database
     *
     * @param employee
     */
    public void removeUser(Employee employee) {
        this.users.remove(employee);
    }
}
