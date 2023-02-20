package com.craftdemo.contentauthoringtool.controller;

import com.craftdemo.contentauthoringtool.exception.BadRequestException;
import com.craftdemo.contentauthoringtool.model.FAQ;
import com.craftdemo.contentauthoringtool.service.FAQService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class FAQControllerTest {

    @Mock
    private FAQService faqService;

    @InjectMocks
    private FAQController faqController;

    private List<FAQ> faqList;

    @Before
    public void setup() {
        faqList = new ArrayList<>();
        faqList.add(new FAQ(1, "Question 1", "Answer 1", UUID.randomUUID()));
        faqList.add(new FAQ(2, "Question 2", "Answer 2", UUID.randomUUID()));
    }

    @Test
    public void testAddFAQ() {
        FAQ faq = new FAQ(1, "Question", "Answer", UUID.randomUUID());

        String expectedResponse = "FAQ persisted in the DB";
        String actualResponse = faqController.add(faq);

        assertEquals(expectedResponse, actualResponse);

        verify(faqService, times(1)).saveFAQ(faq);
    }

    @Test
    public void testUpdateFAQ() {
        int id = 1;
        FAQ faq = new FAQ(id, "Question", "Answer", UUID.randomUUID());

        when(faqService.updateFAQ(id, faq)).thenReturn(faq);

        String expectedResponse = "FAQ updated in the DB";
        String actualResponse = faqController.update(id, faq);

        assertEquals(expectedResponse, actualResponse);

        verify(faqService, times(1)).updateFAQ(id, faq);
    }

    @Test(expected = BadRequestException.class)
    public void testUpdateFAQWithException() {
        int id = 1;
        FAQ faq = new FAQ(id, "Question", "Answer", UUID.randomUUID());

        doThrow(new RuntimeException("FAQ not found")).when(faqService).updateFAQ(id, faq);

        faqController.update(id, faq);
    }

    @Test
    public void testDeleteFAQ() {
        int id = 1;

        String expectedResponse = "FAQ deleted in the DB";
        String actualResponse = faqController.delete(id);

        assertEquals(expectedResponse, actualResponse);

        verify(faqService, times(1)).deleteFaqById(id);
    }

    @Test(expected = BadRequestException.class)
    public void testDeleteFAQWithException() {
        int id = 1;

        doThrow(new RuntimeException("FAQ not found")).when(faqService).deleteFaqById(id);

        faqController.delete(id);
    }

    @Test
    public void testGetAllFAQs() {
        when(faqService.getFAQ()).thenReturn(faqList);

        List<FAQ> expectedList = faqList;
        List<FAQ> actualList = faqController.getFAQ();

        assertEquals(expectedList, actualList);

        verify(faqService, times(1)).getFAQ();
    }
}