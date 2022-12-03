package GreedforSpeed;
import java.awt.geom.Ellipse2D;
import java.io.File;
import java.io.IOException;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.Timer;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.event.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.TexturePaint;

public class Game implements ActionListener, KeyListener{

    protected ArrayList<Rock> rocks = new ArrayList<>();
    protected static Game game;
    static Timer timer;
    protected Random rand = new Random();
    protected Rectangle car;
    protected int xMotion = 0;
    panel panel;
    protected int HEIGHT = 800, WIDTH = 600;
    protected int ticks;
    protected boolean startGame = false;
    protected ArrayList<roadLines> roads = new ArrayList<>();
    


    public static void main(String[] args){
        game = new Game();
    }


    Game(){

        JFrame frame = new JFrame("Greed for Speed");
        timer = new Timer(30, this);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WIDTH, HEIGHT);


        panel = new panel();
        panel.setBackground(Color.black);
        frame.add(panel);
        frame.addKeyListener(this);
        frame.setResizable(false);
        frame.setVisible(true);

        for(int i = -1; i<4;i++){
            roads.add(new roadLines(290, i*200)); //road lines of width 20,length 120, xcoords 290 and ycoords multiples of 180
        }        

    }

    class Rock{

        Ellipse2D rock;
        int x;
        int y;
        int radius;

        Rock(int x,int y, int radius){
            this.x = x;
            this.y = y;
            this.radius = radius;
        }
    }

    class roadLines{

        Rectangle roadLine;
        int x;
        int y;

        roadLines(int x, int y){
            this.x = x;
            this.y = y;
        }
    }



    public void addRock(){
        Rock rock = new Rock(50 + rand.nextInt(500), 0,50+rand.nextInt(30));
        rocks.add(rock);
    }


     
    @Override
    public void actionPerformed(ActionEvent e){

        ticks++;
        
       if(startGame){
            if(rocks.size()>0){
                for(Rock rock: rocks){
                    rock.y+=5;
                    if(rock.y == HEIGHT){
                        rock.x = 50 + rand.nextInt(500);
                        rock.y = 0;
                    }
                }
            }

           if(ticks%100==0 && ticks > 0 && rocks.size() < 7){                
                this.addRock(); 
           }

           for(roadLines road: roads){
            road.y+=5;
                if(road.y == HEIGHT+100){
                    road.y = -100;
                }
            }
       }

           

        panel.repaint(); 
        

    }

    public void repaint(Graphics g){    

        //drawingRoad(g);

        Graphics2D g2d = (Graphics2D) g;

        
        for(roadLines road: roads){
            road.roadLine = new Rectangle(road.x, road.y, 20, 100);
            g2d.setColor(Color.white);
            g2d.fill(road.roadLine);

        }


        if(rocks.size()>0){
            for( Rock rock: rocks){
                rock.rock = new Ellipse2D.Double((double)rock.x,(double)rock.y,(double)rock.radius+15, (double)rock.radius-15);
                //g2d.setPaint(drawingRock());
                g2d.setColor(Color.darkGray);
                g2d.fill(rock.rock);
            }
        }

        car = new Rectangle(xMotion + 275, 450, 50, 70);
        g2d.setColor(Color.RED.darker());
        g2d.fill(car);

    }


    public TexturePaint drawingRock(){
        BufferedImage img2 = null;
        TexturePaint pt = null;

        try{
            img2 = ImageIO.read(new File("GreedforSpeed/rock.jpg"));}
        catch(IOException e){
            System.out.println("no img!");
        }

        
        if(img2 != null){
            pt = new TexturePaint(img2,new Rectangle(0,0,200,200));
            return pt;
        }
        return pt;
    }

    


    static class panel extends JPanel {        

        private static final long serialVersionUID = 1L;
    
        protected void paintComponent(Graphics g){
            super.paintComponent(g);
            game.repaint(g);              
        } 

    }

   
    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyChar()== KeyEvent.VK_SPACE){
            timer.start();
            if(startGame == false){
                startGame = true;
            }
            else{ 
                startGame = false;
               // gameOver()
            }
        }

        int keyCode = e.getKeyCode();
        if(keyCode == KeyEvent.VK_LEFT){
            xMotion -= 10;
        }
        if(keyCode == KeyEvent.VK_RIGHT){
            xMotion += 10;
        }
        panel.repaint();
        
    }


    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}
}