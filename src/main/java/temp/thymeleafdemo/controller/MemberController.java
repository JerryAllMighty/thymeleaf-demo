package temp.thymeleafdemo.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import temp.thymeleafdemo.controller.dto.request.CreateMemberRequestDto;
import temp.thymeleafdemo.controller.dto.response.CreateMemberResponseDto;
import temp.thymeleafdemo.service.MemberService;

import java.net.URI;

import static temp.thymeleafdemo.common.ApiConstants.BASE_END_POINT;
import static temp.thymeleafdemo.common.ApiConstants.MEMBER_REST_END_POINT;

@RestController
@RequestMapping(BASE_END_POINT + MEMBER_REST_END_POINT)
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @PostMapping
    public ResponseEntity<CreateMemberResponseDto> createMember(@RequestBody @Valid CreateMemberRequestDto createMemberRequestDto) {
        CreateMemberResponseDto createMemberResponseDto = memberService.createMember(createMemberRequestDto);
        return ResponseEntity.created(URI.create(BASE_END_POINT + MEMBER_REST_END_POINT + createMemberResponseDto.memberId()))
                .body(createMemberResponseDto);
    }

}
