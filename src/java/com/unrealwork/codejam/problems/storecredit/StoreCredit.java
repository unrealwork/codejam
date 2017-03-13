package com.unrealwork.codejam.problems.storecredit;


import com.unrealwork.codejam.utils.CaseLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Collection;

import static java.lang.System.out;

public class StoreCredit {
    private static final String DATA_SET_NAME = "store-credit-large.in";
    private static final Logger logger = LoggerFactory.getLogger(StoreCredit.class);

    public static void main(String[] args) {
        CaseLoader<StoreCreditCase> caseLoader = new StoreCreditCaseLoader(DATA_SET_NAME);
        try {
            Collection<StoreCreditCase> cases = caseLoader.load();
            logger.info("{}", cases.size());
            int index = 0;
            for (StoreCreditCase creditCase : cases) {
                out.println(String.format("Case %d: %s", index, creditCase.solve().getKey()));
                index++;
            }
        } catch (IOException e) {
            logger.error("Failed to load data set {}", DATA_SET_NAME);
            throw new IllegalStateException(e);
        }
    }

}
