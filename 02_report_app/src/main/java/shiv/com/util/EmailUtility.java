package shiv.com.util;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import jakarta.mail.internet.MimeMessage;

@Component
public class EmailUtility {

	@Autowired
	private JavaMailSender mailSender;

	@Async
	public void sendEmail(String subject, String body, String toAddress, File file) {
		try {
			MimeMessage mimeMessage = mailSender.createMimeMessage();

			MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
			mimeMessageHelper.setSubject(subject);
			mimeMessageHelper.setText(body, true);
			mimeMessageHelper.setTo(toAddress);
			mimeMessageHelper.addAttachment("citizen-paln", file);
			mailSender.send(mimeMessage);
			file.delete();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
