package com.vibbra.ports;

import com.vibbra.entities.Message;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

public interface MessagePort {
    Message save(Message message);
    List<Message> messagesOfDeal(@NotNull BigDecimal idDeal);
    Message findBy(BigDecimal id);
}
