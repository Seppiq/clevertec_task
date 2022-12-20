# ReceiptTask
Test task for CLEVERTEC

## Использованный стэк
* Java 17
* Gradle 7.5
* Spring Boot
* PostgreSQL

### Инструкция по запуску
Для запуска приложения необходимо запустить сервер и добавить данные из файлов *.sql, далее через Postman или другим возможным способом загрузить данные из JSON в БД.

Для создания карты использовать метод POST по пути http://localhost:8080/api/card
Для создания продуктов использовать метод POST по пути http://localhost:8080/api/product
Для создания чека использовать метод POST по пути http://localhost:8080/api/receipt
Для получения файла PDF чека использовать метод GET по пути http://localhost:8080/api/receipt/download/{id}
Файлы DLL находятся в ресурсах. 

# Пример чека
(https://github.com/Seppiq/clevertec_task/files/10273251/response.pdf)
