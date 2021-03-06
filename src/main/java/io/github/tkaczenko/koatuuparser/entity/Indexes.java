/*
 * This file is generated by jOOQ.
 */
package io.github.tkaczenko.koatuuparser.entity;


import io.github.tkaczenko.koatuuparser.entity.tables.Location;

import javax.annotation.Generated;

import org.jooq.Index;
import org.jooq.OrderField;
import org.jooq.impl.Internal;


/**
 * A class modelling indexes of tables of the <code>public</code> schema.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.7"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Indexes {

    // -------------------------------------------------------------------------
    // INDEX definitions
    // -------------------------------------------------------------------------

    public static final Index DISTRICT_DISTRICT_IDX = Indexes0.DISTRICT_DISTRICT_IDX;
    public static final Index LOCATION_KOATUU_IDX = Indexes0.LOCATION_KOATUU_IDX;
    public static final Index LOCATION_PKEY = Indexes0.LOCATION_PKEY;
    public static final Index LOCATION_REGION_IDX = Indexes0.LOCATION_REGION_IDX;
    public static final Index LOCATION_SETTLEMENT_IDX = Indexes0.LOCATION_SETTLEMENT_IDX;

    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Indexes0 {
        public static Index DISTRICT_DISTRICT_IDX = Internal.createIndex("district_district_idx", Location.LOCATION, new OrderField[] { Location.LOCATION.DISTRICT }, false);
        public static Index LOCATION_KOATUU_IDX = Internal.createIndex("location_koatuu_idx", Location.LOCATION, new OrderField[] { Location.LOCATION.KOATUU }, true);
        public static Index LOCATION_PKEY = Internal.createIndex("location_pkey", Location.LOCATION, new OrderField[] { Location.LOCATION.ID }, true);
        public static Index LOCATION_REGION_IDX = Internal.createIndex("location_region_idx", Location.LOCATION, new OrderField[] { Location.LOCATION.REGION }, false);
        public static Index LOCATION_SETTLEMENT_IDX = Internal.createIndex("location_settlement_idx", Location.LOCATION, new OrderField[] { Location.LOCATION.SETTLEMENT }, false);
    }
}
