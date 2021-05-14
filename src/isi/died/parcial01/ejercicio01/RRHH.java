package isi.died.parcial01.ejercicio01;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RRHH {
	
	public List<Recibo> recibosSueldo(List<Empleado> empleados, Double objetivo){
		List<Recibo> r = new ArrayList<Recibo>();
		
		Recibo recibo = new Recibo();
		
		Integer i = 1;
		
		for(Empleado e: empleados){
			//Pide que se guarde el mes pero me parecio mas completo guardar la fecha 
			//en la que genero el recibo, es por eso que reescribi el toString() de Recibo
		
			recibo.setNumero(i);
			recibo.setMes(LocalDate.now());
			recibo.setEmpleado(e);			

			if(e instanceof EnConvenio) {
				recibo.setTotal(((EnConvenio) e).calcularSueldo());
			}
			else {
				recibo.setTotal(((Contratado) e).calcularSueldo(objetivo));			
			}
			
			r.add(recibo);
			i++;
		}
		
		return r;
	}

}
