package main.java.org.krivoruchenko.lab.service;

import main.java.org.krivoruchenko.lab.entity.Bank;
import main.java.org.krivoruchenko.lab.entity.User;

import java.time.LocalDate;
import java.util.List;

/**
 * Интерфейс, предоставляющий методы для управления информацией о клиентах банка.
 *
 * <p>Этот интерфейс определяет операции CRUD (Create, Read, Update, Delete) для клиента банка.</p>
 */
public interface UserService {
    /**
     * Создает нового клиента банка с указанными параметрами.
     *
     * @param id                Уникальный идентификатор клиента банка.
     * @param lastName          Фамилия клиента.
     * @param firstName         Имя клиента.
     * @param patronymic        Отчество клиента.
     * @param birthDate         Дата рождения клиента.
     * @param workplace         Место работы клиента.
     * @param usedBanksIds      Список банков, которыми пользуется клиент.
     * @return                  Созданный объект класса {@link User}.
     */
    User create(int id, String lastName, String firstName, String patronymic, LocalDate birthDate, String workplace, List<Bank> usedBanksIds);

    /**
     * Возвращает информацию о текущем клиенте банка.
     *
     * @param id    Уникальный идентификатор клиента банка.
     * @return      Объект класса {@link User}.
     */
    User read(int id);

    /**
     * Обновляет информацию о существующем клиенте банка.
     */
    void update();

    /**
     * Удаляет клиента банка по его уникальному идентификатору.
     *
     * @param id Уникальный идентификатор клиента банка.
     */
    void delete(int id);
}
