package final_project;

public class AdvancedCourse extends Course {
	private String [] dataManagement = {"Select A Class", "CL120", "CL122", "CL123"};
	private String [] OOP = {"Select A Class", "HP211", "HP212", "HP213"};
	private String [] calculus = {"Select A Class", "RM124", "RM125", "RM26"};
	private String [] webAppDev = {"Select A Class", "Lab220", "Lab221", "Lab222"};
	private String [] cybersecurity = {"Select A Class", "Mac214", "Mac215", "Mac216"};
    
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
