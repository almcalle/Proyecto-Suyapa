package com.almcalle.suyapa.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.almcalle.suyapa.domain.Alumno;
import com.almcalle.suyapa.repository.AlumnoRepository;

@Controller
public class AlumnoController {
	
	private final Logger log = LoggerFactory.getLogger(AlumnoController.class);

	
	
	@Autowired
	AlumnoRepository alumnoRepository;

	
	 @GetMapping("/alumnos")
	    public String listaAlumno(Model model) {
		 log.debug("Accediendo a /alumnos");	 
		List<Alumno> alumnos = alumnoRepository.findAll();
		 log.debug("Lista de alumnos: " + alumnos.toString());		 
	        model.addAttribute("alumnos", alumnos );	       
	        return "alumno/listAlumnos";
	    }
	
	
	
    @GetMapping("/alumno/add")
    public String mostrarFormAlumno(Model model) {
		 log.debug("Accediendo a /alumno/add");
    	 model.addAttribute("alumno", new Alumno());
        return "alumno/addAlumno";
    }

    @PostMapping("/alumno")
    public String guardarAlumno(@ModelAttribute Alumno alumno) {    	
		 log.debug("Guardando Alumno");    	
    	alumnoRepository.save(alumno);       	
        return "alumno/detalleAlumno";
    }

    
	@GetMapping("/alumno/{id}")
	public String detalleAlumno(Model model, @PathVariable(value = "id") Long id) {
		log.debug("Detalle Alumno del Alumno: " + id);
		Alumno alumno = alumnoRepository.findById(id).orElse(null);

		if (alumno != null) {
			log.debug("Alumno obtenido: " + alumno);

			model.addAttribute("alumno", alumno);

			return "alumno/detalleAlumno";
		} else
			return "alumno/noAlumno";

	}
    
    
}