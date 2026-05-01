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
@Table(name = "tcomplaintfile")
@Setter
@Getter
public class EntityComplaintFile {
    @Id
    @Column(name = "idComplaintfile")
    private String idComplaintfile;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idComplaint")
    private EntityComplaint parentComplaint;

    @Column(name = "name")
    private String name;

    @Column(name = "extension")
    private String extension;

    @Column(name = "createdAt")
    private Date createdAt;

    @Column(name = "updatedAt")
    private Date updatedAt;
}