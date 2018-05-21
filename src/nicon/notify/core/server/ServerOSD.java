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

package nicon.notify.core.server;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import nicon.notify.gui.desktopNotify.DesktopConfirm;
import nicon.notify.gui.desktopNotify.DesktopNotify;

import javax.swing.*;

/**
 *
 * Autor: FrederickSalazar
 *
 * El ServerOSD es denominado servidor de notificaciones de NiconNotifyOSD
 * tiene como funcion central gestionar la publicacion en pantalla de
 * todas las notificaciones recibidas, se encarga de administrar el stack
 * de notificaciones, asi entonces el ServerOSD es el encargado de
 * validar la cantidad maxima de notificaciones permitidas por el tamaño de
 * la pantalla, adicionalmente controla la posicion en la cual las
 * notificaciones serán mostradas.
 *
 * @author Frederick Adolfo Salazar Sanchez
 */

public class ServerOSD{
    
    private int nid;
    private int size;
    private int maxStackSize;
    private int yPosition;
    private int prev_vertical_position;

    private Timer timer;

    private HashMap stackServer;

    private Toolkit tool;
    private Dimension dimensionDevice;
    
    private DesktopNotify notify;
    private static ServerOSD server;

    private final double versionServer;


    /**
     * Autor: FrederickSalazar
     *
     * Crea una nueva instancia del servidor de notificaciones,
     * este es el encargado de controlar y gestionar la
     * publicación y eliminacion de notificaciones del stack
     *
     */

    private ServerOSD(){
        versionServer =  1.70;
        System.out.println("Starting ServerOSD "+versionServer);
        stackServer = new HashMap();
        setMaximunStackSize();
        size = -1;
    }


    /**
     * Autor: FrederickSalazar
     *
     * Crea una NID para una nueva  notificacion que será  lanzada por
     * el servidor este NID identifica la notifiacion dentro del
     * stack de notificaciones
     *
     * @return int NID
     */

    private int createNID(){
        System.out.println("ServerOSD: creating nid key stack ...");
        nid = (int) Math.floor(Math.random()*1000);
            if(stackServer.containsKey(nid)){
                System.out.println("ServerOSD: the key is not available ...");
                createNID();
            }
        System.out.println("ServerOSD: nid key is : "+nid);
        return nid;
    }


    /**
     * El metodo send() es el encargado de controlar y enviar la notificacion
     * al escritorio, la notificacion es cargada al denominado stack de
     * notificaciones, se crea el nid y se la notificacion se hace visible para
     * el OS host, dentro de este metodo controlaremos de igual forma el tiempo
     * que se deseea mostrar la notificacion en pantalla o se se desea dejar
     * impresa en pantalla hasta que el mismo usuario desee cerrarla
     *
     * @param notify
     */

    public synchronized void  send(final DesktopNotify notify){

        try{

            if(stackServer.size()<=getMaxStackSize()){

                notify.setNid(createNID());
                System.out.println("ServerOSD: Stack size: "+stackServer.size());
                stackServer.put(nid, notify);

                notify.setLocation(getDimensionDevice().width-notify.getWidth()-5,setVerticalPosition());
                System.out.println("ServerOSD: Notification is Launched nid:"+nid);
                prev_vertical_position = notify.getY();

                /*
                Autor: FrederickSalazar
                Fecha: 22 de marzo de 2017
                Descr: eliminamos el uso de server Thread y usamos un timer
                       para asi controlar el tiempo de ejecucion de la notificacion
                */

                timer = new Timer(notify.getEvent().getTime(), new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //eliminamos la notificacion del stack
                        remove(notify.getNid());
                    }
                });

                if(notify instanceof DesktopConfirm){
                    ((DesktopConfirm) notify).setState(true);
                }

                timer.start();
                notify.showMe();
            }
        }catch(Exception e){
           System.out.println("ServerOSD: Exception in send():\n"+e);
        }
    }


    /**
     * Autor:  FrederickSalazar
     *
     * permite remover una notificacion del servidor de notificaciones,
     * la elimina del stack de notificaciones e invoca el metodo
     * notify en el caso de las DesktopConfirm para liberar el hilo
     * de ejecucion y retornar el valor seleccionado por el usuario
     *
     * @param nid
     */

    public void remove(int nid){

        if(stackServer.containsKey(nid)){
            notify = (DesktopNotify) stackServer.get(nid);
            if(notify.isVisible()){
                notify.dispose();
                stackServer.remove(nid);

                if(notify instanceof DesktopConfirm){
                    System.out.println("Si es una cnfirm");
                    ((DesktopConfirm) notify).setState(false);
                    synchronized (notify){
                        notify.notify();
                    }
                }
                System.out.println("ServerOSD: notification with nid: "+nid+" remove successfully ...");
            }
        }
    }


    /**
     * Autor: FrederickSalazar
     *
     * Este metodo permite calcular segun el tamaño de la pantalla la cantidad maxima de
     * notificaciones que puede recibir el stack de notificaciones, el calculo
     * de la cantidad de notificaciones es el resultado de medir el alto de la pantall
     * y dividirlo por el alto promedio de las notificaciones
     */

    private void setMaximunStackSize(){
        maxStackSize = (int) getDimensionDevice().getHeight()/110;
        System.out.println("Maximun total notification in screen: "+maxStackSize);
    }


    /**
     * Autor: FrederickSalazar
     *
     * Este metodo retorna la maxima cantidad de notificaciones
     * que soporta el stack de acuerdo a la capacidad de la
     * pantalla medida en el alto de la misma
     *
     * @return int maxStackSize
     */

    public int getMaxStackSize(){
        return maxStackSize;
    }


    /**
     * calcula y retorna la posicion en el eje Y para una nueva
     * notificacion que será desplegada en pantalla
     *
     * @return int verticalPosition
     */

    private int setVerticalPosition(){
        if(stackServer.size()==1){
            yPosition = 30;
        }else {
           if(stackServer.size()>1){
               yPosition = prev_vertical_position + 110;
           }
        }
        return yPosition;
    }


    /**
     * Retorna un objeto {@link Dimension} que representa
     * el tamaño de la pantalla en la cual se esta ejecutando
     * el serverOSD
     *
     * @return Dimension dimensionDevice
     */

    public Dimension getDimensionDevice(){
        try{
           tool = Toolkit.getDefaultToolkit();
           dimensionDevice = tool.getScreenSize();
        }catch(Exception e){
            System.err.println("ServerOSD: Exception in: "+e);
        }
        return dimensionDevice;
    }


    /**
     * Retorna la cantidad de notificaciones que actualmente
     * posee el stack
     *
     * @return int stackSize
     */

    private int stackSize(){
        if(stackServer!=null){
            size = stackServer.size();
        }
        return size;
    }


    /**
     * Retorna una instancia del servidor de notificaciones el cual
     * se encarga de controlar al gestion de notificaciones
     * en el escritorio
     *
     * @return ServerOSD instance
     */

    public static ServerOSD getInstance(){
        if(server==null){
            server = new ServerOSD();
        }
        return server;
    }
}
