# Laboratory-Reporting-Application

### 📖 Tanım

<ul>
  <li><b>Laboratory-Reporting-Application</b> bir <b>Spring Boot uygulamasıdır.</b> İlgili laboratuvar kayıtları eklenebilir, güncellenebilir ve silinebilir.</li> 
  <li>
    <b>Açıklama:</b>
    <ul>
      <li><b>LabReportController:</b> Laboratuvar raporlarını oluşturmak, silmek ve güncellemek için kullanılan controller. Dışarı açılan API.</li>
    </ul>
  </li>
</ul>

### Uygulamadaki REST API'ler [BASE URL = /lab-reports]

<table style="width:100%">
  <tr>
      <th>Metot</th>
      <th>Url</th>
      <th>Açıklama</th>
      <th>Response</th>
      <th>Request Body</th>
      <th>Request Param</th>
      <th>Path Variable</th>
      <th>HttpStatus</th>
  </tr>
  <tr>
      <td>GET</td>
      <td>/all</td> 
      <td>Oluşturulmuş Tüm Raporları Getirir</td>
      <td> List<<LabReport>LabReport> labReports </td>
      <td> </td>
      <td></td>
      <td></td>
      <td>200</td>
  </tr>
  <tr>
      <td>GET</td>
      <td>/search</td>
      <td>Aldığı parametrelerle tespit ettiği raporu getirir.</td>
      <td> List<<LabReport>LabReport> labReports </td>
      <td> </td>
      <td>String patientFirstName, <br>
String patientLastName, <br>
String patientIdentityNumber, <br>
String labAssistantFirstName, <br>
String labAssistantLastName, <br>
String orderByDate</td>
      <td></td>
      <td>200</td>
  </tr>
  <tr>
      <td>GET</td>
      <td>/{id}</td>
      <td>id parametresi alarak ilgili raporu getirir</td>
      <td>LabReport labReport</td>
      <td></td>
      <td></td>
      <td>Long id</td>
      <td>200</td>
  </tr>
  <tr>
    <td>POST</td>
    <td>/create</td>
    <td>Rapor oluşturur.</td>
    <td>LabReport labReport</td>
    <td>LabReport labReport</td>
    <td></td>
    <td></td>
    <td>201</td>
  </tr>
  <tr>
    <td>PUT</td>
    <td>/update/{id}</td>
    <td>İlgili raporu günceller.</td>
    <td>LabReport labReport</td>
    <td>LabReport labReport</td>
    <td></td>
    <td>Long id</td>
    <td>201</td>
  </tr>
  <tr>
    <td>DELETE</td>
    <td>/delete/{id}</td>
    <td>İlgili idli raporu siler.</td>
    <td>Void</td>
    <td></td>
    <td></td>
    <td>Long id</td>
    <td>204</td>
  </tr>


</table>


---
### Kullanılan Teknolojiler


- Java 17
- Spring Boot 3.2.5
- MySQL
- Postman
- Maven
- Restful API
---

### Uygulamayı ayağa kaldırmak için:

#### .env dosyasında değişkenler tanımlanmalıdır.

```
DB_USERNAME= {BURAYA_DB_USERNAME_YAZILMALI}
DB_PASSWORD= {BURAYA_DB_PASSWORD_YAZILMALI}
```
---

### Maven ile çalıştırmak için
Aşağıdaki adımlar takip edilir.

```sh
$ cd laboratory-reporting-application
$ mvn clean install
$ mvn spring-boot:run
```