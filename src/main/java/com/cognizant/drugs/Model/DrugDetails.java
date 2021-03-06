package com.cognizant.drugs.Model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@Entity
@Table(name="drug_details")
public class DrugDetails {
	@Id
    @GeneratedValue
    private int id;
	@Column(name = "location")
	String location;
	@Column(name = "quantity")
	int quantity;
}
