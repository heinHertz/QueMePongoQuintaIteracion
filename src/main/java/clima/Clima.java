package clima;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;

public class Clima {
	
	int temperatura;
	
	Instant fecha;
	
	
	  HashMap<String, Object>  climas = new HashMap<String, Object>();
	
	
	public Clima(   Object  object    ) {
		
		
		this.climas = (HashMap<String, Object>) object;
		
		
	}
	
	public int getTemperatura() {
		
		return (int) this.climas.get("Value");
		
	}
	
	
    public boolean esClimaFecha(Instant fecha) {
        return fecha.equals(this.fecha) || this.noSuperaHora(fecha);
    }

    private boolean noSuperaHora(Instant fecha) {
        return fecha.isAfter(this.fecha) && ChronoUnit.HOURS.between(this.fecha, fecha) == 0;
    }
	
    
    public int temperaturaDeClima() {
    	
    	return this.temperatura;
        	
    }

	public void setTemperatura(int temperatura) {
		this.temperatura = temperatura;
	}

	public void setFecha(Instant fecha) {
		this.fecha = fecha;
	}

    
    
}
