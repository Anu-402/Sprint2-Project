package com.cg.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.training.dao.TraineeDao;
import com.cg.training.entity.Trainee;
import com.cg.training.exception.TraineeException;


@Service
public class TraineeServiceImpl implements TraineeService {

	@Autowired
	TraineeDao traineedao;
	
	@Override
	public Trainee addTrainee(Trainee trainee) {
		traineedao.saveAndFlush(trainee);
		return trainee;
	}

	@Override
	public Trainee deleteTraineeById(int traineeId) {
		Trainee tr=null;
		if(traineedao.existsById(traineeId))
		{
			tr=traineedao.findById(traineeId).get();
			traineedao.deleteById(traineeId);
		}
		return tr;
	}

	

	@Override
	public Trainee findTraineeById(int traineeId) throws TraineeException {
	
		Trainee tr = null;
		if(traineedao.existsById(traineeId))
		{
			tr=traineedao.findById(traineeId).get();
		}
		else
		{
			throw new TraineeException(traineeId+ " ID NOT FOUND ");
		}
		return tr;
	}

	@Override
	public List<Trainee> findAllTrainees() {
		List<Trainee> list=traineedao.findAll();
		return list;
	}

}
