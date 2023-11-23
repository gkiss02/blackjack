package com.example;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
/*
 * Created by JFormDesigner on Thu Nov 23 11:26:02 CET 2023
 */



/**
 * @author kissgabor
 */
public class GameoverModal extends JDialog {
	public GameoverModal(Window owner, String message) {
		super(owner);
		initComponents(message);
	}

	private void initComponents(String message) {
		dialogPane = new JPanel();
		buttonBar = new JPanel();
		okButton = new JButton();
		label4 = new JLabel();

		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());

		dialogPane.setLayout(null);
			
		buttonBar.setBorder(new EmptyBorder(12, 0, 0, 0));
		buttonBar.setLayout(new GridBagLayout());
		((GridBagLayout)buttonBar.getLayout()).columnWidths = new int[] {0, 80};
		((GridBagLayout)buttonBar.getLayout()).rowHeights = new int[] {0, 0};
		((GridBagLayout)buttonBar.getLayout()).columnWeights = new double[] {1.0, 0.0};
		((GridBagLayout)buttonBar.getLayout()).rowWeights = new double[] {0.0, 1.0E-4};

		okButton.setText("New Game");
		buttonBar.add(okButton, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(0, 0, 0, 0), 0, 0));
			
		dialogPane.add(buttonBar);
		buttonBar.setBounds(12, 218, 374, buttonBar.getPreferredSize().height);

		label4.setText(message.toUpperCase() + "!");
		dialogPane.add(label4);
		label4.setBounds(new Rectangle(new Point(175, 115), label4.getPreferredSize()));
		
		
		contentPane.add(dialogPane, BorderLayout.CENTER);
		pack();
		setLocationRelativeTo(getOwner());
	}

	private JPanel dialogPane;
	private JPanel buttonBar;
	private JButton okButton;
	private JLabel label4;

}

