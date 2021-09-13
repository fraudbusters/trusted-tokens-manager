package com.rbkmoney.trusted.tokens.utils;

import com.rbkmoney.damsel.domain.*;
import com.rbkmoney.damsel.fraudbusters.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TransactionUtils {

    public static final String TOKEN = "token";
    public static final String EXCEPTION_TOKEN = "exception_token";

    public static Payment createPayment() {
        return new Payment()
                .setEventTime(String.valueOf(LocalDateTime.now()))
                .setCost(new Cash()
                        .setCurrency(new CurrencyRef().setSymbolicCode("RUB"))
                        .setAmount(1000))
                .setPaymentTool(PaymentTool.bank_card(new BankCard().setToken(TOKEN)));
    }

    public static Withdrawal createWithdrawal() {
        return new Withdrawal()
                .setEventTime(String.valueOf(LocalDateTime.now()))
                .setCost(new Cash()
                        .setCurrency(new CurrencyRef().setSymbolicCode("RUB"))
                        .setAmount(1000))
                .setDestinationResource(Resource.bank_card(new BankCard().setToken(TOKEN)));
    }

    public static List<Payment> createPaymentList() {
        List<Payment> payment = new ArrayList<>();
        payment.add(new Payment()
                .setStatus(PaymentStatus.captured)
                .setEventTime(String.valueOf(LocalDateTime.now()))
                .setCost(new Cash()
                        .setCurrency(new CurrencyRef().setSymbolicCode("RUB"))
                        .setAmount(1000))
                .setPaymentTool(PaymentTool.bank_card(new BankCard().setToken(TOKEN))));
        payment.add(new Payment()
                .setStatus(PaymentStatus.captured)
                .setEventTime(String.valueOf(LocalDateTime.now()))
                .setCost(new Cash()
                        .setCurrency(new CurrencyRef().setSymbolicCode("RUB"))
                        .setAmount(1000))
                .setPaymentTool(PaymentTool.bank_card(new BankCard().setToken(EXCEPTION_TOKEN))));
        payment.add(new Payment()
                .setStatus(PaymentStatus.captured)
                .setEventTime(String.valueOf(LocalDateTime.now()))
                .setCost(new Cash()
                        .setCurrency(new CurrencyRef().setSymbolicCode("RUB"))
                        .setAmount(1000))
                .setPaymentTool(PaymentTool.bank_card(new BankCard().setToken(TOKEN))));
        return payment;
    }

}
