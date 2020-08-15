package com.cg.training.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cg.training.entity.Trainee;

@Repository
public interface TraineeDao extends JpaRepository<Trainee, Integer>{


}
