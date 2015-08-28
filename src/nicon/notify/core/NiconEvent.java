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
        
    private final String titleEvent;    
    private final String textEvent;
    private final byte tipeMessage;

    /**
     * Crea un objeto Event que contiene la informacion de la notificacion
     * @param titleEvent
     * @param textEvent
     * @param tipeMessage
     */
    public NiconEvent(String titleEvent, String textEvent, byte tipeMessage) {
        this.titleEvent = titleEvent;
        this.textEvent = textEvent;
        this.tipeMessage = tipeMessage;
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

    @Override
    public String toString() {
        return "NiconEvent: " + "titleEvent=" + titleEvent + ", textEvent=" + textEvent + ", tipeMessage=" + tipeMessage;
    }
}

