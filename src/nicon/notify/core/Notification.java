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

import nicon.notify.core.util.ControlNotify;
import nicon.notify.core.util.NotifyConfig;
import nicon.notify.gui.desktopNotify.DesktopConfirm;
import nicon.notify.gui.desktopNotify.DesktopNotify;

/**
 * Notification es la clase API para la invocación, manejo y configuración de las
 * notificaciones de escritorio que provee NiconNotifyOSD, use este standar
 * para acceder a todas las herramientas que provee NiconNotifyOSD
 * 
 * @author Frederick Adolfo Salazar Sanchez
 */

public class Notification {

    public final static int OK_MESSAGE = 0;
    public final static int ERROR_MESSAGE = 1;
    public final static int WARNING_MESSAGE = 2;
    public final static int CONFIRM_MESSAGE = 3;
    public final static int DEFAULT_MESSAGE = 4;

    public final static int FACEBOOK_ICON = 1;
    public final static int TWITTER_ON_ICON = 2;
    public final static int TWITTER_OFF_ICON = 3;
    public final static int UPDATE_ICON_GREEN = 4;
    public final static int SECURE_ICON = 5;
    public final static int GOOGLE_ICON = 6;
    public final static int DISK_ICON = 7;
    public final static int GPLUS_ICON = 8;
    public final static int WEATHER_ICON = 9;
    public final static int WIFI_ICON = 10;
    public final static int DOWNLOAD_ICON = 11;
    public final static int RSS_ICON = 12;
    public final static int UPDATE_ICON_BLUE = 13;
    public final static int EVERNOTE_ICON = 14;
    public final static int MESSAGE_ICON_ORANGE = 15;
    public final static int MESSAGE_ICON_BLUE = 16;
    public final static int MUSIC_ICON = 17;
    public final static int SHIELD_ICON = 18;
    public final static int PLUGIN_ICON = 19;
    public final static int MAIL_ICON_RED = 20;
    public final static int MAIL_ICON_BLUE = 21;
    public final static int IMAGE_ICON=22;
    public final static int NOTES_ICON=23;
    public final static int CALENDAR_ICON=24;
    protected final static int INFO_ICON=25;

    public final static char NICON_DARK_THEME = 'D';
    public final static char NICON_LIGHT_THEME = 'L';

    private static DesktopNotify notify;
    private static NiconEvent event;
    private static DesktopConfirm confirm;
    private static int option;

    /**
     * Muestra una notificación de escritorio recibiendo como parametros el
     * titulo y el mensaje.
     *
     * @param title
     * @param message
     */
    public static void show(String title, String message) {
        event = new NiconEvent(title, message, Notification.DEFAULT_MESSAGE);
        notify = new DesktopNotify(event);
        ControlNotify.launchNotify(notify);
    }
    
    /**
     * Muestra una notificación de escritorio recibiendo como parametros el
     * titulo y el mensaje y ademas un booleano que identifica si desea 
     * reproducir un sonido al mostrar la notificacion
     *
     * @param title
     * @param message
     * @param sound
     */
    public static void show(String title, String message,boolean sound) {
        event = new NiconEvent(title, message, Notification.DEFAULT_MESSAGE);
        notify = new DesktopNotify(event);
            if(sound){
                notify.playSound(0);        
            }
        ControlNotify.launchNotify(notify);
    }

    /**
     * Muestra una notificacion de escritorio recibiendo como parametros el 
     * titulo, el mensaje a mostrar y el tipo de notificacion definido en 
     * Notification ej:<p>
     * Notification.OK_MESSAGE<BR>
     * Notification.WARNING_MESSAGE<BR>
     * Notification.ERROR_MESSAGE<BR>
     * Notification.DEFAULT_MESSAGE<BR>
     *
     * @param title
     * @param message
     * @param tipeNotify
     */
    public static void show(String title, String message, int tipeNotify) {
        event = new NiconEvent(title, message, tipeNotify);
        notify = new DesktopNotify(event);
        ControlNotify.launchNotify(notify);
    }
    
