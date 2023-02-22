package com.craftdemo.contentauthoringtool.service.impl;

import com.craftdemo.contentauthoringtool.exception.BadRequestException;
import com.craftdemo.contentauthoringtool.model.FAQ;
import com.craftdemo.contentauthoringtool.service.HelpArticleService;
import com.craftdemo.contentauthoringtool.model.HelpArticle;
import com.craftdemo.contentauthoringtool.repository.HelpArticleRepository;
import com.craftdemo.contentauthoringtool.utility.ILogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HelpArticleServiceImplementation implements HelpArticleService {

    @Autowired
    private HelpArticleRepository helpArticleRepository;

    @Autowired
    ILogger<String> logger;

    @Override
    public HelpArticle saveHelpArticle(HelpArticle helpArticle) {
        HelpArticle article= null;
        if(helpArticle==null){
            throw new BadRequestException("Please enter a valid help Article");
        }
        try{
            article = helpArticleRepository.save(helpArticle);
        }catch(Exception e){
            logger.logError("Error occured while adding help article");
            throw e;
        }
        logger.logInfo("Successfully saved the article");
        return article;

    }

    @Override
    public HelpArticle updateHelpArticle(int id, HelpArticle helpArticle) {
        HelpArticle article= null;
        try{
            HelpArticle helpArticleFromDB = helpArticleRepository.getReferenceById(id);
            helpArticleFromDB.setImageText(helpArticle.getImageText());
            helpArticleFromDB.setImageUrl(helpArticle.getImageUrl());
            helpArticleFromDB.setParagraph(helpArticle.getParagraph());
            helpArticleFromDB.setTitle(helpArticle.getTitle());
            helpArticleFromDB.setSubtitle(helpArticle.getSubtitle());
            article= helpArticleRepository.save(helpArticleFromDB);
        }catch(Exception e){
            logger.logError("Exception occured while adding the logs");
            throw e;
        }
        logger.logInfo("Article record successfully updated");
        return article;
    }

    @Override
    public List<HelpArticle> getHelpArticle() {
        return helpArticleRepository.findAll();
    }

    @Override
    public void deleteArticleById(int id) {
        try{
            HelpArticle dataFromDB = helpArticleRepository.findById(id).get();
            helpArticleRepository.delete(dataFromDB);
        }
        catch(Exception e){
            logger.logError("Exception occured while deleting article-"+e);
            throw e;
        }
        logger.logInfo("Article Record Deleted successfully");
    }

    @Override
    public List<HelpArticle> getHelpArticleByUserId(UUID userId) {
        return helpArticleRepository.findByUserId(userId, HelpArticle.class);
    }
}
