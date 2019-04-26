/*package com.example.opentravel.test;


import ch.qos.logback.core.net.SyslogOutputStream;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.JavascriptExecutor;
import weka.core.pmml.jaxbbindings.False;

import java.io.IOException;


public class Sprint1 {
    public static void stopProg(WebDriver driver, String chck) {
        System.out.println("Fault in: " +chck);
        driver.close();
        System.exit(0);
    }
    public static boolean checkTitle(WebDriver driver, String expTitle) {
        String title=driver.getTitle();
        if(!title.equals(expTitle)) {
            System.out.println("Fault: "+title+"-> " +expTitle);
            return false;
        }
        return true;
    }

    public static boolean BAU(WebDriver driver,Main sp) {
        String title = "";
        String expectedTitle = "Opentravel";

        driver.get(sp.baseUrl);
        title=driver.getTitle();
        if (!title.equals(expectedTitle)) {
            System.out.println("Failed: Base URL -" + title);
            return false;
        }
        return true;
    }

    public static boolean LUP1(WebDriver driver, Main sp) {
        String title = "";
        String expectedTitle = "All Places";

        BAU(driver, sp);
        driver.findElement(By.linkText("OFFERS")).click();
        title=driver.getTitle();
        if (!title.equals(expectedTitle)) {
            System.out.println("Failed: LUP1 -" + title);
            return false;
        }
        return true;
    }
    public static boolean BLO1(WebDriver driver, Main sp) {
        String title = "";
        String expectedTitle = "Blogs";

        BAU(driver, sp);
        driver.findElement(By.linkText("BLOG")).click();
        title=driver.getTitle();
        if (!title.equals(expectedTitle)) {
            System.out.println("Failed: BLO1 -" + title);
            return false;
        }
        return true;

    }
    public static boolean USE1(WebDriver driver, Main sp) {
        String title = "";
        String expectedTitle = "Guides";

        BAU(driver, sp);
        driver.findElement(By.linkText("USERS")).click();
        title=driver.getTitle();
        if (!title.equals(expectedTitle)) {
            System.out.println("Failed: USE1 -" + title);
            return false;
        }
        return true;

    }

    public static boolean regGID(WebDriver driver, Main sp) throws InterruptedException {
        String title = "";
        String expectedTitle = "Registration";

        BAU(driver, sp);
        driver.findElement(By.linkText("REGISTER")).click();
        title = driver.getTitle();
        if (!title.equals(expectedTitle)) {
            System.out.println("Failed:" + title);
            return false;
        }
        driver.findElement(By.linkText("GID")).click();
        driver.findElement(By.id("name")).sendKeys(sp.exname);
        driver.findElement(By.id("languages")).sendKeys(sp.exlang);
        driver.findElement(By.id("age")).sendKeys(sp.exage);
        driver.findElement(By.id("experience")).sendKeys(sp.exexp);
        driver.findElement(By.id("aboutMe")).sendKeys(sp.exabout);
        driver.findElement(By.id("email")).sendKeys(sp.uName);
        driver.findElement(By.id("password")).sendKeys(sp.pWord);

        driver.findElement(By.className(("login100-form-btn"))).click();
        Thread.sleep(10000);
        title = driver.getTitle();
        System.out.println(title);
        if (title.equals("Login")) {
            System.out.println("GID registration successful!!!");
            return true;
        }
        System.out.println("Failed in registration GID");
        return false;
    }


    public static boolean regTourist(WebDriver driver, Main sp) {

        String title = "";
        String expectedTitle = "Registration";

        BAU(driver, sp);
        driver.findElement(By.linkText("REGISTER")).click();
        title = driver.getTitle();
        if (!title.equals(expectedTitle)) {
            System.out.println("Failed:" + title);
            return false;
        }
        driver.findElement(By.linkText("Tourist")).click();
        driver.findElement(By.id("name")).sendKeys(sp.exname);
        driver.findElement(By.id("languages")).sendKeys(sp.exlang);
        driver.findElement(By.id("age")).sendKeys(sp.exage);
        driver.findElement(By.id("country")).sendKeys(sp.excount);
        driver.findElement(By.id("aboutMe")).sendKeys(sp.exabout);
        driver.findElement(By.id("email")).sendKeys(sp.uName2);
        driver.findElement(By.id("password")).sendKeys(sp.pWord);

        driver.findElement(By.className(("login100-form-btn"))).click();
        title = driver.getTitle();
        if (title.equals("Login")) {
            System.out.println("Tourist registration successful!!!");
            return true;
        }
        System.out.println("Failed in registration Tourist");
        return false;
    }

    public static boolean logIn(WebDriver driver, Main sp) {
        String title = "";
        String expectedTitle = "Login";

        BAU(driver, sp);
        driver.findElement(By.linkText("LOGIN")).click();
        title = driver.getTitle();
        if (!title.equals(expectedTitle)) {
            System.out.println("Failed:" + title);
            return false;
        }
        driver.findElement(By.id("email")).sendKeys(sp.exUName);
        driver.findElement(By.id("password")).sendKeys(sp.pWord);
        driver.findElement(By.className(("container-login100-form-btn"))).click();
        title = driver.getTitle();

        if (title.equals("Opentravel")) {
            System.out.println("Logged In!!!");
            return true;
        }
        System.out.println("Failed in Logging In");
        return false;
    }
    public static boolean logOut(WebDriver driver, Main sp) {
        String expectedTitle = "Login";
        BAU(driver, sp);
        driver.findElement(By.linkText("LOGOUT")).click();
        return checkTitle(driver,expectedTitle);
    }

    public static boolean USE2(WebDriver driver, Main sp) {
        String title = "";
        String expectedTitle = "Profile";

        BAU(driver, sp);
        driver.findElement(By.partialLinkText("@")).click();
        title = driver.getTitle();
        if (!title.equals(expectedTitle)) {
            System.out.println("Failed:" + title);
            return false;
        }
        System.out.println("User's Profile Done!!!");
        return true;
    }

    public static boolean BLO4(WebDriver driver, Main sp) throws InterruptedException {
        String title = "";
        String expectedTitle = "Profile";

        BAU(driver, sp);
        driver.findElement(By.partialLinkText("@")).click();
        title = driver.getTitle();
        if (!title.equals(expectedTitle)) {
            System.out.println("Failed:" + title);
            return false;
        }
        driver.findElement(By.cssSelector("a[href*='newBlog']")).click();
        ((JavascriptExecutor) driver)
                .executeScript("window.scrollTo(0, document.body.scrollHeight)");

        driver.findElement(By.id("title")).sendKeys(sp.exBlogName);
        driver.findElement(By.id("text")).sendKeys(sp.exBlogText);


        Select categSel = new Select(driver.findElement(By.id("category")));
        categSel.selectByVisibleText("Nature");
        Thread.sleep(4000);
        driver.findElement(By.cssSelector("input[value*='ADD BLOG']")).click();

        title = driver.getTitle();
        if (!title.equals(expectedTitle)) {
            System.out.println("Failed:" + title);
            return false;
        }

        System.out.println("Blog Created!!!");

        return true;
    }

    public static boolean BLO5(WebDriver driver, Main sp)  {
        String title = "";
        String expectedTitle = "Profile";

        BAU(driver, sp);
        driver.findElement(By.partialLinkText("@")).click();
        title = driver.getTitle();
        if (!title.equals(expectedTitle)) {
            System.out.println("Failed:" + title);
            return false;
        }

        driver.findElement(By.linkText(sp.exBlogName)).click();
        title = driver.getTitle();
        if (!title.equals("Single Blog")) {
            System.out.println("Failed:" + title);
            return false;
        }
        driver.findElement(By.className("btn-danger")).click();
        driver.findElement(By.partialLinkText("Delete")).click();
        title = driver.getTitle();
        if (!title.equals("Blogs")) {
            System.out.println("Failed:" + title);
            return false;
        }

        System.out.println("Blog Deleted!!!");

        return true;
    }

    public static boolean LUP6(WebDriver driver, Main sp) throws InterruptedException {
        String title = "";
        String expectedTitle = "Profile";

        BAU(driver, sp);
        driver.findElement(By.partialLinkText("@")).click();
        title = driver.getTitle();
        if (!title.equals(expectedTitle)) {
            System.out.println("Failed:" + title);
            return false;
        }
        driver.findElement(By.cssSelector("a[href*='newPlace']")).click();

        driver.findElement(By.id("title")).sendKeys(sp.exPlaceName);
        driver.findElement(By.id("address")).sendKeys(sp.exAdress);
        driver.findElement(By.id("text")).sendKeys(sp.exBlogText);


        Select categSel = new Select(driver.findElement(By.id("category")));
        categSel.selectByVisibleText("Nature");
        Thread.sleep(4000);
        driver.findElement(By.className("login100-form-btn")).click();

        title = driver.getTitle();
        if (!title.equals(expectedTitle)) {
            System.out.println("Failed:" + title);
            return false;
        }

        System.out.println("Place Created!!!");

        return true;
    }

    public static boolean LUP7(WebDriver driver, Main sp) throws InterruptedException {
        String title = "";
        String expectedTitle = "Profile";

        BAU(driver, sp);
        driver.findElement(By.partialLinkText("@")).click();
        driver.findElement(By.linkText(sp.exPlaceName)).click();
        title = driver.getTitle();
        if (!title.equals("Places")) {
            System.out.println("Failed:" + title);
            return false;
        }
        Thread.sleep(3000);
        driver.findElement(By.className("btn-danger")).click();
        driver.findElement(By.partialLinkText("Delete")).click();
        title = driver.getTitle();
        if (!title.equals("All Places")) {
            System.out.println("Failed:" + title);
            return false;
        }

        System.out.println("Place Deleted!!!");

        return true;
    }

    public static boolean LUP12(WebDriver driver, Main sp) {
        String expectedTitle = "Places";
        LUP1(driver, sp);
        driver.findElement(By.xpath("//*[text()[contains(.,'kg1')]]")).click();
        if(checkTitle(driver,expectedTitle)==false){
            System.out.println("Fault in LUP12");
            return false;
        }
        return true;
    }
    public static boolean BLO2(WebDriver driver, Main sp) {
        String expectedTitle = "Single Blog";
        BLO1(driver, sp);
        driver.findElement(By.xpath("//*[text()[contains(.,'KG')]]")).click();
        if(checkTitle(driver,expectedTitle)==false){
            System.out.println("Fault in BLO2");
            return false;
        }
        return true;
    }

}
*/