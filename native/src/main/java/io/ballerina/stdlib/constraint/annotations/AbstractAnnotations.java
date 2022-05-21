/*
 * Copyright (c) 2022, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package io.ballerina.stdlib.constraint.annotations;

import io.ballerina.runtime.api.values.BTypedesc;
import io.ballerina.stdlib.constraint.validators.ArrayConstraintValidator;
import io.ballerina.stdlib.constraint.validators.FloatConstraintValidator;
import io.ballerina.stdlib.constraint.validators.IntConstraintValidator;
import io.ballerina.stdlib.constraint.validators.NumberConstraintValidator;
import io.ballerina.stdlib.constraint.validators.StringConstraintValidator;

import java.util.HashSet;
import java.util.Set;

/**
 * The abstract class to represent the annotation attachment points.
 */
public abstract class AbstractAnnotations {

    private final Set<String> failedConstraints;
    final IntConstraintValidator intConstraintValidator;
    final FloatConstraintValidator floatConstraintValidator;
    final NumberConstraintValidator numberConstraintValidator;
    final StringConstraintValidator stringConstraintValidator;
    final ArrayConstraintValidator arrayConstraintValidator;

    public AbstractAnnotations() {
        this.failedConstraints = new HashSet<>();
        this.intConstraintValidator = new IntConstraintValidator(failedConstraints);
        this.floatConstraintValidator = new FloatConstraintValidator(failedConstraints);
        this.numberConstraintValidator = new NumberConstraintValidator(failedConstraints);
        this.stringConstraintValidator = new StringConstraintValidator(failedConstraints);
        this.arrayConstraintValidator = new ArrayConstraintValidator(failedConstraints);
    }

    public abstract void validate(Object value, BTypedesc typedesc);

    public Set<String> getFailedConstraints() {
        return failedConstraints;
    }
}
