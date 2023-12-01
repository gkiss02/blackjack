package com.example;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.*;

public class LoginModal extends JDialog {
	public LoginModal(Window owner, String text1, String text2) {
		super(owner);
		initComponents(text1,text2);
	}

	private void initComponents(String text1, String text2) {
		dialogPane = new JPanel();
		contentPanel = new JPanel();
		panel = new JPanel();
		welcomeText1 = new JLabel();
		welcomeText2 = new JLabel();
		buttonBar = new JPanel();
		okButton = new JButton();

		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());
		
		dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));

		dialogPane.setLayout(new BorderLayout());

		contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.X_AXIS));
				
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		welcomeText1.setText(text1);
		panel.add(welcomeText1);

		welcomeText2.setText(text2);
		panel.add(welcomeText2);
				
		contentPanel.add(panel);
			
		dialogPane.add(contentPanel, BorderLayout.CENTER);

		buttonBar.setBorder(new EmptyBorder(12, 0, 0, 0));
		buttonBar.setLayout(new GridBagLayout());
		((GridBagLayout)buttonBar.getLayout()).columnWidths = new int[] {0, 80};
		((GridBagLayout)buttonBar.getLayout()).columnWeights = new double[] {1.0, 0.0};

		okButton.setText("OK");
		buttonBar.add(okButton, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(0, 0, 0, 0), 0, 0));

		okButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent e) {
				dispose();
			}
		});

		dialogPane.add(buttonBar, BorderLayout.SOUTH);
		
		contentPane.add(dialogPane, BorderLayout.CENTER);
		pack();
		setLocationRelativeTo(getOwner());
	}
	private JPanel dialogPane;
	private JPanel contentPanel;
	private JPanel panel;
	private JLabel welcomeText1;
	private JLabel welcomeText2;
	private JPanel buttonBar;
	private JButton okButton;
}
