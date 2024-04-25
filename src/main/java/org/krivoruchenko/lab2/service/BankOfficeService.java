package org.krivoruchenko.lab2.service;

import org.krivoruchenko.lab2.entity.Bank;
import org.krivoruchenko.lab2.entity.BankOffice;

/**
 * Интерфейс, предоставляющий методы для управления банковскими офисами.
 *
 * <p>Этот интерфейс определяет операции CRUD (Create, Read, Update, Delete) для банковского офиса.</p>
 */
public interface BankOfficeService {
    /**
     * Создает новый банковский офис с указанными параметрами.
     *
     * @param id                Уникальный идентификатор офиса.
     * @param name              Название офиса.
     * @param bank              Банк, к которому принадлежит офис.
     * @param address           Адрес офиса.
     * @param status            Статус работы офиса (работает/не работает).
     * @param canPlaceAtm       Возможность установки банкомата в офисе.
     * @param canProvideCredit  Возможность предоставления кредитов.
     * @param cashWithdrawal    Возможность снятия наличных.
     * @param cashDeposit       Возможность внесения наличных.
     * @param rentCost          Стоимость аренды офиса.
     */
    void create(long id, String name, Bank bank, String address, boolean status, boolean canPlaceAtm, boolean canProvideCredit, boolean cashWithdrawal, boolean cashDeposit, double rentCost);

    /**
     * Возвращает информацию о текущем банковском офисе.
     *
     * @param id    Уникальный идентификатор офиса.
     * @return      Объект класса {@link BankOffice}.
     */
    BankOffice read(long id);

    /**
     * Обновляет информацию о существующем банковском офисе.
     *
     * @param id            Уникальный идентификатор офиса.
     * @param bankOffice    Объект класса {@link BankOffice}.
     */
    void update(long id, BankOffice bankOffice);

    /**
     * Удаляет банковский офис по его уникальному идентификатору.
     *
     * @param id Уникальный идентификатор офиса.
     */
    void delete(long id);
}
