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

package nicon.notify.core;

import nicon.notify.core.server.ServerOSD;
import nicon.notify.core.util.NotifyConfig;
import nicon.notify.gui.desktopNotify.DesktopConfirm;
import nicon.notify.gui.desktopNotify.DesktopNotify;


/*
 * Notification es el API principal de NiconNotifyOSD, a traves de este API
 * se pueden crear las notificaciones de escritorio que provee el paquete 
 * y pasar los parámetros básicos necesarios para poder hacer uso de NiconNotifyOSD
 * 
 * requieriments: Java 1.6 or superior
 * Created in: NetBeans 8.0.2
 * OS Supported: GNU/Linux, Mac and Windows
 * 
 * @author Frederick Adolfo Salazar Sanchez
 * @version 1.98
 * Modificado: 29/08/2015
 */

public class Notification {
    
    private static ServerOSD serverOSD;
    private static final int time_out = 10000;

    public final static byte OK_MESSAGE = 0;
    public final static byte ERROR_MESSAGE = 1;
    public final static byte WARNING_MESSAGE = 2;
    public final static byte CONFIRM_MESSAGE = 3;
    public final static byte DEFAULT_MESSAGE = 4;

    /*
      variables estaticas para el manejo de los iconos
    */
    
    public final static short FACEBOOK_ICON = 1;
    public final static short TWITTER_ON_ICON = 2;
    public final static short TWITTER_OFF_ICON = 3;
    public final static short UPDATE_ICON_GREEN = 4;
    public final static short SECURE_ICON = 5;
    public final static short GOOGLE_ICON = 6;
    public final static short DISK_ICON = 7;
    public final static short GPLUS_ICON = 8;
    public final static short WEATHER_ICON = 9;
    public final static short WIFI_ICON = 10;
    public final static short DOWNLOAD_ICON = 11;
    public final static short RSS_ICON = 12;
    public final static short UPDATE_ICON_BLUE = 13;
    public final static short EVERNOTE_ICON = 14;
    public final static short MESSAGE_ICON_ORANGE = 15;
    public final static short MESSAGE_ICON_BLUE = 16;
    public final static short MUSIC_ICON = 17;
    public final static short SHIELD_ICON = 18;
    public final static short PLUGIN_ICON = 19;
    public final static short MAIL_ICON_RED = 20;
    public final static short MAIL_ICON_BLUE = 21;
    public final static short IMAGE_ICON=22;
    public final static short NOTES_ICON=23;
    public final static short CALENDAR_ICON=24;
    public final static short INFO_ICON=25;
    public final static short BAT_FULL=26;
    public final static short BAT_MED=27;
    public final static short BAT_DOWN=28;
    public final static short CONTACT_ICON = 29;
    public final static short DISK_ORANGE = 30;
    public final static short ALARM_ICON = 31;
    public final static short NICON_SYSTEM = 32;

    
    /*
     *  Variables estaticas para los NiconThee
     */
    
    public final static char NICON_DARK_THEME = 'D';
    public final static char NICON_LIGHT_THEME = 'L';
    public final static char NICON_GRAY_THEME = 'G';

    
    private static DesktopNotify notify;
    private static NiconEvent event;
    private static DesktopConfirm confirm;
    private static int option;

    
    /**
     * Crea una notificacion de escritorio recibiendo como parámetros el titulo
     * el mensaje y un thema que puede usar asi:
     * <br>
     * <br>Notification.Nicon_Light_Theme
     * <br>Notification.Nicon_Dark_Theme
     * @param title
     * @param message
     * @param theme 
     */
    
    public static void show(String title, String message,char theme) {
        init_Server();
        event = new NiconEvent(title, message, Notification.DEFAULT_MESSAGE);
        notify = new DesktopNotify(event,theme);
        serverOSD.send(notify, time_out);
    }
    
    
    /**
     * Crea una notificacion de escritorio recibiendo como parámetros el titulo
     * el mensaje, un thema y el tiempo que desea se muestre la notificacion,si
     * desea que la notificación no se cierre puede usar como parámetro -1
     * 
     * @param title
     * @param message
     * @param theme
     * @param timeout 
     */
    
