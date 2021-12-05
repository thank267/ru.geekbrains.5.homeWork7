package ru.geekbrains.homework7.entities;

import lombok.*;

import javax.persistence.*;

@ToString
@Getter
@Setter
@Entity
@Table(name = "products")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "title", length = 250, nullable = false, unique = false)
	private String title;

	@Column(name = "cost", nullable = false, unique = false)
	private int cost;


}
