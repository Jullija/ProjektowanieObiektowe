package main;

import dokumenty.Faktura;
import magazyn.Towar;
import produkty.ICategory;
import produkty.Kategoria;
import produkty.Subkategoria;
import rabatlosowy.LosowyRabat;

import java.util.Calendar;

import static dokumenty.WydrukFaktury.drukujFakture;


public class Ui {

	public static void main(String[] args){
		Calendar teraz=Calendar.getInstance();

		Towar towar1 = new Towar(10, "Buty");
		Towar towar2 = new Towar(5, "Jabłko");

		
		//Tworzyenie kategorii
		Kategoria category1 = new Kategoria("Kategoria 1");
		Kategoria category2 = new Kategoria("Kategoria 2");

		// Tworzenie podkategorii
		Subkategoria subcategory1 = new Subkategoria("Podkategoria 1");
		Subkategoria subcategory2 = new Subkategoria("Podkategoria 2");


		subcategory1.addComponent(towar1);
		subcategory2.addComponent(towar2);
		category1.addComponent(towar1);
		category2.addComponent(towar2);


		// Wypisanie drzewa
		category1.print();
		category2.print();
		subcategory1.print();
		subcategory2.print();
		System.out.println("======================");


		
		//I przykladowa fakture
		Faktura f=new Faktura(teraz.getTime(),"Fido");
		f.dodajPozycje(towar1,1);
		f.dodajPozycje(towar2, 5);
		
		drukujFakture(f);

		
		//TEST ZEWN. rabatu
		LosowyRabat lr=new LosowyRabat();
		System.out.println(lr.losujRabat());
	}


}
