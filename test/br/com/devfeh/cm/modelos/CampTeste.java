package br.com.devfeh.cm.modelos;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import excecao.ExplosaoException;
import modelo.Campo;

public class CampTeste {

	private Campo campo;
	
	@BeforeEach
	void iniciarCampo() {
		campo = new Campo(3, 3);
	}
	
	@Test	
	void testeVizinhoRealDistancia1() {
		Campo vizinho = new Campo(2, 4);
		
		boolean resultado = campo.adicionarVizinho(vizinho);	
		
		assertTrue(resultado);
		
	}
	
	@Test
	void testeVizinhoRealDistancia2() {
		Campo vizinho = new Campo(1, 4);
		
		boolean resultado = campo.adicionarVizinho(vizinho);	
		
		assertFalse(resultado);
		
	}
	
	@Test
	void testeVizinhoRealDistancia3() {
		Campo vizinho = new Campo(2, 5);
		
		boolean resultado = campo.adicionarVizinho(vizinho);	
		
		assertFalse(resultado);
		
	}
	
	@Test
	void testeVizinhoRealDistancia4() {
		Campo vizinho = new Campo(4, 4);
		
		boolean resultado = campo.adicionarVizinho(vizinho);	
		
		assertTrue(resultado);
		
	}
	
	@Test
	void testeAlternarMarcador() {
		campo.alternarMarcacao();
		assertTrue(campo.isMarcado());
	}
	
	@Test
	void testeMarcado() {
		assertFalse(campo.isMarcado());
	}
	
	@Test
	void testeAlternarMarcadorDuasChamada() {
		campo.alternarMarcacao();
		campo.alternarMarcacao();
		assertFalse(campo.isMarcado());
	}
	
	@Test
	void abrirNaoMinadoNaoMarcado() {
		
		assertTrue(campo.abrir());
	}
	
	@Test
	void abrirNaoMinadoestaMarcado() {
		campo.alternarMarcacao();
		assertFalse(campo.abrir());
	}
	
	@Test
	void abrirMinadoeMarcado() {
		campo.alternarMarcacao();
		campo.minar();
		assertFalse(campo.abrir());
	}
	
	@Test
	void abrirMinadoeNaoMarcado() {
		campo.minar();
		
		assertThrows(ExplosaoException.class, () -> {
			campo.abrir();
		});
	}
}	
