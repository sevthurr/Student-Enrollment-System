package final_project;

public class BeginnerCourse extends Course {
    private String[] introToComputing = {"Select A Class Code", "COMP-1A", "COMP-1B", "COMP-1C"};
    private String[] programming1 = {"Select A Class", "PROG-1A", "PROG-1B", "PROG-2C"};
    private String [] discereteMath = {"Select A Class", "MTH-1A", "MTH-2B", "MATH-2C"};
	private String [] computerNetworks = {"Select A Class", "COMNET-1A", "COMNET-2B", "COMNET-2C"};
	private String [] webDev = {"Select A Class", "WEBDEV-1A", "WEBDEV-1B", "WEBDEV-2C"};
    
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
