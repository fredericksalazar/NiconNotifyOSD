NiconNotifyOSD
==============

<b> NiconNotifyOSD</b> es una libreria para <b>JavaSE</b> que permite gestionar notificaciones de escritorio en todos los sistemas opreativos, con una simple API, usted podrà mostrar todo tipo de notificaciones flotantes con diferentes parámetros en <b>GNU/Linux</b>, <b> Windows </b> y <b> Mac OS</b>

Get Started
==========
El <b> API Notification </b> ofrece todos los métodos necesarios para poder usar la librería, usted podrá en cuestion de segundos comenzar a usar la librería, a continuacion mostramos algunas de las propiedades del API Notification y como puede empezar a usarla en sus proyectos

<b>Definiciones:</b>

Antes de empezar a usar la librería, consideramos que debe conocer un poco más de los conceptos basicos que la componen,<b>NiconNotifyOSD</b> dispone de varios componentes en diferentes capas, estos componentes se complementan en uno solo, una <b>Notificacion</b>, asi en <b>NiconNotifyOSD </b> una notificacion es un objeto grafico que muestra información en una pantalla de una manera no intrusiva y temporal, para ello se creo las <b>DesktopNotify</b> objetos graficos, cuya mision es mostrar en pantalla la informacion que usted necesita, una DesktopNotify esta compuesta por un objeto denominado <b>NiconEvent</b>, en NiconNotifyOSD una notificacion tiene como unico objetivo mostrar un evento ocurrido, este objeto NiconEvent contiene la informacion como titulo, mensaje, tipo de notificación (Error, OK, Warning, Information), el tiempo que durará el evento en segundos, y si emite o no un sonido, este evento es pasado a la DesktopNotify, la cual será pasada al servidor de notificaciones <b>ServerOSD</b>, este ServerOSD es un objeto encargado de gestionar y controlar el despliegue de las notificaciones en pantalla,

<b>Lanzando Notificaciones desde su app Java:</b>

<ul>
  <li> Notificacion de Escritorio simple:
  <p> Una notificación de escritorio se compone de un titulo, un mensaje y un tipo de even

