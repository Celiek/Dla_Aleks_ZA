package com.company;

import java.nio.file.PathMatcher;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// program wczytuej ile linii uzytkownik chce wprowadzic
// nastepnie wczytuej tyle linii i sprawdza czy wpisane dane zawierają wprowadzony regex
// jeżeli wprowadzi dodatkową zmienną to możeodwrócić działanie programu(zmienna fau)

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Wprowadź wyrażenie regularne");
        String regex = s.nextLine();

        Pattern compiledPattern = Pattern.compile(regex);

        System.out.println("Czy chcesz odwrócić działanie programu? (wpisz 'v')");
        String fau = null;
        fau = s.nextLine();

        //sprawdzanie drugiego parametru
        //w tym przypadku gdy jest pusty
        if(fau.equals("")){
            System.out.println("Ile linii chcesz wpisać ? ");
            int ilosc_linii = s.nextInt();
            String[] tablica = new String[ilosc_linii];

            //fragment kodu do debugowania
            System.out.println("Wypisywanie pasujących linii kodu");

            for (int i = 0; i < ilosc_linii; i++) {

                System.out.println("Wprowadź ciąg znaków");
                tablica[i] = s.nextLine();

                //kompilowanie linijki "i" do kodu
                Matcher matcher = compiledPattern.matcher(tablica[i]);

                //wypisywanie zdania jeżeli sie zgadza
                if(matcher.find()){
                    System.out.println(tablica[i]);
                }else{
                    //do debugowania
                    System.out.println(tablica[i] +  " nie pasuje");
                }
            }
        }else if( fau.equals("v")){
            // nie ma wprowadzonego drugiego parametru

            System.out.println("Ile linii chcesz wpisać ? ");
            int ilosc_linii = s.nextInt();
            String[] tablica = new String[ilosc_linii];

            //fragment kodu do debugowania
            System.out.println("Wypisywanie pasujących linii kodu");

            for (int i = 0; i < ilosc_linii; i++) {

                System.out.println("Wprowadź ciąg znaków");
                tablica[i] = s.nextLine();

                //kompilowanie linijki "i" do kodu
                // w celu zamiany jej na regex

                Matcher matcher = compiledPattern.matcher(tablica[i]);

                //sprawdzanie warunków
                // kilka warunków do usunięcia
                if(matcher.find()){
                    System.out.println(tablica[i] +  " nie pasuje");
                }else{
                    //do debugowania
                    System.out.println(tablica[i]);
                }
            }
        }else{
            System.out.println("Wprowadzono zły znak");
            System.out.println("Koncze dzialanie programu");
        }

    }
}
