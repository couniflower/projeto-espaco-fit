package jtextfields;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WrapLineJtable {
    public StringBuilder wrapLine(String texto, int largura) {
        if(texto.contains("\n")){
            StringBuilder str = new StringBuilder();
            str.append("<html>");
            str.append(texto.replaceAll("\n","<br>"));
            str.append("</html>");

            return str;
        }

        if(texto.length() < largura){
            int tamanho = 0, indexInicial = 0;
            String substring = "";
            List<String> frasesMaiores = new ArrayList<>();
            List<String> frasesMenores = new ArrayList<>();

            while(tamanho < texto.length()){
                if(substring.length() <= largura){
                    if(texto.charAt(tamanho) == ' ' || texto.charAt(tamanho) == '.'){
                        substring += texto.substring(indexInicial, tamanho + 1);
                        indexInicial = tamanho + 1;
                        if(texto.charAt(tamanho) == '.'){
                            frasesMaiores.add(substring);
                            substring = "";
                        }
                    }
                }else{
                    frasesMaiores.add(substring);
                    substring = "";
                }
                tamanho++;
            }

            List<String> frase = new ArrayList<>();
            String resto = "";
            tamanho = 0;
            while(tamanho < frasesMaiores.size()){
                substring = resto;
                resto = "";
                substring += frasesMaiores.get(tamanho);
                frase = Arrays.stream(substring.split(" ")).toList();
                substring = "";
                for(int palavra = 0; palavra < frase.size(); palavra++) {
                    if (substring.length() <= largura) {
                        if ((frase.get(palavra).length()) < ((largura + 1) - substring.length())) {
                            substring += frase.get(palavra) + " ";
                        } else {
                            resto += frase.get(palavra) + " ";
                        }
                    }
                }
                frasesMenores.add(substring);
                if((tamanho == (frasesMaiores.size() - 1)) && (resto.length() != 0)){
                    frasesMenores.add(resto);
                }
                tamanho++;
            }

            String retorno = "";
            for(String f : frasesMenores){
                if(frasesMenores.indexOf(f) != (frasesMenores.size() - 1)){
                    retorno += f + "\n";
                }else{
                    retorno += f;
                }
            }

            StringBuilder str = new StringBuilder();
            str.append("<html>");
            str.append(retorno.replaceAll("\n","<br>"));
            str.append("</html>");

            return str;
        }

        StringBuilder str = new StringBuilder();
        str.append("<html>");
        str.append(texto.replaceAll("\n","<br>"));
        str.append("</html>");

        return str;
    }
}
