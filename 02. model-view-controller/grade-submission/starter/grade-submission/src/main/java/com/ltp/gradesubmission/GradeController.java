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
	public String gradeForm(Model model, @RequestParam(required = false) String student) {
		int index = getGradeIndex(student);
		model.addAttribute(
			"grade", index == -1000 ? new Grade() : studentGrades.get(index));
		return "form";
	}

	@PostMapping("/handleSubmit")
	public String submitGrade(Grade grade) {
		int index = getGradeIndex(grade.getStudent());
		if (index == -1000) {
			studentGrades.add(grade);
		} else {
			studentGrades.set(index, grade);
		}
		return "redirect:/grades";
	}
	
	public Integer getGradeIndex(String student) {
		for (int i = 0; i < studentGrades.size(); i++) {
			if (studentGrades.get(i).getStudent() == student) return i;
		}
		// could not find the student
		return -1000;
	}

}