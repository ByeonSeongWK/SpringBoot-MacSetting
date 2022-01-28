package com.byeon.blog.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

// ORM -> Java(다른 언어들 포함) Object -> 테이블로 매핑 해주는 기술
@Entity // User 클래스가 MySQL에 테이블이 생성이 된다.
public class User {
	
	// 유저 아이디
	@Id // Primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 프로젝트에서 연결된 DB의 넘버링 전략을 따라간다.
	private int id; // oracle : 시퀀스, MySQL : auto_increment
	
	
	// 유저 이름
	@Column(nullable = false, length = 30) // NOT NULL, 길이 30
	private String username;
	
	// 유저 비밀번호
	@Column(nullable = false, length = 100) // => 해쉬 (비밀번호 암호화)
	private String password; // 비밀번호
	
	// 유저 이메일
	@Column(nullable = false, length = 50)
	private String email;
	
	// 유저 접근 권한
	@ColumnDefault("'user'") // 기본값을 user로 설정 
	private String role; // Enum을 쓰는게 좋다. --> Enum을 사용하면 어떤 데이터의 도메인을 만들어 줄 수 있다. // admin. user, manager 중 하나 선택 가능
	
	
	// 유저 가입 시간
	@CreationTimestamp // 시간이 자동 입력
	private Timestamp createDate;
}
