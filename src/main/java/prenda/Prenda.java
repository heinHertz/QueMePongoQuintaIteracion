package prenda;


import java.util.Objects;

public class Prenda {

    TipoPrenda tipoPrenda;



    Material material;

    Color colorPrimario;

    Color colorSecundario;
    
    Trama trama = Trama.LISA;
    
    
// la temperatura va en tipo prenda
    
    public Prenda( TipoPrenda tipoPrenda, Material material, Color colorPrimario,Color colorSecundario, Trama trama){

    	this.tipoPrenda = tipoPrenda; Objects.requireNonNull(tipoPrenda, "tipoPrenda es obligatorio");		
    	
    	this.material = Objects.requireNonNull(material, "material es obligatorio");	
    			  
    	this.colorPrimario = Objects.requireNonNull(colorPrimario, "colorPrimario es obligatorio");
    	
    	this.colorSecundario = colorSecundario;
    	
    	this.trama = trama; 
        

    }

    
    public boolean esAdecuadaTemperaturaPrenda(int temperatura) {
    	
    	return this.tipoPrenda.getTemperaturaAdecuada() < temperatura   ;
    	
    }
    
    
    
    public void setTipoPrenda(TipoPrenda tipoPrenda ) {    	    	
  	  this.tipoPrenda = Objects.requireNonNull(tipoPrenda, "tipoPrenda es obligatorio");
     }

    
    public void setMaterial(Material material ) {
    	this.material = Objects.requireNonNull(material, "material no debe ser nulo");
    }

    

    public void setColorPrimario(Color colorPrimario) {
    	this.colorPrimario = Objects.requireNonNull(colorPrimario, "color es obligatorio");
    }

    
    public void setColorSecundario(Color colorSecundario) {
    	this.colorSecundario = Objects.requireNonNull(colorSecundario, "color es obligatorio no nulo");
    }

   

    public Color getColorPrimario() {
        return this.colorPrimario;
    }

    public TipoPrenda getTipoPrenda() {
		return tipoPrenda;
	}



    public Categoria getCategoriaDePrenda() {
		return tipoPrenda.getCategoria();
	}


	public Color getColorSecundario() {
        return colorSecundario;
    }

	
	public boolean prendaPerteneceACategoria(Categoria categoria){
		
		return this.getCategoriaDePrenda().equals(categoria);
	}

    // ESTO SIRVE SI AL COMPARAR DOS OBJETOS PRENDA , SON IGUALES SI TIENEN LAS MISMAS ATRIBUTOS CON LOS MISMOS VALORES
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Prenda)) return false;
        Prenda prenda = (Prenda) o;
        return  tipoPrenda.equals(prenda.tipoPrenda) &&
                colorPrimario.equals(prenda.colorPrimario) &&
                Objects.equals(colorSecundario, prenda.colorSecundario) &&
                material == prenda.material;
    	}


}



