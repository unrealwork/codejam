package com.unrealwork.codejam.problems.storecredit;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;


public class StoreCreditCaseTest {
    @Test(dataProvider = "provideCases")
    public void testSolve(StoreCreditCase creditCase, Pair<Integer> result) throws Exception {
        assertEquals(creditCase.solve(), result);
    }


    @DataProvider
    private Object[][] provideCases() {
        return new Object[][]{
                {
                        new StoreCreditCase(
                                100,
                                integerList(new int[]{5, 75, 25})
                        )
                        , new Pair<>(2, 3)
                },
                {
                        new StoreCreditCase(
                                8,
                                integerList(new int[]{2, 1, 9, 4, 4, 56, 90, 3})
                        )
                        , new Pair<>(4, 5)
                }
        };
    }

    private List<Integer> integerList(int[] ints) {
        List<Integer> intList = new ArrayList<Integer>();
        for (int index = 0; index < ints.length; index++) {
            intList.add(ints[index]);
        }
        return intList;
    }
}