/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jstore.components;

import com.jstore.domain.Generic;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

/**
 *
 * @author phasnox
 */
public class EntityJTextField extends JTextField{

    private Generic<Object> entity;
    PopUpEntityList menu;

    

    public EntityJTextField(){
        this.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                onKeyPressed(evt);
            }
        });
        menu = new PopUpEntityList();
    }

    private void onKeyPressed(KeyEvent evt) {
                HashMap likes = new HashMap();
                List beans = entity.findLikeCriteria(likes);
                menu.setBeans(beans);
                menu.show(this, this.getX(), this.getY());

                if(evt.getKeyCode()==KeyEvent.VK_DOWN){
                    int selected=menu.getJlist().getSelectedIndex()+1;
//                    if(selected>menu.getJlist().getMaxSelectionIndex()){
//                        selected=menu.getJlist().getMaxSelectionIndex();
//                    }
                        menu.getJlist().setSelectedIndex(selected);
                        menu.getJlist().ensureIndexIsVisible(selected);
                        this.setText(" " + Integer.toString(selected));
                }
            }
    public void setBeans(List beans){
        menu.setBeans(beans);
    }

    /**
     * @return the entity
     */
    public Generic<Object> getEntity() {
        return entity;
    }

    /**
     * @param entity the entity to set
     */
    public void setEntity(Generic<Object> entity) {
        this.entity = entity;
    }
    
    
    class PopUpEntityList extends JPopupMenu {
        private List beans;
        final int MAX_SHOWED=5;
        private JList jlist;

        public PopUpEntityList(){
            super("Menu");
            setFocusable(false);

            initJlist();
        }


        private void setBeans(List beans) {
            this.beans=beans;
            int count=0;
            Iterator beansit = beans.iterator();
            //this.removeAll();
            getJlist().removeAll();
            getJlist().setListData(beans.toArray());
//            while(beansit.hasNext() | count>MAX_SHOWED){
//                JMenuItem anItem = new JMenuItem(beansit.next().toString());
//                jlist.add(anItem);
//                count++;
//            }
        }

        public List getBeans() {
            return beans;
        }

        private void initJlist() {
            setJlist(new JList());

            getJlist().getInputMap().put(KeyStroke.getKeyStroke("UP"), "moveUpList");
            getJlist().getInputMap().put(KeyStroke.getKeyStroke("DOWN"), "moveDownList");
            getJlist().getInputMap().put(KeyStroke.getKeyStroke("ENTER"), "enterList");

//            getJlist().getActionMap().put("moveUpList", moveUpList);
//            getJlist().getActionMap().put("moveDownList", moveDownList);
//            jlist.getActionMap().put("enterList", enterList);

            getJlist().setSelectedIndex(0);
            getJlist().setSize(600, 400);
            this.add(getJlist());
        }

//        Action moveUpList = new AbstractAction() {) {
//            public void actionPerformed(ActionEvent e) {
//                int selected=getJlist().getSelectedIndex()-1;
//                if(selected<0){
//                    selected=0;
//                }
//                getJlist().setSelectedIndex(3);
//                getJlist().ensureIndexIsVisible(3);
//            }
//        };
//
//        Action moveDownList = new AbstractAction() {) {
//            public void actionPerformed(ActionEvent e) {
//                int selected=getJlist().getSelectedIndex()+1;
//                if(selected>getJlist().getMaxSelectionIndex()){
//                    selected=getJlist().getMaxSelectionIndex();
//                }
//                getJlist().setSelectedIndex(3);
//                getJlist().ensureIndexIsVisible(3);
//            }
//        };

        /**
         * @return the jlist
         */
        public JList getJlist() {
            return jlist;
        }

        /**
         * @param jlist the jlist to set
         */
        public void setJlist(JList jlist) {
            this.jlist = jlist;
        }

  
    }

}
