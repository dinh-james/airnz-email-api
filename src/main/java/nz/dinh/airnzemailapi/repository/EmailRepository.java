package nz.dinh.airnzemailapi.repository;

import nz.dinh.airnzemailapi.exception.EmailNotFoundException;
import nz.dinh.airnzemailapi.model.Email;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmailRepository {
    List<Email> emails = new ArrayList<>();

    public EmailRepository() {
        emails.add(new Email(
                "fa409398-8cf2-47af-8ad3-b6fe4669e09a",
                "SENT",
                "james@example.com",
                new String[]{"support@example.com"},
                "Help!",
                "Hi Team! Please be kind as I haven't worked with Java in many years.",
                null,
                null
        ));
        emails.add(new Email(
                "d63b49c7-1417-499a-af6a-f9cb2358ef82",
                "SENT",
                "nik@example.com",
                new String[]{"john@example.com"},
                "Hello there",
                "Hi John, I hope you're having an awesome day.",
                null,
                null
        ));
        emails.add(new Email(
                "09d9c272-663c-4ec5-a0a3-e915b0f0c8c3",
                "NEW",
                "support@example.com",
                new String[]{"james@example.com"},
                "RE: Help!",
                "Hi James! I've forwarded your email to my manager for review. Thanks!",
                new String[]{"manager@example.com"},
                null
        ));
        emails.add(new Email(
                "fa409398-8cf2-47af-8ad3-b6fe4669e09a",
                "DRAFT",
                "admin@example.com",
                new String[]{"admin@example.com"},
                "New Accounts Process",
                "Hi Everyone, please see attached the final copy of the new accounts process.",
                null,
                new String[]{"james@example.com", "john@example.com", "nik@example.com"}
        ));
    }

    public List<Email> findAll() {
        return emails;
    }

    public Email findById(String id) {
        return emails.stream().filter(stream -> stream.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new EmailNotFoundException("Email not found"));
    }

    public Email create(Email Email) {
        emails.add(Email);
        return Email;
    }

    public void update(Email Email, String id) {
        Email existing = emails.stream().filter(u -> u.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new EmailNotFoundException("Email not found"));
        int i = emails.indexOf(existing);
        emails.set(i, Email);
    }

    public void delete(String id) {
        emails.removeIf(Email -> Email.getId().equals(id));
    }

    public void send(String id) {
        Email existing = emails.stream().filter(u -> u.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new EmailNotFoundException("Email not found"));
        int i = emails.indexOf(existing);
        existing.setStatus("SENT");
        emails.set(i, existing);
    }

    public void saveAsDraft(String id) {
        Email existing = emails.stream().filter(u -> u.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new EmailNotFoundException("Email not found"));
        int i = emails.indexOf(existing);
        existing.setStatus("DRAFT");
        emails.set(i, existing);
    }
}
