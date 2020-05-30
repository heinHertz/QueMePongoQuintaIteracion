package test;

import prenda.*;
import prenda.Categoria;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ColorTest {

    TipoPrenda tipoInferior = new TipoPrenda( Categoria.INFERIOR , 15 );

    @Test
    public void colorSecundarioTest(){

        Prenda pantalon = new Prenda( tipoInferior, Material.POLIESTER, Color.NEGRO,Color.BLANCO ,null    );

        assertEquals( pantalon.getColorSecundario(), Color.BLANCO);

    }

    @Test
    public void colorSecundarioTest2(){

        Prenda pantalon = new Prenda( tipoInferior,  Material.POLIESTER, Color.NEGRO, null, null    );

        assertEquals( pantalon.getColorSecundario(), null);

    }

    // este Test espera una Excepcion de Tipo Runtime en caso de que no tenga color principal asignado salta la Exception

    @Test(expected = RuntimeException.class)

    public void tieneColorPrimarioiNull() throws RuntimeException {

        Prenda pantalon = new Prenda( tipoInferior, Material.POLIESTER, null, Color.BLANCO   , null );

        assertEquals( pantalon.getColorPrimario(), Color.AMARILLO);

    }

   @Test (expected = RuntimeException.class)
    public void colorSecundarioTest3(){

        Prenda pantalon = new Prenda( tipoInferior, Material.POLIESTER, Color.NEGRO, Color.BLANCO , null    );

        pantalon.setColorSecundario(Color.AMARILLO);

    }





}
