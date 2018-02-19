package br.com.jungle.conexaobanco;

import br.com.jungle.conexaobanco.Class.User;


public class Common {

    private static String DB_NAME = "jungledb";
    private static String COLLECTION_NAME = "user";
    public static String API_KEY = "p51Al3hRjKZjb5gCFj-vQfR2ZJPSPEm0";

    public static String getAddressSingle(User user){
        String baseUrl = String.format("https://api.mlab.com/api/1/databases/%s/collections/%s",DB_NAME,COLLECTION_NAME);
        StringBuilder stringBuilder = new StringBuilder(baseUrl);
        stringBuilder.append("/"+user.get_id().getOid()+"?apiKey="+API_KEY);
        return stringBuilder.toString();
    }



    public static String getAddressAPI(){
        String baseUrl = String.format("https://api.mlab.com/api/1/databases/%s/collections/%s",DB_NAME,COLLECTION_NAME);
        StringBuilder stringBuilder = new StringBuilder(baseUrl);
        stringBuilder.append("?apiKey="+API_KEY);
        return stringBuilder.toString();
    }




}
