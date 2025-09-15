// File: Rsakit.java
package RumahSakit;

import java.util.Scanner;

public class Rsakit {
    public static void main(String[] args) {
        Dokter[] daftarDokter = {
            new Dokter("Dr. Rudi", "Penyakit Jantung", new String[]{"Senin", "Kamis"}, "10:30"),
            new Dokter("Dr. Andi", "Paru-paru", new String[]{"Selasa", "Jumat"}, "09:00"),
            new Dokter("Dr. Sari", "Pencernaan", new String[]{"Rabu"}, "13:00"),
            new Dokter("Dr. Lina", "Saraf", new String[]{"Senin", "Rabu"}, "11:00"),
            new Dokter("Dr. Bima", "Kulit & Kelamin", new String[]{"Jumat"}, "14:00")
        };
        Scanner scanner = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("\n===== Sistem Informasi Rumah Sakit =====");
            System.out.println("1. Cek Jadwal Dokter");
            System.out.println("2. Pendaftaran Pasien");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan hari kunjungan untuk cek jadwal: ");
                    String hariCekJadwal = scanner.nextLine();

                    System.out.println("\nJadwal Dokter di Hari " + hariCekJadwal + ":");
                    boolean adaDokter = false;
                    for (Dokter d : daftarDokter) {
                        if (d.praktikDiHari(hariCekJadwal)) {
                            System.out.println("- Spesialis " + d.getSpesialis() + " (Dr. " + d.getNama() + ", Jam: " + d.getJam() + ")");
                            adaDokter = true;
                        }
                    }
                    if (!adaDokter) {
                        System.out.println("Tidak ada dokter yang praktik di hari tersebut.");
                    }
                    break;

                case 2:
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
                        break;
                    }

                    System.out.print("\nMasukkan nama pasien: ");
                    String namaPasien = scanner.nextLine();
                    System.out.print("Masukkan keluhan: ");
                    String keluhan = scanner.nextLine();
                    System.out.print("Pilih spesialisasi yang ingin dituju: ");
                    String spesialisTujuan = scanner.nextLine();

                    // Membuat objek Pasien
                    Pasien pasien = new Pasien(namaPasien, keluhan, "Belum Diperiksa");

                    Dokter dokterPilihan = null;
                    for (Dokter d : daftarDokter) {
                        if (d.getSpesialis().equalsIgnoreCase(spesialisTujuan) && d.praktikDiHari(hariKunjungan)) {
                            dokterPilihan = d;
                            break;
                        }
                    }

                    System.out.println("\n=================================");
                    System.out.println("=== Hasil Pendaftaran ===");
                    if (dokterPilihan != null) {
                        System.out.println("Pendaftaran Berhasil!");
                        dokterPilihan.tampilkanInfo();
                        pasien.tampilkanInfo();
                    } else {
                        System.out.println("Maaf, jadwal praktik untuk spesialisasi tersebut tidak ditemukan.");
                    }
                    System.out.println("=================================");
                    break;
                case 0:
                    System.out.println("Terima kasih!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 0);

        scanner.close();
    }
}