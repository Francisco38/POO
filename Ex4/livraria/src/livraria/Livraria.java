

package livraria;

import java.util.ArrayList;

/**
 *
 * @author Francisco Antonio Da Cruz Faria 2019227649
 */
public class Livraria {
    //atributos da livraria
    private ArrayList<Livro> livros;
    private ArrayList<Cliente> clientes;

    /**
     * construtor
     */
    public Livraria() {
        livros = new ArrayList<>();
        clientes = new ArrayList<>();
    }

    public static void main(String[] args) {
        Livraria livraria = new Livraria();
        
        System.out.println("---------START-----------------");
        //inicializaçao de diversos livros e adiciocao ao array  
        Livro l1 = new LivroTecnico("H. Schildt", "\"Java: The Complete Reference\"", 80, "Computer Science- Java");
        livraria.addLivro(l1);
        Livro l2 = new LivroTecnico("E. Gamma et al.", "\"Design Patterns\"", 80, "Computer Science -Basic");
        livraria.addLivro(l2);
        Livro l3 = new LivroTecnico("M. Fowler", "\"UML Distilled\"", 70, "Computer Science - UML");
        livraria.addLivro(l3);
        Livro l4 = new LivroTecnico("D. Knuth", "\"The Art of Computer Programming\"", 90, "Computer~Science - Basics");
        livraria.addLivro(l4);
        Livro l5 = new LivroAventura("A. Christie", "\"The Man in the Brown Suit\"", 75, 14);
        livraria.addLivro(l5);

        //inicializacao de diversos clientes e adicao ao array 
        Cliente c1 = new ClientePremium("B. Antunes", "antunes@books.com");
        livraria.addCliente(c1);
        Cliente c2 = new ClienteFrequente("A. Oliveira", "oliveira@books.com");
        livraria.addCliente(c2);
        Cliente c3 = new ClienteRegular("C. Teodoro", "teodoro@books.com");
        livraria.addCliente(c3);

        //print de todos os livros no array livros
        System.out.println("\nStock inicial:");
        livraria.printStock(livraria.livros);
        
        //venda de livros e informar o utilizador do sucesso da operacao ou de potenciais erros
        System.out.println("\nCompras:");
        System.out.println(livraria.venda(l1, c3));
        System.out.println(livraria.venda(l2, c2));
        System.out.println(livraria.venda(l3, c1));
        System.out.println(livraria.venda(l5, c1));
        
        //calculo e impressão do valor total dos livros vendidos 
        System.out.println("\nVolume de vendas: " + livraria.getValorVendas());
        
        //imprime lista de todos os livros ainda disponiveis para venda
        System.out.println("\nStock final:");
        livraria.printStock(livraria.livros);

        //impressao do titulo de todos os livros comprados por c1
        System.out.println("");
        livraria.printComprasTodas();
        
        System.out.println("-------------------END-----------");
    }
    
    /**
     * adiciona l ao array livros
     * @param l livro que se quer adicionar
     */
    public void addLivro(Livro l){
        livros.add(l);
    }
    
    /**
     * adiciona o cliente c ao array clientes
     * @param c cliente que se pretende adicionar
     */
    public void addCliente(Cliente c){
        clientes.add(c);
    }
    
    /**
     * venda do livro l ao cliente c 
     * @param l livro que se vai vender
     * @param c cliente que quer comprar l
     * @return se o livro estiver disponivel devolve informaçoes relevantes sobre a transacao, isto e nome do cliente, o nome do livro, 
     * o tipo de livro e as caracteristicas especificas do mesmo e o preco, caso contrario devolve um aviso a dizer que o livro nao esta disponivel
     */
    public String venda(Livro l,Cliente c){
        //inicializaçao da varivel para guardar o index do livro
        int index=livros.indexOf(l);
        
        //confirma se o livro esta disponivel,caso nao estea devolve um string com essa informação
        if(index!=-1){
            //se o cliente nao existir adicionar ao array clientes
            if(clientes.indexOf(c)==-1){ 
                clientes.add(c);
            }
            
            //adiciona o livro l aos livros comprados por c
            c.addCompra(l);
            
            //remove o livro l do array livros
            livros.remove(index);
            
            //se o livro for tecnico
            if (l.getType()==0){
                //devolver um string com as informações importantes
                return c.getNome()+" comprou "+l.getTitulo()+", livro tecnico de "+l.getEsp()+", por "+l.getPreco();
            }
            
            //se o livro for de aventura
            else{
                //devolver um string com as informações importantes
                return c.getNome()+" comprou "+l.getTitulo()+", livro de aventura para maiores de "+l.getIdade()+" anos , por "+l.getPreco();
            }
        }
        else{
            //devolve string a avisar que o livro pedido nao existe
            return "Livro nao disponivel";
        }
    }
    
    /**
     * imprime todos os Livros que estão na lista
     * @param lista lista de Livros
     */
    public void printStock(ArrayList<Livro> lista){
        //ciclo que percore todos os valores da lista
        for(Livro i: lista){
            
            //imprime todas as informções sobre o livro i
            System.out.println(i);
            
        }
    }
    
    /**
     * imprime as compras de todos os clientes
     */
    public void printComprasTodas(){
        //ciclo que percorre todos os valores no array clientes
        for(Cliente c:clientes){
            //imprime as compras do cliente c com utilizando o metodo printCompras
            printCompras(c);
        }
    }
    
    /**
     * imprime todos o titulo de todos os livros comprados pelo cliente c
     * @param c cliente
     */
    public void printCompras(Cliente c){
        System.out.print(c.getNome()+" comprou:");
        
        //ciclo que percore todos os livros comprados pelo cliente c
        for (Livro i : c.getCompras()){
            
            //imprime o titulo do livro i
            System.out.print(i.getTitulo()+".");
        }
        System.out.println("");
    }
    
    /**
     * calcula e devolve o valor total dos livros vendidos
     * @return float com o valor total 
     */
    public float getValorVendas(){
        //inicialização da variavel total como float
        float total=0;
        
        //cliclo que percorre todos os clientes no array clientes
        for (Cliente c: this.clientes){
            
            //ciclo que percorre todos os livros comprados pelo cliente c
            for (Livro l : c.getCompras()){
                
                //adiciona o preco do livro ao total
                total+=l.getPreco();
            }
        }
        
        //devolve o total
        return total;
    }
}
