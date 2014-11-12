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

package nicon.notify.gui.desktopNotify;

import nicon.notify.core.util.ControlNotify;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import nicon.notify.core.util.NLabel;
import nicon.notify.core.NiconEvent;
import nicon.notify.core.Notification;
import nicon.notify.core.util.NotifyConfig;
import nicon.notify.core.util.NotifyUtil;
import nicon.notify.gui.themes.NiconDarkTheme;
import nicon.notify.gui.themes.NiconLightTheme;
import nicon.notify.gui.themes.NiconTheme;

/**
 *
 * @author frederick
 */
public class DesktopNotify extends JDialog implements NotifyDesktopInterface{
    
      
    private int iconOption;
    private String selSkin;
    
    private NiconEvent ev;
    private NotifyConfig config;
    private NotifyUtil util;
    private NiconTheme theme;
    
    private JButton jbClose;    
    private JPanel panel;    
    private JLabel jlTitle;
    private NLabel jlMessage;
    private JLabel jlIcon;   
    private ImageIcon icon;
    private Timer timer;
    
    /**
     * Este metodo constructor permite crear una nueva notificacion de escritorio
     * de forma que se configura por defecto con la informacion y caracteristicas
     * del objeto NiconEvent que llega en su constructor.
     * 
     * @param ev 
     */
    
    public DesktopNotify(NiconEvent ev) {        
        this.ev=ev;
        this.config=NotifyConfig.getInstance();
        this.util=NotifyUtil.getInstance();
        this.theme=NiconDarkTheme.getInstance();        
        setSize(380,98);
        setUndecorated(true);     
        init();        
        setDesktopInterface();
        closeNotify(this);
    }        
    
     public DesktopNotify(NiconEvent ev, String optionTheme) {        
        this.ev=ev;
        this.selSkin=optionTheme;
        this.config=NotifyConfig.getInstance();
        this.util=NotifyUtil.getInstance();  
        this.selectTheme();
        
        setSize(380,98);
        setUndecorated(true); 
        init();        
        setDesktopInterface();
        closeNotify(this);
    }     
    
    /**
     * Este metodo permite crear una nueva notificacion de escritorio recibiendo
     * como parametros el Evento que se desea mostrar y un Icono de los iconos 
     * proveidos por la libreria, para hacer uso de los iconos debera acceder a 
     * ellos mediante las variables constantes de DesktopNoify
     * @param ev
     * @param iconOption 
     */
    public DesktopNotify(NiconEvent ev, int iconOption){
        this.ev=ev;
        this.iconOption=iconOption;
        config=NotifyConfig.getInstance();
        util=NotifyUtil.getInstance();        
        theme=NiconDarkTheme.getInstance();        
        setSize(380,98);
        setUndecorated(true);   
        init();        
        setDesktopInterface();
        setIconOption();
        closeNotify(this);
    }    
    
    public DesktopNotify(NiconEvent ev, int iconOption,String optionTheme){
        this.ev=ev;
        this.iconOption=iconOption;
        this.selSkin=optionTheme;
        this.config=NotifyConfig.getInstance();
        this.util=NotifyUtil.getInstance();
        this.selectTheme();
        
        setSize(380,98);
        setUndecorated(true);  
        init();        
        setDesktopInterface();
        setIconOption();
    }    
    
    private void init() {
        panel=new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(Integer.parseInt(theme.getBakcgroundPanel(), 16)));
        
