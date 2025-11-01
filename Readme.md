# 🍽️ Aplikasi Restoran Makanan

## 📖 Deskripsi Program

Program ini adalah aplikasi restoran sederhana yang dibuat dengan Java untuk membantu proses pemesanan makanan dan minuman. Program ini dapat menampilkan menu, menerima pesanan dari pelanggan, menghitung total biaya dengan berbagai komponen (pajak, biaya pelayanan, diskon, dan promo), lalu mencetak struk pembayaran yang rapi.

### Tujuan Program:
- Memudahkan pelanggan dalam memesan makanan/minuman
- Menghitung total biaya secara otomatis
- Memberikan promo dan diskon sesuai ketentuan
- Menampilkan struk pembayaran yang jelas dan terstruktur

---

## 🏗️ Struktur Program

Program ini terdiri dari **2 class utama**:

### 1. **Class Menu** (`Menu.java`)
Class ini merepresentasikan **satu item menu** di restoran.

**Atribut:**
- `nama` (String) → Nama menu (contoh: "Nasi Padang")
- `harga` (int) → Harga menu dalam Rupiah
- `kategori` (String) → Kategori menu ("Makanan" atau "Minuman")

**Method:**
- `Menu(String nama, int harga, String kategori)` → Constructor untuk membuat objek menu baru
- `getNama()` → Mengambil nama menu
- `getHarga()` → Mengambil harga menu
- `getKategori()` → Mengambil kategori menu
- `tampilkanMenu(int nomor)` → Menampilkan informasi menu dengan format rapi

### 2. **Class Main** (`Main.java`)
Class ini berisi **logika utama program** dan mengatur alur pemesanan.

**Fungsi Utama:**
- Menginisialisasi daftar menu restoran
- Menampilkan menu kepada pelanggan
- Menerima input pesanan dari user
- Menghitung total biaya, pajak, diskon, dan promo
- Mencetak struk pembayaran

**Method-method Penting:**
- `hitungSubtotal()` → Menghitung total harga pesanan sebelum pajak
- `hitungPajak()` → Menghitung pajak 10% dari subtotal
- `hitungDiskon()` → Menghitung diskon 10% jika syarat terpenuhi
- `hitungPromoMinuman()` → Menghitung jumlah minuman gratis (promo beli 1 gratis 1)
- `hitungHargaMinumanTermurah()` → Mencari harga minuman termurah untuk perhitungan promo
- `cetakStruk()` → Mencetak struk pembayaran lengkap

---

## 💰 Logika Perhitungan Biaya

### 1. **Subtotal**
Subtotal adalah total harga semua pesanan sebelum ditambah biaya lain.
```
Subtotal = (Harga Menu 1 × Jumlah) + (Harga Menu 2 × Jumlah) + ...
```

### 2. **Pajak**
Pajak dihitung sebesar **10%** dari subtotal.
```
Pajak = Subtotal × 10%
```

### 3. **Biaya Pelayanan**
Biaya pelayanan bersifat **tetap** sebesar **Rp 20.000**.

### 4. **Promo Minuman (Beli 1 Gratis 1)**
Promo ini berlaku jika **subtotal melebihi Rp 50.000**.
- Program menghitung total minuman yang dipesan
- Setiap 2 minuman, 1 minuman gratis (diambil yang termurah)
- Contoh: Pesan 3 minuman → dapat 1 gratis

**Cara Kerja:**
```
Jumlah Minuman Gratis = Total Minuman yang Dipesan / 2
Potongan Promo = Jumlah Minuman Gratis × Harga Minuman Termurah
```

### 5. **Diskon 10%**
Diskon 10% diberikan jika **total biaya (setelah pajak + biaya pelayanan - promo minuman) melebihi Rp 100.000**.
```
Diskon = Total Sebelum Diskon × 10%
```

### 6. **Total Akhir**
```
Total Akhir = Subtotal + Pajak + Biaya Pelayanan - Promo Minuman - Diskon
```

---

## 🔄 Alur Eksekusi Program

Berikut adalah langkah-langkah yang terjadi saat program dijalankan:

1. **Inisialisasi Data Menu**
   - Program membuat array berisi 4 menu (2 makanan + 2 minuman)
   - Setiap menu berupa objek dari class `Menu`

2. **Menampilkan Daftar Menu**
   - Program menampilkan semua menu yang tersedia dengan nomor, nama, harga, dan kategori

