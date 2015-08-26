/*
 * Copyright (c) NiconSystemCO 2013
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


package nicon.notify.gui.desktopNotify.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import nicon.notify.gui.desktopNotify.DesktopConfirm;
import nicon.notify.gui.desktopNotify.DesktopNotify;

/**
 *
 * @author frederick
 */
public class NotifyController implements ActionListener{
    
    private final DesktopConfirm desktopConfirm;
    private int optionPressed;

    /**
     *
     * @param desktopConfirm
     */
    public NotifyController(DesktopNotify desktopConfirm) {
        this.desktopConfirm = (DesktopConfirm) desktopConfirm;
        this.desktopConfirm.jbAcept.addActionListener(this);
        this.desktopConfirm.jbCancel.addActionListener(this);
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource().equals(desktopConfirm.jbAcept)){            
            optionPressed=1;
            //desktopConfirm.closeNotify(desktopConfirm); 
        }
        
        if(e.getSource().equals(desktopConfirm.jbCancel)){            
            optionPressed=0;
            //desktopConfirm.closeNotify(desktopConfirm);
        }
        
    }
        
    /**
     *
     * @return
     */
    public int getOptionPressed(){
        return optionPressed;
    }
    
}
