/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jstore.components;

import com.jstore.domain.Generic;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import javax.swing.JList;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;

/**
 *
 * @author phasnox
 */
public class EntityJTextField extends JTextField{

    private Generic<Object> dataManager=null;
    private Generic<Object> selectedEntity=null;
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
                List beans = dataManager.findLikeCriteria(likes);
                menu.setBeans(beans);
                menu.show(this.getParent(), this.getX(), this.getY() + this.getHeight());

                if(evt.getKeyCode()==KeyEvent.VK_DOWN){
                    menu.moveNext();
                }
                if(evt.getKeyCode()==KeyEvent.VK_UP){
                    menu.movePrevious();
                }
                if(evt.getKeyCode()==KeyEvent.VK_ENTER){
                    menu.setVisible(false);
                    selectedEntity=menu.getSelectedBean();
                    this.setText(selectedEntity.toString());
                }
                this.requestFocus();
            }
    public void setBeans(List beans){
        menu.setBeans(beans);
    }

    /**
     * @return the entity
     */
    public Generic<Object> getDataManager() {
        return dataManager;
    }

    /**
     * @param entity the entity to set
     */
    public void setDataManager(Generic<Object> entity) {
        this.dataManager = entity;
    }
    
    
    class PopUpEntityList extends JPopupMenu {
        private List beans;
        final int MAX_SHOWED=5;
        private JList jlist;
        private int selectedIndex=-1;

        public PopUpEntityList(){
            super("Menu");
            setFocusable(false);
            initJlist();
        }


        private void setBeans(List beans) {
            this.beans=beans;
            int count=0;
            Iterator beansit = beans.iterator();
            getJlist().removeAll();
            getJlist().setListData(beans.toArray());
        }

        public List getBeans() {
            return beans;
        }

        private void initJlist() {
            setJlist(new JList());
            jlist.setFocusable(false);
            this.add(getJlist());
        }

        public JList getJlist() {
            return jlist;
        }

        public void setJlist(JList jlist) {
            this.jlist = jlist;
        }

        private void moveNext() {
            if(selectedIndex>=jlist.getModel().getSize()-1){
                selectedIndex=jlist.getModel().getSize()-1;
            }else{
                selectedIndex++;
            }
            jlist.setSelectedIndex(selectedIndex);
            jlist.ensureIndexIsVisible(selectedIndex);
        }

        private void movePrevious(){
            if(selectedIndex<=0){
                selectedIndex=0;
            }else{
                selectedIndex--;
            }
            jlist.setSelectedIndex(selectedIndex);
            jlist.ensureIndexIsVisible(selectedIndex);
        }

        /**
         * @return the selectedIndex
         */
        public int getSelectedIndex() {
            return selectedIndex;
        }

        /**
         * @param selectedIndex the selectedIndex to set
         */
        public void setSelectedIndex(int selectedIndex) {
            this.selectedIndex = selectedIndex;
        }

        private Generic<Object> getSelectedBean() {
            return (Generic)beans.get(selectedIndex);
        }

  
    }

}
