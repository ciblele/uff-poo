package ad2_poo;

/* Cibele Ramos da Silva - 13113050303
   AD2 POO 2016.2
*/

import java.io.*;
import java.util.Collections;
import java.util.LinkedList;

class GrafosAD2 {

    static final int MAXVERTICES = 1500;
    static final int GRAUMAXIMO = 250;
    public int[][] vertices = new int[MAXVERTICES + 1][GRAUMAXIMO];
    public int[] graus = new int[MAXVERTICES + 1];
    public int quantVertices;
    public int quantNos;

    GrafosAD2() {

    }

    void ler_ArquivoExterno(boolean orientado) {
        int no1, no2;
        try {   //outro arquivo enviado é grafo2.txt também com os valores do enunciado
            try (BufferedReader arquivo = new BufferedReader(new FileReader("grafo7.txt"))) {
                String linha;
                String[] linhadividida;
                Boolean primeiralinha = true;
                while ((linha = arquivo.readLine()) != null) {
                    if (primeiralinha) {
                        quantVertices = linha.split(" ").length;
                        primeiralinha = false;
                    } else {
                        linhadividida = linha.split(" ");
                        no1 = Integer.parseInt(linhadividida[0]);
                        no2 = Integer.parseInt(linhadividida[1]);
                        insere_vertice(no1, no2, orientado);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado. " + e);
        } catch (IOException e) {
            System.out.println("Um erro foi encontrado na leitura do arquivo. " + e);
        }
    }

    void insere_vertice(int x, int y, boolean orientado) {
        vertices[x][graus[x]] = y;
        graus[x]++;
        if (!orientado) {
            insere_vertice(y, x, true);
        }
    }
}

public class AD2_POO {

    static boolean[] descoberto = new boolean[1500];
    static String componentes = "";
    static String naordem = "";
    static int quantidade;

    static void conectar(GrafosAD2 g) {
        LinkedList grafos = new LinkedList();
        int j, v;
        for (int i = 1; i <= g.quantVertices - 1; i++) {
            if (!descoberto[i]) {
                quantidade++;
                grafos.add(i);
                naordem = "";
                descoberto[i] = true;
                while (!grafos.isEmpty()) {
                    Collections.sort(grafos);
                    v = (int) grafos.remove();
                    naordem = naordem + " " + v;
                    for (j = g.graus[v] - 1; j >= 0; j--) {
                        if (!descoberto[g.vertices[v][j]]) {
                            grafos.add(g.vertices[v][j]);
                            descoberto[g.vertices[v][j]] = true;
                        }
                    }
                }
                componentes = componentes + organizar(naordem) + "\n";
            }
        }
    }

    static String organizar(String org) {
        String[] organizando = org.split(" ");
        org = "";
        String temp = "0";
        for (int a = 0; a < organizando.length - 1; a++) {
            for (int b = a + 1; b < organizando.length - 1; b++) {
                if (!organizando[a].isEmpty() && !organizando[b].isEmpty()) {
                    if (Integer.parseInt(organizando[a]) > Integer.parseInt(organizando[b])) {
                        temp = organizando[a];
                        organizando[a] = organizando[b];
                        organizando[b] = temp;
                    }
                }
            }
        }
        for (String c : organizando) {
            org = org + " " + c;
        }
        return org;
    }

    static void imprimir() {
        System.out.print("quantidade: " + quantidade + "\n" + componentes);
    }

    static public void main(String[] args) {
        GrafosAD2 grafosad2 = new GrafosAD2();
        grafosad2.ler_ArquivoExterno(false);
        conectar(grafosad2);
        imprimir();
    }
}
