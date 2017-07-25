/* Cibele Ramos da Silva - 13113050303 */

public class telefonia {
    public static void main(String[] args) {
      arquivosUsados primeiroArquivo = new arquivosUsados();
      primeiroArquivo.leitorPrimeiroArquivo("Ligacoes.txt");
     
      arquivosUsados segundoArquivo = new arquivosUsados();
      segundoArquivo.leitorPrimeiroArquivo("Pares.txt");
}


import java.io.*;
import java.util.*;

public class arquivosUsados {
  public void leitorPrimeiroArquivo(String caminho){
      matrizes Matriz = new matrizes();  
      BufferedReader arquivo = new BufferedReader(new FileReader(caminho));
            
       String linha = arquivo.readLine(); 
       StringTokenizer st = new StringTokenizer(linha);
       int tamanho = Integer.parseInt(st.nextToken());
       Matriz.configMatriz(tamanho);
    
       linha = arquivo.readLine();
         while (linha != null) {
                st = new StringTokenizer(linha);
                 while (st.hasMoreTokens()){
                   int linhaLida = Integer.parseInt(st.nextToken());
                   int colunaLida = Integer.parseInt(st.nextToken());
                   int pesoLido  = Integer.parseInt(st.nextToken());
               Matriz.atualizarMatriz(colunaLida,linhaLida ,pesoLido);
               
               Matriz.atualizarMatriz(linhaLida ,colunaLida, pesoLido);
                
          }
             linha = arquivo.readLine();
        }
         Matriz.outMat();
      }

    
 public void leitorSegundoArquivo(String caminho){
        BufferedReader segundoArquivo = new BufferedReader(new FileReader(caminho));
        String linha = segundoArquivo.readLine(); 
        StringTokenizer st2 = new StringTokenizer(linha);
        int tamanho = Integer.parseInt(st2.nextToken());
        linha = segundoArquivo.readLine();
            while (linha != null) {
                st2 = new StringTokenizer(linha);
                 while (st2.hasMoreTokens()){
                int disp1 = Integer.parseInt(st2.nextToken());
                int disp2 = Integer.parseInt(st2.nextToken());
                }
             linha = segundoArquivo.readLine();
        }
    
      }

    }

public class matrizes {
    
     int [][] matrizUsada;
  
  
public void configMatriz(int n){
    matrizUsada = new int [n][n];
     for (int j=0; j<n; j++){
           for(int i=0; i<n; i++){
              matrizUsada[j][i]=0;   
             }
        }
    }

public void atualizarMatriz(int x,int y, int pesoLido){
                 matrizUsada [x-1][y-1] = pesoLido;
                 matrizUsada [y-1][x-1] = pesoLido;
     }  
 
 public void outMat( ){
       for (int[] matriz1 : matrizUsada) {
           for (int i = 0; i < matrizUsada.length; i++) {
               System.out.print(matriz1[i] + " ");
           }
           System.out.println();
       }
     
    }

    void ligacaoObrigatoria(int disp1, int disp2) {
                 matrizUsada [disp1-1][disp2-1] = 0;
                 matrizUsada [disp2-1][disp1-1] = 0;
    
    }
}