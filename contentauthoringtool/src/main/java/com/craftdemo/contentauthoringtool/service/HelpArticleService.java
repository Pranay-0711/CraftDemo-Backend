package com.craftdemo.contentauthoringtool.service;

import com.craftdemo.contentauthoringtool.model.HelpArticle;

import java.util.List;
import java.util.UUID;

/**
 * CRUD operations related to the help article
 */
public interface HelpArticleService {
    /**
     * Saves the Help article in the DB
     * @param helpArticle
     * @return
     */
    public HelpArticle saveHelpArticle(HelpArticle helpArticle);

    /**
     * updates the help article in the DB
     * @param id id to uniquely identify the help article
     * @param helpArticle the article which has to be updated with
     * @return
     */
    public HelpArticle updateHelpArticle(int id, HelpArticle helpArticle);

    /**
     *get all the help articles
     * @return list of all the help articles
     */
    List<HelpArticle> getHelpArticle();

    /**
     * deletes help article by id
     * @param id id to uniquely identify the article in the DB
     */
    public void deleteArticleById(int id);

    /**
     * get all the help article submitted by the user.
     * @param userId user id
     * @return list of help articles
     */
    List<HelpArticle> getHelpArticleByUserId(UUID userId);
}
