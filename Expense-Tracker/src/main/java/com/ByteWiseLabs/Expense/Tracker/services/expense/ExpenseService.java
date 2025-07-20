package com.ByteWiseLabs.Expense.Tracker.services.expense;

import com.ByteWiseLabs.Expense.Tracker.dto.ExpenseDTO;
import com.ByteWiseLabs.Expense.Tracker.entity.Expense;

import java.util.List;

public interface ExpenseService {
    Expense postExpense(ExpenseDTO expenseDTO);

    List<Expense> getAllExpenses();

    Expense getExpenseById(Long id);

    Expense updateExpense(Long id, ExpenseDTO expenseDTO);

    void deleteExpense(Long id);
}
