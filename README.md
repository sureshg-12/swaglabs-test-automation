SwagLabs Automation Testing Project

This repository contains an automation testing framework for SwagLabs, a sample e-commerce application designed for testing purposes. 
The project is built using Java, Selenium WebDriver, and TestNG, and aims to automate the testing of various essential features of the application.
These features include login functionality, homepage interactions, product selection, order placement, and the checkout process.

The project’s structure is organized in a way that ensures ease of use and maintainability. 
The core Java classes are placed in the src/main/java directory, while the test scripts are located under src/test/java. 
The main testing class, SwagLabsTesting.java, contains a variety of test methods designed to validate key functions. 

These include:                                                                                                                            
login_valid(): Verifies successful login using valid credentials.                                                                     
invalid_details(): Tests login with invalid credentials.                                                                        
homepage(): Ensures the homepage is displayed correctly and elements are functional.                                                        
checkout_details(): Validates the checkout process for placing an order.                                                                
order_success(): Confirms that an order is successfully completed.                                                                         

In addition, the project includes a baseclass/Initializemethods.java file, which is responsible for setting up the WebDriver
and performing other necessary initializations required for the tests to run smoothly.

The test results and any captured screenshots from the test executions are stored in the following directories:                                                
/screenshots: Screenshots taken during test execution.                                                                                  
/target/test-output: Detailed reports generated from the tests

Results and Reports                                                                                
During test execution, screenshots are captured for visual validation and saved in the /screenshots folder. 
Detailed execution reports, including pass/fail status, logs, and stack traces, are generated and stored in the /target/test-output folder.

License                                                                                        
This project is licensed under the MIT License. You are free to use, modify, and distribute the code for personal or commercial use.
For more information, please refer to the LICENSE file in the repository.

About the SwagLabs Application                                                                             
SwagLabs is a mock e-commerce application commonly used for automation testing tutorials and practice. It contains sample product listings, shopping cart functionality, 
and a user account system, making it ideal for automating end-to-end testing of a typical online store.
