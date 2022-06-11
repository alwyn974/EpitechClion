package re.alwyn974.epitechclion.annotator

class EpitechCLionWarning (
    val line: Int,
    val reason: String,
    val level: EpitechCLionWarningLevel
)

enum class EpitechCLionWarningLevel {
    INFO,
    MINOR,
    MAJOR
}