    public static void show(String title, String message,char theme,int timeout) {
        init_Server();
        event = new NiconEvent(title, message, Notification.DEFAULT_MESSAGE);
        notify = new DesktopNotify(event,theme);
        serverOSD.send(notify, timeout);
    }
    
    
    /**
     * Crea una notificacion de escritorio recibiendo como parámetros el titulo
     * el mensaje, un thema y el tipo de notificacion que desea usar, los tipos
     * pueden ser de Warning,Error,OK,Default y puede usarlos de la siguiente
     * manera:
     * <p>
     * Notification.OK_MESSAGE<BR>
     * Notification.WARNING_MESSAGE<BR>
     * Notification.ERROR_MESSAGE<BR>
     * Notification.DEFAULT_MESSAGE<BR>
     *
     * @param title
     * @param message
     * @param theme
     * @param type
     */
    
    public static void show(String title, String message,char theme, byte type) {
        init_Server();
        event = new NiconEvent(title, message, type);
        notify = new DesktopNotify(event,theme);
        serverOSD.send(notify, time_out);
    }
    
    
     /**
     * Crea una notificacion de escritorio recibiendo como parámetros el titulo
     * el mensaje, un thema, el tipo de notificacion que desea lanzar (Warning,
     * Error,OK,Default) y el tiempo que desea mostrar la notificacion
     *
     * @param title
     * @param message
     * @param theme
     * @param type
     * @param timeout
     */
    
    public static void show(String title, String message,char theme, byte type, int timeout) {
        init_Server();
        event = new NiconEvent(title, message, type);
        notify = new DesktopNotify(event,theme);
        serverOSD.send(notify, timeout);
    }
    
    
    /**
     * Crea una notificacion de escritorio recibiendo como parámetros el titulo
     * el mensaje, un thema y un boolean sound que permite reproducir un sonido
     * al momento de lanzar la notificación
     *
     * @param title
     * @param message
     * @param theme
     * @param sound
     */
    
    public static void show(String title, String message,char theme, boolean sound) {
        init_Server();
        event = new NiconEvent(title, message, Notification.DEFAULT_MESSAGE);
        notify = new DesktopNotify(event,theme);
            if(sound) notify.playSound(0);        
        serverOSD.send(notify, time_out);
    }
    
    /**
     * Crea una notificacion de escritorio recibiendo como parámetros el titulo
     * el mensaje, un thema, un boolean sound y el tiempo que desea mostrar la
     * notificacion en la pantalla
     *
     * @param title
     * @param message
     * @param theme
     * @param sound
     * @param timeout
     */
    
    public static void show(String title, String message,char theme, boolean sound,int timeout) {
        init_Server();
        event = new NiconEvent(title, message, Notification.DEFAULT_MESSAGE);
        notify = new DesktopNotify(event,theme);
            if(sound) notify.playSound(0); 
        serverOSD.send(notify, timeout);
    }
    
    
    /**
     * Crea una notificacion de escritorio recibiendo como parámetros el titulo
     * el mensaje, un thema, un boolean sound y el tipo de notificacion, de 
     * acuerdo al tipo de notificación que se use (Warning,Error,OK,Defaul) 
     * sera el tipo de sonido que se reproduce al momento de lanzar la notificación
     * notificación
     *
     * @param title
     * @param message
     * @param theme
     * @param sound
     * @param type
     */
    
