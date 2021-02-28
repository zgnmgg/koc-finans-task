# Koç Finans Full Stack Developer Task

Proje temel olarak backend ve frontend altyapılarından oluşmaktadır.
1. Backend Servisleri (Spring Boot)
2. Frontend Servisi (Angular Framework)
3. Veritabanı (PostgreSQL Heroku)

## 1. Backend Sunucu

5 farklı servis oluşturularak tasarlanmıştır. Servisler aşağıdaki sıralamayla çalıştırılmalıdır. 
* (service-registry, gateway-service, api-service, city-score-service, identity-score-service). 
* Servislerin docker file'ına bulunduğu klasörlerin altındaki `Dockerfile` dosyasından ulaşabilirsiniz.
* Servislerin swagger url'i Örn:`http://localhost:8081/swagger-ui.html#/` şeklindedir.
* Servislerin `src/main/resources/application.yaml` dosyasında servisin çalışacağı port gibi genel ayarlar yapılmalıdır.
* Servislerde Java 8 kullanılmıştır.

### 1.1. Service Registry
* Servis için eureka server kullanıldı.
* Servis Spring Cloud Netflix Eureka ile servislerin makina adı ve bağlantı noktasına ihtiyaç duymaksızın birbirleriyle iletişim kurmasını sağlar.
* Servis ile tüm bağlı clientların listesi alınır ve load balancing algortiması ile servislere istekler dağıtılır.
* Çalışan servisin url adresine gidilerek register olan eureka servisler monitor edilebilir.

### 1.2. Gateway Service
* Eureka servise bağlanarak servisler arası yönlendirmeler yapmaktadır. 
* Yönlendirmelere `src/main/resources/application.yaml` dosyasından ulaşabilirsiniz.

### 1.3. Api Service

* Heroku Postgres sunucusuyla oluşturulan demo database'e bağlantı sağlamaktadır. Database içerisine gerekli tablolar eklendi ve servis içerisinde entityleri oluşturuldu.
* Frontend tarafından yapılan CRUD işlemlerine dönüş sağlayan servistir.
* Exception Handling yapılarak oluşan hatalar custom exception dönüşleri sağlandı.
* Frontend tarafından aldığı form bilgisini alıp diğer servislere istek atarak skor hesaplaması yapmaktadır.
* Skor hesaplaması yapan servistir. Şehir skoru hesabını `city-score-service`'ten skor segmenti skorunu `identity-score-service`'ten alarak skor hesaplar.
* Hesapladığı skoru kullanıcının girdiği telefon numarasına SmsService'i servisiyle Sms göndermektedir (Burada sms entegrasyonu yapılmamış olup sadece servis yönlendirmesi yapılmıştır).
* Service Registry servisi çalışmadan proje eureka client'a bağlanamayacağından çalışmayacaktır.
* Angular tarafından yapılan isteklerde CORS hatasından dolayı CORS config'i yapılmıştır. `src/config/SimpleCorsFilter`

### 1.4. City Score Service
* `url:/city-score` urlinde aldığı path variable("code") değerle bu değere karşılık gelen şehir skoru dönüşü sağlamaktadır. 
* Şehir skoru proje içerisine enum olarak tanımlanmıştır. Şehir bilgileri enum olarak ayarlanmıştır. Şehirlerin skorları random atanmıştır.

### 1.5. Identity Score Service
* `url:/identity-score` urli kimlik numarası parametresini alarak bu numaranın skorunu 1 ile 9 arasında random bir sayı üreterek kimlik skoru dönüşü sağlamaktadır.

## 2. Frontend Service (UI-Service)

* Angular ile hazırlanan bu serviste iki adet sayfa bulunmaktadır.
    * İlk sayfa 'Gelir Formu' form içerisindeki bilgileri alıp api-service'e istek atıp daha sonra çıkan skor değerini ekrana yazmaktadır.
    * İkinci sayfa kimlik bilgilerine göre kaydedilen kişilerin skorunu dönmektedir.
    * İsteklerde hata olması durumun exception durumları yapılmıştır.
    * Servisin database ile ilişkisi yoktur. Sadece istekleri api-service'e atıp aldığı dataları ekranda göstermektedir.
    * Servisin çalışması için terminal üzerinden önce `npm install` daha `ng serve` komutu yazılarak çalıştırılabilir.


## 3. Veritabanı Bağlantısı

* Database içerisinde oluşturulan tablolar ve içerisinde yer alan column'lar `Schema.sql` dosyası içerisinde yer almaktadır.
* Database bilgileri `api-service` içerisine default olarak eklenmiştir. (Env bilgisi olarak eklenmemiştir)
* Database bilgileri:
    * url: jdbc:postgresql://ec2-54-87-34-201.compute-1.amazonaws.com/d282u2o70av3df
    * username: dnxefbukwnniwx
    * password: 02ff97b092ad0d3ebac1b466e49852efc23c05d0e2488666b98f8b8777304731
    

### Not

Servislerin Postman collectionlarını `Koç Finans.postman_collection.json` bulabilirsiniz.
