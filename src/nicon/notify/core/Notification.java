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

package nicon.notify.core;

import java.awt.Component;
import nicon.notify.gui.desktopNotify.ControllerDesktopNotify;
import nicon.notify.gui.desktopNotify.DesktopConfirm;
import nicon.notify.gui.desktopNotify.DesktopNotify;
import nicon.notify.gui.desktopNotify.controller.DesktopConfirmController;
import nicon.notify.gui.windowNotify.ConfirmNotify;
import nicon.notify.gui.windowNotify.InputNotify;
import nicon.notify.gui.windowNotify.WindowNotify;


public class Notification {
    
    private static WindowNotify windowNotify;
    private static InputNotify inputNotify;
    private static ConfirmNotify confirmNotify;
    private static DesktopNotify desktopNotify;
    private static DesktopConfirm desktopConfirm;
    
    private static NiconEvent event;
    
    private static String response;
    private static int option;
    private static DesktopConfirmController controller;
    
    
    /**
     * Crea una Notificacion de escritorio con un titulo y un mensaje
     * @param title
     * @param message 
     */
    public static void desktopMessage(String title, String message){
        event=new NiconEvent(title,message,NiconEvent.NOTIFY_DEFAULT);
        desktopNotify=new DesktopNotify(event);
        ControllerDesktopNotify.launchNotify(desktopNotify);
    }
    
    /**
     * Crea una notificacion de escritorio con un titulo y un mensaje y el Skin
     * desea usar para la notificacion usando las siguientes Opciones<P><B>
     * DesktopNotify.NICON_DARK_THEME</P><P><B>
     * DesktopNotify.NICON_LIGHT_THEME</P>
     * @param title
     * @param message
     * @param optionTheme 
     */
    public static void desktopMessage(String title, String message,String Skin){
        event=new NiconEvent(title,message,NiconEvent.NOTIFY_DEFAULT);
        desktopNotify=new DesktopNotify(event,Skin);
        ControllerDesktopNotify.launchNotify(desktopNotify);
    }
    
    /**
     * Crea una notificacion de escritorio recibiendo el titulo, un mensaje y
     * el tipo de Notificacion a mostrar, NiconEvent.Error NiconEvent.Warning
     * NiconEvent.Default NiconEvent.OK
     * @param title
     * @param message
     * @param tipeNotify 
     */
    public static void desktopMessage(String title, String message, int tipeNotify){
        event=new NiconEvent(title,message,tipeNotify);
        desktopNotify=new DesktopNotify(event);
        ControllerDesktopNotify.launchNotify(desktopNotify);
    }
    
    /**
     * Crea una notificacion de escritorio recibiendo el titulo, un mensaje y
     * el tipo de Notificacion a mostrar, NiconEvent.Error NiconEvent.Warning
     * NiconEvent.Default NiconEvent.OK y el Skin que
     * desea usar para la notificacion usando las siguientes Opciones<P><B>
     * DesktopNotify.NICON_DARK_THEME</P><P><B>
     * DesktopNotify.NICON_LIGHT_THEME</P>
     * @param title
     * @param message
     * @param tipeNotify 
     */    
    public static void desktopMessage(String title, String message, int tipeNotify,String optionTheme){
        event=new NiconEvent(title,message,tipeNotify);
        desktopNotify=new DesktopNotify(event,optionTheme);
        ControllerDesktopNotify.launchNotify(desktopNotify);
    }    
    
    /**
     * crea una notificacion de escritorio con un titulo, un mensaje y un valor
     * entero que presenta un icono especial seleccionando una de las opciones 
     * habilitadas dentro de DesktopNotify:
     * <br><b> DesktopNotify.NICON_FACEBOOK_ICON</br>
     * <br>DesktopNotify.NICON_TWITTER_ICON</br>
     * <br>DesktopNotify.NICON_TWITTER_OFF_ICON</br>
     * <br>DesktopNotify.NICON_UPDATE_ICON</br>
     * <br>DesktopNotify.NICON_SECURE_ICON</br>
     * <br>DesktopNotify.NICON_GOOGLE_ICON</br>
     * <br>DesktopNotify.NICON_HARD_ICON</br>
     * <br>DesktopNotify.NICON_GPLUS_ICON</br>
     * <br>DesktopNotify.NICON_WEATHER_ICON</br>
     * </b><br>
     * @param tipeIcon
     * @param title
     * @param message
     */
    public static void desktopMessage(int tipeIcon,String title, String message){
        event=new NiconEvent(title,message,NiconEvent.NOTIFY_DEFAULT);
        desktopNotify=new DesktopNotify(event, tipeIcon);
        ControllerDesktopNotify.launchNotify(desktopNotify);
    }
    
