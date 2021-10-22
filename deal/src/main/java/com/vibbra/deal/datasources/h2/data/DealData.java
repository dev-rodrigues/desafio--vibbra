package com.vibbra.deal.datasources.h2.data;

import com.vibbra.deal.datasources.h2.model.DealModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;

public interface DealData extends JpaRepository<DealModel, BigDecimal> {
}
