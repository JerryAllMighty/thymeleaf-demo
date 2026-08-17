package temp.thymeleafdemo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import temp.thymeleafdemo.controller.dto.request.CreateMemberRequestDto;
import temp.thymeleafdemo.controller.dto.response.CreateMemberResponseDto;
import temp.thymeleafdemo.domain.Member;
import temp.thymeleafdemo.domain.MemberRole;
import temp.thymeleafdemo.domain.MemberStatus;
import temp.thymeleafdemo.repository.MemberMapper;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
    private final MemberMapper memberMapper;

    @Override
    @Transactional
    public CreateMemberResponseDto createMember(CreateMemberRequestDto createMemberRequestDto) {
        Member member = Member.builder()
                .password(createMemberRequestDto.password())
                .name(createMemberRequestDto.name())
                .role(MemberRole.from(createMemberRequestDto.role()))
                .status(MemberStatus.NORMAL)
                .build();

        if (memberMapper.insert(member) < 1) {
            throw new RuntimeException("회원 저장 오류");
        }
        return CreateMemberResponseDto.builder()
                .memberId(member.getMemberId())
                .password(member.getPassword())
                .name(member.getName())
                .role(member.getClass().getName())
                .build();
    }
}
