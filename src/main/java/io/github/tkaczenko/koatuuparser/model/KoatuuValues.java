package io.github.tkaczenko.koatuuparser.model;

/**
 * @author Andrii Tkachenko
 */
public interface KoatuuValues {
    interface Level2Type {
        /**
         * міста обласного значення
         */
        int DISTRICT_CITY = 1;
        /**
         * райони Автономної Республіки Крим, області
         */
        int DISTRICT = 2;
        /**
         * райони міст, що мають спеціальний статус
         */
        int SPECIAL_CITY_REGION = 3;
    }

    interface Level3Type {
        /**
         * міста районного значення
         */
        int REGION_CITY = 1;
        /**
         * райони в містах обласного значення
         */
        int DISTRICT_CITY_REGION = 3;
        /**
         * селища міського типу, що входять до складу міськради;
         */
        int CITY_URBAN_SETTLEMENT = 4;
        /**
         * селища міського типу, що входять до складу райради;
         */
        int REGION_URBAN_SETTLEMENT = 5;
        /**
         * селища міського типу, що входять до складу райради в місті;
         */
        int CITY_REGION_URBAN_SETTLEMENT = 6;
        /**
         * міста, що входять до складу міськради;
         */
        int CITY = 7;
        /**
         * сільради, що входять до складу райради;
         */
        int REGION_SETTLEMENT = 8;
        /**
         * сільради, села, що входять до складу райради міста, міськради.
         */
        int CITY_SETTLEMENT = 9;
    }
}
