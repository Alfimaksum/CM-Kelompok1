import java.util.Scanner;

public class  PraktikumPemilihan01 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Program Menghitung Nilai Akhir");
        System.out.println("================================");

        // Input nilai tugas
        System.out.print("Masukkan Nilai Tugas: ");
        double tugas = sc.nextDouble();
        if (!isValid(tugas)) {
            System.out.println("\n================================");
            System.out.println("nilai tidak valid");
            System.out.println("================================");
            return;
        }

        // Input nilai kuis
        System.out.print("Masukkan Nilai Kuis: ");
        double kuis = sc.nextDouble();
        if (!isValid(kuis)) {
            System.out.println("\n================================");
            System.out.println("nilai tidak valid");
            System.out.println("================================");
            return;
        }

        // Input nilai UTS
        System.out.print("Masukkan Nilai UTS: ");
        double uts = sc.nextDouble();
        if (!isValid(uts)) {
            System.out.println("\n================================");
            System.out.println("nilai tidak valid");
            System.out.println("================================");
            return;
        }

        // Input nilai UAS
        System.out.print("Masukkan Nilai UAS: ");
        double uas = sc.nextDouble();
        if (!isValid(uas)) {
            System.out.println("\n================================");
            System.out.println("nilai tidak valid");
            System.out.println("================================");
            return;
        }

        System.out.println("\n================================");
        
        // Menghitung nilai akhir
        double nilaiAkhir = hitungNilaiAkhir(tugas, kuis, uts, uas);

        // Konversi nilai angka ke nilai huruf
        String[] konversi = konversiNilai(nilaiAkhir);
        String nilaiHuruf = konversi[0];
        String keterangan = konversi[1];

        // Menentukan status kelulusan
        String status = tentukanStatus(nilaiHuruf);

        // Output hasil
        System.out.println("nilai akhir : " + String.format("%.1f", nilaiAkhir));
        System.out.println("Nilai Huruf : " + nilaiHuruf);
        System.out.println("================================");
        
        if (status.equals("LULUS")) {
            System.out.println("SELAMAT ANDA LULUS");
        } else {
            System.out.println("ANDA TIDAK LULUS");
        }
    }

    // Fungsi untuk memvalidasi nilai
    public static boolean isValid(double nilai) {
        return nilai >= 0 && nilai <= 100;
    }

    // Fungsi untuk menghitung nilai akhir
    public static double hitungNilaiAkhir(double tugas, double kuis, double uts, double uas) {
        return (0.20 * tugas) + (0.20 * kuis) + (0.30 * uts) + (0.40 * uas);
    }

    // Fungsi untuk mengkonversi nilai angka ke nilai huruf dan keterangan
    public static String[] konversiNilai(double nilaiAkhir) {
        String nilaiHuruf;
        String keterangan;

        if (nilaiAkhir > 80) {
            nilaiHuruf = "A";
            keterangan = "Sangat Baik";
        } else if (nilaiAkhir > 73) {
            nilaiHuruf = "B+";
            keterangan = "Lebih dari Baik";
        } else if (nilaiAkhir > 65) {
            nilaiHuruf = "B";
            keterangan = "Baik";
        } else if (nilaiAkhir > 60) {
            nilaiHuruf = "C+";
            keterangan = "Lebih dari Cukup";
        } else if (nilaiAkhir > 50) {
            nilaiHuruf = "C";
            keterangan = "Cukup";
        } else if (nilaiAkhir > 39) {
            nilaiHuruf = "D";
            keterangan = "Kurang";
        } else {
            nilaiHuruf = "E";
            keterangan = "Gagal";
        }

        return new String[]{nilaiHuruf, keterangan};
    }

    // Fungsi untuk menentukan status kelulusan
    public static String tentukanStatus(String nilaiHuruf) {
        if (nilaiHuruf.equals("A") || nilaiHuruf.equals("B+") || nilaiHuruf.equals("B") || 
            nilaiHuruf.equals("C+") || nilaiHuruf.equals("C")) {
            return "LULUS";
        } else {
            return "TIDAK LULUS";
        }
    }
}
