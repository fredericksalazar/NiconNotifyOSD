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

import java.awt.Color;
import java.awt.Font;
import nicon.notify.core.font.UbuntuFont;

/**
 *
 * @author frederick
 */
public class NotifyConfig {
    
    /**
     * Fuente para los titulos de las WindowNotify
     */
    private Font titleFontWin;
    
    /**
     * Fuente para el texto de las WindowNotify
     */
    private Font messageFontWin;
    
    /**
     * Fuente para el titulo de las DesktopNotify
     */
    private Font titleFontDesk;
    
    /**
     * Fuente para el mensaje de las DesktopNotify
     */
    private Font messageFontDesk;
    
    private UbuntuFont font;
    
    private Color fontErrorColor;
    private Color fontWarningColor;
    private Color fontOKColor;
    private Color fontConfirmColor;
    private Color fontDefaultColor;
    
    private String nitruxIconsPath;
    
    private static NotifyConfig instance;
    
    
    private NotifyConfig() {
        font=UbuntuFont.getInstance();
        titleFontWin=font.getUbuntuFont(28);
        messageFontWin=font.getUbuntuFont(14);
        titleFontDesk=font.getUbuntuBold(17);
        messageFontDesk=font.getUbuntuFont(12);
        
        fontErrorColor=new java.awt.Color(222,60,60);
        fontWarningColor=new java.awt.Color(230,89,0);
        fontOKColor=new java.awt.Color(116,164,0);
        fontConfirmColor=new java.awt.Color(57,191,222);
        fontDefaultColor=new java.awt.Color(214, 214, 214);
        
        nitruxIconsPath="/nicon/notify/gui/Icons/Nitrux/";
    } 
      
    public  Font getTitleFont() {
        return titleFontWin;
    }

    public Font getMessageFont() {
        return messageFontWin;
    }

    public Font getTitleFontWin() {
        return titleFontWin;
    }

    public Font getMessageFontWin() {
        return messageFontWin;
    }

    public Font getTitleFontDesk() {
        return titleFontDesk;
    }

    public Font getMessageFontDesk() {
        return messageFontDesk;
    }   

    public  Color getFontErrorColor() {
        return fontErrorColor;
    }

    public  Color getFontWarningColor() {
        return fontWarningColor;
    }  

    public  Color getFontOKColor() {
        return fontOKColor;
    }

    public Color getFontConfirmColor() {
        return fontConfirmColor;
    }

    public Color getFontDefaultColor() {
        return fontDefaultColor;
    }    
    
    public String getNitruxIconsPath() {
        return nitruxIconsPath;
    }
    
    public static NotifyConfig getInstance(){
        if(instance==null){
            instance=new NotifyConfig();
        }
        return instance;
    }
    
}
