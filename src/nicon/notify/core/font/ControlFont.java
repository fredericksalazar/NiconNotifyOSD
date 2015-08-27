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

package nicon.notify.core.font;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author frederick
 */
public class ControlFont {
    
    private static ControlFont font;
    private Font ubuntuFont;
    
    private String urlFont;
    private InputStream in;
    
    private ControlFont(){
        urlFont="/nicon/notify/core/font/font.OTF";
            try{
               in=getClass().getResourceAsStream(urlFont); 
               ubuntuFont=Font.createFont(Font.TRUETYPE_FONT, in);
               in.close();
            }catch(FontFormatException | IOException e){
                System.out.println("Ocurrio el siguiente error al Intentar cargar La fuente:\n"+e);
            }
    }
    
    /**
     * retorna la fuente Almacenada en el flujo de datos.
     * @param size
     * @return 
     */
    public Font getUbuntuFont(float size){
        return ubuntuFont.deriveFont(size);
    }
    
    /**
     *
     * @param size
     * @return
     */
    public Font getUbuntuBold(float size){
        return ubuntuFont.deriveFont(Font.BOLD, size);
    }
    
    /**
     *
     * @return
     */
    public static ControlFont getInstance(){
        if(font==null){            
            font=new ControlFont(); 
        } 
        return font;
    }
    
}
