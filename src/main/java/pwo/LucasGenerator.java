/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pwo;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class LucasGenerator {

    public static void main(String[] args) {
        int n = 100; // Liczba wyrazów do wygenerowania
        long[] lucasSequence = new long[n];

        // Pierwsze dwa wyrazy ciągu Lucas
        lucasSequence[0] = 2;
        lucasSequence[1] = 1;

        // Generowanie pozostałych wyrazów
        for (int i = 2; i < n; i++) {
            lucasSequence[i] = lucasSequence[i - 1] + lucasSequence[i - 2];
        }

        // Zapisywanie wyrazów ciągu do pliku tekstowego
        try {
            PrintWriter writer = new PrintWriter(new FileWriter("lucas_sequence.txt"));

            for (int i = 0; i < n; i++) {
                writer.println("L(" + i + ") = " + lucasSequence[i]);
            }

            writer.close();
            System.out.println("Ciąg Lucas zapisany do pliku 'lucas_sequence.txt'");
        } catch (IOException e) {
            System.err.println("Błąd podczas zapisu do pliku.");
            e.printStackTrace();
        }
    }
}

