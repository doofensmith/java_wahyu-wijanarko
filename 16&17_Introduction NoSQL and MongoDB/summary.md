# (16&17) Introduction NoSQL and MongoDB
## Summary
Materi pada pembelajaran ini:
1. Definition of NoSQL
2. Rekomendasi penggunaan
3. Tipe - tipe


#### NoSQL
NoSQL merupakan bukan database relational.  
Kelebihan database NoSQL yaitu:
- schema less.
- pembuatan lebih cepat.
- support file berukuran besar.
- support klasterisasi.
  
#### Penggunaan Database NoSQL
Kita bisa menggunakan database NoSQL ketika:
- Membutuhkan skema yang fleksibel.
- Datanya sementara.
- Data catatan atau log data.

#### Tipe - tipe database NoSQL
Database NoSQL memiliki beberapa tipe atau kategori, diantaranya adalah:
1. Key/Value  
Merupakan tipe yang paling simpel, dipasangkan berdasarkan key dan value dengan setiap keynya adalah unique.
2. Column-family  
Penyimpanan datanya per kolom.
3. Graph  
Memodelkan struktur relasi dari data.
4. Document-based  
Menyimpan setiap informasi sebagai dokumen dengan kumpulan dokumennya disebut collection.
5. Geospatial

## Task 1
Berdasarkan database sebelumnya tentang penjualan outlet digital, gunakan perintah CRUD untuk manipulasi data.  
1. Create
    - Insert operator  
        Screenshots:  
        ![operator.png](./screenshots/Screenshot%20(194).png)
    - Insert product_type  
        Screenshot:  
        ![product_type.png](./screenshots/Screenshot%20(195).png)
    - Insert product
        Screenshot:  
        ![product.png](./screenshots/Screenshot%20(196).png)
    - Insert product_description
        Screenshot:
        ![product_desc.png](./screenshots/Screenshot%20(197).png)
    - Insert payment_methods
        Screenshot:
        ![payment_method](./screenshots/Screenshot%20(198).png)
    - Insert users
        Screenshot:
        ![users.png](./screenshots/Screenshot%20(199).png)
    - Insert transaction
        Screenshot:
        ![transaction.png](./screenshots/Screenshot%20(200).png)
    - Insert transaction_detail
        Screenshot:
        ![transaction_detail.png](./screenshots/Screenshot%20(201).png)
  
2. Read
    - User dengan gender laki - laki.
        Screenshot:
        ![read1.png](./screenshots/Screenshot%20(202).png)
    - Product dengan id = 3.
        Screenshot:
        ![read2.png](./screenshots/Screenshot%20(203).png)
    - Jumlah user dengan gender perempuan.
        Screenshot:
        ![read3.png](./screenshots/Screenshot%20(204).png)
    - Data pelanggan dengan urutan abjad.
        Screenshot:
        ![read4.png](./screenshots/Screenshot%20(205).png)
    - Menampilkan 5 data product.
        Screenshot:
        ![read5.png](./screenshots/Screenshot%20(206).png)
  
3. Update
    - Ubah data product id = 1 menjadi product dummy
        Screenshot:
        ![update1.png](./screenshots/Screenshot%20(207).png)
    - Ubah qty = 3 pada transaction detail dengan product id = 1
        Scrrenshot:
        ![update2.png](./screenshots/Screenshot%20(208).png)
  
4. Delete
    - Delete data pada tabel product dengan id = 1
        Screenshot:  
        ![delete1.png](./screenshots/Screenshot%20(209).png)
    - Delete pada tabel product dengan product type id = 1
        Screenshot:  
        ![delete2.png](./screenshots/Screenshot%20(210).png)
        
