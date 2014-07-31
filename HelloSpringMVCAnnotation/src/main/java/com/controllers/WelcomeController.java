package com.controllers;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.models.WelcomeModel;

@Controller
@RequestMapping("/welcome")
public class WelcomeController {

	private WelcomeModel welcomeModel;

	@RequestMapping(method = RequestMethod.GET)
	public String printHello(ModelMap model) {

		model.addAttribute("message", welcomeModel.getWelcomeVariable1() + " "
				+ welcomeModel.getWelcomeVariable2());

		return "page";
	}

	@RequestMapping(value = "/{variable}", method = RequestMethod.GET)
	public String printVariable(@PathVariable String variable, ModelMap model) {

		model.addAttribute("message", "The path is ".concat(variable));

		return "page";
	}

	@RequestMapping(value = "/timestamped", method = RequestMethod.GET)
	public String printTimestamped(
			@RequestParam("startValidity") @DateTimeFormat(pattern = "yyyy-MM-dd'T'hh:mm:ss") Date startValidity,
			@RequestParam("endValidity") @DateTimeFormat(pattern = "yyyy-MM-dd'T'hh:mm:ss") Date endValidity, ModelMap model) {

		Timestamp ts = new Timestamp(startValidity.getTime());
		Timestamp ts1 = new Timestamp(endValidity.getTime());
		
		model.addAttribute("message", "Okay received timestamps");

		return "page";
	}

	public WelcomeModel getWelcomeModel() {
		return welcomeModel;
	}

	public void setWelcomeModel(WelcomeModel welcomeModel) {
		this.welcomeModel = welcomeModel;
	}

}
