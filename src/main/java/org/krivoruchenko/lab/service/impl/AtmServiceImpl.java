package main.java.org.krivoruchenko.lab.service.impl;

import main.java.org.krivoruchenko.lab.entity.BankAtm;
import main.java.org.krivoruchenko.lab.entity.BankOffice;
import main.java.org.krivoruchenko.lab.entity.Employee;
import main.java.org.krivoruchenko.lab.service.AtmService;

/**
 * Реализация интерфейса AtmService для работы с объектами BankAtm.
 */
public class AtmServiceImpl implements AtmService {
    /**
     * Создает новый объект BankAtm с заданными параметрами.
     *
     * @param id                Уникальный идентификатор банкомата.
     * @param name              Название банкомата.
     * @param status            Статус банкомата (1 - работает, 2 - нет денег, 0 - не работает).
     * @param bankOffice        Банковский офис, к которому привязан банкомат.
     * @param location          Местоположение банкомата.
     * @param servicingEmployee Сотрудник, обслуживающий банкомат.
     * @param cashWithdrawal    Возможность снятия наличных.
     * @param cashDeposit       Возможность внесения наличных.
     * @param maintenanceCost   Стоимость обслуживания банкомата.
     * @return                  Созданный объект класса {@link BankAtm}.
     */
    @Override
    public BankAtm create(int id, String name, int status, BankOffice bankOffice, String location, Employee servicingEmployee, boolean cashWithdrawal, boolean cashDeposit, double maintenanceCost) {
        BankAtm atm = new BankAtm();
        atm.setId(id);
        atm.setName(name);
        atm.setAddress(bankOffice.getAddress());
        switch (status) {
            case 1 -> {}            // работает
            case 2 -> {}            // нет денег
            default -> status = 0;  // не работает
        }
        atm.setStatus(status);
        atm.setBankOffice(bankOffice); // Для использования ID необходимы коллекции
        bankOffice.setQuantityAtms(bankOffice.getQuantityAtms() + 1);
        bankOffice.getBank().setQuantityATM(bankOffice.getBank().getQuantityATM() + 1);
        atm.setLocation(location);
        atm.setServicingEmployee(servicingEmployee); // Для использования ID необходимы коллекции
        atm.setCashWithdrawal(cashWithdrawal);
        atm.setCashDeposit(cashDeposit);
        atm.setTotalMoney(bankOffice.getBank().getTotalMoney());
        atm.setMaintenanceCost(maintenanceCost);
        return atm;
    }

    /**
     * Возвращает объект BankAtm.
     *
     * @param id    Уникальный идентификатор банкомата.
     * @return      Объект класса {@link BankAtm}.
     */
    @Override
    public BankAtm read(int id) {
        return null;
    }

    /**
     * Обновляет параметры существующего объекта BankAtm.
     *
     * @param id                Уникальный идентификатор банкомата.
     * @param name              Название банкомата.
     * @param status            Статус банкомата (1 - работает, 2 - нет денег, 0 - не работает).
     * @param bankOffice        Банковский офис, к которому привязан банкомат.
     * @param location          Местоположение банкомата.
     * @param servicingEmployee Сотрудник, обслуживающий банкомат.
     * @param cashWithdrawal    Возможность снятия наличных.
     * @param cashDeposit       Возможность внесения наличных.
     * @param maintenanceCost   Стоимость обслуживания банкомата.
     */
    @Override
    public void update(int id, String name, int status, BankOffice bankOffice, String location, Employee servicingEmployee, boolean cashWithdrawal, boolean cashDeposit, double maintenanceCost) {
        BankAtm atm = read(id);
    }

    /**
     * Удаляет объект BankAtm по указанному идентификатору.
     *
     * @param id Уникальный идентификатор банкомата.
     */
    @Override
    public void delete(int id) {

    }
}
