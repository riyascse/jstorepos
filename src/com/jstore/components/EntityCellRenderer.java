/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jstore.components;

import com.jstore.domain.Generic;
import com.jstore.domain.Sesion;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author phasnox
 */
public class EntityCellRenderer extends EntityJTextField implements TableCellRenderer{

    public EntityCellRenderer(Generic entity) {
        super.setDataManager(entity);
    }

    
    public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int i, int i1) {
        //throw new UnsupportedOperationException("Not supported yet.");
        return this;
    }


}
