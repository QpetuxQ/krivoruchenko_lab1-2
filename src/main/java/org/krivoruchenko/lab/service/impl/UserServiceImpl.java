package main.java.org.krivoruchenko.lab.service.impl;

import main.java.org.krivoruchenko.lab.entity.Bank;
import main.java.org.krivoruchenko.lab.entity.User;
import main.java.org.krivoruchenko.lab.service.UserService;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

/**
 * Реализация интерфейса UserService для управления информацией о клиентах банка.
 */
public class UserServiceImpl implements UserService {
    private static final Random RANDOM = new Random();

    /**
     * Создает нового клиента с заданными параметрами.
     *
     * @param id            Идентификатор клиента.
     * @param lastName      Фамилия клиента.
     * @param firstName     Имя клиента.
     * @param patronymic    Отчество клиента.
     * @param birthDate     Дата рождения клиента.
     * @param workplace     Место работы клиента.
     * @param usedBanksIds  Список банков, которыми пользуется клиент.
     * @return              Созданный объект класса {@link User}.
     */
    @Override
    public User create(int id, String lastName, String firstName, String patronymic, LocalDate birthDate, String workplace, List<Bank> usedBanksIds) {
        User user = new User();
        user.setId(id);
        user.setLastName(lastName);
        user.setFirstName(firstName);
        user.setPatronymic(patronymic);
        user.setBirthDate(birthDate);
        user.setWorkplace(workplace);
        double monthlyIncome = (double) (Math.round((RANDOM.nextDouble() * 10_000) * 100)) / 100;
        user.setMonthlyIncome(monthlyIncome);
        for (Bank bank : usedBanksIds) bank.setQuantityClients(bank.getQuantityClients() + 1);
        user.setUsedBanksIds(usedBanksIds);
        user.setCreditRating(getCreditRating(monthlyIncome));
        return user;
    }

    /**
     * Возвращает информацию о текущем клиенте.
     *
     * @param id    Идентификатор клиента.
     * @return      Объект класса {@link User}, представляющий клиента.
     */
    @Override
    public User read(int id) {
        return null;
    }

    /**
     * Обновляет информацию о клиенте.
     */
    @Override
    public void update() {

    }

    /**
     * Удаляет клиента по указанному идентификатору.
     *
     * @param id Идентификатор клиента для удаления.
     */
    @Override
    public void delete(int id) {

    }

    /**
     * Возвращает кредитный рейтинг клиента в зависимости от его ежемесячного дохода.
     *
     * @param monthlyIncome Ежемесячный доход клиента.
     * @return Кредитный рейтинг клиента.
     */
    private int getCreditRating(double monthlyIncome) {
        int creditRating = 100; // Минимальный рейтинг
        for (int i = 1_000; i <= 10_000; i += 1_000) {
            if (monthlyIncome < i) {
                creditRating += 100;
                break;
            } else creditRating += 100;
        }
        return Math.min(creditRating, 1000); // Ограничение максимального рейтинга
    }
}
