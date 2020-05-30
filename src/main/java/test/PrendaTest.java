package test;


import prenda.Color;

import prenda.*;
import prenda.Categoria;
import prenda.TipoPrenda;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;


public class PrendaTest {


    TipoPrenda remera = new TipoPrenda( Categoria.SUPERIOR , 15 );
    TipoPrenda pantalon = new TipoPrenda( Categoria.INFERIOR ,15 );

   // public TipoPrenda remera = new TipoPrenda( "remera", Categoria.SUPERIOR );
   // public TipoPrenda pantalon = new TipoPrenda( "pantalon", Categoria.INFERIOR );

    //test que espera una exception
    @Test(expected = RuntimeException.class)
    public void testPrendaCategoriaNULL(){

    	
        Prenda pantalon1 = new Prenda( null,  Material.POLIESTER, Color.NEGRO, Color.BLANCO , null   );

    }

    @Test
    public void testPrendaColorSecundarioDiferentes(){

        Prenda pantalonAdidas = new Prenda( pantalon, Material.POLIESTER, Color.NEGRO, null , null  );

        pantalonAdidas.setColorSecundario(Color.BLANCO);

        assertEquals(  pantalonAdidas.getColorSecundario() , Color.BLANCO);
    }
    @Test
    public void testPrendaPerteneceACategoria(){

        Prenda pantalonAdidas = new Prenda( pantalon,  Material.POLIESTER, Color.NEGRO, null , null  );

        assertEquals( pantalonAdidas.prendaPerteneceACategoria(Categoria.INFERIOR) , true);

    }

    @Test
    public void testPrendaDistintosDeberiaFallar(){

        Prenda pantalonAdidas = new Prenda( pantalon,  Material.POLIESTER, Color.NEGRO,null , null  );

        assertNotEquals( pantalonAdidas.getColorPrimario(), Color.BLANCO);
    }

    //  TEST  QUE ESPERA UNA EXCEPTION POR FALLA DE COLOR PRIMARIO
    @Test(expected = RuntimeException.class)
    public void testPrendaColorPrincipalNullSaltaException(){

        Prenda pantalon1 = new Prenda( pantalon,  Material.POLIESTER, null,  null, null    );

    }

    @Test(expected = RuntimeException.class)
    public void testPrendaCategoriaNullSaltaException(){

        Prenda pantalonAdidas = new Prenda( null,  Material.POLIESTER , Color.NEGRO,  null  ,null  );

    }
    @Test(expected = RuntimeException.class)
    public void testPrendaMaterialNullSaltaException(){

        Prenda pantalonAdidas = new Prenda( pantalon, null, Color.NEGRO,  null , null   );

    }

    @Test(expected = RuntimeException.class)
    public void testPrendaTipoPrendaNullSaltaException(){

        Prenda pantalonAdidas = new Prenda( null,Material.POLIESTER, Color.NEGRO,  null , null   );

    }


}
