## How to run project?
To run app you either start from IDEA by running RedisHomeworkApplication or from console `mvn spring-boot:run`

## What endpoints are available?`
```
POST /redis/publish - sends message to redis server, text of the message should be in body
GET /redis/getLast - return last message
GET /redis/getByTime?start={your_start_date}&end={your_end_date} - return messages that occurred between specified dates
```
