package com.github.alwyn974.epitechclion.services

import com.intellij.openapi.project.Project
import com.github.alwyn974.epitechclion.MyBundle

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}
