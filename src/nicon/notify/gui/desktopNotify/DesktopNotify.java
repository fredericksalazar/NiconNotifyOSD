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

package nicon.notify.gui.desktopNotify;

import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import nicon.notify.gui.desktopNotify.components.NLabel;
import nicon.notify.core.NiconEvent;
import nicon.notify.core.Notification;
import nicon.notify.core.server.ServerOSD;
import nicon.notify.core.util.NotifyConfig;
import nicon.notify.core.util.NotifyUtil;
import nicon.notify.gui.desktopNotify.controller.MouseController;
import nicon.notify.gui.themes.NiconDarkTheme;
import nicon.notify.gui.themes.NiconGrayTheme;
import nicon.notify.gui.themes.NiconLightTheme;
import nicon.notify.gui.themes.NiconTheme;

/**
 * Esta clase define una notificacion del tipo DesktopNotify, esta notificacion
 * es el centro de esta tecnologia,en esta clase solo definimos los aspectos
 * graficos.
 * 
 * @author frederick
 */
public class DesktopNotify extends JDialog implements ActionListener {
    
          
    private final NiconEvent ev;
    private int nid;
    private short icon;
    private char nicon_theme;
    private String urlIcon; 
    
    private JLabel jlTitle;
    private NLabel jlMessage;
    private JLabel jlIcon;   
    
    private final NotifyConfig config;
    private final NotifyUtil util;
    private NiconTheme theme;
    
    private JButton jbClose;    
    private JPanel panel;  
    private String urlSound;

