package com.example.simplelibrary.controllers;

import com.example.simplelibrary.models.Member;
import com.example.simplelibrary.services.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MemberController{
    private MemberService memberService;

    @Autowired
    public void setMemberService(MemberService memberService) {
        this.memberService = memberService;
    }

    @RequestMapping("/member")
    public String index(Model model){
        model.addAttribute("members",memberService.listMember());
        return "member";
    }

    @RequestMapping(value = "/member/create", method = RequestMethod.GET)
    public String formMember(Model model){
        model.addAttribute("member", new Member());
        return "formMember";
    }

    @RequestMapping(value = "member/create", method = RequestMethod.POST)
    public String store(Model model, Member member){
        model.addAttribute("member", memberService.store(member));
        return "redirect:/member";
    }

    @RequestMapping("member/{id}")
    public String editMember(Model model, @PathVariable Long id){
        model.addAttribute("member",memberService.getMember(id));
        return "formMember";
    }

    @RequestMapping("member/delete/{id}")
    public String deleteMember(@PathVariable Long id){
        memberService.deleteMember(id);
        return "redirect:/member";
    }

}
