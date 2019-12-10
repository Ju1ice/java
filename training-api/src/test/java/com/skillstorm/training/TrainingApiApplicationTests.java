package com.skillstorm.training;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.jboss.logging.Logger;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.skillstorm.training.beans.Batch;
import com.skillstorm.training.data.BatchRepository;
import com.skillstorm.training.service.BatchService;

@SpringBootTest // creates a singleton ApplicationContext
@TestMethodOrder(OrderAnnotation.class)
class TrainingApiApplicationTests {
	
	@Autowired
	private ApplicationContext context;
	@Autowired
	private BatchService batchService;
	@Autowired
	private BatchRepository repository;
	
	// spring-boot-starter-web
	private static final Logger log = Logger.getLogger(TrainingApiApplicationTests.class);
	
	@Order(1)
	@Test
	@Transactional // always performs a rollback at the end of the test
	// maintain "transient state" in tests
	public void save() {
		log.info("save()");
		long batches = 5;
		Batch batch = new Batch();
		batch.setName("JAJAHAGAGAGAA");
		batch.setTrainer("Dan Pickles");
		batch.setStart(new Date());
		batch.setEnd(new Date());
		batchService.save(batch);
		assertEquals(++batches, repository.count());
	}
	
	@Order(2)
	@Test
	public void get() {
		log.info("get()");
		int batches = 5;
		assertEquals(batches, repository.findAll().size());
	}
	
}







