package com.test.dao;

import com.test.model.Document;

public interface DocumentDao {

    public int insert(Document document);

//    public int update(Document document);

    public Document select(int document_id);

//    public List<Document> selectList(int start, int end);
//
//    public int delete(int document_id);

}
