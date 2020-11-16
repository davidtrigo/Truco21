package com.truco21.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

public class Baraja{
	

	private int status; 
	private ArrayList<ArrayList<Carta>>  mesa; 
	

	
	public Baraja() {
		super();	
		status=0; 
	}


		public ArrayList<ArrayList<Carta>> iniJuego(){ 
			status=1; 
			ArrayList<Carta> mazo21 = iniMazo21();  
			ArrayList<ArrayList<Carta>>  mesa = ponerEnMesa(mazo21); 
			return mesa; 
		}
			
		public ArrayList<ArrayList<Carta>> siguienteMesa(int select){ 
			status++; 
			ArrayList<Carta> mazo21= mesaAmazo(select,mesa); 
			mesa = ponerEnMesa(mazo21); 
			return mesa; 
		}
		
		
		/*
		 *  select  valor que indica en que array esta la carta seleccionada
		 *   0   primer array ,monton de la izquierda 
		 *   1   primer array ,monton del centro
		 *   2   primer array ,monton de la derecha
		 * 
		 * mazo21  array que addiciona 
		 * 
		 *   return   retorna un mazo
		 * 
		 */
		private ArrayList<Carta>   mesaAmazo(int select, ArrayList<ArrayList<Carta>> mesa) {
			
			ArrayList<Carta>  mazo21 = new ArrayList<Carta> (); 
			
			if(select == 0){
				
				mazo21.addAll(mesa.get(1)); 
				mazo21.addAll(mesa.get(0)); 
				mazo21.addAll(mesa.get(2)); 
				
			} else if (select == 1){
				
				mazo21.addAll(mesa.get(0));
				mazo21.addAll(mesa.get(1));
				mazo21.addAll(mesa.get(2));
				
			}else if (select == 2){
				
				mazo21.addAll(mesa.get(1));
				mazo21.addAll(mesa.get(2));
				mazo21.addAll(mesa.get(0));
			
			} else {
				System.out.println("Ningun mazo seleccionado");
			}

			Collections.reverse(mazo21);
			
			return mazo21; 
		}




		private ArrayList<ArrayList<Carta>> ponerEnMesa(ArrayList<Carta> mazo21) {
			 
			ArrayList<ArrayList<Carta>> mesa = new   ArrayList<ArrayList<Carta>>();   
			ArrayList<Carta> mazo1 = new ArrayList<Carta>();
			ArrayList<Carta> mazo2 = new ArrayList<Carta>();
			ArrayList<Carta> mazo3 = new ArrayList<Carta>();
		   
		
		
	 
			
			 for (int i = 0; i <= 20; i+=3) {
					mazo1.add(mazo21.get(i));
					}
			 
			 
			 for (int i = 1; i <= 20; i+=3) {
					mazo2.add(mazo21.get(i));
					}
			 
			 
			 for (int i = 2; i <= 20; i+=3) {
					mazo3.add(mazo21.get(i));
					}
		
		 
		 
			
			/* añade los mazos creados a la mesa*/
		
		
			mesa.add(mazo1);
			mesa.add(mazo1);
			mesa.add(mazo3);
			  
			return mesa;
	     }
	 
		
		
		/*
		 * 
		 * Selecciona segundo mazo get(1) y de ese ,mazo la carta que hace 11 get(4)
		 * 
		 * */
	     public Carta getCartaSeleccionada(){
	    	
	    return  mesa.get(1).get(3);
	     }
		
		
		
		/*
		 *crearBaraja()                                                        
		 * 
		 * método que crea un ArrayList de objetos Carta
		 * 
		 */

		
		private static ArrayList<Carta> crearBaraja(){ 
			
			String[] palo = {"oro","basto","espada","copa"};
			String[] numero={"12","11","10","9","8","7","6","5","4","3","2","1"};
			
			 ArrayList<Carta> paqueteCartas = new ArrayList<Carta>(); 
			 
			for (int i=0; i< palo.length;i++) {		
				for (int j = 0; j < numero.length; j++) {			
					Carta carta = new Carta(palo[i], numero[j]);
					paqueteCartas.add(carta);						
				}
			}		
		 return paqueteCartas;		 
		}
		

		/*
		 * barajar()
		 * 
		 * Método que baraja el mazo de cartas
		 * 
		 *de  la baraja creada  guarda en el Arraylist mazo21  21 objetos de tipo Carta
		 * 
		 * @return mazo21   retorna un arrayList de objetos Cartas  
		 * */
			private  static ArrayList<Carta> iniMazo21(){
				
				ArrayList<Carta> mazo21 = new ArrayList<>();
				ArrayList<Carta> baraja = crearBaraja();			
				Random random = new Random();

				// Mientras queden cartas en la baraja 
				while (mazo21.size()<20){
				   // Elegimos un índice al azar, entre 0 y el número de cartas que quedan por sacar
				   int randomIndex = random.nextInt(baraja.size());

				   // Guardamos la carta en nuevo arrayList de cartas
				   mazo21.add(baraja.get(randomIndex));

				   // Y eliminamos la carta del mazo (la borramos de la lista)
				   baraja.remove(randomIndex);
				}			
				return mazo21;
			}
				 

}





