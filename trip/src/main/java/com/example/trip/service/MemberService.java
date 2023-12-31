package com.example.trip.service;

import com.example.trip.domain.Member;
import com.example.trip.dto.Member.LoginRequest;
import com.example.trip.dto.Member.SignInRequest;
import com.example.trip.dto.Member.UpdatePasswordRequest;
import com.example.trip.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public void saveMember(Member member){
        memberRepository.save(member);
    }


    public void saveMember(SignInRequest request) {
        Member member = Member.builder()
                .loginId(request.getLoginId())
                .password(request.getPassword())
                .name(request.getName())
                .nickname(request.getNickname())
                .email(request.getEmail())
                .build();

        memberRepository.save(member);
    }

    public Member findByID(Long id){
        return memberRepository.findByMemberIndex(id);
    }

    public Long findUserIndexByLoginId(String loginId){
        return memberRepository.findByLoginId(loginId).getMemberIndex();
    }


    public boolean loginMember(LoginRequest request){
        Member member = memberRepository.findByLoginId(request.getLoginId());

        if(member==null) return false;


        if(member.getPassword().equals(request.getPassword()))
            return true;
        else
            return false;
    }

    public boolean allowedId(SignInRequest request){
        Member member = memberRepository.findByLoginId(request.getLoginId());
        if(member != null)
            return false;
        else
            return true;
    }

    public void deleteMember(LoginRequest request){
        Member member = memberRepository.findByLoginId(request.getLoginId());
        memberRepository.delete(member);
    }

    public String findMemberPass(String loginId){
        Member member = memberRepository.findByLoginId(loginId);
        return member.getPassword();
    }

    @Transactional
    public void updateMemberPass(Member member, UpdatePasswordRequest request){
        member.setPassword(request.getPassword());
        saveMember(member);
    }

    public Member findMemberByIndex(Long memberIndex){
        return memberRepository.findByMemberIndex(memberIndex);
    }

    public String findNickName(Long memberIndex){
        return memberRepository.findByMemberIndex(memberIndex).getNickname();
    }
}
