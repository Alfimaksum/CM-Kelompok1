import java.util.Scanner;

public class PlatMobil {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Array untuk menyimpan kode plat mobil
        char[] KODE = {'A', 'B', 'D', 'E', 'F', 'G', 'H', 'L', 'N', 'T'};

        // Array untuk menyimpan nama kota yang berpasangan dengan kode plat mobil
        String[] KOTA = {
            "Banten", "Jakarta", "Bandung", "Cirebon", "Bogor",
            "Pekalongan", "Semarang", "Surabaya", "Malang", "Tegal"
        };

        // Menampilkan daftar kode plat mobil dan kota
        System.out.println("Daftar Kode Plat Mobil dan Kota:");
        for (int i = 0; i < KODE.length; i++) {
            System.out.println(KODE[i] + " - " + KOTA[i]);
        }

        // Meminta input kode plat mobil dari pengguna
        System.out.print("\nMasukkan kode plat mobil: ");
        char inputKode = sc.next().charAt(0);
        inputKode = Character.toUpperCase(inputKode); // Mengonversi ke huruf besar

        // Mencari nama kota berdasarkan kode plat mobil
        String kota = cariKota(KODE, KOTA, inputKode);

        // Menampilkan hasil pencarian
        if (kota != null) {
            System.out.println("Kota dengan kode plat " + inputKode + " adalah " + kota);
        } else {
            System.out.println("Kode plat mobil tidak ditemukan.");
        }

        sc.close();
    }

    // Fungsi untuk mencari nama kota berdasarkan kode plat mobil
    public static String cariKota(char[] KODE, String[] KOTA, char inputKode) {
        for (int i = 0; i < KODE.length; i++) {
            if (KODE[i] == inputKode) {
                return KOTA[i];
            }
        }
        return null; // Jika kode plat tidak ditemukan
    }
}