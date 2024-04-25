package main.java.org.krivoruchenko.lab.service;

import main.java.org.krivoruchenko.lab.entity.Bank;
import main.java.org.krivoruchenko.lab.entity.BankOffice;
import main.java.org.krivoruchenko.lab.entity.Employee;

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
     * @return                Созданный объект класса {@link Employee}.
     */
    Employee create(int id, String lastName, String firstName, String patronymic, LocalDate birthDate, String position, Bank bank, BankOffice bankOffice, boolean worksInOffice, boolean canIssueCredits, double salary);

    /**
     * Возвращает информацию о текущем сотруднике банка.
     *
     * @param id    Уникальный идентификатор сотрудника.
     * @return      Объект класса {@link Employee}.
     */
    Employee read(int id);

    /**
     * Обновляет информацию о существующем сотруднике банка.
     */
    void update();

    /**
     * Удаляет сотрудника банка по его уникальному идентификатору.
     *
     * @param id Уникальный идентификатор сотрудника.
     */
    void delete(int id);
}
