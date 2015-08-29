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
 * NiconLightTheme es una de las bases graficas y de configuracion de UI de las
 * notificaciones de escritorio NiconNotifyOSD, el NiconLightTheme representa 
 * un tema de colores claros basados en un fondo de color Blanco y el gris 
 * oscuro y claro para resaltar el contenido de los textos.
 * 
 * @author Frederick Adolfo Salazar Sanchez
 */

public class NiconLightTheme extends NiconTheme{
    
    private final String nameTheme;
    private final String bakcgroundPanel;
    private final String titleForeground;
    private final String messageForeground;    
    private final String titleWarningForeground;
    private final String titleErrorForeground;
    private final String titleOKForeground;
    
    private static NiconLightTheme instance;
    
    
    /**
     * Crea un objeto de tipo NiconTheme adoptando las caracteristicas de 
     * NiconLightTheme con un fondo claro y fuentes grises.
     */
    
    private NiconLightTheme(){
        this.nameTheme = "Light";
        this.bakcgroundPanel = "F8F8F8";
        this.titleForeground = "313030";
        this.messageForeground = "777777";
        this.titleWarningForeground = "C34000";
        this.titleErrorForeground = "C91313";
        this.titleOKForeground = "4BAF4F";
    }

    /**
     * Retorna el color de fondo de la notificacion
     * @return
     */
    @Override
    public String getBakcgroundPanel() {
        return bakcgroundPanel;
    }
    
    
    /**
     * Retorna el color de fuente del titulo de la notificacion
     * @return
     */
    @Override
    public String getTitleForeground() {
        return titleForeground;
    }

    
    /**
     * Retorna el color de fuente del mensaje de la notificacion
     * @return
     */
    @Override
    public String getMessageForeground() {
        return messageForeground;
    }

    /**
     * Retorna el color para eventos de advertencia del titulo de la notificacion
     * @return
     */
    @Override
    public String getTitleWarningForeground() {
        return titleWarningForeground;
    }
    
    /**
     * Retorna el color de Error del titulo de la notificacion
     * @return
     */
    @Override
    public String getTitleErrorForeground() {
        return titleErrorForeground;
    }
    
    /**
     * Retorna el color de Exito del titulo de la notificacion
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
     * Obtiene una instacia del theme para ser aplicada en una Notificacion.
     * @return
     */
    public static NiconLightTheme getInstance(){
        if(instance==null){
            instance=new NiconLightTheme();
        }
        return instance;
    }
    
}
