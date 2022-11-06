package com.mostafa.savetravels.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mostafa.savetravels.models.Expense;
import com.mostafa.savetravels.repositories.ExpenseRepository;

@Service
public class ExpenseService {
	
	private ExpenseRepository expenseRepository;
	

	public ExpenseService(ExpenseRepository expenseRepository) {
		this.expenseRepository = expenseRepository;
	}
	
	public List<Expense> allExpense(){
		return expenseRepository.findAll();
	}

	public Expense createExpense(Expense expense) {
        return expenseRepository.save(expense);
}

}