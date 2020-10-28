package calculoimcreadcsv;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author leand
 */
public class CalculoImcReadCsv {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Format format = new Format();
        Pessoa pessoa;
        List<Pessoa> pessoas = new ArrayList<Pessoa>();
        String csvArquivo = "dataset.csv";
        BufferedReader conteudoCSV = null;
        String linha = "";
        
        String csvSeparadorCampo = ";";
        boolean primeiraLinha = true;
        
        try{
            conteudoCSV = new BufferedReader(new FileReader(csvArquivo));
            
            while((linha = conteudoCSV.readLine()) != null){
                if(!primeiraLinha){ // IGNORA A 1° LINHA DO ARQUIVO CSV
                String[] dados = linha.split(csvSeparadorCampo);
                pessoa = new Pessoa();
                
                pessoa.setPrimeiroNome(dados[0]);
                pessoa.setSobreNome(dados[1]);
                if(dados.length>2){
                    pessoa.setPeso(format.StringToFloat(dados[2]));
                }else{
                    pessoa.setPeso(0);
                }
                
                if(dados.length>3){
                    pessoa.setAltura(format.StringToFloat(dados[3]));
                }else{
                    pessoa.setAltura(0);
                }
                
                pessoa.CalcularImc();
                pessoas.add(pessoa);
                }else{
                    primeiraLinha = false;
                }
            }
            
        }catch(FileNotFoundException e){
            System.out.println("Arquivo nao encontrado : "+e);
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Index : "+e+" não existe");
        }catch(IOException e){
            System.out.println("Erro de escrita : "+e);
        }finally{
            if(conteudoCSV != null)
                try{
                    conteudoCSV.close();
                } catch(IOException e){
                    System.out.println("IO Erro : \n"+e);
                }
            
        }
        
        // MOSTRAR NA TELA
        for(Pessoa dados_pessoa:pessoas){
            System.out.println(format.transformarMaiusculo(dados_pessoa.getNomeCompleto())+ " "+ format.FloatToString(dados_pessoa.getImc()));
        }
        // SALVAR EM TXT
        try {
            String dados ="";
            for(Pessoa dados_pessoa:pessoas){
                dados = dados.concat(format.transformarMaiusculo(dados_pessoa.getNomeCompleto())+ " "+ format.FloatToString(dados_pessoa.getImc())+"\n");
            }
            
            // Cria arquivo
            File file = new File("Lista_Nome_imc.txt");

            // Se o arquivo nao existir, ele gera
            if (!file.exists()) {
                file.createNewFile();
            }

            // Prepara para escrever no arquivo
            FileWriter fileWriter = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            
            // Escreve e fecha arquivo
            bufferedWriter.write(dados);
            bufferedWriter.close();
        } catch (IOException ex) {
            Logger.getLogger(CalculoImcReadCsv.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
    
}
