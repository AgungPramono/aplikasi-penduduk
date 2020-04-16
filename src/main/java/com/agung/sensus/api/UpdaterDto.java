package com.agung.sensus.api;

import com.agung.sensus.api.Updater;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.sql.Update;

import java.util.List;
import java.util.Map;

@Getter @Setter
@JsonPropertyOrder({"status","data","description"})
public class UpdaterDto {

    private boolean status = Boolean.TRUE;

    @JsonProperty("data")
    private Updater updater;


}
