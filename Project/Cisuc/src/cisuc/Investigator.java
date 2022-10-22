/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cisuc;

import java.io.Serializable;

/**
 *
 * @author faria
 */
public class Investigator implements Comparable<Investigator>,Serializable {

    protected String name;
    protected String email;
    protected ResearchGroup group;
    protected String type;

    /**
     * construtor
     */
    public Investigator() {
        group=new ResearchGroup();
    }

    /**
     * construtor
     */
    public Investigator(String name, String email, ResearchGroup group) {
        this.name = name;
        this.email = email;
        this.group = group;
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
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the group
     */
    public ResearchGroup getGroup() {
        return group;
    }

    /**
     * @param group the group to set
     */
    public void setGroup(ResearchGroup group) {
        this.group = group;
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

    public int compareTo(Investigator i) {
        return (i.getType().compareTo(type)<=0) ? 1 : -1;
    }

    /**
     * passa todos os atributos para um string
     * @return string
     */
    @Override
    public String toString() {
        return name + "," + email + "," + group.getAcronym() ;
    }
    
}
