package com.example;

import lombok.extern.slf4j.Slf4j;
import org.springframework.integration.metadata.MetadataStoreListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class NodeListener implements MetadataStoreListener {

    @Override
    public void onAdd(String key, String value) {
        log.info("add {}: {}", key, value);
    }

    @Override
    public void onRemove(String key, String oldValue) {
        log.info("remove {}: {}", key, oldValue);

    }

    @Override
    public void onUpdate(String key, String newValue) {
        log.info("update {}: {}", key, newValue);
    }
}
