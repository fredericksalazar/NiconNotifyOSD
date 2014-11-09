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

package nicon.notify.gui.windowNotify;

import java.awt.Component;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import nicon.notify.core.NiconEvent;
import nicon.notify.core.util.NotifyConfig;

/**
 * Esta clase definirá la creacion de Objetos del tipo WindowNotify en su 
 * caractiristica de dialogo de confirmacion, por defecto se proponen dos simples
 * opciones de respuesta si / no, esta clase hereda directamente de WindowNotify
 * y ajusta la interfaz a su necesidad.
 * 
 * @author frederick
 */
public class ConfirmNotify extends WindowNotify {

    private JButton noButton;
    
    private NiconEvent ev;
    private NotifyConfig config;
    
    private String textAceptButton="Si";
    private String textCancelButton="No";
    
    private ImageIcon icon;
    
    private int option=-1;
    
    /**
     * Este Consructor permite crea una nueva ConfirmNotify recibiendo un 
     * evento del tipo NiconEvent a mostrar
     * @param ev 
     */
    public ConfirmNotify(Component content,NiconEvent ev) {
        super(content,ev);
        this.ev=ev;
        config=NotifyConfig.getInstance();
        setSize(555,208);
        init();
        setTypeNotify();
    }
    
    /**
     * Este metodo permite crear una nueva ConfirmNotify recibiendo como parametros
     * el evento a mostrar y el texto del boton aceptar y cancelar.
     * @param ev
     * @param buttonText 
     */
    public ConfirmNotify(Component content,NiconEvent ev, String yesbuttonText,String noButtonText ){
        super(content,ev);
        this.ev=ev;
        this.textAceptButton=yesbuttonText;
        this.textCancelButton=noButtonText;
        config=NotifyConfig.getInstance();
        setSize(600, 240);
        init();
        setTypeNotify();
    }

    private void init() {       
        
        jbAcept.setText(textAceptButton);
        jbAcept.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                option=1;
                dispose();
            }
        });
        moveAceptButton(400,150);
        
        noButton=new JButton(textCancelButton);
        noButton.setBounds(270,150, 120, 30);
        noButton.setFocusable(false);
        noButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               option=0;
               dispose();
            }
        });
        
        addButton(noButton);
    }
    
    /**
     * Este metodo retorna la opcion que ha seleccionado el usuario al momento
     * de escogar una opcion propuesta por el desarrollador, en ella si el usuariio
     * presiona el boton si se retornara el valor 0 en caso de decidir que no se
     * retornará el valor 1.
     * 
     * @return int option
     */
    public int getSelectedOption(){        
        return option;
    }

    /**
     * Este metodo se encarga de ajustar la ConfirmNotify de acuerdo al entorno
     * de ejecucion o  al tipo de evento que se desea informar, bien sea de 
     * confirmacion de notificacion de error o de advertencia o de Exito.
     */
    private void setTypeNotify() {
        if(ev.getTipeMessage()==NiconEvent.NOTIFY_CONFIRM){
            icon=new ImageIcon(getClass().getResource(config.getNitruxIconsPath()+"NiconConfirm.png")); 
            setForegroundTitle(config.getFontConfirmColor());
        }
       if(ev.getTipeMessage()==NiconEvent.NOTIFY_WARNING){
           icon=new ImageIcon(getClass().getResource(config.getNitruxIconsPath()+"NiconWarning.png")); 
           setForegroundTitle(config.getFontWarningColor());
       }
       if(ev.getTipeMessage()==NiconEvent.NOTIFY_ERROR){
           icon=new ImageIcon(getClass().getResource(config.getNitruxIconsPath()+"NiconError.png")); 
           setForegroundTitle(config.getFontErrorColor());
       }
       if(ev.getTipeMessage()==NiconEvent.NOTIFY_OK){
           icon=new ImageIcon(getClass().getResource(config.getNitruxIconsPath()+"NiconOK_1.png"));  
           setForegroundTitle(config.getFontOKColor());
       }
       setIconMessage(icon);
    }
    
}
