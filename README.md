▶️ Prerequisites
Java 17 installed

Maven installed

Internet access (tests run on SauceDemo)

▶️ How to Run Tests
Run full suite:

bash
mvn clean test -DsuiteXmlFile=testng.xml
Run specific test class:

bash
mvn test -Dtest=ResetAppStateTest
Run from IntelliJ:

Right-click testng.xml → Run 'SauceDemo Test Suite'

🧰 Framework Highlights
✅ Page Object Model (POM) for clean separation of logic

✅ Screenshot on Failure via ScreenshotUtil.java

✅ Reusable Test Base with centralized setup/teardown

✅ Configurable via config.properties

✅ Bug documentation with GIF/screenshot evidence

🧪 Test Coverage
Category	Test Classes	Purpose
🟢 Login	LoginTest, LoginNegativeTest	Valid & invalid login scenarios
🟣 Cart	AddToCartTest, RemoveFromCartTest	Add/remove product flow
🟡 Inventory	InventorySortTest	Sorting by name/price
🟠 Price Verification	PriceVerificationTest, MultipleProductPriceVerificationTest	Subtotal validation
🔵 Checkout	CheckoutTest	End-to-end checkout
🔴 Reset App State	ResetAppStateTest	Detects UI bug after reset
🐞 Known Bug: Reset App State
Issue: “Remove” button remains after cart reset

Expected: Button should revert to “Add to cart”

Actual: UI still shows “Remove” despite empty cart

Evidence: Screenshot + GIF in /docs

🧩 Project Structure
Code
SauceLabsAutomationFramework/
├── pom.xml
├── testng.xml
├── config.properties
├── docs/ (bug evidence)
├── screenshots/ (auto-captured failures)
├── src/
│   ├── main/java/com/example/
│   │   ├── pageobject/ (LoginPage, CartPage, etc.)
│   │   └── utilities/ (ScreenshotUtil, ConfigReader)
│   └── test/java/com/example/tests/ (all test classes)
📈 Planned Enhancements
🔹 ExtentReports integration

🔹 Retry Analyzer for flaky tests

🔹 Parallel execution support

🔹 Jenkins CI/CD pipeline

🔹 Data-driven testing with Apache POI
