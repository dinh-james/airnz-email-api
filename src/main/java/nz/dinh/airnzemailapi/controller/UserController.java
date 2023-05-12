package nz.dinh.airnzemailapi.controller;

import jakarta.validation.Valid;
import nz.dinh.airnzemailapi.model.AppUser;
import nz.dinh.airnzemailapi.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public List<AppUser> findAll() {
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<AppUser> findById(@PathVariable String id) {
        return userRepository.findById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public AppUser create(@Valid @RequestBody AppUser appUser) {
        return userRepository.create(appUser);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@RequestBody AppUser appUser, @PathVariable String id) {
        userRepository.update(appUser, id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        userRepository.delete(id);
    }
}
