package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class OrdenaStrings {

    public static void main(String[] args) {

        //JAVA ANTIGO
        List<String> palavras = new ArrayList<String>();
        palavras.add("alura online");
        palavras.add("editora casa de codigo");
        palavras.add("caelum");


        Comparator<String> comparador = new ComparadorPorTamanho();

//        Collections.sort(palavras, comparador);


        //JAVA 8
        //DEFAULT METHODS DENTRO DA INTERFACE LIST
        //MÉTODO DA INTERFACE IMPLEMENTADO
        //IMPLEMENTAR NOVOS MÉTODO SEM QUEBRAR AS INTEFACES QUE ESTAO IMPLEMENTADAS
        palavras.sort(comparador);
        System.out.println(palavras);


        for (String p : palavras) {
            System.out.println(p);
        }

        //CONSUMER
        //NOVA FORMA DE ITERAR NA LIST
        //MÉTODOS DEFAULT
        Consumer<String> consumidor = new ImprimeNaLinha();
        //MÉTODO DEFAULT
        palavras.forEach(consumidor);

    }

}

class ImprimeNaLinha implements Consumer<String> {

    @Override
    public void accept(String s) {
        System.out.println(s);
    }
}

class ComparadorPorTamanho implements Comparator<String> {

    @Override
    public int compare(String s1, String s2) {
        if(s1.length() < s2.length()) return -1;

        if(s1.length() > s2.length()) return 1;

        return 0;
    }
}