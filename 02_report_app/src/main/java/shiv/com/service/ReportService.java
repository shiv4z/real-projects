package shiv.com.service;

import java.util.List;

import jakarta.servlet.http.HttpServletResponse;
import shiv.com.entity.CitizenPlan;
import shiv.com.model.SearchRequest;

public interface ReportService {
	
	public List<String> fetchPlanName();;
	
	public List<String> fetchPlanStatus();
	
	public List<CitizenPlan> loadCitizenPlan(SearchRequest request);
	
	public Boolean downloadExcel(HttpServletResponse response);
	
	public Boolean downloadPdf(HttpServletResponse response);

	
	public Boolean exportExcel();
	
	public Boolean exportPdf();


}
