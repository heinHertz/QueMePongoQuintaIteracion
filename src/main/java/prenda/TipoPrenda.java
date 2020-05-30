package prenda;

import java.util.Objects;

//import utiles.CategoriaException;

public class TipoPrenda {

	
	
	
    Categoria categoria;
    
    int temperaturaAdecuada=0;


    public TipoPrenda( Categoria categoria, int temperaturaAdecuada){

    	this.setCategoria(categoria);
    	
    	this.temperaturaAdecuada = temperaturaAdecuada;
   
    }

    public Categoria getCategoria() {
        return categoria;
    }
    
    
   

    public int getTemperaturaAdecuada() {
		return temperaturaAdecuada;
	}

	public void setCategoria(Categoria categoria) {
     
        this.categoria = Objects.requireNonNull(categoria, "no debe Ingresar Categoria Nula");
    }





}
