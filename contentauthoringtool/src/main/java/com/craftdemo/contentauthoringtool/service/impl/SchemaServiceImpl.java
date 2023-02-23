package com.craftdemo.contentauthoringtool.service.impl;

import com.craftdemo.contentauthoringtool.cache.ICacheAccessor;
import com.craftdemo.contentauthoringtool.model.FormPayload;
import com.craftdemo.contentauthoringtool.repository.SchemaRepository;
import com.craftdemo.contentauthoringtool.service.SchemaService;
import com.craftdemo.contentauthoringtool.utility.ILogger;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SchemaServiceImpl implements SchemaService {
    @Autowired
    private SchemaRepository schemaRepository;

    @Autowired
    private ILogger logger;
    private ICacheAccessor<String, FormPayload> cache;

    public SchemaServiceImpl(ICacheAccessor<String, FormPayload> cache) {
        this.cache = cache;
    }

    @Override
    public FormPayload getSchemaById(int id) {
        return schemaRepository.findById(id).get();
    }
    @Override
    public FormPayload getSchemaByType(String type) {
        FormPayload payload = cache.get(type);
        if(payload!=null)return payload;
        return schemaRepository.findByType(type, FormPayload.class);
    }

    @Override
    public FormPayload updatePayload(String type, FormPayload formPayload) {
        cache.put(type, formPayload);
        FormPayload payloadFromDb =  schemaRepository.findByType(type, FormPayload.class);
        payloadFromDb.setJsonSchema(formPayload.getJsonSchema());
        return schemaRepository.save(payloadFromDb);
    }

    @Override
    @PostConstruct
    public void refreshCacheWithSchema(){
        cache.put("faq", schemaRepository.findByType("faq", FormPayload.class));
        cache.put("help_article",schemaRepository.findByType("help_article", FormPayload.class));
        logger.logInfo("cache refresh with schema");
    }
}
