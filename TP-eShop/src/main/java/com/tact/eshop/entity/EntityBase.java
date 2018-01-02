package com.tact.eshop.entity;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/** Base of all entity. */
@MappedSuperclass
public abstract class EntityBase {

    /** Technical ID for Database. */
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    public Date createdAt = new Date();

    @Temporal(TemporalType.TIMESTAMP)
    public Date updatedAt = new Date();

    @PreUpdate
    @PrePersist
    public void setLastUpdate() {
        this.setUpdatedAt( new Date() );
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @return the createdAt
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * @param createdAt the createdAt to set
     */
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * @return the updatedAt
     */
    public Date getUpdatedAt() {
        return updatedAt;
    }

    /**
     * @param updatedAt the updatedAt to set
     */
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
