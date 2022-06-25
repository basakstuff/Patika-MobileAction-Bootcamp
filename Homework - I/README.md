Aşağıdaki kriterlere göre entity tanımlamarını yapınız.✔️

```
Kullanıcı KullanıcıYorum
Id Id
Adı(50 char) Yorum(500 char)
Soyadı(50 char) yorumTarihi (date)
Email(50 char) urunId (Long bir değer olsun)
telefon(15 char) Kullanici (Entity olarak)
Doğum tarihi
Aktif/Pasif Durumu
```
Bu entitylere ait birer tane controller yazınız.✔️

```
Kullanıcı Controller Yorum Controller
Kullanıcı kayıt Yorum kayıt
Kullanıcı findAll Yorum findAll
Kullanıcı findById Yorum silme
Kullanıcı update Yorum güncelleme (Sadece yazdığı yorumun
textini değiştirebilsin. Tarih, urunId vs
değiştirilemesin)
Kullanıcıyı pasif yapma
```
Notlar:

1. Tüm isimlendirmeler İngilizce olmalıdır.✔️
2. Controllerlarınızın pathlerini best practice lere göre belirleyiniz.✔️
3. Clean code prensiplerine özen gösteriniz.✔️
4. Lombok kullanınız. (Pekişmesini istediğim için bu derslik zorunlu )✔️
5. Swagger kullanınız.✔️
