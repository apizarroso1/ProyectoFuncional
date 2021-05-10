package bibliotecaReche;
import java.util.ArrayList;

public class Libreria {
	private ArrayList <Libro> librosAlta;
	private ArrayList <Libro> librosBaja;
	private ArrayList <Materia> materias;
	private ArrayList <Lector> lectores;
	private ArrayList <Lector> lectoresBaja;
	private ArrayList <Prestamo> prestamos;
	
	

	public Libreria () {
		
		this.librosAlta = new ArrayList <Libro> ();
		this.librosBaja = new ArrayList <Libro> ();
		this.materias = new ArrayList <Materia> ();
		this.lectores = new ArrayList <Lector> ();
		this.lectoresBaja = new ArrayList <Lector> ();
		this.prestamos = new ArrayList <Prestamo> ();
	}




	
	public ArrayList<Prestamo> getPrestamos() {
		return prestamos;
	}

	public void setPrestamos(ArrayList<Prestamo> prestamos) {
		this.prestamos = prestamos;
	}

	public ArrayList<Lector> getLectores() {
		return lectores;
	}

	public void setLectores(ArrayList<Lector> lectores) {
		this.lectores = lectores;
	}
	
	public ArrayList<Libro> getLibrosAlta() {
		return librosAlta;
	}

	public void setLibrosAlta(ArrayList<Libro> librosAlta) {
		this.librosAlta = librosAlta;
	}

	public ArrayList<Libro> getLibrosBaja() {
		return librosBaja;
	}

	public void setLibrosBaja(ArrayList<Libro> librosBaja) {
		this.librosBaja = librosBaja;
	}

	public ArrayList<Materia> getMaterias() {
		return materias;
	}

	public void setMaterias(ArrayList<Materia> materias) {
		this.materias = materias;
	}
	 

	public void listarLibros () {
		for (Libro libro : librosAlta) {
			libro.mostrarDatos();
		}
	}

	public boolean existeLibro (Libro a) {
	
		return this.librosAlta.contains(a);
	}
	

	public boolean existeLibroBajas(Libro a) {
		
		return this.librosBaja.contains(a);
	} 
	

	public boolean altaLibro (Libro a) {
		
		return librosAlta.add(a);
	}
	

	public boolean bajaLibro (Libro a) {
		Libro nuevo;
		boolean exito = false;
		if (existeLibro(a)) {
			for (int i = 0; i < librosAlta.size(); i++) {
				if (librosAlta.get(i).equals(a)) {
					nuevo = new Libro (librosAlta.get(i));
					librosBaja.add(nuevo);
					exito = true;
				}
			}
			
			librosAlta.remove(a);
		}
		
		return exito;
	}
	

	public boolean anularBajaLibro (Libro a) {
		Libro nuevo;
		boolean exito = false;
		if (existeLibroBajas(a)) {
			for (int i = 0; i < librosBaja.size(); i++) {
				if (librosBaja.get(i).equals(a)) {
					nuevo = new Libro (librosBaja.get(i));
					librosAlta.add(nuevo);
					exito = true;
				}
			}
			
			librosBaja.remove(a);
		}
		
		return exito;
	}

	public boolean actualizarLibro (Libro a) {
		boolean exito = false;
		int pos = librosAlta.indexOf(a);
		if(pos >=0) {
			librosAlta.set(pos, a);
			exito = true;
		}
					
		return exito;
	}
	

	public boolean compactarRegistro () {
		
		this.librosBaja.clear();
		return librosBaja.isEmpty();
		
	}
	

	public void mostrarMaterias() {
		for (Materia m : materias) {
			m.mostrarDatos();
		}
	}
	

	public boolean existeMateria (Materia m) {
		
		return materias.contains(m);
	}
	
	
	public boolean altaMateria (Materia m) {
		boolean exito = false;
		if (!existeMateria(m)) {
			exito = materias.add(m);
		}
		return exito;
	}
	
	

	public boolean bajaMateria (Materia m) {
		boolean exito = false;
		if (existeMateria(m)) {
			exito = materias.remove(m);
		}
		
		for (int i = 0; i < librosAlta.size(); i++) {
			if(librosAlta.get(i).getMaterias().contains(m)) {
				librosAlta.get(i).getMaterias().remove(m);
			}
		}
		
		for (int i = 0; i < librosBaja.size(); i++) {
			if(librosBaja.get(i).getMaterias().contains(m)) {
				librosBaja.get(i).getMaterias().remove(m);
			}
		}
		return exito;
	}
	

		public boolean existeLector (Lector m) {
			
			return lectores.contains(m);
		}
		

			
		public boolean existeLectorBaja (Lector m) {
					
			return lectoresBaja.contains(m);
		}
		

