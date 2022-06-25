<h1 align="center">Mobile Action Bootcamp Homework-3 Başak ER</h1>

 <p align="center">
  📌 <a href="#project-details">Project Details</a> •
  📌 <a href="#swagger-screenshots">Swagger Screenshots</a> •
  📌 <a href="#user">User</a> •
  📌 <a href="#vehicle">Vehicle</a>
</p>


## Project Details

**Konu:** Sisteme kayıt olan kullanıcıların kendi araçlarını sisteme ekleyebildiği bir uygulama yazılması.

**Kullanıcı:**

- Her kullanıcı, kullanıcı adı ve şifre belirleyerek sisteme kayıt olur. ✔️
- Sisteme giriş yapmayan kullanıcılar bu API’ı kullanamazlar.✔️
- Aynı kullanıcı adı ile sisteme kayıt olunamaz.✔️
- Kullanıcı bilgileri değiştirilemez. Sadece şifre değiştirilebilir. Şifre değiştirme işleminin yapılabilimesi için önce mutlaka login olunmalıdır.✔️
- Şifre değiştirme işleminde eski şifre de parametre olarak alınmalıdır. (Eski şifre, yeni şifre, yeni şifre tekrar gibi)✔️
- Kullanıcı silinebilir. Silindiğinde sistemde kayıtlı tüm araçları da silinmelidir.✔️
- Kullanıcının tüm araçları sorgulanabilmelidir.✔️
- 
**Araç:**

- Login olmuş kullanıcılar kendi araçlarını ekleyebilirler.✔️
- Aynı araç birden fazla kişi tarafından eklenemez.✔️
- Plakalar boşluk, küçük harf ya da Türkçe karakter içeremez.✔️
- Araçlar silinebilir ya da güncellenebilir.✔️
- Marka ve modele göre araçları getiren servis yazılmalıdır.✔️
- 
**Not:**
Hiçbir controllerda persistence nesne kullanılmamalıdır. API pathlerine dikkat edilmelidir. Doğru hata kodlarının dönüldüğünden emin olunuz. Kullanıcı ve araç entitylerine eklenmesi gerektiğini düşündüğünüz bilgileri ekleyiniz. (örneğin kullanıcı adı, soyadı vs.)✔️

## Swagger Screenshots

### Controllers and Schemas: 

