import java.awt.BorderLayout;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class VentanaToH extends JFrame{
	private PanelToH pc;

	public VentanaToH() {
		super();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.pc=new PanelToH(this.getMaximumSize().width,this.getMaximumSize().height,5);//En el ultimo numero se define el numero de discos 1-10
		this.add(pc,BorderLayout.CENTER);
		this.pack();
		this.setVisible(true);
		pc.base=new Base((int) (this.getWidth()*.1), (int) (this.getHeight()*.15), this.getWidth(), this.getHeight());
	}

	public static void main(String[] args) {
		@SuppressWarnings("unused")
		VentanaToH v=new VentanaToH();
	}
}
