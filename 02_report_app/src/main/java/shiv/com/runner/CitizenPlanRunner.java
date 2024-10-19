package shiv.com.runner;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import shiv.com.entity.CitizenPlan;
import shiv.com.repo.CitizenPlanRepo;

@Component
public class CitizenPlanRunner implements ApplicationRunner{
	
	@Autowired
	private CitizenPlanRepo citizenRepo;

	@Override
	public void run(ApplicationArguments args) throws Exception {
	
		CitizenPlan cz = new CitizenPlan();
		cz.setCitizenName("Charles");
		cz.setGender("Male");
		cz.setPlanStatus("Approved");
		cz.setStartDate(LocalDate.now());
		cz.setEndDate(LocalDate.now().plusMonths(6));
		cz.setBenefitAmount(1000.0);
		cz.setPlanName("Food");
		
		CitizenPlan cz1 = new CitizenPlan();
		cz1.setCitizenName("Ram");
		cz1.setGender("Male");
		cz1.setPlanStatus("Approved");
		cz1.setStartDate(LocalDate.now().plusYears(2));
		cz1.setEndDate(LocalDate.now().plusMonths(8));
		cz1.setBenefitAmount(4000.0);
		cz1.setPlanName("Cash");
		
		CitizenPlan cz2 = new CitizenPlan();
		cz2.setCitizenName("Catarina");
		cz2.setGender("Fe-Male");
		cz2.setPlanStatus("Pending");
		cz2.setStartDate(LocalDate.now());
		cz2.setEndDate(LocalDate.now().plusMonths(6));
		cz2.setBenefitAmount(2000.0);
		cz2.setPlanName("Food");
		
		CitizenPlan cz3 = new CitizenPlan();
		cz3.setCitizenName("Honey");
		cz3.setGender("Male");
		cz3.setPlanStatus("Denied");
		cz3.setStartDate(LocalDate.now());
		cz3.setEndDate(LocalDate.now().plusMonths(8));
		cz3.setBenefitAmount(4000.0);
		cz3.setPlanName("Cash");
		cz3.setDeniedReason("Employed in public sector.");
		
		CitizenPlan cz4 = new CitizenPlan();
		cz4.setCitizenName("David");
		cz4.setGender("Male");
		cz4.setPlanStatus("Approved");
		cz4.setStartDate(LocalDate.now().plusDays(180));
		cz4.setEndDate(LocalDate.now().plusMonths(10));
		cz4.setBenefitAmount(4000.0);
		cz4.setPlanName("Medical");
		
		CitizenPlan cz5 = new CitizenPlan();
		cz5.setCitizenName("Anil");
		cz5.setGender("Male");
		cz5.setPlanStatus("Denied");
		cz5.setStartDate(LocalDate.now().plusYears(2));
		cz5.setEndDate(LocalDate.now().plusMonths(8));
		cz5.setBenefitAmount(4000.0);
		cz5.setPlanName("Food");
		cz5.setDeniedReason("Employed into private sector");
		
		CitizenPlan cz6 = new CitizenPlan();
		cz6.setCitizenName("Rupali");
		cz6.setGender("Fe-Male");
		cz6.setPlanStatus("Approved");
		cz6.setStartDate(LocalDate.now());
		cz6.setEndDate(LocalDate.now().plusMonths(12));
		cz6.setBenefitAmount(2000.0);
		cz6.setPlanName("Food");
		
		CitizenPlan cz7 = new CitizenPlan();
		cz7.setCitizenName("Rashi");
		cz7.setGender("Fe-Male");
		cz7.setPlanStatus("Denied");
		cz7.setStartDate(LocalDate.now());
		cz7.setEndDate(LocalDate.now().plusMonths(5));
		cz7.setBenefitAmount(4000.0);
		cz7.setPlanName("Medical");
		cz7.setDeniedReason("Death");
		
		CitizenPlan cz8 = new CitizenPlan();
		cz8.setCitizenName("Bobby");
		cz8.setGender("Male");
		cz8.setPlanStatus("Denied");
		cz8.setStartDate(LocalDate.now().plusYears(1));
		cz8.setEndDate(LocalDate.now().plusMonths(6));
		cz8.setBenefitAmount(1000.0);
		cz8.setPlanName("Food");
		cz8.setDeniedReason("Employed into private sector");
		
		CitizenPlan cz9 = new CitizenPlan();
		cz9.setCitizenName("Kamla");
		cz9.setGender("Fe-Male");
		cz9.setPlanStatus("Approved");
		cz9.setStartDate(LocalDate.now().plusYears(2));
		cz9.setEndDate(LocalDate.now().plusMonths(8));
		cz9.setBenefitAmount(4000.0);
		cz9.setPlanName("Medical");
		
		CitizenPlan cz10 = new CitizenPlan();
		cz10.setCitizenName("Sneha");
		cz10.setGender("Fe-Male");
		cz10.setPlanStatus("Pending");
		cz10.setStartDate(LocalDate.now());
		cz10.setEndDate(LocalDate.now().plusMonths(6));
		cz10.setBenefitAmount(2000.0);
		cz10.setPlanName("Food");
		
		CitizenPlan cz11 = new CitizenPlan();
		cz11.setCitizenName("Pawan");
		cz11.setGender("Male");
		cz11.setPlanStatus("Denied");
		cz11.setStartDate(LocalDate.now());
		cz11.setEndDate(LocalDate.now().plusMonths(8));
		cz11.setBenefitAmount(5000.0);
		cz11.setPlanName("Cash");
		cz11.setDeniedReason("Employed in public sector.");
		
		CitizenPlan cz12 = new CitizenPlan();
		cz12.setCitizenName("Sachin");
		cz12.setGender("Male");
		cz12.setPlanStatus("Approved");
		cz12.setStartDate(LocalDate.now().plusDays(180));
		cz12.setEndDate(LocalDate.now().plusMonths(10));
		cz12.setBenefitAmount(4000.0);
		cz12.setPlanName("Medical");
		
		CitizenPlan cz13 = new CitizenPlan();
		cz13.setCitizenName("Sunita");
		cz13.setGender("Fe-Male");
		cz13.setPlanStatus("Denied");
		cz13.setStartDate(LocalDate.now().plusYears(2));
		cz13.setEndDate(LocalDate.now().plusMonths(8));
		cz13.setBenefitAmount(4000.0);
		cz13.setPlanName("Food");
		cz13.setDeniedReason("Employed into private sector");
		
		CitizenPlan cz14 = new CitizenPlan();
		cz14.setCitizenName("Sejal");
		cz14.setGender("Fe-Male");
		cz14.setPlanStatus("Approved");
		cz14.setStartDate(LocalDate.now());
		cz14.setEndDate(LocalDate.now().plusMonths(12));
		cz14.setBenefitAmount(2000.0);
		cz14.setPlanName("Food");
		
		CitizenPlan cz15 = new CitizenPlan();
		cz15.setCitizenName("Anuradha");
		cz15.setGender("Fe-Male");
		cz15.setPlanStatus("Approved");
		cz15.setStartDate(LocalDate.now());
		cz15.setEndDate(LocalDate.now().plusMonths(5));
		cz15.setBenefitAmount(4000.0);
		cz15.setPlanName("Cash");

		
		List<CitizenPlan> asList = Arrays.asList(cz, cz1,cz2, cz3, cz4, cz5,cz6, cz7,cz8, cz9, cz10, cz11,cz12, cz13,cz14, cz15);
		citizenRepo.deleteAll();
		citizenRepo.saveAll(asList);
		System.out.println("Records inserted successfully...");
	}

}
