package hello.core.member;

import lombok.Getter;
import org.springframework.stereotype.Component;

@Getter
@Component
public class MemberServiceImpl implements MemberService {

  // 테스트 용도
  private final MemberRepository memberRepository;

//  @Autowired  // 자동 의존관계 주입
  public MemberServiceImpl(MemberRepository memoryMemberRepository) {
    this.memberRepository = memoryMemberRepository;
  }

  @Override
  public void join(Member member) {
    memberRepository.save(member);
  }

  @Override
  public Member findMember(Long memberId) {
    return memberRepository.findById(memberId);
  }

}
