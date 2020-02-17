package com.yj.Jeans.model;

import lombok.Data;

import javax.persistence.*;


@Data  //getter setter
@Entity  //저장되기 위한 어떤 집합적인 것(Thing:사람,장소,물건,사건,개념).
@Table(name = "freeboard")  //테이블이름
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
