package visao;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

import excecao.ExplosaoException;
import excecao.SairException;
import modelo.Tabuleiro;

public class TabuleiroConsole {

	private Tabuleiro tabuleiro;
	private Scanner in = new Scanner(System.in);
	
	public TabuleiroConsole(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;
		
		executarJogo();
	}

	private void executarJogo() {
		try {
			boolean continuar = true;
			
			while(continuar) {
				cicloDoJogo();
				
				
				System.out.println("Outra partida? (S/n)");
				String entrada = in.nextLine();
				
				if("n".equalsIgnoreCase(entrada)) {
					continuar = false;
				} else {
					tabuleiro.reiniciarJogo();	
				}
			}
			
		} catch (SairException e) {
			System.out.println("Você Saiu!");
		} finally {
			in.close();
		}
		
	}

	private void cicloDoJogo() {
		try {
			
			while(!tabuleiro.objetivoAlcancado()) {
				System.out.println(tabuleiro);
				
				String digitado = capturarValor("Digite (x,y): ");
				
				Iterator<Integer> xy = Arrays.stream(digitado.split(",")
						).map(e -> Integer.parseInt(e.trim())).iterator();
				
				digitado = capturarValor("1 - Abrir ou 2- (Des)Marcar: ");
				
				if("1".equalsIgnoreCase(digitado)) {
					tabuleiro.abrir(xy.next(), xy.next());
				} else if("2".equalsIgnoreCase(digitado)) {
					tabuleiro.marcar(xy.next(), xy.next());			
				}
				
			}
			System.out.println(tabuleiro);
			System.out.println("Você ganhou!");
		} catch (ExplosaoException e) {
			System.out.println(tabuleiro);
			System.out.println("Você perdeu!");
		}
	}
	
	private String capturarValor(String texto) {
		System.out.print(texto);
		String digitado = in.nextLine();
		
		if("sair".equalsIgnoreCase(digitado)) {
			throw new SairException();
		}
		
		return digitado;
	}
	
		
	
}
