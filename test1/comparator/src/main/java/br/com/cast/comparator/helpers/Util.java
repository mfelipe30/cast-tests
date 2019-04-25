package main.java.br.com.cast.comparator.helpers;

public class Util {

    private static final String COST_MENSAGEM = "mensagem";

    /**
     * 
     * @param mensagem
     * @return
     */
    public String buildJsonResponse(String mensagem) {
        JSONObject obj = new JSONObject();
        obj.put(COST_MENSAGEM, mensagem);

        return obj.toString();
    }
}
