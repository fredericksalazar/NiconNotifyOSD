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
import java.util.HashMap;
import nicon.notify.core.util.NotifyUtil;
import nicon.notify.gui.desktopNotify.DesktopNotify;

/**
 *
 * @author Frederick Adolfo Salazar Sanchez
 */
public class ServerOSD{
    
    private int nid;
    private int prev_vertical_position;
    private final double versionServer;
    private int size;
    private HashMap stackServer;
    private HashMap  stackThread;
    private ServerThread serThread;
    private final NotifyUtil nUtil;
    
    private Dimension dimensionDevice;
    
    private DesktopNotify notify;
    private static ServerOSD server;
    private Toolkit tool;
    private int yPosition;
    
    /*
        Este metodo permite crear el servidor de Notificaciones e iniciar sus
        configuraciones basicas.
    */
    private ServerOSD(){
        versionServer =  0.98;
        System.out.println("Starting ServerOSD "+versionServer);
        stackServer = new HashMap();
        stackThread= new HashMap();
        nUtil = NotifyUtil.getInstance();
        size = -1;
    }
    
    /*
        aqui generaremos el nid para cada notificacion, este nid será unico en 
        cada ejecución e identificará una notificacion dentro del stack de 
        notificaciones implementado en serverOSD, este numero es un enter
        aleatorio entre 1 y mil
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
    
    /*
        El metodo send() es el encargado de controlar y enviar la notificacion
        al escritorio, la notificacion es cargada al denominado stack de
        notificaciones, se crea el nid y se la notificacion se hace visible para
        el OS host, dentro de este metodo controlaremos de igual forma el tiempo
        que se deseea mostrar la notificacion en pantalla o se se desea dejar 
        impresa en pantalla hasta que el mismo usuario desee cerrarla
    */
    public void send(DesktopNotify notify, int time){
        try{
            if(stackServer.size()<=4){
                notify.setNid(createNID());
                System.out.println("ServerOSD: Stack size: "+stackServer.size());
                stackServer.put(nid, notify);
                    if(time >= 10){
                        serThread = new ServerThread(this,nid,time);   
                        serThread.start();
                        stackThread.put(nid, serThread);
                    }
                notify.setLocation(getDimensionDevice().width-notify.getWidth()-5,setVerticalPosition());
                System.out.println("ServerOSD: Notification is Launched nid:"+nid);
                notify.setVisible(true);
                prev_vertical_position = notify.getY();
            }
        }catch(Exception e){
           System.out.println("ServerOSD: Exception in send():\n"+e);
        }
    }
    
    /*
        Este metodo se encarga de ocultar una notificacion en pantalla en caso 
        de que este visible y de eliminar una notificacion en el stack,
    */
    public void remove(int nid){
        ServerThread thrd;
        if(stackServer.containsKey(nid)){
            notify = (DesktopNotify) stackServer.get(nid);
            if(notify.isVisible()){
                notify.dispose();
                thrd = (ServerThread) stackThread.get(nid);
                thrd.killThread();
                stackServer.remove(nid);
                stackThread.remove(nid);
                System.out.println("ServerOSD: notification with nid: "+nid+" remove successfully ...");
            }
        }
    }
    
    /*
     * Este metodo permite ajustar el valor de posicionamiento en el eje Y de una
     * notificacion, calculando la cantidad de notificaciones en ejecucion, el
     * valor height de cada una de ellas y su espacio de separacion podemos saber
     * cual es realmente su nuevo valor de Y
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
    
    
    
    /*
        Este metodo permite conocer las dimensiones en pixeles de la pantalla del
        dispositivo en el cual se esta ejecutando este servidor, el metodo de 
        tipo público retorna un ojeto de tipo Dimension con los valores width 
        y height.
        @return Dimension
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
    
    /*
        Este metodo se usa para retorna el total de notificaciones cargadas 
        dentro de el stack de notificaciones.
    */
    private int stackSize(){
        if(stackServer!=null){
            size = stackServer.size();
        }
        return size;
    }
    
    /*
        Usando el patron de diseño Singleton y segun los requerimientos el 
        ServerOSD debe ser un objeto único dentro de el entorno de ejecución
        pues será quien controle de forma central la gestion de notificaciones.
        @return serverOSD
    */
    public static ServerOSD getInstance(){
        if(server==null){
            server = new ServerOSD();
        }
        return server;
    }
}
