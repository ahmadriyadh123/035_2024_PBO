import java.util.Scanner;

class Dokter {
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

    public String getNama() {
        return nama;
    }

    public String getSpesialis() {
        return spesialis;
    }

    public String[] getHari() {
        return hari;
    }

    public String getJam() {
        return jam;
    }

    public boolean praktikDiHari(String hariKunjungan) {
        for (String h : hari) {
            if (h.equalsIgnoreCase(hariKunjungan)) {
                return true;
            }
        }
        return false;
    }
}

class StatusPasien {
    private String namaPasien;
    private String keluhan;
    private String status;

    public StatusPasien(String namaPasien, String keluhan, String status) {
        this.namaPasien = namaPasien;
        this.keluhan = keluhan;
        this.status = status;
    }

    public String getNamaPasien() {
        return namaPasien;
    }

    public String getKeluhan() {
        return keluhan;
    }

    public String getStatus() {
        return status;
    }
}

public class Rsakit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Dokter[] daftarDokter = {
            new Dokter("Dr. Rudi", "Penyakit Jantung", new String[]{"Senin", "Kamis"}, "10:30"),
            new Dokter("Dr. Andi", "Paru-paru", new String[]{"Selasa", "Jumat"}, "09:00"),
            new Dokter("Dr. Sari", "Pencernaan", new String[]{"Rabu"}, "13:00"),
            new Dokter("Dr. Lina", "Saraf", new String[]{"Senin", "Rabu"}, "11:00"),
            new Dokter("Dr. Bima", "Kulit & Kelamin", new String[]{"Jumat"}, "14:00")
        };

        System.out.print("Masukkan hari kunjungan: ");
        String hariKunjungan = scanner.nextLine();

        System.out.println("\nSpesialisasi yang tersedia di hari " + hariKunjungan + ":");
        boolean adaSpesialis = false;
        for (Dokter d : daftarDokter) {
            if (d.praktikDiHari(hariKunjungan)) {
                System.out.println("- " + d.getSpesialis());
                adaSpesialis = true;
            }
        }
        if (!adaSpesialis) {
            System.out.println("Tidak ada spesialisasi yang praktik di hari tersebut.");
            scanner.close();
            return;
        }

        // Input data pasien
        System.out.print("\nMasukkan nama pasien: ");
        String namaPasien = scanner.nextLine();
        System.out.print("Masukkan keluhan: ");
        String keluhan = scanner.nextLine();
        System.out.print("Pilih spesialisasi yang ingin dituju: ");
        String spesialisTujuan = scanner.nextLine();

        StatusPasien status = new StatusPasien(namaPasien, keluhan, "Belum Diperiksa");

        Dokter dokterPilihan = null;
        for (Dokter d : daftarDokter) {
            if (d.getSpesialis().equalsIgnoreCase(spesialisTujuan) && d.praktikDiHari(hariKunjungan)) {
                dokterPilihan = d;
                break;
            }
        }
        System.out.println("==============================");
        System.out.println("==============================");
        System.out.println("===Hasil Pengecekan Praktik===");
        if (dokterPilihan != null) {
            System.out.println("Jadwal Praktik Ditemukan!");
            System.out.println("Dokter: " + dokterPilihan.getNama());
            System.out.println("Spesialis: " + dokterPilihan.getSpesialis());
            System.out.print("Hari Praktik: ");
            String[] hariPraktik = dokterPilihan.getHari();
            for (int i = 0; i < hariPraktik.length; i++) {
                System.out.print(hariPraktik[i]);
                if (i < hariPraktik.length - 1) System.out.print(", ");
            }
            System.out.println();
            System.out.println("Jam: " + dokterPilihan.getJam());
            System.out.println("==============================");
            System.out.println("Status Pasien:");
            System.out.println("Nama: " + status.getNamaPasien());
            System.out.println("Keluhan: " + status.getKeluhan());
            System.out.println("Status: " + status.getStatus());
            System.out.println("==============================");
            System.out.println("==============================");
        } else {
            System.out.println("Maaf, jadwal praktik spesialisasi tersebut tidak ditemukan di hari yang dipilih.");
        }

        scanner.close();
    }
}            