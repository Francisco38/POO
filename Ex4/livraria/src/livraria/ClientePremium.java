

package livraria;

/**
 *
 * @author Francisco Antonio Da Cruz Faria 2019227649
 */
public class ClientePremium extends Cliente{
    
    /**
     * construtor vazio
     */
    public ClientePremium() {
    }

    /**
     * construtor 
     * @param nome
     * @param email 
     */
    public ClientePremium(String nome, String email) {
        super(nome, email);
    }
    
    /**
     * adiciona uma compra ao array compras depois de aplicar o desconto
     * @param l livro que pretendemos adicionar
     */
    public void addCompra(Livro l) {
        
        //aplicação do desconto de 10%
        l.setPreco(((float)(l.preco*0.90)));
        
        //recorrer a funcao do pai para adicionar o livro
        super.addCompra(l);
    }
}
