package temp.thymeleafdemo.controller.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

@Builder
public record CreateMemberRequestDto(
        @NotBlank
        String password,

        @NotBlank
        String name,

        @NotBlank
        String role
) {
}
