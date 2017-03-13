package com.unrealwork.codejam.utils;


import com.unrealwork.codejam.common.Case;

import java.io.IOException;
import java.util.Collection;

public interface CaseLoader<T extends Case> {
    Collection<T> load() throws IOException;
}
