package com.oocl.web.sampleWebApp;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SingleEntity {
    @Id
    public Long id;
    public String name;
}

interface SingleEntityRepository extends JpaRepository<SingleEntity, Long> {}

