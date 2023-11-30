package com.example;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ChangeEvent;

public class AmountSelector extends JDialog {
	public AmountSelector(Window owner) {
		super(owner);
		initComponents();
	}

	private void initComponents() {
		int maxCoins = App.statics.getCoins();

		slider = new JSlider(5,maxCoins,maxCoins/2);
		currentLabel = new JLabel();
		minLabel = new JLabel();
		maxLabel = new JLabel();
		okButton = new JButton();
		value = new JLabel();

		Container contentPane = getContentPane();
		contentPane.setLayout(null);
		contentPane.add(slider);
		slider.setBounds(65, 140, 260, slider.getPreferredSize().height);
		slider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				value.setText(slider.getValue() + "");
			}
		});

		currentLabel.setText("Your current amount: "+ maxCoins + " coins");
		contentPane.add(currentLabel);
		currentLabel.setBounds(new Rectangle(new Point(110, 55), currentLabel.getPreferredSize()));

		minLabel.setText("Min: 5 coins");
		contentPane.add(minLabel);
		minLabel.setBounds(new Rectangle(new Point(60, 120), minLabel.getPreferredSize()));

		maxLabel.setText("Max: "+ maxCoins + " coins");
		contentPane.add(maxLabel);
		maxLabel.setBounds(new Rectangle(new Point(280, 120), maxLabel.getPreferredSize()));

		value.setText(slider.getValue() + "");
		contentPane.add(value);
		value.setBounds(185,175,40,16);

		okButton.setText("OK");
		contentPane.add(okButton);
		okButton.setBounds(new Rectangle(new Point(300, 225), okButton.getPreferredSize()));
		okButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Player player = new Player();
				player.addCoin(slider.getValue());
				App.statics.setCoins(App.statics.getCoins() - slider.getValue());
				Game game = new Game(player);
				game.setSize(new Dimension(900, 650));
				game.setVisible(true);
				dispose();
			}
		});

		contentPane.setPreferredSize(new Dimension(400, 300));
		pack();
		setLocationRelativeTo(getOwner());
	}

	private JSlider slider;
	private JLabel currentLabel;
	private JLabel minLabel;
	private JLabel maxLabel;
	private JButton okButton;
	private JLabel value;
}
