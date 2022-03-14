# (15) Clean Code
## Summary
Pembelajaran pada materi ini meliputi:
1. Pengertian Clean Code
2. Karakteristik Clean Code
3. Clean Code Principle
4. Refactoring

#### Clean Code
Clean code adalah istilah untuk code yang mudah dipahami, dibaca, dan diubah oleh programmer. Karena dalam penulisan kode yang berhasil dieksekusi belum tentu adalah kode yang bagus. Kode juga sebenarnya harus clean.

##### Why clean code?
Clean code dibutuhkan karena:
1. Bekerja berkolaborasi.
2. Menunjang pengembangan fitur.
3. Pengembangan yang lebih cepat.

#### Karakteristik Clean Code
1. Penamaan mudah dipahami.  
Penamaan harus mudah dipahami, mulai dari penamaan class, variabel, fungsi dan lainnya.  
Bisa menggunakan kaidah yang disarankan pada bahasa pemrograman yang digunakan. Sebagai contoh bahasa Java terdapat beberapa kaidah penamaan seperti:
    - UpperCamelCase : Digunakan untuk penamaan object, class, file
    - lowerCamelCase : Digunakan untuk penamaan Variabel, Fungsi
    - lower_snake_case : Digunakan untuk penamaan package, file
    - UPPER_SNAKE_CASE : Digunakan untuk penamaan variabel final, static, const

2. Mudah dieja dan dipahami.  
Biasakan pemberian variabel atau konstanta pada suatu nilai.
3. Singkat namun mendeskripsikan konteks.
4. Konsisten.
5. Hindari penambahan konteks yang tidak perlu.
6. Komentar.
7. Fungsi.  
Tidak terlalu banyak argumen dalam fungsi yang dibuat.
8. Gunakan konvensi.

##### Saran "formatting"
- lebar baris kode 80 - 120 karakter
- satu class 300 - 500 baris
- memperhatikan indentasi

#### Clean Code Principle
1. KISS  
Keep It So SImple, menhindari membuat fungsi yang dibuat untuk melakukan banyak hal. Biasakan 1 fungsi hanya untuk 1 tugas.
2. DRY  
Don't Repeat Yourself, terlalu sering melakukan duplikasi atau copy paste hal yang sama berulang - ulang.

#### Refactoring
Refactoring adalah proses restrukturisasi kode yang dibuat.

##### Teknik Refactoring
1. Membuat abstraksi.
2. Memecah kode dengan fungsi atau kelas.
3. Memperbaiki penamaan.
4. Mendeteksi duplikasi kode.