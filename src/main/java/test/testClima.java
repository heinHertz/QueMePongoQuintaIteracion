package test;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Map;

import org.junit.Test;

import clima.Clima;
import proveedorclima.AccuWeatherAPI;

public class testClima {

	@Test
	public void testInterfaceClima() {
		
		AccuWeatherAPI apiClima = new AccuWeatherAPI();
		
		List<Map<String, Object>> condicionesClimaticas = apiClima.getWeather( "Buenos Aires, Argentina" );  
		
				
		Clima nuevoClima = new Clima (condicionesClimaticas.get(0).get("Temperature"));
		
		
		assertEquals(	nuevoClima.getTemperatura() ,  57 ); 
		
		
	}
	
	
	
	//assertEquals(	condicionesClimaticas.get(0).get("PrecipitationProbability") ,  0 ); //Devuelve un número del 0 al 1
	
	
}
