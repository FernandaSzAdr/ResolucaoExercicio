package questao01;

import java.util.Scanner;

public class quest {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		Formatacao f1 = new Formatacao();
		Formatacao f2 = new Formatacao();
		String entrada1, entrada2;
		
		System.out.println("1- Implemente um programa que receba como entrada 2 strings(A e B)\n "
				+ "representando permuta��es de 5 n�meros em nota��o de ciclo \n"
				+ "(ex: (153)(24)), e retorne o resultado da opera��o \n"
				+ "de composi��o AB e BA, e indique se a mesma � comutativa ou n�o.\n\n");
		
//		System.out.println("Informe o primeiro grupo (ex: (2543)(1)): ");
//		entrada1 = entrada.nextLine();
		f1.separarString("(3)(2154)");

//		System.out.println("Informe o segundo grupo (ex: (21)(345)): ");
//		entrada2 = entrada.nextLine();
		f2.separarString("(1)(234)(5)");
		
		System.out.println("Comuta��o de G1 e G2: \n[1, 2, 3, 4, 5]" + "\n" + f1.composicao(f2));
		//System.out.println("\nComuta��o de G2 e G1: \n[1, 2, 3, 4, 5]" + "\n" + f2.composicao(f1));
		
		System.out.println("\nS�o comutativos? \n" + f1.comparar(f2));
	}
}
