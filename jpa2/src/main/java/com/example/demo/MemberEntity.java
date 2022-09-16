package com.example.demo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
// 오라클의 엔티티임을 선언
@Entity
@Table(name = "member", uniqueConstraints = { @UniqueConstraint(columnNames = "IDX") })
// Serializable : 데이터 직렬화
public class MemberEntity implements Serializable {

	private static final long serialVersionUID = 751205972389617968L;

	// 하나씩 컬럼 정보를 넣음
	// DB에서 사용될 제약 조건을 미리 설정해줌
	// @Id :아래 컬럼을 Primary Key로 설정
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="IDX", unique = true, nullable=false)
	private long idx;

	@Column(name = "ID", unique = true, nullable = false, length = 20)
	private String id;

	@Column(name = "PASSWORD", nullable = false, length = 20)
	private String password;

	public long getIdx() {
		return idx;
	}

	public void setIdx(long idx) {
		this.idx = idx;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "MemberEntity [idx=" + idx + ", id=" + id + ", password=" + password + "]";
	}
	
}
