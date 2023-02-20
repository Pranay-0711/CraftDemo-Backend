package com.craftdemo.contentauthoringtool.service;
import com.craftdemo.contentauthoringtool.model.FAQ;
import com.craftdemo.contentauthoringtool.repository.FAQRepository;
import com.craftdemo.contentauthoringtool.service.impl.FAQServiceImplementation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class FAQServiceImplementationTest {

    @Mock
    private FAQRepository faqRepository;

    @InjectMocks
    private FAQServiceImplementation faqService;

    private FAQ testFAQ;

    @BeforeEach
    void setUp() {
        testFAQ = new FAQ();
        testFAQ.setId(1);
        testFAQ.setQuestion("Test Question");
        testFAQ.setAnswer("Test Answer");
        testFAQ.setUserId(UUID.randomUUID());
    }

    @Test
    void testSaveFAQ() {
        when(faqRepository.save(testFAQ)).thenReturn(testFAQ);

        FAQ result = faqService.saveFAQ(testFAQ);

        assertEquals(testFAQ, result);
        verify(faqRepository, times(1)).save(testFAQ);
    }

    @Test
    void testUpdateFAQ() {
        when(faqRepository.findById(1)).thenReturn(java.util.Optional.of(testFAQ));
        when(faqRepository.saveAndFlush(testFAQ)).thenReturn(testFAQ);

        testFAQ.setAnswer("Updated Answer");
        FAQ result = faqService.updateFAQ(1, testFAQ);

        assertEquals(testFAQ, result);
        verify(faqRepository, times(1)).findById(1);
        verify(faqRepository, times(1)).saveAndFlush(testFAQ);
    }

    @Test
    void testGetFAQ() {
        List<FAQ> expected = new ArrayList<>();
        expected.add(testFAQ);

        when(faqRepository.findAll()).thenReturn(expected);

        List<FAQ> result = faqService.getFAQ();

        assertEquals(expected, result);
        verify(faqRepository, times(1)).findAll();
    }

    @Test
    void testDeleteFaqById() {
        when(faqRepository.findById(1)).thenReturn(java.util.Optional.of(testFAQ));

        assertDoesNotThrow(() -> faqService.deleteFaqById(1));
        verify(faqRepository, times(1)).findById(1);
        verify(faqRepository, times(1)).delete(testFAQ);
    }

    @Test
    void testGetFAQByUserId() {
        List<FAQ> expected = new ArrayList<>();
        expected.add(testFAQ);

        when(faqRepository.findByUserId(testFAQ.getUserId(), FAQ.class)).thenReturn(expected);

        List<FAQ> result = faqService.getFAQByUserId(testFAQ.getUserId());

        assertEquals(expected, result);
        verify(faqRepository, times(1)).findByUserId(testFAQ.getUserId(), FAQ.class);
    }
}

