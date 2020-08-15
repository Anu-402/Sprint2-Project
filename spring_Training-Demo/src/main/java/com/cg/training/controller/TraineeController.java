package com.cg.training.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.cg.training.entity.Trainee;
import com.cg.training.service.TraineeService;

@RestController
@CrossOrigin("*")
public class TraineeController {

	@Autowired
	TraineeService traineeservice;
	
	
	@GetMapping("trainee")
	public ResponseEntity<List<Trainee>>  findAllTrainees()
	{
	  List<Trainee> list=traineeservice.findAllTrainees();
	  ResponseEntity<List<Trainee>>  rt = new ResponseEntity<List<Trainee>>(list,HttpStatus.OK);
		return rt;
	}

	@DeleteMapping("trainee/{id}")
	public  ResponseEntity<Trainee>  deleteTraineeById(@PathVariable("id") int traineeId) throws Exception
	{
		
		Trainee  trainee = traineeservice.findTraineeById(traineeId);
		ResponseEntity<Trainee>  rt = null;
		
		if(trainee!=null)
		{
			trainee = traineeservice.deleteTraineeById(traineeId);
			rt= new ResponseEntity<Trainee>(trainee,HttpStatus.OK);
		}
		else
		{
			rt=new ResponseEntity<Trainee>(HttpStatus.NOT_FOUND);
		}
		return rt;
	}
	
	@PostMapping("trainee")
	public ResponseEntity<Trainee>  createTrainee(@RequestBody Trainee trainee)
	{
		   Trainee tr = traineeservice.addTrainee(trainee);
		   ResponseEntity<Trainee> rt= new ResponseEntity<Trainee>(trainee,HttpStatus.OK);
		   return rt;
	}
	@GetMapping("trainee/{id}")
	public  ResponseEntity<Trainee>  findTraineeById(@PathVariable("id") int traineeId) throws  Exception
	{
		
		Trainee  trainee = traineeservice.findTraineeById(traineeId);
		ResponseEntity<Trainee>  rt = null;
		
		if(trainee!=null)
		{
			rt= new ResponseEntity<Trainee>(trainee,HttpStatus.OK);
		}
		else
		{
			rt=new ResponseEntity<Trainee>(HttpStatus.NOT_FOUND);
		}
		return rt;
	}
}
