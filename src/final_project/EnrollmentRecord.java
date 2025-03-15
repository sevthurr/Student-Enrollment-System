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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EnrollmentRecord extends StudentEnrollment {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EnrollmentRecord frame = new EnrollmentRecord();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					JOptionPane.showMessageDialog(null, "Welcome Student!");
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public EnrollmentRecord() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\kayem\\Pictures\\k++\\2.png"));
		setTitle("Enrollment Record");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1125, 662);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//TABLE TO DISPLAY ENROLLMENT RECORDS
		JScrollPane EnrollmentRecords = new JScrollPane();
		EnrollmentRecords.setToolTipText("Enrollment records");
		EnrollmentRecords.setEnabled(false);
		EnrollmentRecords.setBounds(38, 120, 1051, 353);
		contentPane.add(EnrollmentRecords);
		
		JTable table = new JTable();
        DefaultTableModel model = (DefaultTableModel) table.getModel();
		EnrollmentRecords.setViewportView(table);
		
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Student", "Schedule", "Course 1", "Course 2", "Course 3", "Course 4", "Course 5"
			}
		));
		 
		JPanel panel = new JPanel();
		panel.setBackground(Color.RED);
		panel.setBounds(0, 0, 1111, 40);
		contentPane.add(panel);
		
		JLabel lblStudentRecords = new JLabel("Enrollment Record");
		lblStudentRecords.setForeground(Color.WHITE);
		lblStudentRecords.setFont(new Font("Gill Sans MT", Font.BOLD, 25));
		panel.add(lblStudentRecords);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.RED);
		panel_1.setBounds(0, 612, 1111, 14);
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
		btnBackToRegistration.setBounds(936, 504, 153, 23);
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
		btnExit.setBounds(988, 538, 101, 23);
		contentPane.add(btnExit);
		
		JButton btnDisplayRecords = new JButton("Display Records");
		btnDisplayRecords.setToolTipText("Click to display enrollment records");
		btnDisplayRecords.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
			        Scanner ifile = new Scanner(new FileReader("enroll.txt"));
			        DefaultTableModel model = (DefaultTableModel) table.getModel();
			        String rec;
			        String[] details;
			        model.setRowCount(0);

			        while (ifile.hasNext()) {
			            rec = ifile.nextLine();
			            details = rec.split(":");
		                model.addRow(details);
			        }
			        ifile.close();
			    } catch (IOException e1) {
			        e1.printStackTrace();
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
