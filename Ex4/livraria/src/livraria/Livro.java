

package livraria;

/**
 *
 * @author Francisco Antonio Da Cruz Faria 2019227649
 */
public class Livro {
    //atributos do livro
    protected String autor;
    protected String titulo;
    protected float preco;

    //variavel para identificar se o livro e tecnico ou de aventura sendo o tecnico igual a 0 e o de aventura correspondente a 1
    protected int type;
    
    
    /**
     * construtor vazio
     */
    public Livro() {
    }

    /**
     * construtor
     * @param autor
     * @param titulo
     * @param preco 
     */
    public Livro(String autor, String titulo, int preco) {    
        //atualizar os valores para os dados pelo utilizador
        setAutor(autor);
        setTitulo(titulo);
        setPreco(preco);
    }

    /**
     * @return the autor
     */
    public String getAutor() {
        return autor;
    }

    /**
     * @param autor the autor to set
     */
    public void setAutor(String autor) {
        this.autor = autor;
    }

    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the preco
     */
    public float getPreco() {
        return preco;
    }

    /**
     * @param preco the preco to set
     */
    public void setPreco(float preco) {
        if(preco>0){
            this.preco = preco;
        }
        else{
            System.out.println("preco tem de ser maior que 0");
        }
    }

    /**
     * @return the type
     */
    public int getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(int type) {
        this.type = type;
    }
    
    /**
     * metodo para se poder aplicar o polimorfismo
     * @return 
     */
    public String getEsp() {
        return "";
    }
    
    /**
     * metodo para se poder aplicar o polimorfismo
     * @return 
     */
    public int getIdade() {
        return 0;
    }
    
    /**
     * @return um string com as informaçoes sobre o livro
     */
    public String toString() {
        return autor + "," + titulo + "," +preco;
    }

    
}
