package com.feirapp.feirapp.models.enums

import com.google.gson.annotations.SerializedName

@Suppress("unused")
enum class MeasureUnitEnum(val stringValue: String) {
    @SerializedName("VAZIO")
    EMPTY("VAZIO"),

    @SerializedName("KG")
    KILO("KG"),

    @SerializedName("UN")
    UNIT("UN"),

    @SerializedName("CX")
    BOX("CX"),

    @SerializedName("L")
    LITER("L"),

    @SerializedName("M")
    METER("M"),

    @SerializedName("PCE")
    PACKAGE("PCE")
}