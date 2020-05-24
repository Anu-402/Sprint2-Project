package com.cg.hcs.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.hcs.entity.HealthTest;

@Repository
public interface TestDao extends JpaRepository<HealthTest,Integer>{

	@Query(" FROM HealthTest where center.centerId=:id")
	public List<HealthTest>  findByCenterId(@Param("id") int id);
	
}