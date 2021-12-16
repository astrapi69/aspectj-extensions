package io.github.astrapi69.apectj;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import java.lang.reflect.Method;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class JointPointInfo {
    Class<?>[] parameterTypes;
    String[] parameterNames;
    Object[] parameterValues;
    Method method;
    Object target;
    String kind;
}
