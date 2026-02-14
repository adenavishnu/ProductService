# Products Service

A Spring Boot microservice for managing e-commerce products, categories, and inventory.

## Tech Stack

- **Java 25**
- **Spring Boot 4.0.2**
- **Spring Data JPA**
- **MySQL**
- **Lombok**
- **Maven**

## Features

- CRUD operations for products
- Product categorization
- Product image gallery support
- Input validation
- RESTful API design

## Prerequisites

- JDK 25+
- Maven 3.9+
- MySQL 8.0+

## Getting Started

### 1. Clone the Repository

```bash
git clone <repository-url>
cd ProductsService
```

### 2. Configure Environment Variables

Create a `.env` file or set the following environment variables:

```properties
SERVER_PORT=8082
MYSQLHOST=localhost
MYSQLPORT=3306
MYSQLDATABASE=products_db
MYSQLUSER=your_username
MYSQLPASSWORD=your_password
```

### 3. Create the Database

```sql
CREATE DATABASE products_db;
```

### 4. Build the Project

```bash
# Windows
.\mvnw.cmd clean install

# Linux/Mac
./mvnw clean install
```

### 5. Run the Application

```bash
# Windows
.\mvnw.cmd spring-boot:run

# Linux/Mac
./mvnw spring-boot:run
```

The service will start at `http://localhost:8082`

## API Endpoints

### Products

| Method | Endpoint                   | Description              |
|--------|----------------------------|--------------------------|
| GET    | `/api/products`            | Get all products         |
| GET    | `/api/products/{id}`       | Get product by ID        |
| POST   | `/api/products`            | Create a new product     |
| PATCH  | `/api/products/{id}`       | Update a product         |
| DELETE | `/api/products/{id}`       | Delete a product         |
| GET    | `/api/products/category/{id}` | Get products by category |
| GET    | `/api/products/categories` | Get all categories       |

### Request/Response Examples

#### Create Product Request

```json
{
  "productName": "Wireless Headphones",
  "description": "Premium noise-cancelling headphones",
  "price": 199.99,
  "quantity": 50,
  "thumbnail": {
    "url": "https://example.com/image.jpg"
  },
  "category": {
    "id": "uuid-here",
    "name": "Electronics"
  }
}
```

#### Product Response

```json
{
  "id": "550e8400-e29b-41d4-a716-446655440000",
  "productName": "Wireless Headphones",
  "description": "Premium noise-cancelling headphones",
  "price": 199.99,
  "quantity": 50,
  "thumbnail": {
    "url": "https://example.com/image.jpg"
  },
  "productGallery": [],
  "category": {
    "id": "uuid-here",
    "name": "Electronics"
  }
}
```

## Project Structure

```
src/main/java/com/ecommerce/productsservice/
├── EcommerceProductsServiceApplication.java  # Main application entry point
├── configurations/                            # Configuration classes
│   └── RestTemplateConfig.java
├── controllers/                               # REST controllers
│   ├── FakeStoreController.java
│   └── ProductController.java
├── dtos/                                      # Data Transfer Objects
│   ├── ProductRequest.java
│   └── ProductResponse.java
├── mappers/                                   # Entity-DTO mappers
│   ├── IProductMapper.java
│   └── ProductMapper.java
├── models/                                    # JPA entities
│   ├── BaseModel.java
│   ├── Category.java
│   ├── ImageRef.java
│   └── Product.java
├── repository/                                # Spring Data repositories
│   └── ProductsRepository.java
└── services/                                  # Business logic layer
    ├── FakeStoreServiceI.java
    ├── IProductService.java
    └── ProductsService.java
```

## Testing

```bash
# Run tests
.\mvnw.cmd test

# Run tests with coverage
.\mvnw.cmd test jacoco:report
```

## Contributing

See [CONTRIBUTING.md](CONTRIBUTING.md) for guidelines.

## License

This project is licensed under the Apache License 2.0 - see the [LICENSE](LICENSE) file for details.
