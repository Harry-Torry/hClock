package hclock;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class HClock {

    static Point mouseDownCompCoords;
    static JLabel timeLabel;

    public static void main(String[] args) {
        final JFrame f = new JFrame("Hello");

        mouseDownCompCoords = null;
        f.setUndecorated(true);
        f.setVisible(true);
        f.setBounds(0, 0, 200, 75);
        f.setAlwaysOnTop(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        timeLabel = new JLabel("Something went wrong!", SwingConstants.CENTER);
        timeLabel.setPreferredSize(new Dimension(300, 100));

        f.getContentPane().add(timeLabel, BorderLayout.CENTER);

        f.addMouseListener(new MouseListener() {

            @Override
            public void mouseReleased(MouseEvent e) {
                mouseDownCompCoords = null;
            }

            @Override
            public void mousePressed(MouseEvent e) {
                mouseDownCompCoords = e.getPoint();
            }

            public void mouseExited(MouseEvent e) {
            }

            public void mouseEntered(MouseEvent e) {
            }

            public void mouseClicked(MouseEvent e) {
            }
        });

        f.addMouseMotionListener(new MouseMotionListener() {

            public void mouseMoved(MouseEvent e) {
            }

            public void mouseDragged(MouseEvent e) {
                Point currCoords = e.getLocationOnScreen();
                f.setLocation(currCoords.x - mouseDownCompCoords.x, currCoords.y - mouseDownCompCoords.y);
            }
        });


        while (true) {
            DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
            Date date = new Date();            
            String theTime = dateFormat.format(date).toString();
            timeLabel.setText(theTime);
        }

    }
}