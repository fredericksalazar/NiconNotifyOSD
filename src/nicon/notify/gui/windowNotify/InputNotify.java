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
package nicon.notify.gui.windowNotify;

import java.awt.Component;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import nicon.notify.core.NiconEvent;
import nicon.notify.core.util.NotifyConfig;

/**
 * Esta clase instancia un objeto del tipo InputNotify que es utilizada para
 * capturar datos simples por parte del usuario, Hereda directamente de
 * WindowNotify y puede retornar los datos ingresados por el usuario.
 *
 * @author frederick
 */
public class InputNotify extends WindowNotify {

    private NotifyConfig config;
    private JTextField textField;
    private JButton jbCancelar;
    private ImageIcon icon;

    public InputNotify(Component content,NiconEvent ev) {
        super(content,ev);
        setSize(545, 260);
        config = NotifyConfig.getInstance();
        init();
    }

    private void init() {
        icon = new ImageIcon(getClass().getResource(config.getNitruxIconsPath() + "NiconQuestion.png"));
        setIconMessage(icon);
        setForegroundTitle(new java.awt.Color(0, 151, 214));

        textField = new JTextField();
        textField.setFont(config.getMessageFont());
        textField.setBounds(108, 150,420, 30);
        addTextField(textField);

        jbCancelar = new JButton("Cancelar");
        jbCancelar.setBounds(280, 190, 120, 30);
        addButton(jbCancelar);
        jbCancelar.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        jbAcept.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {                
                    getInputData();                
            }
        });
        moveAceptButton(405, 190);

    }

    /**
     * Retorna el valo ingresado por el usuario en una variable del tipo string
     * @return String data:
     */
    public String getInputData(){
        return textField.getText();
    }
}
