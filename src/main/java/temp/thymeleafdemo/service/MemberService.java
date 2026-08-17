package temp.thymeleafdemo.service;

import temp.thymeleafdemo.controller.UserForm;
import temp.thymeleafdemo.controller.dto.request.CreateMemberRequestDto;
import temp.thymeleafdemo.controller.dto.response.CreateMemberResponseDto;
import temp.thymeleafdemo.domain.Member;

public interface MemberService {
    CreateMemberResponseDto createMember(CreateMemberRequestDto createMemberRequestDto);
    Member getMemberByNameAndPassword(UserForm userForm);
}
