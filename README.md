# 🧪 SauceDemo Automation Framework

## 📌 Project Overview

This project is a **BDD Automation Framework** developed using Selenium, Cucumber, and TestNG.
It automates key functionalities of the SauceDemo application such as login and cart operations.

---

## 🚀 Tech Stack

* Java
* Selenium WebDriver
* Cucumber (BDD)
* TestNG
* Maven
* Extent Reports
* Log4j

---

## ✅ Scenarios Implemented

### 🔹 Scenario 1: Valid Login

* User logs in with valid credentials
* Verifies navigation to Products page
* Validates products are displayed

### 🔹 Scenario 2: Add Product to Cart

* User selects a product
* Adds product to cart
* Validates cart count
* Verifies product name and price in cart

### 🔹 Scenario 3: Data-Driven Login (JSON)

* Reads credentials from JSON file
* Performs login using dynamic data

---

## ⚙️ Framework Features

* ✔ Page Object Model (POM) design
* ✔ Cross-browser support (Chrome & Edge)
* ✔ Data-driven testing (JSON & Excel utility)
* ✔ Screenshot capture on test failure
* ✔ Logging using Log4j
* ✔ Extent Reports for execution results
* ✔ Configurable via properties file

---

## 📂 Project Structure

```
src/test/java
 ├── base
 ├── pages
 ├── stepdefinitions
 ├── utils
 └── runners

src/test/resources
 ├── features
 ├── config
 └── testdata
```

---

## ▶️ How to Run

1. Clone the repository
2. Navigate to project folder
3. Run the command:

```
mvn clean test
```

---

## 📊 Reports

* Extent Report: `target/ExtentReport.html`
* Logs: `target/logs/test.log`
* Screenshots: `target/screenshots/` (on failure)

---

## 💡 Notes

* Framework supports both WebDriverManager and manual driver setup
* Designed to handle real-world automation challenges like browser setup issues

---

## 👩‍💻 Author

**Eswari**

---
