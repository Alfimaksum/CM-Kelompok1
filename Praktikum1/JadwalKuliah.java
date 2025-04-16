import java.util.Scanner;

public class JadwalKuliah {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Meminta jumlah mata kuliah
        System.out.print("Masukkan jumlah mata kuliah: ");
        int n = sc.nextInt();
        sc.nextLine(); // Membersihkan newline

        // Array untuk menyimpan data mata kuliah
        String[] namaMataKuliah = new String[n];
        int[] sks = new int[n];
        int[] semester = new int[n];
        String[] hariKuliah = new String[n];

        // Input data mata kuliah
        for (int i = 0; i < n; i++) {
            System.out.println("\nMasukkan data mata kuliah ke-" + (i + 1));
            System.out.print("Nama Mata Kuliah: ");
            namaMataKuliah[i] = sc.nextLine();
            System.out.print("SKS          : ");
            sks[i] = sc.nextInt();
            System.out.print("Semester     : ");
            semester[i] = sc.nextInt();
            sc.nextLine(); // Membersihkan newline
            System.out.print("Hari Kuliah  : ");
            hariKuliah[i] = sc.nextLine();
        }

        // Menampilkan menu
        while (true) {
            System.out.println("\n====================================");
            System.out.println("   Menu Manajemen Jadwal Kuliah");
            System.out.println("====================================");
            System.out.println("1. Tampilkan Seluruh Jadwal Kuliah");
            System.out.println("2. Tampilkan Jadwal Kuliah Berdasarkan Hari");
            System.out.println("3. Tampilkan Jadwal Kuliah Berdasarkan Semester");
            System.out.println("4. Cari Mata Kuliah Berdasarkan Nama");
            System.out.println("5. Keluar");
            System.out.println("====================================");
            System.out.print("Pilih menu (1/2/3/4/5): ");
            int pilihan = sc.nextInt();
            sc.nextLine(); // Membersihkan newline

            switch (pilihan) {
                case 1:
                    tampilkanSeluruhJadwal(namaMataKuliah, sks, semester, hariKuliah);
                    break;
                case 2:
                    System.out.print("Masukkan hari: ");
                    String hari = sc.nextLine();
                    tampilkanJadwalBerdasarkanHari(namaMataKuliah, sks, semester, hariKuliah, hari);
                    break;
                case 3:
                    System.out.print("Masukkan semester: ");
                    int sem = sc.nextInt();
                    tampilkanJadwalBerdasarkanSemester(namaMataKuliah, sks, semester, hariKuliah, sem);
                    break;
                case 4:
                    System.out.print("Masukkan nama mata kuliah: ");
                    String nama = sc.nextLine();
                    cariMataKuliah(namaMataKuliah, sks, semester, hariKuliah, nama);
                    break;
                case 5:
                    System.out.println("Terima kasih telah menggunakan program ini.");
                    sc.close();
                    return;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }

    // Fungsi untuk menampilkan seluruh jadwal kuliah
    public static void tampilkanSeluruhJadwal(String[] namaMataKuliah, int[] sks, int[] semester, String[] hariKuliah) {
        System.out.println("\nSeluruh Jadwal Kuliah:");
        System.out.printf("%-20s %-5s %-10s %-10s\n", "Nama Mata Kuliah", "SKS", "Semester", "Hari");
        for (int i = 0; i < namaMataKuliah.length; i++) {
            System.out.printf("%-20s %-5d %-10d %-10s\n", namaMataKuliah[i], sks[i], semester[i], hariKuliah[i]);
        }
    }

    // Fungsi untuk menampilkan jadwal kuliah berdasarkan hari
    public static void tampilkanJadwalBerdasarkanHari(String[] namaMataKuliah, int[] sks, int[] semester, String[] hariKuliah, String hari) {
        System.out.println("\nJadwal Kuliah pada Hari " + hari + ":");
        System.out.printf("%-20s %-5s %-10s %-10s\n", "Nama Mata Kuliah", "SKS", "Semester", "Hari");
        for (int i = 0; i < namaMataKuliah.length; i++) {
            if (hariKuliah[i].equalsIgnoreCase(hari)) {
                System.out.printf("%-20s %-5d %-10d %-10s\n", namaMataKuliah[i], sks[i], semester[i], hariKuliah[i]);
            }
        }
    }

    // Fungsi untuk menampilkan jadwal kuliah berdasarkan semester
    public static void tampilkanJadwalBerdasarkanSemester(String[] namaMataKuliah, int[] sks, int[] semester, String[] hariKuliah, int sem) {
        System.out.println("\nJadwal Kuliah pada Semester " + sem + ":");
        System.out.printf("%-20s %-5s %-10s %-10s\n", "Nama Mata Kuliah", "SKS", "Semester", "Hari");
        for (int i = 0; i < namaMataKuliah.length; i++) {
            if (semester[i] == sem) {
                System.out.printf("%-20s %-5d %-10d %-10s\n", namaMataKuliah[i], sks[i], semester[i], hariKuliah[i]);
            }
        }
    }

    // Fungsi untuk mencari mata kuliah berdasarkan nama
    public static void cariMataKuliah(String[] namaMataKuliah, int[] sks, int[] semester, String[] hariKuliah, String nama) {
        System.out.println("\nHasil Pencarian Mata Kuliah '" + nama + "':");
        System.out.printf("%-20s %-5s %-10s %-10s\n", "Nama Mata Kuliah", "SKS", "Semester", "Hari");
        for (int i = 0; i < namaMataKuliah.length; i++) {
            if (namaMataKuliah[i].equalsIgnoreCase(nama)) {
                System.out.printf("%-20s %-5d %-10d %-10s\n", namaMataKuliah[i], sks[i], semester[i], hariKuliah[i]);
            }
        }
    }
}