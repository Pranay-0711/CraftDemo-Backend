package com.craftdemo.contentauthoringtool.service;

import com.craftdemo.contentauthoringtool.interfaces.FAQService;
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
        return faqRepository.save(frequentQuestionAndAnswer);
    }

    @Override
    public FAQ updateFAQ(int id, FAQ faq) {
        FAQ faqFromDB = faqRepository.getReferenceById(id);
        faqFromDB.setAnswer(faq.getAnswer());
        faqFromDB.setQuestion(faq.getQuestion());
        return faqRepository.save(faqFromDB);
    }

    @Override
    public List<FAQ> getFAQ() {
        return faqRepository.findAll();
    }

    @Override
    public List<FAQ> getFAQByUserId(UUID userId) {
        return faqRepository.findByUserId(userId, FAQ.class);
    }
}
