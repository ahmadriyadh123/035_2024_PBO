package id.ac.polban;

import id.ac.polban.model.Dokter;
import id.ac.polban.model.Pasien;
import id.ac.polban.service.JadwalService;
import java.util.List;
import java.util.Scanner;

public class App {
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
            scanner.nextLine(); // Consume newline

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan hari kunjungan untuk cek jadwal: ");
                    String hariCekJadwal = scanner.nextLine();

                    System.out.println("\nSpesialisasi yang tersedia di hari " + hariCekJadwal + ":");
                    boolean adaSpesialisCek = false;
                    for (Dokter d : daftarDokter) {
                        if (d.praktikDiHari(hariCekJadwal)) {
                            System.out.println("- " + d.getSpesialis() + " (Dr. " + d.getNama() + ", Jam: " + d.getJam() + ")");
                            adaSpesialisCek = true;
                        }
                    }
                    if (!adaSpesialisCek) {
                        System.out.println("Tidak ada spesialisasi yang praktik di hari tersebut.");
                    }
                    break;

                case 2:
                    System.out.print("Masukkan hari kunjungan: ");
                    String hariKunjungan = scanner.nextLine();

                    System.out.println("\nSpesialisasi yang tersedia di hari " + hariKunjungan + ":");
                    boolean adaSpesialis = false;
                    List<Dokter> dokterPraktikHariIni = JadwalService.getDokterPraktik(hariKunjungan);
                    if (!dokterPraktikHariIni.isEmpty()) {
                        for (Dokter d : dokterPraktikHariIni) {
                            System.out.println("- " + d.getSpesialis() + " (Dr. " + d.getNama() + ", Jam: " + d.getJam() + ")");
                            adaSpesialis = true;
                        }
                    }     
                    if (!adaSpesialis) {
                        System.out.println("Tidak ada spesialisasi yang praktik di hari tersebut.");
                        break; // Kembali ke menu utama
                    }

                    // Input data pasien
                    System.out.print("\nMasukkan nama pasien: ");
                    String namaPasien = scanner.nextLine();
                    System.out.print("Masukkan keluhan: ");
                    String keluhan = scanner.nextLine();
                    System.out.print("Pilih spesialisasi yang ingin dituju: ");
                    String spesialisTujuan = scanner.nextLine();

                    Pasien status = new Pasien(namaPasien, keluhan);
                    Dokter dokterPilihan = JadwalService.cariDokter(spesialisTujuan, hariKunjungan);
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
                    break;
                case 0:
                    System.out.println("Terima kasih telah menggunakan layanan kami.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        } while (pilihan != 0);

        scanner.close();
    }
}            