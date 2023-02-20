package com.craftdemo.contentauthoringtool.controller;

import com.craftdemo.contentauthoringtool.exception.BadRequestException;
import com.craftdemo.contentauthoringtool.model.FAQ;
import com.craftdemo.contentauthoringtool.service.FAQService;
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
        FAQ faqResponse = null;
        try{
            faqResponse = faqService.updateFAQ(id,faq);
        }catch(Exception e){
            throw new BadRequestException(e.getMessage(), e);
        }
        return "FAQ updated in the DB";
    }
    @DeleteMapping("{id}/delete")
    public String delete(@PathVariable int id) throws BadRequestException {
        try{
            faqService.deleteFaqById(id);
        }
        catch(Exception e){
            throw new BadRequestException(e.getMessage(), e);
        }
        return "FAQ deleted in the DB";
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
