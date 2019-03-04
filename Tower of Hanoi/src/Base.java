import java.awt.Color;
import java.awt.Graphics;

public class Base {
	private int xPos,
				yPos,
				width,//1924
				height;//1102

	public Base(int x,int y,int width,int height) {
		this.xPos = x;
		this.yPos = y;
		this.setSize(width, height);
	}
	
	public void setSize(int width,int height) {
		this.width = (int) (width*.8);
		this.height = (int) (height*.8);
	}
	
	public void pintaFigura(Graphics g) {
		g.setColor(new Color(100, 100, 100));
		g.fillRect(this.xPos, (int) (this.yPos + this.height*.7 - 10), this.width, (int) (this.height*.09));
		g.setColor(Color.DARK_GRAY);
		g.fillRect(this.xPos, (int) (this.yPos + this.height*.7), this.width, (int) (this.height*.09));//base
		
		g.setColor(Color.GRAY);
		g.fillOval(this.xPos, (int) (this.yPos + this.height*.7 + (this.height*.09) - 15), 100, 30);//parte inferior pilar
		g.fillRect(this.xPos, this.yPos, 100, (int) (this.height*.7 + this.height*.09));//pilar 1
		g.setColor(Color.DARK_GRAY);
		g.fillOval(this.xPos, this.yPos - 15, 100, 30);//parte superior pilar
		
		g.setColor(Color.GRAY);
		g.fillOval(this.xPos+this.width/2-50, (int) (this.yPos + this.height*.7 + (this.height*.09) - 15), 100, 30);//parte inferior pilar
		g.fillRect(this.xPos+this.width/2-50, this.yPos, 100, (int) (this.height*.7 + this.height*.09));//pilar 2
		g.setColor(Color.DARK_GRAY);
		g.fillOval(this.xPos+this.width/2-50, this.yPos - 15, 100, 30);//parte superior pilar
		
		g.setColor(Color.GRAY);
		g.fillOval(this.xPos+this.width-100, (int) (this.yPos + this.height*.7 + (this.height*.09) - 15), 100, 30);//parte inferior pilar
		g.fillRect(this.xPos+this.width-100, this.yPos, 100, (int) (this.height*.7 + this.height*.09));//pilar 3
		g.setColor(Color.DARK_GRAY);
		g.fillOval(this.xPos+this.width-100, this.yPos - 15, 100, 30);//parte superior pilar
	}
}
