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
        setLocation(Toolkit.getDefaultToolkit().getScreenSize().width/3,Toolkit.getDefaultToolkit().getScreenSize().height/3);
        setLayout(new GridLayout(3, 2));
        applyComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        setPreferredSize(new Dimension(200, 100 ));
        setBackground(Color.BLACK);
        TextField hostIP = new TextField("127.0.0.1");
        TextField hostPort = new TextField("9997");
        Button connectButton = new Button("Connect");
        connectButton.setFocusable(false);
        connectButton.addActionListener(e -> {
            tetris.connect(hostIP.getText(), Integer.parseInt(hostPort.getText()));
            setVisible(false);
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
