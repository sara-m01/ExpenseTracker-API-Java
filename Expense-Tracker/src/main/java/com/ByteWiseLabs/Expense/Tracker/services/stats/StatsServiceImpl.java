package com.ByteWiseLabs.Expense.Tracker.services.stats;

import com.ByteWiseLabs.Expense.Tracker.dto.GraphDTO;
import com.ByteWiseLabs.Expense.Tracker.dto.statsDTO;
import com.ByteWiseLabs.Expense.Tracker.entity.Expense;
import com.ByteWiseLabs.Expense.Tracker.entity.Income;
import com.ByteWiseLabs.Expense.Tracker.repository.ExpenseRepository;
import com.ByteWiseLabs.Expense.Tracker.repository.IncomeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;


@Service
@RequiredArgsConstructor
public class StatsServiceImpl implements StatsService{
    private final IncomeRepository incomeRepository;

    private final ExpenseRepository expenseRepository;

    public GraphDTO getChartData(){
        LocalDate endDate = LocalDate.now();
        LocalDate startDate= endDate.minusDays(27);

        GraphDTO graphDTO= new GraphDTO();
        graphDTO.setExpenseList(expenseRepository.findByDateBetween(startDate,endDate));
        graphDTO.setIncomeList(incomeRepository.findByDateBetween(startDate,endDate));

        return graphDTO;
    }

    public statsDTO getStats(){
        Double totalIncome = incomeRepository.sumAllAmounts();
        Double totalExpense = expenseRepository.sumAllAmounts();

        Optional<Income> optionalIncome= incomeRepository.findFirstByOrderByDateDesc();
        Optional<Expense> optionalExpense= expenseRepository.findFirstByOrderByDateDesc();


        statsDTO StatsDTO= new statsDTO();
        StatsDTO.setExpense(totalExpense);
        StatsDTO.setIncome(totalIncome);

        optionalIncome.ifPresent( StatsDTO::setLatestIncome);
        optionalExpense.ifPresent(StatsDTO::setLatestExpense);

        StatsDTO.setBalance(totalIncome-totalExpense);

        List<Income> incomeList= incomeRepository.findAll();
        List<Expense> expenseList= expenseRepository.findAll();

        OptionalDouble minIncome = incomeList.stream().mapToDouble(Income::getAmount).min();
        OptionalDouble maxIncome = incomeList.stream().mapToDouble(Income::getAmount).max();

        OptionalDouble minExpense = expenseList.stream().mapToDouble(Expense::getAmount).min();
        OptionalDouble maxExpense = expenseList.stream().mapToDouble(Expense::getAmount).max();

        StatsDTO.setMaxExpense(maxExpense.isPresent() ? maxExpense.getAsDouble() : null);
        StatsDTO.setMinExpense(minExpense.isPresent() ? minExpense.getAsDouble() : null);

        StatsDTO.setMaxIncome(maxIncome.isPresent() ? maxIncome.getAsDouble() : null);
        StatsDTO.setMinIncome(minIncome.isPresent() ? minIncome.getAsDouble() : null);
        return StatsDTO;
    }
}
