package isi.died.parcial01.ejercicio01;

import java.time.LocalDate;

public class Venta {
	private Integer nroVenta;
	private LocalDate fecha;
	private Double montoTotal;
	private Double objetivo;
	
	//Constructor
	public Venta(Integer nroVenta, LocalDate fecha, Double montoTotal) {
		super();
		this.nroVenta = nroVenta;
		this.fecha = fecha;
		this.montoTotal = montoTotal;
	}	
	
	//Getters and Setters
	public Integer getNroVenta() {
		return nroVenta;
	}
	public void setNroVenta(Integer nroVenta) {
		this.nroVenta = nroVenta;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public Double getMontoTotal() {
		return montoTotal;
	}
	public void setMontoTotal(Double montoTotal) {
		this.montoTotal = montoTotal;
	}
	
	
}
