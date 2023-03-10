package com.craftdemo.contentauthoringtool.controller;

import com.craftdemo.contentauthoringtool.exception.BadRequestException;
import com.craftdemo.contentauthoringtool.service.HelpArticleService;
import com.craftdemo.contentauthoringtool.model.HelpArticle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/article")
@CrossOrigin
public class HelpArticleController {
    @Autowired
    private HelpArticleService helpArticleService;

    @PostMapping("/add")
    public String add(@RequestBody HelpArticle helpArticle){
        try{
            helpArticleService.saveHelpArticle(helpArticle);
        }catch(Exception e){
            throw new BadRequestException(e.getMessage(),e);
        }
        return "FAQ persisted in the DB";
    }

    @PutMapping("{id}/update")
    public String update(@PathVariable int id, @RequestBody HelpArticle helpArticle){
        try{
            helpArticleService.updateHelpArticle(id, helpArticle);
        }catch(Exception e){
            throw new BadRequestException(e.getMessage(),e);
        }
        return "Help Article updated in the DB";
    }

    @DeleteMapping("{id}/delete")
    public String delete(@PathVariable int id) throws BadRequestException {
        try{
            helpArticleService.deleteArticleById(id);
        }
        catch(Exception e){
            throw new BadRequestException(e.getMessage(), e);
        }
        return "FAQ deleted in the DB";
    }

    @GetMapping("/get")
    public List<HelpArticle> getArticle(){
        return helpArticleService.getHelpArticle();
    }

    @GetMapping("/{userId}/get")
    public List<HelpArticle> getUserSpecificArticle(@PathVariable UUID userId){
        return helpArticleService.getHelpArticleByUserId(userId);
    }
}
