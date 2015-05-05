package by.bsuir.gerasimovich.parser;

public enum AutoPartsEnum {
    //elements
    INVOICE("Invoice"),
    DATE("Date"),
    AGENTID("AgentId"),
    AUTOPARTS("Autoparts"),
    AUTOPART("Autopart"),
    AUTOPARTID("AutopartId"),
    PRICE("Price"),
    NUMBER("Number"),
    CURRENCY("Currency");


    public String getValue() {
        return value;
    }
    public static AutoPartsEnum getEnum(String value){
        AutoPartsEnum result=null;
        for(AutoPartsEnum en : AutoPartsEnum.values())
        {
            if(en.getValue().equals(value)){
                result=en;
            }
        }
        return result;
    }
    private String value;
    private AutoPartsEnum(String value){ this.value=value;}

}
