package models;

import javax.swing.JButton;
import javax.swing.JTextArea;

public class ScientificModeModel {
	
	public void clearTheDisplay(JTextArea textArea) {
		textArea.setText("");
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
			} else if (string == "exponent") {
				result = Math.pow(one, two);
			}
			area.setText(result.toString());
		}
		catch (NumberFormatException e) {
		}
	}
	
	public void tenExponentResult(Double value, JTextArea textArea) {
		try {
			Double resultValue = Math.pow(10, value);
			textArea.setText(Double.toString(resultValue));
		} 
		catch (NumberFormatException e) {
		}
	}
	
	public void displayPI(JTextArea textArea) {
		textArea.setText(Double.toString(Math.PI));
	}
	
	public void logResult(Double value, JTextArea textArea) {
		try {
			Double resultValue = Math.log10(value);
			textArea.setText(Double.toString(resultValue));
		}
		catch (NumberFormatException e) {
		}
	}
	
	public void sinResult(Double value, JTextArea textArea) {
		try {
			Double result = Math.sin(value);
			textArea.setText(Double.toString(result));
		}
		catch (NumberFormatException e) {
		}
	}
	
	public void cosResult(Double value, JTextArea textArea) {
		try {
			Double result = Math.cos(value);
			textArea.setText(Double.toString(result));
		}
		catch (NumberFormatException e) {
		}
	}
	
	public void tanResult(Double value, JTextArea textArea) {
		try {
			Double result = Math.tan(value);
			textArea.setText(Double.toString(result));
		}
		catch (NumberFormatException e) {
		}
	}
	
	public void factorialResult(Double value, JTextArea textArea) {
		try {
			Double factorial = 1.0;
			
			for (double i = 1; i <= value; i++) {
				factorial *= i;
			}
			textArea.setText(Double.toString(factorial));
		}
		catch (NumberFormatException e) {
		}
	}
}