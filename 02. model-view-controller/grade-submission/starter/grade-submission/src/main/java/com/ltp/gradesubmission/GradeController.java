package com.ltp.gradesubmission;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class GradeController {

	List<Grade> studentGrades = new ArrayList<>();

	@GetMapping("/")
	public String redirectToForm() {
		System.out.println("\nempty endpoint ... redirecting to /form\n");
		return "redirect:/form";
	}

	@GetMapping("/grade")
	public String redirectToGrades() {
		return "redirect:/grades";
	}

	@GetMapping("/grades")
	public String getGrades(Model model) {
		model.addAttribute("grades", studentGrades);
		return "grades";
	}

	@GetMapping("/form")
	public String gradeForm(Model model, @RequestParam(required = false) String id) {
		int index = getGradeIndex(id);
		System.out.println(index);
		model.addAttribute(
			"grade", index == Constants.NOT_FOUND ? new Grade() : studentGrades.get(index));
		return "form";
	}

	@PostMapping("/handleSubmit")
	public String submitGrade(Grade grade) {
		int index = getGradeIndex(grade.getId());
		if (index == Constants.NOT_FOUND) {
			studentGrades.add(grade);
		} else {
			studentGrades.set(index, grade);
		}
		System.out.println(studentGrades);
		return "redirect:/grades";
	}
	
	public Integer getGradeIndex(String id) {
		System.out.println(studentGrades);
		System.out.println(id);
		for (int i = 0; i < studentGrades.size(); i++) {
			String chosenStudent = studentGrades.get(i).getId();
			if (chosenStudent.equals(id)) {
				return i;
			}
		}
		// could not find the student
		return Constants.NOT_FOUND;
	}

}