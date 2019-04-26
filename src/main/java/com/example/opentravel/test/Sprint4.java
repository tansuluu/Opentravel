//package com.example.opentravel.test;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.Keys;
//import weka.core.pmml.jaxbbindings.False;
//
//import java.io.IOException;
//public class Sprint4 {
//    public static boolean BLO12(WebDriver driver,Main sp) throws InterruptedException {
//        String expectedTitle = "Opentravel";
//        Sprint2.BLO3(driver,sp);
//        driver.findElement(By.className("blogsCom")).click();
//        driver.findElement(By.id("defaultForm")).sendKeys("s");
//        Thread.sleep(3000);
//        driver.findElement(By.id("update")).click();
//        if(!driver.findElement(By.xpath("//*[text()[contains(.,'Nice Blogs')]]")).getText().equals("Nice Blogs")){
//            System.out.println("Fault: Blog comment updating");
//            return false;
//        }
//        return true;
//    }
//    public static boolean LUP14(WebDriver driver,Main sp) throws InterruptedException {
//        String expectedTitle = "Opentravel";
//        Sprint2.LUP4(driver,sp);
//        driver.findElement(By.className("blogsCom")).click();
//        driver.findElement(By.id("defaultForm")).sendKeys("GJ");
//        Thread.sleep(3000);
//        driver.findElement(By.id("update")).click();
//        if(!driver.findElement(By.xpath("//*[text()[contains(.,'Nice PlaceGJ')]]")).getText().equals("Nice PlaceGJ")){
//            System.out.println("Fault: Place comment updating");
//            return false;
//        }
//        return true;
//    }
//    public static boolean USE15(WebDriver driver,Main sp) throws InterruptedException {
//        String expectedTitle = "Opentravel";
//        Sprint1.USE2(driver,sp);
//        driver.findElement(By.className("blogsCom")).click();
//        driver.findElement(By.id("defaultForm")).sendKeys("1");
//        Thread.sleep(3000);
//        driver.findElement(By.id("update")).click();
//        if(!driver.findElement(By.xpath("//*[text()[contains(.,'Nice Profile1')]]")).getText().equals("Nice Profile1")){
//            System.out.println("Fault: User comment updating "+driver.findElement(By.xpath("//*[text()[contains(.,'Nice Profile1')]]")).getText());
//            return false;
//        }
//        return true;
//    }
//    public static boolean BLO7(WebDriver driver,Main sp) throws InterruptedException {
//        String expectedTitle = "Opentravel";
//        Sprint2.BLO3(driver,sp);
//        driver.findElement(By.id("addLike")).click();
//        if(driver.findElement(By.id("deleteLike")).getText().equals("0")){
//            System.out.println("Fault: Blog Like");
//            return false;
//        }
//        return true;
//    }
//    public static boolean BLO15(WebDriver driver,Main sp) throws InterruptedException {
//        String expectedTitle = "Opentravel";
//        Sprint2.BLO3(driver,sp);
//        driver.findElement(By.id("deleteLike")).click();
//        if(driver.findElement(By.id("deleteLike")).getText().equals("0")){
//            System.out.println("Fault: Blog Like Deleting");
//            return false;
//        }
//        return true;
//    }
//    public static boolean LUP2(WebDriver driver,Main sp) throws InterruptedException {
//        String expectedTitle = "Opentravel";
//        Sprint2.LUP4(driver,sp);
//        driver.findElement(By.id("addLike")).click();
//        if(driver.findElement(By.id("deleteLike")).getText().equals("0")){
//            System.out.println("Fault: Place Like");
//            return false;
//        }
//        return true;
//    }
//    public static boolean LUP17(WebDriver driver,Main sp) throws InterruptedException {
//        String expectedTitle = "Opentravel";
//        Sprint2.LUP4(driver,sp);
//        driver.findElement(By.id("deleteLike")).click();
//        if(driver.getTitle().equals("Places")){
//            return true;
//        }
//        System.out.println("Fault: Place Like Deleting");
//        return true;
//    }
//    public static boolean LUP3(WebDriver driver,Main sp) throws InterruptedException {
//        String expectedTitle = "Opentravel";
//        Sprint2.LUP4(driver, sp);
//        driver.findElement(By.id("addFav")).click();
//        if(driver.findElement(By.id("addFav")).getText().equals("ASSIGNE TO FAVORITE")){
//            System.out.println("Fault: Place Favorite");
//            return false;
//        }
//        Sprint1.USE2(driver,sp);
//        driver.findElement(By.className("fa-star")).click();
//        driver.findElement(By.cssSelector("a[href*='/deleteFavorite']")).click();
//
//        return true;
//    }
//    public static boolean FAP1(WebDriver driver, Main sp) {
//        String expectedTitle = "All Places";
//        Sprint1.USE2(driver,sp);
//        driver.findElement(By.className("fa-star")).click();
//        return Sprint1.checkTitle(driver,expectedTitle);
//
//    }
//    public static boolean FAP2(WebDriver driver,Main sp) {
//        String expectedTitle = "Places";
//        FAP1(driver,sp);
//        driver.findElement(By.xpath("//*[text()[contains(.,'kg1')]]")).click();
//        return Sprint1.checkTitle(driver,expectedTitle);
//
//    }
//    public static boolean FAP3(WebDriver driver,Main sp) {
//        String expectedTitle = "Opentravel";
//        FAP2(driver,sp);
//        driver.findElement(By.id("deleteFav")).click();
//        return true;
//    }
//    public static boolean ADM2(WebDriver driver,Main sp) throws InterruptedException {
//        String expectedTitle = "Users";
//        Sprint1.BAU(driver, sp);
//        driver.findElement(By.cssSelector("a[href*='/admin']")).click();
//        Thread.sleep(2000);
//        if(driver.findElement(By.className("title-1")).getText().equals(expectedTitle)){
//            return true;
//        }
//        System.out.println("Failed: Admin Users Page ");
//        return false;
//    }
//    public static boolean ADM5(WebDriver driver,Main sp) throws InterruptedException {
//        String expectedTitle = "Places";
//        ADM2(driver, sp);
//        driver.findElement(By.cssSelector("a[href*='/adminPlaces']")).click();
//        Thread.sleep(2000);
//        if(driver.findElement(By.className("title-1")).getText().equals(expectedTitle)){
//            return true;
//        }
//        System.out.println("Failed: Admin Places Page");
//        return false;
//    }
//    public static boolean ADM3(WebDriver driver,Main sp) throws InterruptedException {
//        String expectedTitle = "Blogs";
//        ADM2(driver, sp);
//        driver.findElement(By.cssSelector("a[href*='/adminBlogs']")).click();
//        Thread.sleep(2000);
//        if(driver.findElement(By.className("title-1")).getText().equals(expectedTitle)){
//            return true;
//        }
//        System.out.println("Failed: Admin Blogs Page "+driver.findElement(By.className("title-1")).getText());
//        return false;
//    }
//}
