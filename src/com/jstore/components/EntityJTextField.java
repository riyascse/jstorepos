/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jstore.components;

import com.jstore.domain.Generic;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;
import javax.swing.event.MenuKeyEvent;

/**
 *
 * @author phasnox
 */
public class EntityJTextField extends JTextField{

    private Generic<Object> dataManager=null;
    private Generic<Object> selectedEntity=null;
    PopUpEntityList menu;
    ArrayList<String> filters;
    

    public EntityJTextField(){
        this.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                if(evt.getKeyCode()==KeyEvent.VK_ESCAPE){
                    menu.setVisible(false);
                    return;
                }
                if(!evt.isShiftDown()){
                    menu.getJlist().dispatchEvent(evt);
                }
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                onKeyReleased(evt);
            }
        });
        menu = new PopUpEntityList();
        filters = new ArrayList();
    }

    private void onKeyReleased(KeyEvent evt) {
        if(evt.getKeyCode()==KeyEvent.VK_ESCAPE){
            menu.setVisible(false);
            return;
        }
        if(evt.isActionKey()){
            if(evt.getKeyCode()==KeyEvent.VK_DOWN & !menu.isVisible()){
                filterAndShow(this.getText());
            }

        }else{
            if((evt.getKeyCode()==KeyEvent.VK_ENTER | evt.getKeyCode()==KeyEvent.VK_TAB) & menu.isVisible()){
                menu.setVisible(false);
                selectedEntity=menu.getSelectedBean();
                this.setText(selectedEntity.toString());
                return;
            }       

            filterAndShow(this.getText());
        }
    }
    public void setBeans(List beans){
        menu.setBeans(beans); 
    }


    public void filterAndShow(String searchString){
        HashMap likes   =   new HashMap();
        for(String filter : filters){
                        likes.put(filter, searchString + "%");
                    }

        List beans = dataManager.findLikeCriteriaOr(likes);
        menu.setBeans(beans);
        if(menu.getBeans().isEmpty()){
            menu.setVisible(false);
            return;
            }
        menu.setVisible(false);
        menu.show(this.getParent(), this.getX(), this.getY() + this.getHeight());
        menu.moveFirst();
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

    public void addFilter(String columnName){
        filters.add(columnName);
    }
    
    class PopUpEntityList extends JPopupMenu {
        private List beans;
        final int MAX_SHOWED=5;
        private JList entityJList;

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
            entityJList.setFocusable(false);
            this.add(getJlist());
        }

        public JList getJlist() {
            return entityJList;
        }

        public void setJlist(JList jlist) {
            this.entityJList = jlist;
        }

        private void moveFirst() {
            entityJList.setSelectedIndex(0);
            entityJList.ensureIndexIsVisible(0);
        }

        private void moveLast() {
            int selectedIndex=entityJList.getModel().getSize()-1;
            entityJList.setSelectedIndex(selectedIndex);
            entityJList.ensureIndexIsVisible(selectedIndex);
        }
        
        private Generic<Object> getSelectedBean() {
            return (Generic)beans.get(entityJList.getSelectedIndex());
        }
    }

}