    private MouseController mouseController;
    
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
        setSize(400,98);
        setUndecorated(true);  
        setAlwaysOnTop(true);
        setResizable(false);
        init();        
        setDesktopInterface();
    }    
  
    /**
     * Este metodo constructor permite crear una nueva notificacion de escritorio
     * de forma que se configura por defecto con la informacion y caracteristicas
     * del objeto NiconEvent que llega en su constructor, ademas recibe un char
     * con la seleccion del NiconTheme que el usuario desea usar
     * 
     * @param ev 
     * @param theme 
     */
    
     public DesktopNotify(NiconEvent ev, char theme) {        
        this.ev=ev;
        this.nicon_theme=theme;
        this.config=NotifyConfig.getInstance();
        this.util=NotifyUtil.getInstance();  
        setNiconTheme();        
        setSize(380,98);
        setUndecorated(true); 
        setAlwaysOnTop(true);
        setResizable(false);
        init();        
        setDesktopInterface();
    }     
    
    /**
     * Este metodo permite crear una nueva notificacion de escritorio recibiendo
     * como parametros el Evento que se desea mostrar y un Icono de los iconos 
     * proveidos por la libreria, para hacer uso de los iconos debera acceder a 
     * ellos mediante las variables constantes de Notification
     * @param ev
     * @param icon 
     */
    public DesktopNotify(NiconEvent ev, short icon){
        this.ev=ev;
        this.icon=icon;
        this.config=NotifyConfig.getInstance();
        this.util=NotifyUtil.getInstance();        
        this.theme=NiconDarkTheme.getInstance();        
        setSize(380,98);
        setUndecorated(true);
        setAlwaysOnTop(true);
        setResizable(false);
        init();        
        setDesktopInterface();
        setIconOption();
    }    
    
    /**
     * Este metodo constructor permite crear una nueva notificacion de escritorio
     * de forma que se configura por defecto con la informacion y caracteristicas
     * del objeto NiconEvent que llega en su constructor, ademas recibe un int
     * que representa el icono a usar en la notificacion y un char con el NiconTheme
     * seleccionado para la notificacion
     * 
     * @param ev 
     * @param icon 
     * @param theme 
     */
    
    public DesktopNotify(NiconEvent ev, short icon,char theme){
        this.ev=ev;
        this.icon=icon;
        this.nicon_theme=theme;
        this.config=NotifyConfig.getInstance();
        this.util=NotifyUtil.getInstance();
        this.setNiconTheme();        
        setSize(380,98);
        setUndecorated(true); 
        setAlwaysOnTop(true);
        setResizable(false);
        init();        
        setDesktopInterface();
        setIconOption();
    }    
    
    /**
     * Este metodo constructor permite crear una nueva notificacion de escritorio
     * de forma que se configura por defecto con la informacion y caracteristicas
     * del objeto NiconEvent que llega en su constructor, ademas de un string 
     * con la url de un icono que el usuario desea mostrar
     * 
     * @param ev 
     * @param url 
     */
    
    public DesktopNotify(NiconEvent ev,String url){
        this.ev=ev;
        this.icon=-1;        
        this.urlIcon=url;
        this.theme=NiconDarkTheme.getInstance();
        this.config=NotifyConfig.getInstance();
        this.util=NotifyUtil.getInstance();
        this.setNiconTheme();        
        setSize(380,98);
        setUndecorated(true);
        setAlwaysOnTop(true);
        setResizable(false);
        init();        
        setDesktopInterface();
        setIconOption();
    }
    
    /**
     * Este metodo constructor permite crear una nueva notificacion de escritorio
     * de forma que se configura por defecto con la informacion y caracteristicas
     * del objeto NiconEvent que llega en su constructor, ademas recibe un 
     * String con el Url de un icono a cargar y el char del NiconTheme a usar en 
     * la notificacion
     * 
     * @param ev 
     * @param url 
     * @param skin 
     */
    
    public DesktopNotify(NiconEvent ev,String url,char skin){
        this.ev=ev;
        this.icon=-1;        
        this.urlIcon=url;
        this.nicon_theme=skin;
        this.config=NotifyConfig.getInstance();
        this.util=NotifyUtil.getInstance();
        this.setNiconTheme();        
        setSize(380,98);
        setUndecorated(true); 
        setAlwaysOnTop(true);
        setResizable(false);
        init();        
        setDesktopInterface();
        setIconOption();
    }
    
    /**
     * Metodo que inicia el proceso de carga y configuracion de la notificacion
     */
    private void init() {  
        
        panel=new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(Integer.parseInt(theme.getBakcgroundPanel(), 16)));
        
        jbClose=new JButton();
        jbClose.setBounds(362, 2, 15, 15);
        jbClose.setBorderPainted(false);
        jbClose.setContentAreaFilled(false);
        jbClose.setIcon(new ImageIcon(getClass().getResource(config.getNitruxIconsPath()+"CloseNotify.png")));
        jbClose.addActionListener(this);
                
        jlIcon=new JLabel();
        jlIcon.setBounds(0,0,65,65);
        
        jlTitle=new JLabel(ev.getTitleEvent());
        jlTitle.setFont(config.getTitleFontDesk());
        jlTitle.setBounds(72,6,305, 18);
        
        jlMessage=new NLabel(util.setTextMessageEvent(ev.getTextEvent()));
        jlMessage.setFont(config.getMessageFontDesk());
        jlMessage.setBounds(72,30,299,53);
        jlMessage.setForeground(new Color(Integer.parseInt(theme.getMessageForeground(),16)));
                
        panel.add(jlIcon);
        panel.add(jlTitle);
        panel.add(jlMessage);
        panel.add(jbClose);

        add(panel);

        mouseController = new MouseController(this);
        this.addMouseListener(mouseController);
        jlMessage.addMouseListener(mouseController);
    }


    /**
     * retorna el objeto NiconEvent recibido
     *
     * @return NiconEvent ev
     */

    public NiconEvent getEvent(){
        return this.ev;
    }

    
    /**
     * Retorna el ID de la notificacion que ha sido asignado
     * por el serverOSD al momento de lanzar la notificacion
     *
     * @return int nid
     */
    
    public int getNid() {
        return nid;
    }

    
   /**
    * Ajusta el ID de la notificacion creado por el serverOSD
    * al momento de lanzar la notificacion
    *
    * @param nid 
    */
    
    public void setNid(int nid) {

        this.nid = nid;
    }
    
    
    /**
     * Agrega un objeto JButton a la notificacion
     * @param buton 
     */
    
    public void addButton(JButton buton){
        panel.add(buton);
    }
    
    
    /**
     *  Ajusta el Icono de la notificacion
     * @param icon 
     */
    
    private void setIconNotify(ImageIcon icon){
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
     * Ajusta el Icono de la DesktopNotify
     */
    
    private void setIconOption(){
        
        //En caso de que se reciba un path con el icono que se desea cargar
        if(icon==-1) {
            try {
                File file=new File(urlIcon);
                    if(file.exists()){
                        ImageIcon prevIcon=new ImageIcon(file.getPath());
                        setIconNotify(new ImageIcon(prevIcon.getImage().getScaledInstance(67, 67, Image.SCALE_DEFAULT)));
                    }
            } catch (Exception ex) {
                Logger.getLogger(DesktopNotify.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if(icon==1) setIconNotify((new ImageIcon(getClass().getResource(config.getNitruxIconsPath()+"NiconFacebook.png"))));
        
        if(icon==2) setIconNotify((new ImageIcon(getClass().getResource(config.getNitruxIconsPath()+"NiconTwitter.png"))));
        
        if(icon==3) setIconNotify((new ImageIcon(getClass().getResource(config.getNitruxIconsPath()+"NiconTwitterOff.png"))));
        
        if(icon==4) setIconNotify((new ImageIcon(getClass().getResource(config.getNitruxIconsPath()+"NiconUpdateGreen.png"))));
        
        if(icon==5) setIconNotify((new ImageIcon(getClass().getResource(config.getNitruxIconsPath()+"NiconSecure.png"))));
        
        if(icon==6) setIconNotify((new ImageIcon(getClass().getResource(config.getNitruxIconsPath()+"NiconGoogle.png"))));
        
        if(icon==7) setIconNotify((new ImageIcon(getClass().getResource(config.getNitruxIconsPath()+"NiconHard.png"))));
        
        if(icon==8)  setIconNotify((new ImageIcon(getClass().getResource(config.getNitruxIconsPath()+"NiconPlus.png"))));
        
        if(icon==9)  setIconNotify((new ImageIcon(getClass().getResource(config.getNitruxIconsPath()+"NiconWeather.png"))));
        
        if(icon==10) setIconNotify((new ImageIcon(getClass().getResource(config.getNitruxIconsPath()+"NiconWifi.png"))));
        
        if(icon==11) setIconNotify((new ImageIcon(getClass().getResource(config.getNitruxIconsPath()+"NiconDownload.png"))));
        
        if(icon==12) setIconNotify((new ImageIcon(getClass().getResource(config.getNitruxIconsPath()+"NiconRss.png"))));
        
        if(icon==13) setIconNotify((new ImageIcon(getClass().getResource(config.getNitruxIconsPath()+"NiconUpdateBlue.png"))));
        
        if(icon==14) setIconNotify((new ImageIcon(getClass().getResource(config.getNitruxIconsPath()+"NiconEverNote.png"))));
        
        if(icon==15) setIconNotify((new ImageIcon(getClass().getResource(config.getNitruxIconsPath()+"NiconMessageOrange.png"))));
        
        if(icon==16) setIconNotify((new ImageIcon(getClass().getResource(config.getNitruxIconsPath()+"NiconMessageBlue.png"))));
        
        if(icon==17) setIconNotify((new ImageIcon(getClass().getResource(config.getNitruxIconsPath()+"NiconMusic.png"))));
        
        if(icon==18) setIconNotify((new ImageIcon(getClass().getResource(config.getNitruxIconsPath()+"NiconShield.png"))));
        
        if(icon==19) setIconNotify((new ImageIcon(getClass().getResource(config.getNitruxIconsPath()+"NiconPlugin.png"))));
        
        if(icon==20) setIconNotify((new ImageIcon(getClass().getResource(config.getNitruxIconsPath()+"NiconMailRed.png"))));
        
        if(icon==21) setIconNotify((new ImageIcon(getClass().getResource(config.getNitruxIconsPath()+"NiconMailBlue.png"))));
        
        if(icon==22) setIconNotify((new ImageIcon(getClass().getResource(config.getNitruxIconsPath()+"ImageIcon.png"))));
        
        if(icon==23) setIconNotify((new ImageIcon(getClass().getResource(config.getNitruxIconsPath()+"NiconNotes.png"))));
        
        if(icon==24) setIconNotify((new ImageIcon(getClass().getResource(config.getNitruxIconsPath()+"NiconCalendar.png"))));
        
        if(icon==25) setIconNotify((new ImageIcon(getClass().getResource(config.getNitruxIconsPath()+"NiconInfo.png"))));
        
        if(icon==26) setIconNotify((new ImageIcon(getClass().getResource(config.getNitruxIconsPath()+"NiconFull.png"))));
        
        if(icon==27) setIconNotify((new ImageIcon(getClass().getResource(config.getNitruxIconsPath()+"NiconMed.png"))));
        
        if(icon==28) setIconNotify((new ImageIcon(getClass().getResource(config.getNitruxIconsPath()+"NiconDown.png"))));
        
        if(icon==29) setIconNotify((new ImageIcon(getClass().getResource(config.getNitruxIconsPath()+"NiconContact.png"))));
    
        if(icon==30) setIconNotify((new ImageIcon(getClass().getResource(config.getNitruxIconsPath()+"NiconHardOrange.png"))));
        
        if(icon==31) setIconNotify((new ImageIcon(getClass().getResource(config.getNitruxIconsPath()+"NiconAlarm.png"))));
        
        if(icon==32) setIconNotify((new ImageIcon(getClass().getResource(config.getNitruxIconsPath()+"NiconLogo.png"))));
    
    }
    
    
    /**
     * Permite ajustar el NiconTheme a una desktopNotify
     */
    
    private void setNiconTheme(){
        
        if(nicon_theme==Notification.NICON_DARK_THEME){
            theme=NiconDarkTheme.getInstance();
        }
        
        if(nicon_theme==Notification.NICON_LIGHT_THEME){
            theme=NiconLightTheme.getInstance();
        }
        
        if(nicon_theme==Notification.NICON_GRAY_THEME){
            theme = NiconGrayTheme.getInstance();
        }
    }
    
    /**
     * Retorna un objeto del tipo NiconTheme con el tema seleccionado por el 
     * usuario
     * @return NiconTheme
     */
    public NiconTheme getTheme(){
        return this.theme;
    }


    /**
     * Este metodo retorna el color de fuente usado en los titulos de las notificaciones
     * segun el tipo que sea.
     * @return Color titleforeground
     */
    public Color getForegroundTitle(){
        return this.jlTitle.getForeground();
    }

    
    /**
     * Este metodo permite  emitir un sonido al momento de lanzar la notificacion en el escritori
     *
     * @param type
     */    
    private void playSound(int type){
        
        if(type==0){
            urlSound="/nicon/notify/core/sound/notify.wav";
        }
        if(type==1){
            urlSound="/nicon/notify/core/sound/warning.wav";
        }
        if(type==2){
            urlSound="/nicon/notify/core/sound/error.wav";
        }
        AudioClip adio = java.applet.Applet.newAudioClip(getClass().getResource(urlSound));
        adio.play();
    }

    /**
     * Este metodo permite mostrar la notificacion
     */
    public void showMe(){

        if(ev.isSound()){

            if(ev.getTipeMessage()==Notification.DEFAULT_MESSAGE)
                playSound(0);

            if(ev.getTipeMessage()==Notification.OK_MESSAGE)
                playSound(0);

            if(ev.getTipeMessage()==Notification.WARNING_MESSAGE)
                playSound(1);

            if(ev.getTipeMessage()==Notification.ERROR_MESSAGE)
                playSound(2);
        }

        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(this.jbClose)){
            ServerOSD.getInstance().remove(getNid());
        }
    }

}
