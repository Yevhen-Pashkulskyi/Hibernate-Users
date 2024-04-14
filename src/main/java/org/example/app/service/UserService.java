package org.example.app.service;

import org.example.app.entity.User;
import org.example.app.entity.UserMapper;
import org.example.app.exceptions.UserException;
import org.example.app.repository.impl.UserRepository;
import org.example.app.utils.UserValidator;
import org.example.app.utils.UsersConstant;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

public class UserService {

    UserRepository repository = new UserRepository();

    public String createUser(Map<String, String> data) {
        Map<String, String> errors =
                new UserValidator().validateContactData(data);
        if (!errors.isEmpty()) {
            try {
                throw new UserException("Check inputs", errors);
            } catch (UserException e) {
                return e.getErrors(errors);
            }
        }
        return repository.create(new UserMapper().mapContactData(data));
    }

    public String readUsers() {
        // Отримуємо дані
        Optional<List<User>> optional = repository.read();
        // Якщо Optional не містить null, формуємо виведення.
        // Інакше повідомлення про відсутність даних.
        if (optional.isPresent()) {
            // Отримуємо колекцію з Optional
            List<User> list = optional.get();
            // Якщо колекція не порожня, формуємо виведення.
            // Інакше повідомлення про відсутність даних.
            if (!list.isEmpty()) {
                AtomicInteger count = new AtomicInteger(0);
                StringBuilder stringBuilder = new StringBuilder();
                list.forEach((contact) ->
                        stringBuilder.append(count.incrementAndGet())
                                .append(") ")
                                .append(contact.toString())
                );
                return "\nUSERS:\n" + stringBuilder;
            } else return UsersConstant.DATA_ABSENT_MSG;
        } else return UsersConstant.DATA_ABSENT_MSG;
    }

    public String updateUser(Map<String, String> data) {
        Map<String, String> errors =
                new UserValidator().validateContactData(data);
        if (!errors.isEmpty()) {
            try {
                throw new UserException("Check inputs", errors);
            } catch (UserException e) {
                return e.getErrors(errors);
            }
        }
        return repository.update(new UserMapper().mapContactData(data));
    }

    public String deleteUser(Map<String, String> data) {
        Map<String, String> errors =
                new UserValidator().validateContactData(data);
        if (!errors.isEmpty()) {
            try {
                throw new UserException("Check inputs", errors);
            } catch (UserException e) {
                return e.getErrors(errors);
            }
        }
        return repository.delete(new UserMapper().mapContactData(data).getId());
    }

    public String readUserById(Map<String, String> data) {
        Map<String, String> errors =
                new UserValidator().validateContactData(data);
        if (!errors.isEmpty()) {
            try {
                throw new UserException("Check inputs", errors);
            } catch (UserException e) {
                return e.getErrors(errors);
            }
        }
        // Отримуємо дані
        Optional<User> optional =
                repository.readById(Long.parseLong(data.get("id")));
        // Якщо Optional не містить null, формуємо виведення.
        // Інакше повідомлення про відсутність даних.
        if (optional.isPresent()) {
            // Отримуємо об'єкт з Optional
            User user = optional.get();
            return "\nUSER: " + user + "\n";
        } else return UsersConstant.DATA_ABSENT_MSG;
    }
}
