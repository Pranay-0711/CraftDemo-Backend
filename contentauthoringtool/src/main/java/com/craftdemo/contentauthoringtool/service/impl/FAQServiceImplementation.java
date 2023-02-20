package com.craftdemo.contentauthoringtool.service.impl;

import com.craftdemo.contentauthoringtool.service.FAQService;
import com.craftdemo.contentauthoringtool.model.FAQ;
import com.craftdemo.contentauthoringtool.repository.FAQRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class FAQServiceImplementation implements FAQService {
    @Autowired
    private FAQRepository faqRepository;
    @Override
    public FAQ saveFAQ(FAQ frequentQuestionAndAnswer) {
        FAQ faq=null;
        try{
            faq = faqRepository.save(frequentQuestionAndAnswer);
        }
        catch(Exception e){
            System.err.println("Error Occured while saving FAQ.");
        }
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
            System.err.println("Exception occured while deletion-"+e);
            throw e;
        }
    }

    @Override
    public List<FAQ> getFAQByUserId(UUID userId) {
        return faqRepository.findByUserId(userId, FAQ.class);
    }
}
