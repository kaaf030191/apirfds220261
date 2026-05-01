package com.epiis.apirfds220261.entity;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tcomplaint")
@Setter
@Getter
public class EntityComplaint {
    @Id
    @Column(name = "idComplaint")
    private String idComplaint;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idOffice")
    private EntityOffice parentOffice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idProfessor")
    private EntityProfessor parentProfessor;

    @Column(name = "code")
    private String code;

    @Column(name = "personFullName")
    private String personFullName;

    @Column(name = "description")
    private String description;

    @Column(name = "issueDate")
    private Date issueDate;

    @Column(name = "status")
    private String status;

    @Column(name = "createdAt")
    private Date createdAt;

    @Column(name = "updatedAt")
    private Date updatedAt;

    @OneToMany(mappedBy = "parentComplaint", cascade = CascadeType.ALL)
    private List<EntityComplaintFile> childComplateFile;

    @OneToMany(mappedBy = "parentComplaint", cascade = CascadeType.ALL)
    private List<EntityComplaintComment> childComplaintComment;
}