# Как запустить приложение

Необходимо ввести следующую команду: `./mvnw spring-boot:run`

# API

## Get Requests

### `localhost:8080/api/findRepetitionsInLine`
Запрос должен содержать JSON со значением line, которая содержит входную строку. Пример:{"line": "aaaaabcccc"}   
Запрос вернет: `{
    "a": 5,
    "c": 4,
    "b": 1
}`

