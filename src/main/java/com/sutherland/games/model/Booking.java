package com.sutherland.games.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String reason;

	private String status;

	@Temporal(TemporalType.TIMESTAMP)
	private Date bokingFrom;

	@Temporal(TemporalType.TIMESTAMP)
	private Date bookingTo;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createdOn;

	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(columnDefinition = "member_id")
	private Member member;

	@PrePersist
	public void prePersist() {
		this.setCreatedOn(new Date());
	}

}
