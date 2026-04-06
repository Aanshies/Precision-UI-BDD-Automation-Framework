# Precision UI BDD Automation Framework

## Overview
**Precision UI BDD Automation Framework** is a robust, end-to-end automation suite designed to validate critical user journeys on E-commerce platforms (Search, Cart Management, and Checkout). Built as a technical assignment for **Veeva Systems**, this framework focuses on high reliability, cross-browser compatibility, and modular design.

## Features
* **Behavior Driven Development:** Feature files written in Gherkin for clear stakeholder communication.
* **Cross-Browser Support:** Configured for seamless execution on Chrome and Edge browsers.
* **Enhanced Logging:** Integrated Log4j for detailed execution debugging and traceability.
* **Scalable Architecture:** Modular Page Objects to ensure zero code redundancy and easy maintenance.
* **Professional Reporting:** Integrated Extent Reports for clear visualization of test results.

## Technologies Used
* **Language:** Java
* **Automation Tool:** Selenium WebDriver
* **Framework:** Cucumber (BDD)
* **Design Pattern:** Page Object Model (POM)
* **Build Tool:** Maven
* **Reporting:** Extent Reports & Log4j

## Installation
### Prerequisites
* JDK 11 or higher
* Apache Maven installed
* Google Chrome or Microsoft Edge browser

### Setup
1. Clone the repository:
   `git clone https://github.com/Aanshies/Precision-UI-BDD-Automation-Framework.git`
2. Navigate to the project directory.
3. Install dependencies:
   `mvn install`

## Usage
* Run the automation suite via the `TestRunner` class.
* Execute via terminal using the command: `mvn test`.
* Review execution logs in the `/logs` directory.
* Open `extent-report.html` in your browser to view final test results.

## Acknowledgements
* **Veeva Systems** for the technical challenge.
* Selenium and Cucumber Open Source Communities.
