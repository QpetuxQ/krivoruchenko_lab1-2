package org.krivoruchenko.lab2.service;

import org.krivoruchenko.lab2.entity.Bank;
import org.krivoruchenko.lab2.entity.BankOffice;
import org.krivoruchenko.lab2.entity.Employee;

import java.time.LocalDate;

/**
 * Интерфейс, предоставляющий методы для управления сотрудниками банка.
 *
 * <p>Этот интерфейс определяет операции CRUD (Create, Read, Update, Delete) для сотрудника банка.</p>
 */
public interface EmployeeService {
    /**
     * Создает нового сотрудника банка с указанными параметрами.
     *
     * @param id              Уникальный идентификатор сотрудника.
     * @param lastName        Фамилия сотрудника.
     * @param firstName       Имя сотрудника.
     * @param patronymic      Отчество сотрудника.
     * @param birthDate       Дата рождения сотрудника.
     * @param position        Должность сотрудника.
     * @param bank            Банк, в котором работает сотрудник.
     * @param bankOffice      Офис банка, в котором работает сотрудник.
     * @param worksInOffice   Работает ли сотрудник в офисе.
     * @param canIssueCredits Возможность выдачи кредитов сотрудником.
     * @param salary          Зарплата сотрудника.
     */
    void create(long id, String lastName, String firstName, String patronymic, LocalDate birthDate, String position, Bank bank, BankOffice bankOffice, boolean worksInOffice, boolean canIssueCredits, double salary);

    /**
     * Возвращает информацию о текущем сотруднике банка.
     *
     * @param id    Уникальный идентификатор сотрудника.
     * @return      Объект класса {@link Employee}.
     */
    Employee read(long id);

    /**
     * Обновляет информацию о существующем сотруднике банка.
     *
     * @param id        Уникальный идентификатор сотрудника.
     * @param employee  Объект класса {@link Employee}.
     */
    void update(long id, Employee employee);

    /**
     * Удаляет сотрудника банка по его уникальному идентификатору.
     *
     * @param id Уникальный идентификатор сотрудника.
     */
    void delete(long id);
}
