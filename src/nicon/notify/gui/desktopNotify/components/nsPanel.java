/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nicon.notify.gui.desktopNotify.components;

import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.*;

import nicon.notify.core.util.NotifyConfig;
import nicon.notify.core.util.NotifyUtil;
import nicon.notify.gui.desktopNotify.DesktopNotify;

/**
 *
 * @author Frederick Salazar Sanchez
 */

public class nsPanel extends JPanel{
    
    private final DesktopNotify notify;
    private JLabel jlDate;
    
    private final NotifyConfig config;
    private final NotifyUtil util;
    
    private JLabel jlIcon;
    private JLabel jlTitle;
    private NLabel jlMessage;
    
    public nsPanel(DesktopNotify notify){
        this.setLayout(null);
        this.notify = notify;
        
        config = NotifyConfig.getInstance();
        util = NotifyUtil.getInstance();
        init();
        setTimeNotification();
    }

    private void init() {
        
        setBackground(new Color(Integer.parseInt(notify.getTheme().getBakcgroundPanel(), 16)));
        
        jlDate = new JLabel();
        jlDate.setFont(config.getMessageFontDesk());
        jlDate.setBounds(330,2,100,30);
        jlDate.setForeground(config.getFontDefaultColor());
                
        jlIcon=new JLabel();
        jlIcon.setBounds(0,0,65,65);
        
        jlTitle=new JLabel(notify.getEvent().getTitleEvent());
        jlTitle.setFont(config.getTitleFontDesk());
        jlTitle.setBounds(72,6,305, 18);
        
        jlMessage=new NLabel(util.setTextMessageEvent(notify.getEvent().getTextEvent()));
        jlMessage.setFont(config.getMessageFontDesk());
        jlMessage.setBounds(72,30,299,53);
        jlMessage.setForeground(new Color(Integer.parseInt(notify.getTheme().getMessageForeground(),16)));
                
        add(jlIcon);
        add(jlTitle);
        add(jlMessage);
        add(jlDate);    
    }

    public JLabel getJlDate() {

        return jlDate;
    }

    public void setJlDate(JLabel jlDate) {

        this.jlDate = jlDate;
    }

    public JLabel getJlIcon() {

        return jlIcon;
    }

    public void setJlIcon(JLabel jlIcon) {
        this.jlIcon = jlIcon;
    }

    public JLabel getJlTitle() {
        return jlTitle;
    }

    public void setJlTitle(JLabel jlTitle) {
        this.jlTitle = jlTitle;
    }

    public NLabel getJlMessage() {
        return jlMessage;
    }

    public void setJlMessage(NLabel jlMessage) {
        this.jlMessage = jlMessage;
    }
    
    
    /**
     * Este metodo permite  ajustar el objeto que muestra  la hora de la
     * notificacin, se ajusta la hora y el color que se mostrará
     *dentro de la DesktopNotify.
     */

    private void setTimeNotification(){
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm a");
        this.jlDate.setText(sdf.format(cal.getTime()));
    }

}
