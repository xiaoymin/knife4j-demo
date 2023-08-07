package com.xiaominfo.knife4j.plugin;

/**
 * @author <a href="xiaoymin@foxmail.com">xiaoymin@foxmail.com</a>
 * 2023/8/7 20:20
 * @since knife4j-handler-enum
 */
public interface CommonFormEnumParser<T extends Enum<T>> {
    /**
     * Realize the instantiation of the enumeration according to the input input
     * @param input input character
     * @return enumeration instance
     */
    T fromValue(String input);
}
