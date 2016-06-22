package ui;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import models.RegularModeModel;

public class RegularModeJPanel extends JPanel {

	private static final long serialVersionUID = -9218456470600280075L;
	private JTextArea inputDisplay = new JTextArea(1, 20);
	
	JPanel[] panelRows = new JPanel[6];
	Double firstValue;
	Double secondValue;
	String functionValue;
	
	private RegularModeModel regularModeModel;
	
	private JButton zeroButton, oneButton, twoButton, threeButton, fourButton, fiveButton, sixButton, sevenButton, eightButton, nineButton, decimalButton;
	private JButton plusButton, minusButton, multiplyButton, divideButton, squareButton, squareRootButton, posNegButton, clearButton, equalsButton;
	
	private Font textFont;
	private Font buttonFont;
	
	Dimension inputDisplayDimension = new Dimension(335, 50);
	Dimension buttonDimension = new Dimension(80, 50);
	
	public RegularModeJPanel() {
		
		BoxLayout grid = new BoxLayout(this, BoxLayout.PAGE_AXIS);
		setLayout(grid);
		
		regularModeModel = new RegularModeModel();
		
		textFont = new Font("Courier New", Font.PLAIN, 24);
		buttonFont = new Font("Arial", Font.CENTER_BASELINE, 38);
		
		setupRegularModeButtons();
		
		for (int i = 0; i < 6; i++) {
			panelRows[i] = new JPanel();
		}
		
		inputDisplay.setEditable(false);
		inputDisplay.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		inputDisplay.setPreferredSize(inputDisplayDimension);
		inputDisplay.setFont(textFont);
		inputDisplay.setBorder(BorderFactory.createTitledBorder("Answer"));
		
		panelRows[0].add(inputDisplay);
		add(panelRows[0]);
		
		panelRows[1].add(clearButton);
		panelRows[1].add(squareButton);
		panelRows[1].add(squareRootButton);
		panelRows[1].add(divideButton);
		
		panelRows[2].add(sevenButton);
		panelRows[2].add(eightButton);
		panelRows[2].add(nineButton);
		panelRows[2].add(multiplyButton);
		
		panelRows[3].add(fourButton);
		panelRows[3].add(fiveButton);
		panelRows[3].add(sixButton);
		panelRows[3].add(minusButton);

		panelRows[4].add(oneButton);
		panelRows[4].add(twoButton);
		panelRows[4].add(threeButton);
		panelRows[4].add(plusButton);
		
		panelRows[5].add(posNegButton);
		panelRows[5].add(zeroButton);
		panelRows[5].add(decimalButton);
		panelRows[5].add(equalsButton);
		
		add(panelRows[1]);
		add(panelRows[2]);
		add(panelRows[3]);
		add(panelRows[4]);
		add(panelRows[5]);
	}
	
	private class ButtonListener implements ActionListener {
		
		JButton pressedButton;
		
		public ButtonListener(JButton button) {
			this.pressedButton = button;
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			regularModeModel.displayContent(inputDisplay, pressedButton);
		}
	}
	
