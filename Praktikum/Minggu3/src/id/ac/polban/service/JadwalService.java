package id.ac.polban.service;

import id.ac.polban.model.Dokter;
import java.util.ArrayList;
import java.util.List;

public class JadwalService {

    // Penerapan STATIC: Daftar dokter ini milik kelas, bukan objek.
    // Bersifat pusat dan sama untuk seluruh aplikasi.
    private static final List<Dokter> daftarDokter = new ArrayList<>();

    // Penerapan STATIC: Static initializer block untuk mengisi data sekali saja
    // saat kelas ini dimuat.
    static {
        daftarDokter.add(new Dokter("Dr. Rudi", "Penyakit Jantung", new String[]{"Senin", "Kamis"}, "10:30"));
        daftarDokter.add(new Dokter("Dr. Andi", "Paru-paru", new String[]{"Selasa", "Jumat"}, "09:00"));
        daftarDokter.add(new Dokter("Dr. Sari", "Pencernaan", new String[]{"Rabu"}, "13:00"));
        daftarDokter.add(new Dokter("Dr. Lina", "Saraf", new String[]{"Senin", "Rabu"}, "11:00"));
        daftarDokter.add(new Dokter("Dr. Bima", "Kulit & Kelamin", new String[]{"Jumat"}, "14:00"));
    }

    // Penerapan STATIC: Method ini bisa dipanggil tanpa membuat objek JadwalService.
    public static List<Dokter> getDokterPraktik(String hariKunjungan) {
        List<Dokter> dokterPraktik = new ArrayList<>();
        for (Dokter d : daftarDokter) {
            if (d.praktikDiHari(hariKunjungan)) {
                dokterPraktik.add(d);
            }
        }
        return dokterPraktik;
    }

    // Penerapan STATIC: Method ini juga bersifat utility/pembantu.
    public static Dokter cariDokter(String spesialis, String hariKunjungan) {
        for (Dokter d : daftarDokter) {
            if (d.getSpesialis().equalsIgnoreCase(spesialis) && d.praktikDiHari(hariKunjungan)) {
                return d;
            }
        }
        return null;
    }
}