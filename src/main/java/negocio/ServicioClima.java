package negocio;

import java.time.Instant;
import java.util.List;
import java.util.Map;

import clima.*;
import excepciones.ExcepcionServicioClima;
import proveedorclima.AccuWeatherAPI;
import proveedorclima.ProveedorClima;

public class ServicioClima implements InterfazServicioClima{

	  List<Clima> climas;
	  
	  List<Map<String, Object>> climasWeather;
	 
	  ProveedorClima proveedorClima;
	
	  public ServicioClima(ProveedorClima proveedorClima) {
		  
	        this.proveedorClima = proveedorClima;
	        
	    }
	
	  
	  public void agregarClimaDelProveedor() {
		  
		  ProveedorClima apiClima = new AccuWeatherAPI();
		  
		  List<Map<String, Object>> condicionesClimaticas = apiClima.getWeather( "Buenos Aires, Argentina" );  
			
			
			Clima nuevoClima = new Clima (condicionesClimaticas.get(0).get("Temperature"));
		  
			climas.add(nuevoClima);
	  }
	  
	  
	  @Override
	    public Clima getClima(Instant fecha) {

	        Clima climaFecha = this.buscarClimaFecha(fecha);

	         Clima nuevoClima = new Clima(null);
	        
	        if (climaFecha == null) {
	            try {
	            	
	                this.climasWeather = this.proveedorClima.getWeather("Buenos Aires, Argentina");
	            
	        	
	        		 nuevoClima = new Clima (climasWeather.get(0).get("Temperature"));
	        		 // return  nuevoClima; 
	            }
	            
	            catch (Exception ex) {
	                ex.printStackTrace();
	                throw new ExcepcionServicioClima("No se puedieron obtener los climas del " + fecha.toString());
	            }
	        }

	       
			return  nuevoClima;    //       this.buscarClimaFecha(fecha);  //
	    }
	  
	  
		
		  public Clima buscarClimaFecha(Instant fecha) {
		  
		  Clima climaFecha = null;
		  
		  if (this.climas != null) { climaFecha = this.climas .stream() .filter(clima
		  -> clima.esClimaFecha(fecha)).findFirst() .orElse(null); }
		  
		  return climaFecha; }
		 
	  
	  
	  
	
}
