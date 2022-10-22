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
public class Student extends Investigator{
    private String thesisTitle;
    private String conclusionDate;
    private EffectiveMember advisor;

    /**
     * construtor
     */
    public Student() {
        advisor = new EffectiveMember();
    }

    /**
     * construtor
     */
    public Student( String nome, String email, ResearchGroup grupo,String tituloDaDefesa, String dataConclusao,  EffectiveMember orientador) {
        super(nome, email, grupo);
        this.thesisTitle = tituloDaDefesa;
        this.conclusionDate = dataConclusao;
        this.advisor = orientador;
        type="student";
    }

    
    /**
     * @return the thesisTitle
     */
    public String getThesisTitle() {
        return thesisTitle;
    }

    /**
     * @param thesisTitle the thesisTitle to set
     */
    public void setThesisTitle(String thesisTitle) {
        this.thesisTitle = thesisTitle;
    }

    /**
     * @return the conclusionDate
     */
    public String getConclusionDate() {
        return conclusionDate;
    }

    /**
     * @param conclusionDate the conclusionDate to set
     */
    public void setConclusionDate(String conclusionDate) {
        this.conclusionDate = conclusionDate;
    }

    /**
     * @return the advisor
     */
    public EffectiveMember getAdvisor() {
        return advisor;
    }

    /**
     * @param advisor the advisor to set
     */
    public void setAdvisor( EffectiveMember advisor) {
        this.advisor = advisor;
    }

    @Override
    public String toString() {
        return super.toString()+"," + thesisTitle + "," + conclusionDate + "," + advisor.getName();
    }
    
    
}
