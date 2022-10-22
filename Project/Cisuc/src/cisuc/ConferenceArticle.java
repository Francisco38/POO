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
public class ConferenceArticle extends Publication{
    private String sumary;
    private String confName;
    private String confDate;
    private String confLocalizacion;

    /**
     * construtor
     */
    public ConferenceArticle(String title, int publicationYear, int audience,String sumary, String confName, String confDate, String confLocalizacion) {
        super(title, publicationYear, audience);
        this.sumary = sumary;
        this.confName = confName;
        this.confDate = confDate;
        this.confLocalizacion = confLocalizacion;
        this.type="conference article";
    }
    
    /**
     * metodo que calcula o fator de impacto
     * @return String fator de impacto
     */
    public String impactFactor() {
        if (this.getAudience() < 200) {
                return "C";
            } else if (this.getAudience() >= 500) {
                return "A";
            } else {
                return "B";
            }
    }

    /**
     * @return the sumary
     */
    public String getSumary() {
        return sumary;
    }

    /**
     * @param sumary the sumary to set
     */
    public void setSumary(String sumary) {
        this.sumary = sumary;
    }

    /**
     * @return the confName
     */
    public String getConfName() {
        return confName;
    }

    /**
     * @param confName the confName to set
     */
    public void setConfName(String confName) {
        this.confName = confName;
    }

    /**
     * @return the confDate
     */
    public String getConfDate() {
        return confDate;
    }

    /**
     * @param confDate the confDate to set
     */
    public void setConfDate(String confDate) {
        this.confDate = confDate;
    }

    /**
     * @return the confLocalizacion
     */
    public String getConfLocalizacion() {
        return confLocalizacion;
    }

    /**
     * @param confLocalizacion the confLocalizacion to set
     */
    public void setConfLocalizacion(String confLocalizacion) {
        this.confLocalizacion = confLocalizacion;
    }
    
    
    
    
}
