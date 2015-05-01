package gameadapter;

import gamelogic.BoardPanel;
import gamelogic.Tetris;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by ayhun on 1.5.2015.
 */
public class ConnectionFrame extends JFrame{
    public ConnectionFrame(Tetris tetris){
        setLocation(300,300);
        setLayout(new GridLayout(3, 2));
        applyComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        setPreferredSize(new Dimension(200, 200 ));
        setBackground(Color.BLACK);
        TextField hostIP = new TextField("127.0.0.1");
        TextField hostPort = new TextField("9998");
        Button connectButton = new Button("Connect");
        connectButton.setFocusable(false);
        connectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tetris.connect(hostIP.getText(), Integer.parseInt(hostPort.getText()));
                setVisible(false);
            }
        });

        this.add(new Label("Host:"));
        this.add(hostIP);
        this.add(new Label("Port:"));
        this.add(hostPort);
        this.add(connectButton);

        pack();
        setVisible(true);
    }
}