![25](https://user-images.githubusercontent.com/25417307/174491873-41a363eb-2180-4a01-9f62-4bdf47fe5281.png)


### User: 

#### ♦️ Her kullanıcı, kullanıcı adı ve şifre belirleyerek sisteme kayıt olur.

![1 (2)](https://user-images.githubusercontent.com/25417307/174491902-f66522fd-0723-4e14-b075-ebbea95c9c2e.png)

➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖


#### ♦️ Kullanıcı parolası şifrelenir.

![2](https://user-images.githubusercontent.com/25417307/174491908-dd311def-ad85-4371-a47b-413c0f275001.PNG)

➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖


#### ♦️ Aynı kullanıcı adı ile sisteme kayıt olunamaz.

![3 (1)](https://user-images.githubusercontent.com/25417307/174491927-0a8798f5-0fb4-418f-9286-c64cf028613d.png)

➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖


#### ♦️ Kullanıcı adı ve şifreyle giriş yapılır.

![4 (1)](https://user-images.githubusercontent.com/25417307/174492002-d5c9c73b-b202-47a5-97ff-7e06947af242.png)

➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖


#### ♦️ Kullanıcı girişi yapılmadan API kullanılamaz

![5 (1)](https://user-images.githubusercontent.com/25417307/174492015-1c4005c0-6b30-4895-86f5-28dd158bf6b4.png)

➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖


#### ♦️ Kullanıcı girişi yapıldıktan sonra tüm kullanıcıları görüntüleme.

![201](https://user-images.githubusercontent.com/25417307/174492039-aa1844fb-8cab-4f00-a7d5-b362e7920473.png)

➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖


![6 (1)](https://user-images.githubusercontent.com/25417307/174492044-bdc18ca6-31b2-48da-ae15-b787f7b760d7.png)

➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖


#### ♦️ Kullanıcı şifre değiştirirken kontrollerin yapılması

![6 (2)](https://user-images.githubusercontent.com/25417307/174492072-a7dc8ddd-411e-47df-9888-5410ceb0d927.png)

➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖


#### ♦️ Kullanıcı şifre değiştirme

![7 (2)](https://user-images.githubusercontent.com/25417307/174492090-cbeaaafd-3850-4c73-9293-a4d062005277.png)

➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖


![8(2)](https://user-images.githubusercontent.com/25417307/174492093-9d95f66c-0f48-42b4-85cb-dcbd0b26dacc.png)

➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖


#### ♦️ Kullanıcının tüm araçlarının görüntülenmesi

![14](https://user-images.githubusercontent.com/25417307/174492291-028b7bc0-a09f-447b-b11a-1e8a73e424c5.png)

➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖


#### ♦️ Kullanıcı silme
(Silinmiş kullanıcı görüntüsü ve kullanıcıya ait tüm araçların da silinmesi)

![17A](https://user-images.githubusercontent.com/25417307/174492331-8817ba82-bc77-405c-a0b8-54a118b8ffbd.png)

➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖


![18](https://user-images.githubusercontent.com/25417307/174492344-d12ac2b0-7bd9-4d2b-9a5b-9fd77627303d.png)

➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖


![19](https://user-images.githubusercontent.com/25417307/174492384-a9d77de2-84c3-4c1e-a2ac-5dfe940051dc.png)

➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖


![20](https://user-images.githubusercontent.com/25417307/174492424-8ea70a7c-d9a8-4487-91f3-cee95cfeacb6.png)

➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖


### Vehicle: 

#### ♦️ Araç ekleme

![8 (1)](https://user-images.githubusercontent.com/25417307/174492151-43ad1a38-f761-477f-ad1d-ee69dd0eefb7.png)

➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖


#### ♦️ Araç eklerken plaka kontrolü

![2-3 (1)](https://user-images.githubusercontent.com/25417307/174492162-4b11fb79-381e-49ef-9894-911e62c7b250.png)

➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖


#### ♦️ Aynı araç birden fazla kez ve farklı kişilere eklenemez

![9 (1)](https://user-images.githubusercontent.com/25417307/174492195-9f48bed9-09e3-4851-8eee-12d3a9058510.png)

➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖


#### ♦️ Tüm araçları görüntüle (İsteğe bağlı page ile)

![10 (1)](https://user-images.githubusercontent.com/25417307/174492232-58b6cf67-a8d1-427b-a6c3-cfe837ad8265.png)

➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖


#### ♦️ Araç silme

![12 (1)](https://user-images.githubusercontent.com/25417307/174492249-17dca534-0d44-4623-afd1-2e03a678ed4f.png)

➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖


![13 (1)](https://user-images.githubusercontent.com/25417307/174492264-890f391b-0d28-42ec-bd80-be6617df6b67.png)

➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖


#### ♦️ Araç güncelleme

![15 (1)](https://user-images.githubusercontent.com/25417307/174492308-8cf1f043-dc8d-4b99-9663-0c2653d94c06.png)

➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖


![16](https://user-images.githubusercontent.com/25417307/174492318-367d3271-6a88-49b1-92b4-59406d991d17.png)

➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖


#### ♦️ Marka ve modele göre araç görüntüleme

![18 (1)](https://user-images.githubusercontent.com/25417307/174492450-faa248f4-c953-4481-a3bb-ca74f70dce92.png)

➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖


![19 (1)](https://user-images.githubusercontent.com/25417307/174492454-7f993c3a-76b5-4f92-af8c-2083368e6f87.png)

➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖



