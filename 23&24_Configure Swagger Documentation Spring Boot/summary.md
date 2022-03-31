# (23&24) Configure Swagger Documentation Spring Boot & JPA (Spring Database SQL)
## Summary
Materi pada section ini meliputi:
1. Dokumentasi API
2. Alasan Membuat Dokumentasi API
3. API Documentation Tools
4. Swagger API Documentation

#### Dokumentasi API
Dokumentasi API adalah konten teknikal untuk mendokumentasi API. Berisi tentang cara - cara untuk mengintegrasikan API.

#### Alasan menggunakan dokumentasi API
Meningkatkan efisiensi pengintegrasian API dan informasi pembaruan.

#### Tools Dokumentasi API
Beberapa contoh tools untuk dokumentasi API:
1. Swagger
2. Postman
3. Apiary
4. Stoplight
5. Redocly

#### Swagger
Alasan menggunakan swagger untuk dokumentasi API:
1. Open Source.
2. Digunakan oleh perusahaan besar.
3. Dokumentasi API yang baik.

## Task 1
#### 1. Membuat CRUD Product
1. Get All Product
![get_all.png](./screenshots/get_all1.png)
2. Create 3 new Product
![create.png](./screenshots/new.png)
  
    Result:  
![res_create.png](./screenshots/result_new.png)

3. Get By Id = 3
![get_id3.png](./screenshots/get_by_id.png)

4. Edit Id = 3
![edit3.png](./screenshots/edit_id3.png)
  
    Result:  
![res_edit.png](./screenshots/result_edit.png)

5. Delete id = 2
![del_3.png](./screenshots/delete_id2.png)
  
    Result:  
![res_del.png](./screenshots/result_delete.png)

#### 2. Membuat dokumentasi API dengan Swagger
Screenshot halaman swagger:
![swagger.png](./screenshots/swagger.png)

## Task 2
#### 1. Penambahan property pada swagger
![swagge_add_property.png](./screenshots/swagger_add_anotation.png)

#### 2. Perubahan database dari H2 menjadi Postgresql dan membuat entity baru.
- Perubahan file [application.properties](./praktikum/springcrud-product/src/main/resources/application.properties)
Screenshot:  
![app.prop.png](./screenshots/applicationproperties.png)  
- Test CRUD Entity Customer:
   1. POST, Membuat Customer baru:  
      Screenshot:  
      ![create_customer.png](./screenshots/create_customer.png)
   2. PUT, Update Customer dengan Id:  
      Screenshot:  
      ![get_customer.png](./screenshots/edit_customer.png)
   3. GET, Melihat Customer dengan Id:  
      Screenshot:  
      ![create_customer.png](./screenshots/read_customer_by_id.png)
   4. DELETE, Menghapus Customer dengan Id:  
      Screenshot:    
      ![create_customer.png](./screenshots/delete_customer.png)