package org.smart4j.annotation;

import java.lang.annotation.*;

/**
 * Created by marszhou on 15/12/21.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Aspect {
    Class<? extends Annotation> value();
}
