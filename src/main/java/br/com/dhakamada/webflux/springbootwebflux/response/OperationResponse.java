package br.com.dhakamada.webflux.springbootwebflux.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by dhakamada on 19/11/17.
 */
public class OperationResponse {

    @JsonProperty("code")
    private String uuid;

    @JsonCreator
    public OperationResponse(String uuid) {
        this.uuid = uuid;
    }
}
