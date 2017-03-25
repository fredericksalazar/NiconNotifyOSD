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

package nicon.notify.gui.desktopNotify.components;

import nicon.notify.core.Notification;
import nicon.notify.core.util.NotifyConfig;
import nicon.notify.gui.desktopNotify.DesktopNotify;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

/**
 * Esta clase representa un boton personalizado de NiconNotifyOSD
 * tiene caracteristicas especiales para el sistema y esta
 * adaptado exclusivamente a la UI, este  tipo de boton permite
 * ajustarlo segun las condiciones y tipos de eventos, asi el
 * boton recibe un tipo 1 para confirmar y 0 para cancelar
 *
 *
 * @author FrederickSalazar
 */

public class nsButton extends JButton{

    DesktopNotify notify;
    private int tipo;
    private float opacity;
    
    public nsButton(DesktopNotify notify,String text, int tipo){

        super(text);
        this.setOpaque(false);
        this.setContentAreaFilled(false);
        this.setBorderPainted(false);

        if(tipo ==1){
            this.setForeground(Color.white);
        }else{
            this.setForeground(Color.darkGray);
        }

        this.notify = notify;
        this.tipo = tipo;
        this.opacity = 0.8f;
        addMouseListener(new EventButton());
    }

    public int getTipo() {
        return tipo;
    }

    public void setOpacity(float opacity){
        this.opacity = opacity;
    }

    public float getOpacity(){
        return opacity;
    }

    @Override
    protected void paintComponent(Graphics g) {

        /*
        validamos el tipo de boton creado para asi dinamicamente ajustar el color de fondo, si es un
        boton de tipo 0 (cancel) entonces su color de fondo es constante, pero si el tipo de boton
        es 1 (Acept) entonces deberemos ajustar el color de fondo de acuerdo al tipo de evento
        Error, wairnig, exito
        */

        Graphics2D g2 = (Graphics2D) g;

        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,opacity));

        if(this.tipo == 1){

            if(notify.getEvent().getTipeMessage() == Notification.DEFAULT_MESSAGE){
                g2.setColor(NotifyConfig.getInstance().getFontConfirmColor());
            }else{
                g2.setColor(notify.getForegroundTitle());
            }
        }else if(this.tipo == 0){
            g2.setColor(NotifyConfig.getInstance().getCancelButtonColor());
        }

        g2.fillRect(0,0,this.getWidth(),this.getHeight());

        super.paintComponent(g2);
    }


    /**
     * Esta clase anidada manejará el efecto hover sbre el boton
     */

    public class EventButton extends MouseAdapter{

        @Override
        public void mouseClicked(MouseEvent e) {
            efectHover(0.8f,1f,0.1f,5,true);
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            efectHover(1f,0.8f,0.1f,5,false);
        }

        @Override
        public void mouseExited(MouseEvent e) {
            efectHover(0.8f,1f,0.1f,5,true);
        }

        /**
         * Este metodo permite ejecutar el efecto Hover en el boton al momento de realizar diferentes
         * acciones con el mouse
         *
         * @param index
         * @param range
         * @param cont
         * @param sleep
         * @param event
         */
        public void efectHover(float index, float range, float cont, int sleep,boolean event){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (float i = index;(event)? i <= range : i >= range;i = (event)?i+cont:i-cont){
                        setOpacity(i);
                        try{
                            Thread.sleep(sleep);
                        }catch(Exception e){
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        }
    }
    
}
