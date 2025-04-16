public class PraktikumFungsi01 {

    // Data stok bunga untuk setiap cabang
    private static int[][] stockBunga = {
        {10, 5, 15, 7},  // RoyalGarden 1
        {6, 11, 9, 12},  // RoyalGarden 2
        {2, 10, 10, 5},  // RoyalGarden 3
        {5, 7, 12, 9}   // RoyalGarden 4
    };

    // Harga bunga per jenis
    private static int[] hargaBunga = {75000, 50000, 60000, 10000};

    // Nama bunga
    private static String[] namaBunga = {"Aglonema", "Keladi", "Alocasia", "Mawar"};

    public static void main(String[] args) {
        // Menampilkan pendapatan setiap cabang jika semua bunga habis terjual
        tampilkanPendapatan();

        // Menampilkan stok bunga setelah pengurangan karena bunga mati
        kurangiStock(4, new int[]{1, 2, 0, 5}); // Cabang 4 (RoyalGarden 4)
        tampilkanStock();
    }

    // Fungsi untuk menampilkan pendapatan setiap cabang
    public static void tampilkanPendapatan() {
        System.out.println("Pendapatan Setiap Cabang Jika Semua Bunga Habis Terjual:");
        for (int i = 0; i < stockBunga.length; i++) {
            int pendapatan = hitungPendapatan(i);
            System.out.println("RoyalGarden " + (i + 1) + ": Rp " + pendapatan);
        }
        System.out.println();
    }

    // Fungsi untuk menghitung pendapatan cabang tertentu
    public static int hitungPendapatan(int cabang) {
        int total = 0;
        for (int j = 0; j < stockBunga[cabang].length; j++) {
            total += stockBunga[cabang][j] * hargaBunga[j];
        }
        return total;
    }

    // Fungsi untuk mengurangi stok bunga karena bunga mati
    public static void kurangiStock(int cabang, int[] pengurangan) {
        for (int j = 0; j < stockBunga[cabang - 1].length; j++) {
            stockBunga[cabang - 1][j] -= pengurangan[j];
        }
    }

    // Fungsi untuk menampilkan stok bunga setiap cabang
    public static void tampilkanStock() {
        System.out.println("Stok Bunga Setelah Pengurangan:");
        System.out.printf("%-15s %-10s %-10s %-10s %-10s\n", "Cabang", "Aglonema", "Keladi", "Alocasia", "Mawar");
        for (int i = 0; i < stockBunga.length; i++) {
            System.out.printf("RoyalGarden %-2d", (i + 1));
            for (int j = 0; j < stockBunga[i].length; j++) {
                System.out.printf(" %-10d", stockBunga[i][j]);
            }
            System.out.println();
        }
    }
}