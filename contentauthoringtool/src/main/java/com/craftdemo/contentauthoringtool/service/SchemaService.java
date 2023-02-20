package com.craftdemo.contentauthoringtool.service;

import com.craftdemo.contentauthoringtool.model.FormPayload;

public interface SchemaService {
    FormPayload getSchemaById(int id);
    public FormPayload getSchemaByType(String type);
}
