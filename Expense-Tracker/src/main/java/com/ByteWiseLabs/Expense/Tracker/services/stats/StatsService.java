package com.ByteWiseLabs.Expense.Tracker.services.stats;

import com.ByteWiseLabs.Expense.Tracker.dto.GraphDTO;
import com.ByteWiseLabs.Expense.Tracker.dto.statsDTO;

public interface StatsService {
    GraphDTO getChartData();

    statsDTO getStats();
}
