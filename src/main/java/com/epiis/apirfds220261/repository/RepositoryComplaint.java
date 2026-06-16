package com.epiis.apirfds220261.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.epiis.apirfds220261.entity.EntityComplaint;

@Repository
public interface RepositoryComplaint extends JpaRepository<EntityComplaint, String> {}