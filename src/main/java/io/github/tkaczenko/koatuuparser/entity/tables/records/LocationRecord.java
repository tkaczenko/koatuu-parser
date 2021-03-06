/*
 * This file is generated by jOOQ.
 */
package io.github.tkaczenko.koatuuparser.entity.tables.records;


import io.github.tkaczenko.koatuuparser.entity.tables.Location;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record6;
import org.jooq.Row6;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.7"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class LocationRecord extends UpdatableRecordImpl<LocationRecord> implements Record6<Long, String, String, String, String, String> {

    private static final long serialVersionUID = 1930541122;

    /**
     * Setter for <code>public.location.id</code>.
     */
    public void setId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.location.id</code>.
     */
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>public.location.district</code>.
     */
    public void setDistrict(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.location.district</code>.
     */
    public String getDistrict() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.location.koatuu</code>.
     */
    public void setKoatuu(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.location.koatuu</code>.
     */
    public String getKoatuu() {
        return (String) get(2);
    }

    /**
     * Setter for <code>public.location.location_type</code>.
     */
    public void setLocationType(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.location.location_type</code>.
     */
    public String getLocationType() {
        return (String) get(3);
    }

    /**
     * Setter for <code>public.location.region</code>.
     */
    public void setRegion(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>public.location.region</code>.
     */
    public String getRegion() {
        return (String) get(4);
    }

    /**
     * Setter for <code>public.location.settlement</code>.
     */
    public void setSettlement(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>public.location.settlement</code>.
     */
    public String getSettlement() {
        return (String) get(5);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record6 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row6<Long, String, String, String, String, String> fieldsRow() {
        return (Row6) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row6<Long, String, String, String, String, String> valuesRow() {
        return (Row6) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field1() {
        return Location.LOCATION.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return Location.LOCATION.DISTRICT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return Location.LOCATION.KOATUU;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return Location.LOCATION.LOCATION_TYPE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field5() {
        return Location.LOCATION.REGION;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field6() {
        return Location.LOCATION.SETTLEMENT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component2() {
        return getDistrict();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component3() {
        return getKoatuu();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component4() {
        return getLocationType();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component5() {
        return getRegion();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component6() {
        return getSettlement();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getDistrict();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getKoatuu();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getLocationType();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value5() {
        return getRegion();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value6() {
        return getSettlement();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LocationRecord value1(Long value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LocationRecord value2(String value) {
        setDistrict(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LocationRecord value3(String value) {
        setKoatuu(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LocationRecord value4(String value) {
        setLocationType(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LocationRecord value5(String value) {
        setRegion(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LocationRecord value6(String value) {
        setSettlement(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LocationRecord values(Long value1, String value2, String value3, String value4, String value5, String value6) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached LocationRecord
     */
    public LocationRecord() {
        super(Location.LOCATION);
    }

    /**
     * Create a detached, initialised LocationRecord
     */
    public LocationRecord(Long id, String district, String koatuu, String locationType, String region, String settlement) {
        super(Location.LOCATION);

        set(0, id);
        set(1, district);
        set(2, koatuu);
        set(3, locationType);
        set(4, region);
        set(5, settlement);
    }
}
