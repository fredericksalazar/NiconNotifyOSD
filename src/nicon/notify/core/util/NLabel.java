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

package nicon.notify.core.util;

import javax.swing.JTextArea;

/**
 * NLabel es un componente usado para mostrar testos multilineas en todas las 
 * notificaciones del sistema, hereda directamente de <b> JTextArea</b> y permite
 * mostrar la informacion de los mensajes de los objetos NiconEvent
 * @author frederick
 */
public class NLabel extends JTextArea{
    
    private final String text;

    /**
     *
     * @param text
     */
    public NLabel(String text) {
        super(text);
        this.text = text;        
        this.setEditable(false);
        this.setLineWrap(true);
        this.setBackground(null);
        this.setBorder(null);
        this.setWrapStyleWord(true);
        this.setFocusable(false);        
    }
    
    
}
