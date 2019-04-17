/*package com.example.opentravel.test;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;

public class Sprint2 {




    public static boolean REG5(WebDriver driver, Sprint1 sp) {
        String title = "";
        String expectedTitle = "About Us";

        Sprint1.BAU(driver,sp);
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
        Sprint1.BAU(driver,sp);
        Sprint1.LUP1(driver, sp);
        driver.findElement(By.id("Layer_1")).click();
        driver.findElement(By.className("search_content_input")).sendKeys("Toktogul city");
        driver.findElement(By.className("search_content_input")).sendKeys(Keys.ENTER);
        Thread.sleep(5000);
        title=driver.getTitle();
        System.out.println("Searching found");
        return true;
    }

    public static boolean LUP11(WebDriver driver, Sprint1 sp) throws InterruptedException {
        String title = "";
        String expectedTitle = "Opentravel";
        Sprint1.LUP6(driver, sp);
        Sprint1.BAU(driver, sp);
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
        if (!title.equals("Opentravel")) {
            System.out.println("Failed:" + title);
            return false;
        }
        System.out.println("Place Updated!!!");
        Sprint1.LUP7(driver, sp);
        return true;
    }

    public static boolean BLO3(WebDriver driver, Sprint1 sp) throws InterruptedException {
        String title = "";
        String expectedTitle = "Toktogul city";
        Sprint1.BAU(driver,sp);
        Sprint1.BLO1(driver, sp);
        driver.findElement(By.id("Layer_1")).click();
        Thread.sleep(1000);
        driver.findElement(By.className("search_content_input")).sendKeys(expectedTitle+"\n");
        title=driver.getTitle();
        System.out.println("Searching found");
        return true;
    }

    public static boolean USE11(WebDriver driver, Sprint1 sp) throws InterruptedException {
        String title = "";
        String expectedTitle = "Nadyr Sultanov";
        Sprint1.BAU(driver,sp);
        Sprint1.USE1(driver, sp);
        driver.findElement(By.id("Layer_1")).click();
        Thread.sleep(1000);
        driver.findElement(By.className("search_content_input")).sendKeys(expectedTitle+"\n");
        title=driver.getTitle();
        System.out.println("hehehe");
        WebElement el=driver.findElement(By.linkText("Nadyr Sultanov"));
        if(el==null) {
            System.out.println("Searching not found:"+title);
        }
        System.out.println("Searching found");
        return true;
    }

    public static boolean BLO6(WebDriver driver, Sprint1 sp) throws InterruptedException {
        String title = "";
        String expectedTitle = "Opentravel";
        Sprint1.BLO4(driver, sp);
        Sprint1.BAU(driver, sp);
        driver.findElement(By.partialLinkText("@")).click();
        title = driver.getTitle();
        if (!title.equals("Profile")) {
            System.out.println("Failed:" + title);
            return false;
        }

        driver.findElement(By.linkText(sp.exBlogName)).click();

        driver.findElement(By.linkText("UPDATE THE BLOG")).click();
        title = driver.getTitle();

        driver.findElement(By.id("text")).sendKeys(sp.exBlogText+"updated");


        Select categSel = new Select(driver.findElement(By.id("category")));
        categSel.selectByVisibleText("Parks");
        driver.findElement(By.cssSelector("input[value*='UPDATE']")).click();
        Sprint1.BLO5(driver, sp);
        title = driver.getTitle();

        if (!title.equals("Opentravel")) {
            System.out.println("Failed:" + title);
            return false;
        }
        System.out.println("Blog Updated!!!");
        return true;
    }



    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\tanya\\Downloads\\programs\\geckodriver.exe");

        WebDriver driver = new FirefoxDriver();
        Sprint1 sp = new Sprint1();

        Sprint1.logIn(driver,sp);
        boolean progress;
        /*progress = LUP4(driver, sp);
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
        }*/
        /*progress = LUP11(driver, sp);
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
}*/