3. **Input Jumlah Item yang Dipesan**
   - User menginput berapa item yang ingin dipesan (maksimal 4)
   - Program memvalidasi input (minimal 1, maksimal 4)

4. **Input Detail Pesanan**
   - Untuk setiap item yang dipesan, user memasukkan:
     - Nomor menu yang dipilih (1-4)
     - Jumlah pesanan
   - Data disimpan dalam array `pilihanMenu` dan `jumlahPesanan`

5. **Menghitung Subtotal**
   - Program menghitung total harga dari semua pesanan

6. **Menghitung Pajak**
   - Pajak 10% dihitung dari subtotal

7. **Cek Promo Minuman**
   - Jika subtotal > Rp 50.000, program menghitung promo beli 1 gratis 1 untuk minuman
   - Potongan promo dihitung berdasarkan harga minuman termurah

8. **Menghitung Total Sebelum Diskon**
   - Total = Subtotal + Pajak + Biaya Pelayanan - Promo Minuman

9. **Cek Diskon**
   - Jika total sebelum diskon > Rp 100.000, diskon 10% diberikan

10. **Menghitung Total Akhir**
    - Total Akhir = Total Sebelum Diskon - Diskon

11. **Mencetak Struk**
    - Program menampilkan struk pembayaran lengkap dengan format yang rapi

---

## 📝 Contoh Input dan Output

### **Contoh 1: Pemesanan Sederhana**

**Input:**
```
Berapa item yang ingin Anda pesan (maksimal 4)? 2

--- Pesanan ke-1 ---
Pilih nomor menu (1-20): 1
Jumlah: 2

--- Pesanan ke-2 ---
Pilih nomor menu (1-20): 11
Jumlah: 1
```

**Output:**
```
========================================
        STRUK PEMESANAN                 
========================================
Nasi Padang          x2  = Rp 50,000
Es Teh               x1  = Rp 5,000
----------------------------------------
Subtotal             = Rp 55,000
Pajak (10%)          = Rp 5,500
Biaya Pelayanan      = Rp 20,000
Promo Minuman        = -Rp 5,000
========================================
TOTAL BAYAR          = Rp 75,500
========================================
```

**Penjelasan:**
- Subtotal = Rp 55.000
- Pajak = Rp 5.500 (10% dari subtotal)
- Biaya Pelayanan = Rp 20.000
- Promo Minuman = -Rp 5.000 (karena subtotal > Rp 50.000, dapat 1 minuman gratis)
- Total = Rp 75.500 (tidak dapat diskon karena < Rp 100.000)

---

### **Contoh 2: Pemesanan dengan Diskon**

**Input:**
```
Berapa item yang ingin Anda pesan (maksimal 4)? 3

--- Pesanan ke-1 ---
Pilih nomor menu (1-20): 1
Jumlah: 3

--- Pesanan ke-2 ---
Pilih nomor menu (1-20): 2
Jumlah: 2

--- Pesanan ke-3 ---
Pilih nomor menu (1-20): 12
Jumlah: 2
```

**Output:**
```
========================================
        STRUK PEMESANAN                 
========================================
Nasi Padang          x3  = Rp 75,000
Mie Goreng           x2  = Rp 40,000
Jus Jeruk            x2  = Rp 20,000
----------------------------------------
Subtotal             = Rp 135,000
Pajak (10%)          = Rp 13,500
Biaya Pelayanan      = Rp 20,000
Promo Minuman        = -Rp 10,000
Diskon (10%)         = -Rp 15,850
========================================
TOTAL BAYAR          = Rp 142,650
========================================
```

**Penjelasan:**
- Subtotal = Rp 135.000
- Pajak = Rp 13.500
- Biaya Pelayanan = Rp 20.000
- Promo Minuman = -Rp 10.000 (2 minuman dipesan, dapat 1 gratis @ Rp 10.000)
- Total Sebelum Diskon = Rp 158.500
- Diskon = -Rp 15.850 (karena total > Rp 100.000, dapat diskon 10%)
- Total Akhir = Rp 142.650

---

## 🚀 Cara Menjalankan Program

### **1. Instalasi Java di Windows**

Jika Anda belum menginstall Java, ikuti langkah berikut:

#### **A. Download JDK**
1. Buka browser dan kunjungi: https://www.oracle.com/java/technologies/downloads/
2. Pilih versi **Java SE Development Kit** (JDK) terbaru untuk Windows
3. Download installer sesuai sistem Anda:
   - **Windows x64 Installer** (untuk Windows 64-bit)
   - **Windows x86 Installer** (untuk Windows 32-bit)

