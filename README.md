## ▶️ How to run
**Prerequisites**
- Java 17 installed
- Maven installed
- Internet access (tests use https://www.saucedemo.com)
mvn clean test -DsuiteXmlFile=testng.xml

🧩 SauceLabs Automation Framework 🚀

One-line summary:
Selenium + TestNG + POM automation framework for SauceDemo — includes login, cart, checkout, sorting, and reset state tests with screenshot capture and bug tracking.

🔎 Project Overview

This project is a complete Selenium WebDriver automation framework built from scratch using Java, TestNG, and Maven following the Page Object Model (POM) design pattern.

It automates the SauceDemo
 web application to verify critical e-commerce functionalities such as login, add-to-cart, checkout, price validation, and UI behavior.

This framework is designed to be resume-ready for QA Automation portfolios — demonstrating not just automation, but also bug detection, structured reporting, and professional framework design.

⚙️ Tech Stack
Tool / Library	Purpose
Java 17	Programming language
Selenium WebDriver 4.35.0	Browser automation
TestNG 7.11.0	Test framework
Maven	Build and dependency management
WebDriverManager	Auto browser driver handling
ExtentReports	HTML reporting (for future use)
Commons IO	Screenshot file handling
SLF4J Simple Logger	Lightweight logging
Page Object Model (POM)	Design pattern for reusability
🧪 Test Coverage
Category	Test Class	Description
🟢 Login	LoginTest, LoginNegativeTest	Valid & invalid login validations
🟣 Cart	AddToCartTest, RemoveFromCartTest	Add & remove product flow
🟡 Inventory	InventorySortTest	Verifies product sorting (name/price)
🟠 Price Verification	PriceVerificationTest, MultipleProductPriceVerificationTest	Ensures subtotal = sum of item prices
🔵 Checkout	CheckoutTest	End-to-end checkout validation
🔴 Reset App State	ResetAppStateTest	Detects UI defect — button state not refreshing after reset
📸 Screenshot Utility	ScreenshotUtil.java	Captures screen automatically on test failure
🧰 Framework Highlights

✅ Page Object Model (POM) — separation of page logic & test logic
✅ Reusable Test Base — centralized setup & teardown in BaseTest
✅ Screenshot on Failure — stored in /screenshots folder automatically
✅ Config-Driven — all environment variables stored in config.properties
✅ TestNG Suite Execution — all test classes run via testng.xml
✅ Known Bug Documentation — includes GIF & screenshot proof of a UI bug

🧩 Project Structure
SauceLabsAutomationFramework/
│
├── pom.xml
├── testng.xml
├── README.md
├── config.properties
│
├── docs/
│   ├── demo.gif
│   └── reset_bug_screenshot.png
│
├── screenshots/
│   └── (auto screenshots on test failures)
│
├── src/
│   ├── main/java/com/example/
│   │   ├── pageobject/
│   │   │   ├── LoginPage.java
│   │   │   ├── InventoryPage.java
│   │   │   ├── CartPage.java
│   │   │   ├── CheckoutPage.java
│   │   │   └── LogoutPage.java
│   │   └── utilities/
│   │       ├── ScreenshotUtil.java
│   │       └── ConfigReader.java
│   └── test/java/com/example/tests/
│       ├── LoginTest.java
│       ├── LoginNegativeTest.java
│       ├── LogoutTest.java
│       ├── AddToCartTest.java
│       ├── RemoveFromCartTest.java
│       ├── InventorySortTest.java
│       ├── PriceVerificationTest.java
│       ├── MultipleProductPriceVerificationTest.java
│       ├── CheckoutTest.java
│       └── ResetAppStateTest.java

🧠 How to Run Tests
Run entire suite
mvn clean test -DsuiteXmlFile=testng.xml

Run a specific test class
mvn test -Dtest=ResetAppStateTest

Run from IntelliJ

Right-click on testng.xml → Run 'SauceDemo Test Suite'

🖼 Screenshot Storage

Path: /screenshots/

Screenshots are automatically captured on any test failure via ScreenshotUtil.java.

Filenames include timestamps for easy identification.

🧩 Configuration File (config.properties)
baseUrl=https://www.saucedemo.com/
browser=firefox
implicitWait=10
headless=false


You can easily switch browsers (Chrome/Firefox) or enable headless mode from here.

🧾 Known Issue: Reset App State Bug
🐞 Bug Description

After performing Reset App State from the sidebar menu, the “Remove” button remains visible on product cards — even though the cart is emptied.
This represents a UI desynchronization bug: the frontend does not re-render product states after reset.

Step	Action	Expected	Actual
1️⃣	Login as standard_user	Login successful	✅
2️⃣	Add "Sauce Labs Backpack" to cart	Added successfully	✅
3️⃣	Open menu → click “Reset App State”	Button resets to “Add to cart”	❌ Button still shows “Remove”
4️⃣	Check cart icon	Empty	✅


📸 Screenshot Evidence

Screenshot captured during failed automation test showing the UI state inconsistency.

✅ Expected Behavior

After reset, all buttons should revert to “Add to cart” and the cart should be empty.

❌ Actual Behavior

UI still displays “Remove” button for previously added products even though the cart is cleared.

📈 Future Enhancements
Feature	Description
🔹 Extent Reports Integration	Add HTML report generation with screenshots
🔹 Retry Analyzer	Auto re-run flaky tests
🔹 Parallel Execution	Multi-browser execution support
🔹 Jenkins Integration	CI/CD pipeline execution
🔹 Data-Driven Testing	Integrate Apache POI for Excel-based data input
📊 Example Test Report (coming soon)

ExtentReport integration in progress — next update will include detailed HTML test execution logs with embedded screenshots.

👨‍💻 Author

Vishnu Kant
Full Stack QA | Selenium + Java Automation
📧 [vishnukantkushwaha077@gmail.com]
🔗 GitHub: vishnukant0010

🧾 License

This project is open-source under the MIT License — free to use and modify.

🏁 Quick Summary

✅ Built from scratch using Java + Selenium + TestNG
✅ Fully functional automation suite (Login → Checkout)
✅ Screenshot capture on failure
✅ Configurable browser setup
✅ Detects real UI bug (Reset App State issue)
✅ Ready for Jenkins or ExtentReport integration
