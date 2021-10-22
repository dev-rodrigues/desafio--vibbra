package com.vibbra.interactors;

import com.vibbra.deal.transportLayers.openapi.model.MessageResponse;
import com.vibbra.ports.MessagePort;
import com.vibbra.transportlayers.mapper.MessageMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FindMessagesOfDealsUseCase {

    String token = "eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJ6ZFBzcVByd0JwQWhqNGl4aC1tanVsaFRyZENaRW44N2tERHZrWDB1dUlBIn0.eyJleHAiOjE2MzQ2MTA3MzksImlhdCI6MTYzNDYxMDQzOSwianRpIjoiYzU3NjEwODQtYjU3Yi00YWUzLWFkZmItYWI0MGE2ZjBjYTVhIiwiaXNzIjoiaHR0cDovL2xvY2FsaG9zdDo4MDgwL2F1dGgvcmVhbG1zL2NsaWVudGVzIiwiYXVkIjoiYWNjb3VudCIsInN1YiI6ImI1ZjBmMTg0LTk1OTEtNDg3OC1hMzA3LWM0YmYxNmEwNWFjMCIsInR5cCI6IkJlYXJlciIsImF6cCI6InRlc3RlIiwic2Vzc2lvbl9zdGF0ZSI6ImY3MjA2MTY1LTg5YTQtNDc2OS1hN2I0LWViMjc5OTVjZWExNiIsImFjciI6IjEiLCJyZWFsbV9hY2Nlc3MiOnsicm9sZXMiOlsib2ZmbGluZV9hY2Nlc3MiLCJ1bWFfYXV0aG9yaXphdGlvbiIsImRlZmF1bHQtcm9sZXMtY2xpZW50ZXMiXX0sInJlc291cmNlX2FjY2VzcyI6eyJhY2NvdW50Ijp7InJvbGVzIjpbIm1hbmFnZS1hY2NvdW50IiwibWFuYWdlLWFjY291bnQtbGlua3MiLCJ2aWV3LXByb2ZpbGUiXX19LCJzY29wZSI6ImVtYWlsIHVzZXIgcHJvZmlsZSIsInNpZCI6ImY3MjA2MTY1LTg5YTQtNDc2OS1hN2I0LWViMjc5OTVjZWExNiIsInppcENvZGUiOiIyMjIyMjIyMiIsImVtYWlsX3ZlcmlmaWVkIjpmYWxzZSwibmFtZSI6Im1pcmFuYSIsInByZWZlcnJlZF91c2VybmFtZSI6Im1pcmFuYSIsImdpdmVuX25hbWUiOiJtaXJhbmEiLCJlbWFpbCI6Im1pcmFuYUBlbWFpbC5jb20ifQ.U7mtq6Npl5xzcbAzlEJtrL6MWIAfpqZlg_oFI-wKhpadWMCNGwV1nkPuJPWCZL8FU9V5ojSPpVMNYe8qDlf_crBD7zyXkN3AbqTHPpM2GKZuqpgIHXBoL74ox7IpV8u_kKXqyzqlaXUkI9Rmz6pyWVgkLYvSIzaxitcD2SJyqpU1tDmKciSWGJPRO3jbbFFJseFZtbtzbPwHZjqFMEZdWvzFhurgokC37OJszzIqe7mSi5Tv70f1WVrfUEGrIH1cAtgaUTlmaTPXGJDbVVnEjkbq6SjK48sEKQDAE39odamk-8JME1mu0zdchBckbh_t1nJrwzgUhAeJ7WVurKul4g";
    private final MessageMapper mapper;
    private final CheckIfDealExistsUseCase checkIfDealExistsUseCase;
    private final MessagePort messagePort;

    public FindMessagesOfDealsUseCase(CheckIfDealExistsUseCase checkIfDealExistsUseCase, MessagePort messagePort) {
        this.mapper = MessageMapper.INSTANCE;
        this.checkIfDealExistsUseCase = checkIfDealExistsUseCase;
        this.messagePort = messagePort;
    }

    public List<MessageResponse> execute(BigDecimal deal) {

        var existeDeal = checkIfDealExistsUseCase.execute(deal, token);

        if (existeDeal) {
            var messages = messagePort.messagesOfDeal(deal);
            return messages.stream().map(mapper::mapper).collect(Collectors.toList());
        }

        throw new RuntimeException("Deal not exist");
    }
}
