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
public class ConferenceArticleBook extends Book{
    private String conferenceName;
    private int numArticles;

    /**
     * construtor
     */
    public ConferenceArticleBook(String title, int publicationYear, int audience, String summary, String publishingCompany, String isbn,String conferenceName, int numArticles) {
        super(title, publicationYear, audience, summary, publishingCompany, isbn);
        this.conferenceName = conferenceName;
        this.numArticles = numArticles;
        this.type="conference article book";
    }
    
    /**
     * metodo que calcula o fator de impacto
     * @return String fator de impacto
     */
    public String impactFactor() {
        if (this.getAudience() < 2500) {
                return "C";
            } else if (this.getAudience() >= 7500) {
                return "A";
            } else {
                return "B";
            }
    }
    
    /**
     * @return the conferenceName
     */
    public String getConferenceName() {
        return conferenceName;
    }

    /**
     * @param conferenceName the conferenceName to set
     */
    public void setConferenceName(String conferenceName) {
        this.conferenceName = conferenceName;
    }

    /**
     * @return the numArticles
     */
    public int getNumArticles() {
        return numArticles;
    }

    /**
     * @param numArticles the numArticles to set
     */
    public void setNumArticles(int numArticles) {
        this.numArticles = numArticles;
    }
    
}
