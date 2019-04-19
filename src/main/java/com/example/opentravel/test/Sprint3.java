/*package com.example.opentravel.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import weka.core.pmml.jaxbbindings.False;

import java.io.IOException;
public class Sprint3 {
    public static boolean USE6(WebDriver driver,Sprint1 sp) {
        String expectedTitle = "Profile";
        Sprint1.USE2(driver, sp);
        driver.findElement(By.linkText("UPDATE USER")).click();
        if(Sprint1.checkTitle(driver,"Update profile")==false){
            System.out.println("Fault in USE6");
            return false;
        }
        driver.findElement(By.id("name")).sendKeys(sp.exname+"updated");
        driver.findElement(By.id("languages")).sendKeys(sp.exlang+"updated");
        driver.findElement(By.id("age")).sendKeys(sp.exage);
        driver.findElement(By.id("experience")).sendKeys(sp.exexp);
        driver.findElement(By.id("aboutMe")).sendKeys(sp.exabout+"updated");
        driver.findElement(By.className("login100-form-btn")).click();
        if(Sprint1.checkTitle(driver,expectedTitle)==false){
            System.out.println("Fault in USE6");
            return false;
        }
        return true;

    }

    public static boolean USE7(WebDriver driver,Sprint1 sp) {
        String expectedTitle = "Opentravel";
        Sprint1.USE2(driver, sp);
        driver.findElement(By.className("btn-danger")).click();
        driver.findElement(By.linkText("Delete")).click();
        if(Sprint1.checkTitle(driver,"Login")==false){
            System.out.println("Fault in USE7");
            return false;
        }
        return true;
    }
    public static boolean NEW(WebDriver driver,Sprint1 sp) {
        String expectedTitle = "Opentravel";
        driver.findElement(By.linkText("HELP")).click();
        if(Sprint1.checkTitle(driver,"Opentravel")==false){
            System.out.println("Fault in USE7");
            return false;
        }
        return true;
    }

    public static boolean LUP5(WebDriver driver,Sprint1 sp) {
        String expectedTitle = "Places";
        Sprint1.LUP12(driver, sp);
        driver.findElement(By.id("comments")).sendKeys("Nice Place");
        driver.findElement(By.className("submit-btn")).click();
        if(Sprint1.checkTitle(driver,expectedTitle)==false){
            System.out.println("Fault in USE6");
            return false;
        }
        return true;
    }

    public static boolean BLO8(WebDriver driver,Sprint1 sp) {
        String expectedTitle = "Single Blog";
        Sprint1.BLO2(driver, sp);
        driver.findElement(By.id("comments")).sendKeys("Nice Blog");
        driver.findElement(By.className("submit-btn")).click();
        if(Sprint1.checkTitle(driver,expectedTitle)==false){
            System.out.println("Fault in USE6");
            return false;
        }
        return true;
    }

    public static boolean USE14(WebDriver driver,Sprint1 sp) {
        String expectedTitle = "Profile";
        Sprint1.USE2(driver, sp);
        driver.findElement(By.id("comments")).sendKeys("Nice Blog");
        driver.findElement(By.className("submit-btn")).click();
        if(Sprint1.checkTitle(driver,expectedTitle)==false){
            System.out.println("Fault in USE6");
            return false;
        }
        return true;
    }


    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\tanya\\Downloads\\programs\\geckodriver.exe");

        WebDriver driver = new FirefoxDriver();
        Sprint1 sp = new Sprint1();
        boolean progress;
        Sprint1.BAU(driver,sp);
        Sprint1.logIn(driver,sp);
        progress = USE6(driver, sp);
        if (!progress) {
            driver.close();
            System.exit(0);
        }
        progress = USE6(driver, sp);
        if (!progress) {
            driver.close();
            System.exit(0);
        }
        progress = NEW(driver, sp);
        if (!progress) {
            driver.close();
            System.exit(0);
        }
        progress = LUP5(driver, sp);
        if (!progress) {
            driver.close();
            System.exit(0);
        }
        progress = BLO8(driver, sp);
        if (!progress) {
            driver.close();
            System.exit(0);
        }
        progress = USE14(driver, sp);
        if (!progress) {
            driver.close();
            System.exit(0);
        }
        /*progress = USE6(driver, sp);
        if (!progress) {
            driver.close();
            System.exit(0);
        }*/

