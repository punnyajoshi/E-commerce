E-commerce Web Application Automated Testing Suite 

This project contains an automated testing suite for an e-commerce web application using Java, Selenium WebDriver, Gradle, TestNG, and Git. The suite covers key functionalities such as Search, Profile Management, Contact, Registration, Login, and Cart Operations.


Tech Stack
Core Language: Java
Web Automation Tool: Selenium WebDriver
Build Tool: Gradle
Version Control: Git
Testing Framework: TestNG



Setup and Execution

Clone the repository:
git clone https://github.com/your-username/ecommerce-web-automation.git

Navigate to the project directory:
cd ecommerce-web-automation

Build the project using Gradle:
gradle clean build

Run the tests using TestNG:
gradle test


Features

Search Functionality Testing

Test the search feature for various input scenarios.
Validate the accuracy and relevance of search results.
Profile Management Testing

Automate testing of user profile creation, editing, and deletion.
Verify the update and management of user details.
Contact Page Testing

Validate form submission on the Contact page.
Test response messages and error handling mechanisms.
User Registration and Login Testing

Automate the process of user registration and login.
Test both successful and unsuccessful authentication scenarios.
Cart Operations Testing

Test adding, removing, and updating items in the shopping cart.
Validate price calculations and checkout procedures.
Page Object Model (POM)

The project implements the Page Object Model (POM) for maintainable code structure. Each web page is represented as a Java class, making the code more organized and easier to maintain.

TestNG

TestNG is used for managing tests, assertions, and generating reports. The test suite consists of multiple test classes, each focusing on a specific feature.

Code Documentation

The source code is well-documented with comments and clear variable names to ensure easy understanding and maintenance.

Best Practices

The project follows best practices in coding and Selenium WebDriver usage, such as using explicit waits, handling implicit waits, and implementing a page object model.

Source Code

The source code is available in the GitHub repository: https://github.com/your-username/ecommerce-web-automation