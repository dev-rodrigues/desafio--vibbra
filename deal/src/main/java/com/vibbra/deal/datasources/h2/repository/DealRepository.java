package com.vibbra.deal.datasources.h2.repository;

import com.vibbra.deal.datasources.h2.data.DealData;
import com.vibbra.deal.datasources.h2.mapper.DealModelMapper;
import com.vibbra.deal.expections.DealNotLocalizedException;
import com.vibbra.deal.ports.DealPort;
import org.springframework.stereotype.Repository;
import com.vibbra.deal.entities.Deal;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class DealRepository implements DealPort {

    private final DealModelMapper mapper;
    private final DealData data;

    public DealRepository(DealData data) {
        this.mapper = DealModelMapper.INSTANCE;
        this.data = data;
    }

    @Override
    public Deal save(Deal deal) {
        var mapped = mapper.map(deal);
        var saved = data.save(mapped);
        return mapper.map(saved);
    }

    @Override
    public Optional<Deal> findBy(BigDecimal id) {
        var deal = data.findById(id).orElseThrow(() -> new DealNotLocalizedException("Deal not Localized"));
        var converted = mapper.map(deal);
        return Optional.of(converted);
    }

    @Override
    public List<Deal> findAll() {
        var deals = data.findAll();
        return deals.stream().map(mapper::map).collect(Collectors.toList());
    }
}
