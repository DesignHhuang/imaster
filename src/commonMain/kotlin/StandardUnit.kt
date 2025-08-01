package com.wattsonic

enum class StandardUnit(private val conversionFactor: Double) {
    /**
     * 伏特
     */
    VOLT(1.0),
    TENTH_VOLT(0.1),
    MILLI_VOLT(0.001),
    KILO_VOLT(1000.0),

    /**
     * 安培
     */
    AMPERE(1.0),
    TENTH_AMPERE(0.1),
    HUNDREDTH_AMPERE(0.01),

    /**
     * 安时
     */
    AMPERE_HOUR(1.0),

    /**
     * 欧姆
     */
    KILO_OHM(1000.0),
    OHM(1.0),
    MICRO_OHM(0.001 * 0.001),

    /**
     * 百分比
     */
    PERCENT(1.0),
    TENTH_PERCENT(0.1),
    HUNDREDTH_PERCENT(0.01),

    /**
     * 摄氏度
     */
    CELSIUS(1.0),
    TENTH_CELSIUS(0.1),

    /**
     * 时间(秒)
     */
    SECONDS(1.0),
    TENTH_SECONDS(0.1),
    MINUTE(60.0),
    MILLISECONDS(0.001),

    /**
     * 时间(小时)
     */
    HOUR(1.0),

    /**
     * 欧姆每伏特
     */
    OHM_PER_VOLT(1.0),

    /**
     * 瓦特
     */
    W(1.0),
    TEN_W(10.0),
    TENTH_KW(100.0),
    KW(1000.0),

    /**
     * 千瓦时
     */
    KWH(1.0),
    TENTH_KWH(0.1),
    TEN_WH(0.01),
    WH(0.001),

    /**
     * 整形
     */
    INTEGER(1.0),
    TENTH_INTEGER(0.1),
    MILLI_INTEGER(0.001),

    /**
     * 赫兹
     */
    HZ(1.0),
    TEN_MHZ(0.01),

    /**
     * ⽆功功率
     */
    KVAR(1.0),

    /**
     * 视在功率
     */
    KVA(1.0);

    fun toStandard(value: Long): Number {
        return if (conversionFactor >= 1.0) {
            value * conversionFactor.toLong()
        } else {
            value * conversionFactor
        }
    }
}
