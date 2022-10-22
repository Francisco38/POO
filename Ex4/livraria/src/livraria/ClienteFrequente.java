

package livraria;

/**
 *
 * @author Francisco Antonio Da Cruz Faria 2019227649
 */
public class ClienteFrequente extends Cliente{

    /**
     * construtor vazio
     */
    public ClienteFrequente() {
    }

    /**
     * construtor 
     * @param nome
     * @param email 
     */
    public ClienteFrequente(String nome, String email) {
        //recorrendo ao construtor do pai atribuir as variaveis
        super(nome, email);
    }
    
    /**
     * adiciona uma compra ao array compras depois de aplicar o desconto
     * @param l livro que pretendemos adicionar
     */
    public void addCompra(Livro l) {
        //aplicação do desconto de 5%
        l.setPreco(((float)(l.preco*0.95)));
        
        //recorrer a funcao do pai para adicionar o livro
        super.addCompra(l);
    }
    
}