    public static void show(String title, String message,char theme,boolean sound, byte type) {
        init_Server();
        event = new NiconEvent(title, message, type);
        notify = new DesktopNotify(event,theme);
        
            if(sound){
                if(event.getTipeMessage()==Notification.OK_MESSAGE)
                    notify.playSound(0);
                    
                if(event.getTipeMessage()==Notification.WARNING_MESSAGE)
                    notify.playSound(1);
                
                if(event.getTipeMessage()==Notification.ERROR_MESSAGE)
                    notify.playSound(2);
            }
        serverOSD.send(notify, time_out);
    }
    
    
    /**
     * Crea una notificacion de escritorio recibiendo como parámetros el titulo
     * el mensaje, un thema, un boolean sound, el tipo de notificacion que se
     * desea lanzar (Warning,Error,OK,Default) y el tiempo que desea que se
     * muestre la notificacion en el escritorio
     *
     * @param title
     * @param message
     * @param theme
     * @param sound
     * @param type
     * @param timeout
     */
    
    public static void show(String title, String message,char theme,boolean 
                            sound, byte type,int timeout) {
        init_Server();
        event = new NiconEvent(title, message, type);
        notify = new DesktopNotify(event,theme);
       
            if(sound){
                if(event.getTipeMessage()==Notification.OK_MESSAGE)
                    notify.playSound(0);
                
                if(event.getTipeMessage()==Notification.WARNING_MESSAGE)
                    notify.playSound(1);
                
                if(event.getTipeMessage()==Notification.ERROR_MESSAGE)
                    notify.playSound(2);
            }
        serverOSD.send(notify, timeout);
    }

    
    /**
     * Crea una notificacion de escritorio recibiendo como parámetros el titulo
     * el mensaje, un thema, y un icono proveido por Nitrux dentro del paquete
     * nicon.notify.gui.icons.Nitrux los iconos puedes usarlos invocando el API
     * Notification de la siguiente manera, ejemplos:
     * <br>
     * Notification.FACEBOOK_ICON<BR>
     * Notification.MUSIC_ICON<br>
     * 
     * @param icon
     * @param title
     * @param theme
     * @param message 
     */
    
    public static void show(String title, String message,char theme,short icon) {
        init_Server();
        event = new NiconEvent(title, message, Notification.DEFAULT_MESSAGE);
        notify = new DesktopNotify(event, icon, theme);
        serverOSD.send(notify, time_out);
    }
    
    
    /**
     * Crea una notificacion de escritorio recibiendo como parámetros el titulo
     * el mensaje, un thema, un icono y el tiempo que desea que se muestre la
     * notificacion en el escritorio
     * 
     * @param icon
     * @param title
     * @param theme
     * @param message 
     * @param timeout 
     */
    
