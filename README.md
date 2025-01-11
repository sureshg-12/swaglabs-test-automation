SwagLabs Automation Testing Project

This repository contains an automation testing framework for SwagLabs, a sample e-commerce application designed for testing purposes. The project is built using Java, Selenium WebDriver, and TestNG, and aims to automate the testing of various essential features of the application. These features include login functionality, homepage interactions, product selection, order placement, and the checkout process.

The project’s structure is organized in a way that ensures ease of use and maintainability. The core Java classes are placed in the src/main/java directory, while the test scripts are located under src/test/java. The main testing class, SwagLabsTesting.java, contains a variety of test methods designed to validate key functions. 

These include:
login_valid(): Verifies successful login using valid credentials.
invalid_details(): Tests login with invalid credentials.
homepage(): Ensures the homepage is displayed correctly and elements are functional.
checkout_details(): Validates the checkout process for placing an order.
order_success(): Confirms that an order is successfully completed.
In addition, the project includes a baseclass/Initializemethods.java file, which is responsible for setting up the WebDriver and performing other necessary initializations required for the tests to run smoothly.

The test results and any captured screenshots from the test executions are stored in the following directories:
/screenshots: Screenshots taken during test execution.
/target/test-output: Detailed reports generated from the tests

