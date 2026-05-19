package modelo;

import java.util.ArrayList;
import java.util.List;

public class Campo {
	
	
	private int linha;
	private int coluna;
	
	private boolean minado = false;
	private boolean aberto = false;
	private boolean marcado = false;
	
	private List<Campo> vizinhos = new ArrayList<>();
		
	public Campo(int linha, int coluna ){
		this.linha = linha;
		this.coluna = coluna;
		
	}


	public boolean adicionarVizinho(Campo vizinho) {
		boolean linhaDiferente = this.linha != vizinho.linha;
		boolean colunaDiferente = this.coluna != vizinho.coluna;
		boolean diagonal = linhaDiferente && colunaDiferente;
		
		int deltaLinha = Math.abs(this.linha - vizinho.linha);
		int deltaColuna = Math.abs(this.coluna - vizinho.coluna);
		int deltaGeral = deltaColuna + deltaLinha;
				
		if(deltaGeral == 1 && !diagonal) {
			vizinhos.add(vizinho);
			return true;	
		} else if(deltaGeral == 2 && diagonal) {
			vizinhos.add(vizinho);
			return true;
		} else {
			return false;
		}
		
	}
}
