package com.unrealwork.codejam.utils;


import com.unrealwork.codejam.common.Case;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;

public abstract class AbstcractCaseLoader<T extends Case> implements CaseLoader<T> {
    private String dataSetName;
    public static final Logger logger = LoggerFactory.getLogger(AbstcractCaseLoader.class);

    public AbstcractCaseLoader(String dataSetName) {
        this.dataSetName = dataSetName;
    }

    @Override
    public Collection<T> load() throws IOException {
        String dataSetPath = AbstcractCaseLoader.class.getClassLoader()
                .getResource("datasets/".concat(dataSetName))
                .getPath();
        if (dataSetPath == null) {
            logger.error("Data set {} not available", dataSetPath);
            throw new IOException();
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(new File(dataSetPath)))) {
            return parseCases(reader);
        } catch (IOException e) {
            logger.error("Unable to find dataset {}. {}", dataSetName, e);
            throw e;
        }
    }

    public abstract Collection<T> parseCases(BufferedReader reader) throws IOException;
}
