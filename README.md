**This project is a REST API Automation Framework built with RestAssured + TestNG + Allure Reports using Page Object Model (POM) design pattern.
It provides reusable components for testing APIs such as Books API and Default API (Health, Signup, Login).**

**Tools & Libraries**

Java 11+

Maven

RestAssured – HTTP client for API testing

TestNG – Test runner and reporting

Allure Reports – Rich HTML reports with request/response logs

Jackson / Gson – JSON parsing utilities

**Features**

Follows Page Object Model (POM) for APIs
Reusable Request Builder with Bearer Token support
Token Management 
Centralized Endpoints 
JSON Test Data Driven 
Allure Integration (request & response attachments)
Supports TestNG suite execution via testng.xml

**Test Cases**

Default API Tests

User Signup

User Login & Token Generation

Health Check

Book API Tests

Create Book

Get All Books

Get Book by ID

Update Book

Delete Book

**Reporting
**
Allure captures:

Request body

Response body

Test status (pass/fail)

Report available after test execution in target/allure-results

Future Enhancements

Add DataProvider for multiple book/user test cases

Add Parallel Execution support with TestNG

Integrate with CI/CD (Jenkins/GitHub Actions)

Extend framework for additional APIs
