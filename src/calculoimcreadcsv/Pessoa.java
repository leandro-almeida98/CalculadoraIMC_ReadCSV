/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculoimcreadcsv;

import java.text.DecimalFormat;


/**
 *
 * @author leand
 */
public class Pessoa {
    Format format = new Format();
    private String primeiroNome;
    private String sobreNome;
    private float peso;
    private float altura;
    private float Imc;
    

    public String getPrimeiroNome() {
        return primeiroNome;
    }
    
    public void setPrimeiroNome(String primeiroNome) {
        this.primeiroNome = format.retirarEspaço(primeiroNome);
    }

    public String getSobreNome() {
        return sobreNome;
    }

    public void setSobreNome(String sobreNome) {
        this.sobreNome = format.retirarEspaço(sobreNome);
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public float getImc() {
        return Imc;
    }

    public void setImc(float Imc) {
        Imc = format.StringToFloat(String.format("%.02f", Imc));
        this.Imc = Imc;
    }
    
    public String getNomeCompleto() {
        return primeiroNome+" "+sobreNome;
    }
    
    
    public void CalcularImc(){
        setImc(getPeso()/(getAltura()*getAltura()));
    }
    
}
