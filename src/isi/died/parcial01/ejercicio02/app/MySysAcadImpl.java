package isi.died.parcial01.ejercicio02.app;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;

import isi.died.parcial01.ejercicio02.db.BaseDeDatos;
import isi.died.parcial01.ejercicio02.db.BaseDeDatosExcepcion;
import isi.died.parcial01.ejercicio02.dominio.*;
import isi.died.parcial01.ejercicio02.dominio.Inscripcion.Estado;


public class MySysAcadImpl implements MySysAcad {
	private static final BaseDeDatos DB = new BaseDeDatos();


	private List<Materia> materia = new ArrayList<Materia>();
	
	public void registrarNota(Examen unExamen, Integer unaNota) {
		unExamen.setNota(unaNota);
		if(unaNota > 6) {
			//Incompleto
			for(Inscripcion i: unExamen.getMateria().getInscripciones()) {	
				if(i.getInscripto() == unExamen.getAlumno()) {
					i.setEstado(Estado.PROMOCIONADO);
				}
			}
		}
	}
	
	@Override
	public void registrarMateria(Materia d) {
		this.materia.add(d);
	}
	
	private List<Docente> docentes = new ArrayList<Docente>();
	
	@Override
	public void registrarDocente(Docente d) {
		this.docentes.add(d);
	}
	
	private List<Alumno> alumnos = new ArrayList<Alumno>();
	
	@Override
	public void registrarAlumnos(Alumno d) {
		this.alumnos.add(d);
	}
	

	@Override
	public void inscribirAlumnoCursada(Docente d, Alumno a, Materia m, Integer cicloLectivo) throws BaseDeDatosExcepcion, DocenteException{
		Inscripcion insc = new Inscripcion(cicloLectivo,Inscripcion.Estado.CURSANDO);
		
		if(m.getDocentes().contains(d))	{
			d.agregarInscripcion(insc);
		}
		else throw new DocenteException();
		
		a.addCursada(insc);
		m.addInscripcion(insc);
		// DESCOMENTAR Y gestionar excepcion
		try{
			DB.guardar(insc);
		}
		catch (BaseDeDatosExcepcion e) {
			throw new BaseDeDatosExcepcion();
		}
	}

	@Override
	public void inscribirAlumnoExamen(Docente d, Alumno a, Materia m) {
		Examen e = new Examen();
		a.addExamen(e);
		d.agregarExamen(e);
		m.addExamen(e);
		// DESCOMENTAR Y gestionar excepcion
		// DB.guardar(e);
	}

	@Override
	public List<Examen> topNExamenes(Materia m, Integer n) {
		
		return null;
	}
	
	public Integer cantidadAplazos(Alumno a) {
		return (int) a.getExamenes().stream().filter(e -> e.getNota()<6).count();
	}
	

}
