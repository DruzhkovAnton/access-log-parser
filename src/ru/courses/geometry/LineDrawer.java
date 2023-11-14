package ru.courses.geometry;

import javax.swing.*;
import java.awt.*;

public class LineDrawer extends JFrame {
    int x1,x2,y1,y2;
    int x3,x4,y3,y4;
    int x5,x6,y5,y6;


    public LineDrawer(Line line1, Line line2, Line line3) {

        this.x1 = line1.p1.x*10;
        this.y1 = line1.p1.y*10;
        this.x2 = line1.p2.x*10;
        this.y2 = line1.p2.y*10;
        this.x3 = line2.p1.x*10;
        this.y3 = line2.p1.y*10;
        this.x4 = line2.p2.x*10;
        this.y4 = line2.p2.y*10;
        this.x5 = line3.p1.x*10;
        this.y5 = line3.p1.y*10;
        this.x6 = line3.p2.x*10;
        this.y6 = line3.p2.y*10;

        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void paint(Graphics g) {
        g.drawLine(x1, y1, x2, y2);
        g.drawLine(x3, y3, x4, y4);
        g.drawLine(x5, y5, x6, y6);
    }

}