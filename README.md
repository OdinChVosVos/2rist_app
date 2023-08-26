# The_Code_THat_Failed Command
## Our product's name is *2rist* {Tourist}

На этом репозитории лежит сторона бэка.
В качестве стека технологий использоались
+  фреймворк Spring Boot,
+  СУБД PostgreSQL 14,
+  для миграции БД использовался flyway,
+  использовались библиотеки:
   +   Lombock,
   +    Swagger,
   +    jwt security token,
   +    jpa,
   +    orika

В проекте предусмотрены 7 сущностей, одно перечисление. 
Предусмотрена регистрация и аутентификация, использование jwt токена.

## ER диаграмма представления БД
![image](https://github.com/OdinChVosVos/testspringboot/assets/95305025/b1898a0d-f5fa-44e9-84be-f88ab790ab62)

## Предусмотренные запросы:

/api/auth&nbsp;   &nbsp;   &nbsp;   &nbsp;   &nbsp;  **КОНТРОЛЛЕР БЕЗОПАСНОСТИ**
+  /register&nbsp;   &nbsp;   &nbsp;   &nbsp;   &nbsp;  Регистрация
+  /authenticate&nbsp;   &nbsp;   &nbsp;   &nbsp;   &nbsp;  Аутентификация
  
/api/tagsPlaces&nbsp;   &nbsp;   &nbsp;   &nbsp;   &nbsp;  **КОНТРОЛЛЕР ЗАПИСЕЙ ТЭГ_МЕСТО**
+  /add    &nbsp;   &nbsp;   &nbsp;   &nbsp;   &nbsp;             Добавление записи
+  /getAll    &nbsp;   &nbsp;   &nbsp;   &nbsp;   &nbsp;          Получение всех записей
+  /get/place/{name} &nbsp;   &nbsp;   &nbsp;   &nbsp;   &nbsp;   Получение записей по месту

/api/interests    &nbsp;   &nbsp;   &nbsp;   &nbsp;   &nbsp;     **КОНТРОЛЛЕР ИНТЕРЕСОВ**
+  /add      &nbsp;   &nbsp;   &nbsp;   &nbsp;   &nbsp;           Добавление интересов
+  /remove      &nbsp;   &nbsp;   &nbsp;   &nbsp;   &nbsp;        Удаление интересов
+  /getAll       &nbsp;   &nbsp;   &nbsp;   &nbsp;   &nbsp;       Получение всех интересов
+  /get/{mail}  &nbsp;   &nbsp;   &nbsp;   &nbsp;   &nbsp;        Получение интересов по пользователю

/api/tags    &nbsp;   &nbsp;   &nbsp;   &nbsp;   &nbsp;          **КОНТРОЛЛЕР ТЭГОВ**
+  /add     &nbsp;   &nbsp;   &nbsp;   &nbsp;   &nbsp;            Добавление тэга
+  /remove  &nbsp;   &nbsp;   &nbsp;   &nbsp;   &nbsp;            Удаление тэга
+  /getAll    &nbsp;   &nbsp;   &nbsp;   &nbsp;   &nbsp;          Получение всех тэгов
+  /get/{name}    &nbsp;   &nbsp;   &nbsp;   &nbsp;   &nbsp;      Получение тэга по названию
+  /get/place/{name} &nbsp;   &nbsp;   &nbsp;   &nbsp;   &nbsp;   Получение тэгов по месту

/api/users      &nbsp;   &nbsp;   &nbsp;   &nbsp;   &nbsp;       **КОНТРОЛЛЕР ПОЛЬЗОВАТЕЛЕЙ**
+  /remove/{mail}   &nbsp;   &nbsp;   &nbsp;   &nbsp;   &nbsp;    Удаление пользователя по почте
+  /update          &nbsp;   &nbsp;   &nbsp;   &nbsp;   &nbsp;    Изменение пользователя
+  /getAll         &nbsp;   &nbsp;   &nbsp;   &nbsp;   &nbsp;     Получение всех пользователей
+  /get/{mail}    &nbsp;   &nbsp;   &nbsp;   &nbsp;   &nbsp;      Получение пользователя по почте

  
