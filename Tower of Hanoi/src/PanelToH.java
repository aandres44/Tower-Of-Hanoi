import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PanelToH extends JPanel implements MouseListener{
	private int size;
	private String movimientos;
	public Base base;
	public MyStack<Disco> pilaTmp,
				   pila,
				   pila2,
				   pila3;
	public Disco tapa;
	

	public PanelToH(int width,int height,int size) {
		super();
		this.setPreferredSize(getMaximumSize());
		this.size = size;
		pilaTmp=new MyStack<Disco>();
		pila=new MyStack<Disco>();
		pila2=new MyStack<Disco>();
		pila3=new MyStack<Disco>();
		for (int i = 1;i <= size;i++) {
			pilaTmp.push(new Disco(i));
		}
		tapa=new Disco(-1);
		TowerOfHanoi.move(this.size);
		this.movimientos = TowerOfHanoi.getMovimientos();
//		System.out.println(this.movimientos);
		
		this.addMouseListener(this);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		base.pintaFigura(g);
		int j = 0;
		if(!this.pilaTmp.isEmpty()) {//para crear la primer pila solo en el inicio del programa
			for (int i = this.pilaTmp.size();i > 0;i--) {
				this.pila.push(this.pilaTmp.pop());
				this.pila.top().setPos((170 - ((this.pila.top().getWidth()-150)/2)), (int) (1102*.7 - 50 - j*this.pila.top().getHeight()) );//200+ pila.top().getSize()*45
				this.pila.top().pintaFigura(g);
				j++;
			}
			this.tapa.setPos(this.pila.top().getX() + (this.pila.top().getWidth())/2 - 51, this.pila.top().getY() - 10);
			this.tapa.pintaFigura(g);	
		} else {//proceso de resolucion
			for (int i = this.pila.size();i > 0;i--) {
				this.pilaTmp.push(this.pila.pop());
			}
			for (int i = this.pilaTmp.size();i > 0;i--) {
				this.pila.push(this.pilaTmp.pop());
				this.pila.top().setPos((170 - ((this.pila.top().getWidth()-150)/2)), (int) (1102*.7 - 50 - j*this.pila.top().getHeight()) );//200+ pila.top().getSize()*45
				this.pila.top().pintaFigura(g);
				j++;
			}
			if(!this.pila.isEmpty()) {
				this.tapa.setPos(this.pila.top().getX() + (this.pila.top().getWidth())/2 - 51, this.pila.top().getY() - 10);
				this.tapa.pintaFigura(g);
			}
			j = 0;
			for (int i = this.pila2.size();i > 0;i--) {
				this.pilaTmp.push(this.pila2.pop());
			}
			for (int i = this.pilaTmp.size();i > 0;i--) {
				this.pila2.push(this.pilaTmp.pop());
				this.pila2.top().setPos((893 - ((this.pila2.top().getWidth()-150)/2)), (int) (1102*.7 - 50 - j*this.pila2.top().getHeight()) );//200+ pila.top().getSize()*45
				this.pila2.top().pintaFigura(g);
				j++;
			}
			if(!this.pila2.isEmpty()) {
				this.tapa.setPos(this.pila2.top().getX() + (this.pila2.top().getWidth())/2 - 48, this.pila2.top().getY() - 10);
				this.tapa.pintaFigura(g);
			}
			j = 0;
			for (int i = this.pila3.size();i > 0;i--) {
				this.pilaTmp.push(this.pila3.pop());
			}
			for (int i = this.pilaTmp.size();i > 0;i--) {
				this.pila3.push(this.pilaTmp.pop());
				this.pila3.top().setPos((1625 - ((this.pila3.top().getWidth()-150)/2)), (int) (1102*.7 - 50 - j*this.pila3.top().getHeight()) );//200+ pila.top().getSize()*45
				this.pila3.top().pintaFigura(g);
				j++;
			}
			if(!this.pila3.isEmpty()) {
				this.tapa.setPos(this.pila3.top().getX() + (this.pila3.top().getWidth())/2 - 53, this.pila3.top().getY() - 10);
				this.tapa.pintaFigura(g);
			}
		}
		
		
	}
	
	public void nextMove() {
		switch (this.movimientos.substring(0, 2)) {
		case "AB":this.pila2.push(this.pila.pop());
			break;
		case "AC":this.pila3.push(this.pila.pop());
			break;
		case "BA":this.pila.push(this.pila2.pop());
			break;
		case "BC":this.pila3.push(this.pila2.pop());
			break;
		case "CA":this.pila.push(this.pila3.pop());
			break;
		case "CB":this.pila2.push(this.pila3.pop());
			break;
		default:System.out.println("ERROR");
			break;
		}
		this.movimientos = this.movimientos.substring(2);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(!this.pila.isEmpty() || !this.pila2.isEmpty()) {
			nextMove();
			this.paintImmediately(0, 0, 1924, 1102);
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
