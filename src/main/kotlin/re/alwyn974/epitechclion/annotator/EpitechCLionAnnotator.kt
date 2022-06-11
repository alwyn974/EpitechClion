package re.alwyn974.epitechclion.annotator

import com.intellij.lang.annotation.AnnotationBuilder
import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.ExternalAnnotator
import com.intellij.lang.annotation.HighlightSeverity
import com.intellij.openapi.editor.Document
import com.intellij.openapi.fileEditor.FileDocumentManager
import com.intellij.openapi.util.TextRange
import com.intellij.openapi.util.TextRange.isProperRange
import com.intellij.psi.PsiDocumentManager
import com.intellij.psi.PsiFile

class EpitechCLionAnnotator : ExternalAnnotator<Document, List<EpitechCLionWarning>>() {

    private val ansiRegex = Regex("(\\x9B|\\x1B\\[)[0-?]*[ -\\\\/]*[@-~]")

    override fun collectInformation(file: PsiFile): Document? {
        return FileDocumentManager.getInstance().getDocument(file.virtualFile)
    }

    override fun doAnnotate(document: Document): List<EpitechCLionWarning> {
        return CNormitek.cnormitek(document).toList()
    }

    override fun apply(file: PsiFile, annotationResult: List<EpitechCLionWarning>, holder: AnnotationHolder) {
        val document = PsiDocumentManager.getInstance(file.project).getDocument(file) ?: return
        for (epitechCLionWarning in annotationResult) {
            val line: Int = epitechCLionWarning.line - 1
            val lineStartOffset = document.getLineStartOffset(line)
            val lineEndOffset = document.getLineEndOffset(line)
            println("$lineStartOffset $lineEndOffset")
            //val range = TextRange(lineStartOffset, lineEndOffset)

            val textInLine = document.getText(TextRange(lineStartOffset, lineEndOffset))
            var col = 0
            var offset = 0
            println("$textInLine ${textInLine[offset]}")
            while (offset < textInLine.length) {
                if (textInLine[offset] == '\t')
                    col += (4 - col % 4)
                else
                    col++
                offset++
            }
            if (!isProperRange(lineStartOffset, lineEndOffset))
                continue
            val builder: AnnotationBuilder = holder.newAnnotation(HighlightSeverity.ERROR, "EpitechCLion: ${epitechCLionWarning.reason.replace(ansiRegex, "")}")
            val range = TextRange(lineStartOffset, lineEndOffset)
            builder.range(range).create()
        }
    }

}
