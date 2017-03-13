package com.unrealwork.codejam.problems.storecredit;

import com.unrealwork.codejam.utils.AbstcractCaseLoader;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;


public class StoreCreditCaseLoader extends AbstcractCaseLoader<StoreCreditCase> {
    public StoreCreditCaseLoader(String dataSetName) {
        super(dataSetName);
    }

    @Override
    public Collection<StoreCreditCase> parseCases(BufferedReader reader) throws IOException {
        Set<StoreCreditCase> result = new HashSet<>();
        Integer caseCount = Integer.parseInt(reader.readLine());
        for (int i = 0; i < caseCount; i++) {
            Integer credit = Integer.parseInt(reader.readLine());
            reader.readLine();
            List<Integer> items = Arrays
                    .stream(reader.readLine().split(" "))
                    .map(Integer::valueOf)
                    .collect(Collectors.toList());
            result.add(new StoreCreditCase(credit, items));
        }
        return result;
    }
}