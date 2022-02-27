import java.util.ArrayList;
import java.util.Map;

/**
 * This is the DatabaseConnection
 * It is the only way to communicate with the database.
 * It uses Singleton design pattern to
 * ensure a single access to the database to avoid any possible problems caused
 * by multiple connections at a time.
 */
public class DatabaseConnection {
    private static DatabaseConnection dbConnection = null;
    private Database database;


    private DatabaseConnection() {
        database = new Database();
    }

    // guarantees a single instance of DatabaseConnection
    public static DatabaseConnection getDB() {
        if (dbConnection == null) {
            dbConnection = new DatabaseConnection();
        }
        return dbConnection;
    }

    /**
     * @return the Map of Admins
     */
    public Map<Integer, Admin> getAdmins() {
        return database.getAdminDB();
    }

    /**
     * @return the Map of Users
     */
    public Map<Integer, User> getUsers() {
        return database.getUserDB();
    }

    /**
     * @return the Map of Teams
     */
    public Map<String, Team> getTeams() {
        return database.getTeamDB();
    }

    /**
     * @param id
     * @return the Admin with ID = id
     */
    public Admin getAdmin(Integer id) {
        return database.getAdminDB().get(id);
    }

    /**
     * @param id
     * @return the User with ID = id
     */
    public User getUser(Integer id) {
        return database.getUserDB().get(id);
    }

    /**
     * @param name
     * @return the Team with Name = name
     */
    public Team getTeam(String name) {
        return database.getTeamDB().get(name);
    }

    /**
     * @return Company name
     */
    public String getCompanyName() {
        return database.name;
    }

    /**
     * @return list of company grievances
     */
    public ArrayList<String> getCompanyGrievances() {
        return database.grievances;
    }

    /**
     * @return list of company holidays
     */
    public ArrayList<String> getCompanyHolidays() {
        return database.holidays;
    }

    /**
     * @return list of company units
     */
    public ArrayList<CompanyUnit> getCompanyUnits() {
        return database.companyUnits;
    }

    /**
     * @return company revenue
     */
    public int getCompanyRevenue() {
        return database.revenue;
    }

    /**
     * adds a new admin to the database
     *
     * @param newAdmin
     */
    public void addAdmin(Admin newAdmin) {
        getAdmins().put(newAdmin.id, newAdmin);
    }

    /**
     * adds a new user to the database
     *
     * @param newUser
     */
    public void addUser(User newUser) {
        getUsers().put(newUser.id, newUser);
    }

    /**
     * adds a new team to the database
     *
     * @param newTeam
     */
    public void addTeam(Team newTeam) {
        getTeams().put(newTeam.name, newTeam);
    }

    /**
     * changes the company name
     *
     * @param newName
     */
    public void setCompanyName(String newName) {
        database.name = newName;
    }

    /**
     * changes the company revenue
     *
     * @param newRevenue
     */
    public void setCompanyRevenue(int newRevenue) {
        database.revenue = newRevenue;
    }

    /**
     * adds a holiday to the list of company holidays
     *
     * @param newHoliday
     */
    public void addCompanyHoliday(String newHoliday) {
        database.holidays.add(newHoliday);
    }

    /**
     * adds a grievance to the list of company grievances
     *
     * @param newGrievance
     */
    public void addCompanyGrievance(String newGrievance) {
        database.grievances.add(newGrievance);
    }

    /**
     * adds a company unit to the list of company units
     *
     * @param companyUnit
     */
    public void addCompanyUnits(CompanyUnit companyUnit) {
        database.companyUnits.add(companyUnit);
    }
}