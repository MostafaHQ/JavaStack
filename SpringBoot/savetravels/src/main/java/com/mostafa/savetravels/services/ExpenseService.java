package com.mostafa.savetravels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.mostafa.savetravels.models.Expense;
import com.mostafa.savetravels.repositories.ExpenseRepository;

@Service
public class ExpenseService {
	
	private final ExpenseRepository expenseRepository;
	

	public ExpenseService(ExpenseRepository expenseRepository) {
		this.expenseRepository = expenseRepository;
	}
	
	public List<Expense> allExpense(){
		return expenseRepository.findAll();
	}

	public Expense createExpense(Expense expense) {
        return expenseRepository.save(expense);
}
	
	public Expense findExpense(Long id) {
		Optional<Expense> optionalExpense = expenseRepository.findById(id);
        if(optionalExpense.isPresent()) {
            return optionalExpense.get();
        } else {
            return null;
        }
    }
	
	public Expense updateExpense(Expense expense) {
    	return expenseRepository.save(expense);
    }
	
	public void delete(Long id) {
		expenseRepository.deleteById(id);
	}
	
	}