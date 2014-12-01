package jeu;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		 HashSet<Carte> mm = new HashSet<Carte>();
		  HashSet<Carte> l = new HashSet<Carte>();
		LinkedList<Carte> n=new LinkedList<Carte>();
		n.add(new Carte(8, "Pique"));
		n.add(new Carte(8, "Coeur"));
		n.add(new Carte(13, "Pique"));

		mm.add(new Carte(1, "Pique"));
		mm.add(new Carte(8, "Coeur"));
		mm.add(new Carte(10, "Carreau"));
		l.add(new Carte(2, "Pique"));
		l.add(new Carte(2, "Coeur"));
		l.add(new Carte(2, "Carreau"));
		 
		// print the list
	     
		System.out.println(n);
    	Carte caa=new Carte(8,"Pique");
    	System.out.println(caa);

		//System.out.println(n.getLast());
		System.out.print("valeur de la carte à jouer ");
	    Scanner ra = new Scanner(System.in);	
		int i=ra.nextInt();
		System.out.print("couleur de la carte à jouer ");
		Scanner r = new Scanner(System.in);
		String c=r.next();
		//   for (int j = 0; j <i; j++) { 
		    	Carte ca=new Carte(i,c);
		    	System.out.println(ca);
		    	 //n.remove(ca);
		    	

		   				System.out.println(n);

		   				
	}
	      
		
		
		
	
}
