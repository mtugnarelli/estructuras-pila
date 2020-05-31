package estructuras;

import org.junit.Assert;
import org.junit.Test;

public class PruebaPilaSobreArreglos {

	@Test
	public void alCrearEstaVacia() {
		
		Pila<Integer> pila = new PilaSobreArreglos<Integer>(10);
		
		Assert.assertTrue(pila.estaVacia());
	}
	
	@Test
	public void apilarUnElemento() {
		
		Pila<String> pila = new PilaSobreArreglos<String>(10);
		
		pila.apilar("fisica");
		
		Assert.assertFalse(pila.estaVacia());
		Assert.assertEquals("fisica", pila.obtenerTope());
	}
	
	@Test
	public void apilarDosElementos() {
		
		Pila<String> pila = new PilaSobreArreglos<String>(10);
		
		pila.apilar("fisica");
		pila.apilar("quimica");
		
		Assert.assertFalse(pila.estaVacia());
		Assert.assertEquals("quimica", pila.obtenerTope());
	}
	
	@Test
	public void apilarDosElementosLuegoDesapilarUno() {
		
		Pila<String> pila = new PilaSobreArreglos<String>(5);
		
		pila.apilar("fisica");
		pila.apilar("quimica");
		String desapilado = pila.desapilar();
		
		Assert.assertFalse(pila.estaVacia());
		Assert.assertEquals("quimica", desapilado);
		Assert.assertEquals("fisica", pila.obtenerTope());
	}
	
	@Test
	public void apilarDosElementosLuegoDesapilarDos() {
		
		Pila<String> pila = new PilaSobreArreglos<String>(5);
		
		pila.apilar("fisica");
		pila.apilar("quimica");
		String primero = pila.desapilar();
		String segundo = pila.desapilar();
		
		Assert.assertTrue(pila.estaVacia());
		Assert.assertEquals("quimica", primero);
		Assert.assertEquals("fisica", segundo);
	}
	
	@Test(expected = NoExisteElElemento.class)
	public void lanzaExcepcionAlObtenerElTopeSiEstaVacia() {
		
		Pila<Object> pila = new PilaSobreArreglos<Object>(5);
		
		pila.obtenerTope();
	}

	@Test(expected = NoExisteElElemento.class)
	public void lanzaExcepcionAlDescapilarSiEstaVacia() {
		
		Pila<Object> pila = new PilaSobreArreglos<Object>(15);
		
		pila.desapilar();
	}
	
	@Test
	public void apilarDiezElementosConCapacidadInicialDeTres() {
		
		Pila<Integer> pila = new PilaSobreArreglos<Integer>(3);
		
		pila.apilar(1);
		pila.apilar(2);
		pila.apilar(3);
		pila.apilar(4);
		pila.apilar(5);
		pila.apilar(6);
		pila.apilar(7);
		pila.apilar(8);
		pila.apilar(9);
		pila.apilar(10);
		
		int diez = pila.desapilar();
		int nueve = pila.desapilar();
		int ocho = pila.desapilar();
		int siete = pila.desapilar();
		int seis = pila.desapilar();
		int cinco = pila.desapilar();
		int cuatro = pila.desapilar();
		int tres = pila.desapilar();
		int dos = pila.desapilar();
		int uno = pila.desapilar();
		
		Assert.assertTrue(pila.estaVacia());
		Assert.assertEquals(10, diez);
		Assert.assertEquals(9, nueve);
		Assert.assertEquals(8, ocho);
		Assert.assertEquals(7, siete);
		Assert.assertEquals(6, seis);
		Assert.assertEquals(5, cinco);
		Assert.assertEquals(4, cuatro);
		Assert.assertEquals(3, tres);
		Assert.assertEquals(2, dos);
		Assert.assertEquals(1, uno);
	}
	
	@Test
	public void apilarTresLuegoDesapilarDosLuegoApilarUnoLuegoDesapilaTodos() {
		
		Pila<String> pila = new PilaSobreArreglos<String>(2);
		
		pila.apilar("fisica");
		pila.apilar("quimica");
		pila.apilar("biologia");
		String primero = pila.desapilar();
		String segundo = pila.desapilar();
		pila.apilar("matematica");
		String tercero = pila.desapilar();
		String cuarto = pila.desapilar();
		
		Assert.assertTrue(pila.estaVacia());
		Assert.assertEquals("biologia", primero);
		Assert.assertEquals("quimica", segundo);
		Assert.assertEquals("matematica", tercero);
		Assert.assertEquals("fisica", cuarto);
	}


}
