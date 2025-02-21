import java.awt.*;

import javax.swing.JFrame;
class snake_game{
    public static void main(String[] args) {
        JFrame frame=new JFrame("snake game");
        Dimension size= Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int)size.getWidth();
        int height = (int)size.getHeight();
        frame.setBounds(00,00,width,height);
        frame.setResizable(true);
         game_panel panel=new game_panel();
       frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true); 
       
       panel.setBackground(Color.darkGray);
    }
}