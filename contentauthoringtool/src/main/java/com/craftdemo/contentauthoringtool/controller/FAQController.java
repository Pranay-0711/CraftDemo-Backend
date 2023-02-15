package com.craftdemo.contentauthoringtool.controller;

import com.craftdemo.contentauthoringtool.model.FAQ;
import com.craftdemo.contentauthoringtool.interfaces.FAQService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/faq")
@CrossOrigin
public class FAQController {
    @Autowired
    private FAQService faqService;

    @PostMapping("/add")
    public String add(@RequestBody FAQ faq){
        faqService.saveFAQ(faq);
        return "FAQ persisted in the DB";
    }

    @PutMapping("{id}/update")
    public String update(@PathVariable int id, @RequestBody FAQ faq){
        faqService.updateFAQ(id,faq);
        return "FAQ updated in the DB";
    }

    @GetMapping("/get")
    public List<FAQ> getFAQ(){
        return faqService.getFAQ();
    }

    @GetMapping("/{userId}/get")
    public List<FAQ> getUserSpecifFAQ(@PathVariable UUID userId){
        return faqService.getFAQByUserId(userId);
    }

}
