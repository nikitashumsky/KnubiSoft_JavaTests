package com.knubisoft.base.reflection.model;

import com.knubisoft.base.validation.annotation.Entity;
import jdk.jfr.Name;
import lombok.SneakyThrows;

public class InheritedEntryModel extends EntryModel {

    public InheritedEntryModel(String tableName) {
        super(tableName);
    }

    public InheritedEntryModel(String tableName, String schemaName) {
        super(tableName, schemaName);
    }

    public InheritedEntryModel(String tableName, String schemaName, String version) {
        super(tableName, schemaName, version);
    }

    @Override
    @Entity
    public EntryModel builder() {
        return super.builder();
    }
}
