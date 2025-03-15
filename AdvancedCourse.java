package final_project;

public class AdvancedCourse extends Course {
	private String [] dataManagement = {"Select A Class", "DBMS-3A", "DBMS-4B", "DBMS4C"};
	private String [] OOP = {"Select A Class", "OOP-3A", "OOP-3B", "OOP-4C"};
	private String [] calculus = {"Select A Class", "CALC-3A", "CALC-3B", "CALC-4C"};
	private String [] webAppDev = {"Select A Class", "WEBAPP-3A", "WEBAPP-4B", "WEBAPP-4C"};
	private String [] cybersecurity = {"Select A Class", "CYBRSEC-3A", "CYBRSEC-4B", "CYBRSEC-4C"};
    
    public AdvancedCourse(String[] schedule) {
        super(schedule);
    }

    @Override
    public String getCourseType() {
        return "Advanced";
    }
    
    public String[] getDataManagement() {
        return dataManagement;
    }

    public String[] getOOP() {
        return OOP;
    }

    public String[] getCalculus() {
        return calculus;
    }

    public String[] getwebAppDev() {
        return webAppDev;
    }

    public String[] getCybersecurity() {
        return cybersecurity;
    }
}
