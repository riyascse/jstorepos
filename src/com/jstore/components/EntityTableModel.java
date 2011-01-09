/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jstore.components;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.swing.table.DefaultTableModel;
import com.jstore.domain.Generic;

/**
 *
 * @author phasnox
 */
public class EntityTableModel extends DefaultTableModel{

    Map columns;
    List beans;

    public EntityTableModel(Map columns){
        setColumns(columns);
        beans = new ArrayList();
    }

    public EntityTableModel(){

    }

    public void setColumnFormats(Map formats){

    }

    public void setValues(Map columns, List beans){
        this.columns=columns;
        this.beans = beans;

        //Set column names
        setColumns(columns);

        //Set each bean in rows
        setBeans(beans);
    }

    public List getBeans() {
        return beans;
    }

    public void setBeans(List beans) {
        this.beans = beans;
        this.getDataVector().removeAllElements();
        //Set each bean in rows
        Iterator beansit = beans.iterator();
        while(beansit.hasNext()){
            Generic o = (Generic)beansit.next();
            ArrayList row = new ArrayList();

            //We get the values, wich are the property names
            Iterator colsit = columns.values().iterator();
            while(colsit.hasNext()){
                String propertyName = (String)colsit.next();
                row.add(o.getProperty(propertyName));
            }
            this.addRow(row.toArray());
        }
    }

    public Map getColumns() {
        return columns;
    }

    public void addColumn(String columnName, String beanProperty){
        if(columns==null){
            columns = new LinkedHashMap();
        }

        columns.put(columnName, beanProperty);
        this.addColumn(columnName);
    }

    public void setColumns(Map columns) {
        this.columns = columns;
        //Set column names
        Object[] colnames = columns.keySet().toArray();
        this.setColumnIdentifiers(colnames);
    }


    public Object getValueAt(int row, String colname){
        Generic bean = (Generic)beans.get(row);
        String propertyName = (String) columns.get(colname);
        return bean.getProperty(propertyName);
    }

    public Object getBeanAt(int row){
        if(beans==null){ return null;}
        if(row<0){ return null;}
        Generic bean = (Generic)beans.get(row);
        return bean;
    }

    public void addRow(Generic o){
        beans.add(o);
        ArrayList row = new ArrayList();
        //We get the values, wich are the property names
        Iterator colsit = columns.values().iterator();
        while(colsit.hasNext()){
            String propertyName = (String)colsit.next();
            row.add(o.getProperty(propertyName));
        }
        this.addRow(row.toArray());
    }

    public void clearRows() {
        beans.removeAll(beans);
        this.getDataVector().removeAllElements();
    }
}
