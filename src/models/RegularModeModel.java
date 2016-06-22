package models;

import javax.swing.JButton;
import javax.swing.JTextArea;

public class RegularModeModel {
	
	public void clearTheDisplay(JTextArea textArea) {
		textArea.setText("");
	}
	
	public void getSquareResult(Double value, JTextArea textArea) {
		try {
			Double resultValue = value * value;
			textArea.setText(Double.toString(resultValue));
		} 
		catch (NumberFormatException e) {
		}
	}
	
	public void getSquareRootResult(Double value, JTextArea textArea) {
		try {
			Double resultValue = Math.sqrt(value);
			textArea.setText(Double.toString(resultValue));
		}
		catch (NumberFormatException e) {
		}
	}
	
	public void reverseSignTheResult(JTextArea display) {
		try {
			Double inputValue = Double.parseDouble(display.getText());
			
			if (inputValue != 0) {
				inputValue = inputValue * -1;
				display.setText(Double.toString(inputValue));
			}
		}
		catch (NumberFormatException e) {
		}
	}
	
	public void equalTheResult(Double one, Double two, JTextArea area, String string) {
		
		Double result = 0.0;
		
		try {
			if (string == "addition") {
				result = one + two;
			} 
			else if (string == "subtraction") {
				result = one - two;
			} else if (string == "multiplication") {
				result = one * two;
			} else if (string == "division") {
				result = one / two;
			}
			area.setText(result.toString());
		}
		catch (NumberFormatException e) {
		}
	}
	
	public void displayContent(JTextArea textArea, JButton button) {
		
		String buttonText = button.getText();
		
		if (buttonText == "0") {
			textArea.append("0");
		} else if (buttonText == "1") {
			textArea.append("1");
		} else if (buttonText == "2") {
			textArea.append("2");
		} else if (buttonText == "3") {
			textArea.append("3");
		} else if (buttonText == "4") {
			textArea.append("4");
		} else if (buttonText == "5") {
			textArea.append("5");
		} else if (buttonText == "6") {
			textArea.append("6");
		} else if (buttonText == "7") {
			textArea.append("7");
		} else if (buttonText == "8") {
			textArea.append("8");
		} else if (buttonText == "9") {
			textArea.append("9");
		} else if (buttonText == ".") {
			textArea.append(".");
			button.setEnabled(false);
		}
	}
}