package br.renato.emailService.consumer;

import br.renato.emailService.dto.EmailDTO;
import br.renato.emailService.entity.Email;
import br.renato.emailService.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmailConsumer {

	private final EmailService emailService;

	@RabbitListener(queues = "${spring.rabbitmq.queue}")
	public void listen(@Payload EmailDTO emailDTO) {
		Email email = new Email();
		BeanUtils.copyProperties(emailDTO, email);
		emailService.sendEmail(email);
		System.out.println("Email status: " + email.getEmailStatus().toString());
	}
}
