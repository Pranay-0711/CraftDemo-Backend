package com.craftdemo.contentauthoringtool.service.impl;

import com.craftdemo.contentauthoringtool.exception.BadRequestException;
import com.craftdemo.contentauthoringtool.service.FAQService;
import com.craftdemo.contentauthoringtool.model.FAQ;
import com.craftdemo.contentauthoringtool.repository.FAQRepository;
import com.craftdemo.contentauthoringtool.utility.ILogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class FAQServiceImplementation implements FAQService {
    @Autowired
    private FAQRepository faqRepository;

    @Autowired
    ILogger<String> logger;

    @Override
    public FAQ saveFAQ(FAQ frequentQuestionAndAnswer) {
        //validation check
        if(frequentQuestionAndAnswer==null){
            throw new BadRequestException("Please enter a valid FAQ");
        }
        FAQ faq=null;
        try{
            faq = faqRepository.save(frequentQuestionAndAnswer);
        }
        catch(Exception e){
            logger.logError("Error Occured while saving FAQ.");
            throw e;
        }
        logger.logInfo("Faq persisted in the DB");
        return faq;
    }

    @Override
    public FAQ updateFAQ(int id, FAQ faq) {
        FAQ faqFromDB= null;
        try{
            faqFromDB = faqRepository.findById(id).get();
            faqFromDB.setAnswer(faq.getAnswer());
            faqFromDB.setQuestion(faq.getQuestion());
            faqFromDB = faqRepository.saveAndFlush(faqFromDB);
        }
        catch(Exception e){
            logger.logError("Exception occured while updating the DB"+e.getMessage());
            throw e;
        }
       return faqFromDB;
    }

    @Override
    public List<FAQ> getFAQ() {
        return faqRepository.findAll();
    }

    @Override
    public void deleteFaqById(int id) {
        try{
            FAQ dataFromDB = faqRepository.findById(id).get();
            faqRepository.delete(dataFromDB);
        }
        catch(Exception e){
            logger.logError("Exception occured while deletion-"+e);
            throw e;
        }
        logger.logInfo("Successfully deleted the faq record");
    }

    @Override
    public List<FAQ> getFAQByUserId(UUID userId) {
        return faqRepository.findByUserId(userId, FAQ.class);
    }
}
