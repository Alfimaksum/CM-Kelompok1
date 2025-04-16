import java.util.Scanner;

public class Kubus {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Menampilkan menu pilihan
        System.out.println("====================================");
        System.out.println("   Program Menghitung Kubus");
        System.out.println("====================================");
        System.out.println("1. Hitung Volume Kubus");
        System.out.println("2. Hitung Luas Permukaan Kubus");
        System.out.println("3. Hitung Keliling Kubus");
        System.out.println("4. Keluar");
        System.out.println("====================================");

        // Meminta pilihan menu dari pengguna
        System.out.print("Pilih menu (1/2/3/4): ");
        int pilihan = sc.nextInt();

        if (pilihan >= 1 && pilihan <= 3) {
            // Meminta input panjang rusuk kubus
            System.out.print("Masukkan panjang rusuk kubus: ");
            double rusuk = sc.nextDouble();

            // Memanggil fungsi sesuai pilihan pengguna
            switch (pilihan) {
                case 1:
                    double volume = hitungVolume(rusuk);
                    System.out.println("Volume Kubus: " + volume);
                    break;
                case 2:
                    double luasPermukaan = hitungLuasPermukaan(rusuk);
                    System.out.println("Luas Permukaan Kubus: " + luasPermukaan);
                    break;
                case 3:
                    double keliling = hitungKeliling(rusuk);
                    System.out.println("Keliling Kubus: " + keliling);
                    break;
            }
        } else if (pilihan == 4) {
            System.out.println("Terima kasih telah menggunakan program ini.");
        } else {
            System.out.println("Pilihan tidak valid.");
        }

        sc.close();
    }

    // Fungsi untuk menghitung volume kubus
    public static double hitungVolume(double rusuk) {
        return Math.pow(rusuk, 3);
    }

    // Fungsi untuk menghitung luas permukaan kubus
    public static double hitungLuasPermukaan(double rusuk) {
        return 6 * Math.pow(rusuk, 2);
    }

    // Fungsi untuk menghitung keliling kubus
    public static double hitungKeliling(double rusuk) {
        return 12 * rusuk;
    }
}