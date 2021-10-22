package com.vibbra.deal.ports;

import com.vibbra.deal.entities.Deal;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface DealPort {
    Deal save(Deal deal);
    Optional<Deal> findBy(BigDecimal id);
    List<Deal> findAll();
}
