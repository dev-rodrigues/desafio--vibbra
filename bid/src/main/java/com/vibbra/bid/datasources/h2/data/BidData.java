package com.vibbra.bid.datasources.h2.data;

import com.vibbra.bid.datasources.h2.model.BidModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface BidData extends JpaRepository<BidModel, BigDecimal> {
    BidModel findByIdDealAndId(BigDecimal idDeal, BigDecimal idBid);
    List<BidModel> findByIdDeal(BigDecimal idDeal);
}
