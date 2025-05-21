package hello.core.member;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

//@Component
public class MemoryMemberRepository implements MemberRepository {

  // HashMap - 동시성 이슈가 발생할 수 있음
  // ConcurrentHashMap - 을 현업에서는 사용하는 편
  private static Map<Long, Member> store = new HashMap<>();

  @Override
  public void save(Member member) {
    store.put(member.getId(), member);
  }

  @Override
  public Member findById(Long memberId) {
    return store.get(memberId);
  }
}
