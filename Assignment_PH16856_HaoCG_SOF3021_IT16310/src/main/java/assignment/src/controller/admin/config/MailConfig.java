package assignment.src.controller.admin.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import assignment.src.common.CommonConst;

@Configuration
public class MailConfig {
	@Bean
	public JavaMailSender getJavaMailSender() {
		//set host and port
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setHost("smtp.gmail.com");
		mailSender.setPort(587);
		
		// Tk 
		mailSender.setUsername(CommonConst.MY_EMAIL);
		mailSender.setPassword(CommonConst.MY_PASSWORD);
		
		//Config
		Properties props = mailSender.getJavaMailProperties();
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");
        
        //return sender
        return mailSender;
	}
}
