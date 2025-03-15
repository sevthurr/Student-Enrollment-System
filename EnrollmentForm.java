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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import java.awt.Toolkit;
import java.awt.CardLayout;


public class EnrollmentForm extends StudentRegistration {
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
					EnrollmentForm frame = new EnrollmentForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					JOptionPane.showMessageDialog(null, "SEARCH ID TO ENROLL A COURSE");
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public EnrollmentForm() {

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
		        String enteredID = studentID.getText().trim(); // Retrieve entered student ID

		        // Validate if the student ID is entered
		        if (enteredID.isEmpty()) {
		            JOptionPane.showMessageDialog(null, "Please enter a valid student ID.");
		            return;
		        }

		        // Get the selected schedule and courses
		        String schedule = (String) CB_BeginnerSchedule.getSelectedItem();
		        String introToComputingRoom = (String) CB_IntroToComputing.getSelectedItem();
		        String programming1Room = (String) CB_Programming.getSelectedItem();
		        String discreteMathRoom = (String) CB_DiscreteMath.getSelectedItem();
		        String computerNetworksRoom = (String) CB_ComputerNetworks.getSelectedItem();
		        String webDevRoom = (String) CB_WebDev.getSelectedItem();

		        // Validate course and schedule selection
		        if (CB_BeginnerSchedule.getSelectedIndex() == 0 ||
		            CB_IntroToComputing.getSelectedIndex() == 0 ||
		            CB_Programming.getSelectedIndex() == 0 ||
		            CB_DiscreteMath.getSelectedIndex() == 0 ||
		            CB_ComputerNetworks.getSelectedIndex() == 0 ||
		            CB_WebDev.getSelectedIndex() == 0) {
		            JOptionPane.showMessageDialog(null, "Please pick a schedule and a class for each course.");
		            return;
		        }

		        String sqlStudent = "SELECT * FROM students WHERE idNumber = ?";
		        String sqlEnrollment = "INSERT INTO EnrollmentRecord (student_id, schedule_id) VALUES (?, ?)";
		        String sqlGetScheduleId = "SELECT schedule_id FROM Schedule WHERE schedule_name = ?";
		        String sqlEnrollmentCourses = "INSERT INTO EnrollmentCourses (enrollment_id, course_id, room) VALUES (?, ?, ?)";
		        String sqlGetCourseId = "SELECT course_id FROM Course WHERE course_name = ?";

		        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb", "root", "");
		             PreparedStatement stmtStudent = connection.prepareStatement(sqlStudent);
		             PreparedStatement stmtGetScheduleId = connection.prepareStatement(sqlGetScheduleId);
		             PreparedStatement stmtEnrollment = connection.prepareStatement(sqlEnrollment, Statement.RETURN_GENERATED_KEYS);
		             PreparedStatement stmtGetCourseId = connection.prepareStatement(sqlGetCourseId);
		             PreparedStatement stmtEnrollmentCourses = connection.prepareStatement(sqlEnrollmentCourses)) {

		            // Validate if the student ID exists
		            stmtStudent.setInt(1, Integer.parseInt(enteredID));
		            ResultSet rsStudent = stmtStudent.executeQuery();
		            if (!rsStudent.next()) {
		                JOptionPane.showMessageDialog(null, "Student not found. Please enter a valid student ID.");
		                return;
		            }

		            // Retrieve schedule_id based on schedule_name
		            stmtGetScheduleId.setString(1, schedule);
		            ResultSet rsSchedule = stmtGetScheduleId.executeQuery();
		            int scheduleId = -1;
		            if (rsSchedule.next()) {
		                scheduleId = rsSchedule.getInt("schedule_id");
		            } else {
		                JOptionPane.showMessageDialog(null, "Invalid schedule selection.");
		                return;
		            }

		            stmtEnrollment.setInt(1, Integer.parseInt(enteredID));
		            stmtEnrollment.setInt(2, scheduleId);
		            stmtEnrollment.executeUpdate();

		            // Get the generated enrollment_id
		            ResultSet generatedKeys = stmtEnrollment.getGeneratedKeys();
		            int enrollmentId = -1;
		            if (generatedKeys.next()) {
		                enrollmentId = generatedKeys.getInt(1);
		            }

		            String[] beginnerCourses = {"Introduction to Computing", "Programming 1", "Discrete Math", "Computer Networks", "Web Development"};
		            String[] beginnerRooms = {introToComputingRoom, programming1Room, discreteMathRoom, computerNetworksRoom, webDevRoom};

		            for (int i = 0; i < beginnerCourses.length; i++) {
		                stmtGetCourseId.setString(1, beginnerCourses[i]);
		                ResultSet rsCourse = stmtGetCourseId.executeQuery();

		                if (rsCourse.next()) {
		                    int courseId = rsCourse.getInt("course_id");
		                    stmtEnrollmentCourses.setInt(1, enrollmentId);
		                    stmtEnrollmentCourses.setInt(2, courseId);
		                    stmtEnrollmentCourses.setString(3, beginnerRooms[i]);
		                    stmtEnrollmentCourses.executeUpdate();
		                } else {
		                    JOptionPane.showMessageDialog(null, "Invalid course selection: " + beginnerCourses[i]);
		                    return;
		                }
		            }

		            // Display confirmation message
		            String fullName = rsStudent.getString("FirstName") + " " + rsStudent.getString("LastName");
		            String gradeLevel = String.valueOf(rsStudent.getInt("GradeLevel"));
		            String program = rsStudent.getString("PROGRAM");

		            JOptionPane.showMessageDialog(null, "ENROLLED\n " + "\nStudent ID: " + enteredID + "\nName: " + fullName + "\nGrade Level: " + gradeLevel + "\nProgram: " + program +
		                    "\n--------------------------------------------------------------" +
		                    "\nCOURSE INFORMATION\n" + "\nSchedule: " + schedule +
		                    "\nIntro To Computing: " + introToComputingRoom + "\nProgramming 1: " + programming1Room +
		                    "\nDiscrete Math: " + discreteMathRoom + "\nComputer Networks: " + computerNetworksRoom +
		                    "\nWeb Development: " + webDevRoom);

		            // Proceed to EnrollmentRecords screen
		            EnrollmentRecords enrollRec = new EnrollmentRecords();
		            enrollRec.setVisible(true);

		        } catch (SQLException ex) {
		            ex.printStackTrace();
		            JOptionPane.showMessageDialog(null, "Error occurred while processing the enrollment: " + ex.getMessage());
		        } catch (NumberFormatException nfe) {
		            JOptionPane.showMessageDialog(null, "Invalid student ID. Please enter a valid numeric ID.");
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
		        String enteredID = studentID.getText().trim(); // Retrieve entered student ID

		        // Validate if the student ID is entered
		        if (enteredID.isEmpty()) {
		            JOptionPane.showMessageDialog(null, "Please enter a valid student ID.");
		            return;
		        }

		        // Get the selected schedule and courses
		        String schedule = (String) CB_AdvancedSchedule.getSelectedItem();
		        String dataManagementRoom = (String) CB_DataManagement.getSelectedItem();
		        String OOPRoom = (String) CB_OOP.getSelectedItem();
		        String calculusRoom = (String) CB_Calculus.getSelectedItem();
		        String webAppDevRoom = (String) CB_WebAppDevelopment.getSelectedItem();
		        String cybersecurityRoom = (String) CB_Cybersecurity.getSelectedItem();

		        // Validate course and schedule selection
		        if (CB_AdvancedSchedule.getSelectedIndex() == 0 ||
		            CB_DataManagement.getSelectedIndex() == 0 ||
		            CB_OOP.getSelectedIndex() == 0 ||
		            CB_Calculus.getSelectedIndex() == 0 ||
		            CB_WebAppDevelopment.getSelectedIndex() == 0 ||
		            CB_Cybersecurity.getSelectedIndex() == 0) {
		            JOptionPane.showMessageDialog(null, "Please pick a schedule and a class for each course.");
		            return;
		        }

		        String sqlStudent = "SELECT * FROM students WHERE idNumber = ?";
		        String sqlEnrollment = "INSERT INTO EnrollmentRecord (student_id, schedule_id) VALUES (?, ?)";
		        String sqlGetScheduleId = "SELECT schedule_id FROM Schedule WHERE schedule_name = ?";
		        String sqlEnrollmentCourses = "INSERT INTO EnrollmentCourses (enrollment_id, course_id, room) VALUES (?, ?, ?)";
		        String sqlGetCourseId = "SELECT course_id FROM Course WHERE course_name = ?";

		        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb", "root", "");
		             PreparedStatement stmtStudent = connection.prepareStatement(sqlStudent);
		             PreparedStatement stmtGetScheduleId = connection.prepareStatement(sqlGetScheduleId);
		             PreparedStatement stmtEnrollment = connection.prepareStatement(sqlEnrollment, Statement.RETURN_GENERATED_KEYS);
		             PreparedStatement stmtGetCourseId = connection.prepareStatement(sqlGetCourseId);
		             PreparedStatement stmtEnrollmentCourses = connection.prepareStatement(sqlEnrollmentCourses)) {

		            // Validate if the student ID exists
		            stmtStudent.setInt(1, Integer.parseInt(enteredID));
		            ResultSet rsStudent = stmtStudent.executeQuery();
		            if (!rsStudent.next()) {
		                JOptionPane.showMessageDialog(null, "Student not found. Please enter a valid student ID.");
		                return;
		            }

		            // Retrieve schedule_id based on schedule_name
		            stmtGetScheduleId.setString(1, schedule);
		            ResultSet rsSchedule = stmtGetScheduleId.executeQuery();
		            int scheduleId = -1;
		            if (rsSchedule.next()) {
		                scheduleId = rsSchedule.getInt("schedule_id");
		            } else {
		                JOptionPane.showMessageDialog(null, "Invalid schedule selection.");
		                return;
		            }

		            // Insert enrollment record into the EnrollmentRecord table
		            stmtEnrollment.setInt(1, Integer.parseInt(enteredID));
		            stmtEnrollment.setInt(2, scheduleId);
		            stmtEnrollment.executeUpdate();

		            // Get the generated enrollment_id
		            ResultSet generatedKeys = stmtEnrollment.getGeneratedKeys();
		            int enrollmentId = -1;
		            if (generatedKeys.next()) {
		                enrollmentId = generatedKeys.getInt(1);
		            }

		            // Insert each advanced course into EnrollmentCourses along with the room
		            String[] advancedCourses = {"Data Management", "Object-Oriented Programming", "Calculus", "Web App Development", "Cybersecurity"};
		            String[] advancedRooms = {dataManagementRoom, OOPRoom, calculusRoom, webAppDevRoom, cybersecurityRoom};

		            for (int i = 0; i < advancedCourses.length; i++) {
		                stmtGetCourseId.setString(1, advancedCourses[i]);
		                ResultSet rsCourse = stmtGetCourseId.executeQuery();

		                if (rsCourse.next()) {
		                    int courseId = rsCourse.getInt("course_id");
		                    stmtEnrollmentCourses.setInt(1, enrollmentId);
		                    stmtEnrollmentCourses.setInt(2, courseId);
		                    stmtEnrollmentCourses.setString(3, advancedRooms[i]);
		                    stmtEnrollmentCourses.executeUpdate();
		                } else {
		                    JOptionPane.showMessageDialog(null, "Invalid course selection: " + advancedCourses[i]);
		                    return;
		                }
		            }

		            // Display confirmation message
		            String fullName = rsStudent.getString("FirstName") + " " + rsStudent.getString("LastName");
		            String gradeLevel = String.valueOf(rsStudent.getInt("GradeLevel"));
		            String program = rsStudent.getString("PROGRAM");

		            JOptionPane.showMessageDialog(null, "ENROLLED\n " + "\nStudent ID: " + enteredID + "\nName: " + fullName + "\nGrade Level: " + gradeLevel + "\nProgram: " + program +
		                    "\n--------------------------------------------------------------" +
		                    "\nCOURSE INFORMATION\n" + "\nSchedule: " + schedule +
		                    "\nData Management: " + dataManagementRoom + "\nObject-Oriented Programming: " + OOPRoom +
		                    "\nCalculus: " + calculusRoom + "\nWeb Application Development: " + webAppDevRoom +
		                    "\nCybersecurity: " + cybersecurityRoom);

		            // Proceed to EnrollmentRecords screen
		            EnrollmentRecords enrollRec = new EnrollmentRecords();
		            enrollRec.setVisible(true);

		        } catch (SQLException ex) {
		            ex.printStackTrace();
		            JOptionPane.showMessageDialog(null, "Error occurred while processing the enrollment: " + ex.getMessage());
		        } catch (NumberFormatException nfe) {
		            JOptionPane.showMessageDialog(null, "Invalid student ID. Please enter a valid numeric ID.");
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
		        String enteredID = studentID.getText().trim(); // Retrieve entered student ID

		        if (enteredID.isEmpty()) {
		            JOptionPane.showMessageDialog(null, "Please enter a student ID.");
		            return;
		        }

		        String sql = "SELECT * FROM students WHERE idNumber = ?";
		        
		        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb", "root", null);
		             PreparedStatement stmt = connection.prepareStatement(sql)) {
		            
		            stmt.setInt(1, Integer.parseInt(enteredID)); // Set the student ID in the query
		            ResultSet rs = stmt.executeQuery(); // Execute the query

		            if (rs.next()) {
		                // Retrieve the student data from the result set
		                String id = rs.getString("idNumber");
		                String firstName = rs.getString("FirstName");
		                String lastName = rs.getString("LastName");
		                String gradeLevel = String.valueOf(rs.getInt("GradeLevel"));
		                String program = rs.getString("PROGRAM");

		                // Display the found student data
		                JOptionPane.showMessageDialog(null, "Student found: " + id + "\nName: " + firstName + " " + lastName + "\nGrade Level: " + gradeLevel + "\nProgram: " + program);

		                // Set the text fields with the retrieved student data
		                txtFirstName.setText(firstName);
		                txtFirstName.setEditable(false);
		                txtLastName.setText(lastName);
		                txtLastName.setEditable(false);
		                txtGradeLevel.setText(gradeLevel);
		                txtGradeLevel.setEditable(false);
		                txtProgram.setText(program);
		                txtProgram.setEditable(false);

		                int gradeLevelInt = Integer.parseInt(gradeLevel);
		                
		                // Enable beginner or advanced courses based on grade level
		                if (gradeLevelInt >= 1 && gradeLevelInt <= 2) {
		                    btnBeginnerCourse.setEnabled(true);
		                    btnadvancedCourse.setEnabled(false);
		                } else if (gradeLevelInt >= 3 && gradeLevelInt <= 4) {
		                    btnBeginnerCourse.setEnabled(false);
		                    btnadvancedCourse.setEnabled(true);
		                }

		            } else {
		                // If no student is found
		                JOptionPane.showMessageDialog(null, "Student not found!");
		            }

		        } catch (SQLException ex) {
		            ex.printStackTrace();
		            JOptionPane.showMessageDialog(null, "Error retrieving records from database. Please try again.");
		        } catch (NumberFormatException nfe) {
		            JOptionPane.showMessageDialog(null, "Invalid student ID. Please enter a valid numeric ID.");
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
