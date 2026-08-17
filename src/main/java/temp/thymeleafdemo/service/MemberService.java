package temp.thymeleafdemo.service;

import temp.thymeleafdemo.controller.dto.request.CreateMemberRequestDto;
import temp.thymeleafdemo.controller.dto.response.CreateMemberResponseDto;

public interface MemberService {
    CreateMemberResponseDto createMember(CreateMemberRequestDto createMemberRequestDto);
}
