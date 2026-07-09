package main;
import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Game");

        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);

        window.pack(); //sets window to preferred size of its subcomponents, in this case the game panel

        window.setLocationRelativeTo(null);
        window.setVisible(true);

        gamePanel.startGameThread();

        
    }
}