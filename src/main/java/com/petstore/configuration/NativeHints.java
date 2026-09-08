package com.petstore.configuration;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.aot.hint.MemberCategory;
import org.springframework.aot.hint.RuntimeHints;
import org.springframework.aot.hint.RuntimeHintsRegistrar;
import org.springframework.aot.hint.TypeHint;
import org.springframework.aot.hint.TypeReference;

public class NativeHints implements RuntimeHintsRegistrar {
    @Override
    public void registerHints(RuntimeHints hints, ClassLoader classLoader) {
        // Register the array class you need, e.g., java.util.UUID[]
        hints.reflection().registerType(com.petstore.model.User[].class, builder -> 
            builder.withMembers(MemberCategory.INVOKE_PUBLIC_CONSTRUCTORS)
        );
        hints.reflection().registerType(org.hibernate.dialect.PostgreSQLDialect.class, builder -> 
            builder.withMembers(MemberCategory.INVOKE_PUBLIC_CONSTRUCTORS)
        );
        hints.reflection()
        .registerTypes(TypeReference.listOf(
                        ArrayList.class,
                        LinkedList.class,
                        HashSet.class,
                        TreeSet.class,
                        ConcurrentHashMap.class,
                        LinkedHashMap.class,
                        TreeMap.class),
                TypeHint.builtWith(MemberCategory.INVOKE_PUBLIC_CONSTRUCTORS, MemberCategory.INVOKE_PUBLIC_METHODS));
    }
}


