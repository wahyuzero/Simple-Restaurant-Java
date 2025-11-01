import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Membuat scanner untuk input user
        Scanner input = new Scanner(System.in);
        
        // Inisialisasi array menu restoran (20 item)
        Menu[] daftarMenu = new Menu[20];
        
        // Menu Makanan
        daftarMenu[0] = new Menu("Nasi Padang", 25000, "Makanan");
        daftarMenu[1] = new Menu("Mie Goreng", 20000, "Makanan");
        daftarMenu[2] = new Menu("Nasi Goreng Spesial", 22000, "Makanan");
        daftarMenu[3] = new Menu("Ayam Bakar", 28000, "Makanan");
        daftarMenu[4] = new Menu("Ayam Penyet", 23000, "Makanan");
        daftarMenu[5] = new Menu("Soto Ayam", 18000, "Makanan");
        daftarMenu[6] = new Menu("Gado-Gado", 17000, "Makanan");
        daftarMenu[7] = new Menu("Bakso Spesial", 19000, "Makanan");
        daftarMenu[8] = new Menu("Sate Ayam (10 tusuk)", 30000, "Makanan");
        daftarMenu[9] = new Menu("Nasi Uduk Komplit", 20000, "Makanan");
        
        // Menu Minuman
        daftarMenu[10] = new Menu("Es Teh", 5000, "Minuman");
        daftarMenu[11] = new Menu("Jus Jeruk", 10000, "Minuman");
        daftarMenu[12] = new Menu("Es Campur", 12000, "Minuman");
        daftarMenu[13] = new Menu("Jus Alpukat", 13000, "Minuman");
        daftarMenu[14] = new Menu("Es Kelapa Muda", 11000, "Minuman");
        daftarMenu[15] = new Menu("Teh Tarik", 8000, "Minuman");
        daftarMenu[16] = new Menu("Kopi Susu", 9000, "Minuman");
        daftarMenu[17] = new Menu("Jus Mangga", 12000, "Minuman");
        daftarMenu[18] = new Menu("Es Cincau", 7000, "Minuman");
        daftarMenu[19] = new Menu("Air Mineral", 3000, "Minuman");
        
        // Array untuk menyimpan pesanan (maksimal 4 item)
        int[] pilihanMenu = new int[4];
        int[] jumlahPesanan = new int[4];
        int totalItemPesan = 0;
        
        // Menampilkan header program
        System.out.println("========================================");
        System.out.println("   SELAMAT DATANG DI RESTORAN PAK ARIF   ");
        System.out.println("========================================");
        System.out.println();
        
        // Menampilkan daftar menu
        System.out.println("===== DAFTAR MENU =====");
        System.out.println();
        System.out.println(">>> MENU MAKANAN <<<");
        daftarMenu[0].tampilkanMenu(1);
        daftarMenu[1].tampilkanMenu(2);
        daftarMenu[2].tampilkanMenu(3);
        daftarMenu[3].tampilkanMenu(4);
        daftarMenu[4].tampilkanMenu(5);
        daftarMenu[5].tampilkanMenu(6);
        daftarMenu[6].tampilkanMenu(7);
        daftarMenu[7].tampilkanMenu(8);
        daftarMenu[8].tampilkanMenu(9);
        daftarMenu[9].tampilkanMenu(10);
        System.out.println();
        System.out.println(">>> MENU MINUMAN <<<");
        daftarMenu[10].tampilkanMenu(11);
        daftarMenu[11].tampilkanMenu(12);
        daftarMenu[12].tampilkanMenu(13);
        daftarMenu[13].tampilkanMenu(14);
        daftarMenu[14].tampilkanMenu(15);
        daftarMenu[15].tampilkanMenu(16);
        daftarMenu[16].tampilkanMenu(17);
        daftarMenu[17].tampilkanMenu(18);
        daftarMenu[18].tampilkanMenu(19);
        daftarMenu[19].tampilkanMenu(20);
        System.out.println("=======================");
        System.out.println();
        
        // Input jumlah item yang ingin dipesan
        System.out.print("Berapa item yang ingin Anda pesan (maksimal 4)? ");
        totalItemPesan = input.nextInt();
        
        // Validasi jumlah pesanan
        if (totalItemPesan > 4) {
            System.out.println("Maaf, maksimal 4 item!");
            totalItemPesan = 4;
        } else if (totalItemPesan < 1) {
            System.out.println("Minimal pesan 1 item!");
            totalItemPesan = 1;
        }
        
        System.out.println();
        
        // Input pesanan dari user (tanpa loop, manual untuk setiap item)
        if (totalItemPesan >= 1) {
            System.out.println("--- Pesanan ke-1 ---");
            System.out.print("Pilih nomor menu (1-20): ");
            pilihanMenu[0] = input.nextInt();
            System.out.print("Jumlah: ");
            jumlahPesanan[0] = input.nextInt();
        }
        
        if (totalItemPesan >= 2) {
            System.out.println("--- Pesanan ke-2 ---");
            System.out.print("Pilih nomor menu (1-20): ");
            pilihanMenu[1] = input.nextInt();
            System.out.print("Jumlah: ");
            jumlahPesanan[1] = input.nextInt();
        }
        
        if (totalItemPesan >= 3) {
            System.out.println("--- Pesanan ke-3 ---");
            System.out.print("Pilih nomor menu (1-20): ");
            pilihanMenu[2] = input.nextInt();
            System.out.print("Jumlah: ");
            jumlahPesanan[2] = input.nextInt();
        }
        
        if (totalItemPesan >= 4) {
            System.out.println("--- Pesanan ke-4 ---");
            System.out.print("Pilih nomor menu (1-20): ");
            pilihanMenu[3] = input.nextInt();
            System.out.print("Jumlah: ");
            jumlahPesanan[3] = input.nextInt();
        }
        
        // Menghitung subtotal
        int subtotal = hitungSubtotal(daftarMenu, pilihanMenu, jumlahPesanan, totalItemPesan);
        
        // Menghitung pajak 10%
        int pajak = hitungPajak(subtotal);
        
        // Biaya pelayanan
        int biayaPelayanan = 20000;
        
        // Cek promo minuman (beli 1 gratis 1)
        int jumlahMinumanGratis = 0;
        if (subtotal > 50000) {
            jumlahMinumanGratis = hitungPromoMinuman(daftarMenu, pilihanMenu, jumlahPesanan, totalItemPesan);
        }
        int potonganPromoMinuman = jumlahMinumanGratis * hitungHargaMinumanTermurah(daftarMenu, pilihanMenu, jumlahPesanan, totalItemPesan);
        
        // Total sebelum diskon
        int totalSebelumDiskon = subtotal + pajak + biayaPelayanan - potonganPromoMinuman;
        
        // Cek diskon 10% jika total > 100.000
        int diskon = 0;
        if (totalSebelumDiskon > 100000) {
            diskon = hitungDiskon(totalSebelumDiskon);
        }
        
        // Total akhir
        int totalAkhir = totalSebelumDiskon - diskon;
        
        // Menampilkan struk
        cetakStruk(daftarMenu, pilihanMenu, jumlahPesanan, totalItemPesan, subtotal, pajak, biayaPelayanan, potonganPromoMinuman, diskon, totalAkhir);
        
        input.close();
    }
    
    // Method untuk menghitung subtotal pesanan
    public static int hitungSubtotal(Menu[] daftarMenu, int[] pilihanMenu, int[] jumlahPesanan, int totalItem) {
        int subtotal = 0;
        
        if (totalItem >= 1) {
            int indexMenu = pilihanMenu[0] - 1;
            if (indexMenu >= 0 && indexMenu < 20) {
                subtotal = subtotal + (daftarMenu[indexMenu].getHarga() * jumlahPesanan[0]);
            }
        }
        
        if (totalItem >= 2) {
            int indexMenu = pilihanMenu[1] - 1;
            if (indexMenu >= 0 && indexMenu < 20) {
                subtotal = subtotal + (daftarMenu[indexMenu].getHarga() * jumlahPesanan[1]);
            }
        }
        
        if (totalItem >= 3) {
            int indexMenu = pilihanMenu[2] - 1;
            if (indexMenu >= 0 && indexMenu < 20) {
                subtotal = subtotal + (daftarMenu[indexMenu].getHarga() * jumlahPesanan[2]);
            }
        }
        
        if (totalItem >= 4) {
            int indexMenu = pilihanMenu[3] - 1;
            if (indexMenu >= 0 && indexMenu < 20) {
                subtotal = subtotal + (daftarMenu[indexMenu].getHarga() * jumlahPesanan[3]);
            }
        }
        
        return subtotal;
    }
    
    // Method untuk menghitung pajak 10%
    public static int hitungPajak(int subtotal) {
        return subtotal * 10 / 100;
    }
    
    // Method untuk menghitung diskon 10%
    public static int hitungDiskon(int total) {
        return total * 10 / 100;
    }
    
    // Method untuk menghitung promo minuman (beli 1 gratis 1)
    public static int hitungPromoMinuman(Menu[] daftarMenu, int[] pilihanMenu, int[] jumlahPesanan, int totalItem) {
        int totalMinuman = 0;
        
        if (totalItem >= 1) {
            int indexMenu = pilihanMenu[0] - 1;
            if (indexMenu >= 0 && indexMenu < 20) {
                if (daftarMenu[indexMenu].getKategori().equals("Minuman")) {
                    totalMinuman = totalMinuman + jumlahPesanan[0];
                }
            }
        }
        
        if (totalItem >= 2) {
            int indexMenu = pilihanMenu[1] - 1;
            if (indexMenu >= 0 && indexMenu < 20) {
                if (daftarMenu[indexMenu].getKategori().equals("Minuman")) {
                    totalMinuman = totalMinuman + jumlahPesanan[1];
                }
            }
        }
        
        if (totalItem >= 3) {
            int indexMenu = pilihanMenu[2] - 1;
            if (indexMenu >= 0 && indexMenu < 20) {
                if (daftarMenu[indexMenu].getKategori().equals("Minuman")) {
                    totalMinuman = totalMinuman + jumlahPesanan[2];
                }
            }
        }
        
        if (totalItem >= 4) {
            int indexMenu = pilihanMenu[3] - 1;
            if (indexMenu >= 0 && indexMenu < 20) {
                if (daftarMenu[indexMenu].getKategori().equals("Minuman")) {
                    totalMinuman = totalMinuman + jumlahPesanan[3];
                }
            }
        }
        
        // Beli 1 gratis 1, jadi jumlah gratis = total minuman / 2
        return totalMinuman / 2;
    }
    
    // Method untuk mencari harga minuman termurah (untuk perhitungan promo)
    public static int hitungHargaMinumanTermurah(Menu[] daftarMenu, int[] pilihanMenu, int[] jumlahPesanan, int totalItem) {
        int hargaMinumanTermurah = 999999;
        boolean adaMinuman = false;
        
        if (totalItem >= 1) {
            int indexMenu = pilihanMenu[0] - 1;
            if (indexMenu >= 0 && indexMenu < 20) {
                if (daftarMenu[indexMenu].getKategori().equals("Minuman")) {
                    if (daftarMenu[indexMenu].getHarga() < hargaMinumanTermurah) {
                        hargaMinumanTermurah = daftarMenu[indexMenu].getHarga();
                        adaMinuman = true;
                    }
                }
            }
        }
        
        if (totalItem >= 2) {
            int indexMenu = pilihanMenu[1] - 1;
            if (indexMenu >= 0 && indexMenu < 20) {
                if (daftarMenu[indexMenu].getKategori().equals("Minuman")) {
                    if (daftarMenu[indexMenu].getHarga() < hargaMinumanTermurah) {
                        hargaMinumanTermurah = daftarMenu[indexMenu].getHarga();
                        adaMinuman = true;
                    }
                }
            }
        }
        
        if (totalItem >= 3) {
            int indexMenu = pilihanMenu[2] - 1;
            if (indexMenu >= 0 && indexMenu < 20) {
                if (daftarMenu[indexMenu].getKategori().equals("Minuman")) {
                    if (daftarMenu[indexMenu].getHarga() < hargaMinumanTermurah) {
                        hargaMinumanTermurah = daftarMenu[indexMenu].getHarga();
                        adaMinuman = true;
                    }
                }
            }
        }
        
        if (totalItem >= 4) {
            int indexMenu = pilihanMenu[3] - 1;
            if (indexMenu >= 0 && indexMenu < 20) {
                if (daftarMenu[indexMenu].getKategori().equals("Minuman")) {
                    if (daftarMenu[indexMenu].getHarga() < hargaMinumanTermurah) {
                        hargaMinumanTermurah = daftarMenu[indexMenu].getHarga();
                        adaMinuman = true;
                    }
                }
            }
        }
        
        if (adaMinuman) {
            return hargaMinumanTermurah;
        } else {
            return 0;
        }
    }
    
    // Method untuk mencetak struk
    public static void cetakStruk(Menu[] daftarMenu, int[] pilihanMenu, int[] jumlahPesanan, int totalItem, int subtotal, int pajak, int biayaPelayanan, int potonganPromo, int diskon, int totalAkhir) {
        System.out.println();
        System.out.println("========================================");
        System.out.println("        STRUK PEMESANAN                 ");
        System.out.println("========================================");
        
        // Menampilkan item pesanan
        if (totalItem >= 1) {
            int indexMenu = pilihanMenu[0] - 1;
            if (indexMenu >= 0 && indexMenu < 20) {
                int hargaItem = daftarMenu[indexMenu].getHarga() * jumlahPesanan[0];
                System.out.printf("%-20s x%-2d = Rp %,d%n", daftarMenu[indexMenu].getNama(), jumlahPesanan[0], hargaItem);
            }
        }
        
        if (totalItem >= 2) {
            int indexMenu = pilihanMenu[1] - 1;
            if (indexMenu >= 0 && indexMenu < 20) {
                int hargaItem = daftarMenu[indexMenu].getHarga() * jumlahPesanan[1];
                System.out.printf("%-20s x%-2d = Rp %,d%n", daftarMenu[indexMenu].getNama(), jumlahPesanan[1], hargaItem);
            }
        }
        
        if (totalItem >= 3) {
            int indexMenu = pilihanMenu[2] - 1;
            if (indexMenu >= 0 && indexMenu < 20) {
                int hargaItem = daftarMenu[indexMenu].getHarga() * jumlahPesanan[2];
                System.out.printf("%-20s x%-2d = Rp %,d%n", daftarMenu[indexMenu].getNama(), jumlahPesanan[2], hargaItem);
            }
        }
        
        if (totalItem >= 4) {
            int indexMenu = pilihanMenu[3] - 1;
            if (indexMenu >= 0 && indexMenu < 20) {
                int hargaItem = daftarMenu[indexMenu].getHarga() * jumlahPesanan[3];
                System.out.printf("%-20s x%-2d = Rp %,d%n", daftarMenu[indexMenu].getNama(), jumlahPesanan[3], hargaItem);
            }
        }
        
        System.out.println("----------------------------------------");
        System.out.printf("Subtotal             = Rp %,d%n", subtotal);
        System.out.printf("Pajak (10%%)          = Rp %,d%n", pajak);
        System.out.printf("Biaya Pelayanan      = Rp %,d%n", biayaPelayanan);
        
        if (potonganPromo > 0) {
            System.out.printf("Promo Minuman        = -Rp %,d%n", potonganPromo);
        }
        
        if (diskon > 0) {
            System.out.printf("Diskon (10%%)         = -Rp %,d%n", diskon);
        }
        
        System.out.println("========================================");
        System.out.printf("TOTAL BAYAR          = Rp %,d%n", totalAkhir);
        System.out.println("========================================");
        System.out.println();
        System.out.println("   Terima kasih atas kunjungan Anda!   ");
        System.out.println("========================================");
    }
}
