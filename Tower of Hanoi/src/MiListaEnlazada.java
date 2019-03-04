import java.util.NoSuchElementException;

/*Andres Aguirre Alvarez
  A01228159
  MiListaEnlazada.java
*/
public class MiListaEnlazada<E> {
	private NodoLE<E> inicio,
					  fin;
	private int size;

	public MiListaEnlazada() {
		this.inicio=this.fin=null;
		this.size=0;
	}
	public MiListaEnlazada(E[] datos) {
		//Inicializa la lista con los elementos que tiene el arreglo
		this.inicio=this.fin=null;
		this.size=0;
		for (int i = 0; i < datos.length; i++) {
			insertarFin(datos[i]);
		}
	}
	public E inicio() {
		try{
			return this.inicio.getDato();
		} catch(NullPointerException e) {
			throw new NoSuchElementException("No se puede regresar ese elemento, esta vacia la lista");
		}
	}
	public E fin() {
		try {
			return this.fin.getDato();
		} catch(NullPointerException e) {
			throw new NoSuchElementException("No se puede regresar ese elemento, esta vacia la lista");
		}
	}
	public boolean estaVacia() {
		return this.size==0;//en lugar de if
	}
	public int size() {
		return this.size;
	}
	public void insertarInicio(E dato) {
		NodoLE<E> nuevo=new NodoLE<E>(dato,this.inicio);//guardar la referencia del nuevo nodo en el inicio
		this.inicio=nuevo;
		if (this.estaVacia()) {
			this.fin=nuevo;
		}
		this.size++;
	}
	public void insertarFin(E dato) {
		if(this.estaVacia()) {
			this.insertarInicio(dato);
		} else {
			NodoLE<E> nuevo=new NodoLE<E>(dato);//guardar la referencia del nuevo nodo en el fin
			this.fin.setNext(nuevo);
			this.fin=nuevo;
			this.size++;
		}
	}
	public void insertarEn(E dato,int pos) {
		if(pos<0 || pos-1>=size) {
			throw new IndexOutOfBoundsException("Invalid position: "+pos);
		} else if(this.estaVacia()||pos==0) {
			this.insertarInicio(dato);
		} else {
			NodoLE<E> tmp=new NodoLE<E>(inicio.getDato(),inicio.getNext());
			tmp=this.inicio;
			for (int i = 0; i < pos-1; i++) {
				tmp=tmp.getNext();
			}
			NodoLE<E> nuevo=new NodoLE<E>(dato,tmp.getNext());
			tmp.setNext(nuevo);
			this.size++;
		}
	}
	public E borrarInicio() {
		try {
			E res=this.inicio();
			this.inicio=this.inicio.getNext();
			this.size--;
			if(this.size==1) {
				this.fin=null;
			}
			return res;
		} catch(NullPointerException|NoSuchElementException e) {
			throw new IndexOutOfBoundsException("No se puede borrar el inicio de una lista vacia");
		}
	}
	public E borrarFin() {
		if(size>1) {
			E dato=this.fin();
			NodoLE<E> tmp=new NodoLE<E>(inicio.getDato(),inicio.getNext());
			for (int i = 0; i < this.size-2; i++) {
				tmp=tmp.getNext();
			}
			this.fin=tmp;
			this.fin.setDato(tmp.getDato());
			this.fin.setNext(null);
			this.size--;
			return dato;
		} else {
			try {//cambiar el mensaje de la excepcion
				return this.borrarInicio();
			} catch(IndexOutOfBoundsException e) {
				throw new IndexOutOfBoundsException("No se puede borrar el fin de una lista vacia");
			}
		}
	}
	public void flush() {
		this.inicio=this.fin=null;
		this.size=0;
	}
	public void borrarEn(int pos) {//corregir, arroga IOOBE
		if(!this.estaVacia()) {
			if(pos<0 || pos>size-1) {
				System.out.println("Invalid position: "+pos);
			} else if(pos==0) {
				borrarInicio();
			} else if(pos==size-1) {
				borrarFin();
			} else {
				NodoLE<E> tmp=new NodoLE<E>(inicio.getDato(),inicio.getNext());//inicio.getdato?
				tmp=this.inicio;
//				NodoLE<E> die=new NodoLE<E>(null);
				for (int i = 0; i < pos-1; i++) {
					tmp=tmp.getNext();
				}
//				die=tmp.getNext();
				tmp.setNext(tmp.getNext().getNext());
//				die=null;
				this.size--;
			}
		}
	}
	public E getEn(int pos) {
		if(pos<0 || pos>size-1 || this.estaVacia()) {
			throw new IndexOutOfBoundsException("Invalid position: "+pos);
		} else if(pos==this.size-1) {
			return this.fin();
		} else {
			NodoLE<E> tmp=new NodoLE<E>(inicio.getDato(),inicio.getNext());
			tmp=this.inicio;
			for (int i = 0; i < pos; i++) {
				tmp=tmp.getNext();
			}
			return tmp.getDato();
		}
	}
	public void setEn(E dato,int pos) {
		if(pos<0 || pos>size-1 || this.estaVacia()) {
			System.out.println("Invalid position: "+pos);
		} else {
			NodoLE<E> tmp=new NodoLE<E>(inicio.getDato(),inicio.getNext());
			tmp=this.inicio;
			for (int i = 0; i < pos; i++) {
				tmp=tmp.getNext();
			}
			tmp.setDato(dato);
		}
	}
	public String toString() {
		String res="";
		NodoLE<E> current=this.inicio;
		for (int i = 0; i < size; i++) {
			res+=current.getDato()+",";
			current=current.getNext();
		}
		return res;
	}
	public static void main(String[] args) {
		Integer[] x= {0,1,2,3,4};
		MiListaEnlazada<Integer> lista=new MiListaEnlazada<>(x);
		Integer a=new Integer(8);
		Integer b=new Integer(9);
		System.out.println(lista);
		lista.borrarEn(4);
		lista.insertarEn(a, 3);
		lista.setEn(b, 2);
		System.out.println(lista);
	}
}

class NodoLE<E> {
	private E dato;
	private NodoLE<E> next;
	public E getDato() {
		return dato;
	}
	public void setDato(E dato) {
		this.dato = dato;
	}
	public NodoLE<E> getNext() {
		return next;
	}
	public void setNext(NodoLE<E> next) {
		this.next = next;
	}
	public NodoLE(E dato) {
		this(dato,null);
	}
	public NodoLE(E dato, NodoLE<E> next) {
		super();
		this.dato = dato;
		this.next = next;
	}
	public String toString() {
		return this.dato+":"+this.next;
	}
}