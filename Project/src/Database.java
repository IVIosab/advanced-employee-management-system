import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * This si a mock database consisting of Maps as the DataBases
 * <p>
 * Note : this is just for convenience, in a big project there has to be an actual Database
 */
public class Database {
    public String name;
    public ArrayList<String> grievances = new ArrayList<>();
    public ArrayList<String> holidays = new ArrayList<>();
    public ArrayList<CompanyUnit> companyUnits = new ArrayList<>();
    public int revenue;
    private Map<Integer, Admin> adminDB = new HashMap<>();
    private Map<Integer, User> userDB = new HashMap<>();
    private Map<String, Team> teamDB = new HashMap<>();

    public Map<Integer, Admin> getAdminDB() {
        return adminDB;
    }

    public Map<Integer, User> getUserDB() {
        return userDB;
    }

    public Map<String, Team> getTeamDB() {
        return teamDB;
    }
}
