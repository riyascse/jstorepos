/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jstore.components;

import java.awt.EventQueue;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.InternationalFormatter;
import javax.swing.text.NumberFormatter;

/**
 *
 * @author phasnox
 */
public class TestJFormattedTextField {
public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {

                NumberFormatter nf = new NumberFormatter(new java.text.DecimalFormat("#,##0.00"));
                DefaultFormatterFactory ff = new DefaultFormatterFactory(nf);

                NumberFormat format = new java.text.DecimalFormat("#,##0.00");//DecimalFormat.getInstance();
                format.setMinimumFractionDigits(2);
                format.setMaximumFractionDigits(2);
                InternationalFormatter formatter = new InternationalFormatter(format);
                formatter.setAllowsInvalid(false);
                JFormattedTextField field = new JFormattedTextField(formatter);
                field.setValue(0);

                field.selectAll();

                JFrame frame = new JFrame("Test");
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.getContentPane().add(field);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
                field.selectAll();
            }
        });
    }
}
