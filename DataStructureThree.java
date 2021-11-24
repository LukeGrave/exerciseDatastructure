package com.datastructure;

import java.util.ArrayList;
import java.util.List;

public class DataStructureThree {

//Aufgabe - Liste sortieren
//    Wähle einen der bereits mit Arrays implementierten Sortieralgorithmus und ändere die Implementation derart, dass statt
//    Arrays Listen verwendet werden. Wichtig: Es soll NICHT die eingebaute Sortierfunktion des Listen Interface, sondern
//    euer eigener Algorithmus verwendet werden.

    public static void main(String[] args) {

        List<String> students = new ArrayList<>();
        addName(students, "Thomas");
        addName(students, "Zulu");
        addName(students, "Lukas");
        addName(students, "Raphael");
        addName(students, "Yankee");



//  SelectionSort
        int len = students.size();
        String x,y;	//Zwischenspeicher

        for(int j = 0; j < len-1; j++)	//Index Wahl
        {
            for(int k = j+1; k < len; k++)	//Kontrollwerte ab Indexwahl + 1
            {
                if (students.get(j).compareTo(students.get(k)) > 0)	//Vergleich ob gewählter Wert die Kleinste gegenüber den Folgenden ist
                {                                                   // CompareTo wandelt Zeichen in Unicode um und vergleicht
                    x = students.get(j);		//setze als (Nächst)kleinster Wert
                    y = students.get(k);
                    students.set(j,y);
                    students.set(k,x);
                }
            }
            for(String a : students) //Ausgabe der Liste nach jedem Schritt
            {
                System.out.println(a);
            }
            System.out.println();
        }
    }

    private static void addName(List<String> person, String name) {
        person.add(name);
    }

}
