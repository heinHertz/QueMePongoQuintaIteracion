package atuendo;

import prenda.*;

import java.util.ArrayList;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import excepciones.*;

public class Atuendo {

    List<Prenda> prendas = new ArrayList<Prenda>();
    
   
    public Atuendo(List<Prenda> prendas) {
    	
        if(this.esPrendasValidas(prendas)) throw new ExcepcionAtuendo("Prendas no puede estar vacío");
        this.prendas = prendas;
    }
    
    public Atuendo() {};  
    

    public void agregarPrenda( Prenda prendaNueva){

    	prendas.add( Objects.requireNonNull(prendaNueva, "prenda no debe ser nula") );

    }

    public List<Prenda> getPrendas() {   return prendas;    }
    
    
    public boolean esPrendasValidas(List<Prenda> prendas) {
    	
        return prendas == null || prendas.isEmpty() || !tieneTodasLasCategorias(prendas);
      }
    
    
    public boolean esAtuendoAptoTemperatura(int temperatura) {
    	
    return	this.prendas.stream().allMatch( p -> p.esAdecuadaTemperaturaPrenda(temperatura) == true );
    	
    
    
    }
    
    
    public boolean esAtuendoConTodasLasCategorias() {
    	
    	return tieneTodasLasCategorias( this.prendas );
    }

    
    private boolean tieneTodasLasCategorias(List<Prenda> prendas) {
    	
        Map<Categoria, List<Prenda>> prendasPorCategoria = prendas.stream().collect(Collectors.groupingBy(Prenda::getCategoriaDePrenda));

        return prendasPorCategoria.containsKey(Categoria.SUPERIOR)
            && prendasPorCategoria.containsKey(Categoria.INFERIOR)
            && prendasPorCategoria.containsKey(Categoria.CALZADO)
            && prendasPorCategoria.containsKey(Categoria.ACCESORIOS);
    }
    
    
    
    



}
