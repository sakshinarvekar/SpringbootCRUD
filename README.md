# Spring Boot REST API with CRUD Operations and MySQL Integration

## Introduction
This project implements a Spring Boot REST API for managing categories and products. It integrates with a MySQL database using Spring Data JPA and Hibernate for data persistence.

- One-to-many relationship between categories and products.
- Server-side pagination for efficient handling of large datasets.
- Enhanced product details with respective category information.

## Table of Contents
1. [Prerequisites](#prerequisites)
2. [Installation](#installation)
3. [Usage](#usage)
4. [Database Configuration](#database-configuration)
5. [API Endpoints](#api-endpoints)
6. [Data Model](#data-model)
7. [Testing](#testing)
8. [Contributing](#contributing)
9. [License](#license)

## Prerequisites
- Java Development Kit (JDK) 8 or higher
- Maven
- MySQL Database

## Installation
1. Install MySQL if you haven't already done so.
2. Create a new database schema for the project:
    ```sql
    CREATE DATABASE SpringDB;
    ```
3. Update the `application.properties` and `application.yaml` files with your MySQL database connection details, including the database name, username, and password.

## Usage
- Start the Spring Boot application.
- Use Postman or any other API testing tool to interact with the API endpoints.

## Database Configuration
1. Install MySQL if you haven't already done so.
2. Create a new database schema for the project:
    ```sql
    CREATE DATABASE SpringDB;
    ```
3. Update the `application.properties` and `application.yaml` files with your MySQL database connection details, including the database name, username, and password.

## API Endpoints
### Categories
| Method | Endpoint                         | Description                          |
|--------|----------------------------------|--------------------------------------|
| GET    | `/api/categories?page={page}`    | Get all categories with pagination. |
| POST   | `/api/categories`                | Create a new category.               |
| GET    | `/api/categories/{id}`          | Get a category by ID.                |
| PUT    | `/api/categories/{id}`          | Update a category by ID.             |
| DELETE | `/api/categories/{id}`          | Delete a category by ID.             |

### Products
| Method | Endpoint                         | Description                          |
|--------|----------------------------------|--------------------------------------|
| GET    | `/api/products?page={page}`     | Get all products with pagination.    |
| POST   | `/api/products`                 | Create a new product.                |
| GET    | `/api/products/{id}`            | Get a product by ID.                 |
| PUT    | `/api/products/{id}`            | Update a product by ID.              |
| DELETE | `/api/products/{id}`            | Delete a product by ID.              |

## Data Model
The data model consists of two entities: Category and Product. There is a one-to-many relationship between Category and Product.

## How it Works

### Creating Categories and Adding Products

To add products, it's recommended to first create categories and then add products to those categories. Follow the steps below:

1. **Create Category**:

    Send a POST request to `http://localhost:8080/api/categories` with the following JSON payload:
    ```json
    {
        "cname": "New Category"
    }
    ```
    This request will create a new category with the specified name.

2. **Add Product to Category**:

    After creating the category, you can add products to it by sending a POST request to `http://localhost:8080/api/products` with the following JSON payload:
    ```json
    {
        "pname": "New Product",
        "pdesc": "New Description",
        "pprice": 10000,
        "category": {
            "cid": 1 // Specify the ID of the created category
        }
    }
    ```
    This request will create a new product and associate it with the specified category.


## Testing
Postman can be used to test the API endpoints. Simply import the provided Postman collection and execute the requests to interact with the API.

## Contributing
Contributions are welcome! Feel free to submit bug reports, feature requests, or pull requests.

## License
This project is licensed under the [MIT License](LICENSE).
