package br.com.dhakamada.webflux.springbootwebflux.dto;

/**
 * Created by dhakamada on 19/11/17.
 */
public class OperationDTO {

    public String uuid;
    public String name;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
