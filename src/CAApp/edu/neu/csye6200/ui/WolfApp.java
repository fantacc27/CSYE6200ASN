package CAApp.edu.neu.csye6200.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.sql.Time;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * A Test application for the Wolfram Celular Autonomon application
 *
 * @author MMUNSON
 *
 */
public class WolfApp extends CAApp {

    private static Logger log = Logger.getLogger(WolfApp.class.getName());

    protected JPanel northPanel = null;
    protected JButton startBtn = null;
    protected JButton stopBtn = null;
    private CACanvas caPanel = null;

    private JLabel genCtnLabel = null;
    private JTextField stepCntTF = null;
    private JComboBox<String> ruleCBox = null;
    private Time Timer;
    /**
     * Sample app constructor
     */
    public WolfApp() {
        frame.setSize(500, 400);
        frame.setTitle("WolfApp");

        caPanel = new CACanvas();
        frame.add(caPanel, BorderLayout.CENTER); // Add to the center of our frame
        frame.setVisible(true); // The UI is built, so display it
    }

    public JPanel getNorthPanel() {
        northPanel = new JPanel();
        northPanel.setLayout(new FlowLayout());

        startBtn = new JButton("Start");
        startBtn.addActionListener(this); // Allow the app to hear about button pushes
        northPanel.add(startBtn);

        stopBtn = new JButton("Stop"); // Allow the app to hear about button pushes
        stopBtn.addActionListener(this);
        northPanel.add(stopBtn);

        genCtnLabel = new JLabel("GenCount:");
        northPanel.add(genCtnLabel);
        
        stepCntTF = new JTextField("10");
        northPanel.add(stepCntTF);
        
        ruleCBox = new JComboBox<String>();
        ruleCBox.addItem("Rule 1");
        ruleCBox.addItem("Rule 2");
        ruleCBox.addItem("Rule 3");
        northPanel.add(ruleCBox);

        return northPanel;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        log.info("We received an ActionEvent " + ae);
        if (ae.getSource() == startBtn) {
            System.out.println("Start pressed");
        } else if (ae.getSource() == stopBtn) {
            System.out.println("Stop pressed");
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {
        log.info("Window opened");
    }

    @Override
    public void windowClosing(WindowEvent e) {
    }

    @Override
    public void windowClosed(WindowEvent e) {
    }

    @Override
    public void windowIconified(WindowEvent e) {
        log.info("Window iconified");
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        log.info("Window deiconified");
    }

    @Override
    public void windowActivated(WindowEvent e) {
        log.info("Window activated");
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        log.info("Window deactivated");
    }

    /**
     * Sample Wolf application starting point
     *
     * @param args
     */
    public static void main(String[] args) {
        WolfApp wapp = new WolfApp();
        log.info("WolfApp started");
    }
}
