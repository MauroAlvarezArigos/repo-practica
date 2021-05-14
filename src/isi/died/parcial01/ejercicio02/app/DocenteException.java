package isi.died.parcial01.ejercicio02.app;

public class DocenteException extends Exception {
	
	public DocenteException() {
		super("El docente no pertenece a la materia la cual queres inscribirte");
	}
	
}
