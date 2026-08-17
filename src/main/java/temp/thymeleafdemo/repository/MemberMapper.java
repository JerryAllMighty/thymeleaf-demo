package temp.thymeleafdemo.repository;

import org.apache.ibatis.annotations.Mapper;
import temp.thymeleafdemo.entity.Member;

@Mapper
public interface MemberMapper {
    int insert(final Member member);
}
