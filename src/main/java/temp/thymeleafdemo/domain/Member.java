package temp.thymeleafdemo.domain;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class Member {
    private Long memberId;
    private String password;
    private String name;
    private MemberRole role;
    private MemberStatus status;
    private String createdAt;
}
