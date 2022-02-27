import java.util.ArrayList;

/**
 * This is the Company
 * It holds all information necessary about the Company
 */
public class Company {
    protected String name;
    protected ArrayList<String> grievances, holidays;
    protected int revenue;
    protected DatabaseConnection dbConnection = DatabaseConnection.getDB();
    protected ArrayList<CompanyUnit> companyUnits; // this has all the Company Units in the company, whether it's teams or employees

    Company() {
        this.name = "";
        this.revenue = 0;
        this.holidays = new ArrayList<>();
        this.grievances = new ArrayList<>();
        this.companyUnits = new ArrayList<>();
    }

    /**
     * @return the company revenue
     */
    public int getCompanyRevenue() {
        return dbConnection.getCompanyRevenue();
    }

    /**
     * this method adds a complaint expressed by an employee to the list of grievances
     *
     * @param grievance
     */
    public void addCompanyGrievances(String grievance) {
        dbConnection.addCompanyGrievance(grievance);
    }

    /**
     * @return the list of grievances
     */
    public ArrayList<String> getCompanyGrievances() {
        return dbConnection.getCompanyGrievances();
    }

    /**
     * this method adds a holiday to the list of company holidays
     *
     * @param holiday
     */
    public void addCompanyHoliday(String holiday) {
        dbConnection.addCompanyHoliday(holiday);
    }

    /**
     * @return the company holidays
     */
    public ArrayList<String> getCompanyHolidays() {
        return dbConnection.getCompanyHolidays();
    }

    /**
     * this method adds a company unit to the list of company units
     *
     * @param companyUnit
     */
    public void addCompanyUnit(CompanyUnit companyUnit) {
        dbConnection.addCompanyUnits(companyUnit);
    }

    /**
     * @return the list of company units
     */
    public ArrayList<CompanyUnit> getCompanyUnits() {
        return dbConnection.getCompanyUnits();
    }
}
