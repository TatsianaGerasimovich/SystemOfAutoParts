package by.bsuir.gerasimovich.parserBrands;

public enum BrandsEnum {
    AUTOPARTS_MODELS("AutopartsModels"),
    AUTOPARTS_MODEL("AutopartModel"),
    MODEL_ID("ModelId"),
    AUTOPART_ID("AutopartId"),
    BRAND_ID("BrandId");

    public String getValue() {
        return value;
    }
    public static BrandsEnum getEnum(String value){
        BrandsEnum result=null;
        for(BrandsEnum en : BrandsEnum.values())
        {
            if(en.getValue().equals(value)){
                result=en;
            }
        }
        return result;
    }
    private String value;
    private BrandsEnum(String value){ this.value=value;}

}
