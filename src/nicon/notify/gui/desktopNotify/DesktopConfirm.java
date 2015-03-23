/*
 * Copyright (c) NiconSystem inc 2013
 * License: GPLv3
 *
 * Authors:
 * Frederick Adolfo Salazar Sanchez <fredefass01@gmail.com>
 *
 *   This program is free software; you can redistribute it and/or modify
 *   it under the terms of the GNU General Public License as
 *   published by the Free Software Foundation; either version 3,
 *   or (at your option) any later version.
 *
 *   This program is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU General Public License for more details
 *
 *   You should have received a copy of the GNU General Public
 *   License along with this program; if not, write to the
 *   Free Software Foundation, Inc.,
 *   51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */

package nicon.notify.gui.desktopNotify;

import java.awt.Color;
import nicon.notify.core.util.ControlNotify;
import javax.swing.JButton;
import nicon.notify.core.NiconEvent;

/**
 *
 * @author frederick
 */
public class DesktopConfirm extends DesktopNotify implements NotifyDesktopInterface{
        
    public JButton jbAcept;
    public JButton jbCancel;
    public static int option=-1;
    public static int visible=0;
    
    
    public DesktopConfirm(NiconEvent ev) {
        super(ev);
        setSize(380,110);
        init();
    }

    private void init() {               
       jbAcept=new JButton("Acept");
       jbAcept.setBounds(0,80,190,30); 
       jbAcept.setForeground(Color.white);
       jbAcept.setBorderPainted(false);
       jbAcept.setFocusPainted(false);
       jbAcept.setBackground(this.getForegroundTitle());
       
       jbCancel=new JButton("Cancel");
       jbCancel.setBounds(190,80,190,30);
       jbCancel.setBackground(Color.lightGray);
       
       addButton(jbAcept);
       addButton(jbCancel);
    }
    
    /**
     * este metodo obtiene y retorna la opcion seleccionada por parte del usuario
     * que corresponde al evento NiconEvent que se ha pasado como parametro de
     * informacion, el valor retornado será un valor entero que representa una 
     * seleccion en base a la siguiente logica
     * 
     * 0= respuesta negativa (Cancel)
     * 1= respuesta afirmativa (Aceptar).
     * @return 
     */
    public int getSelectedOption(){
        return option;
    }
    
    @Override
    public void closeNotify(DesktopNotify notify) {
        System.out.println("Closing Notify");
        ControlNotify.removeNotify(notify);
    }
    
}
