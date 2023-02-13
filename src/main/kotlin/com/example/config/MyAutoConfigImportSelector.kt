package com.example.config

import org.springframework.boot.context.annotation.ImportCandidates
import org.springframework.context.annotation.DeferredImportSelector
import org.springframework.core.type.AnnotationMetadata

/**
 * @author nespot2
 **/
class MyAutoConfigImportSelector(
    private val classLoader: ClassLoader
) : DeferredImportSelector {
    override fun selectImports(importingClassMetadata: AnnotationMetadata): Array<String> {
        val list = mutableListOf<String>()
        val importCandidates = ImportCandidates.load(MyAutoConfiguration::class.java, classLoader)
        for (candidate in importCandidates) {
            list.add(candidate)
        }
        return list.toTypedArray()
    }

}