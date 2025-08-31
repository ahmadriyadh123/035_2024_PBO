// Soal 4 OPERATORS(1)
package KasusAnalisis;
class ConvertDataType {
    static short methodOne(long l) {
        int i = (int) l;   // Konversi long ke int
        return (short) i;  // Konversi int ke short
    }

    public static void main(String[] args) {
        double d = 10.25;         // Nilai awal bertipe double
        float f = (float) d;      // Konversi double ke float
        // Cast berulang: float -> long -> int -> short -> byte
        byte b = (byte) methodOne((long) f);
        System.out.println(b);    // Output: 10 (bagian pecahan hilang saat cast ke long)
    }
}