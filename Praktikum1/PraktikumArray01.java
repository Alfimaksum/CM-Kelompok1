import java.util.Scanner;

public class PraktikumArray01 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Meminta jumlah mata kuliah
        System.out.println("==========================================");
        System.out.println("      Program Menghitung IP Semester");
        System.out.println("==========================================");

        System.out.print("Masukkan jumlah mata kuliah: ");
        int jumlahMataKuliah = sc.nextInt();
        sc.nextLine(); // Membersihkan newline

        // Array untuk menyimpan data mata kuliah
        String[] namaMataKuliah = new String[jumlahMataKuliah];
        int[] sks = new int[jumlahMataKuliah];
        String[] nilaiHuruf = new String[jumlahMataKuliah];
        double[] nilaiAngka = new double[jumlahMataKuliah];
        double[] nilaiSetara = new double[jumlahMataKuliah];

        // Input data mata kuliah
        for (int i = 0; i < jumlahMataKuliah; i++) {
            System.out.println("\nMasukkan data mata kuliah ke-" + (i + 1));
            System.out.print("Nama Mata Kuliah: ");
            namaMataKuliah[i] = sc.nextLine();
            System.out.print("Bobot SKS: ");
            sks[i] = sc.nextInt();
            System.out.print("Nilai Angka: ");
            nilaiAngka[i] = sc.nextDouble();
            sc.nextLine(); // Membersihkan newline

            // Konversi nilai angka ke huruf dan setara
            nilaiHuruf[i] = konversiNilaiHuruf(nilaiAngka[i]);
            nilaiSetara[i] = konversiNilaiSetara(nilaiHuruf[i]);
        }

        // Menghitung IP Semester
        double totalNilaiSetara = 0;
        int totalSKS = 0;

        for (int i = 0; i < jumlahMataKuliah; i++) {
            totalNilaiSetara += nilaiSetara[i] * sks[i];
            totalSKS += sks[i];
        }

        double ipSemester = totalNilaiSetara / totalSKS;

        // Output hasil dalam bentuk tabel
        System.out.println("\n============================================================");
        System.out.println("                      Hasil Konversi Nilai");
        System.out.println("============================================================");
        System.out.printf("%-30s %-10s %-10s %-10s\n", "MK", "Nilai Angka", "Nilai Huruf", "Bobot Nilai");
        System.out.println("------------------------------------------------------------");

        for (int i = 0; i < jumlahMataKuliah; i++) {
            System.out.printf("%-30s %-10.2f %-10s %-10.2f\n", namaMataKuliah[i], nilaiAngka[i], nilaiHuruf[i], nilaiSetara[i]);
        }

        System.out.println("============================================================");
        System.out.printf("IP Semester: %.2f\n", ipSemester);
        System.out.println("============================================================");

        sc.close();
    }

    // Fungsi untuk mengkonversi nilai angka ke huruf
    public static String konversiNilaiHuruf(double nilaiAngka) {
        if (nilaiAngka >= 80) {
            return "A";
        } else if (nilaiAngka >= 73) {
            return "B+";
        } else if (nilaiAngka >= 65) {
            return "B";
        } else if (nilaiAngka >= 60) {
            return "C+";
        } else if (nilaiAngka >= 50) {
            return "C";
        } else if (nilaiAngka >= 39) {
            return "D";
        } else {
            return "E";
        }
    }

    // Fungsi untuk mengkonversi nilai huruf ke nilai setara
    public static double konversiNilaiSetara(String nilaiHuruf) {
        switch (nilaiHuruf) {
            case "A":
                return 4.0;
            case "B+":
                return 3.5;
            case "B":
                return 3.0;
            case "C+":
                return 2.5;
            case "C":
                return 2.0;
            case "D":
                return 1.0;
            case "E":
                return 0.0;
            default:
                return 0.0; // Jika nilai tidak valid
        }
    }
}
