

package livraria;
import java.util.ArrayList;

/**
 *
 * @author Francisco Antonio Da Cruz Faria 2019227649
 */
public class Cliente {
    //atributos
    protected String nome;
    protected String email;
    protected ArrayList<Livro> compras;
    
    /**
     * construtor vazio
     */
    public Cliente() {
        //inicializacao do array compras
        compras=new ArrayList<>();
    }
    
    /**
     * construtor
     * @param nome
     * @param email 
     */
    public Cliente(String nome, String email) {
        //inicializar as variaveis que necessitam de ser inicilizadas recurendo ao construtor vazio
        this();
        
        //atribuicao dos valores dados como argumentos aos atributos
        setNome(nome);
        setEmail(email);
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the compras
     */
    public ArrayList<Livro> getCompras() {
        return compras;
    }

    /**
     * adiciona um livro ao array compras
     * @param l livro que pretendemos adicionar
     */
    public void addCompra(Livro l) {
        compras.add(l);
    }

    
    
}
