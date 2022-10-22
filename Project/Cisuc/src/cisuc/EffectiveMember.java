/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cisuc;

/**
 *
 * @author faria
 */
public class EffectiveMember extends Investigator {
    private int numeroGabinete;
    private int numeroTeleDei;

    /**
     * construtor
     */
    public EffectiveMember() {
        super();
    }
    
    /**
     * construtor
     */
    public EffectiveMember(String nome, String email, ResearchGroup grupo,int numeroGabinete,int numeroTeleDei) {
        super(nome, email, grupo);
        this.numeroGabinete = numeroGabinete;
        this.numeroTeleDei = numeroTeleDei;
        type="effective";
    }

    /**
     * @return the numeroGabinete
     */
    public int getNumeroGabinete() {
        return numeroGabinete;
    }

    /**
     * @param numeroGabinete the numeroGabinete to set
     */
    public void setNumeroGabinete(int numeroGabinete) {
        this.numeroGabinete = numeroGabinete;
    }

    /**
     * @return the numeroTeleDei
     */
    public int getNumeroTeleDei() {
        return numeroTeleDei;
    }

    /**
     * @param numeroTeleDei the numeroTeleDei to set
     */
    public void setNumeroTeleDei(int numeroTeleDei) {
        this.numeroTeleDei = numeroTeleDei;
    }

    /**
     * 
     * @return 
     */
    public String toString() {
        return  super.toString()+"," + numeroGabinete + "," + numeroTeleDei;
    }
    
    
}
