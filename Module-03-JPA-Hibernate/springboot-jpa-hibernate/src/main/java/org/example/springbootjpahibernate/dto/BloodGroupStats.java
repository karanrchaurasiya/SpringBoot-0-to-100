package org.example.springbootjpahibernate.dto;

import lombok.Data;
import org.example.springbootjpahibernate.entity.Patient;
import org.example.springbootjpahibernate.entity.type.BloodGroupType;

@Data
public class BloodGroupStats {
    private final BloodGroupType bloodGroup;
    private final Long count;
}
