package temp.thymeleafdemo.controller;

import jakarta.validation.constraints.NotBlank;

public record UserForm(
        @NotBlank
        String name,

        @NotBlank
        String password
) {
}
