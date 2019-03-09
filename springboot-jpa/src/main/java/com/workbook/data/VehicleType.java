package com.workbook.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.workbook.metadata.AutoDocument;

import lombok.Data;

@Data
@AutoDocument(desc = "Bare Bone Class of Generic Vehicle")
@Table(name = "VEHICLE_TYPE")
@Entity
public class VehicleType {
	
	@Id
	@AutoDocument(desc = "Data Model Identification Number")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@AutoDocument(desc = "Vehicle Type Data")
	@Column(name = "TYPE_NAME")
	private String type;

}
