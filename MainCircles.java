package Java2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MainCircles extends JFrame {
    private static final int POS_X = 200;
    private static final int POS_Y = 150;
    private static final int WINDOW_WIDTH = 600;
    private static final int WINDOW_HEIGTH = 400;

    private  Sprite[] sprites = new Sprite[1];
    private int spritesCount;

    private void update(GameCanvas canvas, float deltaTime){
        for (int i = 0; i < spritesCount; i++) {
            sprites[i].update(canvas, deltaTime);
        }
    }
    private void render(GameCanvas canvas, Graphics g){
        for (int i = 0; i < spritesCount; i++) {
            sprites[i].render(canvas, g);
        }
    }

    void onDrawCanvas(GameCanvas c, Graphics g, float deltaTime){
        update(c, deltaTime);
        render(c, g);
    }
    private void initApplication(){
        addSprite(new Background());
        }


    private MainCircles(){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(POS_X, POS_Y, WINDOW_WIDTH, WINDOW_HEIGTH);
        setTitle("Circles");
        GameCanvas canvas = new GameCanvas(this);
        canvas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1)
                    addSprite(new Ball(e.getX(), e.getY()));
                else if (e.getButton() == MouseEvent.BUTTON3)
                    removeSprite();
            }
        });
            add(canvas);
            initApplication();
            setVisible(true);
        }

    private void addSprite(Sprite s){
        if(spritesCount == sprites.length){
            Sprite[] temp = new Sprite[sprites.length * 2];
            System.arraycopy(sprites, 0, temp, 0, sprites.length);// system.arraycope - это копирование массивы, содержит 5 аргуметов, откуда копируем, куда копируем, из 0 индекса в 0 индекс, столько сколько нужно(.length)
            sprites = temp;
        }
        sprites[spritesCount++] = s;
    }
    private void removeSprite(){
        if (spritesCount > 1) spritesCount --;
    }

    public static void main(String[] args) {
        new MainCircles();
    }
}
