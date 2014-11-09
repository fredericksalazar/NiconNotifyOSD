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
    
    public final static int NICON_FACEBOOK_ICON=1;
    public final static int NICON_TWITTER_ON_ICON=2;
    public final static int NICON_TWITTER_OFF_ICON=3;
    public final static int NICON_UPDATE_ICON=4;
    public final static int NICON_SECURE_ICON=5;
    public final static int NICON_GOOGLE_ICON=6;
    public final static int NICON_HARD_ICON=7;
    public final static int NICON_GPLUS_ICON=8;
    public final static int NICON_WEATHER_ICON=9;
    
    public final static String NICON_DARK_THEME="D";
    public final static String NICON_LIGHT_THEME="L";
    
    private int iconOption;
    private String optionTheme;
    
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
        this.optionTheme=optionTheme;
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
        this.optionTheme=optionTheme;
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
        jbClose.setIcon(new ImageIcon(getClass().getResource(config.getNitruxIconsPath()+"small/CloseNotify.png")));
        jbClose.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();                
                ControllerDesktopNotify.displayed--;
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
        if(ev.getTipeMessage()==NiconEvent.NOTIFY_DEFAULT){
            setIconNotify(new ImageIcon(getClass().getResource(config.getNitruxIconsPath()+"small/wingpanel.png")));
            jlTitle.setForeground(new Color(Integer.parseInt(theme.getTitleForeground(), 16)));
        }
        if(ev.getTipeMessage()==NiconEvent.NOTIFY_OK){
            setIconNotify(new ImageIcon(getClass().getResource(config.getNitruxIconsPath()+"small/NiconOK.png")));
            jlTitle.setForeground(new Color(Integer.parseInt(theme.getTitleOKForeground(), 16)));
        }
        if(ev.getTipeMessage()==NiconEvent.NOTIFY_WARNING){
            setIconNotify(new ImageIcon(getClass().getResource(config.getNitruxIconsPath()+"small/NiconWarning.png")));
            jlTitle.setForeground(new Color(Integer.parseInt(theme.getTitleWarningForeground(), 16)));
        }
        if(ev.getTipeMessage()==NiconEvent.NOTIFY_ERROR){
            setIconNotify(new ImageIcon(getClass().getResource(config.getNitruxIconsPath()+"small/NiconError.png")));
            jlTitle.setForeground(new Color(Integer.parseInt(theme.getTitleErrorForeground(), 16)));
        }
        if(ev.getTipeMessage()==NiconEvent.NOTIFY_CONFIRM){
            setIconNotify(new ImageIcon(getClass().getResource(config.getNitruxIconsPath()+"small/NiconConfirm.png")));
            jlTitle.setForeground(new Color(Integer.parseInt(theme.getTitleForeground(), 16)));
        }
    }
    
    /**
     * Ajusta el Icono de la notificacion con la opcion recibida del API.
     */
    private void setIconOption(){
        if(iconOption==1){
            setIconNotify((new ImageIcon(getClass().getResource(config.getNitruxIconsPath()+"small/NiconFacebook.png"))));
        }
        if(iconOption==2){
            setIconNotify((new ImageIcon(getClass().getResource(config.getNitruxIconsPath()+"small/NiconTwitter.png"))));
        }
        if(iconOption==3){
            setIconNotify((new ImageIcon(getClass().getResource(config.getNitruxIconsPath()+"small/NiconTwitterOff.png"))));
        }
        if(iconOption==4){
            setIconNotify((new ImageIcon(getClass().getResource(config.getNitruxIconsPath()+"small/NiconUpdate.png"))));
        }
        if(iconOption==5){
            setIconNotify((new ImageIcon(getClass().getResource(config.getNitruxIconsPath()+"small/NiconSecure.png"))));
        }
        if(iconOption==6){
            setIconNotify((new ImageIcon(getClass().getResource(config.getNitruxIconsPath()+"small/NiconGoogle.png"))));
        }
        if(iconOption==7){
            setIconNotify((new ImageIcon(getClass().getResource(config.getNitruxIconsPath()+"small/NiconHard.png"))));
        }
        if(iconOption==8){
            setIconNotify((new ImageIcon(getClass().getResource(config.getNitruxIconsPath()+"small/NiconPlus.png"))));
        }
        if(iconOption==9){
            setIconNotify((new ImageIcon(getClass().getResource(config.getNitruxIconsPath()+"small/NiconWeather.png"))));
        }
    }
    
    private void selectTheme(){
        if(optionTheme.equals(DesktopNotify.NICON_DARK_THEME)){
            theme=NiconDarkTheme.getInstance();
        }
        if(optionTheme.equals(DesktopNotify.NICON_LIGHT_THEME)){
            theme=NiconLightTheme.getInstance();
        }
    }
       
    @Override
    public void closeNotify(final DesktopNotify notify) {
       timer = new Timer(6500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ControllerDesktopNotify.removeNotify(notify);
                timer.stop();
                timer=null;
            }
        });
        timer.start();
    }
            
}
