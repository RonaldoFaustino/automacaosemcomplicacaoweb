package br.com.chronosacademy.media;

public class Media {
    public String calculoMedia(double n1, double n2) {

        double media = (n1 + n2) / 2;

        if(media < 5){
            return "Reprovado";
        }else{
            return "Aprovado";
        }

    }
}
