package com.craftdemo.contentauthoringtool.service;

import com.craftdemo.contentauthoringtool.model.FAQ;

import java.util.List;
import java.util.UUID;

public interface FAQService {
    public FAQ saveFAQ(FAQ frequentQuestionAndAnswer);
    public FAQ updateFAQ(int id, FAQ faq);
    List<FAQ> getFAQ();
    public void deleteFaqById(int id);
    List<FAQ> getFAQByUserId(UUID userId);
}
