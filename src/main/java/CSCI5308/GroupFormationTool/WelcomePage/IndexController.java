package CSCI5308.GroupFormationTool.WelcomePage;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import CSCI5308.GroupFormationTool.AccessControl.*;
import CSCI5308.GroupFormationTool.Courses.InterfaceCourse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import CSCI5308.GroupFormationTool.SystemConfig;
import CSCI5308.GroupFormationTool.Courses.ICoursePersistence;
import CSCI5308.GroupFormationTool.Courses.InterfaceCourse;

@Controller
public class IndexController {
	@GetMapping("/")
	public String greeting(Model model, HttpServletRequest httpServletRequest) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication.isAuthenticated()) {
			ICoursePersistence courseDB = SystemConfig.instance().getCourseDB();
			List<InterfaceCourse> allCourses = courseDB.loadAllCourses();
			model.addAttribute("courses", allCourses);
			IUserPersistence userDB = SystemConfig.instance().getUserDB();
			Long userID = userDB.loadInstructorByBannerID(httpServletRequest.getRemoteUser());
			if (userID != null && userID != 0) {
				model.addAttribute("questionbutton", "visible");
				model.addAttribute("userID", userID);
			} else {
				InterfaceUser u = UserObjectFactory.createObject(new UserFactory());
				userDB.loadUserByBannerID(httpServletRequest.getRemoteUser(),u);
				model.addAttribute("questionbutton", "hidden");
				model.addAttribute("userID", u.getID());
			}
		}
		return "index";
	}
}