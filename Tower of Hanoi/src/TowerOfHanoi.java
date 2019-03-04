
public class TowerOfHanoi {
	private static String movimientos = "";
	
	public static String getMovimientos() {
		return movimientos;
	}

	public static void setMovimientos(String movimientos) {
		TowerOfHanoi.movimientos = movimientos;
	}
	
	public static void move(int disks, char from, char to, char using) {
		if(disks==1) {
//			System.out.println("Moviendo el disco " + disks + " desde " + from + " hasta " + to);
			setMovimientos(getMovimientos() + from + to);
		} else {
			move(disks - 1, from, using, to);
//			System.out.println("Moviendo el disco " + disks + " desde " + from + " hasta " + to);
			setMovimientos(getMovimientos() + from + to);
			move(disks - 1, using, to, from);
		}
	}
	
	public static void move(int disks) {
		move(disks, 'A', 'C', 'B');
	}
	
//	public static void main(String[] args) {
//		TowerOfHanoi toh=new TowerOfHanoi();
//		move(3);
//	}

	
}
