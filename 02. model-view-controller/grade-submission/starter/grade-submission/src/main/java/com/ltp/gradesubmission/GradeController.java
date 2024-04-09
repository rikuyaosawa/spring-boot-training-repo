package com.ltp.gradesubmission;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GradeController {

	ArrayList<Grade> studentGrades = new ArrayList<>();

	@GetMapping("/grades")
	public String getGrades(Model model) {
		studentGrades.add(new Grade("Hermionie", "Arithmancy", "A+"));
		studentGrades.add(new Grade("Rikuya", "Potions", "C+"));
		studentGrades.add(new Grade("Harry", "Potions", "C-"));
		model.addAttribute("grades", studentGrades);
		return "grades";
	}

}