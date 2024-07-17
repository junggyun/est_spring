package com.study.est_spring.day0717.ep01;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/members")
public class MemberController {
    private List<Member> members = new ArrayList<>();
    private long nextId = 1;

    @GetMapping
    public List<Member> getAllMembers() {
        return members;
    }

    @PostMapping
    public Member createMember(
            @RequestBody Member member
    ) {
        member.setId(nextId++);
        members.add(member);
        return member;
    }

    @GetMapping("/{id}")
    public Member getMemberById(
            @PathVariable("id") Long id
    ) {
        return members.stream()
                .filter(m -> m.getId() == id)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    @PutMapping("/{id}")
    public Member updateMember(
            @PathVariable("id") Long id,
            @RequestBody Member updateMember
    ) {
        Member member = members.stream()
                .filter(m -> m.getId() == id)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
        member.setName(updateMember.getName());
        member.setEmail(updateMember.getEmail());
        return member;
    }

    @DeleteMapping("/{id}")
    public void deleteMember(
            @PathVariable("id") Long id
    ) {
        members.removeIf(m -> m.getId() == id);
    }
}
