import java.util.Scanner;

class Makanan {
    private String nama;
    private double harga;

    public Makanan(String nama, double harga) {
        this.nama = nama;
        this.harga = harga;
    }

    public String getNama() {
        return nama;
    }

    public double getHarga() {
        return harga;
    }
}

class Minuman {
    private String nama;
    private double harga;

    public Minuman(String nama, double harga) {
        this.nama = nama;
        this.harga = harga;
    }

    public String getNama() {
        return nama;
    }

    public double getHarga() {
        return harga;
    }
}

public class Pujasera {
    private Makanan[] daftarMakanan;
    private Minuman[] daftarMinuman;

    public Pujasera(Makanan[] daftarMakanan, Minuman[] daftarMinuman) {
        this.daftarMakanan = daftarMakanan;
        this.daftarMinuman = daftarMinuman;
    }

    public void tampilkanMenu() {
        System.out.println("=========================");
        System.out.println("===== Menu Pujasera =====");
        System.out.println("=========================");
        System.out.println("===== Daftar Makanan ====");
        for (int i = 0; i < daftarMakanan.length; i++) {
            System.out.printf("%d. %s - Rp%,.0f\n", i + 1, daftarMakanan[i].getNama(), daftarMakanan[i].getHarga());
        }
        System.out.println("===== Daftar Minuman ====");
        for (int i = 0; i < daftarMinuman.length; i++) {
            System.out.printf("%d. %s - Rp%,.0f\n", i + 1 + daftarMakanan.length, daftarMinuman[i].getNama(), daftarMinuman[i].getHarga());
        }
        System.out.println("=========================");
        System.out.println("=========================");
    }

    public void mulaiTransaksi() {
        Scanner scanner = new Scanner(System.in);
        tampilkanMenu();

        // Input nomor menu, bisa satu atau lebih, dipisahkan koma
        System.out.print("\nMasukkan nomor menu (pisahkan dengan koma jika lebih dari satu, contoh: 1,3,4): ");
        String input = scanner.nextLine().trim();
        if (input.isEmpty()) {
            System.out.println("Tidak ada menu yang dipilih.");
            return;
        }
        String[] pilihanStr = input.split(",");
        double totalHarga = 0;
        StringBuilder pesanan = new StringBuilder();

        for (String s : pilihanStr) {
            if (s.trim().isEmpty()) continue;
            int pilihan;
            try {
                pilihan = Integer.parseInt(s.trim());
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid: " + s);
                return;
            }

            if (pilihan >= 1 && pilihan <= daftarMakanan.length) {
                Makanan makanan = daftarMakanan[pilihan - 1];
                totalHarga += makanan.getHarga();
                pesanan.append(makanan.getNama()).append(" (Rp").append(String.format("%,.0f", makanan.getHarga())).append("), ");
            } else if (pilihan > daftarMakanan.length && pilihan <= daftarMakanan.length + daftarMinuman.length) {
                Minuman minuman = daftarMinuman[pilihan - daftarMakanan.length - 1];
                totalHarga += minuman.getHarga();
                pesanan.append(minuman.getNama()).append(" (Rp").append(String.format("%,.0f", minuman.getHarga())).append("), ");
            } else {
                System.out.println("Nomor menu tidak valid: " + pilihan);
                return;
            }
        }

        if (pesanan.length() > 0) pesanan.setLength(pesanan.length() - 2); // hapus koma terakhir

        System.out.printf("Anda memilih: %s\n", pesanan.toString());
        System.out.printf("Total harga: Rp%,.0f\n", totalHarga);
        System.out.print("Masukkan uang pembayaran: Rp ");
        double uang = scanner.nextDouble();

        if (uang < totalHarga) {
            System.out.println("Uang tidak cukup. Transaksi dibatalkan.");
        } else {
            double kembalian = uang - totalHarga;
            System.out.printf("Terima kasih! Kembalian Anda: Rp%,.0f\n", kembalian);
            System.out.println("Selamat menikmati makanan dan minuman Anda!");
        }
    }

    public static void main(String[] args) {
        Makanan[] makanan = {
            new Makanan("Nasi Goreng", 15000),
            new Makanan("Mie Ayam", 12000),
            new Makanan("Sate Ayam", 20000)
        };

        Minuman[] minuman = {
            new Minuman("Es Teh", 5000),
            new Minuman("Jus Jeruk", 8000),
            new Minuman("Kopi", 7000)
        };

        Pujasera pujasera = new Pujasera(makanan, minuman);
        pujasera.mulaiTransaksi();
    }
}