    public static void show(String title, String message,char theme,short icon,int timeout) {
        init_Server();
        event = new NiconEvent(title, message, Notification.DEFAULT_MESSAGE);
        notify = new DesktopNotify(event, icon, theme);
        serverOSD.send(notify, timeout);
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
     * @param theme
     * @param message
     * @param sound
     */
    public static void show(String title, String message,char theme,short icon,boolean sound) {
        init_Server();
        event = new NiconEvent(title, message, Notification.DEFAULT_MESSAGE);
        notify = new DesktopNotify(event, icon,theme);
        serverOSD.send(notify, time_out);
            if(sound){
                notify.playSound(0);
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
     * @param theme
     * @param message
     * @param sound
     * @param timeout
     */
    public static void show(String title, String message,char theme,short icon,boolean sound,int timeout) {
        init_Server();
        event = new NiconEvent(title, message, Notification.DEFAULT_MESSAGE);
        notify = new DesktopNotify(event, icon,theme);
        serverOSD.send(notify, timeout);
            if(sound){
                notify.playSound(0);
            }
    }

    
    /**
     * Este metodo muestra una notificacion de escritorio del tipo confirmacion
     * recibe un titulo, un mensae y el tipo de notificacion
     * @param title
     * @param message
     * @param theme
     * @return 
     */
    public static int showConfirm(String title, String message,char theme){
        init_Server();
        option=-1;
        event=new NiconEvent(title,message,Notification.DEFAULT_MESSAGE);
        confirm = new DesktopConfirm(event,theme);
        serverOSD.send(confirm, time_out);
            while(confirm.isShowing()!=true){
                option=confirm.getSelectedOption();
                break;
            }
        return option;
    }
    
    
    /**
     * Este metodo muestra una notificacion de escritorio del tipo confirmacion
     * recibe un titulo, un mensae y el tipo de notificacion
     * @param title
     * @param message
     * @param theme
     * @param timeout
     * @return 
     */
    public static int showConfirm(String title, String message,char theme,int timeout){
        init_Server();
        option=-1;
        event=new NiconEvent(title,message,Notification.DEFAULT_MESSAGE);
        confirm = new DesktopConfirm(event,theme);
        serverOSD.send(confirm, timeout);
            while(confirm.isShowing()!=true){
                option=confirm.getSelectedOption();
                break;
            }
        return option;
    }
    
    
    /**
     * Este metodo muestra una notificacion de escritorio del tipo confirmacion
     * recibe un titulo, un mensae y el tipo de notificacion
     * @param title
     * @param message
     * @param theme
     * @param type
     * @return 
     */
    public static int showConfirm(String title, String message,char theme, byte type){
        init_Server();
        option=-1;
        event=new NiconEvent(title,message,type);
        confirm = new DesktopConfirm(event,theme);
        serverOSD.send(confirm, time_out);
            while(confirm.isShowing()!=true){
                option=confirm.getSelectedOption();
                break;
            }
        return option;
    }
    
    
    /**
     * Este metodo muestra una notificacion de escritorio del tipo confirmacion
     * recibe un titulo, un mensae y el tipo de notificacion
     * @param title
     * @param message
     * @param theme
     * @param type
     * @param timeout
     * @return 
     */
    public static int showConfirm(String title, String message,char theme, byte type,int timeout){
        init_Server();
        option=-1;
        event=new NiconEvent(title,message,type);
        confirm = new DesktopConfirm(event,theme);
        serverOSD.send(confirm, timeout);
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
     * @param theme
     * @param sound
     * @return int response
     */
    public static int showConfirm(String title, String message,char theme,boolean sound){
        init_Server();
        option=-1;
        event=new NiconEvent(title,message,Notification.DEFAULT_MESSAGE);
        confirm = new DesktopConfirm(event);
        serverOSD.send(confirm, time_out);
            if(sound){
                confirm.playSound(0);
            }
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
     * @param theme
     * @param sound
     * @param timeout
     * @return int response
     */
    public static int showConfirm(String title, String message,char theme,boolean sound,int timeout){
        init_Server();
        option=-1;
        event=new NiconEvent(title,message,Notification.DEFAULT_MESSAGE);
        confirm = new DesktopConfirm(event,theme);
        serverOSD.send(confirm, timeout);
            if(sound){
                  confirm.playSound(0);
            }
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
     * @param theme
     * @param sound
     * @param type
     * @return int response
     */
    public static int showConfirm(String title, String message,char theme,boolean sound,byte type){
        init_Server();
        option=-1;
        event=new NiconEvent(title,message,type);
        confirm = new DesktopConfirm(event);
        serverOSD.send(confirm, time_out);
            if(sound){
                    if(event.getTipeMessage()==Notification.OK_MESSAGE){
                        confirm.playSound(0);
                    }
                    if(event.getTipeMessage()==Notification.WARNING_MESSAGE){
                        confirm.playSound(1);
                    }
                    if(event.getTipeMessage()==Notification.ERROR_MESSAGE){
                        confirm.playSound(2);
                    }
                }
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
     * @param theme
     * @param sound
     * @param type
     * @param timeout
     * @return int response
     */
    public static int showConfirm(String title, String message,char theme,boolean sound,byte type,int timeout){
        init_Server();
        option=-1;
        event=new NiconEvent(title,message,type);
        confirm = new DesktopConfirm(event);
        serverOSD.send(confirm, timeout);
            if(sound){
                    if(event.getTipeMessage()==Notification.OK_MESSAGE){
                        confirm.playSound(0);
                    }
                    if(event.getTipeMessage()==Notification.WARNING_MESSAGE){
                        confirm.playSound(1);
                    }
                    if(event.getTipeMessage()==Notification.ERROR_MESSAGE){
                        confirm.playSound(2);
                    }
                }
        while(confirm.isShowing()!=true){
            option=confirm.getSelectedOption();
            break;
        }
        return option;
    }
    
    
    /**
     * Este metodo muestra una notificacion de escritorio del tipo confirmacion
     * recibe un titulo, un mensae y el tipo de notificacion
     * @param title
     * @param message
     * @param theme
     * @param icon
     * @return 
     */
    public static int showConfirm(String title, String message,char theme,short icon){
        init_Server();
        option=-1;
        event=new NiconEvent(title,message,Notification.DEFAULT_MESSAGE);
        confirm = new DesktopConfirm(event,theme,icon);
        serverOSD.send(confirm, time_out);
            while(confirm.isShowing()!=true){
                option=confirm.getSelectedOption();
                break;
            }
        return option;
    }
    
    
    /**
     * Este metodo muestra una notificacion de escritorio del tipo confirmacion
     * recibe un titulo, un mensae y el tipo de notificacion
     * @param title
     * @param message
     * @param theme
     * @param icon
     * @param timeout
     * @return 
     */
    public static int showConfirm(String title, String message,char theme,short icon,int timeout){
        init_Server();
        option=-1;
        event=new NiconEvent(title,message,Notification.DEFAULT_MESSAGE);
        confirm = new DesktopConfirm(event,theme,icon);
        serverOSD.send(confirm, timeout);
            while(confirm.isShowing()!=true){
                option=confirm.getSelectedOption();
                break;
            }
        return option;
    }
    
    
    /**
     * Este metodo muestra una notificacion de escritorio del tipo confirmacion
     * recibe un titulo, un mensae y el tipo de notificacion
     * @param title
     * @param message
     * @param theme
     * @param icon
     * @param sound
     * @return 
     */
    public static int showConfirm(String title, String message,char theme,short icon,boolean sound){
        init_Server();
        option=-1;
        event=new NiconEvent(title,message,Notification.DEFAULT_MESSAGE);
        confirm = new DesktopConfirm(event,theme,icon);
        serverOSD.send(confirm, time_out);
            if(sound){
                confirm.playSound(0);
            }
            while(confirm.isShowing()!=true){
                option=confirm.getSelectedOption();
                break;
            }
        return option;
    }
    
    
    /**
     * Crea una notificacion de escritorio de tipo confirmacion o ConfirmNotify
     * que permite seleccionar una accion aceptar o cancelar segun desea el
     * usuario, recibe como paramentros:
     * @param title
     * @param message
     * @param theme
     * @param icon
     * @param sound
     * @param timeout
     * @return 
     */
    public static int showConfirm(String title, String message,char theme,short icon,boolean sound,int timeout){
        init_Server();
        option=-1;
        event=new NiconEvent(title,message,Notification.DEFAULT_MESSAGE);
        confirm = new DesktopConfirm(event,theme,icon);
        serverOSD.send(confirm, timeout);
            if(sound){
                confirm.playSound(0);
            }
            while(confirm.isShowing()!=true){
                option=confirm.getSelectedOption();
                break;
            }
        return option;
    }
 
    
    /**
     * Inicialia el servidor de notificaciones ServerOSD.
     */
    
    private static void init_Server(){
        System.out.println("Starting NiconNotifyOSD "+NotifyConfig.getInstance().getVersionLib());
        serverOSD = ServerOSD.getInstance();
    }

    
    /**
     * Muestra la informacion básica de NiconNotifyOSD
     */
    public static void showVersionLib(){
        init_Server();
        String title=NotifyConfig.getInstance().getNameLib();
        String version=NotifyConfig.getInstance().getVersionLib();
        String info=NotifyConfig.getInstance().getInfoLib();
        event=new NiconEvent(title,"Version: "+version+"\n"+info,Notification.DEFAULT_MESSAGE);
        notify=new DesktopNotify(event,Notification.NICON_SYSTEM,Notification.NICON_DARK_THEME);
        serverOSD.send(notify, time_out);
    }

}
