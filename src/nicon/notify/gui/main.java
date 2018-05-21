package nicon.notify.gui;

import nicon.notify.core.Notification;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

/**
 * Created by frederick on 23/03/17.
 */
public class main {

    public static void main(String args[]){

        try {
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        //Notification.show("NiconNotifyOSD 3.0","Notificaciones inteligenes dese NiconNotifyOSD 3.0",Notification.NICON_GRAY_THEME,60);

        Notification.show("Cliente SIMS repimpresión:","Un pin no ha podido ser pagado",Notification.NICON_DARK_THEME,Notification.WARNING_MESSAGE);

    /*
        Notification.show("NiconNotifyOSD 3.0","Nuevo servidor de notificaciones actuando ",Notification.NICON_DARK_THEME, true);

        Notification.show("NiconNotifyOSD 3.0","Nuevo servidor de notificaciones actuando ",Notification.NICON_LIGHT_THEME,Notification.ERROR_MESSAGE);

        Notification.show("NiconNotifyOSD 3.0","Nuevo servidor de notificaciones actuando ",Notification.NICON_DARK_THEME, Notification.OK_MESSAGE);

        Notification.show("NiconNotifyOSD 3.0","Nuevo servidor de notificaciones actuando ",Notification.NICON_DARK_THEME, Notification.WARNING_MESSAGE);


        int sel = Notification.showConfirm("NiconNotifyOSD 3.0","DesktopConfirm con nueva interface y funcionalidad",
                                           Notification.NICON_LIGHT_THEME,Notification.ERROR_MESSAGE);
    */

        Notification.show("Hola","Hola",Notification.NICON_GRAY_THEME,Notification.OK_MESSAGE);
        Notification.show("hola","hola",Notification.NICON_LIGHT_THEME,Notification.DISK_ICON,1000);

        Notification.showConfirm("Hola","hola sapo hijo de la grandisima puta",Notification.NICON_LIGHT_THEME,Notification.ERROR_MESSAGE,100);
    }
}
