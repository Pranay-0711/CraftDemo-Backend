package com.craftdemo.contentauthoringtool.service;

import com.craftdemo.contentauthoringtool.model.FormPayload;

/**
 * CRUD operations for Schema in the DB.
 */
public interface SchemaService {
    /**
     * get schema by Id (1-faq, 2-article)
     * @param id id of schema
     * @return schema payload
     */
    FormPayload getSchemaById(int id);
    /**
     * get schema by the document type
     * @param type type of document(faq/article)
     * @return schema payload
     */
    public FormPayload getSchemaByType(String type);
}
