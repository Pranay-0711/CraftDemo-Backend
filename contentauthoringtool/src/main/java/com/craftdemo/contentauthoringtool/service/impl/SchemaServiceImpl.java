package com.craftdemo.contentauthoringtool.service.impl;

import com.craftdemo.contentauthoringtool.model.FAQ;
import com.craftdemo.contentauthoringtool.model.FormPayload;
import com.craftdemo.contentauthoringtool.repository.SchemaRepository;
import com.craftdemo.contentauthoringtool.service.SchemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SchemaServiceImpl implements SchemaService {
    @Autowired
    private SchemaRepository schemaRepository;
    @Override
    public FormPayload getSchemaById(int id) {
        return schemaRepository.findById(id).get();
    }
    @Override
    public FormPayload getSchemaByType(String type) {
        return schemaRepository.findByType(type, FormPayload.class);
    }
}