	private class ActionButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			try {
				if (arg0.getSource() == clearButton) {
					regularModeModel.clearTheDisplay(inputDisplay);
				    firstValue = null;
				    secondValue = null;
				    functionValue = "";
				    decimalButton.setEnabled(true);
				}
				else if (arg0.getSource() == plusButton) {
					functionValue = "addition";
					firstValue = Double.parseDouble(inputDisplay.getText());
					regularModeModel.clearTheDisplay(inputDisplay);
					decimalButton.setEnabled(true);
				}
				else if (arg0.getSource() == minusButton) {
					functionValue = "subtraction";
					firstValue = Double.parseDouble(inputDisplay.getText());
					regularModeModel.clearTheDisplay(inputDisplay);
					decimalButton.setEnabled(true);
				}
				else if (arg0.getSource() == multiplyButton) {
					functionValue = "multiplication";
					firstValue = Double.parseDouble(inputDisplay.getText());
					regularModeModel.clearTheDisplay(inputDisplay);
					decimalButton.setEnabled(true);
				}
				else if (arg0.getSource() == divideButton) {
					functionValue = "division";
					firstValue = Double.parseDouble(inputDisplay.getText());
					regularModeModel.clearTheDisplay(inputDisplay);
					decimalButton.setEnabled(true);
				}
				else if (arg0.getSource() == squareButton) {
					firstValue = Double.parseDouble(inputDisplay.getText());
					regularModeModel.getSquareResult(firstValue, inputDisplay);
				}
				else if (arg0.getSource() == squareRootButton) {
					firstValue = Double.parseDouble(inputDisplay.getText());
					regularModeModel.getSquareRootResult(firstValue, inputDisplay);
				}
				else if (arg0.getSource() == posNegButton) {
					regularModeModel.reverseSignTheResult(inputDisplay);
				}
				else if (arg0.getSource() == equalsButton) {
					if (firstValue != null) {
						secondValue = Double.parseDouble(inputDisplay.getText());
						regularModeModel.equalTheResult(firstValue, secondValue, inputDisplay, functionValue);
						decimalButton.setEnabled(true);
					}
					else {
						// do nothing
					}
				}
			}
			catch (NumberFormatException e) {
			}
		}
	}
	
	private void setupRegularModeButtons() {
		zeroButton = new JButton("0");
		zeroButton.setBorder(null);
		zeroButton.setFont(buttonFont);
		zeroButton.setBackground(Color.WHITE);
		zeroButton.setPreferredSize(buttonDimension);
		zeroButton.addActionListener(new ButtonListener(zeroButton));

		oneButton = new JButton("1");
		oneButton.setBorder(null);
		oneButton.setFont(buttonFont);
		oneButton.setBackground(Color.WHITE);
		oneButton.setPreferredSize(buttonDimension);
		oneButton.addActionListener(new ButtonListener(oneButton));

		twoButton = new JButton("2");
		twoButton.setBorder(null);
		twoButton.setFont(buttonFont);
		twoButton.setBackground(Color.WHITE);
		twoButton.setPreferredSize(buttonDimension);
		twoButton.addActionListener(new ButtonListener(twoButton));

		threeButton = new JButton("3");
		threeButton.setBorder(null);
		threeButton.setFont(buttonFont);
		threeButton.setBackground(Color.WHITE);
		threeButton.setPreferredSize(buttonDimension);
		threeButton.addActionListener(new ButtonListener(threeButton));

		fourButton = new JButton("4");
		fourButton.setBorder(null);
		fourButton.setFont(buttonFont);
		fourButton.setBackground(Color.WHITE);
		fourButton.setPreferredSize(buttonDimension);
		fourButton.addActionListener(new ButtonListener(fourButton));

		fiveButton = new JButton("5");
		fiveButton.setBorder(null);
		fiveButton.setFont(buttonFont);
		fiveButton.setBackground(Color.WHITE);
		fiveButton.setPreferredSize(buttonDimension);
		fiveButton.addActionListener(new ButtonListener(fiveButton));

		sixButton = new JButton("6");
		sixButton.setBorder(null);
		sixButton.setFont(buttonFont);
		sixButton.setBackground(Color.WHITE);
		sixButton.setPreferredSize(buttonDimension);
		sixButton.addActionListener(new ButtonListener(sixButton));
		
		sevenButton = new JButton("7");
		sevenButton.setBorder(null);
		sevenButton.setFont(buttonFont);
		sevenButton.setBackground(Color.WHITE);
		sevenButton.setPreferredSize(buttonDimension);
		sevenButton.addActionListener(new ButtonListener(sevenButton));

		eightButton = new JButton("8");
		eightButton.setBorder(null);
		eightButton.setFont(buttonFont);
		eightButton.setBackground(Color.WHITE);
		eightButton.setPreferredSize(buttonDimension);
		eightButton.addActionListener(new ButtonListener(eightButton));

		nineButton = new JButton("9");
		nineButton.setBorder(null);
		nineButton.setFont(buttonFont);
		nineButton.setBackground(Color.WHITE);
		nineButton.setPreferredSize(buttonDimension);
		nineButton.addActionListener(new ButtonListener(nineButton));

		plusButton = new JButton("+");
		plusButton.setBorder(null);
		plusButton.setFont(buttonFont);
		plusButton.setBackground(Color.LIGHT_GRAY);
		plusButton.setPreferredSize(buttonDimension);
		plusButton.addActionListener(new ActionButtonListener());

		minusButton = new JButton("-");
		minusButton.setBorder(null);
		minusButton.setFont(buttonFont);
		minusButton.setBackground(Color.LIGHT_GRAY);
		minusButton.setPreferredSize(buttonDimension);
		minusButton.addActionListener(new ActionButtonListener());

		multiplyButton = new JButton("x");
		multiplyButton.setBorder(null);
		multiplyButton.setFont(buttonFont);
		multiplyButton.setBackground(Color.LIGHT_GRAY);
		multiplyButton.setPreferredSize(buttonDimension);
		multiplyButton.addActionListener(new ActionButtonListener());

		divideButton = new JButton("/");
		divideButton.setBorder(null);
		divideButton.setFont(buttonFont);
		divideButton.setBackground(Color.LIGHT_GRAY);
		divideButton.setPreferredSize(buttonDimension);
		divideButton.addActionListener(new ActionButtonListener());
		
		equalsButton = new JButton("=");
		equalsButton.setBorder(null);
		equalsButton.setFont(buttonFont);
		equalsButton.setBackground(Color.BLUE);
		equalsButton.setForeground(Color.WHITE);
		equalsButton.setPreferredSize(buttonDimension);
		equalsButton.addActionListener(new ActionButtonListener());
		
		posNegButton = new JButton("+/-");
		posNegButton.setBorder(null);
		posNegButton.setFont(buttonFont);
		posNegButton.setBackground(Color.LIGHT_GRAY);
		posNegButton.setPreferredSize(buttonDimension);
		posNegButton.addActionListener(new ActionButtonListener());

		squareRootButton = new JButton("√");
		squareRootButton.setBorder(null);
		squareRootButton.setFont(buttonFont);
		squareRootButton.setBackground(Color.LIGHT_GRAY);
		squareRootButton.setPreferredSize(buttonDimension);
		squareRootButton.addActionListener(new ActionButtonListener());
		
		decimalButton = new JButton(".");
		decimalButton.setBorder(null);
		decimalButton.setFont(buttonFont);
		decimalButton.setBackground(Color.WHITE);
		decimalButton.setPreferredSize(buttonDimension);
		decimalButton.addActionListener(new ButtonListener(decimalButton));
		
		clearButton = new JButton("C");
		clearButton.setBorder(null);
		clearButton.setFont(buttonFont);
		clearButton.setBackground(Color.RED);
		clearButton.setForeground(Color.WHITE);
		clearButton.setPreferredSize(buttonDimension);
		clearButton.addActionListener(new ActionButtonListener());
		
		squareButton = new JButton("^2");
		squareButton.setBorder(null);
		squareButton.setFont(buttonFont);
		squareButton.setBackground(Color.LIGHT_GRAY);
		squareButton.setPreferredSize(buttonDimension);
		squareButton.addActionListener(new ActionButtonListener());
	}
}