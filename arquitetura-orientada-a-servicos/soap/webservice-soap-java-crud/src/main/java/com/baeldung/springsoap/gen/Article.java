package com.baeldung.springsoap.gen;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "articles")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Article {

	@Id
	@GeneratedValue
	@Column(name="article_id")
	private Long articleId;
	@Column(name = "title")
	private String title;
	@Column(name = "category")
	private String category;
}
