/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cisuc;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author faria
 */
public abstract class Publication implements Comparable<Publication>,Serializable {
    protected ArrayList<Investigator> authors;
    protected String title;
    protected ArrayList<String> keyWords;
    protected int publicationYear;
    protected int audience;
    protected String type;

    /**
     * construtor
     */
    public Publication() {
        this.authors = new ArrayList<>();
        this.keyWords = new ArrayList<>();
    }

    /**
     * construtor
     */
    public Publication(String title, int publicationYear, int audience) {
        this();
        this.title = title;
        this.publicationYear = publicationYear;
        this.audience = audience;
    }

    /**
     * @return the authors
     */
    public ArrayList<Investigator> getAuthors() {
        return authors;
    }

    /**
     * @param author the author to add
     */
    public void addAuthors(Investigator author) {
        this.authors.add(author);
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the keyWords
     */
    public ArrayList<String> getKeyWords() {
        return keyWords;
    }

    /**
     * @param keyWord the keyWord to add
     */
    public void addKeyWords(String keyWord) {
        this.keyWords.add(keyWord);
    }

    /**
     * @return the publicationYear
     */
    public int getPublicationYear() {
        return publicationYear;
    }

    /**
     * @param publicationYear the publicationYear to set
     */
    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    /**
     * @return the audience
     */
    public int getAudience() {
        return audience;
    }

    /**
     * @param audience the audience to set
     */
    public void setAudience(int audience) {
        this.audience = audience;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }
    
    /**
     * metodo que organiza para organizar o array por ano, por tipo de publicação e por fator de impacto
     * @param p
     * @return 
     */
    public int compareTo(Publication p) {
        if (p.getPublicationYear() > getPublicationYear()) {
            return -1;
        } else if (p.getPublicationYear() == getPublicationYear()) {
            if (p.getType().equals(this.getType())) {
                if (p.getAudience()>this.getAudience()) {
                    return 1;
                } else {
                    return -1;
                }
            } else if (p.getType().compareTo(this.getType()) < 0) {
                return 1;
            } else {
                return -1;
            }
        } else {
            return 1;
        }
    }
    
    /**
     * calcula o fator de impacto das publicacao
     * @return String fator de impacto
     */
    public abstract String impactFactor();

    /**
     * passa todas as imformacoes revelantes sobre a publicacao para um string 
     * @return string com todas as informacoes
     */
    @Override
    public String toString() {
        String a="";
        for(Investigator i:authors){
            a=a+i.getName()+",";
        }
        a=a+" "+this.getTitle()+","+this.publicationYear;
        return a;
    }
    
    
}
