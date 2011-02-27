/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jstore.components;

import com.jstore.domain.Generic;
import com.jstore.domain.Sesion;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;

/**
 *
 * @author phasnox
 */
public class EntityCellEditor extends DefaultCellEditor {
    
    public EntityCellEditor(EntityJTextField txt) {
        super(txt);
    }

}
