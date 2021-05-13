package isi.died.parcial01.ejercicio01;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Empleado {
	private String nombre;
	private Integer cuil;
	private LocalDate fechaNacimiento;
	private String email;
	protected List<Venta> ventas;
	
	//Constructor
	public Empleado(String nombre, Integer cuil, LocalDate fechaNacimiento, String email) {
		super();
		this.nombre = nombre;
		this.cuil = cuil;
		this.fechaNacimiento = fechaNacimiento;
		this.email = email;
		this.ventas = new ArrayList<Venta>();
	}
	
	//Getters and Setters
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getCuil() {
		return cuil;
	}
	public void setCuil(Integer cuil) {
		this.cuil = cuil;
	}
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	//Methods
	public void agregarVenta(Venta unaVenta) {
		ventas.add(unaVenta);
	}
	
	
	
}