    /**
     * crea una notificacion de escritorio con un titulo, un mensaje y un valor
     * entero que presenta un icono especial seleccionando una de las opciones 
     * habilitadas dentro de DesktopNotify:
     * <br><b> DesktopNotify.NICON_FACEBOOK_ICON</br>
     * <br>DesktopNotify.NICON_TWITTER_ICON</br>
     * <br>DesktopNotify.NICON_TWITTER_OFF_ICON</br>
     * <br>DesktopNotify.NICON_UPDATE_ICON</br>
     * <br>DesktopNotify.NICON_SECURE_ICON</br>
     * <br>DesktopNotify.NICON_GOOGLE_ICON</br>
     * <br>DesktopNotify.NICON_HARD_ICON</br>
     * <br>DesktopNotify.NICON_GPLUS_ICON</br>
     * <br>DesktopNotify.NICON_WEATHER_ICON</br>
     * </b><br>
     * <p>el Skin que
     * desea usar para la notificacion usando las siguientes Opciones<P><B>
     * DesktopNotify.NICON_DARK_THEME</P><P><B>
     * DesktopNotify.NICON_LIGHT_THEME</P>
     * @param ev
     * @param icon 
     */
    public static void desktopMessage(int tipeIcon,String title, String message,String skin){
        event=new NiconEvent(title,message,NiconEvent.NOTIFY_DEFAULT);
        desktopNotify=new DesktopNotify(event, tipeIcon,skin);
        ControllerDesktopNotify.launchNotify(desktopNotify);
    }
    
    /**
     * Este metodo crea una caja de Dialogo del tipo WindowMessage para mostrar
     * una información cualquiera, este metodo puede ser accedido desde cualquier
     * lugar a traves de NotifyFactory.
     * 
     * @param ev
     */
    public static void windowMessage(Component content,String title, String message){         
        event=new NiconEvent(title,message, NiconEvent.NOTIFY_DEFAULT);
        windowNotify=new WindowNotify(content,event);
        windowNotify.setVisible(true);
    }
    
    /**
     * Muestra uuna notificacion del tipo Window recibiendo el titulo, el mensaje
     * y el tipo de notificacion, pueden tomar valores como NiconEvent.Error NiconEvent.Warning
     * NiconEvent.Default NiconEvent.OK
     * @param title
     * @param message
     * @param tipeOption
     */
    
     public static void windowMessage(Component content,String title, String message,int tipeOption){         
        event=new NiconEvent(title,message,tipeOption);
        windowNotify=new WindowNotify(content,event);
        windowNotify.setVisible(true);
    }
     
     /**
      * Muestra una notificacion del tipo Window recibiendo el titulo y el mensaje 
      * a mostrar.
      * @param title
      * @param message
      * @return String response
      */
     public static String windowInputMessage(Component content,String title,String message){
         event=new NiconEvent(title,message,NiconEvent.NOTIFY_DEFAULT);
         inputNotify=new InputNotify(content,event);
         inputNotify.setVisible(true);
            while(inputNotify.isShowing()!=true){
                response=inputNotify.getInputData();
                break;
            }
        return response;
    }
     
     /**
      * Muestra una notificacion del tipo WindowConfirm para solicitar la confirmacion
      * de accion por parte del usuario, recibe el titulo y el mensaje a mostrar
      * @param title
      * @param message
      * @return int option
      */
     public static int windowConfirmMessage(Component content,String title, String message){
        option=-1;            
            event=new NiconEvent(title,message,NiconEvent.NOTIFY_CONFIRM);
            confirmNotify=new ConfirmNotify(content,event);
            confirmNotify.setVisible(true);            
                while(confirmNotify.isShowing()!=true){
                    option=confirmNotify.getSelectedOption();
                    break;
                }
        return option;
    }
     
      /**
      * Muestra una notificacion del tipo WindowConfirm para solicitar la confirmacion
      * de accion por parte del usuario, recibe el titulo y el mensaje a mostrar
      * @param title
      * @param message
      * @return int option
      */
     public static int windowConfirmMessage(Component content,String title, String message, int optionType){
        option=-1;
            event=new NiconEvent(title,message,optionType);
            confirmNotify=new ConfirmNotify(content,event);
            confirmNotify.setVisible(true);            
                while(confirmNotify.isShowing()!=true){
                    option=confirmNotify.getSelectedOption();
                    break;
                }
        return option;
    }
     
     /**
      * Muestra una notificacion del tipo WindowConfirm para solicitar la confirmacion
      * de accion por parte del usuario, recibe el titulo y el mensaje a mostrar, el texto
      * del boton aceptar y el txto del boton cancelar
      * @param title
      * @param message
      * @param textAceptButton
      * @param textNoButton
      * @return int option
      */
     public static int windowConfirmMessage(Component content, String title,String message,String textAceptButton, String textNoButton){
         option=-1;
            event=new NiconEvent(title,message,NiconEvent.NOTIFY_DEFAULT);
            confirmNotify=new ConfirmNotify(content,event,textAceptButton,textNoButton);
            confirmNotify.setVisible(true);            
                while(confirmNotify.isShowing()!=true){
                    option=confirmNotify.getSelectedOption();
                    break;
                }
        return option;
    }
     
     /**
      * Muestra una notificacion del tipo WindowConfirm para solicitar la confirmacion
      * de accion por parte del usuario, recibe el titulo y el mensaje a mostrar, el texto
      * del boton aceptar y el txto del boton cancelar
      * @param title
      * @param message
      * @param textAceptButton
      * @param textNoButton
      * @return int option
      */
     public static int windowConfirmMessage(Component content, String title,String message,String textAceptButton, String textNoButton,int optionType){
         option=-1;
            event=new NiconEvent(title,message,optionType);
            confirmNotify=new ConfirmNotify(content,event,textAceptButton,textNoButton);
            confirmNotify.setVisible(true);            
                while(confirmNotify.isShowing()!=true){
                    option=confirmNotify.getSelectedOption();
                    break;
                }
        return option;
    }
     
     
}
