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

import java.util.HashMap;
import nicon.notify.gui.desktopNotify.DesktopNotify;

/**
 *
 * @author Frederick Adolfo Salazar Sanchez
 */
public class ServerOSD{
    
    private int nid;
    private final double versionServer;
    private int size;
    private HashMap stack;
    private ServerThread serThread;
    
    
    private DesktopNotify notify;
    private ServerOSD server;
    
    private ServerOSD(){
        versionServer =  1.0;
        stack = new HashMap();
        size = -1;
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
           if(stack.size()<4){
             notify.setNid(createNID());
             stack.put(nid, notify);
             serThread = new ServerThread(this,nid,3500);
             notify.setVisible(true);
             serThread.start();
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
        if(stack.containsKey(nid)){
            notify = (DesktopNotify) stack.get(nid);
            if(notify.isVisible()){
                notify.dispose();
                stack.remove(nid);
            }
        }
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
            if(stack.containsKey(nid)){
                System.out.println("ServerOSD: the key is not available ...");
                createNID();
            }
        return nid;
    }
    
    /*
        Este metodo se usa para retorna el total de notificaciones cargadas 
        dentro de el stack de notificaciones.
    */
    public int stackSize(){
        if(stack!=null){
            size = stack.size();
        }
        return size;
    }
    
    /*
        Usando el patron de diseño Singleton y segun los requerimientos el 
        ServerOSD debe ser un objeto único dentro de el entorno de ejecución
        pues será quien controle de forma central la gestion de notificaciones.
    */
    public ServerOSD getInstance(){
        if(server==null){
            server = new ServerOSD();
        }
        return server;
    }
}
