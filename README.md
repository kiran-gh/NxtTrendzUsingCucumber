<h1>Project Overview</h1>

**Automation Testing for NxtTrendz Website Using Cucumber**
<p>This project is designed to automate the testing of the NxtTrendz website's functionality, specifically
focusing on the login and registration features. The automation framework is built using Cucumber with
Selenium WebDriver to perform behavior-driven testing (BDD) for validating the user flows on the website.
The website under test can be accessed here: NxtTrendz Website.</p>

**Objective:**
<p>The primary goal of this automation testing project is to ensure the accuracy and reliability of the key
functionalities on the NxtTrendz website, including:</p>

1. **User Login:** Verifying the login process with valid and invalid credentials.
2. **User Registration:** Testing the registration flow to ensure users can sign up correctly.
3. **Home Page** : Validating the home page elements and their functionality.
4. **Product Page** : Ensuring the product page loads correctly and displays the product details.
5. **Cart Page** : Verifying the cart page functionality, including adding and removing products.


<h1>Technologies Used</h1>

- **Java**: Programming language for writing the test scripts.
- **Cucumber**: BDD framework for writing test cases in Gherkin language.
- **JUnit**: Test runner used for executing the Cucumber test scenarios.
- **Selenium WebDriver**: For browser automation and interacting with the web elements.
- **Page Object Model (POM)**: Design pattern to structure the framework and maintain page classes.


<h1>Key Components:</h1>

**Page Object Model (POM):** <br>
The pages directory contains classes representing web pages with methods that map to web elements and actions.

**Step Definitions:**<br> Located in stepDefinitions, these classes map the steps written in Gherkin to Java code that interacts with the web application.

**Hooks:**<br> Pre and post conditions (such as WebDriver setup and teardown) are defined here to run before or after each test scenario.

**WebDriverFactory:**<br> A class responsible for setting up and managing WebDriver instances across multiple browsers and environments.

**Utility:**<br> Contains helper methods, reusable components like wait methods, and reporting utilities.

**Features:**<br> The features folder contains .feature files written in Gherkin syntax, describing test scenarios.

**Configuration:**<br> The config.properties file contains project-specific configurations such as URL, browser, etc.

**Resources:**<br> Additional data required for the tests such as test data files and configuration.properties.



<h1>Framework Components:</h1> 

**1. Cucumber with BDD:**
Test scenarios are written in Gherkin syntax to describe the behavior of the website
in a readable and maintainable way.

**2. Selenium WebDriver:** 
Used to interact with the website's UI elements to simulate user actions like 
clicking, typing, and form submissions.

**3. JUnit:** Serves as the test runner, allowing us to execute the Cucumber test scenarios.

**4.Page Object Model (POM):** The framework uses POM to separate the test logic from the actual page actions,
ensuring clean and maintainable code.

<h1>Reports and Results:</h1>
The project is configured to generate test execution reports in both JSON and XML formats. These reports
can be used to monitor the success of the test cases and identify any failures or issues.After running
the tests, reports will be generated in the target folder. The reports are in both JSON and XML formats.

**JSON Report:** target/cucumber-reports/Cucumber.json<br>
**XML Report:** target/cucumber-reports/Cucumber.xml<br>
**Published Report:** Once all the tests are executed, the reports are published online. Navigate to 
the bottom of the terminal to get the published report link.The published report is in HTML format
and can be viewed in a web browser. The report provides a summary of the test execution, including
the number of passed, failed, and skipped tests, as well as detailed information about each test case,
including the steps and their status.

<h1>Setup and Configuration:</h1>

**Prerequisites:**
<p>1. Java 8+ installed</p>
<p>2. Maven installed</p>
<p>3. IDE (e.g., IntelliJ IDEA or Eclipse)</p>


<h1>Project Benefits:</h1>

<p>1. Efficiency: Automating repetitive tasks such as login and registration increases testing efficiency and frees up manual testers to focus on more complex test cases.</p>
<p>2. Reliability: Automated tests reduce the chance of human error during regression testing.</p>
<p>3. Maintainability: The use of Cucumber and Page Object Model makes the tests easy to maintain and scale as the application evolves.</p>

<h1>Conclusion</h1>
This automation testing framework will provide a robust solution to ensure the proper functionality of 
critical user interactions on the NxtTrendz website. It ensures that the core features, such as login 
and registration, perform reliably under various conditions, contributing to the overall quality and 
user experience of the web application.


<h1>Author:</h1>

**Vogeti Satya Kiran** 

- **Email**: vogetisatyakiran@gmail.com
- **Phone**: +91 7382482271
- **GitHub**: https://github.com/kiran-gh
- **LinkedIn**: https://www.linkedin.com/in/vogeti-satya-kiran/

**About the Author**
Automation Testing Engineer with a strong background of 3.5 years automation testing experience. Skilled 
in creating automated tests using Cucumber and Page Object Model, ensuring the reliability and 
maintainability of web applications.