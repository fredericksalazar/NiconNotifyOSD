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

package nicon.notify.gui.windowNotify;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import nicon.notify.core.util.NLabel;
import nicon.notify.core.NiconEvent;
import nicon.notify.core.util.NotifyConfig;

/**
 *
 * @author frederick
 */
public class WindowNotify extends JDialog {      

    private JPanel panel;
    private JLabel jlIcon;
    private JLabel jlTitle;
    private NLabel jlMessage;
    private ImageIcon image;
    protected JButton jbAcept;
    
    private NiconEvent ev;
    private NotifyConfig config;
    private ImageIcon icon;

    public WindowNotify(Component content,NiconEvent ev) {
        this.ev = ev;
        setModal(true);
        setSize(535,210);
        setResizable(false);
        setLocationRelativeTo(content);        
        config=NotifyConfig.getInstance();    
        init();
        setIconMessage();
    }

    private void init() {        
        panel = new JPanel();
        panel.setBackground(new java.awt.Color(35, 35, 35));
        panel.setLayout(null);        
        
        image=new ImageIcon(getClass().getResource(config.getNitruxIconsPath()+"NiconDefault.png"));

        jlTitle=new JLabel(ev.getTitleEvent());
        jlTitle.setBounds(108, 10,600, 30);
        jlTitle.setFont(config.getTitleFont());
        jlTitle.setForeground(Color.white);
        
        jlMessage=new NLabel(ev.getTextEvent());
        jlMessage.setBounds(108,50,420,90);
        jlMessage.setFont(config.getMessageFont());
        jlMessage.setForeground(Color.gray);
        
        jlIcon=new JLabel();
        jlIcon.setIcon(image);
        jlIcon.setBounds(0,0,100,100);
        
        jbAcept=new JButton("Aceptar");
        jbAcept.setBounds(402, 150, 120,30);
        jbAcept.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    dispose();
                    ev=null;
                } catch (Throwable ex) {
                    Logger.getLogger(WindowNotify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
                
        panel.add(jlTitle);
        panel.add(jlMessage);
        panel.add(jlIcon);
        panel.add(jbAcept);
        
        getRootPane().setDefaultButton(jbAcept);
        add(panel);
    }
    
    private void setIconMessage() {
       if(ev.getTipeMessage()==NiconEvent.NOTIFY_DEFAULT){
           image=new ImageIcon(getClass().getResource(config.getNitruxIconsPath()+"NiconDefault.png"));
           setForegroundTitle(config.getFontDefaultColor());
           setIconMessage(image); 
       }
       if(ev.getTipeMessage()==NiconEvent.NOTIFY_OK){
           icon=new ImageIcon(getClass().getResource(config.getNitruxIconsPath()+"NiconOKMessage.png"));
           this.setForegroundTitle(config.getFontOKColor());
           this.setIconMessage(icon);           
       }
       
       if(ev.getTipeMessage()==NiconEvent.NOTIFY_WARNING){
           icon=new ImageIcon(getClass().getResource(config.getNitruxIconsPath()+"NiconWarning.png"));
           this.setForegroundTitle(config.getFontWarningColor());
           this.setIconMessage(icon);
       }
       
       if(ev.getTipeMessage()==NiconEvent.NOTIFY_ERROR){
           icon=new ImageIcon(getClass().getResource(config.getNitruxIconsPath()+"NiconError.png"));
           this.setForegroundTitle(config.getFontErrorColor());
           this.setIconMessage(icon);
       }
    }
    
    public void addTextField(JTextField textField){
        panel.add(textField);
        repaint();
    }
    
    public void addButton(JButton button){
        panel.add(button);
        repaint();
    }
    public void setTitleNotify(String title){
        this.jlTitle.setText(title);
    }
    
    public void setMessage(String message){
        this.jlMessage.setText(message);
    }
    
    public void setIconMessage(ImageIcon icon){
        this.jlIcon.setIcon(icon);
    }
    
    public void setForegroundTitle(Color color){
        this.jlTitle.setForeground(color);
    }

    public NiconEvent getEv() {
        return ev;
    }
    
    public void moveAceptButton(int x,int y){
        jbAcept.setBounds(x, y, 120, 30);
    }
    
    
}
