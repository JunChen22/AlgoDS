package com.jchen.project.tree;

import java.util.Set;

public interface ISuffixTree <C extends CharSequence> {

    public boolean doesSubStringExist(C sub);
    public Set<String> getSuffixes();
}
