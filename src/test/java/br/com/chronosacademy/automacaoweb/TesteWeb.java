package br.com.chronosacademy.automacaoweb;

import br.com.chronosacademy.core.Driver;
import br.com.chronosacademy.pages.CursoPage;
import br.com.chronosacademy.pages.PrincipalPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;


import static org.junit.Assert.assertEquals;

public class TesteWeb {
    WebDriver driver;
    Driver driverWeb;
    PrincipalPage principalPage;
    CursoPage cursoPage;

    @Before
    public void inicializaTeste(){
        driverWeb = new Driver("chrome");
        driver = Driver.getDriver();
        driver.get("https://www.chronosacademy.com.br");
        principalPage = new PrincipalPage(driver);
        cursoPage = new CursoPage(driver);
    }


    @Test
    public void primeiroTeste(){
        String titulo = principalPage.getTitulo();
        assertEquals("Porque Tempo É Conhecimento",titulo);
    }

    @Test
    public void segundoTeste(){
        principalPage.clickBotao();
        String titulo = cursoPage.getTitulo2();
        assertEquals("AUTOMAÇÃO SEM COMPLICAÇÃO WEB 2.0", titulo);
    }

    @Test
    public void terceiroTeste(){
        principalPage.clickBotao();
        String titulo = cursoPage.getTitulo2();
        assertEquals("AUTOMAÇÃO SEM COMPLICAÇÃO WEB 2.0", titulo);
    }


    @After
    public void finalizaTeste(){
        driver.quit();
    }


}
