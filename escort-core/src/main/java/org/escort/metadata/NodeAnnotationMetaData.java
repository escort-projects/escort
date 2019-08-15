package org.escort.metadata;

import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Shoukai Huang
 * @Date: 2019/8/15 20:51
 */
@Data
public class NodeAnnotationMetaData implements Serializable {

    public NodeAnnotationMetaData() {
    }

    public NodeAnnotationMetaData(String annotationType) {
        this.annotationType = annotationType;
    }

    private String annotationType;

    private Map<String, Object> metaData;

    public void addMetaData(String key, Object value) {
        if (metaData == null) {
            metaData = new HashMap<>(16);
        }
        metaData.put(key, value);
    }

}
