package com.example.simplelibrary.controllers;

import com.example.simplelibrary.models.Buku;
import com.example.simplelibrary.services.BukuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BukuController {
    private BukuService bukuService;

    @Autowired
    public void setBukuService(BukuService bukuService) {
        this.bukuService = bukuService;
    }

    @RequestMapping("/buku")
    public String index(Model model){
        model.addAttribute("bukus",bukuService.listBuku());
        return "buku";
    }

    @RequestMapping(value = "/buku/create", method = RequestMethod.GET)
    public String formBuku(Model model){
        model.addAttribute("buku",new Buku());
        return "formBuku";
    }

    @RequestMapping(value = "/buku/create", method = RequestMethod.POST)
    public String store(Model model, Buku buku){
        model.addAttribute("buku",bukuService.store(buku));
        return "redirect:/buku";
    }

    @RequestMapping("/buku/{id}")
    public String editBuku(Model model, @PathVariable Long id){
        model.addAttribute("buku",bukuService.getBuku(id));
        return "formBuku";
    }

    @RequestMapping("/buku/delete/{id}")
    public String delete(@PathVariable Long id){
        try {

            bukuService.deleteBuku(id);
            return "redirect:/buku";

        }catch (Exception e){
            return e.getMessage();
        }
    }

}
