/*
 * Copyright (c) NiconSystemCO 2015
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
import javax.swing.JButton;
import nicon.notify.core.NiconEvent;
import nicon.notify.core.Notification;
import nicon.notify.core.server.ServerOSD;

/**
 *
 * @author frederick
 */
public class DesktopConfirm extends DesktopNotify implements ActionListener{
        
   
    public JButton jbAcept;
    public JButton jbCancel;
    public int option;
    
    
    /**
     * Crea una DesktopConfirm recibiendo un objeto NiconEvent con los parametros
     * configurados.
     * @param ev
     */
    
    public DesktopConfirm(NiconEvent ev) {
        super(ev);        
        setSize(380,106);
        init();
    }
    
    
    /**
     * Crea Un DesktopConfirm con un objeto NiconEvent y un tema a aplicar a la
     * notificacion, los temas pueden ser asi:<br>
     * Notification.Nicon_Light_Theme<br>
     * Notification.Nicon_Dark_Theme<br>
     * Notification.Nicon_Gray_Theme
     * @param ev
     * @param theme
     */
    public DesktopConfirm(NiconEvent ev,char theme){
        super(ev,theme);
        setSize(380,106);
        init();
    }
    
    
    /**
     * 
     * @param ev
     * @param theme
     * @param icon
     */
    public DesktopConfirm(NiconEvent ev,char theme,short icon){
        super(ev,icon,theme);
        setSize(380,106);
        init();
    }
            

    /**
     * Inicializa y ajusta todos los objetos que componen la notificacion de
     * confirmacion, los botones aceptar y cancelar.
     */
    
    private void init() {  
        
       jbAcept=new JButton("Acept");
       jbAcept.setBounds(0,83,190,23); 
       jbAcept.setForeground(Color.white);
       jbAcept.setOpaque(true);
       jbAcept.setBorderPainted(false);
       jbAcept.addActionListener(this);
       
       jbCancel=new JButton("Cancel");
       jbCancel.setBounds(190,83,190,23);
       jbCancel.setOpaque(true);
       jbCancel.setBorderPainted(false);
       jbCancel.addActionListener(this);
       
       
       addButton(jbAcept);
       addButton(jbCancel);
       setAceptButtonColor();
    }
    
    private void setAceptButtonColor(){
        if(getEvent().getTipeMessage() == Notification.DEFAULT_MESSAGE && 
                                getTheme().getNameTheme().equals("Dark")){
            jbAcept.setBackground(new Color(Integer.parseInt("707070", 16)));
        }else{
            jbAcept.setBackground(this.getForegroundTitle());
        }
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
       ServerOSD.getInstance().remove(getNid());
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
