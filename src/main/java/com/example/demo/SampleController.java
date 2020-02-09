package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sample")
public class SampleController {

	@GetMapping("hello")
	public String sampleHello(@RequestParam String arg) {

		if (arg == null) {
			return "nulldayo";
		}

		if (arg.equals("edogawakonan")) {
			return "tanteisa";
		}

		if (arg.equals("edogawakonan")) {
			return "tanteisa";
		}

		return "Hello";
	}

	@PostMapping("question")
	public SampleResponse sampleQuestion(@RequestBody SampleRequest req) {

		SampleResponse res = new SampleResponse();

		if (req.getQuestion().equals("shinnichi to kekkonnshitai") && req.getName().equals("ran")) {
			res.setAnswer("sounaruto iine");
			res.setIsBestAnswer(true);
		}

		if (req.getQuestion().equals("omae kudou shinichi dana")) {
			throw new SampleException("mazui!");
		}

		res.setAnswer("saate doukana");
		res.setIsBestAnswer(false);

		return res;
	}

}
