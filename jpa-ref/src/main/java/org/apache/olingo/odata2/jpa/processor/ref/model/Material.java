/*******************************************************************************
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 * 
 *    http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 ******************************************************************************/
package org.apache.olingo.odata2.jpa.processor.ref.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "T_MATERIAL")
public class Material {

  public Material() {}

  public Material(final String materialName, final String typeCode, final double price,
      final String measurementUnit) {
    super();
    this.materialName = materialName;
    this.typeCode = typeCode;
    this.price = price;
    this.measurementUnit = measurementUnit;
  }

  @Id
  @Column(name = "MATERIAL_ID")
  private long materialId;

  @Column(name = "MATERIAL_NAME")
  private String materialName;

  @Column(name = "TYPE_CODE")
  private String typeCode;

  @Column(name = "PRICE")
  private double price;

  @Column(name = "MEASUREMENT_UNIT")
  private String measurementUnit;

  @ManyToMany
  private List<Store> stores = new ArrayList<Store>();

  public long getMaterialId() {
    return materialId;
  }

  public void setMaterialId(final long materialId) {
    this.materialId = materialId;
  }

  public String getMaterialName() {
    return materialName;
  }

  public void setMaterialName(final String materialName) {
    this.materialName = materialName;
  }

  public String getTypeCode() {
    return typeCode;
  }

  public void setTypeCode(final String typeCode) {
    this.typeCode = typeCode;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(final double price) {
    this.price = price;
  }

  public String getMeasurementUnit() {
    return measurementUnit;
  }

  public void setMeasurementUnit(final String measurementUnit) {
    this.measurementUnit = measurementUnit;
  }

  public List<Store> getStores() {
    return stores;
  }

  public void setStores(final List<Store> stores) {
    this.stores = stores;
    Iterator<Store> itr = stores.iterator();
    while (itr.hasNext()) {
      itr.next().getMaterials().add(this);
    }
  }
}
