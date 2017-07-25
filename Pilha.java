package pilha;

/**
 *
 * @author Cibele Ramos da Silva - 13113050303
 */
public class Pilha {
    
   //enunciado 
   //b) Altere a declaração dos campos de forma que estes não possam ser modificados
   //fora da classe Pilha. 
   // Cibele: feito exceto a variável topo que precisa ser incrementada/
   // decrementada abaixo)
    final static int TAM_MAX = 1000;
    final int Valores[] = new int[TAM_MAX]; //inicializei a variável
    int topo;
   
   //a) Defina um construtor para a classe.
   public Pilha() { 
     topo = -1;
   }

   //c) Declare o método empty, o qual testa se uma pilha está vazia.
   public boolean empty() {
     return (topo == -1);
   }
   
   //d) Declare o método push, o qual insere um valor no topo da pilha.
   public void push(int valor) {
     Valores[++topo] = valor;
   }

  //e) Declare o método pop, o qual remove um valor do topo da pilha e o retorna.
  //Cibele: coloquei já retornando a exclusão
   public int pop() {
     return Valores[topo--];
   }
   
/*f) Declare uma variação do método pop, a qual recebe um número e desempilha
tantos valores quanto o número passado. Caso o valor seja maior que o número de
números empilhados, todos os valores são removidos. Esta função não retorna
nenhum valor. */
   public void popMultiplo(int quantidade){
      int i = 0;
     // System.out.println(quantidade + " max " + TAM_MAX + " topo " + topo);  
      if (quantidade >= TAM_MAX) {
         topo = -1;
      }
      while (i < quantidade) {
         topo--; 
         i++;  
      }
   }
/*g) Declare o método top, o qual apenas retorna o valor do topo da pilha, sem
modificá-la. */
   public int top(){
       return Valores[topo];
   }
   
/*h) Crie uma classe Principal com um método main(). Crie um objeto do tipo Pilha e
insira os valores 10, 20 e 30. Remova 2 elementos da pilha e exiba o seu topo
resultante.*/
    public static void main(String[] args) {
      Pilha pilha = new Pilha();
      pilha.push(10);
      pilha.push(20);
      pilha.push(30);
      pilha.popMultiplo(2);
      System.out.println(pilha.top());     
    } 
}
