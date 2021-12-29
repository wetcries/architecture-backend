# arch-backend
### Описание

В репозитории представлена backend составляющая проекта. 

Для поднятия инфраструктуры в проекте находится docker-compose файл, в котором описаны необходимые 
для работы бэкенда сервисы, такие как база данных и ml-сервер. Для самого сервиса также создан docker контейнер.

Чтобы запустить всю инфраструктуру, достаточно поднять docker compose следующей командой, находясь в директории с 
docker-compose.yml файлом:
```shell
docker compose up -d
```

Для работы с API необходимо пройти аутентификацию с помощью jwt токена, 
который можно выписать, обратившись POST запросом
на контекст /backend/login. При обращении на данный контекст, в теле запроса нужно 
передать реквизиты клиента API в виде:

```json
{
  "username": "client-username",
  "password": "client-password"
}
```

При удачной аутентификации в ответе на запрос в заголовке *Authorization* будет 
находиться jwt токен для работы с API.

```
Пример заголовка:
Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImF1dGhvcml0aWVzIjpbeyJhdXRob3JpdHkiOiJST0xFX0FETUlOIn1dLCJpYXQiOjE2NDA3OTg1NTIsImV4cCI6MTY0MDgyMjQwMH0.i7N2pqzDKFb9UnPgr0XbsajurSy2saZxBmmKZ0qMvlWxU3yErGTi5xJqoVp6nxBG5V3LGRphgZpYGXKVUAlqMQ
```

> **NOTE**
> 
> Для работы с "нуля" существует клиент администратор с именем admin и паролем admin. 
> Чтобы создать нового клиента, необходимо совершить запрос `POST /backend/api/v1/clients`,
> передавая в теле запроса
> реквизиты нового клиента.
> 
> У администратора есть доступ к любым методам API сервера. У созданных клиентов, доступ
> имеется только к контексту `/backend/api/v2`. Контекст `/backend/api/v1` является
> служебным и закрыт для обычных клиентов.

При обращении к API сервера, в заголовке запроса `Authorization` нужно передавать
выданный токен в виде `Bearer <you-jwt-token>`.

Ознакомиться с функциональностью API сервиса можно по следующему пути `http://localhost:8080/backend/swagger-ui.html`.

#### P.S.
Также в репозитории находятся:
* Dockerfile для создания image сервера 
* Architecture Backend.postman_collection.json с Postman коллекцией
методов API сервера
* prod_application.yaml с prod-конфигурацией сервиса