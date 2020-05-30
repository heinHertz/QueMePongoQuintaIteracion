package negocio;

import java.time.Instant;

import clima.Clima;



public interface InterfazServicioClima {
	
	 Clima getClima(Instant fecha);
	
		

}
