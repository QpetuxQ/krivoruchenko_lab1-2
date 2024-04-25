package org.krivoruchenko.lab2.service;

import org.krivoruchenko.lab2.entity.BankAtm;
import org.krivoruchenko.lab2.entity.BankOffice;
import org.krivoruchenko.lab2.entity.Employee;

/**
 * Интерфейс {@link AtmService} предоставляет методы для управления объектами {@link BankAtm}.
 */
public interface AtmService {
    /**
     * Создает новый объект {@link BankAtm} с предоставленными атрибутами.
     *
     * @param id                Уникальный идентификатор банкомата.
     * @param name              Название банкомата.
     * @param status            Статус банкомата (1 - работает, 2 - отсутствует деньги, 0 - не работает).
     * @param bankOffice        Офис банка, к которому привязан банкомат.
     * @param location          Местоположение банкомата.
     * @param servicingEmployee Сотрудник, ответственный за обслуживание банкомата.
     * @param cashWithdrawal    Указывает, поддерживает ли банкомат снятие наличных.
     * @param cashDeposit       Указывает, поддерживает ли банкомат внесение наличных.
     * @param maintenanceCost   Стоимость обслуживания банкомата.
     */
    void create(long id, String name, int status, BankOffice bankOffice, String location, Employee servicingEmployee, boolean cashWithdrawal, boolean cashDeposit, double maintenanceCost);

    /**
     * Получает объект класса {@link BankAtm}.
     *
     * @param id    Уникальный идентификатор банкомата.
     * @return      Объект класса {@link BankAtm}.
     */
    BankAtm read(long id);

    /**
     * Обновляет существующий объект {@link BankAtm} с предоставленными атрибутами.
     *
     * @param id        Уникальный идентификатор банкомата.
     * @param bankAtm   Объект класса {@link BankAtm}.
     */
    void update(long id, BankAtm bankAtm);

    /**
     * Удаляет объект {@link BankAtm} с указанным идентификатором.
     *
     * @param id Уникальный идентификатор банкомата для удаления.
     */
    void delete(long id);
}
