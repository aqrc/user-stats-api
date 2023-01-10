# user-stats-api
Take-home coding assignment. API that loads data from files and calculates statistics of the requested user. Done using Spring Boot.

## Usage
Runs on port 8080.

Has a `GET /userStats/{userId}` endpoint. UserIds can be found in `src/main/resources/data/requests.csv`.

## Example
```
GET localhost:8080/userStats/c94c22b5-dfc8-4a8b-bf4e-9625556ff51d
```
