// File: Pasien.java
package RumahSakit;

public class Pasien extends Orang { 
    private String keluhan;
    private String status;

    public Pasien(String nama, String keluhan, String status) {
        super(nama); 
        this.keluhan = keluhan;
        this.status = status;
    }

    // Getter spesifik untuk Pasien
    public String getKeluhan() { return keluhan; }
    public String getStatus() { return status; }

    //Override
    public void tampilkanInfo() {
        System.out.println("\n=== Status Pasien ===");
        super.tampilkanInfo();
        System.out.println("Keluhan: " + this.keluhan);
        System.out.println("Status: " + this.status);
    }
}
