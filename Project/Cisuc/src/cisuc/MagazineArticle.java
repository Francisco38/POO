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
public class MagazineArticle extends Publication {

    private String summary;
    private String magazineName;
    private String magazineDate;
    private int magazineNum;
    
    /**
     * construtor
     */
    public MagazineArticle(String title, int publicationYear, int audience, String summary, String magazineName, String magazineDate, int magazineNum) {
        super(title, publicationYear, audience);
        this.summary = summary;
        this.magazineName = magazineName;
        this.magazineDate = magazineDate;
        this.magazineNum = magazineNum;
        this.type = "magazine article";
    }

    /**
     * metodo que calcula o fator de impacto
     * @return String fator de impacto
     */
    public String impactFactor() {
        if (this.getAudience() < 500) {
            return "C";
        } else if (this.getAudience() >= 1000) {
            return "A";
        } else {
            return "B";
        }
    }

    /**
     * @return the summary
     */
    public String getSummary() {
        return summary;
    }

    /**
     * @param summary the summary to set
     */
    public void setSummary(String summary) {
        this.summary = summary;
    }

    /**
     * @return the magazineName
     */
    public String getMagazineName() {
        return magazineName;
    }

    /**
     * @param magazineName the magazineName to set
     */
    public void setMagazineName(String magazineName) {
        this.magazineName = magazineName;
    }

    /**
     * @return the magazineDate
     */
    public String getMagazineDate() {
        return magazineDate;
    }

    /**
     * @param magazineDate the magazineDate to set
     */
    public void setMagazineDate(String magazineDate) {
        this.magazineDate = magazineDate;
    }

    /**
     * @return the magazineNum
     */
    public int getMagazineNum() {
        return magazineNum;
    }

    /**
     * @param magazineNum the magazineNum to set
     */
    public void setMagazineNum(int magazineNum) {
        this.magazineNum = magazineNum;
    }

}
