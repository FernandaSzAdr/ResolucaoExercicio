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
	
	//
	public void separarString (String grupo){
		grupoS = grupo.split("[\\W]");
		String[] j = new String[4];
		
		for(String i: grupoS){
			if(i.length() > 0){
				cont++;
				j = i.split("");
			
				for(String x: j){
					lista.add(Integer.parseInt(x));
					cont2++;				
				}
				lista2.add(cont2);
				cont2 = 0;
			}
			
		}
		
		for(String i: grupoS){
			if(i.length() > 0){
			}
		}
	}
	
	private void criarSubGrupos(){
		
	}
	
	public ArrayList<Integer> getLista(){
		return lista;
	}
	
	public ArrayList<Integer> getLista2(){
		return lista2;
	}
	
	public int buscarElemento(int elemento){
		int aux = 0, aux2 = 0, cont = 0, j = 0, pt1 = 0;
		
		do{
			for(j = 0; j < lista2.get(aux); j ++){
				pt1 = lista.get(cont);			
				
				if(pt1 == elemento){
					if(j+1 == lista2.get(aux)){
						if(aux2 > 0){
							if (lista2.get(aux) == 1) {
								return elemento;
							}else if (lista2.get(aux) == 2) {
								return lista.get(cont++);
							}else if(cont == 4){
								return lista.get(aux2);
							}else {
								return lista.get(cont++);								
							}
						}else{
							return lista.get(0);							
						}
					}else{
						if(aux2 > 0){
							return lista.get(cont+1);
						}else{
							return lista.get(j+1);							
						}
					}
				}
				cont++;
			}
			aux2 = cont;
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
			System.out.println("i = " + i);
			num = l2.buscarElemento(i);
			System.out.println("num = " + num);
			num2 = buscarElemento(num);
			System.out.println("num2 = " + num2);
			listaNova.add(num2);
		}
		return listaNova;
	}

}
