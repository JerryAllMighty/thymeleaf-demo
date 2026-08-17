package temp.thymeleafdemo.controller.dto.response;

import lombok.Builder;

@Builder
public record CreateMemberResponseDto(
        Long memberId,
        String password,
        String name,
        String role
) {
}
