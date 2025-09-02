package com.ekibiina.ekibiina.api.controllers.members;

import com.ekibiina.ekibiina.api.entities.Member;
import com.ekibiina.ekibiina.api.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/members")
public class MemberController {

    @Autowired
    private MemberRepository memberRepository;

    // Create Member
    @PostMapping("/create")
    public Member createMember(@RequestBody Member member) {
        return memberRepository.save(member);
    }

    // Get All Members
    @GetMapping("/all")
    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    // Get Total Members
    @GetMapping("/count")
    public Long getTotalMembers() {
        return memberRepository.count();
    }

    //Get a Single Member by memberId
    @GetMapping("/{memberId}")
    public Optional<Member> getMemberById(@PathVariable Long memberId) {
        return memberRepository.findById(memberId);
    }

    // Get Total Members by Sacco_id
    @GetMapping("/count/sacco/{saccoId}")
    public Long getTotalMembersBySacco(@PathVariable Long saccoId) {
        return memberRepository.countBySaccoId(saccoId);
    }
}
