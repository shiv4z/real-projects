package shiv.com.util;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import shiv.com.entity.CitizenPlan;

@Component
public class ExcelGenerator {
	
	
	
	public void generateExcel(List<CitizenPlan> citizens, HttpServletResponse response, File file) {
		try {
	    	   Workbook workbook = new HSSFWorkbook();
	    	      Sheet sheet = workbook.createSheet("citizen-plan");
	    	      Row row = sheet.createRow(0);
	    	      
	    	      
	    	      row.createCell(0).setCellValue("ID");
	    	      row.createCell(1).setCellValue("NAME");
	    	      row.createCell(2).setCellValue("GENDER");
	    	      row.createCell(3).setCellValue("PLAN_NAME");
	    	      row.createCell(4).setCellValue("PLAN_STATUS");
	    	      row.createCell(5).setCellValue("BENEFIT_AMOUNT");
	    	      row.createCell(6).setCellValue("START_DATE");
	    	      row.createCell(7).setCellValue("END_DATE");
	    	      row.createCell(8).setCellValue("DENIAL_REASON");
	    	      

	    	      AtomicInteger rowIndex = new AtomicInteger(1);
	    	      if(null != citizens && !citizens.isEmpty()) {
	    	    	  citizens.forEach( citizen -> {
	    	    		  Row row2 = sheet.createRow(rowIndex.getAndIncrement());
	    	    		  row2.createCell(0).setCellValue(citizen.getCitizenId());
	    	    		  row2.createCell(1).setCellValue(citizen.getCitizenName());
	    	    		  row2.createCell(2).setCellValue(citizen.getGender());
	    	    		  row2.createCell(3).setCellValue(citizen.getPlanName());
	    	    		  row2.createCell(4).setCellValue(citizen.getPlanStatus());
	    	    		  if(null != citizen.getBenefitAmount()) {
	        	    		  row2.createCell(5).setCellValue(citizen.getBenefitAmount());
	    	    		  }else {
	        	    		  row2.createCell(5).setCellValue("NA");
	    	    		  }
	    	    		  
	    	    		  if(null != citizen.getStartDate()) {
	    	    			  row2.createCell(6).setCellValue(citizen.getStartDate().toString());
	    	    		  }else {
	    	    			  row2.createCell(6).setCellValue("NA");

	    	    		  }
	    	    		  if(null != citizen.getEndDate()) {
	        	    		  row2.createCell(7).setCellValue(citizen.getEndDate().toString());
	    	    		  }else {
	        	    		  row2.createCell(7).setCellValue("NA");
	    	    		  }
	    	    		  if(null != citizen.getDeniedReason()) {
	        	    		  row2.createCell(8).setCellValue(citizen.getDeniedReason());
	    	    		  }else {
	        	    		  row2.createCell(8).setCellValue("NA");
	 
	    	    		  }
	    	    	  });
	    	      }
	    	      FileOutputStream fileOutputStream = new FileOutputStream(file);
	    	      workbook.write(fileOutputStream);
	    	      fileOutputStream.close();
	    	      
	    	      ServletOutputStream outputStream = response.getOutputStream();
	    	      workbook.write(outputStream);
	    	      workbook.close();
	    	      
	      }catch(Exception e) {
	    	  e.printStackTrace();
	      }
	   
	}

}
