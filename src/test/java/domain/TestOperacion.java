package domain;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;


public class TestOperacion{

	private Operacion op;
	
	@Before
	public void init() {
		this.op = new Operacion();
		this.op.agregarItem(new Articulo("articulo1",1200));
		this.op.agregarItem(new Articulo("articulo2",1400));
	}
	
	@Test
	public void testCalculoValorDeOperacion() {
		Assert.assertEquals(2600.0,this.op.costoTotal(),1.00);
	}
	
	@Test 
	public void testCalculoValorDeOperacionPostAgregadoDeElemento() {
		this.op.agregarItem(new Servicio("servicio1",2000));
		Assert.assertEquals(4600.0,this.op.costoTotal(),1.00);
		
	}
	
	@Test
    public void testAgregadoDeItemEstandoOperacionCerrada(){
		this.op.cerrarOperacion();
		this.op.agregarItem(new Servicio("servicio1",1000));
		Assert.assertEquals(2,this.op.getItems().size(),1.00);
		
	}
	
	@Test
	public void testCambioDePrecioEstandoOperacionCerrada() {
		this.op.cerrarOperacion();
		this.op.modificarCostoDeItem(0, 1000);
		Assert.assertEquals(2600,this.op.costoTotal(),1.00);
		
	}
	
	@Test
	public void testPuedeGenerarRemito() {
		Assert.assertTrue(this.op.puedeGenerarRemito());
	}
	
	@Test
	public void testPuedeGenerarRemitoSiNoSonArticulos(){
		this.op.agregarItem(new Servicio("servicio1",1200));
		Assert.assertFalse(this.op.puedeGenerarRemito());
		
	}
	
	@Test
	public void modificarPrecioDeArticulo() {
		this.op.modificarCostoDeItem(0, 1000);
		Assert.assertEquals(2400,this.op.costoTotal(),1.00);
	}
	
	@Test
	public void modificarPrecioDeArticuloCerrandoOperacion() {
		this.op.cerrarOperacion();
		this.op.modificarCostoDeItem(0, 1000);
		Assert.assertEquals(2600,this.op.costoTotal(),1.00);
	}
}
