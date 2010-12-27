/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jstore.components;

import java.awt.event.KeyEvent;
import javax.swing.JDialog;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;


/**
 *
 * @author phasnox
 */
public class AskNumberDialog  extends JDialog implements ActionListener{

    private JPanel myPanel = null;
    private JButton okButton = null;
    private JButton cancelButton = null;
    private JTextField numberTxt = null;
    private boolean answer = false;
    private Double number = new Double(0);
    private String defaultNumber = "1";
    public boolean getAnswer() { return answer; }


    public AskNumberDialog(JFrame frame, boolean modal, String myMessage) {
        super(frame, modal);
        myPanel = new JPanel();
        getContentPane().add(myPanel);

        myPanel.add(new JLabel(myMessage));

        numberTxt = new JNumberTextField(15);
        numberTxt.setColumns(4);
        numberTxt.setText(defaultNumber);
        numberTxt.addKeyListener(new localKeyListener());
        numberTxt.selectAll();
        myPanel.add(numberTxt);
        
        okButton = new JButton("OK");
        okButton.addActionListener(this);
        myPanel.add(okButton);

        cancelButton = new JButton("CANCEL");
        cancelButton.addActionListener(this);
        myPanel.add(cancelButton);


        this.addKeyListener(new localKeyListener());
        pack();
        setLocationRelativeTo(frame);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if(okButton == e.getSource()) {
            number = Double.parseDouble(numberTxt.getText());
            answer = true;
            setVisible(false);
        }
        else if(cancelButton == e.getSource()) {
            answer = false;
            setVisible(false);
        }
    }
    

    class localKeyListener extends java.awt.event.KeyAdapter{

        @Override
        public void keyPressed(KeyEvent evt) {

            if(evt.getKeyCode()==evt.VK_ENTER){
                number = Double.parseDouble(numberTxt.getText());
                answer = true;
                setVisible(false);
            }

            if(evt.getKeyCode()==evt.VK_ESCAPE){
                answer = false;
                setVisible(false);
            }

            
        }

    }

    public Double getNumber() {
        return number;
    }





}
