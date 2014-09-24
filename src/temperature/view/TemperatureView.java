package temperature.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.alee.laf.WebLookAndFeel;

public class TemperatureView {
	public JButton convertButton, resetButton, infoButton;
	private JTextField valueTextField;
	private JComboBox unitTemperature;
	private JLabel resultLabel;
	private String [] choices = {"Celsius", "Fahrenheit", "Kelvin"};
	private String info = "Temperature v2\n"
			+"Date created: September 23, 2014\n"
			+"Author: DTT(nise)\n"
			+"Convert temperature to Celcius, Fahrenheit, and Kelvin.\n\n"
			+"Note: This project is used for learning purpose only.";
	
	public TemperatureView() {
		createAndShowGui();
	}

	private void createAndShowGui() {
		setLookAndFeel();
		JFrame mainFrame = new JFrame("Temperature Conversion - v2");
		mainFrame.setContentPane(createContentPanel());
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setPreferredSize(new Dimension(400, 350));
		mainFrame.pack();
		mainFrame.setResizable(false);
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setVisible(true);
		
		// set icon
		ImageIcon icon = new ImageIcon(getClass().getResource("/temperature/images/icon.png"));
		mainFrame.setIconImage(icon.getImage());
	}
	
	private void setLookAndFeel() {
		WebLookAndFeel.install();
		WebLookAndFeel.setDecorateFrames(true);
	}
	
	private JPanel createContentPanel() {
		JPanel mainPanel = new JPanel(new BorderLayout());
		
		// set the left image
		ImageIcon logo = new ImageIcon(getClass().getResource("/temperature/images/temperature_banner.png"));
		JLabel logoLabel = new JLabel(logo);
		logoLabel.setBorder(BorderFactory.createMatteBorder(0,0,1,0,Color.decode("#A09F9F")));
		
		// convert panel
		JPanel convertContainer = new JPanel(new GridBagLayout());
		convertContainer.setBackground(Color.decode("#FDFDFD"));
		GridBagConstraints gc = new GridBagConstraints(); // grid constraint
				
		// add components
		mainPanel.add(logoLabel, BorderLayout.NORTH);
		mainPanel.add(convertContainer, BorderLayout.CENTER);
		
		// value text field
		gc.gridx = 0;
		gc.gridy = 0;
		gc.insets.bottom = 5;
		gc.insets.right = 10;
		JLabel valueLabel = new JLabel("Value:");
		valueLabel.setPreferredSize(new Dimension(130, 30));
		valueLabel.setFont(new Font("Elephant", Font.ITALIC, 17));
		valueLabel.setHorizontalAlignment(4);
		convertContainer.add(valueLabel, gc);
		
		gc.gridx = 1;
		gc.gridy = 0;
		valueTextField = new JTextField();
		valueTextField.setPreferredSize(new Dimension(150, 30));
		convertContainer.add(valueTextField, gc);
		
		// unit combo box
		gc.gridx = 0;
		gc.gridy = 1;
		JLabel unitLabel = new JLabel("Current Unit:");
		unitLabel.setPreferredSize(new Dimension(130, 30));
		unitLabel.setFont(new Font("Elephant", Font.ITALIC, 17));
		unitLabel.setHorizontalAlignment(4);
		convertContainer.add(unitLabel, gc);
		
		gc.gridx = 1;
		gc.gridx = 1;
		unitTemperature = new JComboBox(choices);
		unitTemperature.setPreferredSize(new Dimension(150, 30));
		unitTemperature.setSelectedIndex(0);
		convertContainer.add(unitTemperature, gc);
		
		// result label
		gc.gridx = 0;
		gc.gridy = 2;
		gc.gridwidth = 2;
		gc.insets.bottom = 0;
		gc.fill = GridBagConstraints.BOTH;
		resultLabel = new JLabel("Waiting for input...", SwingConstants.CENTER);
		resultLabel.setBorder(BorderFactory.createLineBorder(Color.decode("#A09F9F")));
		resultLabel.setFont(new Font("Elephant", Font.ITALIC, 20));
		resultLabel.setPreferredSize(new Dimension(150, 60));
		convertContainer.add(resultLabel, gc);
		
		// button panel
		JPanel buttonContainer = new JPanel(new FlowLayout());
		buttonContainer.setBackground(Color.decode("#FDFDFD"));
		convertButton = new JButton("Convert");
		buttonContainer.add(convertButton, gc);
		
		resetButton = new JButton("Reset");
		buttonContainer.add(resetButton, gc);
		
		infoButton = new JButton("About");
		buttonContainer.add(infoButton, gc);
		
		gc.gridx = 0;
		gc.gridy = 3;
		convertContainer.add(buttonContainer, gc);
		
		mainPanel.setOpaque(true);
		return mainPanel;
	}
	
	
	public void setActionListener(ActionListener al) {
		unitTemperature.addActionListener(al);
		convertButton.addActionListener(al);
		resetButton.addActionListener(al);
		infoButton.addActionListener(al);
	}
	
	public void setResultLabel(String s) {
		resultLabel.setText(s);
	}
	
	public double getValueTextField() {
		try {
			return Double.parseDouble(valueTextField.getText());
		} catch(NumberFormatException e) {
			return 0.0;
		}
	}
	
	public int getUnitTemperature() {
		return unitTemperature.getSelectedIndex();
	}
	
	public void reset() {
		valueTextField.setText("");
		unitTemperature.setSelectedIndex(0);
		resultLabel.setText("Waiting for input...");
	}
	
	public void getInfo() {
		JOptionPane.showMessageDialog(null, info);
	}
}