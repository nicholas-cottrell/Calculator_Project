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

import models.ScientificModeModel;

public class ScientificModeJPanel extends JPanel {

	private static final long serialVersionUID = 4616091474856173458L;
	
	private JTextArea inputDisplay = new JTextArea(1, 20);
	JPanel[] panelRows = new JPanel[6];
	Dimension inputDisplayDimension = new Dimension(660, 50);
	Dimension buttonDimension = new Dimension(90, 50);
		
	private JButton zeroButton, oneButton, twoButton, threeButton, fourButton, fiveButton, sixButton, sevenButton,
	eightButton, nineButton, decimalButton;
	private JButton plusButton, minusButton, multiplyButton, divideButton, equalsButton;
	
	private JButton squareButton, squareRootButton, posNegButton, clearButton;
	private JButton exponentButton, sinButton, cosButton, tanButton, tenExponentButton, logButton, piButton,
	factorialButton;
	
	private Font textFont;
	private Font buttonFont;
	
	Double firstValue;
	Double secondValue;
	String functionValue;
	
	private ScientificModeModel scientificModeModel;
		
	public ScientificModeJPanel() {
		BoxLayout grid = new BoxLayout(this, BoxLayout.PAGE_AXIS);
		setLayout(grid);
		
		scientificModeModel = new ScientificModeModel();
		
		textFont = new Font("Courier New", Font.PLAIN, 24);
		buttonFont = new Font("Arial", Font.CENTER_BASELINE, 38);
		
		setupButtons();
		
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
		panelRows[1].add(piButton);
		panelRows[1].add(factorialButton);
		panelRows[1].add(sevenButton);
		panelRows[1].add(eightButton);
		panelRows[1].add(nineButton);
		panelRows[1].add(divideButton);
		
		panelRows[2].add(sinButton);
		panelRows[2].add(cosButton);
		panelRows[2].add(tanButton);
		panelRows[2].add(fourButton);
		panelRows[2].add(fiveButton);
		panelRows[2].add(sixButton);
		panelRows[2].add(multiplyButton);
		
		panelRows[3].add(squareButton);
		panelRows[3].add(squareRootButton);
		panelRows[3].add(exponentButton);
		panelRows[3].add(oneButton);
		panelRows[3].add(twoButton);
		panelRows[3].add(threeButton);
		panelRows[3].add(minusButton);
		
		panelRows[4].add(tenExponentButton);
		panelRows[4].add(logButton);
		panelRows[4].add(posNegButton);
		panelRows[4].add(zeroButton);
		panelRows[4].add(decimalButton);
		panelRows[4].add(equalsButton);
		panelRows[4].add(plusButton);
		
		add(panelRows[1]);
		add(panelRows[2]);
		add(panelRows[3]);
		add(panelRows[4]);
	}
	
	private class ButtonListener implements ActionListener {
		
		JButton pressedButton;
		
