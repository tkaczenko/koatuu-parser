package io.github.tkaczenko.koatuuparser.model.local;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Andrii Tkachenko
 */
@Builder
@Data
public class LocationDTO implements Serializable {
    private String koatuu;
    private String region;
    private String district;
    private String settlement;
    private String locationType;
}
