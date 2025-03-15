package final_project;

public class Course {
	    private String[] schedule = {"Select A Schedule", "Morning (0700 - 1200)",
	    							"Afternoon (1300 - 1700)", "Evening (1730 PM - 2130 PM)"};


	    public Course(String [] schedule) {
	        this.schedule = schedule;
	        
	    }

	    public String[] getSchedule() {
	        return schedule;
	    }

	    public String getCourseType() {
			return null;
		}
	    	
	}
