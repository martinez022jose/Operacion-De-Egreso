package domain;

import java.util.ArrayList;
import java.util.List;


public class Operacion{
	private double gastoTotalDeOperacion;
	private boolean operacionAbierta = true;
	
	private List<Item> ItemsOperacion = new ArrayList<Item>();
	
	public void modificarNombreDeItem(int posicion,String nuevoNombre) {
		if(this.operacionAbierta) {
		ItemsOperacion.get(posicion).setNombre(nuevoNombre);}
	}
	
	public void modificarCostoDeItem(int posicion,double costo) {
		if(this.operacionAbierta) {
		ItemsOperacion.get(posicion).setCosto(costo);}
	}
	
	public void eliminarItemEn(int posicion) {
		ItemsOperacion.remove(posicion);
	}
	
	public List<Item> getItems() {
		return ItemsOperacion;
	}
	
	public void setGastoTotal(double valor) {
		this.gastoTotalDeOperacion = valor;
	}
	
	public double getGastoTotal() {
		return gastoTotalDeOperacion;
	}
	
	public boolean getOperacionAbierta() {
		return operacionAbierta;
	}
	
	public void cerrarOperacion() {
		operacionAbierta = false;
		this.setGastoTotal(this.costoTotal());
		
	}
	
	public void agregarItem(Item elemento) {
		if(this.getOperacionAbierta()){
		ItemsOperacion.add(elemento);
		}
	}
	
	public double costoTotal() {
	   return ItemsOperacion.stream().mapToDouble(Item::getCosto).sum();
	}
	
	public boolean sonTodosArticulos(){
		return ItemsOperacion.stream().map(Item::tipoDeItem).allMatch(elemento -> elemento=="articulo");
	}
	
	public boolean puedeGenerarRemito() {
		return this.sonTodosArticulos();
	}
	
	public void generarRemito(){
		if(this.puedeGenerarRemito()) {
			for(int i=0;i<ItemsOperacion.size();i++) {
				System.out.println(ItemsOperacion.get(i));
			}
		}
		
	}
	

}
