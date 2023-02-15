package com.craftdemo.contentauthoringtool.service;

import com.craftdemo.contentauthoringtool.interfaces.HelpArticleService;
import com.craftdemo.contentauthoringtool.model.HelpArticle;
import com.craftdemo.contentauthoringtool.repository.HelpArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HelpArticleServiceImplementation implements HelpArticleService {

    @Autowired
    private HelpArticleRepository helpArticleRepository;

    @Override
    public HelpArticle saveHelpArticle(HelpArticle helpArticle) {
        return helpArticleRepository.save(helpArticle);
    }

    @Override
    public HelpArticle updateHelpArticle(int id, HelpArticle helpArticle) {
        HelpArticle helpArticleFromDB = helpArticleRepository.getReferenceById(id);
        helpArticleFromDB.setImageText(helpArticle.getImageText());
        helpArticleFromDB.setImageUrl(helpArticle.getImageUrl());
        helpArticleFromDB.setParagraph(helpArticle.getParagraph());
        helpArticleFromDB.setTitle(helpArticle.getTitle());
        helpArticleFromDB.setSubtitle(helpArticle.getSubtitle());
        return helpArticleRepository.save(helpArticleFromDB);
    }

    @Override
    public List<HelpArticle> getHelpArticle() {
        return helpArticleRepository.findAll();
    }

    @Override
    public List<HelpArticle> getHelpArticleByUserId(UUID userId) {
        return helpArticleRepository.findByUserId(userId, HelpArticle.class);
    }
}
