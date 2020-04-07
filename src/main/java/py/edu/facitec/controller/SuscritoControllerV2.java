package py.edu.facitec.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//Utilizando la Arquitetura RESET

import py.edu.facitec.model.Suscrito;
import py.edu.facitec.repository.SuscritoRepository;
@RestController
//Atiende requisiciones
@RequestMapping("/suscritos")

public class SuscritoControllerV2 {
	
	//inicializar
	@Autowired
	private SuscritoRepository suscritoRepository;
	
	
	@GetMapping
	public List<Suscrito> getSuscritos(){
		System.out.println("Listando Elemento Java a Json");
		
		return suscritoRepository.findAll();
		
	}
	
	//suscritos/3
	@GetMapping(value = "/{codigo}")
										//cargar la url de arriba al codigo
	public Optional<Suscrito> getSuscrito(@PathVariable long codigo ){
		
		System.out.println("Recuprando un elemnto Java a Json ");
		
		Optional<Suscrito> retorno=suscritoRepository.findById(codigo);
		
		return retorno;
		
	}
	
	@DeleteMapping("eliminar/{codigo}")
	public void eliminarSuscrito(@PathVariable Long codigo) {
		
		System.out.println("URL / suscritos/eliminar/3");
		
		suscritoRepository.deleteById(codigo);
		
	}
	
	@PostMapping()		 //Recibir Json que se convertira en Java
	public Suscrito guardar(@RequestBody Suscrito suscrito){
		
		System.out.println("Json a Jav");
	
	  Suscrito retorno=	suscritoRepository.save(suscrito);
	  
	  return retorno;
	}
	


}
