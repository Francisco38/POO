

package livraria;

/**
 *
 * @author Francisco Antonio Da Cruz Faria 2019227649
 */
public class ClienteRegular extends Cliente{

    /**
     * construtor vazio
     */
    public ClienteRegular() {
    }

    /**
     * construtor 
     * @param nome
     * @param email 
     */
    public ClienteRegular(String nome, String email) {
        //recorrendo ao construtor do pai atribuir as variaveis
        super(nome, email);
    }
    
    /**
     * adiciona uma compra ao array compras
     * @param l livro que pretendemos adicionar
     */
    public void addCompra(Livro l) {
        //recorrer a funcao do pai para adicionar o livro
        super.addCompra(l);
    }
}
