package org.krivoruchenko.lab2.service.impl;

import org.krivoruchenko.lab2.entity.Bank;
import org.krivoruchenko.lab2.entity.BankOffice;
import org.krivoruchenko.lab2.entity.Employee;
import org.krivoruchenko.lab2.service.EmployeeService;
import org.krivoruchenko.lab2.utils.EntityMaps;

import java.time.LocalDate;

/**
 * Реализация интерфейса EmployeeService для управления информацией о сотрудниках банка.
 */
public class EmployeeServiceImpl implements EmployeeService {
    @Override
    public void create(long id, String lastName, String firstName, String patronymic, LocalDate birthDate, String position, Bank bank, BankOffice bankOffice, boolean worksInOffice, boolean canIssueCredits, double salary) {
        if (read(id) == null) {
            Employee employee = new Employee();
            employee.setId(id);
            employee.setLastName(lastName);
            employee.setFirstName(firstName);
            employee.setPatronymic(patronymic);
            employee.setBirthDate(birthDate);
            employee.setPosition(position);
            employee.setBank(bank);
            employee.setBankOffice(bankOffice);
            employee.setWorksInOffice(worksInOffice);
            employee.setCanIssueCredits(canIssueCredits);
            employee.setSalary(salary);

            bank.getEmployeeMap().put(id, employee);
        }
    }

    @Override
    public Employee read(long id) {
        Employee employee = null;
        for (Bank bank : EntityMaps.bankMap.values()) {
            if (bank.getEmployeeMap().containsKey(id)){
                employee = bank.getEmployeeMap().get(id);
                break;
            }
        }
        return employee;
    }

    @Override
    public void update(long id, Employee employee) {
        if (read(id) != null && employee != null) {
            employee.getBank().getEmployeeMap().replace(id, employee);
        }
    }

    @Override
    public void delete(long id) {
        Employee employee = read(id);
        if (employee != null) {
            employee.getBank().getEmployeeMap().remove(id);
        }
    }
}
