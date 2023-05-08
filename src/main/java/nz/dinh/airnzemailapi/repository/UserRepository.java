package nz.dinh.airnzemailapi.repository;

import nz.dinh.airnzemailapi.exception.UserNotFoundException;
import nz.dinh.airnzemailapi.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {

    List<User> users = new ArrayList<>();

    public UserRepository() {
        users.add(new User("147bffbd-f80b-47ff-8972-402b480d6467","James", "james@example.com"));
        users.add(new User("c05b9707-95aa-44a6-aabc-fc83ba12b747","Nik", "nik@example.com"));
        users.add(new User("cfb2fb65-74fe-4823-9953-2d4864647ea4","Anson", "anson@example.com"));
        users.add(new User("723904cc-b0ec-468c-9d25-0eb08ddc83ba","Neville", "neville@example.com"));
    }

    public List<User> findAll() {
        return users;
    }

    public User findById(String id) {
        return users.stream().filter(stream -> stream.id().equals(id))
                .findFirst()
                .orElseThrow(() -> new UserNotFoundException("User not found"));
    }

    public User create(User user) {
        users.add(user);
        return user;
    }

    public void update(User user, String id) {
        User existing = users.stream().filter(u -> u.id().equals(id))
                .findFirst()
                .orElseThrow(() -> new UserNotFoundException("User not found"));
        int i = users.indexOf(existing);
        users.set(i, user);
    }

    public void delete(String id)
    {
        users.removeIf(user -> user.id().equals(id));
    }
}
