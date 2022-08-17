package me.mical.easylib.function

/**
 * @author xiaomu
 * @since 2022/8/17 11:12
 */

/**
 * 判断 HashMap 中是否包含集合的某一元素
 */
inline fun <reified T, R> Map<T, R>.containsKey(elements: List<T>): Boolean {
    for (element in elements) {
        if (containsKey(element)) {
            return true
        }
    }
    return false
}

/**
 * 获取 HashMap 所有键中所有与集合中元素重复的元素
 */
inline fun <reified T, R> Map<T, R>.getContains(elements: List<T>): List<T> {
    val result = arrayListOf<T>()
    for (element in elements) {
        if (containsKey(element)) {
            result.add(element)
        }
    }
    return result
}