		public ButtonListener(JButton button) {
			this.pressedButton = button;
		}
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			scientificModeModel.displayContent(inputDisplay, pressedButton);
		}
	}
	
	private class ActionButtonListener implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {		
			try {
				if (arg0.getSource() == clearButton) {
					scientificModeModel.clearTheDisplay(inputDisplay);
				    firstValue = null;
				    secondValue = null;
				    functionValue = "";
				    decimalButton.setEnabled(true);
				}
				else if (arg0.getSource() == plusButton) {
					functionValue = "addition";
					firstValue = Double.parseDouble(inputDisplay.getText());
					scientificModeModel.clearTheDisplay(inputDisplay);
					decimalButton.setEnabled(true);
				}
				else if (arg0.getSource() == minusButton) {
					functionValue = "subtraction";
					firstValue = Double.parseDouble(inputDisplay.getText());
					scientificModeModel.clearTheDisplay(inputDisplay);
					decimalButton.setEnabled(true);
				}
				else if (arg0.getSource() == multiplyButton) {
					functionValue = "multiplication";
					firstValue = Double.parseDouble(inputDisplay.getText());
					scientificModeModel.clearTheDisplay(inputDisplay);
					decimalButton.setEnabled(true);
				}
				else if (arg0.getSource() == divideButton) {
					functionValue = "division";
					firstValue = Double.parseDouble(inputDisplay.getText());
					scientificModeModel.clearTheDisplay(inputDisplay);
					decimalButton.setEnabled(true);
				}
				else if (arg0.getSource() == squareButton) {
					firstValue = Double.parseDouble(inputDisplay.getText());
					scientificModeModel.getSquareResult(firstValue, inputDisplay);
				}
				else if (arg0.getSource() == squareRootButton) {
					firstValue = Double.parseDouble(inputDisplay.getText());
					scientificModeModel.getSquareRootResult(firstValue, inputDisplay);
				}
				else if (arg0.getSource() == posNegButton) {
					scientificModeModel.reverseSignTheResult(inputDisplay);
				}
				else if (arg0.getSource() == piButton) {
					scientificModeModel.displayPI(inputDisplay);
				}
				else if (arg0.getSource() == factorialButton) {
					firstValue = Double.parseDouble(inputDisplay.getText());
					scientificModeModel.factorialResult(firstValue, inputDisplay);
				}
				else if (arg0.getSource() == sinButton) {
					firstValue = Double.parseDouble(inputDisplay.getText());
					scientificModeModel.sinResult(firstValue, inputDisplay);
				}
				else if (arg0.getSource() == cosButton) {
					firstValue = Double.parseDouble(inputDisplay.getText());
					scientificModeModel.cosResult(firstValue, inputDisplay);
				}
				else if (arg0.getSource() == tanButton) {
					firstValue = Double.parseDouble(inputDisplay.getText());
					scientificModeModel.tanResult(firstValue, inputDisplay);
				}
				else if (arg0.getSource() == exponentButton) {
					functionValue = "exponent";
					firstValue = Double.parseDouble(inputDisplay.getText());
					scientificModeModel.clearTheDisplay(inputDisplay);
					decimalButton.setEnabled(true);
				}
				else if (arg0.getSource() == tenExponentButton) {
					firstValue = Double.parseDouble(inputDisplay.getText());
					scientificModeModel.tenExponentResult(firstValue, inputDisplay);
				}
				else if (arg0.getSource() == logButton) {
					firstValue = Double.parseDouble(inputDisplay.getText());
					scientificModeModel.logResult(firstValue, inputDisplay);
				}			
				else if (arg0.getSource() == equalsButton) {
					if (firstValue != null) {
						secondValue = Double.parseDouble(inputDisplay.getText());
						scientificModeModel.equalTheResult(firstValue, secondValue, inputDisplay, functionValue);
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
	
	private void setupButtons() {
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
		
		decimalButton = new JButton(".");
		decimalButton.setBorder(null);
		decimalButton.setFont(buttonFont);
		decimalButton.setBackground(Color.WHITE);
		decimalButton.setPreferredSize(buttonDimension);
		decimalButton.addActionListener(new ButtonListener(decimalButton));
		
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
		equalsButton.setForeground(Color.WHITE);
		equalsButton.setBackground(Color.BLUE);
		equalsButton.setPreferredSize(buttonDimension);
		equalsButton.addActionListener(new ActionButtonListener());
		
		squareButton = new JButton("^2");
		squareButton.setBorder(null);
		squareButton.setFont(buttonFont);
		squareButton.setBackground(Color.LIGHT_GRAY);
		squareButton.setPreferredSize(buttonDimension);
		squareButton.addActionListener(new ActionButtonListener());
		
		squareRootButton = new JButton("√");
		squareRootButton.setBorder(null);
		squareRootButton.setFont(buttonFont);
		squareRootButton.setBackground(Color.LIGHT_GRAY);
		squareRootButton.setPreferredSize(buttonDimension);
		squareRootButton.addActionListener(new ActionButtonListener());
		
		posNegButton = new JButton("+/-");
		posNegButton.setBorder(null);
		posNegButton.setFont(buttonFont);
		posNegButton.setBackground(Color.LIGHT_GRAY);
		posNegButton.setPreferredSize(buttonDimension);
		posNegButton.addActionListener(new ActionButtonListener());
		
		clearButton = new JButton("C");
		clearButton.setBorder(null);
		clearButton.setFont(buttonFont);
		clearButton.setForeground(Color.WHITE);
		clearButton.setBackground(Color.RED);
		clearButton.setPreferredSize(buttonDimension);
		clearButton.addActionListener(new ActionButtonListener());
		
		exponentButton = new JButton("x^y");
		exponentButton.setBorder(null);
		exponentButton.setFont(buttonFont);
		exponentButton.setBackground(Color.LIGHT_GRAY);
		exponentButton.setPreferredSize(buttonDimension);
		exponentButton.addActionListener(new ActionButtonListener());
		
		sinButton = new JButton("sin");
		sinButton.setBorder(null);
		sinButton.setFont(buttonFont);
		sinButton.setBackground(Color.LIGHT_GRAY);
		sinButton.setPreferredSize(buttonDimension);
		sinButton.addActionListener(new ActionButtonListener());
		
		cosButton = new JButton("cos");
		cosButton.setBorder(null);
		cosButton.setFont(buttonFont);
		cosButton.setBackground(Color.LIGHT_GRAY);
		cosButton.setPreferredSize(buttonDimension);
		cosButton.addActionListener(new ActionButtonListener());
		
		tanButton = new JButton("tan");
		tanButton.setBorder(null);
		tanButton.setFont(buttonFont);
		tanButton.setBackground(Color.LIGHT_GRAY);
		tanButton.setPreferredSize(buttonDimension);
		tanButton.addActionListener(new ActionButtonListener());
		
		tenExponentButton = new JButton("10^x");
		tenExponentButton.setBorder(null);
		tenExponentButton.setFont(buttonFont);
		tenExponentButton.setBackground(Color.LIGHT_GRAY);
		tenExponentButton.setPreferredSize(buttonDimension);
		tenExponentButton.addActionListener(new ActionButtonListener());
		
		logButton = new JButton("log");
		logButton.setBorder(null);
		logButton.setFont(buttonFont);
		logButton.setBackground(Color.LIGHT_GRAY);
		logButton.setPreferredSize(buttonDimension);
		logButton.addActionListener(new ActionButtonListener());
		
		piButton = new JButton("pi");
		piButton.setBorder(null);
		piButton.setFont(buttonFont);
		piButton.setBackground(Color.LIGHT_GRAY);
		piButton.setPreferredSize(buttonDimension);
		piButton.addActionListener(new ActionButtonListener());
		
		factorialButton = new JButton("n!");
		factorialButton.setBorder(null);
		factorialButton.setFont(buttonFont);
		factorialButton.setBackground(Color.LIGHT_GRAY);
		factorialButton.setPreferredSize(buttonDimension);
		factorialButton.addActionListener(new ActionButtonListener());
	}
}