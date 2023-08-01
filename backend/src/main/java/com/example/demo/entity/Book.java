package com.example.demo.entity;

import java.sql.Date;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Data
@Table(name="books")
public class Book {
	
	@Id
	@Nonnull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String tieude;
	private String tacgia;
	private String theloai;
	private Date ngayphathanh;
	private int sotrang;
	private int soluong;
	private String img;
	private String mieuta;
	private String danhgia;
}