package shiv.com.util;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.springframework.stereotype.Component;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import jakarta.servlet.http.HttpServletResponse;
import shiv.com.entity.CitizenPlan;

@Component
public class PdfGenerator {
	
	public void generatePdf(List<CitizenPlan> citizens, HttpServletResponse response, File file) {
		try {
			Document document = new Document(PageSize.A4); 
			PdfWriter.getInstance(document, response.getOutputStream());  
			PdfWriter.getInstance(document, new FileOutputStream(file));
			
			document.open();
			
			Font fontTiltle = FontFactory.getFont(FontFactory.TIMES_ROMAN);
		    fontTiltle.setSize(20);
			
			Paragraph paragraph= new Paragraph("Citizen Plan");
			paragraph.setAlignment(Paragraph.ALIGN_CENTER);
			document.add(paragraph);	
			
			PdfPTable table = new PdfPTable(9);
			
			table.setWidthPercentage(100f);
		    table.setSpacingBefore(5);
		    
			table.addCell("ID");
			table.addCell("Name");
			table.addCell("GENDER");
			table.addCell("PLAN_NAME");
			table.addCell("PLAN_STATUS");
			table.addCell("BENEFIT_AMOUNT");
			table.addCell("PLAN_START_DATE");
			table.addCell("PLAN_END_DATE");
			table.addCell("PLAN_DENIED_REASON");
			
		//	float[] columnWidths = {2f, 3f, 2f, 4f, 4f, 6f, 6f, 6f, 6f};
	   //     table.setWidths(columnWidths);
	        
			if(null != citizens && !citizens.isEmpty()) {
				citizens.forEach( obj -> {
					table.addCell(obj.getCitizenId().toString());
					table.addCell(obj.getCitizenName());
					table.addCell(obj.getGender());
					table.addCell(obj.getPlanName());
					table.addCell(obj.getPlanStatus());
					table.addCell(obj.getBenefitAmount().toString() != null ? obj.getBenefitAmount().toString(): "NA");
					table.addCell(obj.getStartDate().toString() != null ? obj.getStartDate().toString() : "NA");
					table.addCell(obj.getEndDate().toString() != null ? obj.getEndDate().toString() : "NA");
					table.addCell(obj.getDeniedReason() != null ? obj.getDeniedReason() : "NA");
					
				});
			}
			
			document.add(table);
			document.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
