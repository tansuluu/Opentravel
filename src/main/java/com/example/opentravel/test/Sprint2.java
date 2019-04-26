//package com.example.opentravel.test;
//
//import org.openqa.selenium.*;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.support.ui.Select;
//
//import java.io.IOException;
//
//public class Sprint2 {
//
//
//
//
//    public static boolean REG5(WebDriver driver, Main sp) {
//        String title = "";
//        String expectedTitle = "About Us";
//
//        Sprint1.BAU(driver,sp);
//        driver.findElement(By.linkText("ABOUT US")).click();
//
//        title = driver.getTitle();
//        if (!title.equals(expectedTitle)) {
//            System.out.println("Failed:" + title);
//            return false;
//        }
//
//        return true;
//    }
//
//    public static boolean LUP4(WebDriver driver, Main sp) throws InterruptedException {
//        String title = "";
//        String expectedTitle = "Toktogul city";
//        Sprint1.BAU(driver,sp);
//        Sprint1.LUP1(driver, sp);
//        driver.findElement(By.id("Layer_1")).click();
//        driver.findElement(By.className("search_content_input")).sendKeys("kg1");
//        driver.findElement(By.className("search_content_input")).sendKeys(Keys.ENTER);
//        Thread.sleep(500);
//        driver.findElement(By.xpath("//*[text()[contains(.,'kg1')]]")).click();
//        Sprint1.checkTitle(driver,"Places");
//        System.out.println("Searching found");
//        return true;
//    }
//
//    public static boolean LUP11(WebDriver driver, Main sp) throws InterruptedException {
//        String title = "";
//        String expectedTitle = "Opentravel";
//        Sprint2.LUP4(driver, sp);
//
//        driver.findElement(By.linkText("UPDATE THE PLACE")).click();
//        title = driver.getTitle();
//        if (!title.equals(expectedTitle)) {
//            System.out.println("Failed:" + title);
//            return false;
//        }
//
//        driver.findElement(By.id("title")).sendKeys(sp.exPlaceName);
//        driver.findElement(By.id("address")).sendKeys(sp.exAdress+"updated");
//        driver.findElement(By.id("text")).sendKeys(sp.exBlogText+"updated");
//
//
//        Select categSel = new Select(driver.findElement(By.id("category")));
//        categSel.selectByVisibleText("Parks");
//        driver.findElement(By.className("login100-form-btn"));
//        title = driver.getTitle();
//        if (!title.equals("Opentravel")) {
//            System.out.println("Failed:" + title);
//            return false;
//        }
//        System.out.println("Place Updated!!!");
//        return true;
//    }
//
//    public static boolean BLO3(WebDriver driver, Main sp) throws InterruptedException {
//        String title = "";
//        String expectedTitle = "KG";
//        Sprint1.BAU(driver,sp);
//        Sprint1.BLO1(driver, sp);
//        driver.findElement(By.id("Layer_1")).click();
//        Thread.sleep(1000);
//        driver.findElement(By.className("search_content_input")).sendKeys("KG");
//        driver.findElement(By.className("search_content_input")).sendKeys(Keys.ENTER);
//        Thread.sleep(5000);
//        driver.findElement(By.xpath("//*[text()[contains(.,'KG')]]")).click();
//        title=driver.getTitle();
//        System.out.println("Searching found");
//        return true;
//    }
//
//    public static boolean USE11(WebDriver driver, Main sp) throws InterruptedException {
//        String title = "";
//        String expectedTitle = "Nadyr Sultanov";
//        Sprint1.BAU(driver,sp);
//        Sprint1.USE1(driver, sp);
//        driver.findElement(By.id("Layer_1")).click();
//        Thread.sleep(1000);
//        driver.findElement(By.className("search_content_input")).sendKeys(expectedTitle+"\n");
//        title=driver.getTitle();
//        driver.findElement(By.xpath("//*[text()[contains(.,'Nadyr Sultanov')]]")).click();
//        Sprint1.checkTitle(driver,"Profile");
//        return true;
//    }
//
//    public static boolean BLO6(WebDriver driver, Main sp) throws InterruptedException {
//        String title = "";
//        String expectedTitle = "Opentravel";
//        BLO3(driver, sp);
//        driver.findElement(By.linkText("UPDATE THE BLOG")).click();
//        title = driver.getTitle();
//
//        driver.findElement(By.id("text")).sendKeys(sp.exBlogText+"updated");
//
//
//        driver.findElement(By.cssSelector("input[value*='UPDATE']")).click();
//        System.out.println("Blog Updated!!!");
//        return true;
//    }
//    public static boolean LUP10(WebDriver driver, Main sp) throws InterruptedException {
//        String expectedTitle = "Opentravel";
//        Sprint4.ADM5(driver, sp);
//        if(!driver.findElement(By.linkText("Delete")).getAttribute("href").equals("")){
//            return true;
//        }
//        return false;
//    }
//    public static boolean BLO9(WebDriver driver, Main sp) throws InterruptedException {
//        String expectedTitle = "Opentravel";
//        Sprint4.ADM3(driver, sp);
//        if(!driver.findElement(By.linkText("Delete")).getAttribute("href").equals("")){
//            return true;
//        }
//        return false;
//    }
//    public static boolean LUP8(WebDriver driver, Main sp) throws InterruptedException {
//        String expectedTitle = "Opentravel";
//        Sprint4.ADM5(driver, sp);
//        driver.findElement(By.linkText("Update")).click();
//        Thread.sleep(1500);
//        return Sprint1.checkTitle(driver,expectedTitle);
//    }
//    public static boolean BLO10(WebDriver driver, Main sp) throws InterruptedException {
//        String expectedTitle = "New Blog";
//        Sprint4.ADM3(driver, sp);
//        driver.findElement(By.linkText("Update")).click();
//        Thread.sleep(1500);
//        return Sprint1.checkTitle(driver,expectedTitle);
//    }
//
//}