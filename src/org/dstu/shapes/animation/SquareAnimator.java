package org.dstu.shapes.animation;

import org.dstu.shapes.Circle;
import org.dstu.shapes.Shape;
import org.dstu.shapes.Square;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.*;

public class SquareAnimator extends Animator {

    public SquareAnimator(Shape shape, JComponent component) {
       super(shape, component);
    }

    Random ran = new Random();

    @Override
    public void run() {
        while (true) {

            if (Math.random() >= 0.5) {
                shape.moveRel(-(int) (Math.random() * 10), (int) (Math.random() * 10));
                int val = ran.nextInt(150);
                int r = ran.nextInt(255);
                int g = ran.nextInt(255);
                int b = ran.nextInt(255);
                ((Square) shape).setSide(val);
                shape.setColor(new Color(r, g, b));

            } else shape.moveRel((int) (Math.random() * 10), -(int) (Math.random() * 10));
            if (component != null) {
                component.repaint();
            }
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
