import java.util.NoSuchElementException;

public class MyStack<E> {
	private MiListaEnlazada<E> lista;//relacion tiene un

	
	public MyStack() {
		this.lista=new MiListaEnlazada<>();
	}
	
	public void push(E dato) {
		this.lista.insertarInicio(dato);
	}

	public E pop() {
		try {
			return this.lista.borrarInicio();
		} catch(IndexOutOfBoundsException e) {
			throw new NoSuchElementException("No se puede hacer pop de un stack vacio");
		}
	}
	
	public E top() {
		try {
			return this.lista.inicio();
		} catch(IndexOutOfBoundsException e) {
			throw new NoSuchElementException("No se puede hacer top de un stack vacio");
		}
	}
	
	public int size() {
		return this.lista.size();
	}
	
	public boolean isEmpty() {
		return this.lista.estaVacia();
	}
	
	public String toString() {
		return this.lista.toString();
	}
	public static void main(String[] args) {
		MyStack<Integer> pila=new MyStack<>();
		for (int i = 0; i < 5; i++) {
			pila.push(i);
		}
		System.out.println(pila.top());
	}
}
