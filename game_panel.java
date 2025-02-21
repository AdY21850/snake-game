import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class game_panel extends JPanel implements ActionListener , KeyListener
{

           Dimension size= Toolkit.getDefaultToolkit().getScreenSize();
           int width = (int)size.getWidth();
           int k=(width-45);
           int height = (int)size.getHeight();

         private int z=100;
         private int q=500;
         private String score1;
         private boolean gameover= false;
    private int [] snakexlength=new int[1000];
    private int [] snakeylength=new int[1000];
    private int  lengthOfSnake=3;

    private boolean left=false;
    private boolean right=true;
    private boolean up=false;
    private boolean down=false;


    private ImageIcon snaketitle = new ImageIcon(getClass().getResource("images//snaketitle2.png"));
    private ImageIcon leftmouth = new ImageIcon(getClass().getResource("images//leftmouth.png"));
    private ImageIcon rightmouth = new ImageIcon(getClass().getResource("images//rightmouth.png"));
    private ImageIcon upmouth = new ImageIcon(getClass().getResource("images//upmouth.png"));
    private ImageIcon downmouth = new ImageIcon(getClass().getResource("images//downmouth.png"));
    private ImageIcon snakeimage = new ImageIcon(getClass().getResource("images//snakeimage.png"));
    private ImageIcon enemy = new ImageIcon(getClass().getResource("images//enemy.png"));
    private ImageIcon gameover2 = new ImageIcon(getClass().getResource("images//gameover2.png"));



    private int moves =0;
    private int score=0;
    private Timer timer;
    private int delay= 50;


    game_panel() {
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(true);

        timer=new Timer(delay,this);
        timer.start(); 
        

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.white);
        Dimension size= Toolkit.getDefaultToolkit().getScreenSize();
         int width = (int)size.getWidth();
         int k=(width-45);
        int height = (int)size.getHeight();
        g.drawRect(20, 10, (width-45),(height-790));
        g.fillRect(20, 10, (width-45), (height-790));
        g.drawRect(20, 90,(width-44), (height-150));
         g.setColor(Color.black);
        g.fillRect(20, 90,(width-45), (height-150));
        snaketitle.paintIcon(this, g, 600, 10);
        
            if(moves==0){
                 snakexlength[0]=100;
                 snakexlength[1]=75;
                 snakexlength[2]=50;
                 
                  snakeylength[0]=100;
                 snakeylength[1]=100;
                 snakeylength[2]=100;
                
            }
            if(left ){
                leftmouth.paintIcon(this,g,snakexlength[0],snakeylength[0]);
            }
            if(right ){
                rightmouth.paintIcon(this,g,snakexlength[0],snakeylength[0]);
            }
            if(up ){
                upmouth.paintIcon(this,g,snakexlength[0],snakeylength[0]);
            }
            if(down ){
                downmouth.paintIcon(this,g,snakexlength[0],snakeylength[0]);
            }
            for(int i=1;i<lengthOfSnake;i++){
            snakeimage.paintIcon(this,g,snakexlength[i],snakeylength[i]);

            }
            enemy.paintIcon(this, g, z, q);
            if(gameover){
                gameover2.paintIcon(this, g,110,100);
                g.setColor(Color.red);
                g.setFont(new Font("Italic",Font.BOLD,40));
                g.drawString("dubara SAPERA banne ke liye space dabaye",300,(height-80));
            }
            g.setColor(Color.black);
            g.setFont(new Font("Bold",Font.PLAIN,20));
            g.drawString("score :"+score,(width-150),50);
            g.dispose();
        }
    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i=lengthOfSnake-1;i>0;i--){
            snakexlength[i]=snakexlength[i-1];
            snakeylength[i]=snakeylength[i-1];
        }
        
        if(left){
            snakexlength[0]=snakexlength[0]-25;
        }
        if(right){
            snakexlength[0]=snakexlength[0]+25;
        }
        if(up){
            snakeylength[0]=snakeylength[0]-25;
        }
        if(down){
            snakeylength[0]=snakeylength[0]+25;
        }
        if(snakexlength[0]>(width-45))
        {snakexlength[0]=20;}
        if(snakexlength[0]<20){
            snakexlength[0]=(width-45);}

            if(snakeylength[0]>(height-90))
        {snakeylength[0]=90;}
        if(snakeylength[0]<90){
            snakeylength[0]=(height-90);}
            collition();
            bodycollition();
        repaint();
       }

   

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_SPACE){
            restart();
        }
        if (e.getKeyCode()==KeyEvent.VK_LEFT && (!right)){
             left=true;
              right=false;
              up=false;
              down=false;
               moves++;
        }
        if (e.getKeyCode()==KeyEvent.VK_RIGHT && (!left)){
             left=false;
              right=true;
              up=false;
              down=false;
               moves++;
        }
         if (e.getKeyCode()==KeyEvent.VK_UP && (!down)){
             left=false;
              right=false;
              up=true;
              down=false;
               moves++;
        }
        if (e.getKeyCode()==KeyEvent.VK_DOWN && (!up)){
             left=false;
              right=false;
              up=false;
              down=true;
               moves++;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
         if (e.getKeyCode()==KeyEvent.VK_LEFT && (!right)){
             left=true;
              right=false;
              up=false;
              down=false;
               moves++;
        }
        if (e.getKeyCode()==KeyEvent.VK_RIGHT && (!left)){
             left=false;
              right=true;
              up=false;
              down=false;
               moves++;
        }
         if (e.getKeyCode()==KeyEvent.VK_UP && (!down)){
             left=false;
              right=false;
              up=true;
              down=false;
               moves++;
        }
        if (e.getKeyCode()==KeyEvent.VK_DOWN && (!up)){
             left=false;
              right=false;
              up=false;
              down=true;
               moves++;
        }
    }
    

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode()==KeyEvent.VK_LEFT && (!right)){
             left=true;
              right=false;
              up=false;
              down=false;
               moves++;
        }
        if (e.getKeyCode()==KeyEvent.VK_RIGHT && (!left)){
             left=false;
              right=true;
              up=false;
              down=false;
               moves++;
        }
         if (e.getKeyCode()==KeyEvent.VK_UP && (!down)){
             left=false;
              right=false;
              up=true;
              down=false;
               moves++;
        }
        if (e.getKeyCode()==KeyEvent.VK_DOWN && (!up)){
             left=false;
              right=false;
              up=false;
              down=true;
               moves++;
        }
    }
 private void newenemy(){
           int minValue1 = 50;
           int maxValue1= (width-44);
           int minValue2 = 100;
           int maxValue2= (height-150);
           int numberOfPossibleValues1 = ((maxValue1 - minValue1) / 25) + 1;
           int numberOfPossibleValues2 = ((maxValue2 - minValue2) / 25) + 1;
           Random random = new Random();
           int randomIndex1 = random.nextInt(numberOfPossibleValues1);
           int randomIndex2 = random.nextInt(numberOfPossibleValues2);
            z = minValue1 + (randomIndex1 * 25);
            q = minValue2 + (randomIndex2 * 25);

          System.out.println("index q= "+q+" index z=" +z);
          for (int i=lengthOfSnake-1;i>=0;i--){
             if(snakexlength[0]==z && snakeylength[0]==q){
                newenemy();
             }
          }

   }
    private void collition() {
        if(snakexlength[0]==z && snakeylength[0]==q)
        {
           newenemy();
           lengthOfSnake++;
           score++;
           String score1=score+"";
        }
    }
     private void bodycollition() {
        for (int i=lengthOfSnake-1;i>0;i--){
            if(snakexlength[i]==snakexlength[0]&&snakeylength[i]==snakeylength[0])
            {
                timer.stop();
                gameover= true;
            }
    }
 }
 private void restart(){
    gameover=false;
    score=0;
    moves=0;
    lengthOfSnake=3;
     left=false;
     right=true;
     up=false;
     down=false;
     timer.start();
     repaint();
     newenemy();
 }
}