     /**
     * Muestra una notificacion de escritorio recibiendo como parametros el 
     * titulo, el mensaje a mostrar y el tipo de notificacion definido en 
     * Notification, ademas un booleano para ejecutar un sonido de acuerdo
     * al tipo de notificacion ej:<p>
     * Notification.OK_MESSAGE<BR>
     * Notification.WARNING_MESSAGE<BR>
     * Notification.ERROR_MESSAGE<BR>
     * Notification.DEFAULT_MESSAGE<BR>
     *
     * @param title
     * @param message
     * @param tipeNotify
     * @param sound
     */
    public static void show(String title, String message, int tipeNotify,boolean sound) {
        event = new NiconEvent(title, message, tipeNotify);
        notify = new DesktopNotify(event);
            if(sound){
                if(event.getTipeMessage()==Notification.OK_MESSAGE){
                    notify.playSound(0);
                    ControlNotify.launchNotify(notify);
                }
                if(event.getTipeMessage()==Notification.WARNING_MESSAGE){
                    notify.playSound(1);
                    ControlNotify.launchNotify(notify);
                }
                if(event.getTipeMessage()==Notification.ERROR_MESSAGE){
                    notify.playSound(2);
                    ControlNotify.launchNotify(notify);
                }
            }
    }

    /**
     * Muestra una notificacion de escritorio recibiendo como parametro el 
     * titulo, el mensaje a mostrar y un tema a usar ej:<p>
     * Notification.NICON_LIGHT_THEME<BR>
     * Notification.NICON_DARK_THEME
     *
     * @param title
     * @param message
     * @param Skin
     */
    public static void show(String title, String message, char Skin) {
        event = new NiconEvent(title, message, Notification.DEFAULT_MESSAGE);
        notify = new DesktopNotify(event, Skin);
        ControlNotify.launchNotify(notify);
    }
    
    
    /**
     * Muestra una notificacion de escritorio recibiendo como parametro el 
     * titulo, el mensaje a mostrar y un tema a usar ej:<p>
     * Notification.NICON_LIGHT_THEME<BR>
     * Notification.NICON_DARK_THEME
     *
     * @param title
     * @param message
     * @param Skin
     * @param sound
     */
    public static void show(String title, String message, char Skin,boolean sound) {
        event = new NiconEvent(title, message, Notification.DEFAULT_MESSAGE);
        notify = new DesktopNotify(event, Skin);
            if(sound){
                notify.playSound(0);
            }
        ControlNotify.launchNotify(notify);
    }

    /**
     * Muesra una notificacion de escritorio recibiendo el titulo, un mensaje y el
     * tipo de Notificacion a mostrar y el tema a usar<P> 
     * Notification.show("title","message",Notification.DEFAUL_MESSAGE,Notification.NICON_LIGHT_THEME
     *
     * @param title
     * @param message
     * @param tipeNotify
     * @param skin
     * @param sound
     */
    public static void show(String title, String message, int tipeNotify, char skin,boolean sound) {
        event = new NiconEvent(title, message, tipeNotify);
        notify = new DesktopNotify(event, skin);
            if(sound){
                if(event.getTipeMessage()==Notification.OK_MESSAGE){
                    notify.playSound(0);
                    ControlNotify.launchNotify(notify);
                }
                if(event.getTipeMessage()==Notification.WARNING_MESSAGE){
                    notify.playSound(1);
                    ControlNotify.launchNotify(notify);
                }
                if(event.getTipeMessage()==Notification.ERROR_MESSAGE){
                    notify.playSound(2);
                    ControlNotify.launchNotify(notify);
                }
            }
    }

    /**
     * Muestra una notificacion de escritorio con un Icono, un titulo, 
     * un mensaje, Ej iconos incorporados:<p>
     * Notification.FACEBOOK_ICON<br>
     * Notification.UPDATE_ICON_GREEN<br>
     * Notification.CALENDAR_ICON<br>
     * Notification.MUSIC_ICON<br>
     * Notification.SECURE_ICON
     * 
     * @param icon
     * @param title
     * @param message
     */
    public static void show(int icon, String title, String message) {
        event = new NiconEvent(title, message, Notification.DEFAULT_MESSAGE);
        notify = new DesktopNotify(event, icon);
        ControlNotify.launchNotify(notify);
    }
    
