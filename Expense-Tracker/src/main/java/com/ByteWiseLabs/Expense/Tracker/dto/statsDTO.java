package com.ByteWiseLabs.Expense.Tracker.dto;

import com.ByteWiseLabs.Expense.Tracker.entity.Expense;
import com.ByteWiseLabs.Expense.Tracker.entity.Income;
import lombok.Data;

import java.io.DataInput;

@Data
public class statsDTO {
    private Double income;
    private Double expense;
    private Income latestIncome;
    private Expense latestExpense;
    private Double balance;
    private Double minIncome;
    private Double maxIncome;
    private Double minExpense;
    private Double maxExpense;
}
