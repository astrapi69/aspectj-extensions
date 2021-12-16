/**
 * The MIT License
 *
 * Copyright (C) 2021 Asterios Raptis
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package io.github.astrapi69.apectj;

import lombok.experimental.UtilityClass;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

import java.util.HashMap;
import java.util.Map;


/**
 * The class {@link JoinPointExtensions} provides extension methods for the {@link JoinPoint} object
 */
@UtilityClass
public class JoinPointExtensions {

    /**
     * Gets the parameter names and the corresponding values
     * @param joinPoint the join point
     * @return the parameter names and the corresponding values as a Map
     */
    public static Map<String, Object> getParameterNamesAndValues(JoinPoint joinPoint)
    {
        String[] parameterNames = ((MethodSignature)joinPoint.getSignature()).getParameterNames();
        Object[] parameterValues = joinPoint.getArgs();
        Map<String, Object> parameterNamesAndValues = new HashMap<>();
        if (parameterNames.length != 0)
        {
            for (int i = 0; i < parameterNames.length; i++)
            {
                parameterNamesAndValues.put(parameterNames[i], parameterValues[i]);
            }
        }
        return parameterNamesAndValues;
    }

    public static JointPointInfo getJointPointInfo(JoinPoint joinPoint) {
        return JointPointInfo.builder()
                .parameterTypes(((MethodSignature)joinPoint.getSignature()).getParameterTypes())
                .parameterNames(((MethodSignature)joinPoint.getSignature()).getParameterNames())
                .parameterValues(joinPoint.getArgs())
                .method(((MethodSignature)joinPoint.getSignature()).getMethod())
                .target(joinPoint.getTarget())
                .kind(joinPoint.getKind())
                .build();
    }

}
