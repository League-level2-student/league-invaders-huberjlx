import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Rocketship extends GameObject {
	int speed;
	int xVelocity = 0;
	int yVelocity = 0;
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;
	
	Rocketship(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed = 10;
		if (needImage) {
		    loadImage ("rocket.png");
		}
	}
	
	public void update() {
		super.update();
		if (x + width < LeagueInvaders.WIDTH && x > 0) {
			x += xVelocity;
		} else {
			if (x <= 0) {
				x = 1;
			} else {
				x = LeagueInvaders.WIDTH - width - 1;
			}
		}
		if (y + height + 30 < LeagueInvaders.HEIGHT && y > 0) {
			y += yVelocity;
		} else {
			if (y <= 0) {
				y = 1;
			} else {
				y = LeagueInvaders.HEIGHT - height - 31;
			}
		}
	}
	
	public void draw(Graphics g) {
		if (gotImage) {
			g.drawImage(image, x, y, width, height, null);
		} else {
			g.setColor(Color.BLUE);
			g.fillRect(x, y, width, height);
		}
	}
	
	public Projectile getProjectile() {
        return new Projectile(x+width/2, y, 10, 10);
	} 
	
	public void right() {
		if (x + width < LeagueInvaders.WIDTH) {
			xVelocity = speed;
		}
	}
	
	public void left() {
		if (x > 0) {
			xVelocity = -speed;
		}
	}
	
	public void up() {
		if (y > 0) {
			yVelocity = -speed;
		}
	}
	
	public void down() {
		if (y + height + 30 < LeagueInvaders.HEIGHT) {
			yVelocity = speed;
		}
	}
	void loadImage(String imageFile) {
	    if (needImage) {
	        try {
	            image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
		    gotImage = true;
	        } catch (Exception e) {
	            
	        }
	        needImage = false;
	    }
	}
}
