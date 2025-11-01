public class Menu {
    // Atribut untuk menyimpan data menu
    private String nama;
    private int harga;
    private String kategori;
    
    // Constructor untuk membuat objek Menu
    public Menu(String nama, int harga, String kategori) {
        this.nama = nama;
        this.harga = harga;
        this.kategori = kategori;
    }
    
    // Getter untuk mengambil nama menu
    public String getNama() {
        return nama;
    }
    
    // Getter untuk mengambil harga menu
    public int getHarga() {
        return harga;
    }
    
    // Getter untuk mengambil kategori menu
    public String getKategori() {
        return kategori;
    }
    
    // Method untuk menampilkan informasi menu
    public void tampilkanMenu(int nomor) {
        System.out.println(nomor + ". " + nama + " - Rp " + harga + " (" + kategori + ")");
    }
}
