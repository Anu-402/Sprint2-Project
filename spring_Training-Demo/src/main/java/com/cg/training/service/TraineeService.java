package com.cg.training.service;

import java.util.List;

import com.cg.training.entity.Trainee;
import com.cg.training.exception.TraineeException;

public interface TraineeService {
	
	public  Trainee  addTrainee(Trainee trainee);
	public  Trainee  deleteTraineeById(int traineeId);
	public  List<Trainee>findAllTrainees();
	public  Trainee findTraineeById(int traineeId) throws TraineeException ;
}