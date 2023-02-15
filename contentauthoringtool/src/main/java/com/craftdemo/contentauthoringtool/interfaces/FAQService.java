package com.craftdemo.contentauthoringtool.interfaces;

import com.craftdemo.contentauthoringtool.model.FAQ;

import java.util.List;
import java.util.UUID;

public interface FAQService {
    public FAQ saveFAQ(FAQ frequentQuestionAndAnswer);
    public FAQ updateFAQ(int id, FAQ faq);
    List<FAQ> getFAQ();
    List<FAQ> getFAQByUserId(UUID userId);
}
