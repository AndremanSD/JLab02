package org.dstu;

import org.dstu.components.GraphicsPanel;
import org.dstu.shapes.Circle;
import org.dstu.shapes.Shape;
import org.dstu.shapes.Square;
import org.dstu.shapes.animation.Animator;
import org.dstu.shapes.animation.CircleAnimator;
import org.dstu.shapes.animation.SquareAnimator;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        List<Shape> shapes = new ArrayList<>();
        shapes.add(new Circle(50, 150, 100, Color.GREEN));
        shapes.add(new Circle(150, 150, 100, Color.GREEN));
        shapes.add(new Circle(150, 250, 100, Color.GREEN));
        shapes.add(new Square(500, 170, 50, Color.BLUE));
        shapes.add(new Square(520, 120, 50, Color.BLUE));
        shapes.add(new Square(570, 70, 50, Color.BLUE));

        GraphicsPanel canvas = new GraphicsPanel(shapes);

        Runnable circleController = () -> {
            while (true) {
                shapes.size();
                shapes.forEach(shape -> {
                    if (shape instanceof Circle) {
                        shape.moveRel((int)(Math.random() * 5), (int)(Math.random() * 2));
                        ((Circle) shape).setRadius((int)Math.random() * 30);

                    } else if (shape instanceof Square) {
                        shape.moveRel(-(int)(Math.random() * 5), -(int)(Math.random() * 2));
                    }
                });
                canvas.repaint();
                try {
                    Thread.sleep(250);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        for (Shape s: shapes) {
            Thread t = new Thread(s.getAnimator(canvas));
            t.start();
        }

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(720, 480);
        frame.add(canvas);
        frame.setVisible(true);

//        Thread animationThread = new Thread(circleController);
//        animationThread.start();
    }
}
