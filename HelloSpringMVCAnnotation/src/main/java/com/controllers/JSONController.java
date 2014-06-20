package com.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.entities.Potato;

@Controller
@RequestMapping("/jsons")
public class JSONController {

	@RequestMapping(value = "/{size}/{color}", method = RequestMethod.GET)
	public @ResponseBody
	Potato printPotato(@PathVariable String size, @PathVariable String color) {

		Potato potato = new Potato();
		potato.setCarbs(12);
		potato.setColor(color);
		potato.setSize(size);

		return potato;
	}

	@RequestMapping(value = "/query")
	public @ResponseBody
	Potato printPotato2(@RequestParam(value = "color") String color,
			@RequestParam(value = "size") String size) {

		Potato potato = new Potato();
		potato.setCarbs(50);
		potato.setColor(color);
		potato.setSize(size);

		return potato;
	}
}
