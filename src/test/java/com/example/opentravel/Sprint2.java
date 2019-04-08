package com.example.opentravel;
import com.example.opentravel.Sprint1;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

import java.io.IOException;

public class Sprint2 {

    String baseUrl = "http://127.0.0.1:8080/";

    public static void BAU(WebDriver driver, Sprint1 sp) {
        String title = "";
        String expectedTitle = "Opentravel";

        driver.get(sp.baseUrl);
        title=driver.getTitle();
        if (!title.equals(expectedTitle)) {
            System.out.println("Failed: Base URL -" + title);
        }

    }

    public static void LUP1(WebDriver driver, Sprint1 sp) {
        String title = "";
        String expectedTitle = "All Places";

        driver.get(sp.baseUrl);
        driver.findElement(By.linkText("OFFERS")).click();
        title=driver.getTitle();
        if (!title.equals(expectedTitle)) {
            System.out.println("Failed: LUP1 -" + title);
        }

    }
    public static void BLO1(WebDriver driver, Sprint1 sp) {
        String title = "";
        String expectedTitle = "Blogs";

        driver.get(sp.baseUrl);
        driver.findElement(By.linkText("BLOG")).click();
        title=driver.getTitle();
        if (!title.equals(expectedTitle)) {
            System.out.println("Failed: BLO1 -" + title);
        }

    }
    public static void USE1(WebDriver driver, Sprint1 sp) {
        String title = "";
        String expectedTitle = "GUIDES";

        driver.get(sp.baseUrl);
        driver.findElement(By.linkText("USERS")).click();
        title=driver.getTitle();
        if (!title.equals(expectedTitle)) {
            System.out.println("Failed: USE1 -" + title);
        }

    }

    public static boolean REG5(WebDriver driver, Sprint1 sp) {
        String title = "";
        String expectedTitle = "About us";

        BAU(driver,sp);
        driver.findElement(By.linkText("ABOUT US")).click();

        title = driver.getTitle();
        if (!title.equals(expectedTitle)) {
            System.out.println("Failed:" + title);
            return false;
        }

        return true;
    }

    public static boolean LUP4(WebDriver driver, Sprint1 sp) throws InterruptedException {
        String title = "";
        String expectedTitle = "Toktogul city";
        BAU(driver,sp);
        LUP1(driver, sp);
        driver.findElement(By.id("Layer_1")).click();
        driver.findElement(By.className("search_content_input")).sendKeys("Toktogul city");
        driver.findElement(By.className("search_content_input")).sendKeys(Keys.ENTER);
        title=driver.getTitle();
        if(title.equals("Places")) {
            System.out.println("Searching not found:"+title);
        }
        System.out.println("Searching found");
        return true;
    }

    public static boolean LUP11(WebDriver driver, Sprint1 sp) throws InterruptedException {
        String title = "";
        String expectedTitle = "Opentravel";
        Sprint1.LUP6(driver, sp);
        BAU(driver, sp);
        driver.findElement(By.partialLinkText("@")).click();
        title = driver.getTitle();
        if (!title.equals("Profile")) {
            System.out.println("Failed:" + title);
            return false;
        }

        driver.findElement(By.linkText(sp.exPlaceName)).click();

        driver.findElement(By.linkText("UPDATE THE PLACE")).click();
        title = driver.getTitle();
        if (!title.equals(expectedTitle)) {
            System.out.println("Failed:" + title);
            return false;
        }

        driver.findElement(By.id("title")).sendKeys(sp.exPlaceName);
        driver.findElement(By.id("address")).sendKeys(sp.exAdress+"updated");
        driver.findElement(By.id("text")).sendKeys(sp.exBlogText+"updated");


        Select categSel = new Select(driver.findElement(By.id("category")));
        categSel.selectByVisibleText("Parks");
        driver.findElement(By.className("login100-form-btn"));
        title = driver.getTitle();
        if (!title.equals("Places")) {
            System.out.println("Failed:" + title);
            return false;
        }
        Sprint1.LUP7(driver, sp);
        System.out.println("Place Updated!!!");
        return true;
    }

    public static boolean BLO3(WebDriver driver, Sprint1 sp) throws InterruptedException {
        String title = "";
        String expectedTitle = "Toktogul city";
        BAU(driver,sp);
        BLO1(driver, sp);
        driver.findElement(By.id("Layer_1")).click();
        Thread.sleep(1000);
        driver.findElement(By.className("search_content_input")).sendKeys(expectedTitle+"\n");
        title=driver.getTitle();
        if(driver.findElement(By.linkText(expectedTitle))==null) {
            System.out.println("Searching not found:"+title);
        }
        System.out.println("Searching found");
        return true;
    }

    public static boolean USE11(WebDriver driver, Sprint1 sp) throws InterruptedException {
        String title = "";
        String expectedTitle = "Nadyr Sultanov";
        BAU(driver,sp);
        USE1(driver, sp);
        driver.findElement(By.id("Layer_1")).click();
        Thread.sleep(1000);
        driver.findElement(By.className("search_content_input")).sendKeys(expectedTitle+"\n");
        title=driver.getTitle();
        if(driver.findElement(By.linkText("Nadyr Sultanov"))==null) {
            System.out.println("Searching not found:"+title);
        }
        System.out.println("Searching found");
        return true;
    }

    public static boolean BLO6(WebDriver driver, Sprint1 sp) throws InterruptedException {
        String title = "";
        String expectedTitle = "Opentravel";
        Sprint1.BLO4(driver, sp);
        BAU(driver, sp);
        driver.findElement(By.partialLinkText("@")).click();
        title = driver.getTitle();
        if (!title.equals("Profile")) {
            System.out.println("Failed:" + title);
            return false;
        }

        driver.findElement(By.linkText(sp.exBlogName)).click();

        driver.findElement(By.linkText("UPDATE THE PLACE")).click();
        title = driver.getTitle();
        if (!title.equals(expectedTitle)) {
            System.out.println("Failed:" + title);
            return false;
        }

        driver.findElement(By.id("title")).sendKeys();
        driver.findElement(By.id("text")).sendKeys(sp.exBlogText+"updated");


        Select categSel = new Select(driver.findElement(By.id("category")));
        categSel.selectByVisibleText("Parks");
        driver.findElement(By.className("login100-form-btn"));
        Sprint1.BLO5(driver, sp);
        title = driver.getTitle();
        if (!title.equals("Places")) {
            System.out.println("Failed:" + title);
            return false;
        }
        System.out.println("Blog Updated!!!");
        return true;
    }



    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "/home/zarlyk/Music/geckodriver");

        WebDriver driver = new FirefoxDriver();
        Sprint1 sp = new Sprint1();

        boolean progress;
        progress = LUP4(driver, sp);
        if (!progress) {
            driver.close();
            System.exit(0);
            return;
        }
        progress = LUP11(driver, sp);
        if (!progress) {
            driver.close();
            System.exit(0);
            return;
        }
        progress = REG5(driver, sp);
        if (!progress) {
            driver.close();
            System.exit(0);
            return;
        }
        progress = BLO3(driver, sp);
        if (!progress) {
            driver.close();
            System.exit(0);
            return;
        }
        progress = USE11(driver, sp);
        if (!progress) {
            driver.close();
            System.exit(0);
            return;
        }
        progress = LUP11(driver, sp);
        if (!progress) {
            driver.close();
            System.exit(0);
            return;
        }

        progress = BLO6(driver, sp);
        if (!progress) {
            driver.close();
            System.exit(0);
            return;
        }
        driver.close();
        System.exit(0);
    }
}
