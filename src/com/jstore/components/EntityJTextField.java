/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jstore.components;

import com.jstore.domain.Generic;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
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
                    menu.getEntityJlist().dispatchEvent(evt);
                }
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                onKeyReleased(evt);
            }
        });
        menu = new PopUpEntityList(250,200);
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
                setSelectedEntity(menu.getSelectedBean());
                this.setText(getSelectedEntity().toString());
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

    /**
     * @return the selectedEntity
     */
    public Generic<Object> getSelectedEntity() {
        return selectedEntity;
    }

    /**
     * @param selectedEntity the selectedEntity to set
     */
    public void setSelectedEntity(Generic<Object> selectedEntity) {
        this.selectedEntity = selectedEntity;
    }

    
    class PopUpEntityList extends JPopupMenu {
        private List beans;
        final int MAX_SHOWED=5;
        private JList entityJList;
        private int preferredHeight, preferredWidth;

        public PopUpEntityList(){
            this(400, 400);
        }

        public PopUpEntityList(int width, int height){
            setFocusable(false);
            initEntityJList(width, height);
            this.setMaximumSize(new Dimension(width, height));

        }

        private void setBeans(List beans) {
            this.beans=beans;
            int defaultHeight;
            int newHeight;

            defaultHeight = preferredHeight;
            newHeight = beans.size()*19;

            if(newHeight<defaultHeight){
                defaultHeight = newHeight;
            }
            entityJList.removeAll();
            entityJList.setListData(beans.toArray());
            entityJList.getParent().setPreferredSize(new Dimension(200, defaultHeight));
        }

        public List getBeans() {
            return beans;
        }

        public JList getEntityJlist() {
            return entityJList;
        }

        public void setEntityJlist(JList jlist) {
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

        private void initEntityJList(int width,int height) {
            preferredWidth = width;
            preferredHeight = height;

            setEntityJlist(new JList());
            entityJList.setFocusable(false);
            JScrollPane scrollp = new JScrollPane();
            scrollp.setAutoscrolls(true);
            scrollp.setViewportView(entityJList);
            this.add(scrollp);
        }
    }
}
