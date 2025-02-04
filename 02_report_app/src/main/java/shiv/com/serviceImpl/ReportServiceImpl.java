package shiv.com.serviceImpl;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpServletResponse;
import shiv.com.entity.CitizenPlan;
import shiv.com.model.SearchRequest;
import shiv.com.repo.CitizenPlanRepo;
import shiv.com.service.ReportService;
import shiv.com.util.EmailUtility;
import shiv.com.util.ExcelGenerator;
import shiv.com.util.PdfGenerator;

@Service
public class ReportServiceImpl implements ReportService{

	@Autowired
	private CitizenPlanRepo reportRepo;
	
	@Autowired
	private ExcelGenerator excelGenerator;
	
	@Autowired
	private PdfGenerator pdfGenerator;
	
	@Autowired
	private EmailUtility emailUtility;
	
	@Override
	public List<String> fetchPlanName() {
		return reportRepo.fetchPlanName();
	}

	@Override
	public List<String> fetchPlanStatus() {
		return reportRepo.fetchPlanStatus();
	}

	@Override
	public List<CitizenPlan> loadCitizenPlan(SearchRequest request) {
		CitizenPlan citizenPlan = new CitizenPlan();
		if(null != request.getPlanName() && "" != request.getPlanName()) {
			citizenPlan.setPlanName(request.getPlanName());
		}
		if(null != request.getPlanStatus() && "" != request.getPlanStatus()) {
			citizenPlan.setPlanStatus(request.getPlanStatus());
		}
		if(null != request.getGender() && "" != request.getGender()) {
			citizenPlan.setGender(request.getGender());
		}
		if(null != request.getStartDate()) {
			citizenPlan.setStartDate(request.getStartDate());
		}
		if(null != request.getEndDate()) {
			citizenPlan.setEndDate(request.getEndDate());
		}
			
		return reportRepo.findAll(Example.of(citizenPlan));
		
	}


	@Override
	public Boolean exportExcel() {
		return null;
	}

	@Override
	public Boolean exportPdf() {
		return null;
	}

	@Override
	public Boolean downloadExcel(HttpServletResponse response) {
      Boolean isDownloaded = Boolean.FALSE;
		 try {
			 File file = new File("plan.xls");
			 excelGenerator.generateExcel(reportRepo.findAll(), response, file);
			 String subject = "Find Requested Attachment";
			 String body = "<h3>Dear Shiv,</h3>"
			 		+ "<p>I hope this message finds you well. Please find the attached document as requested. Should you have any questions or need further assistance, feel free to reach out.</p>"
			 		+ "<p>Looking forward to your response.</p>"
			 		+ "<p>Best regards,</p>"
			 		+ "<p>Shiv Prasad</p>";
			 String toAddress = "eng.shivp1471@gmail.com";
			 emailUtility.sendEmail(subject, body, toAddress, file );
			 isDownloaded = Boolean.TRUE; 
		//	 file.delete();
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
      
		return isDownloaded;
	}

	@Override
	public Boolean downloadPdf(HttpServletResponse response) {
		Boolean isDownloaded = Boolean.FALSE;
		try {
			File file = new File("plan.pdf");
			pdfGenerator.generatePdf(reportRepo.findAll(), response, file);
			String subject = "Find Requested Attachment";
			 String body = "<h3>Dear Shiv,</h3>"
			 		+ "<p>I hope this message finds you well. Please find the attached document as requested. Should you have any questions or need further assistance, feel free to reach out.</p>"
			 		+ "<p>Looking forward to your response.</p>"
			 		+ "<p>Best regards,</p>"
			 		+ "<p>Shiv Prasad</p>";
			 String toAddress = "eng.shivp1471@gmail.com";
			emailUtility.sendEmail(subject, body, toAddress, file );
			isDownloaded = Boolean.TRUE; 
			//file.delete();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return isDownloaded;

	}
}
