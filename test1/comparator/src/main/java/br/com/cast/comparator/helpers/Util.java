package br.com.cast.comparator.helpers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class Util {

    private static final String COST_MENSAGEM = "mensagem";

    /**
     * 
     * @param mensagem
     * @return
     */
    public String buildJsonResponse(String mensagem) {
        ObjectMapper mapper = new ObjectMapper();
		ObjectNode objectNode = mapper.createObjectNode();
        objectNode.put(COST_MENSAGEM, mensagem);

        return objectNode.toString();
    }
}
