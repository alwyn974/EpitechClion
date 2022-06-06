package re.alwyn974.epitechclion.inspections

import com.intellij.codeHighlighting.HighlightDisplayLevel
import com.intellij.codeInspection.LocalInspectionTool
import com.intellij.codeInspection.ProblemsHolder
import com.intellij.psi.PsiElementVisitor
import re.alwyn974.epitechclion.visitors.EpitechCLionFileVisitor
import javax.swing.JComponent

class EpitechCLionInspection : LocalInspectionTool() {

    override fun getGroupDisplayName(): String = "C/C++"

    override fun getDisplayName(): String = "EpitechCLion"

    override fun isEnabledByDefault(): Boolean = true

    override fun runForWholeFile(): Boolean = true

    override fun getDefaultLevel(): HighlightDisplayLevel {
        return HighlightDisplayLevel.WARNING
    }

    /*override fun createOptionsPanel(): JComponent? {
        return super.createOptionsPanel()
    }*/

    override fun buildVisitor(holder: ProblemsHolder, isOnTheFly: Boolean): PsiElementVisitor {
        return EpitechCLionFileVisitor(holder)
    }

}