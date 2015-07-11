/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nicon.notify.gui.desktopNotify.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import nicon.notify.gui.desktopNotify.DesktopConfirm;

/**
 *
 * @author frederick
 */
public class DesktopConfirmController implements ActionListener{
    
    private DesktopConfirm desktopConfirm;
    private int optionPressed;

    /**
     *
     * @param desktopConfirm
     */
    public DesktopConfirmController(DesktopConfirm desktopConfirm) {
        this.desktopConfirm = desktopConfirm;
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
