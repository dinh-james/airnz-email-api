package nz.dinh.airnzemailapi.controller;

import jakarta.validation.Valid;
import nz.dinh.airnzemailapi.model.Email;
import nz.dinh.airnzemailapi.repository.EmailRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emails")
public class EmailController {
    private final EmailRepository emailRepository;

    public EmailController(EmailRepository emailRepository) {
        this.emailRepository = emailRepository;
    }

    @GetMapping
    public List<Email> findAll() {
        return emailRepository.findAll();
    }

    @GetMapping("/{id}")
    public Email findById(@PathVariable String id) {
        return emailRepository.findById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Email create(@Valid @RequestBody Email Email) {
        return emailRepository.create(Email);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@RequestBody Email Email, @PathVariable String id) {
        emailRepository.update(Email, id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        emailRepository.delete(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping("/{id}/save")
    public void saveAsDraft(@PathVariable String id) {
        emailRepository.saveAsDraft(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping("/{id}/send")
    public void send(@PathVariable String id) {
        emailRepository.send(id);
    }
}
