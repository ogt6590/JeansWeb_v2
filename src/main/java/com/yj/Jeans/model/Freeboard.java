package com.yj.Jeans.model;

import lombok.Data;

import javax.persistence.*;

@Data  //getter setter
@Entity  //jpa 아 관리하는 기능 선언
@Table(name = "freeboard")  //freeboard 테이블과 연결한다
public class Freeboard {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)  //기본키값 자동으로 1씩 상승
    @Column(name="free_id") //컬럼명이 free_id 로 선언한다
    private Long freeid;

    @Column(name = "content")
    private String content;

    @Column(name = "title")
    private String title;

    @Column(name = "writer")
    private String writer;

}
