package usuario;

import java.sql.Date;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import atuendo.Atuendo;
import guardarropa.Guardarropa;
import negocio.InterfazServicioClima;
import negocio.ServicioClima;
import proveedorclima.AccuWeatherAPI;
import proveedorclima.ProveedorClima;

public class Usuario {

	TipoUsuario tipoUsuario;
	
	 Guardarropa guardarropa; //= new ArrayList<>();
	
	 InterfazServicioClima interfazServicioClima;
	
	
	 
	
	
	 public Atuendo sugerenciaTemperaturaActual() {
		 
		 
		 return this.guardarropa.sugerenciasAptasTemperatura( this.temperaturaActual() ).collect(Collectors.toList()).get(0);     
		 
		 
		 
	 }



	 
	 public int temperaturaActual() {
		 
		 
		 AccuWeatherAPI proveedorClima = new AccuWeatherAPI();
		 
		 ServicioClima	  servicioClima = new ServicioClima(proveedorClima);
		 
		 Date fecha = new Date(0);
	
		 Instant instanteFecha = fecha.toInstant();
		 
		 
		 
	return servicioClima.buscarClimaFecha(  instanteFecha ).temperaturaDeClima();     // getClima(new Date()).
		 
		 
	 }


	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}


	public void setGuardarropa(Guardarropa guardarropa) {
		this.guardarropa = guardarropa;
	}


	public void setInterfazServicioClima(InterfazServicioClima interfazServicioClima) {
		this.interfazServicioClima = interfazServicioClima;
	}


	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}



	public Guardarropa getGuardarropa() {
		return guardarropa;
	}



	public InterfazServicioClima getInterfazServicioClima() {
		return interfazServicioClima;
	}
	
	
	 
	
}
