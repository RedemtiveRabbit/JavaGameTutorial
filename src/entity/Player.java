package entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import main.GamePanel;
import main.KeyHandler;

public class Player extends Entity{
    
    GamePanel gp;
    KeyHandler keyH;

    public Player(GamePanel gp, KeyHandler keyH) {

        this.gp = gp;
        this.keyH = keyH;

        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues() {

        x = 100;
        y = 100;
        speed = 2;
        direction = "down";
    }

    public void getPlayerImage() {

        try {

            up1 = ImageIO.read(getClass().getResourceAsStream("/player/KnightUp1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/player/KnightUp2.png"));
            up3 = ImageIO.read(getClass().getResourceAsStream("/player/KnightUp3.png"));
            up4 = ImageIO.read(getClass().getResourceAsStream("/player/KnightUp4.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/player/KnightDown1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/player/KnightDown2.png"));
            down3 = ImageIO.read(getClass().getResourceAsStream("/player/KnightDown3.png"));
            down4 = ImageIO.read(getClass().getResourceAsStream("/player/KnightDown4.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/player/KnightLeft1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/player/KnightLeft2.png"));
            left3 = ImageIO.read(getClass().getResourceAsStream("/player/KnightLeft3.png"));
            left4 = ImageIO.read(getClass().getResourceAsStream("/player/KnightLeft4.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/player/KnightRight1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/player/KnightRight2.png"));
            right3 = ImageIO.read(getClass().getResourceAsStream("/player/KnightRight3.png"));
            right4 = ImageIO.read(getClass().getResourceAsStream("/player/KnightRight4.png"));
            

            
        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public void update() {

        double moveSpeed = speed;

        if((keyH.downPressed == true || keyH.upPressed == true) && (keyH.leftPressed == true || keyH.rightPressed == true)) {

            moveSpeed = moveSpeed / Math.sqrt(2);
        }

        if(keyH.upPressed == true) {

            direction = "up";
            y -= moveSpeed;
        }
        if(keyH.downPressed == true) {

            direction = "down";
            y += moveSpeed;
        }
        if(keyH.leftPressed == true) {

            direction = "left";
            x -= moveSpeed;
        }
        if(keyH.rightPressed == true) {

            direction = "right";
            x += moveSpeed;
        }

        if((keyH.upPressed == true || keyH.downPressed == true || keyH.leftPressed == true || keyH.rightPressed == true) && spriteCounter > 10) {
            if(spriteNum >= 4) {
                spriteNum = 1;
            }
            else {
                spriteNum++;
            }
            spriteCounter = 0;
        }
        spriteCounter++;

        if(!(keyH.upPressed == true || keyH.downPressed == true || keyH.leftPressed == true || keyH.rightPressed == true)) {
            spriteNum = 1;
        }
        

    }
    public void draw(Graphics2D g2) {

        BufferedImage image = null;

        switch(direction) {
            case "up":
                switch(spriteNum) {
                    case 1:
                        image = up1;
                        break;
                    case 2:
                        image = up2;
                        break;
                    case 3:
                        image = up3;
                        break;
                    case 4:
                        image = up4;
                        break;
                }
                break;
            case "down":
                switch(spriteNum) {
                    case 1:
                        image = down1;
                        break;
                    case 2:
                        image = down2;
                        break;
                    case 3:
                        image = down3;
                        break;
                    case 4:
                        image = down4;
                        break;
                }
                break;
            case "left":
                switch(spriteNum) {
                    case 1:
                        image = left1;
                        break;
                    case 2:
                        image = left2;
                        break;
                    case 3:
                        image = left3;
                        break;
                    case 4:
                        image = left4;
                        break;
                }
                break;
            case "right":
                switch(spriteNum) {
                    case 1:
                        image = right1;
                        break;
                    case 2:
                        image = right2;
                        break;
                    case 3:
                        image = right3;
                        break;
                    case 4:
                        image = right4;
                        break;
                }
                break;
        }
        g2.drawImage(image, (int)x, (int)y, gp.tileSize, gp.tileSize, null);
        
    }
}
