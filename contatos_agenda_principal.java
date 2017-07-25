package principal;
/**
 *
 * @author Cibele Ramos da Silva - 13113050303
 * AVISO: Tutora, fiz usando ArrayList pois vi nessa mensagem http://graduacao.cederj.edu.br/ava/local/cecierj_tutoria/index.php?op=3&menu=4&course_id=231&user_id=52978&topico=329259
 * que poderia ser feito assim, apesar de pedir "Vetor" no enunciado da questão.
 */

import java.util.ArrayList;
import java.util.List;

class Contato {
    //o enunciado nao pede id, mas fica mais facil para editar/remover. Por nome poderia editar/remover o errado
   //não com os contatos do exercício, mas em casos futuros
    private int codigodoContato;
    private String nomedoContato;
    private int telefonedoContato;
    private String enderecodoContato;
    private String lembretedoContato;

    public Contato(int codigodoContato, String nomedoContato, int telefonedoContato, String enderecodoContato, String lembretedoContato) {
	this.codigodoContato = codigodoContato;
        this.nomedoContato = nomedoContato;
        this.telefonedoContato = telefonedoContato;
        this.enderecodoContato = enderecodoContato;
        this.lembretedoContato = lembretedoContato;
    }
    public Contato() {
    }

    public int getCodigo() {
        return codigodoContato;
    }

    public void setCodigo(int codigodoContato) {
        this.codigodoContato = codigodoContato;
    }
	
    public String getNome() {
        return nomedoContato;
    }

    public void setNome(String nomedoContato) {
        this.nomedoContato = nomedoContato;
    }
    
    public int getTelefone() {
        return telefonedoContato;
    }

    public void setTelefone(int telefonedoContato) {
        this.telefonedoContato = telefonedoContato;
    }
    
    public String getEndereco() {
        return enderecodoContato;
    }

    public void setEndereco(String enderecodoContato) {
        this.enderecodoContato = enderecodoContato;
    }
	
    public String getLembrete() {
        return lembretedoContato;
    }

    public void setLembrete(String lembretedoContato) {
        this.lembretedoContato = lembretedoContato;
    }	
    
    public String ToString() {
        return "Contato " + getCodigo() + " -> Nome: " + getNome() + " Telefone: " + getTelefone() +
               " Endereço: " + getEndereco() + " Lembrete: " + getLembrete();
    }
}

class AgendaContatos {
private List<Contato> contatos;

    public AgendaContatos(List<Contato> contatos) {
        this.contatos = contatos;
    }
    
    public AgendaContatos() {
        contatos = new ArrayList<>();
    }
    
    public List<Contato> getContatos() {
        return contatos;
    }
    
    //letra c - listar contatos com ToString()
    public void todosOsContatos() {
      for (Contato contato : contatos) {
        System.out.println(contato.ToString());
    }
    }

    //letra b - inserção
    public void add(Contato contato)
    {
        Contato contatoadd = buscaPorNomeUnico(contato.getNome());
        if (contatoadd == null) {
          contatos.add(contato);   
        } else {
          edit(contato, contatoadd.getCodigo()); 
        }
    }
    
    //letra b - alteração
    public void edit(Contato contato, int codigo)
    {
        Contato contatoEdit = buscaPorCodigo(codigo);
        contatoEdit.setEndereco(contato.getEndereco());
        contatoEdit.setTelefone(contato.getTelefone());
        contatoEdit.setLembrete(contato.getLembrete());
        //abaixo coloquei uma obs sobre edição no lembrete, mas como não pede
        //no enunciado deixei comentado e optei por deixar "valendo" só a linha acima
        //contatoEdit.setLembrete(contato.getLembrete() + " (contato editado)");
    }
    
    public Contato buscaPorCodigo(int codigo)
    {
        Contato result = null;
        int i = 0;
        while (i < contatos.size() && result == null)
        {
            if (codigo == contatos.get(i).getCodigo())
            {
                result = contatos.get(i);
            }
            i++;
        }
        return result;
    }
    
    //letra b - remoção
    public void remover(String nomecontato)
    {
        Contato contatoremover = buscaPorNomeUnico(nomecontato);
        contatos.remove(contatoremover);
    }

    //letra a - buscar contatos por nome ou parte e retornar o primeiro Contato(objeto)
    public Contato buscaPorNomeRetorna(String nome)
    {
        Contato result = null;
        int i = 0;                    //se já achou para de procurar  
        while (i < contatos.size() && result == null)
        {
            if (contatos.get(i).getNome().contains(nome))
            {
                result = contatos.get(i);
            }
            i++;
        }
        return result;
    }
    
    //letra b - ver se contato já existe antes de incluir para, caso exista, editar
    public Contato buscaPorNomeUnico(String nome)
    {
        Contato result = null;
        int i = 0;
        while (i < contatos.size() && result == null)
        {
            if (contatos.get(i).getNome().equalsIgnoreCase(nome))
            {
                result = contatos.get(i);
            }
            i++;
        }
        return result;
    }
}

public class Principal {
    public static void main(String[] args) {
      AgendaContatos agenda = new AgendaContatos();
        
    //letra d - instanciando as classes para inserir abaixo
      Contato contatoum = new Contato(1, "Fulano", 99999999, "Rua A", "Amigo");
      Contato contatodois = new Contato(2, "Ciclano", 88888888, "Rua B", "Vizinho do amigo");
      Contato contatotres = new Contato(3, "Beltrano", 88889999, "Rua C", "Não lembro mais quem é");

    //letra d - inserindo os contatos do enunciado
      agenda.add(contatoum);
      agenda.add(contatodois);
      agenda.add(contatotres);

    //letra e - adicionar um contato, remover outro e listar todos
      Contato contatoquatro = new Contato(4, "Fulano", 77777777, "Rua D", "Tem um unicórnio");
      agenda.add(contatoquatro);
      agenda.remover("Ciclano");
      agenda.todosOsContatos();
    } 
}
