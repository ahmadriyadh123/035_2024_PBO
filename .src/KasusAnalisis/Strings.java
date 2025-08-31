// Soal 5 Strings

package KasusAnalisis;
import java.io.*;
import java.util.*;

public class Strings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A = sc.next(); // Input string pertama
        String B = sc.next(); // Input string kedua

        // 1. Jumlah panjang A dan B
        System.out.println(A.length() + B.length());

        // 2. Cek urutan alfabet
        if (A.compareTo(B) > 0) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

        // 3. Mengkapitalisasi huruf pertama masing-masing string
        String capitalizedA = Character.toUpperCase(A.charAt(0)) + A.substring(1);
        String capitalizedB = Character.toUpperCase(B.charAt(0)) + B.substring(1);
        System.out.println(capitalizedA + " " + capitalizedB);
    }
}