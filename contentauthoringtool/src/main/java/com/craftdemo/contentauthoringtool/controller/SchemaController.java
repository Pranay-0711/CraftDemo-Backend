package com.craftdemo.contentauthoringtool.controller;

import com.craftdemo.contentauthoringtool.model.FormPayload;
import com.craftdemo.contentauthoringtool.service.SchemaService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/schema")
@CrossOrigin
public class SchemaController {
    @Autowired
    private SchemaService schemaService;

    @GetMapping("{id}/get")
    public FormPayload getSchema(@PathVariable int id){
        return schemaService.getSchemaById(id);
    }

    @GetMapping("/get/{type}")
    public FormPayload getSchemaByType(@PathVariable String type){
        return schemaService.getSchemaByType(type);
    }
}
