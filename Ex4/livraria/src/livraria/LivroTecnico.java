

package livraria;

/**
 *
 * @author Francisco Antonio Da Cruz Faria 2019227649
 */
public class LivroTecnico extends Livro{
    private String Esp;

    /**
     * construtor vazio
     */
    public LivroTecnico() {
        //defenir o livro como tecnico
        type=0;
    }

    /**
     * construtor 
     * @param autor
     * @param titulo
     * @param preco
     * @param Esp 
     */
    public LivroTecnico(String autor, String titulo, int preco,String Esp) {
        //recorrendo ao construtor do pai inicializar as caracteristicas autor titulo preco
        super(autor, titulo, preco);
        
        //defenir o livro como tecnico
        type=0;
        
        //inicializacao de Esp pelo valor dado como argumento
        setEsp(Esp);
    }

    /**
     * @return the Esp
     */
    public String getEsp() {
        return Esp;
    }

    /**
     * @param Esp the areaDeEsp to set
     */
    public void setEsp(String Esp) {
        this.Esp = Esp;
    }
    
}
