import java.awt.*;
import java.awt.event.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;
public class SnakeGame extends JPanel implements ActionListener,KeyListener{
    @Override
    public void actionPerformed(ActionEvent e) {
        move();
        repaint();
        if(gameOver)
            gameloop.stop();
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_UP&&velocityY!=1){
            velocityX=0;
            velocityY=-1;
        }
        else if(e.getKeyCode()==KeyEvent.VK_DOWN&&velocityY!=-1){
            velocityX=0;
            velocityY=1;
        } else if (e.getKeyCode()==KeyEvent.VK_RIGHT&&velocityX!=-1) {
            velocityY=0;
            velocityX=1;

        }
        else if (e.getKeyCode()==KeyEvent.VK_LEFT&&velocityX!=1) {
            velocityY=0;
            velocityX=-1;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    private  class Tile{
        int x;
        int y;
        Tile(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
    int boardWidth;
    int boardHeight;
    int tileSize=25;
    Tile snakeHead;

    Tile Food;
     Random random;
     //game Logic
     Timer gameloop;
     int velocityX;
     int velocityY;
     boolean gameOver=false;
     ArrayList<Tile> snakeBody;

    SnakeGame(int boardWidth,int boardHeight){
        this.boardWidth=boardWidth;
        this.boardHeight=boardHeight;
        setPreferredSize(new Dimension(this.boardWidth,this.boardHeight));
        setBackground(Color.black);
        addKeyListener(this);
        setFocusable(true);
        snakeHead=new Tile(5,5);
        Food=new Tile(10,10);
        random=new Random();
        placeFood();
        velocityX=0;
        velocityY=0;
        //game Timer
        gameloop =new Timer(100,this);
        gameloop.start();
      snakeBody = new ArrayList<Tile>();
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);
    }
    public void draw(Graphics g){
//        for(int i=0;i<boardWidth/tileSize;i++) {
//        g.drawLine(i*tileSize,0,i*tileSize,boardHeight);
//        g.drawLine(0,i*tileSize,boardWidth,i*tileSize);
//
//        }
        //food
           g.setColor(Color.red);
//        g.fillRect(Food.x*tileSize,Food.y*tileSize,tileSize,tileSize);
        g.fill3DRect(Food.x*tileSize,Food.y*tileSize,tileSize,tileSize,true);
        //Snake Head
        g.setColor(Color.green);
//            g.fillRect(snakeHead.x * tileSize, snakeHead.y * tileSize, tileSize, tileSize);
            g.fill3DRect(snakeHead.x * tileSize, snakeHead.y * tileSize, tileSize, tileSize,true);
       //Snake Body
        for(int i=0;i<snakeBody.size();i++){
        Tile snakePart=snakeBody.get(i);
//            g.fillRect(snakePart.x*tileSize,snakePart.y*tileSize,
//                    tileSize,tileSize);

            g.fill3DRect(snakePart.x*tileSize,snakePart.y*tileSize,
                    tileSize,tileSize,true);
       }
        //Score
        g.setFont(new Font("Roboto",Font.BOLD,16));
        if(gameOver){
            g.setColor(Color.red);
            g.drawString("Game over : "+String.valueOf(snakeBody.size()),tileSize-16,tileSize);
        }
else {
    g.drawString("Score : "+String.valueOf(snakeBody.size()),tileSize-16,tileSize);
        }
        }
        public void placeFood(){
        Food.x=random.nextInt(boardWidth/tileSize);//600/25
        Food.y=random.nextInt(boardHeight/tileSize);//600/25
        }
        public void move() {
            // eat food
            if (collision(snakeHead, Food)) {
                snakeBody.add(new Tile(Food.x, Food.y));
                placeFood();
            }
            //Snake Body
            for (int i = snakeBody.size() - 1; i >= 0; i--) {
                Tile snakePart = snakeBody.get(i);
                if (i == 0) {
                    snakePart.x = snakeHead.x;
                    snakePart.y = snakeHead.y;

                } else {
                    Tile prevSnakePart = snakeBody.get(i - 1);
                    snakePart.x = prevSnakePart.x;
                    snakePart.y = prevSnakePart.y;
                }
            }
                snakeHead.x += velocityX;
                snakeHead.y += velocityY;
                //game over conditions
                for (int j = 0; j < snakeBody.size(); j++) {
                    Tile snakePart = snakeBody.get(j);
              if(collision(snakeHead,snakePart))
                    gameOver=true;
                }
                if(snakeHead.x*tileSize<0||snakeHead.x*tileSize>boardWidth
                        ||snakeHead.y*tileSize<0||snakeHead.y*tileSize>boardHeight)
              gameOver=true;
        }
        public boolean collision(Tile tile1,Tile tile2){
        return tile1.x==tile2.x&&tile1.y==tile2.y;
        }
}
