import java.awt.Color;
import java.awt.Graphics;

public class Disco implements Comparable<Disco> {
	private Color color;
	private int size,
				xPos,
				yPos;
	private int height = 40;
	private int width;
	
	public Color getColor() {
		return color;
	}


	public void setColor(Color color) {
		this.color = color;
	}


	public int getSize() {
		return size;
	}


	public void setSize(int size) {
		this.size = size;
	}
	
	public void setPos(int x,int y) {
		this.xPos = x;
		this.yPos = y;
	}
	
	public int getX() {
		return this.xPos;
	}
	
	public int getY() {
		return this.yPos;
	}
	

	public int getWidth() {
		return width;
	}


	public void setWidth(int width) {
		this.width = width;
	}
	
	public int getHeight() {
		return height;
	}


	public void setHeight(int height) {
		this.height = height;
	}


	
	public Disco(int size) {
		this.setSize(size);
		this.color = paleta(size);
		this.setWidth(this.size*38+120);
	}

	public Color paleta(int size){
		int r = 0,
			g = 0,
			b = 0;
		switch (size) {
		case -1://hole
			r = 128;
			g = 128;
			b = 128;
			break;
		case 1://Red
			r = 255;
			break;
		case 2://Orange
			r = 255;
			g = 119;
			break;
		case 3://Yellow
			r = 255;
			g = 255;
			break;
		case 4://Green
			r = 119;
			g = 255;
			break;
		case 5://Aqua
			g = 255;
			b = 185;
			break;
		case 6://LightBlue
			g = 255;
			b = 255;
			break;
		case 7://Blue
			b = 255;
			break;
		case 8://Purple
			r = 185;
			b = 255;
			break;
		case 9://Pink
			r = 255;
			b = 255;
			break;
		default:
			break;
		}
		return new Color(r,g,b);
	}
	
	@Override
	public int compareTo(Disco disco) {
		if (this.getSize()>disco.getSize()) {
			return 1;
		} else {
			return -1;
		}
	}
	
	public boolean isBigger(Disco disco) {
		return this.compareTo(disco)>1?true:false;
	}
	
	public void pintaFigura(Graphics g) {
		g.setColor(this.getColor());
		if(this.size==-1) {//hole
			g.fillRect(this.xPos, this.yPos, 100, this.height-15);
			g.fillOval(this.xPos, this.yPos + 15, 100, 20);
		} else {
			g.fillRect(this.xPos, this.yPos + (this.height/2), this.getWidth(), this.height);
			g.fillOval(this.xPos, this.yPos + this.height, this.getWidth(), this.height);
			g.setColor(getColor().darker());
			g.fillOval(this.xPos, this.yPos, this.getWidth(), this.height);
		}
	}
}
