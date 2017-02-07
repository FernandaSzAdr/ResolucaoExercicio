package questao01;

import java.util.ArrayList;

public class Formatacao {
	//Essa variavel vai conter os conteudos dentro das ()
	private ArrayList<Integer> lista, lista2, listaNova;
	//Essa variavel contem apenas os numeros dos grupo, sem os ()
	private String[] grupoS;
	//contador para ajudar os amiguinhos
	private int cont, cont2;
	//ainda n usei isso
	private boolean aberto;
	
	public Formatacao(){
		cont = 0;
		cont2 = 0;
		aberto = false;
		lista = new ArrayList<Integer>();
		lista2 = new ArrayList<Integer>();
		listaNova = new ArrayList<Integer>();
	}
	
	public void separarString (String grupo){
		//grupo = (234)(51) | grupoS = [ ,234, , ,51, ]
		// [\\W] remove qualquer caracter diferente de letra da string
		grupoS = grupo.split("[\\W]");
		// j � um vetor do tipo string com 4 espa�os
		String[] j = new String[4];
		
		// for percorrendo grupoS
		for(String i: grupoS){
			// se o tamanho de i for maior de vazio, no caso se ele nao for diferente de numero, entao:
			if(i.length() > 0){
				// cont++
				cont++;
				// i pode ser igual a 234, precisamos separar esses numeros
				// j = [2,3,4]
				j = i.split("");
				
				// for percorrendo o j
				for(String x: j){
					// x � uma string, queremos apenas adicionar numeros
					// converter string para numero � Integer.parseInt(x)
					// lista contem os numeros que foram informados, na sua devida ordem
					lista.add(Integer.parseInt(x));
					// cont2 est� contando a quantidade de numeros que exstem entre o come�o e o fim de ()
					cont2++;				
				}
				//lista2 contera [3,2]
				// estou adicionando quantos numeros existem dentro de cada subgrupo
				lista2.add(cont2);
				
				// reiniciar o cont2 para o proximo intervalo de numeros
				cont2 = 0;
			}
			
		}
	}
	
	
	public ArrayList<Integer> getLista(){
		return lista;
	}
	
	public ArrayList<Integer> getLista2(){
		return lista2;
	}
	
	// essa fun��o recebe um elemento e informa qual o proximo elemento vem a seguir dele
	public int buscarElemento(int elemento){
		int aux = 0;
		int aux2 = 0;
		// variavel que ira conter a posi��o do vetor lista2, ele ajuda a percorrer o lista
		int cont = 0;
		// variavel para o for
		int j = 0;
		int pt1 = 0;
		
		do{
			// lista2.get(aux) � igual a quantidade de numeros que existem dentro de cada intervalo
			// lista2 = [3, 2]
			for(j = 0; j < lista2.get(aux); j ++){
				// lembrando que a lista contem todos os numeros informados em sua devida ordem = [2,3,4,5,1]
				// pt1 ser� o numero na posi��o cont, no caso se estamos procurando o 3
				// j ser� igual a 1, cont ser� igual a 1 e 3 se encontra na posi��o 1 do lista
				// no entanto, se estamos querendo o numero 1, que est� no segundo conjunto (234)(51)
				// o primeiro for ter� acabado, aux ira acrescentar mais um, no caso, est� na posi��o 1 de lista2, q � igual a 2
				// j = 2, cont = 5 e 1 est� na posi��o 5 de lista
				pt1 = lista.get(cont);			
				
				if(pt1 == elemento){
					//chegou no fim da fila
					if(j+1 == lista2.get(aux)){
						//n�o � o primeiro conjunto de numeros
						if(aux2 > 0){
							//o elemento est� sozinho no mini conjunto, tipo (1) ou (5)
							if (lista2.get(aux) == 1) {
								//retorna esse mesmo elemento
								return elemento;
							//se o conjunto tiver dois elementos (23) 
							}else if (lista2.get(aux) == 2) {
								//retorna o primeiro elemento tipo em (23), ele retorna o 2
								return lista.get(aux2);
							
							}/*else if(cont == 4){
			
								return lista.get(aux2);
							}*/else {
								return lista.get(aux2);								
							}
						// � o primeiro conjunto de numeros
						}else{
							// retorna a primeira posi��o
							return lista.get(0);		
							// um else inutil 
						}
					}else{
						// se o numero se apos o primeiro conjunto de numeros
						if(aux2 > 0){
							return lista.get(cont+1);
						}else{
							return lista.get(j+1);							
						}
						// cont e j vao possuir o mesmo valor, esse else � unutil 
					}
				}
				// conta em que posi��o do vetor est�
				cont++;
			}
			// recebe a primeira posi��o daquele subgrupo
			// aux2 cont�m a ultima posi��o que o for chegou, por exemplo, estamos procurando o 5, que se encontra no segundo
			// conjunto, o primeiro for n�o ir� encontrar ele, ent�o partimos para o proximo for.
			// O primeiro for chegou ate a posi��o 3, e precisamos armazenar isso, pra saber que a posi��o 3 � o proximo inicio
			aux2 = cont;
			// terminou o for e o numero n�o foi encontrado, aux incrementa, para ir para a proxima posi��o de lista2
			aux++;
		}while(true);
	}
	
	public boolean comparar(Formatacao g2){
		return listaNova.equals(g2.getListaNova());
	}
	
	public ArrayList<Integer> getListaNova(){
		return listaNova;
	}
	
	public ArrayList<Integer> composicao(Formatacao l2){
		int i, num, num2;
		
		for(i = 1; i < 6; i= i+1){
			num = l2.buscarElemento(i);
			num2 = buscarElemento(num);
			listaNova.add(num2);
		}
		return listaNova;
	}

}
