package com.techlab.entity;

import java.time.LocalDateTime;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class EntityBase<TId> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private TId id;
    private String createdBy;
    private String updatedBy;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
    protected EntityBase(){};
    public EntityBase(TId id, String createdBy, String updatedBy, LocalDateTime createDate, LocalDateTime updateDate) {
        this.id = id;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }
    public TId getId() {
        return id;
    }
    public void setId(TId id) {
        this.id = id;
    }
    public String getCreatedBy() {
        return createdBy;
    }
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
    public String getUpdatedBy() {
        return updatedBy;
    }
    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }
    public LocalDateTime getCreateDate() {
        return createDate;
    }
    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }
    public LocalDateTime getUpdateDate() {
        return updateDate;
    }
    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }

    
}
