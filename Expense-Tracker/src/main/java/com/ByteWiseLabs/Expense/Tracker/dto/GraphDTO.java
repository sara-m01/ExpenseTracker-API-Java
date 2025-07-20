package com.ByteWiseLabs.Expense.Tracker.dto;

import com.ByteWiseLabs.Expense.Tracker.entity.Expense;
import com.ByteWiseLabs.Expense.Tracker.entity.Income;
import lombok.Data;

import java.util.List;

@Data
public class GraphDTO {
    private List<Expense> expenseList;
    private List<Income> incomeList;
}
