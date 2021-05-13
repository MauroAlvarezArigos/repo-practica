package isi.died.parcial01.ejercicio01;

import java.time.LocalDate;

public class EnConvenio extends Empleado {
	private Integer antiguedad;
	private Double sueldoBasico;
	
	
	//Constructor
	public EnConvenio(String nombre, Integer cuil, LocalDate fechaNacimiento, String email, Integer antiguedad,Double sueldoBasico) {
		super(nombre, cuil, fechaNacimiento, email);
		this.antiguedad = antiguedad;
		this.sueldoBasico = sueldoBasico;
	}

	//Getters and Setters
	public Integer getAntiguedad() {
		return antiguedad;
	}
	public void setAntiguedad(Integer antiguedad) {
		this.antiguedad = antiguedad;
	}
	public Double getSueldoBasico() {
		return sueldoBasico;
	}
	public void setSueldoBasico(Double sueldoBasico) {
		this.sueldoBasico = sueldoBasico;
	}
	
	
	//Methods
	public Double calcularSueldo() {
		//Cobra el básico más el 30% total de cada venta en la que participo. 
		//A este monto total se le descuenta el 11% de jubilacion y el 3% de obra social.
		
		Double comision = ventas
						  .stream()
						  .map(v -> v.getMontoTotal()*0.3)
						  .mapToDouble(Double::doubleValue)
						  .sum();
		LocalDate hoy = LocalDate.now();
		
		return this.getFechaNacimiento().getMonthValue() == hoy.getMonthValue()?
				((comision + sueldoBasico) - (comision + sueldoBasico)*0.14) + 0.5*(comision + sueldoBasico) - (comision + sueldoBasico)*0.14
				:(comision + sueldoBasico) - (comision + sueldoBasico)*0.14;
		
		
	}
	
	
	
}
