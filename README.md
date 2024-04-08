# DiceAssignment
## Weather Forecast API Server

## Introduction
This project is a Spring Boot-based server that integrates with the Weather API from Rapid API. It provides RESTful APIs to retrieve weather forecast summaries for various cities.

## Features
- Exposes RESTful APIs to retrieve weather forecast summaries.
- Implements header-based authentication with random client ID and client secret.

## Installation
1. Clone the repository: `git clone https://github.com/your_username/weather-forecast-api.git`
2. Navigate to the project directory: `cd weather-forecast-api`
3. Build the project: `mvn clean install`

## Configuration
- Modify `application.properties` to configure server settings, such as port and database connection.

## Usage
- Start the server: `java -jar target/weather-forecast-api.jar`
- Access the API documentation at `https://diceassignment-production-b41b.up.railway.app/swagger-ui/index.html`

## RESTful APIs
### Authentication
- Header-based authentication with random client ID and client secret.

### Get Weather Forecast Summary by City Name
- Endpoint: `GET /weather/getWeatherSummary/{city}`
- Description: Retrieves the weather forecast summary for the specified city.
- Example Request:
