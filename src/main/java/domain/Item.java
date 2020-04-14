package domain;

public abstract class Item {
    private double costo;
	private String nombre;
	
	public Item(String nombre, int costo) {
		this.nombre = nombre;
		this.costo = costo;
	}
	

	public void setCosto(double costo) {
		this.costo = costo;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	public double getCosto() {
		return costo;
	}
	
	public String getNombre(){
		return nombre;
	}

    public abstract String tipoDeItem();
	
	public boolean esArticulo() {
		return this.tipoDeItem()=="articulo";
	}
	
	@Override
	public String toString() {
		return "Item [costo=" + costo + ", nombre=" + nombre + "]";
	}
	
	


}
