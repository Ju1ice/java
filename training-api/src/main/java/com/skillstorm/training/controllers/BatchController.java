package com.skillstorm.training.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.training.beans.Batch;
import com.skillstorm.training.data.BatchRepository;
import com.skillstorm.training.service.BatchService;

@RestController
@RequestMapping(value = "/batches")
public class BatchController {
	
	private static final Logger log = Logger.getLogger(BatchController.class);

	@Autowired
	private BatchRepository repository; // proxy these calls thru the BatchService
	
	@Autowired
	private BatchService service;

	@PostMapping(value = "/batch", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@Transactional(propagation = Propagation.REQUIRES_NEW) // create a brand-new transaction
	public ResponseEntity<Batch> create(@Valid @RequestBody Batch batch) {
		// calling service.save() will propogate that TX forward
		return new ResponseEntity<Batch>(service.save(batch), HttpStatus.CREATED);
	}

	@GetMapping(value = "/batch/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Batch> findByIdJoinTrainees(@PathVariable int id, HttpSession session) {
		session.setAttribute("user", "Hello World");
		return new ResponseEntity<Batch>(repository.findByIdJoinTrainees(id), HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<Batch>> findAll(HttpSession session){
		log.info(session.getAttribute("user"));
		return new ResponseEntity<List<Batch>>(repository.findAll(), HttpStatus.OK);
	}
	
	@PutMapping(value = "/batch/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Batch> update(@Valid @RequestBody Batch batch, @PathVariable int id) {
		if(!repository.existsById(id) || batch.getId() == 0) {
			return new ResponseEntity<Batch>(HttpStatus.BAD_REQUEST); 
		}
		return new ResponseEntity<Batch>(repository.save(batch), HttpStatus.NO_CONTENT);
	}

}





