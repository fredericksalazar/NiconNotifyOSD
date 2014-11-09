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
import nicon.notify.gui.desktopNotify.DesktopNotify;


public class Notification {
    
    private static DesktopNotify notify;   
    private static NiconEvent event;
     
    
    /**
     * Crea una Notificacion de escritorio con un titulo y un mensaje
     * @param title
     * @param message 
     */
    public static void showNotify(String title, String message){
        event=new NiconEvent(title,message,NiconEvent.NOTIFY_DEFAULT);
        notify=new DesktopNotify(event);
        ControlNotify.launchNotify(notify);
    }
    
    /**
     * Crea una notificacion de escritorio recibiendo el titulo, un mensaje y
     * el tipo de Notificacion a mostrar, NiconEvent.Error NiconEvent.Warning
     * NiconEvent.Default NiconEvent.OK
     * @param title
     * @param message
     * @param tipeNotify 
     */
    public static void showNotify(String title, String message, int tipeNotify){
        event=new NiconEvent(title,message,tipeNotify);
        notify=new DesktopNotify(event);
        ControlNotify.launchNotify(notify);
    }
    
    /**
     * Crea una notificacion de escritorio con un titulo y un mensaje y el Skin
     * desea usar para la notificacion usando las siguientes Opciones
     * DesktopNotify.NICON_DARK_THEME
     * DesktopNotify.NICON_LIGHT_THEME
     * @param title
     * @param message 
     * @param Skin 
     */
    public static void showNotify(String title, String message,String Skin){
        event=new NiconEvent(title,message,NiconEvent.NOTIFY_DEFAULT);
        notify=new DesktopNotify(event,Skin);
        ControlNotify.launchNotify(notify);
    }
    
       
    /**
     * Crea una notificacion de escritorio recibiendo el titulo, un mensaje y
     * el tipo de Notificacion a mostrar, NiconEvent.Error NiconEvent.Warning
     * NiconEvent.Default NiconEvent.OK y el Skin que
     * desea usar para la notificacion usando las siguientes Opciones
     * DesktopNotify.NICON_DARK_THEME
     * DesktopNotify.NICON_LIGHT_THEME
     * 
     * @param title
     * @param message
     * @param tipeNotify 
     * @param skin 
     */    
    public static void showNotify(String title, String message, int tipeNotify,String skin){
        event=new NiconEvent(title,message,tipeNotify);
        notify=new DesktopNotify(event,skin);
        ControlNotify.launchNotify(notify);
    }    
    
    /**
     * crea una notificacion de escritorio con un titulo, un mensaje y un valor
     * entero que presenta un icono especial seleccionando una de las opciones 
     * habilitadas dentro de DesktopNotify:
     * <br>DesktopNotify.NICON_FACEBOOK_ICON
     * <br>DesktopNotify.NICON_TWITTER_ICON
     * <br>DesktopNotify.NICON_TWITTER_OFF_ICON
     * <br>DesktopNotify.NICON_UPDATE_ICON
     * <br>DesktopNotify.NICON_SECURE_ICON
     * <br>DesktopNotify.NICON_GOOGLE_ICON
     * <br>DesktopNotify.NICON_HARD_ICON
     * <br>DesktopNotify.NICON_GPLUS_ICON
     * <br>DesktopNotify.NICON_WEATHER_ICON
     * 
     * @param tipeIcon
     * @param title
     * @param message
     */
    public static void showNotify(int tipeIcon,String title, String message){
        event=new NiconEvent(title,message,NiconEvent.NOTIFY_DEFAULT);
        notify=new DesktopNotify(event, tipeIcon);
        ControlNotify.launchNotify(notify);
    }
    
    /**
     * crea una notificacion de escritorio con un titulo, un mensaje y un valor
     * entero que presenta un icono especial seleccionando una de las opciones 
     * habilitadas dentro de DesktopNotify:
     * <br>DesktopNotify.NICON_FACEBOOK_ICON
     * <br>DesktopNotify.NICON_TWITTER_ICON
     * <br>DesktopNotify.NICON_TWITTER_OFF_ICON
     * <br>DesktopNotify.NICON_UPDATE_ICON
     * <br>DesktopNotify.NICON_SECURE_ICON
     * <br>DesktopNotify.NICON_GOOGLE_ICON
     * <br>DesktopNotify.NICON_HARD_ICON
     * <br>DesktopNotify.NICON_GPLUS_ICON
     * <br>DesktopNotify.NICON_WEATHER_ICON
     * el Skin que
     * desea usar para la notificacion usando las siguientes Opciones
     * DesktopNotify.NICON_DARK_THEME
     * DesktopNotify.NICON_LIGHT_THEME 
     * 
     * @param tipeIcon
     * @param title
     * @param message
     * @param skin
     */
    public static void showNotify(int tipeIcon,String title, String message,String skin){
        event=new NiconEvent(title,message,NiconEvent.NOTIFY_DEFAULT);
        notify=new DesktopNotify(event, tipeIcon,skin);
        ControlNotify.launchNotify(notify);
    }
    
}