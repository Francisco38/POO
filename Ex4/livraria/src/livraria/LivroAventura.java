

package livraria;

/**
 *
 * @author Francisco Antonio Da Cruz Faria 2019227649
 */
public class LivroAventura extends Livro{
    private int idade;

    /**
     * construtor vazio
     */
    public LivroAventura() {
        //defenir o livro como de aventura
        type=1;
    }

    /**
     * construtor 
     * @param autor
     * @param titulo
     * @param preco
     * @param idade 
     */
    public LivroAventura(String autor, String titulo, int preco,int idade) {
        //recorrendo ao construtor do pai inicializar as caracteristicas autor titulo preco
        super(autor, titulo, preco);
        
        //defenir o livro como de aventura
        type=1;
        
        //inicializacao da idade pelo valor dado como argumento
        setIdade(idade);
    }

    /**
     * @return the idade
     */
    public int getIdade() {
        return idade;
    }

    /**
     * @param idade the idade to set
     */
    public void setIdade(int idade) {
        if (idade>=0){
            this.idade = idade;
        }
        else{
            System.out.println("A idade nao pode ser negativa");
        }
    }
    
    
}
