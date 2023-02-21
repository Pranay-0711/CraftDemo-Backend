package com.craftdemo.contentauthoringtool.service;

import com.craftdemo.contentauthoringtool.model.FAQ;

import java.util.List;
import java.util.UUID;

/**
 * CRUD operation for FAQ
 */
public interface FAQService {
    /**
     * saves the FAQ into the DB
     * @param frequentQuestionAndAnswer faq to be saved
     * @return
     */
    public FAQ saveFAQ(FAQ frequentQuestionAndAnswer);

    /**
     * update the faq on user's request
     * @param id faq id in the DB
     * @param faq the faq information to be updated
     * @return
     */
    public FAQ updateFAQ(int id, FAQ faq);

    /**
     * returns the list of Faq's
     * @return the list of faq's
     */
    List<FAQ> getFAQ();

    /**
     * deletes the faq in the DB
     * @param id id mapping for the faq which has to be deleted.
     */
    public void deleteFaqById(int id);

    /**
     * get all faq's added by the user
     * @param userId user Id for which the faq is to be retrieved
     * @return list of faq's for a user
     */
    List<FAQ> getFAQByUserId(UUID userId);
}
