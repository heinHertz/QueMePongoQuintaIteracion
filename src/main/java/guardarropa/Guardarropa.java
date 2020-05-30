package guardarropa;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import atuendo.*;
import prenda.*;

import excepciones.*;

public class Guardarropa {
	
	 List<Atuendo> atuendos = new ArrayList<Atuendo>();

	 List<Prenda> prendas;
	 
	 
	 
	 @Inject
	    public Guardarropa ( List<Prenda> prendas ) {
	        //this.combinadorPrendas = combinadorPrendas;
	      //  this.tipo = tipoGuardarropa;
	        this.prendas = prendas; // new ArrayList<>();
	    }
	 
	 
	 
	 
	
public Stream<Atuendo> sugerenciasAptasTemperatura (List<Prenda> prendas ,   int temperatura   ) {
		
	if(!tieneTodasLasCategorias( prendas))throw new ExcepcionGuardarropa("Debe tener todas las categorias");
	
		
	return  atuendos.stream().filter( a -> a.esAtuendoAptoTemperatura(temperatura) == true  );		
			 
			 
	}
	





public void setPrendas(List<Atuendo> atuendos ){
	
	this.atuendos = atuendos;
}

	
	

private boolean tieneTodasLasCategorias(List<Prenda> prendas) {
	
	
    Map<Categoria, List<Prenda>> prendasPorCategoria = prendas.stream().collect(Collectors.groupingBy(Prenda::getCategoriaDePrenda));

    return prendasPorCategoria.containsKey(Categoria.SUPERIOR)
        && prendasPorCategoria.containsKey(Categoria.INFERIOR)
        && prendasPorCategoria.containsKey(Categoria.CALZADO)
        && prendasPorCategoria.containsKey(Categoria.ACCESORIOS);
}


}
