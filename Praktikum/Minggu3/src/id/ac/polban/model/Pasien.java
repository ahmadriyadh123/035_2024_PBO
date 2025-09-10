package id.ac.polban.model;

public class Pasien {
    private String namaPasien;
    private String keluhan;
    private String status;

    public Pasien(String namaPasien, String keluhan) {
        this.namaPasien = namaPasien;
        this.keluhan = keluhan;
        this.status = "Belum Diperiksa"; // Status diatur di sini
    }

    public String getNamaPasien() { return namaPasien; }
    public String getKeluhan() { return keluhan; }
    public String getStatus() { return status; }
}