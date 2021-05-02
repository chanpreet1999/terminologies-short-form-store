package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Terminology;
import com.example.demo.service.interfaces.ITerminologyService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class TerminologyController {

	ITerminologyService terminologyService;

	@GetMapping(value = "getAllTerminologies")
	public String getAllTerminologies(ModelMap modelMap) {
		modelMap.put("terminologies", terminologyService.getAllTerminologies());
		return "show-terminologies-list";
	}

	@RequestMapping(value = "createTerminology", method = RequestMethod.GET)
	public String showCreateTerminologyPage(ModelMap modelMap) {
		modelMap.put("terminologyBean", new Terminology());
		return "create-terminology";
	}

	@RequestMapping(value = "createTerminology", method = RequestMethod.POST)
	public String createNewTerminology(Terminology terminologyBean, BindingResult result) {

		if (result.hasErrors()) {
			System.out.print(result.getErrorCount());
		}
		terminologyService.createNewTerminology(terminologyBean);
		return "redirect:/getAllTerminologies";
	}

	@RequestMapping(value = "updateTerminology", method = RequestMethod.GET)
	public String showUpdateTerminologyPage(@RequestParam Integer id, ModelMap modelMap) {
		Terminology terminologyBean = terminologyService.findById(id);
		modelMap.put("terminologyBean", terminologyBean);
		return "create-terminology";
	}

	@RequestMapping(value = "updateTerminology", method = RequestMethod.POST)
	public String updateTerminology(Terminology terminologyBean, BindingResult result) {
		terminologyService.updateTerminology(terminologyBean);
		return "redirect:/getAllTerminologies";
	}

	@RequestMapping(value = "deleteTerminology", method = RequestMethod.GET)
	public String deleteTerminology(@RequestParam("id") Integer id) {
		terminologyService.deleteById(id);
		return "redirect:/getAllTerminologies";
	}

	@RequestMapping(value = "searchTerminology", method = RequestMethod.GET)
	public String searchTerminology(@RequestParam("keyword") String searchKeyword, ModelMap modelMap) {

		searchKeyword = searchKeyword.trim();

		if (searchKeyword == null || searchKeyword == "")
			return "redirect:/getAllTerminologies";

		List<Terminology> matchingEntries = terminologyService.getSearchResult(searchKeyword);
		modelMap.put("terminologies", matchingEntries);
		return "show-terminologies-list";
	}
}
