# Provide IT Consulting – Coding Challenge (Java Spring)

## Overview
You will develop an application to demonstrate your understanding of **Java backend development**.  
The app should expose a **JSON API** that clients can call to fetch data stored in your database.  
If the data is not available locally, it should be fetched from an **upstream API**.

You are given a set of **functional requirements** describing the behavior of the application, as well as **implementation suggestions**.  
Read carefully before you begin to fully understand the task.

---

## Task Details
The application should expose **two JSON endpoints**:
1. **Product listing**
2. **Product details**

The app will read product data from a REST API and display detailed information for each item in a separate endpoint.

You will use the following REST API (see documentation at [https://fakestoreapi.com](https://fakestoreapi.com)):

### Product listing endpoint
- **Method:** GET  
- **Action:** Get all products  
- **URI:** `https://fakestoreapi.com/products`

### Product details endpoint
- **Method:** GET  
- **Action:** Get a specific product by ID  
- **URI:** `https://fakestoreapi.com/products/{productid}`

---

## Tasks to Complete

### 1. Product Listing Endpoint
- Build an endpoint for **product listing**.  
- The listing should display:
  - Image  
  - Title  
  - Price  
  - Category  
- The listing should show **at most 8 products per page** and support **pagination**.

### 2. Product Details Endpoint
- Build an endpoint for **product details**.  
- The details view should include all product information:
  - Image, Title, Price, Category, and Description.

### 3. Filtering by Price
- Add filtering by **price range** (Min–Max).

### 4. Filtering by Category
- Add filtering by **category**.

---

## Technologies to Use
- **Java Spring** (Spring Boot)
- **Database engine** of your choice (e.g. H2, MySQL, PostgreSQL)

---

## Points to Consider
1. Optimize code to **avoid unnecessary HTTP calls**.
2. Implementing **tests** (unit/integration) will earn **bonus points**.

---

## API Reference
- [Fake Store API Documentation](https://fakestoreapi.com)
- Example product:  
  `https://fakestoreapi.com/products/1`

---

## Suggested Steps
1. Set up a Spring Boot project.
2. Create service and repository layers for product handling.
3. Implement caching or database persistence to reduce external calls.
4. Add pagination and filtering logic.
5. Implement tests (e.g. with JUnit or Mockito).

---

## Output Example

**GET /products**
```json
[
  {
    "id": 1,
    "title": "Fjallraven Backpack",
    "price": 109.95,
    "category": "men's clothing",
    "image": "https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_.jpg"
  }
]
```

**GET /products/1**
```json
{
  "id": 1,
  "title": "Fjallraven Backpack",
  "price": 109.95,
  "description": "Your perfect pack for everyday use...",
  "category": "men's clothing",
  "image": "https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_.jpg"
}
```
