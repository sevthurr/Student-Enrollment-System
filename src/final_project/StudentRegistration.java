package final_project;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.io.*;
import java.util.Scanner;

import javax.swing.border.BevelBorder;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class StudentRegistration extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField firstName;
	private JTextField lastName;
	public JTable table;
	private int idCounter = 1;
	private String[] gradeLevel = {"Choose grade level", "1", "2", "3", "4"};
	private String[] program = {"Choose program", "Information Technology", "Computer Science", "Computer Engineering", "Software Engineering"};

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentRegistration frame = new StudentRegistration();
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
	
	public String [] getProgram () {
		return program;
	}
	public String[] getGradeLevel() {
		return gradeLevel;
	}
	
	public void setGradeLevel(String[] gradeLevel) {
		this.gradeLevel = gradeLevel;
	}
	
	public String getFirstName() {
		return firstName.getText();
	}

	public String getLastName() {
		return lastName.getText(); 
	}
	  
	public String generateID() {
		int minDigit = 100000;
		int maxDigit = 999999;
		int randomId = (int) (Math.random() * ((maxDigit - minDigit) + 1)) + minDigit;
		return String.valueOf(randomId);
	}
	

	public StudentRegistration() {
		setTitle("Student Registration");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\kayem\\Pictures\\k++\\2.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1165, 589);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setFont(new Font("Gill Sans MT", Font.BOLD, 16));
		lblFirstName.setBounds(44, 130, 103, 30);
		contentPane.add(lblFirstName);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 0, 0));
		panel.setBounds(0, 0, 1141, 40);
		contentPane.add(panel);
		
		JLabel Title = new JLabel("Student Registration");
		Title.setForeground(new Color(255, 255, 255));
		panel.add(Title);
		Title.setFont(new Font("Gill Sans MT", Font.BOLD, 25));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.RED);
		panel_1.setBounds(0, 538, 1141, 14);
		contentPane.add(panel_1);
		
		firstName = new JTextField();
		firstName.setToolTipText("Enter first name");
		firstName.setFont(new Font("Gill Sans MT", Font.PLAIN, 13));
		firstName.setBounds(157, 133, 202, 26);
		contentPane.add(firstName);
		firstName.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("Gill Sans MT", Font.BOLD, 16));
		lblLastName.setBounds(44, 189, 103, 30);
		contentPane.add(lblLastName);
		
		JLabel lblGradeLevel = new JLabel("Grade Level");
		lblGradeLevel.setFont(new Font("Gill Sans MT", Font.BOLD, 16));
		lblGradeLevel.setBounds(44, 247, 103, 30);
		contentPane.add(lblGradeLevel);
		
		lastName = new JTextField();
		lastName.setToolTipText("Enter last name");
		lastName.setFont(new Font("Gill Sans MT", Font.PLAIN, 13));
		lastName.setColumns(10);
		lastName.setBounds(157, 192, 202, 26);
		contentPane.add(lastName);
		
		JLabel lblProgram = new JLabel("Program");
		lblProgram.setFont(new Font("Gill Sans MT", Font.BOLD, 16));
		lblProgram.setBounds(44, 298, 103, 30);
		contentPane.add(lblProgram);
		
		JComboBox<String> gLevel = new JComboBox<String>(gradeLevel);
		gLevel.setFont(new Font("Gill Sans MT", Font.PLAIN, 13));
		gLevel.setBounds(157, 252, 202, 22);
		contentPane.add(gLevel);
		
		JComboBox<String> prog = new JComboBox<String>(program);
		prog.setFont(new Font("Gill Sans MT", Font.PLAIN, 13));
		prog.setBounds(157, 303, 202, 22);
		contentPane.add(prog);
		
		//REGISTER BUTTON FUNCTION
		JButton btnRegister = new JButton("Register");
		btnRegister.setToolTipText("Click To Generate ID Number");
		btnRegister.setBackground(new Color(255, 0, 0));
		btnRegister.setForeground(new Color(255, 255, 255));
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (firstName.getText().isEmpty() || lastName.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "First Name / Last Name Cannot Be Empty!");
					return;
				}
				if (gLevel.getSelectedIndex() == 0 || prog.getSelectedIndex() == 0) {
					JOptionPane.showMessageDialog(null, "Select Your Grade Level / Program");
				} else {
					int selectedGradeLevel = Integer.parseInt(gLevel.getSelectedItem().toString());
					String id = generateID();
					JOptionPane.showMessageDialog(null, "Registered Successfully! \nID Number: " + id);
					try {
						PrintWriter outfile = new PrintWriter(new FileWriter("stud.txt", true));
						Scanner ifile = new Scanner(new FileReader("stud.txt"));
						DefaultTableModel model = (DefaultTableModel) table.getModel();
						
						String rec;
						String[] details;
						model.setRowCount(0);
						String fname = firstName.getText();
						//Capitalize the first letter
						if (!fname.isEmpty()) {
						    fname = fname.substring(0, 1).toUpperCase() + fname.substring(1);
						}
						String lname = lastName.getText();						
						if (!lname.isEmpty()) {
						    lname = lname.substring(0, 1).toUpperCase() + lname.substring(1);
						}
						String gradeLevel = (String) gLevel.getSelectedItem();
						String program = (String) prog.getSelectedItem();
						outfile.println(id + " : " + fname + " : " + lname + " : " + gradeLevel + " : " + program + " : ");
						outfile.close();
						
						while (ifile.hasNext()) {
							rec = ifile.nextLine();
							details = rec.split(":");
							model.addRow(details);
						}
					} catch (IOException e) {
						e.printStackTrace();
		                JOptionPane.showMessageDialog(null, "Registration Failed" +
		                							  "\nCheck if you entered all the fields");
					}
					
					firstName.setText("");
					lastName.setText("");
					gLevel.setSelectedIndex(0);
					prog.setSelectedIndex(0);
				}
			}
		});
		
		btnRegister.setFont(new Font("Gill Sans MT", Font.BOLD, 12));
		btnRegister.setBounds(225, 349, 134, 23);
		contentPane.add(btnRegister);
		
		//UPDATE BUTTON FUNCTION
				JButton btnUpdateRecord = new JButton("Update Record");
				btnUpdateRecord.setToolTipText("Click to update record");
				btnUpdateRecord.setBackground(new Color(255, 255, 255));
				btnUpdateRecord.setForeground(new Color(255, 0, 0));
				btnUpdateRecord.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
						DefaultTableModel model = (DefaultTableModel) table.getModel();
						
						if (table.getSelectedRowCount() == 1) {
							String newFirstName = firstName.getText();
							String newLastName = lastName.getText();
							String newGradeLevel = (String) gLevel.getSelectedItem();
							String newProgram = (String) prog.getSelectedItem();
							
							int selectedRow = table.getSelectedRow();
							String idNumber = (String) model.getValueAt(selectedRow, 0);
							
							model.setValueAt(newFirstName, selectedRow, 1);
							model.setValueAt(newLastName, selectedRow, 2);
							model.setValueAt(newGradeLevel, selectedRow, 3);
							model.setValueAt(newProgram, selectedRow, 4);
							
							btnRegister.setEnabled(false);
								try {
									PrintWriter outfile = new PrintWriter(new FileWriter("stud.txt"));
									for (int row = 0; row < model.getRowCount(); row++) {
										String currentIdNumber = (String) model.getValueAt(row, 0);
										String firstName = (String) model.getValueAt(row, 1);
										String lastName = (String) model.getValueAt(row, 2);
										String gradeLevel = (String) model.getValueAt(row, 3);
										String program = (String) model.getValueAt(row, 4);
										
										outfile.println(currentIdNumber + ":" + firstName + ":" + lastName + ":" + gradeLevel + ":" + program + ":");
									}
								outfile.close();
							} catch (IOException ex) {
								ex.printStackTrace();
							}
							
							JOptionPane.showMessageDialog(null, "Record Update Successful!");
							btnRegister.setEnabled(true);
						
						} else {
							JOptionPane.showMessageDialog(null, "Please select a single row to update.");
						}
						
						firstName.setText("");
						lastName.setText("");
						gLevel.setSelectedIndex(0);
						prog.setSelectedIndex(0);
					}
				});
				
				btnUpdateRecord.setFont(new Font("Gill Sans MT", Font.BOLD, 12));
				btnUpdateRecord.setBounds(61, 429, 134, 23);
				contentPane.add(btnUpdateRecord);
				
		//DELETE BUTTON FUNCTION
		JButton btnDeleteRecord = new JButton("Delete Record");
		btnDeleteRecord.setToolTipText("Click to delete record");
		btnDeleteRecord.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent arg0) {
		        DefaultTableModel model = (DefaultTableModel) table.getModel();
		        int selectedRowIndex = table.getSelectedRow();

		        if (selectedRowIndex != -1) {
		            model.removeRow(selectedRowIndex);
		            try {
		                File originalFile = new File("stud.txt");
		                PrintWriter writer = new PrintWriter(new FileWriter(originalFile));

		                for (int row = 0; row < model.getRowCount(); row++) {
		                    String currentIdNumber = (String) model.getValueAt(row, 0);
		                    String firstName = (String) model.getValueAt(row, 1);
		                    String lastName = (String) model.getValueAt(row, 2);
		                    String gradeLevel = (String) model.getValueAt(row, 3);
		                    String program = (String) model.getValueAt(row, 4);

		                    writer.println(currentIdNumber + ":" + firstName + ":" + lastName + ":" + gradeLevel + ":" + program + ":");
		                }
		                writer.close();
		            } catch (IOException e) {
		                e.printStackTrace();
		                JOptionPane.showMessageDialog(null, "Failed to update record in the file.");
		            }
		            JOptionPane.showMessageDialog(null, "Record deleted successfully.");
		        }
		    }
		});

		
		btnDeleteRecord.setBackground(new Color(255, 255, 255));
		btnDeleteRecord.setForeground(new Color(255, 0, 0));
		btnDeleteRecord.setFont(new Font("Gill Sans MT", Font.BOLD, 12));
		btnDeleteRecord.setBounds(225, 463, 134, 23);
		contentPane.add(btnDeleteRecord);
		
		JLabel lblStudentRecords = new JLabel("Student Records");
		lblStudentRecords.setForeground(new Color(0, 0, 0));
		lblStudentRecords.setFont(new Font("Gill Sans MT", Font.BOLD, 20));
		lblStudentRecords.setBounds(664, 72, 219, 30);
		contentPane.add(lblStudentRecords);
		
		JScrollPane StudentRecords = new JScrollPane();
		StudentRecords.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				btnRegister.setEnabled(false);
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				String tblIDNumber = (String) model.getValueAt(table.getSelectedRow(), 0);
				String tblFirstName = (String) model.getValueAt(table.getSelectedRow(), 1);
				String tblLastName = (String) model.getValueAt(table.getSelectedRow(), 2);
				String tblGradeLevel = (String) model.getValueAt(table.getSelectedRow(), 3);
				String tblProgram = (String) model.getValueAt(table.getSelectedRow(), 4);
				
				firstName.setText(tblFirstName);
				lastName.setText(tblLastName);
				gLevel.setSelectedIndex(0);
				prog.setSelectedIndex(0);
				prog.setSelectedItem(tblProgram);
			}
		});
		StudentRecords.setBounds(435, 113, 660, 295);
		contentPane.add(StudentRecords);
		
		table = new JTable();
		StudentRecords.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID Number", "First Name", "Last Name", "Grade Level", "Program"
			}
		));
		
		
		JButton btnEnrollment = new JButton("Proceed To Enrollment");
		btnEnrollment.setToolTipText("Click to enroll");
		btnEnrollment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {				
				StudentEnrollment enroll = new StudentEnrollment();
				enroll.setVisible(true);				
			}	
		});
		btnEnrollment.setForeground(Color.WHITE);
		btnEnrollment.setFont(new Font("Gill Sans MT", Font.BOLD, 12));
		btnEnrollment.setBackground(Color.RED);
		btnEnrollment.setBounds(930, 429, 167, 23);
		contentPane.add(btnEnrollment);
		
		JButton btnCancel = new JButton("Exit");
		btnCancel.setToolTipText("Click to exit");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int choice = JOptionPane.showConfirmDialog(null, "Do you want to exit?", "Confirmation", JOptionPane.YES_NO_CANCEL_OPTION);
		        if (choice == JOptionPane.YES_OPTION) {
		            System.exit(0);
		        } else if (choice == JOptionPane.NO_OPTION || choice == JOptionPane.CANCEL_OPTION) {
		        }
		    }
		});
		btnCancel.setForeground(Color.RED);
		btnCancel.setFont(new Font("Gill Sans MT", Font.PLAIN, 12));
		btnCancel.setBackground(Color.WHITE);
		btnCancel.setBounds(994, 463, 101, 23);
		contentPane.add(btnCancel);
		
		//DISPLAY RECORDS FUNCTION
		JButton btnDisplayRecords = new JButton("Display Records");
		btnDisplayRecords.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
			        Scanner ifile = new Scanner(new FileReader("stud.txt"));
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
			        JOptionPane.showMessageDialog(null, "Cannot display records" +
			        								"\nCheck the file path");
			    }
			}
		});
		
		btnDisplayRecords.setToolTipText("Click To Display Records");
		btnDisplayRecords.setForeground(new Color(255, 255, 255));
		btnDisplayRecords.setFont(new Font("Gill Sans MT", Font.BOLD, 12));
		btnDisplayRecords.setBackground(new Color(255, 0, 0));
		btnDisplayRecords.setBounds(61, 463, 134, 23);
		contentPane.add(btnDisplayRecords);
		
		JButton btnCancelUpdate = new JButton("Cancel Update");
		btnCancelUpdate.setToolTipText("Click to cancel update");
		btnCancelUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnRegister.setEnabled(true);
				firstName.setText("");
				lastName.setText("");
				gLevel.setSelectedIndex(0);
				prog.setSelectedIndex(0);
			}
		});
		btnCancelUpdate.setForeground(Color.WHITE);
		btnCancelUpdate.setFont(new Font("Gill Sans MT", Font.BOLD, 12));
		btnCancelUpdate.setBackground(Color.RED);
		btnCancelUpdate.setBounds(225, 429, 134, 23);
		contentPane.add(btnCancelUpdate);
	}
}