package com.epiis.apirfds220261.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tcomplaintcomment")
@Setter
@Getter
public class EntityComplaintComment {
    @Id
    @Column(name = "idComplaintcomment")
    private String idComplaintcomment;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idComplaint")
    private EntityComplaint parentComplaint;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idUser")
    private EntityUser parentUser;

    @Column(name = "description")
    private String description;

    @Column(name = "createdAt")
    private Date createdAt;

    @Column(name = "updatedAt")
    private Date updatedAt;
}