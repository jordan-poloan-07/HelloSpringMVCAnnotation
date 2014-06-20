package com.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

	public WelcomeModel getWelcomeModel() {
		return welcomeModel;
	}

	public void setWelcomeModel(WelcomeModel welcomeModel) {
		this.welcomeModel = welcomeModel;
	}

}
