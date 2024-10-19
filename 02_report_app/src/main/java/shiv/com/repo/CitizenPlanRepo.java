package shiv.com.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import shiv.com.entity.CitizenPlan;

public interface CitizenPlanRepo extends JpaRepository<CitizenPlan, Integer>{
	
	@Query(value ="select distinct(planName) from CitizenPlan order by planName")
	public List<String> fetchPlanName();
	
	@Query(value ="select distinct(planStatus) from CitizenPlan order by planStatus")
	public List<String> fetchPlanStatus();

}
