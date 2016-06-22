package ui;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.UIManager;

public class AboutGUI extends JFrame {
		
	private static final long serialVersionUID = 1L;
	
    private JPanel aboutPanel;
    private JTextArea authorTextArea;
    private JTextArea versionTextArea;
    private JTextArea aboutTextArea;
	
	public AboutGUI() {
        aboutPanel = new JPanel();
        authorTextArea = new JTextArea();
        versionTextArea = new JTextArea();
        aboutTextArea = new JTextArea();
        
        String authorString = "Author: Nicholas Cottrell";
        String versionString = "Version: 1.0";
        String aboutString = "This is a simple Java project that I thought to do. There are three different "
        		+ "modes that you can choose from (regular, scientific, and programming). The regular calculator "
        		+ "gives you basic functionality. The scientific calculator gives you the basic functionality as "
        		+ "well as some more advanced calculations. The programming calculator has not been completed yet "
        		+ "but it will be ASAP.";
        
        setTitle("About");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(600, 300, 250, 250);
        
        authorTextArea.setText(authorString);
        authorTextArea.setWrapStyleWord(true);
        authorTextArea.setLineWrap(true);
        authorTextArea.setOpaque(false);
        authorTextArea.setEditable(false);
        authorTextArea.setFocusable(false);
        authorTextArea.setBackground(UIManager.getColor("Label.background"));
        authorTextArea.setFont(UIManager.getFont("Label.font"));
        authorTextArea.setBorder(UIManager.getBorder("Label.border"));
        
        versionTextArea.setText(versionString);
        versionTextArea.setWrapStyleWord(true);
        versionTextArea.setLineWrap(true);
        versionTextArea.setOpaque(false);
        versionTextArea.setEditable(false);
        versionTextArea.setFocusable(false);
        versionTextArea.setBackground(UIManager.getColor("Label.background"));
        versionTextArea.setFont(UIManager.getFont("Label.font"));
        versionTextArea.setBorder(UIManager.getBorder("Label.border"));
        
        aboutTextArea.setText(aboutString);
        aboutTextArea.setWrapStyleWord(true);
        aboutTextArea.setLineWrap(true);
        aboutTextArea.setOpaque(false);
        aboutTextArea.setEditable(false);
        aboutTextArea.setFocusable(false);
        aboutTextArea.setBackground(UIManager.getColor("Label.background"));
        aboutTextArea.setFont(UIManager.getFont("Label.font"));
        aboutTextArea.setBorder(UIManager.getBorder("Label.border"));
        
        aboutPanel.add(authorTextArea);
        aboutPanel.add(versionTextArea);
        aboutPanel.add(aboutTextArea);
        aboutPanel.setLayout(new BoxLayout(aboutPanel, BoxLayout.Y_AXIS));

        add(aboutPanel);
        
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
	}
}