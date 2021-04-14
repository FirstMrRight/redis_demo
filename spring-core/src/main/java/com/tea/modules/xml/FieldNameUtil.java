package com.tea.modules.xml;

/**
 * com.xjm.xml
 *
 * @author xiejiemin
 * @create 2020/12/2
 */
public class FieldNameUtil {
    /**
     * 分割驼峰字段
     * @param name
     * @param separator
     * @return
     */
    private static String separateCamelCase(String name, String separator) {
        StringBuilder translation = new StringBuilder();
        for (int i = 0; i < name.length(); i++) {
            char character = name.charAt(i);
            if (Character.isUpperCase(character) && translation.length() != 0) {
                translation.append(separator);
            }
            translation.append(character);
        }
        return translation.toString();
    }
    /**
     * 下划线转换为驼峰
     */
    public static String underscore2CamelCase(String name) {
        StringBuilder translation = new StringBuilder();
        for (int i = 0; i < name.length(); i++) {
            char character = name.charAt(i);
            if (character == '_')
                continue;
            if (translation.length() != 0 && name.charAt(i - 1) == '_') {
                translation.append(Character.toUpperCase(character));
            } else {
                translation.append(character);
            }
        }
        return translation.toString();
    }

    /**
     * 驼峰转换为下划线
     * @param name
     * @return
     */
    public static String camelCase2Underscore(String name) {
        return separateCamelCase(name, "_").toLowerCase();
    }

    /**
     * 首字母大写
     * @param name
     * @return
     */
    public static String upperCaseFirstLetter(String name){
        StringBuilder fieldNameBuilder = new StringBuilder();
        int index = 0;
        char firstCharacter = name.charAt(index);
        while (index < name.length() - 1) {
            if (Character.isLetter(firstCharacter)) {
                break;
            }

            fieldNameBuilder.append(firstCharacter);
            firstCharacter = name.charAt(++index);
        }

        if (index == name.length()) {
            return fieldNameBuilder.toString();
        }

        if (!Character.isUpperCase(firstCharacter)) {
            String modifiedTarget = modifyString(Character.toUpperCase(firstCharacter), name, ++index);
            return fieldNameBuilder.append(modifiedTarget).toString();
        } else {
            return name;
        }
    }

    /**
     * 首字母小写
     * @param name
     * @return
     */
    public static String lowerCaseFirstLetter(String name){
        StringBuilder fieldNameBuilder = new StringBuilder();
        int index = 0;
        char firstCharacter = name.charAt(index);
        while (index < name.length() - 1) {
            if (Character.isLetter(firstCharacter)) {
                break;
            }

            fieldNameBuilder.append(firstCharacter);
            firstCharacter = name.charAt(++index);
        }

        if (index == name.length()) {
            return fieldNameBuilder.toString();
        }

        if (!Character.isLowerCase(firstCharacter)) {
            String modifiedTarget = modifyString(Character.toLowerCase(firstCharacter), name, ++index);
            return fieldNameBuilder.append(modifiedTarget).toString();
        } else {
            return name;
        }
    }

    /**
     * 修改字符串
     * @param firstCharacter
     * @param srcString
     * @param indexOfSubstring
     * @return
     */
    private static String modifyString(char firstCharacter, String srcString, int indexOfSubstring) {
        return (indexOfSubstring < srcString.length())
                ? firstCharacter + srcString.substring(indexOfSubstring)
                : String.valueOf(firstCharacter);
    }
}
