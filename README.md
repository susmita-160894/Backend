# Backend

# User Profile and Coin Data Backend Application

## Table of Contents
- [Introduction](#introduction)
- [Tech Stack](#tech-stack)
- [Features](#features)
- [Requirements](#requirements)
- [Endpoints](#endpoints)
- [Setup](#setup)
- [Usage](#usage)

## Introduction
This project is a backeend application that allows users to create and update user profiles and retrieve various coin data from a third-partty API. Users can sign up with a unique username and password, save their basic profile details, and search for coin details using the CoinMarketCap API.

## Tech Stack
- **Spring Boot**: For building the application.
- **Hibernate**: For ORM (Object-Relational Mapping).
- **MySQL**: For database management.

## Features
- User sign-up with unique username and password.
- User login and auhentication.
- Create and update user profiles with details like first name, last name, email, mobile number, username, and password.
- Search and retrieve cryptocurrency data from the CoinMarketCap API.
- Error handling for API errors.
- Basic valiation and secure API endpoints.

## Requirements
- Java 8 or more
- Maven
- MySQL

## Endpoints

### User Management
- **Sign Up**: `POST /api/users/signup`
  - Request Body: 
    ```json
    {
      "firstName": "Anu",
      "lastName": "Sawant",
      "email": "Anu.Sawant@example.com",
      "mobile": "1234567890",
      "username": "anusawant",
      "password": "Password123!"
    }
    ```

- **Login**: `POST /api/users/login`
  - Request Body:
    ```json
    {
      "username": "anusawant",
      "password": "Password123!"
    }
    ```

- **Update Profile**: `PUT /api/users/update`
  - Request Header: `Authorization: Bearer <token>`
  - Request Body:
    ```json
    {
      "firstName": "Anu",
      "lastName": "Sawant",
      "mobile": "1234567890",
      "password": "NewPassword123!"
    }
    ```

### Coin Data
- **Get Coin Data**: `GET /api/coins?symbol=BTC,ETH,LTC`
  - Request Header: `Authorization: Bearer <token>`
  - Example Response:
    ```json
    {
      "data": {
        "BTC": { ... },
        "ETH": { ... },
        "LTC": { ... }
      }
    }
    ```

## Setup
1. Clone the repository:
    ```bash
    git clone https://github.com/yourusername/your-repo-name.git
    cd your-repo-name
    ```

2. Configure the database:
    - Update the MySQL database configuration in `src/main/resources/application.properties`.

3. Install dependencies and build the project:
    ```bash
    mvn clean install
    ```

4. Run the application:
    ```bash
    mvn spring-boot:run
    ```

## Usage
1. **Sign Up**: Create a new user by sending a POST request to `/api/users/signup` with the required details.

2. **Login**: Authenticate the user by sending a POST request to `/api/users/login` and obtain a JWT token.

3. **Update Profile**: Update user details by sending a PUT request to `/api/users/update` with the new details and the JWT token in the Authorization header.

4. **Get Coin Data**: Retrieve cryptocurrency data by sending a GET request to `/api/coins` with the symbols and the JWT token in the Authorization header.

## Third-Party API Integration
- The application integrates with the CoinMarketCap API to fetch cryptocurrency data.
- Endpoint: `https://pro-api.coinmarketcap.com/v1/cryptocurrency/quotes/latest?symbol=BTC,ETH,LTC`
- Header: `X-CMC_PRO_API_KEY : 27ab17d1-215f-49e5-9ca4-afd48810c149`

## Validation
- **Username**: Must be alphanumeric and 4 to 15 characters long.
- **Password**: Must be 8 to 15 characters long with at least one uppercase letter, one lowercase letter, one digit, and one special character.

## Error Handling
- Proper error messages will be shown in case of API errors or validation failures.

---

This README provides a comprehensive overview of the project, including setup instructions, endpoints, and usage examples. If you have any questions or need further assistance, please feel free to open an issue on the repository.
