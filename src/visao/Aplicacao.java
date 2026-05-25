package visao;

import modelo.Tabuleiro;

public class Aplicacao {

	public static void main(String[] args) {
		
		Tabuleiro tabuleiro = new Tabuleiro(5,5,3);
		
		new TabuleiroConsole(tabuleiro);
		
		tabuleiro.abrir(2, 1);
		tabuleiro.marcar(4, 4);
		tabuleiro.marcar(2, 5);
		
		System.out.println(tabuleiro);
	}
}
