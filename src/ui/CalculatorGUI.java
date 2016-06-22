package ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class CalculatorGUI extends JFrame {

	private static final long serialVersionUID = 4851206059872063354L;
	
	private RegularModeJPanel regularModeJPanel;
	private ScientificModeJPanel scientificModeJPanel;
	private ProgrammingModeJPanel programmingModeJPanel;
	
	private JMenuBar menuBar;
	private JMenu calculatorModeMenu;
	private JMenu helpMenuItem;
	private JMenuItem regularModeMenuItem, scientificModeMenuItem, programmingModeMenuItem, aboutMenuItem;
		
	public CalculatorGUI() {
		setTitle("Calculator Project");
			
		regularModeJPanel = new RegularModeJPanel();
		scientificModeJPanel = new ScientificModeJPanel();
		programmingModeJPanel = new ProgrammingModeJPanel();
		
		initializeFrame();
		initializeMenuBar();
		setVisible(true);
	}

	public void initializeFrame() {		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 300, 300, 300);
        setLocationRelativeTo(null);
		setResizable(false);
	}
	
	public void initializeMenuBar() {
		menuBar = new JMenuBar();
		createModeMenu();
		createSettingsMenu();
		setJMenuBar(menuBar);
	}
	
	public void createModeMenu() {
		calculatorModeMenu = new JMenu("Calculator Mode");
		menuBar.add(calculatorModeMenu);
		regularModeMenuItem = new JMenuItem("Regular");
		regularModeMenuItem.addActionListener(new CalculatorModeListener(regularModeJPanel));
		scientificModeMenuItem = new JMenuItem("Scientific");
		scientificModeMenuItem.addActionListener(new CalculatorModeListener(scientificModeJPanel));
		programmingModeMenuItem = new JMenuItem("Programming");
		programmingModeMenuItem.addActionListener(new CalculatorModeListener(programmingModeJPanel));
		calculatorModeMenu.add(regularModeMenuItem);
		calculatorModeMenu.add(scientificModeMenuItem);
		calculatorModeMenu.add(programmingModeMenuItem);
	}
	
	public void createSettingsMenu() {
		helpMenuItem = new JMenu("Help");
		menuBar.add(helpMenuItem);
		aboutMenuItem = new JMenuItem("About");
		aboutMenuItem.addActionListener(new AboutListener());
		helpMenuItem.add(aboutMenuItem);	
	}
	
	private class CalculatorModeListener implements ActionListener {
		private JPanel panel;
		private CalculatorModeListener(JPanel modePanel) {
			this.panel = modePanel;
		}
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if (arg0.getSource().equals(regularModeMenuItem)) {
				setBounds(getX(), getY(), 380, 415);
			} else if (arg0.getSource().equals(scientificModeMenuItem)) {
				setBounds(getX(), getY(), 700, 350);
			} else if (arg0.getSource().equals(programmingModeMenuItem)) {
				setBounds(getX(), getY(), 380, 415);
			}
			changePanel(panel);
		}
	}
	
	private void changePanel(JPanel panel) {
		getContentPane().removeAll();
		getContentPane().add(panel, BorderLayout.CENTER);
		getContentPane().doLayout();
		update(getGraphics());
	}
	
	private class AboutListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			new AboutGUI();
		}
	}
}