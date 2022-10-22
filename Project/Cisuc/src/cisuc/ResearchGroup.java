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
public class ResearchGroup implements Serializable{
    private String name;
    private String acronym;
    private Investigator responsibleResearcher;
    private ArrayList<Investigator> members;

    /**
     * construtor
     */
    public ResearchGroup() {
        this.members = new ArrayList<>();
    }

    /**
     * construtor
     */
    public ResearchGroup(String name, String acronym) {
        this.name = name;
        this.acronym = acronym;
        this.members = new ArrayList<>();
    }


    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the acronym
     */
    public String getAcronym() {
        return acronym;
    }

    /**
     * @param acronym the acronym to set
     */
    public void setAcronym(String acronym) {
        this.acronym = acronym;
    }

    /**
     * @return the responsibleResearcher
     */
    public Investigator getResponsibleResearcher() {
        return responsibleResearcher;
    }

    /**
     * @param responsibleResearcher the responsibleResearcher to set
     */
    public void setResponsibleResearcher(Investigator responsibleResearcher) {
        this.responsibleResearcher = responsibleResearcher;
    }

    /**
     * @return the members
     */
    public ArrayList<Investigator> getMembers() {
        return members;
    }

    /**
     * @param member the member to add
     */
    public void addMembro(Investigator member) {
        members.add(member);
    }
    
}
