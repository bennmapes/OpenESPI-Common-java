/*
 * Copyright 2013, 2014, 2015 EnergyOS.org
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.12.12 at 03:18:20 PM EST 
//

package org.energyos.espi.common.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.energyos.espi.common.models.atom.adapters.LineItemAdapter;

/**
 * [extension] Line item of detail for additional cost
 * 
 * <p>
 * Java class for LineItem complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="LineItem">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="amount" type="{http://naesb.org/espi}Int48"/>
 *         &lt;element name="rounding" type="{http://naesb.org/espi}Int48" minOccurs="0"/>
 *         &lt;element name="dateTime" type="{http://naesb.org/espi}TimeType"/>
 *         &lt;element name="note" type="{http://naesb.org/espi}String256"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LineItem", propOrder = { "amount", "rounding", "dateTime",
		"note" })
@Entity
@Table(name = "line_item")
@XmlJavaTypeAdapter(LineItemAdapter.class)
@XmlRootElement(name = "LineItem")
public class LineItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@XmlTransient
	protected Long id;

	protected long amount;
	protected Long rounding;
	protected long dateTime;
	@XmlElement(required = true)
	protected String note;

	@XmlTransient
	@ManyToOne
	@JoinColumn(name = "electric_power_usage_summary_id")
	protected ElectricPowerUsageSummary electricPowerUsageSummary;

	/**
	 * Gets the value of the amount property.
	 * 
	 */
	public long getAmount() {
		return amount;
	}

	/**
	 * Sets the value of the amount property.
	 * 
	 */
	public void setAmount(long value) {
		this.amount = value;
	}

	/**
	 * Gets the value of the rounding property.
	 * 
	 * @return possible object is {@link Long }
	 * 
	 */
	public Long getRounding() {
		return rounding;
	}

	/**
	 * Sets the value of the rounding property.
	 * 
	 * @param value
	 *            allowed object is {@link Long }
	 * 
	 */
	public void setRounding(Long value) {
		this.rounding = value;
	}

	/**
	 * Gets the value of the dateTime property.
	 * 
	 */
	public long getDateTime() {
		return dateTime;
	}

	/**
	 * Sets the value of the dateTime property.
	 * 
	 */
	public void setDateTime(long value) {
		this.dateTime = value;
	}

	/**
	 * Gets the value of the note property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getNote() {
		return note;
	}

	/**
	 * Sets the value of the note property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setNote(String value) {
		this.note = value;
	}

}
