package com.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.entities.LeXmlElement;

@Controller
@RequestMapping("/xmls")
public class XMLController {

	// the controller methods for xml and json looks the same
	// just that an entity to be converted to xml needs to have @Xml.....
	// annotations, jaxb is also used

	@RequestMapping(value = "/path/{name}/{quantity}")
	public @ResponseBody
	LeXmlElement printXmlPath(@PathVariable String name,
			@PathVariable int quantity) {

		LeXmlElement lxe = new LeXmlElement();
		lxe.setName(name);
		lxe.setQuantity(quantity);

		return lxe;

	}

	@RequestMapping(value = "/query")
	public @ResponseBody
	LeXmlElement printXmlQuery(@RequestParam(value = "name") String name,
			@RequestParam(value = "quantity") int quantity) {

		LeXmlElement lxe = new LeXmlElement();
		lxe.setName(name);
		lxe.setQuantity(quantity);

		return lxe;

	}

}
