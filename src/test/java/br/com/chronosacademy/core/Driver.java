package br.com.chronosacademy.core;

import br.com.chronosacademy.enums.Browser;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

public class Driver {

    private  static WebDriver driver;
    private static WebDriverWait wait;
    private static String nomeCenario;
    private static File diretorio;
    private static int numPrint;

    public static File getDiretorio() {
        return diretorio;
    }

    public static String getNomeCenario() {
        return nomeCenario;
    }

    public static void setNomeCenario(String nomeCenario) {
        Driver.nomeCenario = nomeCenario;
    }

    public static void criarDiretorio(){
        String caminho = "src/test/resources/evidencias";
        diretorio = new File(caminho+"/"+nomeCenario);
        diretorio.mkdir();
        numPrint = 0;
    }

    public static void printScreen(String passo) throws IOException {
        numPrint++;
        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String caminho = diretorio.getPath()+"/"+numPrint+" - "+passo+".png";
        FileUtils.copyFile(file, new File(caminho));
    }

    public Driver (Browser navegador){
        switch (navegador) {
            case CHROME:
                startChrome();
                break;
            case IE:
                startIE();
                break;
            case FIREFOX:
                startFirefox();
                break;
            case EDGE:
                startEDGE();
                break;
            default:
                startDefault();
                break;
        }
        wait = new WebDriverWait(driver, 20);
        driver.manage().window().maximize();
    }

    public static WebDriver getDriver(){
        return driver;
    }

    private void startDefault() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    private void startEDGE() {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
    }

    private void startFirefox() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
    }

    private void startIE() {
        WebDriverManager.iedriver().setup();
        driver = new InternetExplorerDriver();
    }

    private void startChrome() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();

        boolean headless = Boolean.parseBoolean(System.getProperty("headless"));
        chromeOptions.setHeadless(headless);

        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().setSize(new Dimension(1280, 800));
    }

    public static void visibilitOf(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void invisibilitOf(WebElement element) {
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public static void isClicabe(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    public static void atributeChange(WebElement elemente, String attribute, String value){
        wait.until(ExpectedConditions.attributeContains(elemente, attribute, value));
    }

    public static void aguardarOptions(Select select) {
        for(int i = 0; i < 10; i++){
            if(select.getOptions().size() > 1){
                return;
            }else{
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
