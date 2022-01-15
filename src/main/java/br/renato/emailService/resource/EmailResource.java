package br.renato.emailService.resource;

import br.renato.emailService.dto.EmailDTO;
import br.renato.emailService.entity.Email;
import br.renato.emailService.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/email")
@RequiredArgsConstructor
public class EmailResource {

	private final EmailService emailService;

	@PostMapping("/send")
	public ResponseEntity<Email> sendEmail(@RequestBody @Valid final EmailDTO emailDTO) {
		Email email = new Email();
		BeanUtils.copyProperties(emailDTO, email);
		emailService.sendEmail(email);

		return new ResponseEntity<>(email, HttpStatus.CREATED);
	}
}