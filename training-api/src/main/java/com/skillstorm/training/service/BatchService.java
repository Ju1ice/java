package com.skillstorm.training.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.skillstorm.training.beans.Batch;
import com.skillstorm.training.beans.Trainee;
import com.skillstorm.training.data.BatchRepository;
import com.skillstorm.training.data.TraineeRepository;

@Service
public class BatchService {
	
	@Autowired
	private BatchRepository batchRepository;
	@Autowired
	private TraineeRepository traineeRepository;
	
	// @Around advice
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	// accept an incoming TX. if none, Create One
	public Batch save(Batch batch) {
		if(batch.getTrainees() == null || batch.getTrainees().isEmpty()) {
			return batchRepository.save(batch);
		}else {
			Batch result = batchRepository.save(batch);
			for(Trainee trainee : batch.getTrainees()) {
				traineeRepository.save(trainee);
			}
			return result;
		}
	}
}





