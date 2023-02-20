package com.craftdemo.contentauthoringtool.service;

import com.craftdemo.contentauthoringtool.model.HelpArticle;

import java.util.List;
import java.util.UUID;

public interface HelpArticleService {
    public HelpArticle saveHelpArticle(HelpArticle helpArticle);
    public HelpArticle updateHelpArticle(int id, HelpArticle helpArticle);
    List<HelpArticle> getHelpArticle();
    List<HelpArticle> getHelpArticleByUserId(UUID userId);
}
