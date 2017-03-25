package nicon.notify.gui.desktopNotify.controller;

import nicon.notify.core.server.ServerOSD;
import nicon.notify.gui.desktopNotify.DesktopNotify;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by frederick on 22/03/17.
 */
public class MouseController extends MouseAdapter {

    private final DesktopNotify notify;

    public MouseController(DesktopNotify notify){
        this.notify = notify;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("El mouse fue Clickado");
        ServerOSD.getInstance().remove(notify.getNid());
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("El mouse fue presionado");
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("Entro el mouse");
    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}
