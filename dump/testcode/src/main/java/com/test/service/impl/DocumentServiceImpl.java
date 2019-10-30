package com.test.service.impl;

import com.test.dao.DocumentDao;
import com.test.model.Document;
import com.test.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DocumentServiceImpl implements DocumentService {

    @Autowired
    private DocumentDao documentDao;

    @Override
    public Document insert(Document document) {
        documentDao.insert(document);
        return null;
    }

    @Override
    public Document select(int document_id) {
        return null;
    }

    @Override
    public List<Document> selectList(int start, int end) {
        return null;
    }

    @Override
    public Document update(Document document) {
        return null;
    }

    @Override
    public int delete(int document_id) {
        return 0;
    }
}
