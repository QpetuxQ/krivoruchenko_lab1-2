package main.java.org.krivoruchenko.lab.service;

import org.krivoruchenko.lab.entity.*;

import java.time.LocalDate;

/**
 * Интерфейс, предоставляющий методы для управления кредитными счетами.
 *
 * <p>Этот интерфейс определяет операции CRUD (Create, Read, Update, Delete) для кредитного счета.</p>
 */
public interface CreditAccountService {
    /**
     * Создает новый кредитный счет с указанными параметрами.
     *
     * @param id              Уникальный идентификатор кредитного счета.
     * @param user            Пользователь, за которым закреплен кредитный счет.
     * @param bank            Банк, в котором открыт кредитный счет.
     * @param startDate       Дата начала кредита.
     * @param months          Количество месяцев, на которые взят кредит.
     * @param loanAmount      Сумма кредита.
     * @param interestRate    Процентная ставка кредита.
     * @param issuingEmployee Сотрудник, который выдал кредит.
     * @param paymentAccount  Платежный счет для погашения кредита.
     * @return                Созданный объект класса {@link CreditAccount}.
     */
    CreditAccount create(int id, User user, Bank bank, LocalDate startDate, int months, double loanAmount, double interestRate, Employee issuingEmployee, PaymentAccount paymentAccount);

    /**
     * Возвращает информацию о текущем кредитном счете.
     *
     * @param id    Уникальный идентификатор кредитного счета.
     * @return      Объект класса {@link CreditAccount}.
     */
    CreditAccount read(int id);

    /**
     * Обновляет информацию о существующем кредитном счете.
     */
    void update();

    /**
     * Удаляет кредитный счет по его уникальному идентификатору.
     *
     * @param id Уникальный идентификатор кредитного счета.
     */
    void delete(int id);
}
