package GreedforSpeed;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.Timer;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

import java.awt.event.*;

public class Game implements ActionListener, KeyListener{

    protected ArrayList<Rock> rocks = new ArrayList<>();
    protected static Game game;
    static Timer timer;
    protected Random rand = new Random();
    protected Rectangle2D car;
    protected int xMotion = 0;
    panel panel;
    protected int HEIGHT = 800, WIDTH = 600;
    protected int ticks;
    protected boolean startGame = false;


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
    public void addRock(){
        Rock rock = new Rock(100 + rand.nextInt(300), 0,30+rand.nextInt(30));
        rocks.add(rock);
    }
     
    @Override
    //timer calls this every delay seconds - need timer
    public void actionPerformed(ActionEvent e){

        ticks++;
        
       if(startGame){
            if(rocks.size()>0){
                for(Rock rock: rocks){
                    rock.y+=5;
                    if(rock.y == HEIGHT){
                        rock.x = 100 + rand.nextInt(300);
                        rock.y = 0;
                    }
                }
            }

           if(ticks%40==0 && ticks > 0 && rocks.size() < 5){                
                this.addRock(); 
           }
        }
        panel.repaint();        
    }

    public void repaint(Graphics g){
        g.setColor(Color.darkGray.darker());
        g.fillRect(0, 0, WIDTH, HEIGHT);
        

        //MAKING EVERYTHING WHITE!!! check!!
        if(rocks.size()>0){
            for( Rock rock: rocks){
                rock.rock = new Ellipse2D.Double((double)rock.x,(double)rock.y,(double)rock.radius+5, (double)rock.radius);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setColor(Color.WHITE);
                g2d.fill(rock.rock);
            }
        }



        //code to create visuals that update every fps
    }

    class panel extends JPanel {

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
            startGame = true;
        }
        
    }


    @Override
    public void keyReleased(KeyEvent e) {
    }


    @Override
    public void keyTyped(KeyEvent e) {
    }
}