package temp.thymeleafdemo.repository;

import org.apache.ibatis.annotations.Mapper;
import temp.thymeleafdemo.domain.Member;

@Mapper
public interface MemberMapper {
    int insert(final Member member);
}
