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

/**
 * Esta clase será la encargada de crear objetos del tipo Notifyevent que serán
 * mostrados al usuario a traves de NotifyOSD, cada notifYEvent deberá poseer
 * un codigo de evento que define si es un mensaje de error, de alerta un mensaje
 * positivo.
 * 
 * @author Frederick Adolfo Salazar Sanchez
 */

public class NiconEvent {
        
    private String titleEvent;
    private String textEvent;
    private byte tipeMessage;
    private boolean sound;
    private int time;


    /**
     * Crea un objeto NiconEvent basico, asigna los atributos faltantes a valores por
     * defecto
     *
     * @param titulo titulo del event
     * @param mensaje el mensaje del evento
     * @param tipeMessage tipo de evento
     */

    public NiconEvent(String titulo, String mensaje,byte tipeMessage){
        this.titleEvent = titulo;
        this.textEvent = mensaje;
        this.tipeMessage = tipeMessage;
        this.time = Notification.TIME_OUT;
        this.sound = Notification.SOUND;
    }

    /**
     * Crea un objeto NiconEvent basico, asigna los atributos faltantes a valores por
     * defecto
     *
     * @param titulo titulo del evento
     * @param mensaje mensaje del evento
     * @param tipeMessage tipo de evento
     */

    public NiconEvent(String titulo, String mensaje,byte tipeMessage, boolean sonido){
        this.titleEvent = titulo;
        this.textEvent = mensaje;
        this.tipeMessage = tipeMessage;
        this.time = Notification.TIME_OUT;
        this.sound = sonido;
    }


    /**
     * Crea un objeto NiconEvent basico, asigna los atributos faltantes a valores po
     * defecto
     *
     * @param titulo titulo del evento
     * @param mensaje mensaje del evento
     * @param tipeMessage tipo de evento
     */

    public NiconEvent(String titulo, String mensaje,byte tipeMessage, int time){
        this.titleEvent = titulo;
        this.textEvent = mensaje;
        this.tipeMessage = tipeMessage;
        this.time = time*1000;
        this.sound = false;
    }


    /**
     * Crea un objeto Event que contiene la informacion de la notificacion
     * @param titleEvent titulo del evento
     * @param textEvent mensaje del evento
     * @param tipeMessage tipo de evento
     */

    public NiconEvent(String titleEvent, String textEvent, byte tipeMessage,int time,boolean sound) {
        this.titleEvent = titleEvent;
        this.textEvent = textEvent;
        this.tipeMessage = tipeMessage;
        this.time = time*1000;
        this.sound = sound;
    }   

    /**
     * retorna el titulo del evento
     * @return String titleEvent
     */
    public String getTitleEvent() {

        return titleEvent;
    }

    /**
     * retorna el texto del mensaje del NotifyEvent
     * @return String textEvent
     */
    public String getTextEvent() {

        return textEvent;
    }

    /**
     * retorna el tipo de mensaje que tiene el NotifyEvent (Error,Warning,OK)
     * @return int tipeMessage
     */
    public int getTipeMessage() {

        return tipeMessage;
    }

    public boolean isSound() {

        return sound;
    }

    public void setSound(boolean sound) {
        this.sound = sound;
    }

    public int getTime() {

        return time;
    }

    public void setTime(int time) {

        this.time = time;
    }

    @Override
    public String toString() {
        return "NiconEvent: " + "titleEvent=" + titleEvent + ", textEvent=" + textEvent + ", tipeMessage=" + tipeMessage;
    }
}

