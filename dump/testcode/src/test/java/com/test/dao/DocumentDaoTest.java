package com.test.dao;

import com.test.dao.DocumentDao;
import com.test.model.Document;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:root-context.xml")
public class DocumentDaoTest {

    private Document document;

    @Autowired
    private DocumentDao documentDao;

    @Before
    public void 문서_객체_생성() {
        document = new Document();
        document.setDocument_id(99);
        document.setTitle("제목입니다.");
        document.setContent("내용입니다.");
    }

    @Test
    public void 문서_CRUD_테스트() {

        // insert test
        int insertCnt = documentDao.insert(document);
        assertEquals(insertCnt, 1);

        // select test
        Document selected = documentDao.select(document.getDocument_id());
        assertNotNull(selected);
        assertEquals(selected.getDocument_id(), document.getDocument_id());
        assertEquals(selected.getTitle(), document.getTitle());
        assertEquals(selected.getContent(), document.getContent());
        assertEquals(selected.getRead_cnt(), document.getRead_cnt());


    }
}