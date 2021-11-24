package com.datastructure;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DataStructureTwo {

//Aufgabe - Wörterbuch: Deutsch - Englisch
//  Erstelle ein Programm welches ein Wörterbuch zum Übersetzen von Wörtern zwischen Englisch und Deutsch implementiert
//            (bi-direktional). Es soll folgende Funktionalitäten umfassen:
//            - Hinzufügen eines neuen Wort-Paars (Englisch und Deutsch)
//  Entfernen eines Wort-Paars aus dem Wörterbuch
//  Übersetzen eines Wortes (Deutsch oder Englisch) in die jeweilig andere Sprache

    public static void main(String[] args) {
        HashMap<String, String> deEn = new HashMap<>();
        HashMap<String, String> enDe = new HashMap<>();
//  add to Dictionary
        addWord(deEn, enDe, "eins", "one");
        addWord(deEn, enDe, "zwei", "two");
        addWord(deEn, enDe, "drei", "three");
        addWord(deEn, enDe, "vier", "four");
        addWord(deEn, enDe, "fünf", "five");
        addWord(deEn, enDe, "sechs", "six");
        addWord(deEn, enDe, "auto", "bike");    //Falscheintrag

        System.out.println("Deutsch - Englisch");
        callDict(deEn);

        System.out.println("English - German");
        callDict(enDe);

//  delete entry
        Scanner sc1 = new Scanner(System.in);
        System.out.print("remove entry: ");
        String kill = sc1.next();

        eliminate(deEn, enDe, kill);

        System.out.println("Deutsch - Englisch");
        callDict(deEn);

        System.out.println("English - German");
        callDict(enDe);


//  call translation
        System.out.print("translate: ");
        String word = sc1.next();

        translate(deEn, enDe, word);


        sc1.close();
    }

//  eliminate entries in Dictionary 1 and 2
    private static void eliminate(HashMap<String, String> deEn, HashMap<String, String> enDe, String kill)
    {
        if (deEn.containsKey(kill)){        //Dictionary Deutsch-Englisch
            String killToo = deEn.get(kill);    //save value of key
            deEn.remove(kill);                  //kill Entry Dict-1
            enDe.remove(killToo);               //kill Entry Dict-2
        }
        else if(enDe.containsKey(kill)){    //Dictionary Englisch-Deutsch
            String killToo = enDe.get(kill);
            enDe.remove(kill);
            deEn.remove(killToo);
        }
        else{
            System.out.println("No entry found");
        }
    }

//  show Entries of Dictionary
    private static void callDict(HashMap<String, String> dict)
    {
        for (Map.Entry<String, String> keySet : dict.entrySet()) {
            System.out.println(keySet.getKey() + "  \t\t" + keySet.getValue());
        }
        System.out.println();
    }

//  search and translate in Dictionary 1 and 2
    private static void translate(HashMap<String, String> deEn, HashMap<String, String> enDe, String word)
    {
        if (deEn.containsKey(word)){
            System.out.println("Deutsch: " + word + "\tEnglish: " + deEn.get(word));
        }
        else if(enDe.containsKey(word)){
            System.out.println("English: " + word + "\tDeutsch: " + enDe.get(word));
        }
        else{
            System.out.println("No entry found");
        }
    }

//  add Values to Dictionary 1 and 2
    private static void addWord(HashMap<String, String> deEn, HashMap<String, String> enDe, String deutsch, String englisch)
    {
        deEn.put(deutsch, englisch);
        enDe.put(englisch, deutsch);
    }


}
