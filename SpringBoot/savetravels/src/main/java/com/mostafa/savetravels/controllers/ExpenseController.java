package com.mostafa.savetravels.controllers;



import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.mostafa.savetravels.models.Expense;
import com.mostafa.savetravels.services.ExpenseService;

@Controller
public class ExpenseController {
	private final ExpenseService expenseService;
	
	
	public ExpenseController(ExpenseService expenseService) {
		this.expenseService = expenseService;
	}
	
	@GetMapping("/")
	public String home() {
		return "redirect:/expenses";
	}
	
	@GetMapping("/expenses")
    public String index(@ModelAttribute("expense") Expense expense,Model model) {
		model.addAttribute("expenses",expenseService.allExpense());
        return "index.jsp";
	}

	@PostMapping("/expenses")
	public String create(@Valid @ModelAttribute("expense") Expense expense, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("expenses",expenseService.allExpense());
			return "index.jsp";
		}else {
			expenseService.createExpense(expense);
			return "redirect:/expenses";
		}
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id")Long id, Model model) {
		Expense expense = expenseService.findExpense(id);
		model.addAttribute("expense", expense);
		return "edit.jsp";
	}
	
	@PutMapping("/edit/{id}")
	public String update(@PathVariable("id") Long id, Model model, @Valid @ModelAttribute("expense") Expense expense,BindingResult result) {
		
		if (result.hasErrors()) {
			return "edit.jsp";
		}else {
			expenseService.updateExpense(expense);
			return "redirect:/expenses";
		}
	}
	
	@GetMapping("/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		Expense expense = expenseService.findExpense(id);
		model.addAttribute("expense", expense);
		return "show.jsp";
	}
	
	@DeleteMapping("/{id}")
    public String deleteExpense(@PathVariable("id") Long id) {
		expenseService.delete(id);
        return "redirect:/";
    }
}
