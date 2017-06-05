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

import com.almcalle.suyapa.domain.Paciente;
import com.almcalle.suyapa.repository.PacienteRepository;

@Controller
public class PacienteController {
	
	private final Logger log = LoggerFactory.getLogger(PacienteController.class);

	
	
	@Autowired
	PacienteRepository pacienteRepository;

	
	 @GetMapping("/pacientes")
	    public String listaPaciente(Model model) {
		 log.debug("Accediendo a /pacientes");	 
		List<Paciente> pacientes = pacienteRepository.findAll();
		 log.debug("Lista de pacientes: " + pacientes.toString());		 
	        model.addAttribute("pacientes", pacientes );	       
	        return "paciente/listPacientes";
	    }
	
	
	
    @GetMapping("/paciente/add")
    public String mostrarFormPaciente(Model model) {
		 log.debug("Accediendo a /paciente/add");
    	 model.addAttribute("paciente", new Paciente());
        return "paciente/addPaciente";
    }

    @PostMapping("/paciente")
    public String guardarPaciente(@ModelAttribute Paciente paciente) {    	
		 log.debug("Guardando Paciente");    	
    	pacienteRepository.save(paciente);       	
        return "paciente/detallePaciente";
    }

    
	@GetMapping("/paciente/{id}")
	public String detallePaciente(Model model, @PathVariable(value = "id") Long id) {
		log.debug("Detalle Paciente del paciente: " + id);
		Paciente paciente = pacienteRepository.findById(id).orElse(null);

		if (paciente != null) {
			log.debug("Paciente obtenido: " + paciente);

			model.addAttribute("paciente", paciente);

			return "paciente/detallePaciente";
		} else
			return "paciente/noPaciente";

	}
    
    
}