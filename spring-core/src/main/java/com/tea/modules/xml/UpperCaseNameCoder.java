package com.tea.modules.xml;

import com.thoughtworks.xstream.io.naming.NameCoder;

/**
 * com.xjm.xml
 *
 * @author xiejiemin
 * @create 2020/12/2
 */
public class UpperCaseNameCoder implements NameCoder {
    @Override
    public String encodeNode(String name) {
        return name.equalsIgnoreCase("xml")?"xml":FieldNameUtil.upperCaseFirstLetter(name);
    }

    @Override
    public String encodeAttribute(String name) {
        return name.equalsIgnoreCase("xml")?"xml":FieldNameUtil.upperCaseFirstLetter(name);
    }

    @Override
    public String decodeNode(String nodeName) {
        return FieldNameUtil.lowerCaseFirstLetter(nodeName);
    }

    @Override
    public String decodeAttribute(String attributeName) {
        return FieldNameUtil.lowerCaseFirstLetter(attributeName);
    }
}
