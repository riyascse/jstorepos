/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jstore.components;

import com.jstore.domain.Generic;
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
public class EntityJDialog  extends JDialog implements ActionListener{

    private JPanel myPanel = null;
    private JButton okButton = null;
    private JButton cancelButton = null;
    private EntityJTextField entityTxt = null;
    private boolean answer = false;

    public boolean getAnswer() { return answer; }

    public EntityJDialog(JFrame frame, boolean modal, String myMessage, EntityJTextField jTextField) {
        super(frame, modal);
        entityTxt=jTextField;

        myPanel = new JPanel();
        getContentPane().add(myPanel);

        myPanel.add(new JLabel(myMessage));

        myPanel.add(entityTxt);
        
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
                answer = true;
                setVisible(false);
            }

            if(evt.getKeyCode()==evt.VK_ESCAPE){
                answer = false;
                setVisible(false);
            }

            
        }

    }

}
