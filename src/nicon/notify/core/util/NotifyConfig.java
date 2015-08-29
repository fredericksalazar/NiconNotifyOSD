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

import nicon.notify.core.font.ControlFont;
import java.awt.Color;
import java.awt.Font;

/**
 *
 * @author frederick
 */
public class NotifyConfig {
    
    private final Font titleFontDesk;
    private final Font messageFontDesk;
    private final ControlFont font;
    
    private final Color fontErrorColor;
    private final Color fontWarningColor;
    private final Color fontOKColor;
    private final Color fontConfirmColor;
    private final Color fontDefaultColor;
    
    private final String nitruxIconsPath;
    
    private static NotifyConfig instance;
    
    private final String nameLib;
    private final String versionLib;
    private final String infoLib;
    
    
    
    private NotifyConfig() {
        font=ControlFont.getInstance();
        titleFontDesk=font.getUbuntuFont(20);
        messageFontDesk=font.getUbuntuFont(15);
        
        fontErrorColor=new java.awt.Color(222,60,60);
        fontWarningColor=new java.awt.Color(230,89,0);
        fontOKColor=new java.awt.Color(116,164,0);
        fontConfirmColor=new java.awt.Color(57,191,222);
        fontDefaultColor=new java.awt.Color(214, 214, 214);
        
        nitruxIconsPath="/nicon/notify/gui/Icons/Nitrux/";
        nameLib="NiconNotifyOSD";
        versionLib="1.9.5";
        infoLib="Developed By NiconSystem CO | Icons desingned By Nitrux  MX";
    } 
      


    /**
     *
     * @return
     */
    public Font getTitleFontDesk() {
        return titleFontDesk;
    }

    /**
     *
     * @return
     */
    public Font getMessageFontDesk() {
        return messageFontDesk;
    }   

    /**
     *
     * @return
     */
    public  Color getFontErrorColor() {
        return fontErrorColor;
    }

    /**
     *
     * @return
     */
    public  Color getFontWarningColor() {
        return fontWarningColor;
    }  

    /**
     *
     * @return
     */
    public  Color getFontOKColor() {
        return fontOKColor;
    }

    /**
     *
     * @return
     */
    public Color getFontConfirmColor() {
        return fontConfirmColor;
    }

    /**
     *
     * @return
     */
    public Color getFontDefaultColor() {
        return fontDefaultColor;
    }    
    
    /**
     *
     * @return
     */
    public String getNitruxIconsPath() {
        return nitruxIconsPath;
    }

    /**
     *
     * @return
     */
    public String getNameLib() {
        return nameLib;
    }

    /**
     *
     * @return
     */
    public String getVersionLib() {
        return versionLib;
    }

    /**
     *
     * @return
     */
    public String getInfoLib() {
        return infoLib;
    }
       
    /**
     *
     * @return
     */
    public static NotifyConfig getInstance(){
        if(instance==null){
            instance=new NotifyConfig();
        }
        return instance;
    }
    
}
