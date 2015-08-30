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

package nicon.notify.gui.themes;


/**
 *Esta clase define un objeto NiconTheme que tiene colores oscuros como 
 *base para las notificaciones de escritorio Java, define el color de fondo
 *color de fuentes.
 */

public class NiconDarkTheme extends NiconTheme{
    
    
    private final String nameTheme;
    private final String bakcgroundPanel;
    private final String titleForeground;
    private final String messageForeground;    
    private final String titleWarningForeground;
    private final String titleErrorForeground;
    private final String titleOKForeground;
    
    private static NiconDarkTheme instance;
    
    
    /**
     * Crea un objeto NiconDarkTheme que tiene las configuraciones gráficas 
     * para ajustar una notificacion en tono Dark
     */
    
    private NiconDarkTheme(){
        this.nameTheme = "Dark";
        this.bakcgroundPanel = "303030";
        this.titleForeground = "FFFFFF";
        this.messageForeground = "EEEEEE";
        this.titleWarningForeground = "f39c12";
        this.titleErrorForeground = "e74c3c";
        this.titleOKForeground = "4BAF4F";
    }
    
    
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

    
    @Override
    public String getNameTheme() {
        return nameTheme;
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