		public boolean altaLector (Lector m) {
			boolean exito = false;
			if (!existeLector(m)) {
				exito = lectores.add(m);
			}
			return exito;
		}
		

		public void listarLectores () {
			for (Lector lector : lectores) {
				lector.mostrarDatos();
			}
		}
		

		public boolean bajaLector (Lector a) {
			Lector nuevo;
			boolean exito = false;
			if (existeLector(a)) {
				for (int i = 0; i < lectores.size(); i++) {
					if (lectores.get(i).equals(a)) {
						nuevo = new Lector (lectores.get(i));
						lectoresBaja.add(nuevo);
						exito = true;
					}
				}
				
				lectores.remove(a);
			}
			
			return exito;
		}
		

		public boolean anularBajaLector (Lector a) {
			Lector nuevo;
			boolean exito = false;
			if (existeLectorBaja(a)) {
				for (int i = 0; i < lectoresBaja.size(); i++) {
					if (lectoresBaja.get(i).equals(a)) {
						nuevo = new Lector (lectoresBaja.get(i));
						lectores.add(nuevo);
						exito = true;
					}
				}
				
				lectoresBaja.remove(a);
			}
			
			return exito;
		}
	

		public boolean actualizarLector (Lector a) {
			boolean exito = false;
			int pos = lectores.indexOf(a);
			if(pos >=0) {
				lectores.set(pos, a);
				exito = true;
			}
						
			return exito;
		}
		

		public boolean compactarRegistroLector () {
			
			this.lectoresBaja.clear();
			return lectoresBaja.isEmpty();
			
		}
		

		public void buscarLectores (String nombre) {
			
			for (int i = 0; i < lectores.size(); i++) {
				if (lectores.get(i).getNombre().equals(nombre)) {
						lectores.get(i).mostrarDatos();
				}
			}
		}
		

		public boolean existeLibroPrestado ( Libro l) {
			boolean exito = false;
			 for (int i = 0; i < prestamos.size (); i++) {
				
				 if (prestamos.get(i).getLibro().equals(l)) {
					 exito = true;
				 }
			}
			return exito;
		}
		
		

		public boolean existeLectorConPrestamo ( Lector l) {
			boolean exito = false;
			 for (int i = 0; i < prestamos.size (); i++) {
				
				 if (prestamos.get(i).getLector().equals(l)) {
					 exito = true;
				 }
			}
			return exito;
		}
		

	public boolean anotarPrestamo (Libro l, Lector t) {
	
		boolean exito = false;
		
		if (existeLibro(l)) {
			if (existeLector(t)) {
				if (!existeLibroPrestado(l)) {
					if (!existeLectorConPrestamo(t)) {
						
						Prestamo p = new Prestamo (l, t);
						prestamos.add(p);
						exito =true;
					}
				}
			}
		}
		
		
		return exito;
		
	}
		 

	public boolean anotarDevolucion (Libro l, Lector t) {
		
		boolean exito = false;
		
		if (existeLibro(l)) {
			if (existeLector(t)) {
				if (existeLibroPrestado(l)) {
					if (existeLectorConPrestamo(t)) {
						
						Prestamo p = new Prestamo (l, t);
						
						prestamos.remove(p);
						
						exito =true;
					}
				}
			}
		}
		
		return exito;
		
	}
	

	public void listarPrestamos () {
		for (Prestamo prestamo : prestamos) { 
			prestamo.mostrarDatos();
		}
	}
	

	public void PrestamosLector( Lector t) {
		
					if (existeLectorConPrestamo(t)) {
						
						Prestamo p = new Prestamo (t);
						
						for (int i = 0; i < prestamos.size (); i++) {
							
							if (prestamos.get(i).equals(p)) {
								
								prestamos.get(i).mostrarDatos();
								
					}
				}
			}
		}
		

	public void buscarAutor (String autor) {
		
		for (int i = 0; i < librosAlta.size(); i++) {
			
			if (librosAlta.get(i).getAutor().equals(autor)) {
				librosAlta.get(i).mostrarDatos();
			}
		}
	}
	

	public void buscarTitulo (String titulo) {
		
		for (int i = 0; i < librosAlta.size(); i++) {
			
			if (librosAlta.get(i).getAutor().equals(titulo)) {
				librosAlta.get(i).mostrarDatos();
			}
		}
	}
	
	

	public void buscarMaterial (Materia m ) {
		
		for (int i = 0; i < librosAlta.size(); i++) {
			for (int j = 0; j < librosAlta.get(i).getMaterias().size(); j++) {
				if (librosAlta.get(i).getMaterias().get(j).equals(m)) {
					librosAlta.get(i).mostrarDatos();
				}
			}
		}
}
}
