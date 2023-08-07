package com.xiaominfo.knife4j.plugin;

import lombok.AllArgsConstructor;

import java.beans.PropertyEditorSupport;

/**
 * @author <a href="xiaoymin@foxmail.com">xiaoymin@foxmail.com</a>
 * 2023/8/7 20:23
 * @since knife4j-handler-enum
 */
@AllArgsConstructor
public class GenericEnumPropertySupport <T extends Enum<T>> extends PropertyEditorSupport {
    final Class<T> enumClass;

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        if (enumClass.isEnum()){
            //必须是枚举
            if (CommonFormEnumParser.class.isAssignableFrom(enumClass)){
                T[] values=enumClass.getEnumConstants();
                if (values!=null&&values.length>0){
                    // 因为都实现了CommonFormEnumParser接口，随便取一个枚举元素都行
                    CommonFormEnumParser<T> one= (CommonFormEnumParser<T>) values[0];
                    setValue(one.fromValue(text));
                }
            }
        }
    }
}
