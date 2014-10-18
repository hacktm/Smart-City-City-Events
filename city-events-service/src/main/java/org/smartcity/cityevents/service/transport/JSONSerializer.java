package org.smartcity.cityevents.service.transport;

import flexjson.JSONDeserializer;
import org.smartcity.cityevents.entities.BaseEntity;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Set;

/**
 * JSONSerializer class
 *
 * @author bogdan
 *
 * Date: 26.08.2014, time: 22:46
 */
@Component
public class JSONSerializer {

    //@Value("${json.pretty.print}")
    private Boolean jsonPrettyPrint = true;

    public String serialize(Object object) {
        if (object == null) {
            throw new IllegalArgumentException("Why da' fuck do you serialize a null!?");
        }

        if (object instanceof String) {
            throw new IllegalArgumentException("Why da' fuck do you serialize a string!?");
        }

        return getSerializer(jsonPrettyPrint).serialize(object);
    }

    public String serialize(Object object, boolean jsonPrettyPrint) {
        if (object == null) {
            throw new IllegalArgumentException("Why da' fuck do you serialize a null!?");
        }

        if (object instanceof String) {
            throw new IllegalArgumentException("Why da' fuck do you serialize a string!?");
        }

        return getSerializer(jsonPrettyPrint).serialize(object);
    }

    public String serialize(Set<? extends BaseEntity> entities) {
        return getSerializer(jsonPrettyPrint).serialize(entities);
    }

    @SuppressWarnings("unchecked")
    public <T extends Serializable> T deSerialize(String serializedObject, Class<T> objectClass) {
        return (T) new JSONDeserializer<>().deserialize(serializedObject, objectClass);
    }

    private flexjson.JSONSerializer getSerializer(boolean jsonPrettyPrint) {
        return new flexjson.JSONSerializer()
                .exclude("*.class")
                .include("*")
                .prettyPrint(jsonPrettyPrint);
    }
}
