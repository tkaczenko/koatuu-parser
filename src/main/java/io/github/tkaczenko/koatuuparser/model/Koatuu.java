package io.github.tkaczenko.koatuuparser.model;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Andrii Tkachenko
 */
@Builder
@Data
public class Koatuu implements Serializable {
    private String koatuu;
    private String category;
    private String name;
    private KoatuuStructure structure;
}
