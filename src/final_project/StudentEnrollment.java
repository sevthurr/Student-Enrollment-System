package final_project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import java.awt.Toolkit;
import java.awt.CardLayout;


public class StudentEnrollment extends StudentRegistration {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField studentID;
	private JTextField txtFirstName;
	private JTextField txtLastName;
	private JTextField txtGradeLevel;
	private JTextField txtProgram;	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentEnrollment frame = new StudentEnrollment();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					JOptionPane.showMessageDialog(null, "Search to enroll a course!");
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public StudentEnrollment() {

		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\kayem\\Pictures\\k++\\2.png"));
		setTitle("Student Enrollment");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 870, 546);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(255, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		String[] schedule = {"Select A Schedule", "Morning (0700 - 1200)",
				"Afternoon (1300 - 1700)", "Evening (1730 PM - 2130 PM)"};

		 	StudentRegistration registration = new StudentRegistration();
		 	Course course = new Course(schedule);
		 	BeginnerCourse beginnerCourse = new BeginnerCourse(schedule);
		 	AdvancedCourse advancedCourse = new AdvancedCourse(schedule);
		 	
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBackground(new Color(255, 128, 128));
		lblNewLabel_1.setFont(new Font("Gill Sans MT", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(135, 155, 28, 14);
		contentPane.add(lblNewLabel_1);
		
		JPanel leftpanel = new JPanel();
		leftpanel.setBackground(new Color(255, 0, 0));
		leftpanel.setBounds(0, 0, 257, 563);
		contentPane.add(leftpanel);
		leftpanel.setLayout(null);
		
		JLabel lblStudentEnrollment = new JLabel("Course Enrollment");
		lblStudentEnrollment.setBounds(29, 118, 207, 30);
		leftpanel.add(lblStudentEnrollment);
		lblStudentEnrollment.setBackground(new Color(0, 0, 0));
		lblStudentEnrollment.setForeground(new Color(255, 255, 255));
		lblStudentEnrollment.setFont(new Font("Gill Sans MT", Font.BOLD, 22));
		
		JPanel rightpanel = new JPanel();
		rightpanel.setBounds(258, 0, 598, 509);
		contentPane.add(rightpanel);
		rightpanel.setLayout(new CardLayout(0, 0));
		
		JPanel Recordpanel = new JPanel();
		Recordpanel.setBackground(new Color(255, 255, 255));
		rightpanel.add(Recordpanel, "name_2050468074901400");
		Recordpanel.setLayout(null);
		
		JPanel BeginnerPanel = new JPanel();
		BeginnerPanel.setBackground(new Color(255, 255, 255));
		rightpanel.add(BeginnerPanel, "name_2050858115526900");
		BeginnerPanel.setLayout(null);
		
		JLabel lblBeginnerCourses = new JLabel("Beginner Courses");
		lblBeginnerCourses.setBounds(227, 70, 180, 24);
		lblBeginnerCourses.setForeground(Color.BLACK);
		lblBeginnerCourses.setFont(new Font("Gill Sans MT", Font.BOLD, 20));
		BeginnerPanel.add(lblBeginnerCourses);
		
		JLabel lblBeginnerSchedule = new JLabel("Schedule");
		lblBeginnerSchedule.setFont(new Font("Gill Sans MT", Font.BOLD, 16));
		lblBeginnerSchedule.setBounds(89, 117, 103, 30);
		BeginnerPanel.add(lblBeginnerSchedule);
		
		JComboBox<String> CB_BeginnerSchedule = new JComboBox<>(course.getSchedule());
		CB_BeginnerSchedule.setBounds(202, 123, 222, 22);
		BeginnerPanel.add(CB_BeginnerSchedule);
		
		JLabel lblIntroductionToComputing = new JLabel("Introduction To Computing");
		lblIntroductionToComputing.setFont(new Font("Gill Sans MT", Font.BOLD, 16));
		lblIntroductionToComputing.setBounds(61, 184, 245, 30);
		BeginnerPanel.add(lblIntroductionToComputing);
		
		JLabel lblComputerProgramming = new JLabel("Computer Programming 1");
		lblComputerProgramming.setFont(new Font("Gill Sans MT", Font.BOLD, 16));
		lblComputerProgramming.setBounds(61, 274, 245, 30);
		BeginnerPanel.add(lblComputerProgramming);
		
		JLabel lblDiscreteMath = new JLabel("Discrete Math");
		lblDiscreteMath.setFont(new Font("Gill Sans MT", Font.BOLD, 16));
		lblDiscreteMath.setBounds(61, 360, 245, 30);
		BeginnerPanel.add(lblDiscreteMath);
		
		JLabel lblComputerNetworks = new JLabel("Computer Networks");
		lblComputerNetworks.setFont(new Font("Gill Sans MT", Font.BOLD, 16));
		lblComputerNetworks.setBounds(333, 184, 245, 30);
		BeginnerPanel.add(lblComputerNetworks);
		
		JLabel lblWebDevelopment = new JLabel("Web Development 1");
		lblWebDevelopment.setFont(new Font("Gill Sans MT", Font.BOLD, 16));
		lblWebDevelopment.setBounds(333, 274, 245, 30);
		BeginnerPanel.add(lblWebDevelopment);
	
		//COMBO BOX FOR BEGINNER COURSES
		JComboBox<String> CB_IntroToComputing = new JComboBox<>(beginnerCourse.getIntroToComputing());
		CB_IntroToComputing.setBounds(61, 224, 194, 22);
		BeginnerPanel.add(CB_IntroToComputing);
		
		JComboBox <String> CB_Programming = new JComboBox <>(beginnerCourse.getProgramming1());
		CB_Programming.setBounds(61, 316, 194, 22);
		BeginnerPanel.add(CB_Programming);
		
		JComboBox <String> CB_DiscreteMath = new JComboBox <> (beginnerCourse.getDiscereteMath());
		CB_DiscreteMath.setBounds(61, 403, 194, 22);
		BeginnerPanel.add(CB_DiscreteMath);
		
		JComboBox <String> CB_ComputerNetworks = new JComboBox <String>(beginnerCourse.getComputerNetworks());
		CB_ComputerNetworks.setBounds(333, 224, 194, 22);
		BeginnerPanel.add(CB_ComputerNetworks);
		
		JComboBox <String> CB_WebDev = new JComboBox <String>(beginnerCourse.getWebDev());
		CB_WebDev.setBounds(333, 316, 194, 22);
		BeginnerPanel.add(CB_WebDev);
		
		
		//FINALIZE BUTTON FOR BEGINNER
		JButton btnBeginnerFinalize = new JButton("Finalize");
		btnBeginnerFinalize.setToolTipText("Click to finalize enrollment");
		btnBeginnerFinalize.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {         	
               
		        try (Scanner ifile = new Scanner(new FileReader("stud.txt"));
		                PrintWriter outfile = new PrintWriter(new FileWriter("enroll.txt", true))) {

		               boolean found = false;
		               String enteredID = studentID.getText().trim(); // Retrieve entered student ID

		               while (ifile.hasNextLine()) {
		                   String line = ifile.nextLine(); // Read the entire line
		                   String[] details = line.split(":"); // Split the line into details
		                   String id = details[0].trim(); // ID is the first element

		                   if (id.equals(enteredID)) {
		                       found = true;
		                       String schedule = (String) CB_BeginnerSchedule.getSelectedItem();
		                       String introToComputing = (String) CB_IntroToComputing.getSelectedItem();
		                       String programming1 = (String) CB_Programming.getSelectedItem();
		                       String discreteMath = (String) CB_DiscreteMath.getSelectedItem();
		                       String computerNetworks = (String) CB_ComputerNetworks.getSelectedItem();
		                       String webDev = (String) CB_WebDev.getSelectedItem();

		                       // Check for valid selections
		                       if (CB_BeginnerSchedule.getSelectedIndex() == 0 ||
		                           CB_IntroToComputing.getSelectedIndex() == 0 ||
		                           CB_Programming.getSelectedIndex() == 0 ||
		                           CB_DiscreteMath.getSelectedIndex() == 0 ||
		                           CB_ComputerNetworks.getSelectedIndex() == 0 ||
		                           CB_WebDev.getSelectedIndex() == 0) {

		                           JOptionPane.showMessageDialog(null, "Please pick a schedule and a class for each course.");
		                       } else {
		                           String fullName = details[1].trim() + " " + details[2].trim(); // Concatenate first and last name
		                           String gradeLevel = details[3].trim();
		                           String program = details[4].trim();
		                           
		                           // Writing to "enroll.txt"
		                           outfile.println(id + " - " + fullName + ":" + schedule + ":" + "Introduction To Computing" + " - " + introToComputing + ":" + "Programming 1" + " - " +
		                        		   			programming1 + ":" + "Discrete Math" + "-" + discreteMath + ":" + "Computer Networks" + " - " + computerNetworks + ":" +
		                        		   			"Web Development" + " - " + webDev);

		                           // Displaying enrollment confirmation dialog
		                           JOptionPane.showMessageDialog(null, "ENROLLED\n " + "\nStudent ID: " + id + "\nName: " + fullName + "\nGrade Level: " + gradeLevel + "\nProgram: " + program +
		                                                         "\n--------------------------------------------------------------" + 
		                                                         "\nCOURSE INFORMATION\n" + "\nSchedule: " + schedule + 
		                                                         "\nIntro To Computing: Room " + introToComputing + "\nProgramming 1: Room " + programming1 +
		                                                         "\nDiscrete Math: Room " + discreteMath + "\nComputer Networks: Room " + computerNetworks + 
		                                                         "\nWeb Development: Room " + webDev);
		                           found = true;
		                           EnrollmentRecord enrollRec = new EnrollmentRecord();
				                   enrollRec.setVisible(true);
		                           break;
		                           
		                           
		                       }
		                   }
		               }
		           } catch (IOException e) {
		               e.printStackTrace();
		               JOptionPane.showMessageDialog(null, "Error occurred while processing the enrollment: " + e.getMessage());
		           }
		       }
		   });
		
		btnBeginnerFinalize.setForeground(Color.WHITE);
		btnBeginnerFinalize.setFont(new Font("Gill Sans MT", Font.BOLD, 12));
		btnBeginnerFinalize.setBackground(Color.RED);
		btnBeginnerFinalize.setBounds(393, 378, 134, 23);
		BeginnerPanel.add(btnBeginnerFinalize);
		Recordpanel.setLayout(null);
		
		//ADVANCED COURSES
		JPanel AdvancedPanel = new JPanel();
		AdvancedPanel.setBackground(new Color(255, 255, 255));
		rightpanel.add(AdvancedPanel, "name_2051325227198600");
		AdvancedPanel.setLayout(null);
		
		JLabel lblAdvancedCourses = new JLabel("Advanced Courses");
		lblAdvancedCourses.setForeground(Color.BLACK);
		lblAdvancedCourses.setFont(new Font("Gill Sans MT", Font.BOLD, 20));
		lblAdvancedCourses.setBounds(209, 65, 180, 24);
		AdvancedPanel.add(lblAdvancedCourses);
		
		JLabel lblAdvancedSchedule = new JLabel("Schedule");
		lblAdvancedSchedule.setFont(new Font("Gill Sans MT", Font.BOLD, 16));
		lblAdvancedSchedule.setBounds(90, 119, 103, 30);
		AdvancedPanel.add(lblAdvancedSchedule);
		
		JLabel lblDatabaseManagement = new JLabel("Database Management");
		lblDatabaseManagement.setFont(new Font("Gill Sans MT", Font.BOLD, 16));
		lblDatabaseManagement.setBounds(57, 185, 245, 30);
		AdvancedPanel.add(lblDatabaseManagement);
		
		JLabel lblWebApplicationDevelopment = new JLabel("Web App Development");
		lblWebApplicationDevelopment.setFont(new Font("Gill Sans MT", Font.BOLD, 16));
		lblWebApplicationDevelopment.setBounds(343, 186, 245, 30);
		AdvancedPanel.add(lblWebApplicationDevelopment);
		
		JLabel lblOOP = new JLabel("Object-Oriented Programming");
		lblOOP.setFont(new Font("Gill Sans MT", Font.BOLD, 16));
		lblOOP.setBounds(57, 277, 245, 30);
		AdvancedPanel.add(lblOOP);
		
		JLabel lblCybersecurity = new JLabel("Cybersecurity");
		lblCybersecurity.setFont(new Font("Gill Sans MT", Font.BOLD, 16));
		lblCybersecurity.setBounds(343, 276, 245, 30);
		AdvancedPanel.add(lblCybersecurity);
		
		
		JLabel lblCalculus = new JLabel("Calculus");
		lblCalculus.setFont(new Font("Gill Sans MT", Font.BOLD, 16));
		lblCalculus.setBounds(57, 364, 245, 30);
		AdvancedPanel.add(lblCalculus);
		
		//COMBO BOXES FOR ADVANCED COURSES
		JComboBox <String> CB_AdvancedSchedule = new JComboBox <String>(course.getSchedule());
		CB_AdvancedSchedule.setBounds(199, 125, 194, 22);
		AdvancedPanel.add(CB_AdvancedSchedule);
	
		JComboBox <String> CB_DataManagement = new JComboBox <String>(advancedCourse.getDataManagement());
		CB_DataManagement.setBounds(57, 226, 194, 22);
		AdvancedPanel.add(CB_DataManagement);
		
		JComboBox <String> CB_WebAppDevelopment = new JComboBox <String>(advancedCourse.getwebAppDev());
		CB_WebAppDevelopment.setBounds(342, 226, 194, 22);
		AdvancedPanel.add(CB_WebAppDevelopment);
		
		JComboBox <String> CB_OOP = new JComboBox <String>(advancedCourse.getOOP());
		CB_OOP.setBounds(57, 318, 194, 22);
		AdvancedPanel.add(CB_OOP);

		JComboBox <String> CB_Cybersecurity = new JComboBox <String>(advancedCourse.getCybersecurity());
		CB_Cybersecurity.setBounds(342, 318, 194, 22);
		AdvancedPanel.add(CB_Cybersecurity);
		
		JComboBox <String> CB_Calculus = new JComboBox <String>(advancedCourse.getCybersecurity());
		CB_Calculus.setBounds(57, 405, 194, 22);
		AdvancedPanel.add(CB_Calculus);
		
		//ADVANCED COURSE FINALIZE BUTTON
		JButton btnAdvancedFinalize = new JButton("Finalize");
		btnAdvancedFinalize.setToolTipText("Click to finalize enrollment");
		btnAdvancedFinalize.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
		        try (Scanner ifile = new Scanner(new FileReader("stud.txt"));
		                PrintWriter outfile = new PrintWriter(new FileWriter("enroll.txt", true))) {
		            boolean found = false;
		            String enteredID = studentID.getText().trim(); // Retrieve entered student ID

		            while (ifile.hasNextLine()) {
		                String line = ifile.nextLine(); // Read the entire line
		                String[] details = line.split(":"); // Split the line into details
		                String id = details[0].trim(); // ID is the first element
		                String firstName = details[1].trim(); // First name is the second element
		                String lastName = details[2].trim(); // Last name is the third element
		                String gradeLevel = details[3].trim();
		                String program = details[4].trim();

		                if (id.equals(enteredID)) {
		                    found = true;
		                    String schedule = (String) CB_AdvancedSchedule.getSelectedItem();
		                    String dataManagement = (String) CB_DataManagement.getSelectedItem();
		                    String OOP = (String) CB_OOP.getSelectedItem();
		                    String calculus = (String) CB_Calculus.getSelectedItem();
		                    String webAppDev = (String) CB_WebAppDevelopment.getSelectedItem();
		                    String cybersecurity = (String) CB_Cybersecurity.getSelectedItem();

		                    // Check for valid selections
		                    if (CB_AdvancedSchedule.getSelectedIndex() == 0 ||
		                        CB_DataManagement.getSelectedIndex() == 0 ||
		                        CB_OOP.getSelectedIndex() == 0 ||
		                        CB_Calculus.getSelectedIndex() == 0 ||
		                        CB_WebAppDevelopment.getSelectedIndex() == 0 ||
		                        CB_Cybersecurity.getSelectedIndex() == 0) {
		                        JOptionPane.showMessageDialog(null, "Please pick a schedule and a class for each course.");
		                    } else {
		                        // Writing to "enroll.txt"
		                        outfile.println(id + " - " + firstName + " " + lastName + ":" + schedule + ":" + "Data Management" + " - " + dataManagement + ":" + "Object-Oriented Programming"
		                                + " - " + OOP + ":"+ "Calculus" + " - " + calculus + ":" + "Web Application Development" + " - " + webAppDev + ":" + "Cybersecurity" + " - " + cybersecurity);

		                        // Displaying enrollment confirmation dialog
		                        JOptionPane.showMessageDialog(null, "ENROLLED\n " + "\nStudent ID: " + id + "\nName: " + firstName + " " + lastName + "\nGrade Level: " + gradeLevel + "\nProgram: " + program +
		                                "\n--------------------------------------------------------------" +
		                                "\nCOURSE INFORMATION\n" + "\nSchedule: " + schedule +
		                                "\nData Management: Room " + dataManagement + "\nObject-Oriented Programming: Room " + OOP +
		                                "\nCalculus: Room " + calculus + "\nWeb Application Development: Room " + webAppDev +
		                                "\nCybersecurity: Room " + cybersecurity);
		                        EnrollmentRecord enrollRec = new EnrollmentRecord();
		                        enrollRec.setVisible(true);
		                        break;
		                    }
		                }
		            }
		        } catch (IOException e) {
		            e.printStackTrace();
		            JOptionPane.showMessageDialog(null, "Error occurred while processing the enrollment: " + e.getMessage());
		        }
		    }
		});
		
		btnAdvancedFinalize.setForeground(Color.WHITE);
		btnAdvancedFinalize.setFont(new Font("Gill Sans MT", Font.BOLD, 12));
		btnAdvancedFinalize.setBackground(Color.RED);
		btnAdvancedFinalize.setBounds(402, 404, 134, 23);
		AdvancedPanel.add(btnAdvancedFinalize);
		Recordpanel.setLayout(null);

		JButton btnSearchStudent = new JButton("Search Student");
		btnSearchStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				rightpanel.removeAll();
				rightpanel.repaint();
				rightpanel.revalidate();
				rightpanel.add(Recordpanel);
				rightpanel.repaint();
				rightpanel.revalidate();
			}
		});
		btnSearchStudent.setForeground(new Color(255, 0, 0));
		btnSearchStudent.setFont(new Font("Gill Sans MT", Font.BOLD, 12));
		btnSearchStudent.setBackground(new Color(255, 255, 255));
		btnSearchStudent.setBounds(48, 194, 162, 36);
		leftpanel.add(btnSearchStudent);
		
		JButton btnadvancedCourse = new JButton("Advanced Courses");
		btnadvancedCourse.setToolTipText("See advanced courses");
		btnadvancedCourse.setEnabled(false);
		btnadvancedCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rightpanel.removeAll();
				rightpanel.repaint();
				rightpanel.revalidate();
				rightpanel.add(AdvancedPanel);
				rightpanel.repaint();
				rightpanel.revalidate();
			}
		});
		btnadvancedCourse.setForeground(new Color(255, 0, 0));
		btnadvancedCourse.setFont(new Font("Gill Sans MT", Font.BOLD, 12));
		btnadvancedCourse.setBackground(new Color(255, 255, 255));
		btnadvancedCourse.setBounds(48, 310, 162, 36);
		leftpanel.add(btnadvancedCourse);
		
		JButton btnBeginnerCourse = new JButton("Beginner Courses");
		btnBeginnerCourse.setToolTipText("See beginner courses");
		btnBeginnerCourse.setEnabled(false);
		btnBeginnerCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				rightpanel.removeAll();
				rightpanel.repaint();
				rightpanel.revalidate();
				rightpanel.add(BeginnerPanel);
				rightpanel.repaint();
				rightpanel.revalidate();
			}
		});
		btnBeginnerCourse.setForeground(Color.RED);
		btnBeginnerCourse.setFont(new Font("Gill Sans MT", Font.BOLD, 12));
		btnBeginnerCourse.setBackground(Color.WHITE);
		btnBeginnerCourse.setBounds(48, 253, 162, 36);
		leftpanel.add(btnBeginnerCourse);
		
		studentID = new JTextField();
		studentID.setToolTipText("search student ID");
		studentID.setForeground(new Color(0, 0, 0));
		studentID.setBounds(202, 64, 172, 26);
		Recordpanel.add(studentID);
		studentID.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(402, 64, 103, 26);
		Recordpanel.add(btnSearch);
		btnSearch.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	 try (Scanner ifile = new Scanner(new FileReader("stud.txt"))) {
		             boolean found = false;

		             String enteredID = studentID.getText().trim(); // Retrieve entered student ID

		             while (ifile.hasNextLine()) {
		                 String line = ifile.nextLine(); // Read the entire line
		                 String[] details = line.split(":"); // Split the line into details
		                 String id = details[0].trim(); // ID is the first element
		                 String firstName = details[1].trim(); // First name is the second element
		                 String lastName = details[2].trim(); // Last name is the third element
		                 String gradeLevel = details [3].trim();
		                 String program = details [4].trim();

		                 if (id.equalsIgnoreCase(enteredID)) { // Compare with the entered student ID
		                     JOptionPane.showMessageDialog(null, "Student found: " + id + "\nName: " + firstName + " " + lastName + "\nGrade Level: " + gradeLevel + "\nProgram: " + program);
		                     found = true;
			                 txtFirstName.setText(firstName);
			                 txtFirstName.setEditable(false);
			                 txtLastName.setText(lastName);
			                 txtLastName.setEditable(false);
			                 txtGradeLevel.setText(gradeLevel);
			                 txtGradeLevel.setEditable(false);
			                 txtProgram.setText(program);
			                 txtProgram.setEditable(false);			                 
			              
			                 int gradeLevelInt = Integer.parseInt(gradeLevel);
			                 
			                 if (gradeLevelInt >= 1 && gradeLevelInt <= 2) {
			                     btnBeginnerCourse.setEnabled(true);
			                     btnadvancedCourse.setEnabled(false);
			                 } else if (gradeLevelInt >= 3 && gradeLevelInt <= 4) {
			                     btnBeginnerCourse.setEnabled(false);
			                     btnadvancedCourse.setEnabled(true);			        
			                 }
			                 
			             }		        
		           } if (!found) {
		                 JOptionPane.showMessageDialog(null, "Student not found!");
		             }
		         } catch (FileNotFoundException e1) {
		             e1.printStackTrace();
	                 JOptionPane.showMessageDialog(null, "Cannot retrieve records from stud.txt" +
	                		 						"\nEnter a valid ID number.");

		         }	                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               
		     }
		 });
		
		btnSearch.setForeground(new Color(255, 0, 0));
		btnSearch.setFont(new Font("Gill Sans MT", Font.BOLD, 12));
		btnSearch.setBackground(new Color(255, 255, 255));
		
		JLabel lblEnrollmentRecord = new JLabel("Student Record");
		lblEnrollmentRecord.setBounds(237, 134, 187, 30);
		Recordpanel.add(lblEnrollmentRecord);
		lblEnrollmentRecord.setForeground(Color.BLACK);
		lblEnrollmentRecord.setFont(new Font("Gill Sans MT", Font.BOLD, 20));
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setFont(new Font("Gill Sans MT", Font.BOLD, 16));
		lblFirstName.setBounds(88, 188, 103, 30);
		Recordpanel.add(lblFirstName);
		
		txtFirstName = new JTextField();
		txtFirstName.setFont(new Font("Gill Sans MT", Font.PLAIN, 13));
		txtFirstName.setColumns(10);
		txtFirstName.setBounds(201, 191, 223, 26);
		Recordpanel.add(txtFirstName);
		
		txtLastName = new JTextField();
		txtLastName.setFont(new Font("Gill Sans MT", Font.PLAIN, 13));
		txtLastName.setColumns(10);
		txtLastName.setBounds(201, 229, 223, 26);
		Recordpanel.add(txtLastName);
		
		txtGradeLevel = new JTextField();
		txtGradeLevel.setFont(new Font("Gill Sans MT", Font.PLAIN, 13));
		txtGradeLevel.setColumns(10);
		txtGradeLevel.setBounds(201, 266, 223, 26);
		Recordpanel.add(txtGradeLevel);
		
		txtProgram = new JTextField();
		txtProgram.setFont(new Font("Gill Sans MT", Font.PLAIN, 13));
		txtProgram.setColumns(10);
		txtProgram.setBounds(201, 303, 223, 26);
		Recordpanel.add(txtProgram);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("Gill Sans MT", Font.BOLD, 16));
		lblLastName.setBounds(88, 226, 103, 30);
		Recordpanel.add(lblLastName);
		
		JLabel lblGradeLevel = new JLabel("Grade Level");
		lblGradeLevel.setFont(new Font("Gill Sans MT", Font.BOLD, 16));
		lblGradeLevel.setBounds(88, 263, 103, 30);
		Recordpanel.add(lblGradeLevel);
		
		JLabel lblProgram = new JLabel("Program");
		lblProgram.setFont(new Font("Gill Sans MT", Font.BOLD, 16));
		lblProgram.setBounds(88, 300, 103, 30);
		Recordpanel.add(lblProgram);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(Color.RED);
		panel_1_1.setBounds(69, 53, 451, 47);
		Recordpanel.add(panel_1_1);
		panel_1_1.setLayout(null);
		
		JLabel lblStudentId = new JLabel("Student ID");
		lblStudentId.setBounds(20, 11, 83, 25);
		panel_1_1.add(lblStudentId);
		lblStudentId.setForeground(new Color(255, 255, 255));
		lblStudentId.setFont(new Font("Gill Sans MT", Font.BOLD, 16));
		
	}
}
