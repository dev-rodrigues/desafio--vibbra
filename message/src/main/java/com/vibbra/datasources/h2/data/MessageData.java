package com.vibbra.datasources.h2.data;

import com.vibbra.datasources.h2.model.MessageModel;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

public interface MessageData extends JpaRepository<MessageModel, BigDecimal> {

    List<MessageModel> findAllByIdDeal(@NotNull BigDecimal idDeal);
}
