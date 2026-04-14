# Precision UI BDD Automation Framework

## Overview

**Precision UI BDD Automation Framework** is a robust, end-to-end automation suite designed to validate critical user journeys on E-commerce platforms (Search and Cart Management). Built as a technical assignment for **Veeva Systems**, this framework emphasizes scalability, maintainability, and real-world automation practices.

---

## Architecture Diagram

The framework follows a **Hybrid Architecture** combining Behavior Driven Development (BDD) and Page Object Model (POM).

![Architecture Diagram](https://github.com/user-attachments/assets/7f6f0675-07c4-41c7-8c94-1e3aa277fb35)
---

## Features

* **Behavior Driven Development (BDD):** Feature files written in Gherkin for better readability and collaboration.
* **Page Object Model (POM):** Promotes reusable and maintainable code structure.
* **Cross-Browser Support:** Supports execution on Chrome and Edge browsers via configuration.
* **Explicit Wait Handling:** Ensures stability by handling dynamic web elements.
* **Window Handling:** Supports multi-tab scenarios (product selection flow).
* **Modular Framework Design:** Clean separation of concerns across layers.
* **Professional Reporting:** Generates Cucumber HTML reports for execution results.

---

## Technologies Used

* **Language:** Java
* **Automation Tool:** Selenium WebDriver
* **Framework:** Cucumber (BDD) + TestNG
* **Design Pattern:** Page Object Model (POM)
* **Build Tool:** Maven
* **Reporting:** Cucumber HTML Reports

---

## Project Structure

```
src/
 ├── main/java/com/automation/
 │   ├── base/
 │   ├── pages/
 │   ├── utils/
 │
 ├── test/java/com/automation/
 │   ├── stepdefinitions/
 │   ├── runner/
 │
 ├── test/resources/
 │   ├── features/
 │   ├── config/
 │
 └── pom.xml
```

---

## Test Scenarios

### Scenario 1: Search Product

* Navigate to Amazon homepage
* Search for product (iPhone)
* Validate search results

### Scenario 2: Add to Cart

* Search for product (Laptop)
* Select first product
* Switch to new tab
* Add product to cart
* Validate cart count

---

## Maven Execution

Run the framework using:

```
mvn clean test
```

This will execute all scenarios and generate reports in the target folder.

---

## Installation

### Prerequisites

* JDK 11 or higher
* Apache Maven installed
* Google Chrome or Microsoft Edge

### Setup Steps

1. Clone the repository:

```
git clone https://github.com/Aanshies/Precision-UI-BDD-Automation-Framework.git
```

2. Navigate to the project directory:

```
cd Precision-UI-BDD-Automation-Framework
```

3. Install dependencies:

```
mvn install
```

---

## Usage

* Run tests using the TestRunner class
* Or execute using Maven:

```
mvn clean test
```

---

## Execution Report

Below are sample execution reports generated after test execution:

![Cucumber Report 1](https://github.com/user-attachments/assets/074ac7a3-4914-403b-b930-a1a73a049ef0)

![Cucumber Report 2](https://github.com/user-attachments/assets/dc51001f-75a4-494a-a694-f19a10223925)

![Cucumber Report(DD)](<img width="1208" height="556" alt="Image" src="https://github.com/user-attachments/assets/3fc9d44e-820b-43c1-a89a-d8c83a84ee1e" />)
---

## Key Highlights

* Hybrid Framework (BDD + POM)
* Cross-browser execution using config file
* Explicit waits for dynamic element handling
* Window handling for multi-tab scenarios
* Scalable and maintainable framework design

---

## Team Contribution

* **M. Eswari:** Framework setup, Scenario 2 implementation, POM design, enhancements
* **Ch. Sravani:** Framework setup, Scenario 1 implementation, reporting

---

## Acknowledgements

* **Veeva Systems** for the technical assignment
* Selenium and Cucumber Open Source Communities
