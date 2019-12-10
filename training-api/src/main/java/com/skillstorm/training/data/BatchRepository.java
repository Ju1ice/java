package com.skillstorm.training.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.skillstorm.training.beans.Batch;

@Repository
public interface BatchRepository extends JpaRepository<Batch, Integer>{

	@Query("select b from Batch b inner join b.trainees where b.id = ?1")
	public Batch findByIdJoinTrainees(int id);
	
}
