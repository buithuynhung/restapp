Задание: написать простенький микросервис для поиска 256 дня в году. Сервис создается на любом языке программирования и ожидает GET-запросы на 80-м порту

Решение:
Требуется gradle с версией не ниже 4.10
- Docker:  
  + Сборка образа:
      gradle buildDocker
  + Создание контейнера: 
      docker build -t myorg/myapp .
  + Запуск:
      docker run -p 8080:8080 myorg/myapp
- Примеры работы:
  + Запрос:
    1) curl http://localhost:8080/year?year=2000
    2) curl http://localhost:8080/year?year=200
    3) curl http://localhost:8080/year?year=200A
  + Ответ (JSON)
    1) {"errorCode":200,"dataMessage":"12/9/2000"} - OK
    2) {"errorCode":2,"dataMessage":""} - Ошибка (Y - Порядковый номер года, 4 цифры)
    3) {"errorCode":1,"dataMessage":""} - Ошибка (Y - число)