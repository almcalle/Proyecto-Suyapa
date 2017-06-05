package com.almcalle.suyapa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.almcalle.suyapa.domain.Alumno;

/**
 * Spring Data JPA repository for the Ninio entity.
 */
@SuppressWarnings("unused")
@Repository
public interface AlumnoRepository extends JpaRepository<Alumno,Long> {

}