        jbClose=new JButton();
        jbClose.setBounds(355, 5, 15, 15);
        jbClose.setBorderPainted(false);
        jbClose.setContentAreaFilled(false);
        jbClose.setIcon(new ImageIcon(getClass().getResource(config.getNitruxIconsPath()+"CloseNotify.png")));
        jbClose.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();                
                ControlNotify.displayed--;
            }
        });
                
        jlIcon=new JLabel();
        jlIcon.setBounds(0,0,65,65);
        
        jlTitle=new JLabel(ev.getTitleEvent());
        jlTitle.setFont(config.getTitleFontDesk());
        jlTitle.setBounds(75,10,305, 18);
        
        jlMessage=new NLabel(util.setTextMessageEvent(ev.getTextEvent()));
        jlMessage.setFont(config.getMessageFontDesk());
        jlMessage.setBounds(78,40,295,80);
        jlMessage.setForeground(new Color(Integer.parseInt(theme.getMessageForeground(),16)));
                
        panel.add(jlIcon);
        panel.add(jlTitle);
        panel.add(jlMessage);
        panel.add(jbClose);
        add(panel);            
        closeNotify(this);
    }
    
    public void addButton(JButton buton){
        panel.add(buton);
    }
    
    private void setIconNotify(ImageIcon icon){
        this.icon=icon;
        jlIcon.setIcon(icon);
    }
    
    
    /**
     * Este metodo permite Ajustar toda la interfaz de la notificacion segun la
     * configuracion del objeto niconEvent, en este caso si estamos mostrando
     * una notificacion de OK la DesktopNotify podrá configurarse para que toda
     * su interfaz sea simbolo de OK, o en caso de warning de igual forma, ademas
     * permite definir una Interfaz Neutral por defecto con una configuracion 
     * simple y sin ninguna expresion.
     */
    private void setDesktopInterface(){
        if(ev.getTipeMessage()==Notification.DEFAULT_MESSAGE){
            setIconNotify(new ImageIcon(getClass().getResource(config.getNitruxIconsPath()+"NiconDefault.png")));
            jlTitle.setForeground(new Color(Integer.parseInt(theme.getTitleForeground(), 16)));
        }
        if(ev.getTipeMessage()==Notification.OK_MESSAGE){
            setIconNotify(new ImageIcon(getClass().getResource(config.getNitruxIconsPath()+"NiconOK.png")));
            jlTitle.setForeground(new Color(Integer.parseInt(theme.getTitleOKForeground(), 16)));
        }
        if(ev.getTipeMessage()==Notification.WARNING_MESSAGE){
            setIconNotify(new ImageIcon(getClass().getResource(config.getNitruxIconsPath()+"NiconWarning.png")));
            jlTitle.setForeground(new Color(Integer.parseInt(theme.getTitleWarningForeground(), 16)));
        }
        if(ev.getTipeMessage()==Notification.ERROR_MESSAGE){
            setIconNotify(new ImageIcon(getClass().getResource(config.getNitruxIconsPath()+"NiconError.png")));
            jlTitle.setForeground(new Color(Integer.parseInt(theme.getTitleErrorForeground(), 16)));
        }
        if(ev.getTipeMessage()==Notification.CONFIRM_MESSAGE){
            setIconNotify(new ImageIcon(getClass().getResource(config.getNitruxIconsPath()+"NiconConfirm.png")));
            jlTitle.setForeground(new Color(Integer.parseInt(theme.getTitleForeground(), 16)));
        }
    }
    
    /**
     * Ajusta el Icono de la notificacion con la opcion recibida del API.
     */
    private void setIconOption(){
        
        if(iconOption==1) setIconNotify((new ImageIcon(getClass().getResource(config.getNitruxIconsPath()+"NiconFacebook.png"))));
        
        if(iconOption==2) setIconNotify((new ImageIcon(getClass().getResource(config.getNitruxIconsPath()+"NiconTwitter.png"))));
        
        if(iconOption==3) setIconNotify((new ImageIcon(getClass().getResource(config.getNitruxIconsPath()+"NiconTwitterOff.png"))));
        
        if(iconOption==4) setIconNotify((new ImageIcon(getClass().getResource(config.getNitruxIconsPath()+"NiconUpdateGreen.png"))));
        
        if(iconOption==5) setIconNotify((new ImageIcon(getClass().getResource(config.getNitruxIconsPath()+"NiconSecure.png"))));
        
        if(iconOption==6) setIconNotify((new ImageIcon(getClass().getResource(config.getNitruxIconsPath()+"NiconGoogle.png"))));
        
        if(iconOption==7) setIconNotify((new ImageIcon(getClass().getResource(config.getNitruxIconsPath()+"NiconHard.png"))));
        
        if(iconOption==8)  setIconNotify((new ImageIcon(getClass().getResource(config.getNitruxIconsPath()+"NiconPlus.png"))));
        
        if(iconOption==9)  setIconNotify((new ImageIcon(getClass().getResource(config.getNitruxIconsPath()+"NiconWeather.png"))));
        
        if(iconOption==10) setIconNotify((new ImageIcon(getClass().getResource(config.getNitruxIconsPath()+"NiconWifi.png"))));
        
        if(iconOption==11) setIconNotify((new ImageIcon(getClass().getResource(config.getNitruxIconsPath()+"NiconDownload.png"))));
        
        if(iconOption==12) setIconNotify((new ImageIcon(getClass().getResource(config.getNitruxIconsPath()+"NiconRss.png"))));
        
        if(iconOption==13) setIconNotify((new ImageIcon(getClass().getResource(config.getNitruxIconsPath()+"NiconUpdateBlue.png"))));
        
        if(iconOption==14) setIconNotify((new ImageIcon(getClass().getResource(config.getNitruxIconsPath()+"NiconEverNote.png"))));
        
        if(iconOption==15) setIconNotify((new ImageIcon(getClass().getResource(config.getNitruxIconsPath()+"NiconMessageOrange.png"))));
        
        if(iconOption==16) setIconNotify((new ImageIcon(getClass().getResource(config.getNitruxIconsPath()+"NiconMessageBlue.png"))));
        
        if(iconOption==17) setIconNotify((new ImageIcon(getClass().getResource(config.getNitruxIconsPath()+"NiconMusic.png"))));
        
        if(iconOption==18) setIconNotify((new ImageIcon(getClass().getResource(config.getNitruxIconsPath()+"NiconShield.png"))));
        
        if(iconOption==19) setIconNotify((new ImageIcon(getClass().getResource(config.getNitruxIconsPath()+"NiconPlugin.png"))));
        
        if(iconOption==20) setIconNotify((new ImageIcon(getClass().getResource(config.getNitruxIconsPath()+"NiconMailRed.png"))));
        
        if(iconOption==21) setIconNotify((new ImageIcon(getClass().getResource(config.getNitruxIconsPath()+"NiconMailBlue.png"))));
        
        if(iconOption==22) setIconNotify((new ImageIcon(getClass().getResource(config.getNitruxIconsPath()+"ImageIcon.png"))));
        
        if(iconOption==23) setIconNotify((new ImageIcon(getClass().getResource(config.getNitruxIconsPath()+"NiconNotes.png"))));
        
        if(iconOption==24) setIconNotify((new ImageIcon(getClass().getResource(config.getNitruxIconsPath()+"NiconCalendar.png"))));
        
        if(iconOption==25) setIconNotify((new ImageIcon(getClass().getResource(config.getNitruxIconsPath()+"NiconInfo.png"))));
        
    }
    
    private void selectTheme(){
        if(selSkin.equals(Notification.NICON_DARK_THEME)){
            theme=NiconDarkTheme.getInstance();
        }
        if(selSkin.equals(Notification.NICON_LIGHT_THEME)){
            theme=NiconLightTheme.getInstance();
        }
    }
       
    /**
     *
     * @param notify
     */
    @Override
    public void closeNotify(final DesktopNotify notify) {
       timer = new Timer(6500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ControlNotify.removeNotify(notify);
                timer.stop();
                timer=null;
            }
        });
        timer.start();
    }
            
}
