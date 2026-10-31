# Java Selenium E-Commerce Automation Framework

## Project Overview

This project is a Java-based Selenium Automation Framework developed to automate end-to-end e-commerce application workflows.

The framework follows the Page Object Model (POM) design pattern and uses TestNG for test execution, Apache POI for Excel-driven test data, Log4j2 for logging, and ExtentReports for test reporting.

**Application Under Test:** https://shop.qaautomationlabs.com/

## Technologies Used

- Java 21
- Selenium WebDriver
- TestNG
- Maven
- Apache POI
- Log4j2
- ExtentReports
- Page Object Model (POM)
- Git and GitHub
- Eclipse IDE

## Framework Features

### 1. Page Object Model (POM)
- Implemented POM for better code reusability and maintainability.
- Separated page locators and page actions from test classes.

### 2. Excel-Driven Testing
- Integrated Apache POI to read test data from Excel files.
- Supports execution of multiple test data sets using TestNG DataProvider.

### 3. Parallel Execution
- Configured TestNG parallel execution.
- Used ThreadLocal WebDriver to manage independent browser instances for parallel tests.

### 4. Logging
- Integrated Log4j2 for execution logs.
- Captures important test execution information and failures.

### 5. Test Reporting
- Integrated ExtentReports to generate execution reports.
- Reports include passed, failed, and skipped test results.

### 6. Screenshot Capture
- Captures screenshots when tests fail.
- Attaches screenshots to ExtentReports.

### 7. Retry Mechanism
- Implemented TestNG RetryAnalyzer.
- Automatically retries failed test cases based on the configured retry count.

### 8. TestNG Listeners
- Implemented TestNG listeners to manage test execution events.
- Integrated listener functionality with ExtentReports and screenshot capture.

## Project Structure

```text
E-commerce
│
├── src/main/java
│   └── com/commerce
│       ├── baseclass
│       ├── pages
│       ├── actionclass
│       └── utilities
│
├── src/main/resources
│   └── config.properties
│
├── src/test/java
│   └── EcommerceTestCases
│
├── src/test/resources
│   ├── ExcelFile
│   └── ScreenShot
│
├── pom.xml
├── testng.xml
├── .gitignore
└── README.md
```

## Test Scenarios

- Application login.
- Product selection and adding products to cart.
- Cart product validation.
- Billing address entry.
- Order confirmation details validation.
- Order submission and success message validation.
- Excel-driven execution with multiple product combinations.

## How to Execute

1. Clone the repository.
2. Import the project into Eclipse as an existing Maven project.
3. Update the browser and application URL in `config.properties`.
4. Verify the Excel test data file and required dependencies.
5. Right-click `testng.xml`.
6. Select **Run As → TestNG Suite**.

## GitHub Repository

[Java Selenium E-Commerce Automation Framework](https://github.com/Islamuddin5330/Selenium-Ecommerce-Automation)

## Author

**Islamuddin**

QA Automation Engineer | Java | Selenium | TestNG | Playwright
