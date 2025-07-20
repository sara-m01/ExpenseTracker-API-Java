package com.ByteWiseLabs.Expense.Tracker.services.income;

import com.ByteWiseLabs.Expense.Tracker.dto.IncomeDTO;
import com.ByteWiseLabs.Expense.Tracker.entity.Income;

import java.util.List;


public interface IncomeService {
    Income postIncome(IncomeDTO incomeDTO);

    List<Income> getAllIncomes();

    Income getIncomeById(Long id);

    Income updateIncome(Long id, IncomeDTO incomeDTO);

    void deleteIncome(Long id);
}

