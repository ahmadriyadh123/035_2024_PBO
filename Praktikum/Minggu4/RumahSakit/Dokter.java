// File: Dokter.java
package RumahSakit;

public class Dokter extends Orang {
    private String spesialis;
    private String[] hari;
    private String jam;

    public Dokter(String nama, String spesialis, String[] hari, String jam) {
        super(nama); 
        this.spesialis = spesialis;
        this.hari = hari;
        this.jam = jam;
    }

    public String getSpesialis() { return spesialis; }
    public String[] getHari() { return hari; }
    public String getJam() { return jam; }

    public boolean praktikDiHari(String hariKunjungan) {
        for (String h : hari) {
            if (h.equalsIgnoreCase(hariKunjungan)) {
                return true;
            }
        }
        return false;
    }

    // OVERRIDE
    public void tampilkanInfo() {
        System.out.println("=== Informasi Dokter ===");
        super.tampilkanInfo();
        System.out.println("Spesialis: " + this.spesialis);
        System.out.print("Hari Praktik: ");
        for (int i = 0; i < hari.length; i++) {
            System.out.print(hari[i] + (i < hari.length - 1 ? ", " : ""));
        }
        System.out.println("\nJam: " + this.jam);
    }
}
