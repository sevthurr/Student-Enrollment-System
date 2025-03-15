package final_project;

public class Course {
	private String[] schedule = {"Select A Schedule", "Morning", "Afternoon", "Evening"};



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
