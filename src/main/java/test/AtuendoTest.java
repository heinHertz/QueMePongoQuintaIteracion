package test;

import atuendo.Atuendo;
//import prenda.Categoria;
import prenda.*;

import org.junit.Test;

//import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;
import java.util.List;


public class AtuendoTest {

//	Categoria categoria = new Categoria
	
    TipoPrenda tipoRemera = new TipoPrenda( Categoria.SUPERIOR , 15 );
    TipoPrenda tipoCalzado = new TipoPrenda( Categoria.CALZADO ,15 );


    @Test
    public void testTipoPrendaEnAtuendo(){

    	   Prenda sueter = new Prenda( tipoRemera, Material.LANA, Color.AMARILLO, Color.ROJO ,  Trama.LISA );


    	   List<Prenda> prendas = new ArrayList<Prenda>();
    	    
    	    prendas.add(sueter);
    	    
    	    Atuendo atuendo  = new Atuendo();
        

             assertEquals(atuendo.esPrendasValidas(prendas) , true);

    }

   @Test
    public void testTipoPrendaNoValida(){

	   
	
        Prenda sueter = new Prenda( tipoRemera, Material.LANA, Color.AMARILLO, Color.ROJO,Trama.LISA);
        Prenda chomba = new Prenda( tipoRemera, Material.LANA, Color.AMARILLO, Color.ROJO ,Trama.LISA);

        
     	 List<Prenda> prendas = new ArrayList<Prenda>();
	   
        Atuendo atuendo = new Atuendo(   ); 
    	    
  	    prendas.add(sueter);
        prendas.add(chomba);
        
        assertEquals(atuendo.esPrendasValidas(prendas) , false);

    }

   @Test (expected = RuntimeException.class)
    public void testAtuendoSaltaExceptionPorCategoriaRepetida() {

        Atuendo atuendo = new Atuendo();

        Prenda sueter = new Prenda( tipoRemera, Material.LANA, Color.AMARILLO, Color.ROJO, Trama.LISA );
        Prenda zapatos = new Prenda( tipoCalzado,  Material.PLASTICO, Color.NEGRO, null , null   );

        atuendo.agregarPrenda(sueter);

        atuendo.agregarPrenda(zapatos);

    }

    @Test(expected = RuntimeException.class)
    public void testCalzadoDeberiaFallar(){

        Atuendo atuendo = new Atuendo();

        Prenda calzado = new Prenda( tipoRemera,  Material.PLASTICO, Color.NEGRO, Color.BLANCO, null);

        atuendo.agregarPrenda(calzado);


    }

    @Test
    public void testA(){

        Atuendo atuendo = new Atuendo();

     //   TipoPrenda tipoAnteojos = new TipoPrenda( "anteojos", Categoria.ACCESORIOS );
       // TipoPrenda tipoPantalon = new TipoPrenda( "pantalon", Categoria.INFERIOR );
        
        
        TipoPrenda tipoAnteojos = new TipoPrenda( Categoria.ACCESORIOS , 15 );
        TipoPrenda tipoPantalon = new TipoPrenda( Categoria.INFERIOR ,15 );


        Prenda sueter = new Prenda( tipoRemera,  Material.LANA, Color.AMARILLO, Color.ROJO, null);
        Prenda zapatillas = new Prenda( tipoCalzado,  Material.LANA, Color.AMARILLO, Color.ROJO ,null );
        Prenda anteojos = new Prenda( tipoAnteojos,  Material.PLASTICO, Color.NEGRO, Color.NEGRO, null);
        Prenda pantalon = new Prenda( tipoPantalon, Material.LANA, Color.NEGRO, Color.MARRON , null);

        atuendo.agregarPrenda(sueter);
        atuendo.agregarPrenda(zapatillas);
        atuendo.agregarPrenda(anteojos);
        atuendo.agregarPrenda(pantalon);

        assertEquals(  atuendo.esAtuendoConTodasLasCategorias(), true);

    }



}