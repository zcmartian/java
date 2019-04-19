package org.smart4j.framework;

import org.smart4j.helper.*;
import org.smart4j.util.ClassUtil;

/**
 * Created by marszhou on 15/12/20.
 */
public final class HelperLoader {
    public static void init() {
        Class<?>[] classList = {ClassHelper.class, BeanHelper.class,
                IocHelper.class, ControllerHelper.class, DatabaseHelper.class};
        for (Class<?> cls : classList) {
            ClassUtil.loadClass(cls.getName(), true);
        }
    }
}