    /**
     * Muestra una notificacion de escritorio con un Icono, un titulo, 
     * un mensaje, Ej iconos incorporados:<p>
     * Notification.FACEBOOK_ICON<br>
     * Notification.UPDATE_ICON_GREEN<br>
     * Notification.CALENDAR_ICON<br>
     * Notification.MUSIC_ICON<br>
     * Notification.SECURE_ICON
     * 
     * @param icon
     * @param title
     * @param message
     * @param sound
     */
    public static void show(int icon, String title, String message,boolean sound) {
        event = new NiconEvent(title, message, Notification.DEFAULT_MESSAGE);
        notify = new DesktopNotify(event, icon);
            if(sound){
                notify.playSound(0);
            }
        ControlNotify.launchNotify(notify);
    }

    /**
     * crea una notificacion de escritorio con un titulo, un mensaje y un valor
     * entero que presenta un icono especial seleccionando una de las opciones
     * habilitadas dentro de DesktopNotify:
     * <br>DesktopNotify.FACEBOOK_ICON
     * <br>DesktopNotify.NICON_TWITTER_ICON
     * <br>DesktopNotify.TWITTER_OFF_ICON
     * <br>DesktopNotify.UPDATE_ICON
     * <br>DesktopNotify.SECURE_ICON
     * <br>DesktopNotify.GOOGLE_ICON
     * <br>DesktopNotify.DISK_ICON
     * <br>DesktopNotify.GPLUS_ICON
     * <br>DesktopNotify.WEATHER_ICON el Skin que desea usar para la
     * notificacion usando las siguientes Opciones
     * DesktopNotify.NICON_DARK_THEME DesktopNotify.NICON_LIGHT_THEME
     *
     * @param icon
     * @param title
     * @param message
     * @param skin
     */
    public static void show(int icon, String title, String message, char skin) {
        event = new NiconEvent(title, message, Notification.DEFAULT_MESSAGE);
        notify = new DesktopNotify(event, icon, skin);
        ControlNotify.launchNotify(notify);
    }
    
     /**
     * crea una notificacion de escritorio con un titulo, un mensaje y un valor
     * entero que presenta un icono especial seleccionando una de las opciones
     * habilitadas dentro de DesktopNotify:
     * <br>DesktopNotify.FACEBOOK_ICON
     * <br>DesktopNotify.NICON_TWITTER_ICON
     * <br>DesktopNotify.TWITTER_OFF_ICON
     * <br>DesktopNotify.UPDATE_ICON
     * <br>DesktopNotify.SECURE_ICON
     * <br>DesktopNotify.GOOGLE_ICON
     * <br>DesktopNotify.DISK_ICON
     * <br>DesktopNotify.GPLUS_ICON
     * <br>DesktopNotify.WEATHER_ICON el Skin que desea usar para la
     * notificacion usando las siguientes Opciones
     * DesktopNotify.NICON_DARK_THEME DesktopNotify.NICON_LIGHT_THEME
     *
     * @param icon
     * @param title
     * @param message
     * @param skin
     * @param sound
     */
    public static void show(int icon, String title, String message, char skin,boolean sound) {
        event = new NiconEvent(title, message, Notification.DEFAULT_MESSAGE);
        notify = new DesktopNotify(event, icon, skin);
            if(sound){
                notify.playSound(0);
            }
        ControlNotify.launchNotify(notify);
    }
    
    /**
     * Muestra una notificacion de escritorio con un titulo, un mensaje y la ruta
     * de un icono personalizado
     * @param title
     * @param message
     * @param urlIcon 
     */
    public static void show(String title,String message,String urlIcon){
        event=new NiconEvent(title,message,Notification.DEFAULT_MESSAGE);
        notify=new DesktopNotify(event,urlIcon);
        ControlNotify.launchNotify(notify);
    }
    
    /**
     * Muestra una notificacion de escritorio con un titulo, un mensaje y la ruta
     * de un icono personalizado
     * @param title
     * @param message
     * @param urlIcon 
     * @param sound 
     */
    public static void show(String title,String message,String urlIcon,boolean sound){
        event=new NiconEvent(title,message,Notification.DEFAULT_MESSAGE);
        notify=new DesktopNotify(event,urlIcon);
            if(sound){
                notify.playSound(0);
            }
        ControlNotify.launchNotify(notify);
    }
    
    
    /**
     * Muestra una notificacion de escritorio con un titulo, un mensaje, la ruta
     * del icono personalizado y el caracter del Thema a usar:<p>
     * Notification.NICON_DARK_THEME<br>
     * Notification.NICON_LIGHT_THEME
     * @param title
     * @param message
     * @param urlIcon
     * @param skin 
     */
    public static void show(String title,String message, String urlIcon, char skin){
        event=new NiconEvent(title,message,Notification.DEFAULT_MESSAGE);
        notify=new DesktopNotify(event,urlIcon,skin);
        ControlNotify.launchNotify(notify);
    }
    
