package com.sutherland.games.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@Table(name = "games")
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Game implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4868048865863519883L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;

	@Column(nullable = true, length = 100)
	private String title;

	@Column(nullable = true, length = 200)
	private String platform;

	@Column(nullable = true)
	private float score;

	@Column(nullable = true)
	private String genre;

	@Column(nullable = true, length = 1)
	private String editorChoce;

}
