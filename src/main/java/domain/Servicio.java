package domain;

public class Servicio extends Item{
	
	private final String tipoDeItem = "servicio";
   
	public Servicio(String nombre, int costo){
		super(nombre, costo);
	}

	@Override
    public String tipoDeItem() {
	   return tipoDeItem;
    }

	
	
	
	
	
   
  


}
