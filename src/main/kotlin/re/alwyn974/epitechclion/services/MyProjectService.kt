package re.alwyn974.epitechclion.services

import com.intellij.openapi.project.Project
import re.alwyn974.epitechclion.EpitechCLionBundle

class MyProjectService(project: Project) {

    init {
        println(EpitechCLionBundle.message("projectService", project.name))
    }
}
