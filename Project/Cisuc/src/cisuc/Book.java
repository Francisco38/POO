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
public class Book extends Publication {
    protected String summary;
    protected String publishingCompany;
    protected String isbn;

    /**
     * construtor
     */
    public Book() {
        super();
    }

    /**
     * construtor
     */
    public Book(String title, int publicationYear, int audience, String summary, String publishingCompany, String isbn) {
        super(title, publicationYear, audience);
        this.summary = summary;
        this.publishingCompany = publishingCompany;
        this.isbn = isbn;
        this.type = "book";
    }

    /**
     * metodo que calcula o fator de impacto
     * @return String fator de impacto
     */
    public String impactFactor() {
        if (this.getAudience() < 500) {
            return "C";
        } else if (this.getAudience() >= 10000) {
            return "B";
        } else {
            return "A";
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
     * @return the publishingCompany
     */
    public String getPublishingCompany() {
        return publishingCompany;
    }

    /**
     * @param publishingCompany the publishingCompany to set
     */
    public void setPublishingCompany(String publishingCompany) {
        this.publishingCompany = publishingCompany;
    }

    /**
     * @return the isbn
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * @param isbn the isbn to set
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

}
