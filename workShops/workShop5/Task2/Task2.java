/*
Student Name: Amir Aminzadeh
Student Number: 126554187
Date: 2019-10-26
*/

package com.senecacollege.task2.java;

public class Task2 extends javax.swing.JFrame {

	public Task2() {// This constructor is for initializing the different button and textField and
					// label
		initComponents();
		setTitle("Address Book");// This statement identify the title
	}

	private void initComponents() {// This method defines different nodes based on their classes

		jButtonAdd = new javax.swing.JButton();// Add
		jButtonFirst = new javax.swing.JButton();// First
		jButtonNext = new javax.swing.JButton();// Next
		jButtonPrevious = new javax.swing.JButton();// Previous
		jButtonLast = new javax.swing.JButton();// Last
		jButtonUpdate = new javax.swing.JButton();//Update
		jLabel1 = new javax.swing.JLabel();// Label1
		jLabel2 = new javax.swing.JLabel();// label2
		jTextFieldFirstName = new javax.swing.JTextField();// First Name
		jTextFieldLastName = new javax.swing.JTextField();// Last Name
		jLabel3 = new javax.swing.JLabel();// Label3
		jTextFieldCity = new javax.swing.JTextField();// City
		jLabel4 = new javax.swing.JLabel();// Label4
		jComboBoxProvince = new javax.swing.JComboBox();// Province
		jLabel5 = new javax.swing.JLabel();// Label5
		jTextFieldPostalCode = new javax.swing.JTextField();// Postal Code

		// This statement is for closing the stage
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		// These statements is foe setting the texts
		jButtonAdd.setText("Add");

		jButtonFirst.setText("First");

		jButtonNext.setText("Next");

		jButtonPrevious.setText("Previous");

		jButtonLast.setText("Last");

		jButtonUpdate.setText("Update");

		jLabel1.setText("First Name: ");

		jLabel2.setText("Last Name: ");

		jLabel3.setText("City: ");

		jLabel4.setText("Province: ");

		jLabel5.setText("Postal Code: ");

		// These codes are made by part of designing at netBeans
		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup()
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup().addGap(33, 33, 33)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addGroup(layout.createSequentialGroup().addComponent(jLabel3)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(jTextFieldCity, javax.swing.GroupLayout.PREFERRED_SIZE,
														94, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(jLabel4)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(jComboBoxProvince, javax.swing.GroupLayout.PREFERRED_SIZE,
														104, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(jLabel5)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(jTextFieldPostalCode))
										.addGroup(layout.createSequentialGroup().addComponent(jLabel2)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(jTextFieldLastName))
										.addGroup(layout.createSequentialGroup().addComponent(jLabel1)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(jTextFieldFirstName,
														javax.swing.GroupLayout.PREFERRED_SIZE, 394,
														javax.swing.GroupLayout.PREFERRED_SIZE))))
						.addGroup(layout.createSequentialGroup()
								.addComponent(jButtonAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 80,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jButtonFirst, javax.swing.GroupLayout.PREFERRED_SIZE, 82,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jButtonNext, javax.swing.GroupLayout.PREFERRED_SIZE, 81,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jButtonPrevious, javax.swing.GroupLayout.PREFERRED_SIZE, 81,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jButtonLast, javax.swing.GroupLayout.PREFERRED_SIZE, 83,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jButtonUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 80,
										javax.swing.GroupLayout.PREFERRED_SIZE)))
				.addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup().addGap(24, 24, 24).addGroup(layout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel1)
								.addComponent(jTextFieldFirstName, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(25, 25, 25)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(jLabel2).addComponent(jTextFieldLastName,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(26, 26, 26)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(jLabel3)
										.addComponent(jTextFieldCity, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(jLabel4)
										.addComponent(jComboBoxProvince, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(jLabel5)
										.addComponent(jTextFieldPostalCode, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(jButtonAdd).addComponent(jButtonFirst).addComponent(jButtonNext)
										.addComponent(jButtonPrevious).addComponent(jButtonLast)
										.addComponent(jButtonUpdate))
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		pack();
	}



	public static void main(String args[]) {

		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(Task2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(Task2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(Task2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(Task2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}

		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Task2().setVisible(true);
			}
		});
	}

	private javax.swing.JButton jButtonAdd;
	private javax.swing.JButton jButtonFirst;
	private javax.swing.JButton jButtonLast;
	private javax.swing.JButton jButtonNext;
	private javax.swing.JButton jButtonPrevious;
	private javax.swing.JButton jButtonUpdate;
	private javax.swing.JComboBox jComboBoxProvince;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JTextField jTextFieldCity;
	private javax.swing.JTextField jTextFieldFirstName;
	private javax.swing.JTextField jTextFieldLastName;
	private javax.swing.JTextField jTextFieldPostalCode;

}
