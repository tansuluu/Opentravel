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
//public class Main {
//    public static String uName = "Examp@mail.ru";
//    public static String uName2 = "Exam2@mail.ru";
//    public static String exUName="example@mail.ru";
//    public static String pWord = "zzz123";
//    public static String exname = "Example user";
//    public static String exage = "21";
//    public static String exabout = "Hello";
//    public static String exlang = "RU KG TR UZ";
//    public static String exexp = "0";
//    public static String excount = "KG";
//    public static String exBlogName = "KG";
//    public static String exPlaceName = "kg1";
//    public static String exBlogText = "te  Socialist Republics (USSRfd) as  15 constituent  Republic (SSR). The  under Soviet rule, and  became independent from the USSR in 1991. In 1993 the republic ratified its first post-Soviet constitution.";
//    public static String exAdress="KG BISH";
//
//
//    public static String baseUrl = "http://127.0.0.1:8080/";
//    public static void main(String[] args) throws InterruptedException {
//        System.setProperty("webdriver.gecko.driver", "C:\\Users\\tanya\\Downloads\\programs\\geckodriver.exe");
//
//        WebDriver driver = new FirefoxDriver();
//        Main sp = new Main();
//        boolean progress;
//
//        progress=Sprint1.BAU(driver, sp); if(!progress) Sprint1.stopProg(driver,"Base URL"); else System.out.println("Base url works");
//        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//        ////////////////////////                              Registration and logging in
//        //progress=Sprint1.regTourist(driver, sp); if(!progress) Sprint1.stopProg(driver,"Registering tourist"); else System.out.println("Registering tourist");
//        //progress=Sprint1.regGID(driver, sp); if(!progress) Sprint1.stopProg(driver,"Registering GID"); else System.out.println("Registering GID");
//        progress=Sprint1.logIn(driver, sp); if(!progress) Sprint1.stopProg(driver,"Logging in"); else System.out.println("Logging in");
//        progress=Sprint2.REG5(driver, sp); if(!progress) Sprint1.stopProg(driver,"About Website"); else System.out.println("About Website");
//        progress=Sprint3.NEW12(driver, sp); if(!progress) Sprint1.stopProg(driver,"Help"); else System.out.println("Help");
//
//
//        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//        ////////////////////////                              Users work
//        progress=Sprint1.USE2(driver, sp); if(!progress) Sprint1.stopProg(driver,"Profile Page"); else System.out.println("Profile Page");
//        progress=Sprint1.USE1(driver, sp); if(!progress) Sprint1.stopProg(driver,"Users Page"); else System.out.println("Users Page");
//        progress=Sprint2.USE11(driver, sp); if(!progress) Sprint1.stopProg(driver,"Search User"); else System.out.println("Search Users");
//        progress=Sprint3.USE6(driver, sp); if(!progress) Sprint1.stopProg(driver,"Update User"); else System.out.println("Update Users");
//        progress=Sprint3.USE3(driver, sp); if(!progress) Sprint1.stopProg(driver,"Users Comment"); else System.out.println("Users Comment");
//        progress=Sprint4.USE15(driver, sp); if(!progress) Sprint1.stopProg(driver,"Users Comment Updating"); else System.out.println("Users Comment Updating");
//
//
//
//        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//        ////////////////////////                              Place work
//
//        progress=Sprint1.LUP1(driver, sp); if(!progress) Sprint1.stopProg(driver,"Places Page"); else System.out.println("Places Page");
//        progress=Sprint1.LUP6(driver, sp); if(!progress) Sprint1.stopProg(driver,"New Place"); else System.out.println("New Place");
//        progress=Sprint2.LUP4(driver, sp); if(!progress) Sprint1.stopProg(driver,"Search Place"); else System.out.println("Search Place");
//        progress=Sprint1.LUP12(driver, sp); if(!progress) Sprint1.stopProg(driver,"Place Page"); else System.out.println("Place Page");
//        progress=Sprint2.LUP11(driver, sp); if(!progress) Sprint1.stopProg(driver,"Update Place"); else System.out.println("Update Place");
//        progress=Sprint3.LUP5(driver, sp); if(!progress) Sprint1.stopProg(driver,"Place Comment"); else System.out.println("Place Comment");
//        progress=Sprint4.LUP14(driver, sp); if(!progress) Sprint1.stopProg(driver,"Place Comment Updating"); else System.out.println("Place Comment Updating");
//        progress=Sprint4.LUP2(driver, sp); if(!progress) Sprint1.stopProg(driver,"Place Like"); else System.out.println("Place Like");
//        progress=Sprint4.LUP17(driver, sp); if(!progress) Sprint1.stopProg(driver,"Place Like Delete"); else System.out.println("Place Like Delete");
//        progress=Sprint4.LUP3(driver, sp); if(!progress) Sprint1.stopProg(driver,"Place Favorite"); else System.out.println("Place Favorite");
//        progress=Sprint4.FAP1(driver, sp); if(!progress) Sprint1.stopProg(driver,"List Favorite"); else System.out.println("Place Favorite");
//        progress=Sprint4.FAP2(driver, sp); if(!progress) Sprint1.stopProg(driver,"Search Favorite"); else System.out.println("Place Favorite");
//        progress=Sprint4.FAP3(driver, sp); if(!progress) Sprint1.stopProg(driver,"Remove Favorite"); else System.out.println("Place Favorite");
//
//        progress=Sprint1.LUP7(driver, sp); if(!progress) Sprint1.stopProg(driver,"Delete Place"); else System.out.println("Delete Place");
//
//        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//        ////////////////////////                              Blog work
//        progress=Sprint1.BLO1(driver, sp); if(!progress) Sprint1.stopProg(driver,"Blogs Page"); else System.out.println("Blogs Page");
//        progress=Sprint1.BLO4(driver, sp); if(!progress) Sprint1.stopProg(driver,"New Blog"); else System.out.println("New Blog");
//        progress=Sprint1.BLO2(driver, sp); if(!progress) Sprint1.stopProg(driver,"Blog Page"); else System.out.println("Blog Page");
//        progress=Sprint2.BLO3(driver, sp); if(!progress) Sprint1.stopProg(driver,"Search Blog"); else System.out.println("Search Blog");
//        progress=Sprint2.BLO6(driver, sp); if(!progress) Sprint1.stopProg(driver,"Update Blog"); else System.out.println("Update Blog");
//        progress=Sprint3.BLO8(driver, sp); if(!progress) Sprint1.stopProg(driver,"Blog Comment"); else System.out.println("Blog Comment");
//        progress=Sprint4.BLO12(driver, sp); if(!progress) Sprint1.stopProg(driver,"Blog Comment Updating"); else System.out.println("Blog Comment Updating");
//        progress=Sprint4.BLO7(driver, sp); if(!progress) Sprint1.stopProg(driver,"Blog Like"); else System.out.println("Blog Like");
//        progress=Sprint4.BLO15(driver, sp); if(!progress) Sprint1.stopProg(driver,"Blog Like Delete"); else System.out.println("Blog Like Delete");
//
//        progress=Sprint1.BLO5(driver, sp); if(!progress) Sprint1.stopProg(driver,"Delete Blog"); else System.out.println("Delete Blog");
//
//
//        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//        ////////////////////////                              Admin work
//        /*progress=Sprint4.ADM2(driver, sp); if(!progress) Sprint1.stopProg(driver,"Admin Users"); else System.out.println("Admin Users");
//        progress=Sprint4.ADM3(driver, sp); if(!progress) Sprint1.stopProg(driver,"Admin Blogs"); else System.out.println("Admin Blogs");
//        progress=Sprint4.ADM5(driver, sp); if(!progress) Sprint1.stopProg(driver,"Admin Places"); else System.out.println("Admin Places");
//        progress=Sprint2.LUP8(driver, sp); if(!progress) Sprint1.stopProg(driver,"Admin Places Updating"); else System.out.println("Admin Places Updating");
//        progress=Sprint2.BLO10(driver, sp); if(!progress) Sprint1.stopProg(driver,"Admin Blogs Updating"); else System.out.println("Admin Blogs Updating");
//        progress=Sprint2.LUP10(driver, sp); if(!progress) Sprint1.stopProg(driver,"Admin Places Deleting"); else System.out.println("Admin Places Deleting");
//        progress=Sprint2.BLO9(driver, sp); if(!progress) Sprint1.stopProg(driver,"Admin Blogs Deleting"); else System.out.println("Admin Blogs Deleting");
//*/
//
//
//
//
//        //progress=Sprint3.USE7(driver, sp); if(!progress) Sprint1.stopProg(driver,"Delete User"); else System.out.println("Delete Users");
//
//        driver.close();
//        System.exit(0);
//
//    }
//}
