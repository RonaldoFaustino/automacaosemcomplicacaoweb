package br.com.chronosacademy.media;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MediaTest {

    @Test
    public void validaAprovado(){
        double n1 = 5;
        double n2 = 5;

        Media media = new Media();

        String resultado = media.calculoMedia(n1,n2);

        Assert.assertEquals("Aprovado", resultado);
    }

    @Test
    public void validaReprovado(){
        double n1 = 4.9;
        double n2 = 5;

        Media media = new Media();

        String resultado = media.calculoMedia(n1,n2);

        Assert.assertEquals("Reprovado", resultado);
    }

}