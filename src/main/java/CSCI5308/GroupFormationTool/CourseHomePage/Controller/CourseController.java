package CSCI5308.GroupFormationTool.CourseHomePage.Controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import CSCI5308.GroupFormationTool.SystemConfig;
import CSCI5308.GroupFormationTool.AdminPanel.Interface.ICoursePersistence;
import CSCI5308.GroupFormationTool.Courses.Course;
import CSCI5308.GroupFormationTool.Courses.Role;

@Controller
public class CourseController {
	private static final String ID = "id";

	@GetMapping("/course/course")
	public String course(Model model, @RequestParam(name = ID) long courseID,
			@RequestParam(name = "userID") long userID) {
		ICoursePersistence courseDB = SystemConfig.instance().getCourseDB();
		Course course = new Course();
		courseDB.loadCourseByID(courseID, course);
		model.addAttribute("course", course);
		model.addAttribute("userID", userID);
		List<Role> userRoles = course.getAllRolesForCurrentUserInCourse();
		if (null == userRoles) {
			// Default user is a guest.
			model.addAttribute("instructor", false);
			model.addAttribute("ta", false);
			model.addAttribute("student", false);
			model.addAttribute("guest", true);
		} else {
			model.addAttribute("instructor", userRoles.contains(Role.INSTRUCTOR));
			model.addAttribute("ta", userRoles.contains(Role.TA));
			model.addAttribute("student", userRoles.contains(Role.STUDENT));
			model.addAttribute("guest", userRoles.isEmpty());
		}
		return "course/course";
	}
}