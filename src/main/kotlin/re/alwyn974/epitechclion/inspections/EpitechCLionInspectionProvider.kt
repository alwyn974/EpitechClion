package re.alwyn974.epitechclion.inspections

import com.intellij.util.NotNullProducer

class EpitechCLionInspectionProvider : NotNullProducer<List<Class<out Any>>>{
    override fun produce(): List<Class<out Any>> {
        return listOf(
                EpitechCLionInspection::class.java
        )
    }
}