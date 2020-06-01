package estructuras;

import org.junit.Assert;
import org.junit.Test;

public class PruebaPilaSobreListaEnlazada {

	@Test
	public void alCrearEstaVacia() {
		
		Pila<Integer> pila = new PilaSobreListaEnlazada<Integer>();
		
		Assert.assertTrue(pila.estaVacia());
	}
	
	@Test
	public void apilarUnElemento() {
		
		Pila<String> pila = new PilaSobreListaEnlazada<String>();
		
		pila.apilar("fisica");
		
		Assert.assertFalse(pila.estaVacia());
		Assert.assertEquals("fisica", pila.obtenerTope());
	}
	
	@Test
	public void apilarDosElementos() {
		
		Pila<String> pila = new PilaSobreListaEnlazada<String>();
		
		pila.apilar("fisica");
		pila.apilar("quimica");
		
		Assert.assertFalse(pila.estaVacia());
		Assert.assertEquals("quimica", pila.obtenerTope());
	}
	
	@Test
	public void apilarDosElementosLuegoDesapilarUno() {
		
		Pila<String> pila = new PilaSobreListaEnlazada<String>();
		
		pila.apilar("fisica");
		pila.apilar("quimica");
		String desapilado = pila.desapilar();
		
		Assert.assertFalse(pila.estaVacia());
		Assert.assertEquals("quimica", desapilado);
		Assert.assertEquals("fisica", pila.obtenerTope());
	}
	
	@Test
	public void apilarDosElementosLuegoDesapilarDos() {
		
		Pila<String> pila = new PilaSobreListaEnlazada<String>();
		
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
		
		Pila<Object> pila = new PilaSobreListaEnlazada<Object>();
		
		pila.obtenerTope();
	}

	@Test(expected = NoExisteElElemento.class)
	public void lanzaExcepcionAlDescapilarSiEstaVacia() {
		
		Pila<Object> pila = new PilaSobreListaEnlazada<Object>();
		
		pila.desapilar();
	}
	
	@Test
	public void apilarTresLuegoDesapilarDosLuegoApilarUnoLuegoDesapilaTodos() {
		
		Pila<String> pila = new PilaSobreListaEnlazada<String>();
		
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
