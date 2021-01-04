## Prerequirements?
Java 8  Maven are installed. Redis server is already running on port `6379`


## How to run project?
To run app you either start from IDEA by running RedisHomeworkApplication or from console `mvn spring-boot:run`

## What endpoints are available?`
```
POST /redis/publish - sends message to redis server, text of the message should be in body
GET /redis/getLast - return last message
GET /redis/getByTime?start={your_start_date}&end={your_end_date} - return messages that occurred between specified dates
```

## Response example
 ```
{
"id": 3,
"channel": "test",
"text": "third test",
"timestamp": 1609774804000
}
```

## Dev notes
There are two implementations - H2RedisMessageService (writes redis messages to h2 database) and InMemoryRedisMessageService (keeps messages) in memory.
Regarding h2 implementation - in order to persist database to the disc `spring.datasource.url` should be updated to point to the file
