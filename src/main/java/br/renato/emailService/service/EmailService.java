package br.renato.emailService.service;

import br.renato.emailService.entity.Email;
import br.renato.emailService.entity.enums.EmailStatus;
import br.renato.emailService.repository.EmailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class EmailService {

	private final EmailRepository emailRepository;
	private final JavaMailSender mailSender;

	public void sendEmail(final Email email) {
		email.setSentDate(LocalDateTime.now());
		try {
			SimpleMailMessage message = new SimpleMailMessage();
			message.setFrom(email.getEmailFrom());
			message.setTo(email.getEmailTo());
			message.setSubject(email.getSubject());
			message.setText(email.getText());
			mailSender.send(message);

			email.setEmailStatus(EmailStatus.SENT);
		} catch (MailException e) {
			email.setEmailStatus(EmailStatus.ERROR);
		}
		emailRepository.save(email);
	}
}

