package com.skillstorm.training.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skillstorm.training.beans.Trainee;

@Repository
public interface TraineeRepository extends JpaRepository<Trainee, Integer> {

}