    /**
     * Muestra una notificacion de escritorio con un titulo, un mensaje, la ruta
     * del icono personalizado y el caracter del Thema a usar:<p>
     * Notification.NICON_DARK_THEME<br>
     * Notification.NICON_LIGHT_THEME
     * @param title
     * @param message
     * @param urlIcon
     * @param skin 
     * @param sound 
     */
    public static void show(String title,String message, String urlIcon, char skin,boolean sound){
        event=new NiconEvent(title,message,Notification.DEFAULT_MESSAGE);
        notify=new DesktopNotify(event,urlIcon,skin);
            if(sound){
                notify.playSound(0);
            }
        ControlNotify.launchNotify(notify);
    }
    
    /**
     * Este metodo muestra una notificacion de escritorio del tipo confirmacion
     * recibe un titulo, un mensae y el tipo de notificacion
     * @param title
     * @param message
     * @param optionType
     * @return 
     */
    public static int showConfirm(String title, String message, int optionType){
        option=-1;
        event=new NiconEvent(title,message,optionType);
        confirm = new DesktopConfirm(event);
        ControlNotify.launchNotify(confirm);
            while(confirm.isShowing()!=true){
                option=confirm.getSelectedOption();
                break;
            }
        return option;
    }
    
    /**
     * Permite crear una notificacion de escritorio del tipo confirm, recibiendo
     * como parametros el titulo, el mensaje, el tipo de notificacion bien sea
     * de error, advertencia, ok y recibe el thema a usar.
     * @param title
     * @param message
     * @param optionType
     * @param NiconTheme
     * @return 
     */
    
    public static int showConfirm(String title, String message,int optionType,char NiconTheme){
        option=-1;
        event=new NiconEvent(title,message,optionType);
        confirm = new DesktopConfirm(event,NiconTheme);
        ControlNotify.launchNotify(confirm);
            while(confirm.isShowing()!=true){
                option=confirm.getSelectedOption();
                break;
            }
        return option;        
    }
    
    /**
     * Muestra una notificacion de escritorio del tipo de confirmacion la cual
     * contiene un titulo, un mensaje, un tipo de notificacion y un booleano que
     * especifica la reproduccion de un sonido
     * @param title
     * @param message
     * @param optionType
     * @param sound
     * @return int response
     */
    public static int showConfirm(String title, String message, int optionType,boolean sound){
        option=-1;
        event=new NiconEvent(title,message,optionType);
        confirm = new DesktopConfirm(event);
            if(sound){
                    if(event.getTipeMessage()==Notification.OK_MESSAGE){
                        confirm.playSound(0);
                        ControlNotify.launchNotify(confirm);
                    }
                    if(event.getTipeMessage()==Notification.WARNING_MESSAGE){
                        confirm.playSound(1);
                        ControlNotify.launchNotify(confirm);
                    }
                    if(event.getTipeMessage()==Notification.ERROR_MESSAGE){
                        confirm.playSound(2);
                        ControlNotify.launchNotify(confirm);
                    }
                }
        while(confirm.isShowing()!=true){
            option=confirm.getSelectedOption();
            break;
        }
        return option;
    }
    
        
    /**
     * Muestra la informacion básica de NiconNotifyOSD
     */
    public static void showVersionLib(){
        String title=NotifyConfig.getInstance().getNameLib();
        String version=NotifyConfig.getInstance().getVersionLib();
        String info=NotifyConfig.getInstance().getInfoLib();
        event=new NiconEvent(title,"Version: "+version+"\n"+info,Notification.DEFAULT_MESSAGE);
        notify=new DesktopNotify(event,Notification.INFO_ICON,Notification.NICON_LIGHT_THEME);
        ControlNotify.launchNotify(notify);
    }

}
