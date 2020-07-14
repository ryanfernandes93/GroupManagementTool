package CSCI5308.GroupFormationTool.Courses;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import CSCI5308.GroupFormationTool.SystemConfig;

@Controller
public class CourseController {
	private static final String ID = "id";

	@GetMapping("/course/course")
	public String course(Model model, @RequestParam(name = ID) long courseID,
			@RequestParam(name = "userID") long userID) {
		ICoursePersistence courseDB = SystemConfig.instance().getCourseDB();
		InterfaceCourse interfaceCourse = ObjectFactory.createObject(new CourseFactory());
		courseDB.loadCourseByID(courseID, interfaceCourse);
		model.addAttribute("course", interfaceCourse);
		model.addAttribute("userID", userID);
		List<Role> userRoles = interfaceCourse.getAllRolesForCurrentUserInCourse();
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
