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
public class BookChapters extends Book{
    private String chapterName;
    private int initialPage;
    private int finalPage;

    /**
     * construtor
     */
    public BookChapters(String title, int publicationYear, int audience, String summary, String publishingCompany, String isbn,String chapterName, int initialPage, int finalPage) {
        super(title, publicationYear, audience, summary, publishingCompany, isbn);
        this.chapterName = chapterName;
        this.initialPage = initialPage;
        this.finalPage = finalPage;
        this.type="book chapters";
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
     * @return the chapterName
     */
    public String getChapterName() {
        return chapterName;
    }

    /**
     * @param chapterName the chapterName to set
     */
    public void setChapterName(String chapterName) {
        this.chapterName = chapterName;
    }

    /**
     * @return the initialPage
     */
    public int getInitialPage() {
        return initialPage;
    }

    /**
     * @param initialPage the initialPage to set
     */
    public void setInitialPage(int initialPage) {
        this.initialPage = initialPage;
    }

    /**
     * @return the finalPage
     */
    public int getFinalPage() {
        return finalPage;
    }

    /**
     * @param finalPage the finalPage to set
     */
    public void setFinalPage(int finalPage) {
        this.finalPage = finalPage;
    }
    
    
}
