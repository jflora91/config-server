package tech.plinth.config.database.model;

import com.fasterxml.jackson.databind.JsonNode;
import com.vladmihalcea.hibernate.type.json.JsonNodeStringType;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.OffsetDateTime;

@Entity
@Table(name = "config")
@TypeDef(name = "json-node", typeClass = JsonNodeStringType.class)
public class Configuration {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "id", updatable = false)
    private Long id;

    @NotNull(message = "Version needed to be defined")
    @Column(name = "version")
    private Long version;

    @NotNull(message = "To create a new version is needed data")
    @Type(type = "json-node")
    @Column(name = "data_json", columnDefinition = "json")
    private JsonNode dataJson;

    @NotNull(message = "Platform identification can't be null")
    @Column(name = "platform")
    @Size(max = 255)
    private String platform;

    @Column(name = "created_at", updatable = false)
    private OffsetDateTime createdAt;


    public Configuration() {
    }

    public Configuration(String platform, JsonNode data, Long version) {
        this.platform = platform;
        this.dataJson = data;
        this.version = version;

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public JsonNode getDataJson() {
        return dataJson;
    }

    public void setDataJson(JsonNode dataJson) {
        this.dataJson = dataJson;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }


}
