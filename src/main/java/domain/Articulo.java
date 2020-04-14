package domain;

public class Articulo extends Item {
   

	private final String tipoDeItem = "articulo";
	
	 public Articulo(String nombre, int costo) {
			super(nombre, costo);
			
	}
		
	 @Override
	 public String tipoDeItem() {
		   return tipoDeItem;
	 }
     
	
}
