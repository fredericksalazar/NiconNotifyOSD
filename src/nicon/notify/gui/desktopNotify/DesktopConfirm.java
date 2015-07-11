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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import nicon.notify.core.util.ControlNotify;
import javax.swing.JButton;
import nicon.notify.core.NiconEvent;

/**
 *
 * @author frederick
 */
public class DesktopConfirm extends DesktopNotify implements ActionListener{
        
    /**
     *
     */
    public JButton jbAcept;

    /**
     *
     */
    public JButton jbCancel;

    /**
     *
     */
    public int option;
    
    /**
     *
     * @param ev
     */
    public DesktopConfirm(NiconEvent ev) {
        super(ev);        
        setSize(380,110);
        init();
    }
    
    /**
     *
     * @param ev
     * @param optionTheme
     */
    public DesktopConfirm(NiconEvent ev,char optionTheme){
        super(ev,optionTheme);
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
       jbAcept.addActionListener(this);
       
       jbCancel=new JButton("Cancel");
       jbCancel.setBounds(190,80,190,30);
       jbCancel.setBorderPainted(false);
       jbCancel.setFocusPainted(false);
       jbCancel.setBorder(BorderFactory.createLineBorder(Color.yellow, 1));
       jbCancel.addActionListener(this);
       
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
    
    /**
     * Este metodo se encarga de hacer que una notificacion sea cerrada al 
     * momento de obtener el evento de pulsación de un boton. 
     */
    public void close() {
        final DesktopNotify notify = this;
        System.out.println("Closing Notify");
        ControlNotify.removeNotify(notify);
    }

    /**
     * Manejamos los posibles eventos de mouse, click en alguno de los botones
     * seleccionados
     * @param ae 
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource().equals(jbAcept)){
            System.out.println("The option selected is : acept");
            option=1;
            close();
        }else{
            System.out.println("The option selected is : cancel");
            option=-1;
            close();
        }
    }
    
}
