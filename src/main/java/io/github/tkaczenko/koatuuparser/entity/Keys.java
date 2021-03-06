/*
 * This file is generated by jOOQ.
 */
package io.github.tkaczenko.koatuuparser.entity;


import io.github.tkaczenko.koatuuparser.entity.tables.Location;
import io.github.tkaczenko.koatuuparser.entity.tables.records.LocationRecord;

import javax.annotation.Generated;

import org.jooq.UniqueKey;
import org.jooq.impl.Internal;


/**
 * A class modelling foreign key relationships and constraints of tables of 
 * the <code>public</code> schema.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.7"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // IDENTITY definitions
    // -------------------------------------------------------------------------


    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<LocationRecord> LOCATION_PKEY = UniqueKeys0.LOCATION_PKEY;
    public static final UniqueKey<LocationRecord> LOCATION_KOATUU_IDX = UniqueKeys0.LOCATION_KOATUU_IDX;

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------


    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class UniqueKeys0 {
        public static final UniqueKey<LocationRecord> LOCATION_PKEY = Internal.createUniqueKey(Location.LOCATION, "location_pkey", Location.LOCATION.ID);
        public static final UniqueKey<LocationRecord> LOCATION_KOATUU_IDX = Internal.createUniqueKey(Location.LOCATION, "location_koatuu_idx", Location.LOCATION.KOATUU);
    }
}
