package Java2;

import javax.swing.*;
import javax.swing.text.html.HTMLDocument;
import java.awt.*;
import java.util.Random;

public class GameCanvas  extends JPanel {
    private long lastFrameTime;
    private  MainCircles controller;

    GameCanvas(MainCircles controller){
    lastFrameTime = System.nanoTime();
    this.controller = controller;
    }
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        long currentTime = System.nanoTime();
        float deltaTime = (currentTime - lastFrameTime) * 0.000000001f;
        lastFrameTime = currentTime;
        controller.onDrawCanvas(this, g, deltaTime);
        try{
            Thread.sleep(17);//сформирует для нас задрежку fps, т.е без нагрузки //no payload =250 fps, а thear.sleep(17) = 1/60 frames=16.(6)fps.
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        repaint();
    }

    public int getLeft() {return 0; }
    public int getRight() {return getWidth() - 1;}
    public int getTop() {return 0; }
    public int getBottom() {return getHeight() - 1; }
}