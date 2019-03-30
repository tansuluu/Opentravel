package com.example.opentravel;


import ch.qos.logback.core.net.SyslogOutputStream;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Sprint1 {
    static String uName="Examp@mail.ru";
    static String uName2="Examp2@mail.ru";
    static String pWord="zzz123";
    static String exname="Example user";
    static String exage="21";
    static String exabout="Hello";
    static String exlang="RU KG TR UZ";
    static String exexp="0";
    static String excount="KG";


    String baseUrl = "http://127.0.0.1:8080/";

    public static boolean regGID(WebDriver driver,Sprint1 sp){
        String title = "";
        String expectedTitle = "Registration";

        driver.get(sp.baseUrl);
        driver.findElement(By.linkText("REGISTER")).click();
        title=driver.getTitle();
        if(!title.equals( expectedTitle)) {
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
        title=driver.getTitle();

        if(title.equals( "Login")) {
            System.out.println("GID registration successful!!!");
            return true;
        }
        System.out.println("Failed in registration GID");
        return false;
    }



    public static boolean regTourist(WebDriver driver,Sprint1 sp){

        String title = "";
        String expectedTitle = "Registration";

        driver.get(sp.baseUrl);
        driver.findElement(By.linkText("REGISTER")).click();
        title=driver.getTitle();
        if(!title.equals( expectedTitle)) {
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
        title=driver.getTitle();
        if(title.equals( "Login")) {
            System.out.println("Tourist registration successful!!!");
            return true;
        }
        System.out.println("Failed in registration Tourist");
        return false;
    }

    public static boolean logIn(WebDriver driver, Sprint1 sp) {
        String title = "";
        String expectedTitle = "Login";

        driver.get(sp.baseUrl);
        driver.findElement(By.linkText("LOGIN")).click();
        title=driver.getTitle();
        if(!title.equals( expectedTitle)) {
            System.out.println("Failed:" + title);
            return false;
        }
        driver.findElement(By.id("email")).sendKeys(sp.uName);
        driver.findElement(By.id("password")).sendKeys(sp.pWord);
        driver.findElement(By.linkText(("SIGN IN"))).click();
        title=driver.getTitle();
        if(title.equals(sp.baseUrl)) {
            System.out.println("Tourist registration successful!!!");
            return true;
        }
        System.out.println("Failed in registration Tourist");
        return false;
    }

    public static boolean USE2(WebDriver driver, Sprint1 sp) {
        String title = "";
        String expectedTitle = "Login";

        driver.get(sp.baseUrl);
        driver.findElement(By.partialLinkText("@gmail.com")).click();
        return true;
    }

    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver","/home/student/Videos/geckodriver-master/geckodriver");

        WebDriver driver = new FirefoxDriver();
        Sprint1 sp=new Sprint1();
        boolean progress;
        progress=regGID(driver,sp);
        if(!progress){
            driver.close();
            System.exit(0);
            return;
        }
        progress=regTourist(driver,sp);
        if(!progress){
            driver.close();
            System.exit(0);
            return;
        }


        driver.close();
        System.exit(0);

    }
}