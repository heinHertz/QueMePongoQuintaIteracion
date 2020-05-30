package proveedorclima;

import java.util.List;
import java.util.Map;

import proveedorclima.*;
import clima.*;

public interface ProveedorClima {
		
	List<Map<String, Object>> getWeather(String ciudad);
	

	
}
