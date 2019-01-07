# govtech-assignment

Simple REST API with a single `/user` endpoint. Built on top of Spring Boot framework utilising the following starters and dependencies:
1. Spring Data REST to serve Hypermedia driven RESTful endpoints
2. Embedded mongoDB to store data transiently
3. Opencsv to parse CSV data

## Acceptance Criteria Instructions
### Acceptance Criteria 1
To read and serve user data from CSV, paste the csv data into the `users.csv` file at `src/main/resources/users.csv`
### Acceptance Criteria 2
To output valid users with valid salary within range (0 <= salary <= 4000), use the following endpoint:
http://localhost:8080/users/search/findBySalaryBetweenInclusive?from=0&to=4000

## How to Install and Run
Prerequisites: Requires git and maven CLI to be installed
1. Clone repository into local machine by running `git clone https://github.com/JosephineKwa/govtech-assignment.git`
2. Open a terminal window, navigate to the repository root and enter `mvn spring-boot:run`
3. The API will be served at http://localhost:8080

## Supported APIs
### GET Methods
#### - `GET /users`
Returns a list of users.

#### - `GET /users/{userId}`
Returns a single user with the specified ID.
##### Parameters
```
userId: String
```
#### - `GET /users/search/findBySalaryBetweenInclusive?from={from}&to={to}`
Returns a list of users with salary within the specified range.`
##### Query
```
from: Number
to: Number
```
### PUT Methods
#### - `PUT /users/{userId}`
Updates a single user with the specified ID.`
##### Parameters
```
userId: String
```
##### Body
```
name: String
salary: Number
```
### POST Methods
#### - `POST /users`
Creates a single user with the specified properties.
##### Body
```
name: String
salary: Number
```
### DELETE Methods
#### - `DELETE /users/{userId}`
Deletes a single user with the specified ID.`
##### Parameters
```
userId: String
```
## Additional Notes
1. Aside from the above specified APIs, other APIs provided by Spring Data REST are available
 as [listed here](https://docs.spring.io/spring-data/rest/docs/current/reference/html/#repository-resources)
 [and here](https://docs.spring.io/spring-data/rest/docs/current/reference/html/#paging-and-sorting).
 These include `?page`, `?size`, and `?sort` to paginate, limit and sort results.
   - To limit page size to 1: http://localhost:8080/users?size=1
   - To get 2nd page with page size 1 (0-based): http://localhost:8080/users?size=1&page=1
   - To sort results by name in descending order: http://localhost:8080/users?sort=name,desc
2. The application is pre-populated with the example data in the `users.csv` file
3. 😊
