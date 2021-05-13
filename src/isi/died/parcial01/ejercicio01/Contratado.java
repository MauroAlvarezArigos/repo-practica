package isi.died.parcial01.ejercicio01;

import java.time.LocalDate;

public class Contratado extends Empleado {
	private Integer horasTrabajoMes;
	private Double costoXHora;
	
	
	//Constructor
	public Contratado(String nombre, Integer cuil, LocalDate fechaNacimiento, String email, Integer horasTrabajoMes, Double costoXHora) {
		super(nombre, cuil, fechaNacimiento, email);
		this.horasTrabajoMes = horasTrabajoMes;
		this.costoXHora = costoXHora;
	}
	
	//Getters and Setters
	public Integer getHorasTrabajoMes() {
		return horasTrabajoMes;
	}
	public void setHorasTrabajoMes(Integer horasTrabajoMes) {
		this.horasTrabajoMes = horasTrabajoMes;
	}
	public Double getCostoXHora() {
		return costoXHora;
	}
	public void setCostoXHora(Double costoXHora) {
		this.costoXHora = costoXHora;
	}
	
	//Methods
	public Double calcularSueldo(Double objetivo) {
		Double base = horasTrabajoMes * costoXHora;
		Double totalVentas = ventas
							 .stream()
							 .map(v -> v.getMontoTotal())
							 .mapToDouble(Double::doubleValue)
							 .sum();
		
		Double ganancias = totalVentas>objetivo?ventas.size()*costoXHora*5 : 0;
		
		return LocalDate.now().getMonthValue() == this.getFechaNacimiento().getMonthValue()?
			   0.5*(base+ganancias)+ base + ganancias
			   :base + ganancias;
	}
	
	
}
