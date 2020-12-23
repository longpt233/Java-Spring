package com.company.spring.controller.image;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/image")
public class ImageController {
	
	@RequestMapping(value = "/{imageName}")
	@ResponseBody
	public byte[] getImage(@PathVariable(value = "imageName") String imageName) throws IOException {

	File serverFile = new File("product-photos/" + imageName);

	return Files.readAllBytes(serverFile.toPath());
	}
}

