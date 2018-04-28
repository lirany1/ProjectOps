package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class UntitledTestCase {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://www.katalon.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testUntitledTestCase() throws Exception {
    driver.get("http://52.201.233.250/");
    driver.findElement(By.xpath("//img[@alt='Spree 50 1c7335be355d4672a35c5023956d0c883f254831f3e3dae3f2ca05976ceb5e50']")).click();
    driver.findElement(By.linkText("Mugs")).click();
    driver.findElement(By.linkText("Ruby on Rails Stein")).click();
    driver.findElement(By.id("add-to-cart-button")).click();
    driver.findElement(By.id("order_line_items_attributes_1_quantity")).clear();
    driver.findElement(By.id("order_line_items_attributes_1_quantity")).sendKeys("2");
    driver.findElement(By.id("order_line_items_attributes_1_quantity")).click();
    driver.findElement(By.id("order_line_items_attributes_1_quantity")).clear();
    driver.findElement(By.id("order_line_items_attributes_1_quantity")).sendKeys("3");
    driver.findElement(By.id("order_line_items_attributes_1_quantity")).click();
    driver.findElement(By.id("checkout-link")).click();
    driver.findElement(By.id("order_bill_address_attributes_firstname")).click();
    driver.findElement(By.id("order_bill_address_attributes_firstname")).clear();
    driver.findElement(By.id("order_bill_address_attributes_firstname")).sendKeys("liran");
    driver.findElement(By.id("order_bill_address_attributes_lastname")).clear();
    driver.findElement(By.id("order_bill_address_attributes_lastname")).sendKeys("yushinsky");
    driver.findElement(By.id("order_bill_address_attributes_address1")).clear();
    driver.findElement(By.id("order_bill_address_attributes_address1")).sendKeys("outbrain st");
    driver.findElement(By.id("order_bill_address_attributes_city")).clear();
    driver.findElement(By.id("order_bill_address_attributes_city")).sendKeys("haifa");
    driver.findElement(By.id("order_bill_address_attributes_country_id")).click();
    new Select(driver.findElement(By.id("order_bill_address_attributes_country_id"))).selectByVisibleText("Israel");
    driver.findElement(By.id("order_bill_address_attributes_country_id")).click();
    driver.findElement(By.id("order_bill_address_attributes_state_id")).click();
    new Select(driver.findElement(By.id("order_bill_address_attributes_state_id"))).selectByVisibleText("Hefa");
    driver.findElement(By.id("order_bill_address_attributes_state_id")).click();
    driver.findElement(By.id("order_bill_address_attributes_zipcode")).click();
    driver.findElement(By.id("order_bill_address_attributes_zipcode")).clear();
    driver.findElement(By.id("order_bill_address_attributes_zipcode")).sendKeys("32982");
    driver.findElement(By.id("order_bill_address_attributes_phone")).click();
    driver.findElement(By.id("order_bill_address_attributes_phone")).clear();
    driver.findElement(By.id("order_bill_address_attributes_phone")).sendKeys("97202423423424");
    driver.findElement(By.name("commit")).click();
    driver.findElement(By.linkText("Home")).click();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
