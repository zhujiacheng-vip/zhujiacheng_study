package com.zhujiacheng.queue.dome;

public enum CountryEnum {

    ONE(1, "齐"), TWO(2, "楚"), THREE(3, "燕"), FOUT(4, "赵");

    private Integer retCode;

    private String reMessage;

    public Integer getRetCode() {
        return retCode;
    }

    public String getReMessage() {
        return reMessage;
    }

    CountryEnum(Integer retCode, String reMessage) {
        this.retCode = retCode;
        this.reMessage = reMessage;
    }

    public static CountryEnum forEach_CountryEnum(int index) {

        CountryEnum[] values = CountryEnum.values();

        for (CountryEnum value : values) {

            if(index==value.getRetCode()){

                return value;

            }

        }

        return null;

    }

    ;

}
