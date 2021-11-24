package com.datastructure;

import java.net.StandardSocketOptions;
import java.util.HashSet;
import java.util.Set;

public class DataStructureOne {

//    Aufgabe - Mengenlehre
//    Gegeben sind drei Zahlenmengen A, B, C - realisiert als Arrays vom Typ Integer:
//    A = { 49, 30, 14, 47, 13, 2, 12, 29, 19, 11, 15, 39, 43, 45, 34 }
//    B = { 39, 33, 38, 14, 4, 32, 40, 25, 17, 46, 35, 6, 2, 12, 49 }
//    C = { 41, 12, 5, 35, 42, 28, 47, 20, 26, 24, 50, 40, 14, 17, 10 }
//    Berechne möglichst effizient die Vereinigungsmenge von A ∪ B ∪ C sowie alle möglichen Schnittmengen und Differenzmengen der drei Zahlenmengen.

    public static void main(String[] args) {
        int[] A = {49, 30, 14, 47, 13, 2, 12, 29, 19, 11, 15, 39, 43, 45, 34};
        int[] B = {39, 33, 38, 14, 4, 32, 40, 25, 17, 46, 35, 6, 2, 12, 49};
        int[] C = {41, 12, 5, 35, 42, 28, 47, 20, 26, 24, 50, 40, 14, 17, 10};

//  Collect - Vereinigungsmenge - A ∪ B ∪ C
        Set<Integer> values = new HashSet<>();
        System.out.println("Vereinigungsmenge");

        values = collect(values, A, B, C);
        output(values);

//  Cut - Schnittmenge
        System.out.println("Schnittmenge");

        values = cut(values, A, B, C);
        output(values);

//  Only - Differenzmenge
        for (int arr = 1; arr <= 3; arr++) {
            if(arr == 1) {
                System.out.println("Differenzmenge von A");
                values = diff(values, A, B, C);
                output(values);
            } else if(arr == 2) {
                System.out.println("Differenzmenge von B");
                values = diff(values, B, C, A);
                output(values);
            } else {
                System.out.println("Differenzmenge von C");
                values = diff(values, C, A, B);
                output(values);
            }
        }
    }

//  Cut-Methode
    private static Set<Integer> cut(Set<Integer> values, int[] A, int[] B, int[] C) {
        values.clear();
        for (int i = 0; i < A.length; i++) {         // All Number in A
            for (int j = 0; j < B.length; j++) {      // that are in B
                for (int k = 0; k < C.length; k++) {  // and in C
                    if (A[i] == B[j] && A[i] == C[k]) {
                        values.add(A[i]);
                    }
                }
            }
        }
        return values;
    }


//  Collect-Methode
    private static Set<Integer> collect(Set<Integer> values, int[] A, int[] B, int[] C) {
        values.clear();
        for (int i = 0; i < A.length; i++) { //funktioniert nur, da alle Arrays gleich lang sind
            values.add(A[i]);
            values.add(B[i]);
            values.add(C[i]);
        }
        return values;
    }

//  Output-Methode
    private static void output(Set<Integer> xyz){
        for (Integer set : xyz) {
            System.out.print(set + ", ");
        }
        System.out.println();
    }
//  Differenzier-Methode
    private static Set<Integer> diff(Set<Integer> values, int[] array, int[] woArrayOne, int[] woArrayTwo)
    {
        values.clear();
        for (int i = 0; i < array.length; i++)
        {
            values.add(array[i]);   //Add all Values of Circle 1
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < woArrayOne.length; j++) {
                if(array[i] == woArrayOne[j])
                {
                    values.remove(array[i]);    //remove values shared with Circle 2
                }
            }
        }
        for (int i = 0; i < array.length; i++) {
            for (int k = 0; k < woArrayTwo.length; k++) {  // and in C
                if (array[i] == woArrayTwo[k])
                {
                    values.remove(array[i]);    //remove values shared with Circle 3
                }
            }
        }
        return values;
    }

}


