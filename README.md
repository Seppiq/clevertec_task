# ReceiptTask
Test task for CLEVERTEC

## Использованный стэк
* Java 17
* Gradle 7.5
* Spring Boot
* PostgreSQL

### Инструкция по запуску
Для запуска приложения необходимо запустить сервер и добавить данные из файлов *.sql, далее через Postman или другим возможным способом загрузить данные из JSON в БД.

*Для создания карты использовать метод POST по пути http://localhost:8080/api/card<br />
*Для создания продуктов использовать метод POST по пути http://localhost:8080/api/product<br />
*Для создания чека использовать метод POST по пути http://localhost:8080/api/receipt<br />
Для получения файла PDF чека использовать метод GET по пути http://localhost:8080/api/receipt/download/{id}<br />
Файлы DLL находятся в ресурсах. 

# Пример чека
(https://github.com/Seppiq/clevertec_task/files/10273251/response.pdf)


POST запрос на добавление товара в чек
![image](https://user-images.githubusercontent.com/53149697/208913356-dd9b717d-af09-4cd7-8d35-40fa04d00d4c.png)

GET запрос на просмотр товаров
![image](https://user-images.githubusercontent.com/53149697/208947709-24c5018f-8120-48b6-9a11-4c3b1140fa17.png)
