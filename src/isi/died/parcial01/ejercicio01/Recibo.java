package isi.died.parcial01.ejercicio01;

import java.time.LocalDate;

public class Recibo {
	Integer numero;
	LocalDate mes;
	Double total;
	Empleado empleado;
	
	//Constructor
	public Recibo() {
		super();
		this.numero = null;
		this.mes = null;
		this.total = null;
		this.empleado = null;
	}
	
	public Recibo(Integer numero, LocalDate mes, Double total, Empleado empleado) {
		super();
		this.numero = numero;
		this.mes = mes;
		this.total = total;
		this.empleado = empleado;
	}
	
	//Getters and Setters
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public LocalDate getMes() {
		return mes;
	}
	public void setMes(LocalDate mes) {
		this.mes = mes;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public Empleado getEmpleado() {
		return empleado;
	}
	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	@Override
	public String toString() {
		return "Recibo [numero=" + numero + ", mes=" + mes + ", total=" + total + ", empleado=" + empleado.getNombre() + "]";
	}
	
	
	
	
}	
