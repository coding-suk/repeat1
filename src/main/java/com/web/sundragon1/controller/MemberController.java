package com.web.sundragon1.controller;

import com.web.sundragon1.dto.*;
import com.web.sundragon1.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/members")
    public MemberSaveResponseDto saveMember(@RequestBody MemberSaveRequiredDto requestDto) {
        return MemberService.saveMember(requestDto);
    }

    @GetMapping("/members")
    public List<MemberSimpleResponseDto> getMember() {
        return memberService.getMembers();
    }

    @GetMapping("/members/{memberId}")
    public MemberDetailResponseDto getMember(@PathVariable Long memberId) {
        return memberService.getMember(memberId);
    }

    @PutMapping("/members/{memberId}")
    public MemberUpdateResponseDto updateMember(@PathVariable Long memberId, @RequestBody MemberUpdateRequestDto requestDto) {
        return memberService.updateMember(memberId, requestDto);
    }

    @DeleteMapping("/member/{memberId}")
    public void deleteMember(@PathVariable Long memberId) {
        memberService.deleteMember(memberId);
    }
}
