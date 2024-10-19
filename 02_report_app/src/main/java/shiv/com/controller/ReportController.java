package shiv.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpServletResponse;
import shiv.com.model.SearchRequest;
import shiv.com.service.ReportService;

@Controller
public class ReportController {

	@Autowired
	private ReportService reportService;

	@GetMapping("/")
	public String loadIndex(Model model) {
		model.addAttribute("search", new SearchRequest());
		model.addAttribute("report", reportService.loadCitizenPlan(new SearchRequest()));
		init(model);
		return "index";
	}

	@PostMapping("/serachRequest")
	public String loadReportData(SearchRequest request, Model model) {
		model.addAttribute("report", reportService.loadCitizenPlan(request));
		model.addAttribute("search", request);
		init(model);
		return "index";
	}

	private void init(Model model) {
		model.addAttribute("planName", reportService.fetchPlanName());
		model.addAttribute("planStatus", reportService.fetchPlanStatus());
	}

	@GetMapping("/downloadExcel")
	public void downloadExcel(HttpServletResponse response) {
		response.setContentType("application/octet-stream");
		response.addHeader("Content-Disposition", "attachment; filename=\"plan.xls\"");

		reportService.downloadExcel(response);

	}
	
	@GetMapping("/downloadPdf")
	public void download(HttpServletResponse response) {
		response.setContentType("application/pdf");
		response.setHeader("content-Disposition", "attachment; filename=\"plan.pdf\"");
		reportService.downloadPdf(response);
	}
}
