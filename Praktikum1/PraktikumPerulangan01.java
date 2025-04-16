import java.util.Scanner;

public class PraktikumPerulangan01 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Meminta input NIM dari pengguna
        System.out.print("Input NIM: ");
        String nim = sc.nextLine();

        // Mengambil 2 digit terakhir NIM
        int n = Integer.parseInt(nim.substring(nim.length() - 2));

        // Jika n < 10, tambahkan 10
        if (n < 10) {
            n += 10;
        }

        // Menampilkan deret bilangan       
        System.out.print("Output: ");
        for (int i = 1; i <= n; i++) {
            if (i == 6 || i == 10) {
                continue; // Lewati angka 6 dan 10
            }
            if (i % 2 == 1) {
                System.out.print("*  "); // Angka ganjil dicetak dengan *
            } else {
                System.out.print(i + "  "); // Angka genap dicetak sesuai bilangan aslinya
            }
        }
    }
}