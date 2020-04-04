package io.github.tkaczenko.koatuuparser.model;

import lombok.Builder;
import lombok.Data;

/**
 * @author Andrii Tkachenko
 */
@Builder
@Data
public class KoatuuStructure {
    private String level1Code;
    private int level2Type;
    private String level2Code;
    private int level3Type;
    private String level3Code;
    private String level4Code;
}
