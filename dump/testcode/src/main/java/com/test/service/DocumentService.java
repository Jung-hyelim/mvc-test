package com.test.service;

import com.test.model.Document;

import java.util.List;

public interface DocumentService {

    public Document insert(Document document);
    public Document select(int document_id);
    public List<Document> selectList(int start, int end);
    public Document update(Document document);
    public int delete(int document_id);

}
