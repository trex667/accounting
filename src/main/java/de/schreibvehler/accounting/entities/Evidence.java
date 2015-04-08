package de.schreibvehler.accounting.entities;


import java.util.Date;

import javax.persistence.*;

@Entity
@Access(AccessType.FIELD)
public class Evidence {
    
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer id;
    
    @Enumerated(EnumType.STRING)
    private EvidenceType type;

    private Float value;
    
    @Temporal(TemporalType.DATE)
    private Date date;
    
    private String description;

    public void setId(Integer pk) {
        id = pk;
    }
    
    public Integer getId() {
        return id;
    }

    public void setValue(Float value) {
        this.value = value;
    }

    public Float getValue() {
        return value;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Evidence)) {
            return false;
        }
        Evidence other = (Evidence) obj;
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }
        return true;
    }

    public EvidenceType getType() {
        return type;
    }

    public void setType(EvidenceType type) {
        this.type = type;
    }


    
}
