package re.alwyn974.epitechclion.annotator

import com.intellij.openapi.editor.Document
import com.intellij.openapi.fileEditor.FileDocumentManager
import re.alwyn974.epitechclion.EpitechCLionBundle
import java.util.concurrent.TimeUnit

object CNormitek {

    fun cnormitek(document: Document): Array<EpitechCLionWarning> {
        val file = FileDocumentManager.getInstance().getFile(document) ?: return emptyArray()
        val externalAnnotatorResult = runCnormitek(file.path)
        return parse(externalAnnotatorResult)
    }

    private fun parse(res: String?): Array<EpitechCLionWarning> {
        val errors = res?.split("\n")
        if (errors == null || errors.isEmpty()) return emptyArray()
        val result = ArrayList<EpitechCLionWarning>()
        for (error in errors) {
            val split = error.split(":")
            if (split.size < 3) continue
            val line = split[1].toInt()
            var message = split[3]
            val code = message.split("-")[0]
            if (EpitechCLionBundle.containsKey(code))
                message = EpitechCLionBundle.message(code)
            var level: EpitechCLionWarningLevel = EpitechCLionWarningLevel.MINOR
            if (message.contains("minor"))
                level = EpitechCLionWarningLevel.MINOR
            if (message.contains("major"))
                level = EpitechCLionWarningLevel.MAJOR
            if (message.contains("info"))
                level = EpitechCLionWarningLevel.INFO
            result.add(EpitechCLionWarning(line, message, level))
        }
        return result.toTypedArray()
    }

    private fun runCnormitek(path: String): String {
        val process = ProcessBuilder("cnormitek", path)
            .redirectOutput(ProcessBuilder.Redirect.PIPE)
            .redirectError(ProcessBuilder.Redirect.PIPE)
            .start()

        process.waitFor(60, TimeUnit.MINUTES)
        return process.inputStream.bufferedReader().readText()
    }

}