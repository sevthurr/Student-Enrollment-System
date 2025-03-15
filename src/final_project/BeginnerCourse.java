package final_project;

public class BeginnerCourse extends Course {
    private String[] introToComputing = {"Select A Class", "CL101", "CL102", "CL103"};
    private String[] programming1 = {"Select A Class", "HP201", "HP202", "HP203"};
    private String [] discereteMath = {"Select A Class", "RM110", "RM112", "RM113"};
	private String [] computerNetworks = {"Select A Class", "Lab204", "Lab205", "Lab206"};
	private String [] webDev = {"Select A Class", "Mac204", "Mac206", "Mac207"};
    
    public BeginnerCourse(String [] schedule) {
        super(schedule);
    }

    @Override
    public String getCourseType() {
        return "Beginner";
    }
        
     // Getter methods for accessing course arrays
        public String[] getIntroToComputing() {
            return introToComputing;
        }

        public String[] getProgramming1() {
            return programming1;
        }

        public String[] getDiscereteMath() {
            return discereteMath;
        }

        public String[] getComputerNetworks() {
            return computerNetworks;
        }

        public String[] getWebDev() {
            return webDev;
        }
}
