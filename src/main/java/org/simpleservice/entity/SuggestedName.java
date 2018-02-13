package org.simpleservice.entity;

import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Juneau
 */
@Entity
@Table(name = "SUGGESTED_NAME")
@NamedQueries({
    @NamedQuery(name = "SuggestedName.findAll", query = "SELECT sn FROM SuggestedName sn"),
    @NamedQuery(name = "SuggestedName.find", query = "SELECT sn FROM SuggestedName sn WHERE sn.id = :id")
})
public class SuggestedName implements java.io.Serializable {

    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Size(max = 150, message = "The title cannot exceed {max} characters, current title is $'{validatedValue}'")
    @Column(name = "NAME")
    private String name;

    /**
     * @return the id
     */
    public BigDecimal getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(BigDecimal id) {
        this.id = id;
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
}
