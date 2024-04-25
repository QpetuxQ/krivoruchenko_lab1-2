package org.krivoruchenko.lab2.service.impl;

import org.krivoruchenko.lab2.entity.Bank;
import org.krivoruchenko.lab2.entity.PaymentAccount;
import org.krivoruchenko.lab2.entity.User;
import org.krivoruchenko.lab2.service.PaymentAccountService;
import org.krivoruchenko.lab2.utils.EntityMaps;

/**
 * Реализация интерфейса PaymentAccountService для управления информацией о платежных счетах пользователей банка.
 */
public class PaymentAccountServiceImpl implements PaymentAccountService {

    @Override
    public void create(long id, User user, Bank bank, double balance) {
        if (read(id) == null) {
            PaymentAccount paymentAccount = new PaymentAccount();
            paymentAccount.setId(id);
            paymentAccount.setUser(user);
            paymentAccount.setBank(bank);
            paymentAccount.setBalance(balance);
            user.getPaymentAccounts().put(id, paymentAccount);
        }
    }

    @Override
    public PaymentAccount read(long id) {
        PaymentAccount paymentAccount = null;
        for (Bank bank : EntityMaps.bankMap.values()){
            for (User user : bank.getUserMap().values()){
                if (user.getPaymentAccounts().containsKey(id)){
                    paymentAccount = user.getPaymentAccounts().get(id);
                    break;
                }
            }
            if (paymentAccount != null) break;
        }
        return paymentAccount;
    }

    @Override
    public void update(long id, PaymentAccount paymentAccount) {
        if (read(id) != null && paymentAccount != null) paymentAccount.getUser().getPaymentAccounts().replace(id, paymentAccount);
    }

    @Override
    public void delete(long id) {
        PaymentAccount paymentAccount = read(id);
        if (paymentAccount != null) paymentAccount.getUser().getPaymentAccounts().remove(id);
    }
}
