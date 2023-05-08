package nz.dinh.airnzemailapi.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public record User(
        @NotEmpty String id,
        @NotEmpty String name,
        @NotEmpty @Email String email) {
}

