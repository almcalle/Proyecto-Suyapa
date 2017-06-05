package com.almcalle.suyapa.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Alumno {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	Long id;
	
	String nombre;
	
	Integer edad;
	
	enum Sexo {
	    MASCULINO, FEMENINO;
	}
	
	enum Colegio {
	    Colegio1, Colegio2;
	}
	
	enum Clase {
	    PRIMERO_A, PRIMERO_B;
	}
	
	Date fechaNacimiento;
	
	String domicilio;
	
	String idTutor;
	
	
	
// domicilio, colonia, numero de identidad del tutor, nombre y fecha nacimiento de la madre (creo)
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getEdad() {
		
		
		return edad;
	}
	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	
	@Override
	public String toString() {
		return "Alumno [id=" + id + ", nombre=" + nombre + ", edad=" + edad + "]";
	}
	

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getDomicilio() {
		return domicilio;
	}
	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}
	public String getIdTutor() {
		return idTutor;
	}
	public void setIdTutor(String idTutor) {
		this.idTutor = idTutor;
	}
}
