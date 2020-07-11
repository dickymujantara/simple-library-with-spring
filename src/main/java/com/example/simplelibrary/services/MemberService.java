package com.example.simplelibrary.services;

import com.example.simplelibrary.models.Member;

import java.util.List;

public interface MemberService {
    List<Member> listMember();
    Member store(Member member);
    Member getMember(Long id);
    void deleteMember(Long id);
}
