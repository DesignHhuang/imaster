package com.wattsonic

import kotlin.js.JsExport
import kotlin.js.JsName

//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或
// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
fun main() {
    console.log("Hello, Kotlin/JS!")
}

@JsExport
class MyExportedClass {
    fun exportedFunction() = "Hello from Kotlin/JS"

    @JsName("customJsName")
    fun functionWithCustomName() = "Custom name"
}

// 导出工具类
@JsExport
object StringUtils {
    // 为 JavaScript 端指定更友好的函数名
    @JsName("capitalizeFirst")
    fun capitalizeFirstLetter(str: String): String {
        if (str.isEmpty()) return str
        return str.substring(0, 1).uppercase() + str.substring(1).lowercase()
    }

    // 计算字符串中单词数量
    fun countWords(str: String): Int {
        return str.trim().split(Regex("\\s+")).takeIf { it[0].isNotEmpty() }?.size ?: 0
    }

    // 支持默认参数（Kotlin 2.2 改进）
    fun truncate(str: String, maxLength: Int = 20, suffix: String = "..."): String {
        return if (str.length <= maxLength) str else str.substring(0, maxLength) + suffix
    }
}

// 导出数据类（自动生成 TypeScript 类型）
@JsExport
data class StringAnalysis(
    val original: String,
    val length: Int,
    val wordCount: Int
)

// 导出扩展函数
@JsExport
fun String.analyze(): StringAnalysis {
    return StringAnalysis(
        original = this,
        length = this.length,
        wordCount = StringUtils.countWords(this)
    )
}

@JsModule("hello")
external fun sayHello(name: String)