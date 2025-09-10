package id.ac.polban.model;

public class Dokter {
    private String nama;
    private String spesialis;
    private String[] hari;
    private String jam;

    public Dokter(String nama, String spesialis, String[] hari, String jam) {
        this.nama = nama;
        this.spesialis = spesialis;
        this.hari = hari;
        this.jam = jam;
    }

    public String getNama() { return nama; }
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
}