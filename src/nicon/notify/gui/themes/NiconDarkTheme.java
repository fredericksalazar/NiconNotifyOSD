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

package nicon.notify.gui.themes;

/**
 *Esta clase define un objeto NiconTheme que tiene colores oscuros como 
 *base para las notificaciones de escritorio Java, define el color de fondo
 *color de fuentes.
 */
public class NiconDarkTheme extends NiconTheme{
    
    private final String bakcgroundPanel="232323";
    private final String titleForeground="ecf0f1";
    private final String messageForeground="ecf0f1";
    
    private final String titleWarningForeground="f39c12";
    private final String titleErrorForeground="e74c3c";
    private final String titleOKForeground="3498db";
    
    private static NiconDarkTheme instance;
    
    /**
     * Retorna el color de fondo del panel para la notificacion
     * @return 
     */
    @Override
    public String getBakcgroundPanel() {
        return bakcgroundPanel;
    }
    
    /**
     * Retorna el color de fuente del titulo
     * @return 
     */
    @Override
    public String getTitleForeground() {
        return titleForeground;
    }
    
    /**
     * Retorna color de fuente del cuerpo de mensaje
     * @return 
     */
    @Override
    public String getMessageForeground() {
        return messageForeground;
    }
    
    /**
     * Retorna color de fuente de titulo para mensajes de advertencia
     * @return 
     */
    @Override
    public String getTitleWarningForeground() {
        return titleWarningForeground;
    }
    
    /**
     * Retorna el color de fuente de titulo para mensajes de Error
     * @return 
     */
    @Override
    public String getTitleErrorForeground() {
        return titleErrorForeground;
    }
    
    /**
     * Retorna el color de fuente de titulo para mensajes de exito
     * @return 
     */
    @Override
    public String getTitleOKForeground() {
        return titleOKForeground;
    }
    
    /**
     * Retorna una instancia de objeto del tema
     * @return 
     */
    public static NiconDarkTheme getInstance(){
        if(instance==null){
            instance=new NiconDarkTheme();
        }
        return instance;
    }
    
}
