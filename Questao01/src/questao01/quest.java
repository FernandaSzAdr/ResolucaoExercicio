package questao01;

import java.util.Scanner;

public class quest {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		Formatacao f1 = new Formatacao();
		Formatacao f2 = new Formatacao();
		String entrada1, entrada2;
		
//		System.out.println("Informe o primeiro grupo (ex: (2543)(1)): ");
//		entrada1 = entrada.nextLine();
		f1.separarString("(32)(154)");
//		System.out.println("Informe o segundo grupo (ex: (21)(345)): ");
//		entrada2 = entrada.nextLine();
		f2.separarString("(154)(32)");
		
		System.out.println("Comutação de G1 e G2: \n[1, 2, 3, 4, 5]" + "\n" + f1.composicao(f2));
		System.out.println("\nComutação de G2 e G1: \n[1, 2, 3, 4, 5]" + "\n" + f2.composicao(f1));
		
		System.out.println("\nSão comutativos? \n" + f1.comparar(f2));
	}
}
