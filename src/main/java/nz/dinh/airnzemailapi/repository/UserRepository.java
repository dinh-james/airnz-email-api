package nz.dinh.airnzemailapi.repository;

import nz.dinh.airnzemailapi.exception.UserNotFoundException;
import nz.dinh.airnzemailapi.model.AppUser;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {

    List<AppUser> appUsers = new ArrayList<>();

    public UserRepository() {
        appUsers.add(new AppUser("147bffbd-f80b-47ff-8972-402b480d6467", "james@example.com", "james", "password"));
        appUsers.add(new AppUser("c05b9707-95aa-44a6-aabc-fc83ba12b747", "nik@example.com", "nik", "password"));
        appUsers.add(new AppUser("cfb2fb65-74fe-4823-9953-2d4864647ea4", "anson@example.com", "anson", "password"));
        appUsers.add(new AppUser("723904cc-b0ec-468c-9d25-0eb08ddc83ba", "neville@example.com", "neville", "password"));
    }

    public List<AppUser> findAll() {
        return appUsers;
    }

    public Optional<AppUser> findById(String id) {
        return appUsers.stream().filter(stream -> stream.getId().equals(id)).findFirst();
    }

    public Optional<AppUser> findByUsername(String username) {
        return appUsers.stream().filter(stream -> stream.getUsername().equals(username)).findFirst();
    }

    public AppUser create(AppUser appUser) {
        appUsers.add(appUser);
        return appUser;
    }

    public void update(AppUser appUser, String id) {
        AppUser existing = appUsers.stream().filter(u -> u.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new UserNotFoundException("User not found"));
        int i = appUsers.indexOf(existing);
        appUsers.set(i, appUser);
    }

    public void delete(String id) {
        appUsers.removeIf(appUser -> appUser.getId().equals(id));
    }

    public Optional<AppUser> findByEmail(String email) {
        return appUsers.stream().filter(stream -> stream.getEmail().equals(email)).findFirst();
    }
}
