package br.com.devfeh.cm.modelos;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
}	
