package com.agung.sensus.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Data
@JsonPropertyOrder({"version","files","description"})
public class Updater {

    private String version;
    @JsonProperty("files")
    private Files files;

    private String description;

    @Getter @Setter
    static class Files{
        private Integer vid;
        private String name;
        private String version;
        private String link;
    }
}
