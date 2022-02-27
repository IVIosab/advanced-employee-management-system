import java.util.Scanner;

/**
 * This Class showcases an example of how to use the application.
 */
public class ManagementSystem {
    public void Application() {
        /**
         * This a mock build of the databases.
         * Note : keep in mind most of the code written below is only for convenience and in a real project most of the stuff written below will not be present due to the security risks. And everything will be handled through other classes to not face any security breaches or bugs
         */
        Company company = new Company();
        Admin admin = new Admin("Ping", "1234", 56, "Michael", "Scott", 99999);
        company.dbConnection.addAdmin(admin);
        admin.setCompanyName(company, "Dunder Mifflin");
        admin.setCompanyRevenue(company, 14600000);
        admin.addCompanyHoliday(company, "Christmas");
        admin.addCompanyHoliday(company, "Halloween");
        admin.addUser(company, "D-Money", "000000", 51, "Dwight", "Schrute", 50000, false);
        admin.addUser(company, "Jimbo", "i_love_pam", 42, "Jim", "Halpert", 60000, false);
        admin.addUser(company, "pam-pam!", "i_love_jim", 42, "Pam", "Beesly", 40000, false);
        admin.addUser(company, "C-Span", "gay_and_proud", 48, "Oscar", "Martinez", 49000, false);
        admin.addUser(company, "Stan", "toaster", 70, "Stanly", "Hudson", 55000, false);
        admin.addUser(company, "Kev", "i_love_food", 53, "Kevin", "Malone", 42000, false);
        admin.addUser(company, "KitchenWitch", "sprinkles", 46, "Angela", "Martin", 40000, false);
        admin.addUser(company, "Regis", "basketball", 49, "Darryl", "Philbin", 35000, false);
        admin.addUser(company, "SerialKiller", "drugs", 95, "Creed", "Bratton", 100000, false);
        admin.addTeam(company, "Developing");
        admin.addTeam(company, "Design");
        admin.addTeam(company, "HR");
        company.dbConnection.getTeam("HR").addUser(company.dbConnection.getUser(4));
        company.dbConnection.getTeam("HR").addUser(company.dbConnection.getUser(7));
        admin.addTeam(company, "Management");
        admin.addTeam(company, "BackEnd");
        company.dbConnection.getTeam("BackEnd").addUser(company.dbConnection.getUser(1));
        admin.addTeam(company, "FrontEnd");
        company.dbConnection.getTeam("FrontEnd").addUser(company.dbConnection.getUser(2));
        admin.addTeam(company, "UX");
        company.dbConnection.getTeam("UX").addUser(company.dbConnection.getUser(6));
        admin.addTeam(company, "UI");
        company.dbConnection.getTeam("UI").addUser(company.dbConnection.getUser(3));
        admin.addTeam(company, "General");
        company.dbConnection.getTeam("General").addUser(company.dbConnection.getUser(9));
        admin.addTeam(company, "Marketing");
        company.dbConnection.getTeam("Marketing").addUser(company.dbConnection.getUser(8));
        admin.addTeam(company, "Financial");
        company.dbConnection.getTeam("Financial").addUser(company.dbConnection.getUser(5));
        company.dbConnection.getTeam("Developing").addTeam(company.dbConnection.getTeam("BackEnd"));
        company.dbConnection.getTeam("Developing").addTeam(company.dbConnection.getTeam("FrontEnd"));
        company.dbConnection.getTeam("Design").addTeam(company.dbConnection.getTeam("UX"));
        company.dbConnection.getTeam("Design").addTeam(company.dbConnection.getTeam("UI"));
        company.dbConnection.getTeam("Management").addTeam(company.dbConnection.getTeam("General"));
        company.dbConnection.getTeam("Management").addTeam(company.dbConnection.getTeam("Marketing"));
        company.dbConnection.getTeam("Management").addTeam(company.dbConnection.getTeam("Financial"));

        /**
         * printing the data bases to help the user pick the employee he wants to log in with and what actions he wants to perform.
         */
        //Admin database
        System.out.println("Admins:");
        for (int key : company.dbConnection.getAdmins().keySet()) {
            System.out.println("ID : " + key + " | " + "Value : {" + company.dbConnection.getAdmins().get(key).username + "," + company.dbConnection.getAdmins().get(key).password + "," + company.dbConnection.getAdmins().get(key).age + "," + company.dbConnection.getAdmins().get(key).firstName + "," + company.dbConnection.getAdmins().get(key).surName + "}");
        }

        //User database
        System.out.println("Users:");
        for (int key : company.dbConnection.getUsers().keySet()) {
            System.out.println("ID : " + key + " | " + "Value : {" + company.dbConnection.getUsers().get(key).username + "," + company.dbConnection.getUsers().get(key).password + "," + company.dbConnection.getUsers().get(key).age + "," + company.dbConnection.getUsers().get(key).firstName + "," + company.dbConnection.getUsers().get(key).surName + "," + company.dbConnection.getUsers().get(key).getSalary() + "}");
        }

        //Team database
        System.out.println("Teams:");
        for (String key : company.dbConnection.getTeams().keySet()) {
            System.out.print("ID : " + key + " | " + "Value : {" + company.dbConnection.getTeam(key).name + ", [");
            for (int i = 0; i < company.dbConnection.getTeam(key).users.size(); i++) {
                System.out.print(company.dbConnection.getTeam(key).users.get(i).firstName + " " + company.dbConnection.getTeam(key).users.get(i).surName);
                if (i != company.dbConnection.getTeam(key).users.size() - 1) {
                    System.out.print(",");
                }
            }
            System.out.println("] ," + company.dbConnection.getTeam(key).getSalary() + "}");
        }

        /**
         * Console application to show the functionality of the project.
         * an employee logs in and based on the existing data base and then perform the action he wants to do.
         */
        while (true) {
            /**
             * first we see if the employee is an admin or a user
             */
            System.out.println("Specify if you are an Admin or User, or type exit to end terminate the program:");
            Scanner sc = new Scanner(System.in);
            String type = sc.nextLine();
            type = type.toLowerCase();
            DatabaseConnection dbConnection = DatabaseConnection.getDB();
            if (type.equals("admin")) {
                /**
                 * we let the admin log in using his unique ID and his password
                 */
                System.out.println("Enter ID :");
                String idString = sc.nextLine();
                Integer id = Integer.parseInt(idString);
                System.out.println("Enter Paasword :");
                String password = sc.nextLine();
                Admin user = dbConnection.getAdmin(id);
                if (user == null) {
                    System.out.println("The ID is incorrect");
                    return;
                } else if (!user.password.equals(password)) {
                    System.out.println("The Password is incorrect");
                    return;
                }
                while (true) {
                    /**
                     * we show the actions that can be performed and let the Admin do what he wants
                     */
                    user.showHelp();
                    String actionString = sc.nextLine();
                    Integer action = Integer.parseInt(actionString);
                    if (action.equals(1)) {
                        System.out.println("Enter new Company name");
                        String newName = sc.nextLine();
                        user.setCompanyName(company, newName);
                    } else if (action.equals(2)) {
                        System.out.println("Enter new Company revenue");
                        String newRevenue = sc.nextLine();
                        user.setCompanyRevenue(company, Integer.parseInt(newRevenue));
                    } else if (action.equals(3)) {
                        System.out.println("Enter the user's ID");
                        String ID = sc.nextLine();
                        System.out.println("Enter the new salary");
                        String newSalary = sc.nextLine();
                        user.changeSalary(company, Integer.parseInt(ID), Double.parseDouble(newSalary));
                    } else if (action.equals(4)) {
                        System.out.println("Enter the user's ID");
                        String ID = sc.nextLine();
                        user.changeLeaveStatus(company, Integer.parseInt(ID));
                    } else if (action.equals(5)) {
                        System.out.println("Enter the user's username");
                        String username = sc.nextLine();
                        System.out.println("Enter the user's password");
                        String pass = sc.nextLine();
                        System.out.println("Enter the user's age");
                        String age = sc.nextLine();
                        System.out.println("Enter the user's first name");
                        String firstName = sc.nextLine();
                        System.out.println("Enter the user's surname");
                        String surName = sc.nextLine();
                        System.out.println("Enter the user's salary");
                        String salary = sc.nextLine();
                        System.out.println("Enter the user's leave status (1 for On leave, 0 for Not on leave)");
                        String leaveStatus = sc.nextLine();
                        user.addUser(company, username, pass, Integer.parseInt(age), firstName, surName, Double.parseDouble(salary), Boolean.parseBoolean(leaveStatus));
                    } else if (action.equals(6)) {
                        System.out.println("Enter Team name");
                        String team = sc.nextLine();
                        System.out.println(company.dbConnection.getTeam(team).getSalary());
                    } else if (action.equals(7)) {
                        System.out.println("Enter Team name");
                        String team = sc.nextLine();
                        company.dbConnection.getTeam(team).showHelp();
                    } else if (action.equals(8)) {
                        break;
                    } else {
                        System.out.println("Invalid Action");
                    }
                }
            } else if (type.equals("user")) {
                /**
                 * we let the user log in using his unique ID and his password
                 */
                System.out.println("Enter ID :");
                String idString = sc.nextLine();
                Integer id = Integer.parseInt(idString);
                System.out.println("Enter Paasword :");
                String password = sc.nextLine();
                User user = dbConnection.getUser(id);
                if (user == null) {
                    System.out.println("The ID is incorrect");
                    return;
                } else if (!user.password.equals(password)) {
                    System.out.println("The Password is incorrect");
                    return;
                }
                while (true) {
                    /**
                     * we show the actions that can be performed and let the User do what he wants
                     */
                    user.showHelp();
                    String actionString = sc.nextLine();
                    Integer action = Integer.parseInt(actionString);
                    if (action.equals(1)) {
                        System.out.println(user.checkLeaveStatus());
                    } else if (action.equals(2)) {
                        System.out.println(user.getSalary());
                    } else if (action.equals(3)) {
                        for (int i = 0; i < user.checkHoliday(company).size(); i++) {
                            System.out.println(user.checkHoliday(company).get(i));
                        }
                        System.out.println();
                    } else if (action.equals(4)) {
                        System.out.println("Enter your grievance");
                        String grievance = sc.nextLine();
                        user.voiceGrievance(company, grievance);
                    } else if (action.equals(5)) {
                        user.resign(company, user.id);
                        break;
                    } else if (action.equals(6)) {
                        break;
                    } else {
                        System.out.println("Invalid Action");
                    }
                }
            } else if (type.equals("exit")) {
                break;
            } else {
                System.out.println("This user type is not defined in our system.");
            }
        }
        System.out.println();
    }
}
