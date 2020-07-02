package CSCI5308.GroupFormationTool.QuestionManager.Controller;

import java.security.Principal;
import java.util.Map;

import CSCI5308.GroupFormationTool.QuestionManager.Interface.InterfaceSorters;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import CSCI5308.GroupFormationTool.SystemConfig;
import CSCI5308.GroupFormationTool.QuestionManager.Interface.IQuestionSorters;
import CSCI5308.GroupFormationTool.QuestionManager.Interface.IQuestionsPersistence;
import CSCI5308.GroupFormationTool.QuestionManager.Model.Sorters;

@Controller
public class ListQuestionsController {
	IQuestionsPersistence questionDb = SystemConfig.instance().getQuestionDB();
	IQuestionSorters sortersDB = SystemConfig.instance().getSortersDB();
	InterfaceSorters interfaceSorters = new Sorters();
	Map<String, String> sortingFields = interfaceSorters.sortingFieldList();
	Map<String, String> sortingOrders = interfaceSorters.sortingOrderList();
	String bannerID;
	private long userID;

	@RequestMapping(value = "/listquestions", method = RequestMethod.GET)
	public String showQuestions(ModelMap model, Principal principal,@RequestParam(name = "userID") long userID) {
		this.userID = userID;
		setModelForSorting(model);
		bannerID = principal.getName();
		model.addAttribute("questions", questionDb.loadAllQuestionsByID(bannerID));
		return "QuestionManager/listquestions";
	}

	@RequestMapping(value = "/listquestions", method = RequestMethod.POST, params = "action=sort")
	public ModelAndView performSort(@ModelAttribute("sorters") Sorters sorters, BindingResult result, ModelMap model) {
		this.interfaceSorters=sorters;
		setModelForSorting(model);
		model.addAttribute("questions", sortersDB.sort(bannerID, interfaceSorters));
		model.addAttribute("message", "Table is sorted by " + sortingFields.get(interfaceSorters.getSortField()) + " in "
				+ sortingOrders.get(interfaceSorters.getSortOrder()) + " Order");
		return new ModelAndView("QuestionManager/listquestions", model);
	}

	@RequestMapping(value = "/listquestions", method = RequestMethod.POST, params = "action=clearSort")
	public ModelAndView performClearSort(@ModelAttribute("sorters") Sorters sorters, BindingResult result,
										 ModelMap model) {
		setModelForSorting(model);
		model.addAttribute("questions", sortersDB.clearSort(bannerID));
		return new ModelAndView("QuestionManager/listquestions", model);
	}

	public void setModelForSorting(ModelMap model) {
		model.addAttribute("userID",this.userID);
		model.addAttribute("sorters", interfaceSorters);
		model.addAttribute("sortingFields", sortingFields);
		model.addAttribute("sortingOrders", sortingOrders);
	}
}
