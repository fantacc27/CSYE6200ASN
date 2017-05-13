package edu.neu.csye6200.cacrystal;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.logging.Level;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.Timer;

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
    private Thread mythread = null;

    /*private Timer timer = new Timer(300, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            caPanel.repaint();

        }

    });*/
    /**
     * Sample app constructor
     */
    public WolfApp() {
        super.initGUI();
        frame.setSize(500, 400);
        frame.setTitle("WolfApp");

        caPanel = new CACanvas();
        frame.add(caPanel, BorderLayout.CENTER); // Add to the center of our frame
        //frame.pack();
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
        stepCntTF.setVisible(true);
        northPanel.add(stepCntTF);

        ruleCBox = new JComboBox<String>();
        ruleCBox.addItem("Rule 1");
        ruleCBox.addItem("Rule 2");
        ruleCBox.addItem("Rule 3");
        northPanel.add(ruleCBox);

        return northPanel;
    }

    /*private void startBtnActionPerformed(java.awt.event.ActionEvent evt) {
        timer.start();
    }

    private void stopBtnActionPerformed(java.awt.event.ActionEvent evt) {
        timer.stop();
    }*/
    @Override
    public void actionPerformed(ActionEvent ae) {
        String rule = (String) ruleCBox.getSelectedItem();
        int y = Integer.parseInt(stepCntTF.getText().toString());
        log.info("We received an ActionEvent " + ae);
        if (ae.getActionCommand().equalsIgnoreCase("Start")) {

            mythread = new Thread(new Runnable() {
                public void run() {
                    if (rule.equals("Rule 1")) {
                        CAFlakeSet cafs = new CAFlakeSet();
                        cafs.CAFlakeSet_1();
                        ArrayList<CAFlakeCell[][]> al = cafs.getList();

                        //int step = Integer.parseInt(stepCntTF.getText().toString());
                        for (int z = 0; z < y; z++) {

                            CAFlakeCell[][] caflakecell = al.get(z);
                            caPanel.update(caflakecell);
                            //timer.start();
                            //timer.setRepeats(false);
                            caPanel.repaint();
                            try {
                                Thread.sleep(200);
                            } catch (Exception ex) {
                            }
                        }
                    }
                                       else if (rule.equals("Rule 2")) {
                        CAFlakeSet cafs = new CAFlakeSet();
                        cafs.CAFlakeSet_2();
                        ArrayList<CAFlakeCell[][]> al = cafs.getList();

                        //int step = Integer.parseInt(stepCntTF.getText().toString());
                        for (int z = 0; z < y; z++) {

                            CAFlakeCell[][] caflakecell = al.get(z);
                            caPanel.update(caflakecell);
                            //timer.start();
                            //timer.setRepeats(false);
                            caPanel.repaint();
                            try {
                                Thread.sleep(200);
                            } catch (Exception ex) {
                            }
                        }
                    }                    else if (rule.equals("Rule 3")) {
                        CAFlakeSet cafs = new CAFlakeSet();
                        cafs.CAFlakeSet_3();
                        ArrayList<CAFlakeCell[][]> al = cafs.getList();

                        //int step = Integer.parseInt(stepCntTF.getText().toString());
                        for (int z = 0; z < y; z++) {

                            CAFlakeCell[][] caflakecell = al.get(z);
                            caPanel.update(caflakecell);
                            //timer.start();
                            //timer.setRepeats(false);
                            caPanel.repaint();
                            try {
                                Thread.sleep(200);
                            } catch (Exception ex) {
                            }
                        }
                    }
                }
            });
            mythread.start();

        } else if (ae.getActionCommand().equalsIgnoreCase("Stop")) {
            mythread.stop();
        }
    }

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