#### **B. Install JDK**
1. Jalankan file installer yang sudah didownload (contoh: `jdk-21_windows-x64_bin.exe`)
2. Klik **Next** pada welcome screen
3. Pilih lokasi instalasi (default: `C:\Program Files\Java\jdk-21\`)
4. Klik **Next** dan tunggu proses instalasi selesai
5. Klik **Close** setelah instalasi selesai

#### **C. Setting Environment Variable (PATH)**
Agar bisa menjalankan Java dari Command Prompt, Anda perlu menambahkan Java ke PATH:

1. **Buka System Properties:**
   - Tekan `Windows + R`
   - Ketik `sysdm.cpl` lalu tekan Enter
   - Atau: Klik kanan **This PC** → **Properties** → **Advanced system settings**

2. **Edit Environment Variables:**
   - Klik tab **Advanced**
   - Klik tombol **Environment Variables...**

3. **Edit PATH:**
   - Di bagian **System variables**, cari variabel bernama **Path**
   - Klik **Path**, lalu klik **Edit...**
   - Klik **New** dan tambahkan path JDK Anda:
     ```
     C:\Program Files\Java\jdk-21\bin
     ```
     *(Sesuaikan dengan lokasi instalasi JDK Anda)*
   - Klik **OK** pada semua dialog

4. **Restart Command Prompt** (jika sudah terbuka)

#### **D. Verifikasi Instalasi**
Buka **Command Prompt** (CMD) dan jalankan:
```bash
java -version
javac -version
```

Jika muncul informasi versi Java, instalasi berhasil! ✅

Contoh output:
```
java version "21.0.1" 2023-10-17 LTS
Java(TM) SE Runtime Environment (build 21.0.1+12-LTS-29)
```

### **2. Persiapan**
Pastikan Anda sudah menginstall **Java Development Kit (JDK)** di komputer Anda.

Cek versi Java dengan perintah:
```bash
java -version
```

### **3. Kompilasi Program**
Buka **Command Prompt** (CMD):
- Tekan `Windows + R`
- Ketik `cmd` lalu tekan Enter

Masuk ke folder tempat file `Menu.java` dan `Main.java` berada:
```bash
cd C:\Users\NamaAnda\Documents\JavaProject
```
*(Sesuaikan dengan lokasi folder Anda)*

Lalu jalankan perintah kompilasi:
```bash
javac Menu.java Main.java
```

Perintah ini akan mengkompilasi kedua file dan menghasilkan file `.class`.

**Tips:** Jika muncul error "javac is not recognized", pastikan PATH sudah di-setting dengan benar (lihat langkah instalasi di atas).

### **4. Menjalankan Program**
Setelah kompilasi berhasil, jalankan program dengan perintah:

```bash
java Main
```

### **5. Menggunakan Program**
- Program akan menampilkan daftar menu
- Ikuti instruksi yang muncul di layar
- Masukkan jumlah item yang ingin dipesan
- Masukkan nomor menu dan jumlah untuk setiap pesanan
- Program akan menampilkan struk pembayaran otomatis

---

## 🎯 Fitur Khusus Program

✅ **Tidak menggunakan loop (for/while)** → Semua logika dibuat dengan struktur keputusan `if`  
✅ **Penggunaan array** → Data menu dan pesanan disimpan dalam array  
✅ **Penggunaan class dan object** → Konsep OOP diterapkan dengan baik  
✅ **Penggunaan method** → Kode modular dan mudah dipahami  
✅ **Validasi input** → Program memeriksa input user agar tidak error  
✅ **Format struk rapi** → Menggunakan `printf` untuk formatting yang bagus  
✅ **Perhitungan otomatis** → Pajak, promo, dan diskon dihitung secara otomatis  

---

## 📚 Konsep Java yang Digunakan

1. **Class dan Object** → Menu.java sebagai blueprint, objek menu sebagai instance
2. **Array** → Menyimpan daftar menu dan pesanan
3. **Method** → Memecah logika program menjadi fungsi-fungsi kecil
4. **Struktur Keputusan (if/else)** → Menentukan promo dan diskon
5. **Scanner** → Menerima input dari user
6. **Tipe Data** → int untuk harga, String untuk nama/kategori
7. **Getter Method** → Mengakses atribut private dari class Menu
8. **Pemformatan Output** → Menggunakan printf untuk tampilan rapi

**Selamat menggunakan aplikasi restoran! 🍽️**

[Frugaldev](https://frugaldev.biz.id)