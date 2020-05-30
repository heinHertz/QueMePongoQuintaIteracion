package test;

import org.junit.Test;

import prenda.*;

public class testBorrador {
	
	
	
	@Test
	public void testBorrador1() {
		
		TipoPrenda tipoPrenda = new TipoPrenda(Categoria.SUPERIOR);
		
		Borrador borrador = new Borrador(tipoPrenda);
		
		
		borrador.especificarColorPrimariol(Color.AMARILLO);
		
		borrador.especificarMaterial(Material.PLASTICO);

		borrador.setColorSecundario(Color.AZUL);
		
		
		
		
		
	}
	
	
	
	
	
	

}
