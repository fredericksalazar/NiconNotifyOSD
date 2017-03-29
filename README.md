NiconNotifyOSD
==============

<b> NiconNotifyOSD</b> es una libreria para <b>JavaSE</b> que permite gestionar notificaciones de escritorio en todos los sistemas opreativos, con una simple API, usted podrà mostrar todo tipo de notificaciones flotantes con diferentes parámetros en <b>GNU/Linux</b>, <b> Windows </b> y <b> Mac OS</b>

Get Started
==========
El <b> API Notification </b> ofrece todos los métodos necesarios para poder usar la librería, usted podrá en cuestion de segundos comenzar a usar la librería, a continuacion mostramos algunas de las propiedades del API Notification y como puede empezar a usarla en sus proyectos

<b>Definiciones:</b>

Antes de empezar a usar la librería, consideramos que debe conocer un poco más de los conceptos basicos que la componen,<b>NiconNotifyOSD</b> dispone de varios componentes en diferentes capas, estos componentes se complementan en uno solo, una <b>Notificacion</b>, asi en <b>NiconNotifyOSD </b> una notificacion es un objeto grafico que muestra información en una pantalla de una manera no intrusiva y temporal, para ello se creo las <b>DesktopNotify</b> objetos graficos, cuya mision es mostrar en pantalla la informacion que usted necesita, una DesktopNotify esta compuesta por un objeto denominado <b>NiconEvent</b>, en NiconNotifyOSD una notificacion tiene como unico objetivo mostrar un evento ocurrido, este objeto NiconEvent contiene la informacion como titulo, mensaje, tipo de notificación (Error, OK, Warning, Information), el tiempo que durará el evento en segundos, y si emite o no un sonido, este evento es pasado a la DesktopNotify, la cual será pasada al servidor de notificaciones <b>ServerOSD</b>, este ServerOSD es un objeto encargado de gestionar y controlar el despliegue de las notificaciones en pantalla, controla la posición, el tiempo de despliegue y el stack de notificaciones.

<b>Tipos de notificación:</b>

<b>NiconNotifyOSD </b> dispone, por ahora, de dos tipos de notificaciones, las <b>DesktopNotify</b> y las <b>DesktopConfirm</b>, las DesktopNotify son notificaciones simples que contienen un titulo, un mensaje, un tipo de notificacion y son mostradas en pantalla a modo informativo, basicamente su objetivo es mostrar informaciòn al usuario, por el contrario las <b>DesktopConfirm</b> son notificaciones que permiten al usuario poder seleccionar un valor Aceptar o cancelar, ademas de mostrar información al usuario, permiten al mismo poder tomar una decisión.


Lanzando Notificaciones desde su app Java
=========================================

A continuación vera lo simple que usar la librería y el poder del API Notification

<ul>
  <li> Notificacion de Escritorio simple:
  <p> Notification.show("NiconNotifyOSD 3.0", "Esta es una notificacion de prueba, usando la nueva"
                        + "version de NiconNotifyOSD, con nuevo diseño y funcionalidad", Notification.NICON_DARK_THEME);</p>
  
  

