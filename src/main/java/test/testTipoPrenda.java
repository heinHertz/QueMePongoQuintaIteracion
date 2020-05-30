package test;

import atuendo.Atuendo;
import prenda.*;
import prenda.Prenda;

import org.junit.Test;

public class testTipoPrenda {

    @Test
    public void testTipoPrendaNormal(){

        // quiero especificar qué tipo de prenda estoy cargando (zapatos, camisa de mangas cortas, pantalón, etc).
        // tipo zapatos, zapatillas, chancletas

        TipoPrenda remera = new TipoPrenda( Categoria.SUPERIOR, 15 );

        Prenda chomba = new Prenda( remera,  Material.POLIESTER, Color.FUCSIA , Color.AMARILLO ,  Trama.CONLUNARES   );


    }

    @Test(expected = RuntimeException.class)
    public void testTipoPrenda2CategoriasDiferentesDeberiaFallar(){


        TipoPrenda remera = new TipoPrenda( "remera", Categoria.SUPERIOR );

     
        Prenda chomba = new Prenda( remera,  Material.POLIESTER, Color.FUCSIA , Color.AMARILLO ,  Trama.CONLUNARES   );


    }


}
