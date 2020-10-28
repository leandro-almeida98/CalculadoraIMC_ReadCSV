/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculoimcreadcsv;

/**
 *
 * @author leand
 */
public class Format {
    public Float StringToFloat(String dado){
        // CONVERTE UMA STRING PARA FLOAT
        float floatValidado = 0;
        if(dado!=null){
            floatValidado = Float.valueOf(dado.replace(",", "."));
        }
        return floatValidado;
    }
    public String FloatToString(float dado){
        // CONVERTE UM FLOAT COM PONTO, EM UMA STRING COM VIRGULA
        String floatString = "";
        floatString = String.valueOf(dado).replace(".", ",");
        return floatString;
    }
    public String transformarMaiusculo(String dado){
        //TRANSFORMA STRING PARA MAIUSCULA
        return dado.toUpperCase();
    }
    public String retirarEspaço(String dado){
        //RETIRA ESPAÇO DA STRING
        return dado.trim();
    }
    
}
