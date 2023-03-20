package com.kosa.myapp.guestbook;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GuestbookController {

	@GetMapping("/guestbook")
	GuestbookDTO getView() {
		GuestbookDTO dto = new GuestbookDTO();
		dto.setId("1");
		dto.setTitle("2");
		dto.setWriter("3");
		dto.setContents("4");
		dto.setWdate("5");
		return dto;
	}
}
