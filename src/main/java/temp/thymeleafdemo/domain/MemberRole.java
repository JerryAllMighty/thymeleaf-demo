package temp.thymeleafdemo.domain;

public enum MemberRole {
    REGULAR, ADMIN;

    public static MemberRole from(String targetString) {
        return switch (targetString) {
            case "REGULAR" -> MemberRole.REGULAR;
            case "ADMIN" -> MemberRole.ADMIN;
            default -> throw new IllegalArgumentException("회원 역할이 적절하지 않습니다");
        };
    }
}
