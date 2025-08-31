// Soal 3 OPERATORS

package KasusAnalisis;
class FloatingPoint {
    public static void main(String[] args) {
        double x = 92.08;

        // Math.round() membulatkan ke integer terdekat; hasilnya long, jadi perlu casting jika disimpan ke int
        int nx = (int) Math.round(x);
        System.out.println(nx);
    }
}