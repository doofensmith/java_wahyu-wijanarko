# (22) Getting Started REST Spring Boot (MVC)
## Summary
Materi pada section ini meliputi:
1. HTTP Flow
2. Annotation
3. Struktur Project

#### HTTP Flow
adalah proses transaksi data dengan method http dengan proses client request ke server dan server memberikan response.

#### Annotation
Perubahan metadata pada objek Java.

#### Struktur Project
Struktur MVC terdapat:
1. Entity
2. Controller
3. Repository

## Task
#### 1. Problem 1 - H2 Database
1. [GET] all post 1  
![get_all_post.png](./screenshots/get_all_posts_1.png)
  
2. [POST] new 3 posts  
![new_1_post.png](./screenshots/new_post_1.png)    
![new_3_post.png](./screenshots/new_post_3.png)  
Result:  
![get_all_post2.png](./screenshots/get_all_post_afterpost.png)

3. [PUT] update post id 3  
![update.png](./screenshots/update_post.png)  
Result:  
![get_all_post3.png](./screenshots/get_all_post_afterupdate.png)
  
4. [DEL] delete post id 3
![delete.png](./screenshots/delete_post.png)  
Result:  
![get_all_post4.png](./screenshots/get_all_post_afterdelete.png)
