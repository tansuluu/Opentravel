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
        driver.findElement(By.className(("container-login100-form-btn"))).click();
        title=driver.getTitle();
        if(title.equals(sp.baseUrl)) {
            System.out.println("Logged In!!!");
            return true;
        }
        System.out.println("Failed in registration Tourist");
        return false;
    }

    public static boolean USE2(WebDriver driver, Sprint1 sp) {
        String title = "";
        String expectedTitle = "Profile";

        driver.get(sp.baseUrl);
        driver.findElement(By.partialLinkText("@gmail.com")).click();
        title=driver.getTitle();
        if(!title.equals(expectedTitle)){
            System.out.println("Failed:" + title);
            return false;
        }
        System.out.println("User's Profile Done!!!");
        return true;
    }

    public static boolean BLO4(WebDriver driver, Sprint1 sp) {
        String title = "";
        String expectedTitle = "Login";

        driver.get(sp.baseUrl);
        driver.findElement(By.partialLinkText("@gmail.com")).click();
        title=driver.getTitle();
        if(!title.equals(expectedTitle)){
            System.out.println("Failed:" + title);
            return false;
        }

        driver.findElement(By.linkText("NEW BLOG"));
        driver.findElement(By.id("title")).sendKeys("hehehe");
        driver.findElement(By.id("text")).sendKeys("hahaha");
        driver.findElement(By.id("category")).click();
        driver.findElement(By.className("btn btn-primary py-3 px-5")).click();

        return true
    }

    public static boolean BLO5(WebDriver driver, Sprint1 sp) {
        String title = "";
        String expectedTitle = "Login";

        driver.get(sp.baseUrl);
        driver.findElement(By.partialLinkText("@gmail.com")).click();
        title=driver.getTitle();
        if(!title.equals(expectedTitle)){
            System.out.println("Failed:" + title);
            return false;
        }


        return true
    }

    public static boolean LUP6(WebDriver driver, Sprint1 sp) {
        String title = "";
        String expectedTitle = "Login";

        driver.get(sp.baseUrl);

        return true
    }

    public static boolean LUP7(WebDriver driver, Sprint1 sp) {
        String title = "";
        String expectedTitle = "Login";

        driver.get(sp.baseUrl);
        return true
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
        progress=logIn(driver,sp);
        if(!progress){
            driver.close();
            System.exit(0);
            return;
        }
        progress=USE2(driver,sp);
        if(!progress){
            driver.close();
            System.exit(0);
            return;
        }

        progress=BLO4(driver,sp);
        if(!progress){
            driver.close();
            System.exit(0);
            return;
        }

        progress=BLO5(driver,sp);
        if(!progress){
            driver.close();
            System.exit(0);
            return;
        }

        progress=LUP6(driver,sp);
        if(!progress){
            driver.close();
            System.exit(0);
            return;
        }

        progress=LUP7(driver,sp);
        if(!progress){
            driver.close();
            System.exit(0);
            return;
        }

        driver.close();
        System.exit(0);

    }
}