package final_project;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EnrollmentRecords extends EnrollmentForm {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EnrollmentRecords frame = new EnrollmentRecords();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public EnrollmentRecords() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\kayem\\Pictures\\k++\\2.png"));
		setTitle("Enrollment Record");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1174, 669);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//TABLE TO DISPLAY ENROLLMENT RECORDS
		JScrollPane EnrollmentRecords = new JScrollPane();
        EnrollmentRecords.setToolTipText("Enrollment records");
        EnrollmentRecords.setEnabled(false);
        EnrollmentRecords.setBounds(38, 120, 1088, 373);
        contentPane.add(EnrollmentRecords);

        JTable table = new JTable();
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        EnrollmentRecords.setViewportView(table);

        table.setModel(new DefaultTableModel(
                new Object[][]{},
                new String[]{
                        "Student", "Schedule", "Year", "Class Code", "Class Code", "Class Code", "Class Code", "Class Code"
                }
        ));
        
		 
		JPanel panel = new JPanel();
		panel.setBackground(Color.RED);
		panel.setBounds(0, 0, 1148, 40);
		contentPane.add(panel);
		
		JLabel lblStudentRecords = new JLabel("Enrollment Record");
		lblStudentRecords.setForeground(Color.WHITE);
		lblStudentRecords.setFont(new Font("Gill Sans MT", Font.BOLD, 25));
		panel.add(lblStudentRecords);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.RED);
		panel_1.setBounds(0, 612, 1148, 14);
		contentPane.add(panel_1);
		
		JButton btnBackToRegistration = new JButton("Back To Registration");
		btnBackToRegistration.setToolTipText("Click to register again");
		btnBackToRegistration.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentRegistration register = new StudentRegistration();
				register.setVisible(true);
			}
		});
		btnBackToRegistration.setForeground(Color.WHITE);
		btnBackToRegistration.setFont(new Font("Gill Sans MT", Font.BOLD, 12));
		btnBackToRegistration.setBackground(Color.RED);
		btnBackToRegistration.setBounds(936, 520, 153, 23);
		contentPane.add(btnBackToRegistration);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setToolTipText("Click to exit program");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int choice = JOptionPane.showConfirmDialog(null, "Do you want to exit?", "Confirmation", JOptionPane.YES_NO_CANCEL_OPTION);
		        if (choice == JOptionPane.YES_OPTION) {
		            System.exit(0);
		        } else if (choice == JOptionPane.NO_OPTION || choice == JOptionPane.CANCEL_OPTION) {
		        }
			}
		});
		btnExit.setForeground(Color.RED);
		btnExit.setFont(new Font("Gill Sans MT", Font.PLAIN, 12));
		btnExit.setBackground(Color.WHITE);
		btnExit.setBounds(988, 553, 101, 23);
		contentPane.add(btnExit);
		
		
		JButton btnDisplayRecords = new JButton("Display Records");
		btnDisplayRecords.setToolTipText("Click to display enrollment records");
		btnDisplayRecords.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent arg0) {
		        String sql = "SELECT er.enrollment_id, s.idNumber, s.FirstName, s.LastName, s.GradeLevel, sch.schedule_name, " +
		                "GROUP_CONCAT(CONCAT(ec.room) ORDER BY c.course_id SEPARATOR ', ') AS courses " +
		                "FROM EnrollmentRecord er " +
		                "JOIN students s ON er.student_id = s.idNumber " +
		                "JOIN Schedule sch ON er.schedule_id = sch.schedule_id " +
		                "JOIN EnrollmentCourses ec ON er.enrollment_id = ec.enrollment_id " +
		                "JOIN Course c ON ec.course_id = c.course_id " +
		                "GROUP BY er.enrollment_id";

		        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb", "root", null);
		             Statement stmt = connection.createStatement();
		             ResultSet rs = stmt.executeQuery(sql)) {

		            DefaultTableModel model = (DefaultTableModel) table.getModel();
		            model.setRowCount(0);

		            if (!rs.isBeforeFirst()) {
		                JOptionPane.showMessageDialog(null, "No enrollments available at the moment.");
		                return;
		            }

		            while (rs.next()) {
		                String idNumber = rs.getString("idNumber");
		                String studentName = rs.getString("FirstName") + " " + rs.getString("LastName");
		                String student = "" + idNumber + " - " + studentName + "";
		                String schedule = rs.getString("schedule_name");
		                String gradeLevel = rs.getString("GradeLevel");

		                String[] courses = rs.getString("courses").split(", ");

		                // Populate the row with the formatted student data
		                Object[] row = new Object[8];
		                row[0] = student; 
		                row[1] = schedule;
		                row[2] = gradeLevel;

		                for (int i = 0; i < courses.length && i < 5; i++) {
		                    row[i + 3] = courses[i];
		                }

		                model.addRow(row);
		            }

		        } catch (SQLException ex) {
		            ex.printStackTrace();
		            JOptionPane.showMessageDialog(null, "Cannot display records\nCheck the database connection.");
		        }
		    }
		});


		
		btnDisplayRecords.setForeground(Color.WHITE);
		btnDisplayRecords.setFont(new Font("Gill Sans MT", Font.BOLD, 12));
		btnDisplayRecords.setBackground(Color.RED);
		btnDisplayRecords.setBounds(38, 75, 153, 23);
		contentPane.add(btnDisplayRecords);
	}
}
