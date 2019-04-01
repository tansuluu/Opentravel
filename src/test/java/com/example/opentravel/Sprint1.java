

/*
import ch.qos.logback.core.net.SyslogOutputStream;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


/*public class Sprint1 {
    static String uName="Exa@mail.ru";
    static String uName2="Example2@mail.ru";
    static String pWord="zzz123";
    static String exname="Example user";
    static String exage="21";
    static String exabout="Hello";
    static String exlang="RU KG TR UZ";
    static String exexp="0";
    static String excount="KG";


    String baseUrl = "localhost:8080";

    /*public static boolean regGID(WebDriver driver){
        String title = "";
        String expectedTitle = "Registration";

        driver.get(this.baseUrl);
        driver.findElement(By.linkText("REGISTER"));
        title=driver.getTitle();
        if(title!=expectedTitle) {
            System.out.println("Failed:" + title);
            return false;
        }
        driver.findElement(By.linkText("GID")).click();
        driver.findElement(By.id("name")).sendKeys(this.exname);
        driver.findElement(By.id("languages")).sendKeys(this.exlang);
        driver.findElement(By.id("age")).sendKeys(this.exage);
        driver.findElement(By.id("experience")).sendKeys(this.exexp);
        driver.findElement(By.id("aboutMe")).sendKeys(this.exabout);
        driver.findElement(By.id("email")).sendKeys(this.uName);
        driver.findElement(By.id("password")).sendKeys(this.pWord);
        driver.findElement(By.linkText(("SIGN UP"))).click();
        title=driver.getTitle();
        if(title == "Login") {
            System.out.println("GID registration successful!!!");
            return true;
        }
        System.out.println("Failed in registration GID");
        return false;
    }



    public static boolean regTourist(WebDriver driver){

        String title = "";
        String expectedTitle = "Registration";

        driver.get(this.baseUrl);
        driver.findElement(By.linkText("REGISTER"));
        title=driver.getTitle();
        if(title!=expectedTitle) {
            System.out.println("Failed:" + title);
            return false;
        }
        driver.findElement(By.linkText("GID")).click();
        driver.findElement(By.id("name")).sendKeys(this.exname2);
        driver.findElement(By.id("languages")).sendKeys(this.exlang);
        driver.findElement(By.id("age")).sendKeys(this.exage);
        driver.findElement(By.id("country")).sendKeys(this.excount);
        driver.findElement(By.id("aboutMe")).sendKeys(this.exabout);
        driver.findElement(By.id("email")).sendKeys(this.uName2);
        driver.findElement(By.id("password")).sendKeys(this.pWord);
        driver.findElement(By.linkText(("SIGN UP"))).click();
        title=driver.getTitle();
        if(title == "Login") {
            System.out.println("Tourist registration successful!!!");
            return true;
        }
        System.out.println("Failed in registration Tourist");
        return false;
    }

    public static boolean logIn(WebDriver driver) {
        String title = "";
        String expectedTitle = "Login";

        driver.get(this.baseUrl);
        driver.findElement(By.linkText("LOGIN"));
        title=driver.getTitle();
        if(title!=expectedTitle) {
            System.out.println("Failed:" + title);
            return false;
        }
        driver.findElement(By.id("email")).sendKeys(this.uName);
        driver.findElement(By.id("password")).sendKeys(this.pWord);
        driver.findElement(By.linkText(("SIGN IN"))).click();
        title=driver.getTitle();
        if(title == this.baseUrl) {
            System.out.println("Tourist registration successful!!!");
            return true;
        }
        System.out.println("Failed in registration Tourist");
        return false;
    }

    public static boolean USE2(WebDriver driver) {
        String title = "";
        String expectedTitle = "Login";

        driver.get(this.baseUrl);
        driver.findElement(By.partialLinkText("@gmail.com")).click();

    }*/

   /* public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver","C:/Users/tanya/Downloads/programs/geckodriver.exe");

        WebDriver driver = new FirefoxDriver();
        Sprint1 sp=new Sprint1();
        boolean progress;
        /*progress=regGID(driver);
        if(!progress){
            driver.close();
            System.exit(0);
            return;
        }
        progress=regTourist(driver);
        if(!progress){
            driver.close();
            System.exit(0);
            return;
        }*/

       /* String expectedTitle = "Registration";
        String st="";
        st=sp.baseUrl;
        driver.get("http://127.0.0.1:8080/");
        driver.findElement(By.linkText("REGISTER")).click();
        String title=driver.getTitle();
        if(!title.equals(expectedTitle)) {
            System.out.println("Failed:" + expectedTitle);
            return ;
        }
        driver.findElement(By.linkText("GID")).click();
        st=sp.exname;
        driver.findElement(By.id("name")).sendKeys(st);
        driver.findElement(By.id("languages")).sendKeys(sp.exlang);
        driver.findElement(By.id("age")).sendKeys(sp.exage);
        driver.findElement(By.id("experience")).sendKeys(sp.exexp);
        driver.findElement(By.id("aboutMe")).sendKeys(sp.exabout);
        driver.findElement(By.id("email")).sendKeys(sp.uName);
        driver.findElement(By.id("password")).sendKeys(sp.pWord);
        driver.findElement(By.className(("login100-form-btn"))).click();
        title=driver.getTitle();
        if(title.equals("Login")) {
            System.out.println("GID registration successful!!!");
        }
        else
        System.out.println("Failed in registration GID"+title);


        driver.close();
        System.exit(0);

    }
}
}
        */