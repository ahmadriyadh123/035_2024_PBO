// File: Orang.java
package RumahSakit;

public class Orang {
    private String nama;

    public Orang(String nama) {
        this.nama = nama;
    }

    public String getNama() {
        return nama;
    }

    public void tampilkanInfo() {
        System.out.println("Nama: " + this.nama);
    }
}