public class Soal1 {
    public static void main(String[] args) {
        byte angka1 = 125;
        byte angka2 = 6;
        // Terjadi overflow, karena byte hanya menyimpan nilai dari -128 sampai 127
        byte hasil = (byte) (angka1+angka2);

        // 131 - 256 = -125
        System.out.println("Hasil 1"+hasil);
    }
}
