package com.feirapp.feirapp.models.enums

import com.google.gson.annotations.SerializedName


@Suppress("unused")
enum class StatesEnum(val stringValue: String) {
    @SerializedName("EMPTY")
    EMPTY("EMPTY"),

    @SerializedName("AC")
    ACRE("AC"),

    @SerializedName("AL")
    ALAGOAS("AL"),

    @SerializedName("AP")
    AMAPA("AP"),

    @SerializedName("AM")
    AMAZONAS("AM"),

    @SerializedName("BA")
    BAHIA("BA"),

    @SerializedName("CE")
    CEARA("CE"),

    @SerializedName("DF")
    DISTRITO_FEDERAL("DF"),

    @SerializedName("ES")
    ESPIRITO_SANTO("ES"),

    @SerializedName("GO")
    GOIAS("GO"),

    @SerializedName("MA")
    MARANHAO("MA"),

    @SerializedName("MT")
    MATO_GROSSO("MT"),

    @SerializedName("MS")
    MATO_GROSSO_DO_SUL("MS"),

    @SerializedName("MG")
    MINAS_GERAIS("MG"),

    @SerializedName("PA")
    PARA("PA"),

    @SerializedName("PB")
    PARAIBA("PB"),

    @SerializedName("PR")
    PARANA("PR"),

    @SerializedName("PE")
    PERNAMBUCO("PE"),

    @SerializedName("PI")
    PIAUI("PI"),

    @SerializedName("RJ")
    RIO_DE_JANEIRO("RJ"),

    @SerializedName("RN")
    RIO_GRANDE_DO_NORTE("RN"),

    @SerializedName("RS")
    RIO_GRANDE_DO_SUL("RS"),

    @SerializedName("RO")
    RONDONIA("RO"),

    @SerializedName("RR")
    RORAIMA("RR"),

    @SerializedName("SC")
    SANTA_CATARINA("SC"),

    @SerializedName("SP")
    SAO_PAULO("SP"),

    @SerializedName("SE")
    SERGIPE("SE"),

    @SerializedName("TO")
    TOCANTINS("TO")
}