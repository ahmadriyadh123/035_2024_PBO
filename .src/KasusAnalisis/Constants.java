// Soal 2 VARIABLES
package KasusAnalisis;
public class Constants {
    public static void main(String[] args) {
        final double CM_PER_INCH = 2.54; // Konstanta hanya berlaku di method ini
        double paperWidth = 8.5;
        double paperHeight = 11;

        // Output konversi ukuran kertas dari inci ke cm
        System.out.println("Paper size in centimeters: " + paperWidth * CM_PER_INCH + " by " + paperHeight * CM_PER_INCH);
    }
}