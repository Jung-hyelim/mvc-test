package com.test;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class MysqlConnectTest {
    private static final String DRIVER = "com.mysql.jdbc.Driver"; //Connection을 구현한 클래스의 이름
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/testcode?zeroDateTimeBehavior=convertToNull&serverTimezone=UTC"; //mysql 서버 주소
    private static final String USER = "root"; //계정
    private static final String PW = "root123!@#"; // 비밀번호

    @Test //jUnit이 테스트함
    public void testConnection() throws Exception{
        Class.forName(DRIVER); //DRIVER라는 이름을 가진 클래스를 찾음

        try(Connection con = DriverManager.getConnection(URL,USER,PW)){ //DB 계정과 연결하여 연결된 객체를 Connection 클래스의 인스턴스인 con에 담음
            System.out.println(con);
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Test //jUnit이 테스트함
    public void testInsert() throws Exception{
        Class.forName(DRIVER); //DRIVER라는 이름을 가진 클래스를 찾음

        try(Connection con = DriverManager.getConnection(URL,USER,PW)){ //DB 계정과 연결하여 연결된 객체를 Connection 클래스의 인스턴스인 con에 담음
            int num=insert(con, "test","이름",20);
            System.out.println(num+"개 행 삽입 완료");
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    //INSERT 문을 날리는 메서드 (id는 db에서 자동으로 생성하기에 넣을 필요 없음, 반환값은 넣은 행의 개수)
    private int insert(Connection con, String  user_id, String name, int age) {
        final String SQL= "INSERT INTO USERS(user_id, name, age) VALUES (?,?, ?)"; //sql 쿼리

        //PreparedStatement에서 해당 SQL을 미리 컴파일함
        try(PreparedStatement pstml = (PreparedStatement) con.prepareStatement(SQL)) {
            pstml.setString(1, user_id); //1번째 물음표에 name 삽입
            pstml.setString(2, name); //2번째 물음표에 remark 삽입
            pstml.setInt(3, age);
            return pstml.executeUpdate(); //쿼리실행 반환 값 삽입한 행의 개수
        }catch(Exception e){ //예외처리
            e.printStackTrace();
            System.out.println("테이블에 행 삽입 실패");
            return 0;
        }
    }
}
