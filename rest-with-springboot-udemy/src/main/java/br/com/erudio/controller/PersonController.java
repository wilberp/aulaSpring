package br.com.erudio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import br.com.erudio.data.vo.v1.PersonVO;
import br.com.erudio.data.vo.v2.PersonVOV2;
import br.com.erudio.services.PersonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value="Person Ednpoints", description = "Descricao de Pessoas", tags = {"Pessoas Endpoints"})
@RestController
@RequestMapping("/api/person/v1")
public class PersonController {
	
	
	@Autowired
	private PersonService services;
	
	@ApiOperation(value = "Retorna pessoa por Id")
	@GetMapping(value="/{id}", produces = {"application/json", "application/xml", "application/x-yaml"})
	public PersonVO findById(@PathVariable("id") Long id) {
		PersonVO personVo = services.findById(id);
		personVo.add(linkTo(methodOn(PersonController.class).findById(id)).withSelfRel());
		return personVo;
	}
	
	@ApiOperation(value = "Retorna todas as pessoas")
	@GetMapping(produces = {"application/json", "application/xml", "application/x-yaml"})
	public List<PersonVO> findAll() {
		List<PersonVO> persons =  services.findAll();
		persons
			.stream()
			.forEach(p -> p.add(
					linkTo(methodOn(PersonController.class).findById(p.getKey())).withSelfRel()));
		return persons;
	}
	
	@ApiOperation(value = "Grava cadastro de pessoa")
	@PostMapping(produces = {"application/json", "application/xml", "application/x-yaml"}, 
			     consumes = {"application/json", "application/xml", "application/x-yaml"})
	public PersonVO create(@RequestBody PersonVO person) {
				PersonVO personVo =  services.create(person);
				personVo.add(linkTo(methodOn(PersonController.class).findById(personVo.getKey())).withSelfRel());
				return personVo;
	}
	
	@PostMapping("/v2")
	public PersonVOV2 createV2(@RequestBody PersonVOV2 person) {
			return services.createV2(person);
			
	}
	
	@ApiOperation(value = "Altera cadastro pessoa")
	@PutMapping(produces = {"application/json", "application/xml", "application/x-yaml"}, 
			     consumes = {"application/json", "application/xml", "application/x-yaml"})
	public PersonVO update(@RequestBody PersonVO person) {
		PersonVO personVo = services.update(person);
			personVo.add(linkTo(methodOn(PersonController.class).findById(person.getKey())).withSelfRel());
			return personVo;
	}
	
	@ApiOperation(value = "Apaga pessoa por Id")
 	@DeleteMapping(value="/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
 		services.delete(id);
		return ResponseEntity.ok().build();
	}
}
