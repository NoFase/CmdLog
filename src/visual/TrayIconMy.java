package visual;

import debuging.CollectorLogs;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.*;

public class TrayIconMy {

        public  final String APPLICATION_NAME = "CmdLog";
        public  final String ICON_STR = "/images/image_logo32x32.png";

    public TrayIconMy() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new CollectorLogs();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                setTrayIcon();
            }
        });
    }

//    public static void main(String[] args) {
//            SwingUtilities.invokeLater(new Runnable() {
//                @Override
//                public void run() {
//                    setTrayIcon();
//                }
//            });
//        }

//        private static void createGUI() {
//            JFrame frame = new JFrame(APPLICATION_NAME);
//            frame.setMinimumSize(new Dimension(300, 200));
//            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//            frame.pack();
//            frame.setVisible(true);
//
//            setTrayIcon();
//        }

        private  void setTrayIcon() {
            if(! SystemTray.isSupported() ) {
                return;
            }

            PopupMenu trayMenu = new PopupMenu();
            MenuItem item = new MenuItem("Exit");
            item.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.exit(0);
                }
            });
            trayMenu.add(item);

            URL imageURL = TrayIconMy.class.getResource(ICON_STR);

            Image icon = Toolkit.getDefaultToolkit().getImage(imageURL);
            TrayIcon trayIcon = new TrayIcon(icon, APPLICATION_NAME, trayMenu);
            trayIcon.setImageAutoSize(true);

            SystemTray tray = SystemTray.getSystemTray();
            try {
                tray.add(trayIcon);
            } catch (AWTException e) {
                e.printStackTrace();
            }

            trayIcon.displayMessage(APPLICATION_NAME, "Application started!",
                    TrayIcon.MessageType.INFO);
        }
}
