package re.alwyn974.epitechclion.visitors

import com.intellij.codeInspection.ExternalAnnotatorInspectionVisitor
import com.intellij.codeInspection.ProblemHighlightType
import com.intellij.codeInspection.ProblemsHolder
import com.jetbrains.cidr.lang.psi.*
import com.jetbrains.cidr.lang.psi.impl.*
import com.jetbrains.cidr.lang.psi.visitors.OCVisitor
import re.alwyn974.epitechclion.EpitechCLionBundle
import re.alwyn974.epitechclion.annotator.EpitechCLionAnnotator

class EpitechCLionFileVisitor(private val holder: ProblemsHolder) : OCVisitor() {

    private val yellowHighlight: ProblemHighlightType = ProblemHighlightType.GENERIC_ERROR_OR_WARNING //ProblemHighlightType.WARNING

    private val whiteStrikethrough: ProblemHighlightType = ProblemHighlightType.LIKE_DEPRECATED
    private val foregroundGrey: ProblemHighlightType = ProblemHighlightType.LIKE_UNUSED_SYMBOL
    private val foregroundRed: ProblemHighlightType = ProblemHighlightType.ERROR

    private val yellowUnderline: ProblemHighlightType = ProblemHighlightType.LIKE_UNKNOWN_SYMBOL //ProblemHighlightType.LIKE_UNKNOWN_SYMBOL
    private val redUnderline: ProblemHighlightType = ProblemHighlightType.GENERIC_ERROR

    private val major: ProblemHighlightType = ProblemHighlightType.GENERIC_ERROR
    private val minor: ProblemHighlightType = ProblemHighlightType.LIKE_UNKNOWN_SYMBOL
    private val info: ProblemHighlightType = ProblemHighlightType.WEAK_WARNING

    private val annotator = EpitechCLionAnnotator()

    override fun visitOCElement(elem: OCElement?) {
        super.visitOCElement(elem)
    }

    override fun visitOCFile(file: OCFile) {
        val problemDescriptors = ExternalAnnotatorInspectionVisitor.checkFileWithExternalAnnotator(file.containingFile, holder.manager, false, annotator)

        for (descriptor in problemDescriptors)
            holder.registerProblem(descriptor.psiElement, descriptor.descriptionTemplate)

        /*val document: Document = FileDocumentManager.getInstance().getDocument(file.virtualFile) ?: return
        val warnings: List<EpitechCLionWarning> = CNormitek.cnormitek(document).toList();
        for (warning in warnings) {
            var level: ProblemHighlightType = when (warning.level) {
                EpitechCLionWarningLevel.MAJOR -> major
                EpitechCLionWarningLevel.MINOR -> minor
                EpitechCLionWarningLevel.INFO -> info
            }
            //holder.registerProblem(stmt.originalElement, EpitechCLionBundle.message("C3_GOTO"), minor)
        }*/
    }

    override fun visitExpression(expr: OCExpression?) {
        super.visitExpression(expr)
    }

    override fun visitStatement(stmt: OCStatement?) {
        super.visitStatement(stmt)
    }

    override fun visitIfStatement(stmt: OCIfStatement?) {
        super.visitIfStatement(stmt)
    }

    override fun visitBlockStatement(stmt: OCBlockStatement?) {
        super.visitBlockStatement(stmt)
    }

    override fun visitLabeledStatement(stmt: OCLabeledStatement?) {
        super.visitLabeledStatement(stmt)
    }

    override fun visitExpressionStatement(stmt: OCExpressionStatement?) {
        super.visitExpressionStatement(stmt)
    }

    override fun visitEmptyStatement(stmt: OCEmptyStatement?) {
        super.visitEmptyStatement(stmt)
    }

    override fun visitReturnStatement(stmt: OCReturnStatement?) {
        super.visitReturnStatement(stmt)
    }

    override fun visitCoreturnStatement(stmt: OCReturnStatement?) {
        super.visitCoreturnStatement(stmt)
    }

    override fun visitCoyieldStatement(stmt: OCCoyieldStatement?) {
        super.visitCoyieldStatement(stmt)
    }

    override fun visitGotoStatement(stmt: OCGotoStatement?) {
        if (stmt == null)
            return
        holder.registerProblem(stmt.originalElement, EpitechCLionBundle.message("C3_GOTO"), minor)
    }

    override fun visitBreakStatement(stmt: OCBreakStatement?) {
        super.visitBreakStatement(stmt)
    }

    override fun visitContinueStatement(stmt: OCContinueStatement?) {
        super.visitContinueStatement(stmt)
    }

    override fun visitLoopStatement(loop: OCLoopStatement?) {
        super.visitLoopStatement(loop)
    }

    override fun visitWhileStatement(stmt: OCWhileStatement?) {
        super.visitWhileStatement(stmt)
    }

    override fun visitDoWhileStatement(stmt: OCDoWhileStatement?) {
        super.visitDoWhileStatement(stmt)
    }

    override fun visitForStatement(stmt: OCForStatement?) {
        super.visitForStatement(stmt)
    }

    override fun visitForeachStatement(statement: OCForeachStatement?) {
        super.visitForeachStatement(statement)
    }

    override fun visitCaseStatement(stmt: OCCaseStatement?) {
        super.visitCaseStatement(stmt)
    }

    override fun visitSwitchStatement(stmt: OCSwitchStatement?) {
        super.visitSwitchStatement(stmt)
    }

    override fun visitSynchronizedStatement(stmt: OCSynchronizedStatement?) {
        super.visitSynchronizedStatement(stmt)
    }

    override fun visitAutoReleasePoolStatement(stmt: OCAutoReleasePoolStatement?) {
        super.visitAutoReleasePoolStatement(stmt)
    }

    override fun visitTryStatement(stmt: OCTryStatement?) {
        super.visitTryStatement(stmt)
    }

    override fun visitThrowExpression(expression: OCThrowExpression?) {
        super.visitThrowExpression(expression)
    }

    override fun visitFinallySection(finallySection: OCFinallySection?) {
        super.visitFinallySection(finallySection)
    }

    override fun visitCatchSection(catchSection: OCCatchSection?) {
        super.visitCatchSection(catchSection)
    }

    override fun visitDeclarationStatement(stmt: OCDeclarationStatement?) {
        super.visitDeclarationStatement(stmt)
    }

    override fun visitCondition(condition: OCCondition?) {
        super.visitCondition(condition)
    }

    override fun visitCommaExpression(expression: OCCommaExpression?) {
        super.visitCommaExpression(expression)
    }

    override fun visitAssignmentExpression(expression: OCAssignmentExpression?) {
        super.visitAssignmentExpression(expression)
    }

    override fun visitConditionalExpression(expression: OCConditionalExpression?) {
        super.visitConditionalExpression(expression)
    }

    override fun visitBinaryExpression(expression: OCBinaryExpression?) {
        super.visitBinaryExpression(expression)
    }

    override fun visitUnaryExpression(expression: OCUnaryExpression?) {
        super.visitUnaryExpression(expression)
    }

    override fun visitPrefixExpression(expression: OCPrefixExpression?) {
        super.visitPrefixExpression(expression)
    }

    override fun visitCastExpression(expression: OCCastExpression?) {
        super.visitCastExpression(expression)
    }

    override fun visitSizeofExpression(expression: OCSizeofExpression?) {
        super.visitSizeofExpression(expression)
    }

    override fun visitNoexceptExpression(expression: OCNoexceptExpression?) {
        super.visitNoexceptExpression(expression)
    }

    override fun visitPostfixExpression(expression: OCPostfixExpression?) {
        super.visitPostfixExpression(expression)
    }

    override fun visitArraySelectionExpression(expression: OCArraySelectionExpression?) {
        super.visitArraySelectionExpression(expression)
    }

    override fun visitCallExpression(expression: OCCallExpression?) {
        super.visitCallExpression(expression)
    }

    override fun visitQualifiedExpression(expression: OCQualifiedExpression?) {
        super.visitQualifiedExpression(expression)
    }

    override fun visitReferenceExpression(expression: OCReferenceExpression?) {
        super.visitReferenceExpression(expression)
    }

    override fun visitParenthesizedExpression(expression: OCParenthesizedExpression?) {
        super.visitParenthesizedExpression(expression)
    }

    override fun visitLiteralExpression(expression: OCLiteralExpression?) {
        super.visitLiteralExpression(expression)
    }

    override fun visitBoxedExpression(expression: OCBoxedExpression?) {
        super.visitBoxedExpression(expression)
    }

    override fun visitGenericSelectionExpression(expression: OCGenericSelectionExpression?) {
        super.visitGenericSelectionExpression(expression)
    }

    override fun visitArrayLiteral(literal: OCNSArrayLiteral?) {
        super.visitArrayLiteral(literal)
    }

    override fun visitDictionaryLiteral(literal: OCNSDictionaryLiteral?) {
        super.visitDictionaryLiteral(literal)
    }

    override fun visitSendMessageExpression(expression: OCSendMessageExpression?) {
        super.visitSendMessageExpression(expression)
    }

    override fun visitSelectorExpression(expression: OCSelectorExpression?) {
        super.visitSelectorExpression(expression)
    }

    override fun visitAvailabilityExpression(expression: OCAvailabilityExpression?) {
        super.visitAvailabilityExpression(expression)
    }

    override fun visitEncodeExpression(expression: OCEncodeExpression?) {
        super.visitEncodeExpression(expression)
    }

    override fun visitProtocolExpression(expression: OCProtocolExpression?) {
        super.visitProtocolExpression(expression)
    }

    override fun visitMessageArgument(argument: OCMessageArgument?) {
        super.visitMessageArgument(argument)
    }

    override fun visitArgumentList(argList: OCArgumentList?) {
        super.visitArgumentList(argList)
    }

    override fun visitDeclaration(declaration: OCDeclaration?) {
        super.visitDeclaration(declaration)
    }

    override fun visitSymbolDeclarator(declarator: OCSymbolDeclarator<*>?) {
        super.visitSymbolDeclarator(declarator)
    }

    override fun visitLocalSymbolDeclarator(declarator: OCLocalSymbolDeclarator<*>?) {
        super.visitLocalSymbolDeclarator(declarator)
    }

    override fun visitDeclarator(declarator: OCDeclarator?) {
        super.visitDeclarator(declarator)
    }

    override fun visitParameterDeclaration(declaration: OCParameterDeclaration?) {
        super.visitParameterDeclaration(declaration)
    }

    override fun visitParameterList(list: OCParameterList?) {
        super.visitParameterList(list)
    }

    override fun visitTemplateParameterList(list: OCTemplateParameterListImpl?) {
        super.visitTemplateParameterList(list)
    }

    override fun visitTypeParameterDeclaration(declaration: OCTypeParameterDeclaration?) {
        super.visitTypeParameterDeclaration(declaration)
    }

    override fun visitCallable(callable: OCCallable<*>?) {
        super.visitCallable(callable)
    }

    override fun visitFunctionDefinition(functionDefinition: OCFunctionDefinition?) {
        super.visitFunctionDefinition(functionDefinition)
    }

    override fun visitClassDeclaration(dcl: OCClassDeclaration<*>?) {
        super.visitClassDeclaration(dcl)
    }

    override fun visitProtocol(protocol: OCProtocol?) {
        super.visitProtocol(protocol)
    }

    override fun visitInterface(anInterface: OCInterface?) {
        super.visitInterface(anInterface)
    }

    override fun visitImplementation(implementation: OCImplementation?) {
        super.visitImplementation(implementation)
    }

    override fun visitClassPredeclaration(predeclaration: OCClassPredeclaration?) {
        super.visitClassPredeclaration(predeclaration)
    }

    override fun visitMethod(method: OCMethod?) {
        super.visitMethod(method)
    }

    override fun visitMethodSelectorPart(part: OCMethodSelectorPart?) {
        super.visitMethodSelectorPart(part)
    }

    override fun visitArgumentSelector(argumentSelector: OCArgumentSelector?) {
        super.visitArgumentSelector(argumentSelector)
    }

    override fun visitInstanceVariableList(list: OCInstanceVariablesList?) {
        super.visitInstanceVariableList(list)
    }

    override fun visitStructLike(struct: OCStructLike?) {
        super.visitStructLike(struct)
    }

    override fun visitStruct(struct: OCStruct?) {
        super.visitStruct(struct)
    }

    override fun visitConcept(concept: OCConceptDeclaration?) {
        super.visitConcept(concept)
    }

    override fun visitRequiresClause(requiresClause: OCRequiresClause?) {
        super.visitRequiresClause(requiresClause)
    }

    override fun visitRequirement(requirement: OCRequirement?) {
        super.visitRequirement(requirement)
    }

    override fun visitUnion(union: OCUnion?) {
        super.visitUnion(union)
    }

    override fun visitEnum(e: OCEnum?) {
        super.visitEnum(e)
    }

    override fun visitReferenceElement(referenceElement: OCReferenceElement?) {
        super.visitReferenceElement(referenceElement)
    }

    override fun visitMacroCall(macroCall: OCMacroCall?) {
        super.visitMacroCall(macroCall)
    }

    override fun visitMacroCallArgument(argument: OCMacroCallArgument?) {
        super.visitMacroCallArgument(argument)
    }

    override fun visitProperty(property: OCProperty?) {
        super.visitProperty(property)
    }

    override fun visitSynthesizePropertiesList(list: OCSynthesizePropertiesList?) {
        super.visitSynthesizePropertiesList(list)
    }

    override fun visitSynthesizeProperty(property: OCSynthesizeProperty?) {
        super.visitSynthesizeProperty(property)
    }

    override fun visitPropertyAttributesList(list: OCPropertyAttributesList?) {
        super.visitPropertyAttributesList(list)
    }

    override fun visitPropertyAttribute(attribute: OCPropertyAttribute?) {
        super.visitPropertyAttribute(attribute)
    }

    override fun visitCompoundInitializer(initializer: OCCompoundInitializer?) {
        super.visitCompoundInitializer(initializer)
    }

    override fun visitDesignatedInitializer(initializer: OCDesignatedInitializer?) {
        super.visitDesignatedInitializer(initializer)
    }

    override fun visitQualifiedDesignator(designator: OCQualifiedDesignator?) {
        super.visitQualifiedDesignator(designator)
    }

    override fun visitTypeElement(typeElement: OCTypeElement?) {
        super.visitTypeElement(typeElement)
    }

    override fun visitConceptPlaceholderType(placeholderType: OCConceptPlaceholderType?) {
        super.visitConceptPlaceholderType(placeholderType)
    }

    override fun visitCategoryName(categoryName: OCCategoryName?) {
        super.visitCategoryName(categoryName)
    }

    override fun visitSuperClassRef(ref: OCSuperClassRef?) {
        super.visitSuperClassRef(ref)
    }

    override fun visitProtocolsList(list: OCProtocolList?) {
        super.visitProtocolsList(list)
    }

    override fun visitImportDirective(directive: OCIncludeDirective?) {
        super.visitImportDirective(directive)
    }

    override fun visitBlockExpression(blockExpression: OCBlockExpression?) {
        super.visitBlockExpression(blockExpression)
    }

    override fun visitLambdaExpression(lambdaExpression: OCLambdaExpression?) {
        super.visitLambdaExpression(lambdaExpression)
    }

    override fun visitLambdaIntroducer(introducer: OCLambdaIntroducer?) {
        super.visitLambdaIntroducer(introducer)
    }

    override fun visitAttributeList(list: OCAttributesList?) {
        super.visitAttributeList(list)
    }

    override fun visitAttribute(attribute: OCAttribute?) {
        super.visitAttribute(attribute)
    }

    override fun visitStatementExpression(statementExpression: OCStatementExpression?) {
        super.visitStatementExpression(statementExpression)
    }

    override fun visitUsingStatement(usingStatement: OCCppUsingStatement?) {
        if (usingStatement == null)
            return
        holder.registerProblem(usingStatement.originalElement, "Using namespace is forbidden", info)
    }

    override fun visitFunctionDeclaration(declaration: OCFunctionDeclaration?) {
        super.visitFunctionDeclaration(declaration)
    }

    override fun visitAsmStatementPart(part: OCAsmStatementPartImpl?) {
        super.visitAsmStatementPart(part)
    }

    override fun visitAsmStatement(statement: OCAsmStatementImpl?) {
        super.visitAsmStatement(statement)
    }

    override fun visitDefineDirective(directive: OCDefineDirectiveImpl?) {
        super.visitDefineDirective(directive)
    }

    override fun visitMacroReferenceElement(element: OCMacroReferenceElementImpl?) {
        super.visitMacroReferenceElement(element)
    }

    override fun visitDefinedDirective(directive: OCDefinedDirectiveImpl?) {
        super.visitDefinedDirective(directive)
    }

    override fun visitMacroParameter(parameter: OCMacroParameterImpl?) {
        super.visitMacroParameter(parameter)
    }

    override fun visitDirective(directive: OCDirective?) {
        super.visitDirective(directive)
    }

    override fun visitCppQualifiedPointer(pointer: OCCppQualifiedPointer?) {
        super.visitCppQualifiedPointer(pointer)
    }

    override fun visitCppNewExpression(expression: OCCppNewExpression?) {
        super.visitCppNewExpression(expression)
    }

    override fun visitCppDeleteExpression(expression: OCCppDeleteExpression?) {
        super.visitCppDeleteExpression(expression)
    }

    override fun visitCppCoawaitExpression(expression: OCCppCoawaitExpression?) {
        super.visitCppCoawaitExpression(expression)
    }

    override fun visitConstructorFieldInitializer(initializer: OCConstructorFieldInitializer?) {
        super.visitConstructorFieldInitializer(initializer)
    }

    override fun visitStaticAssert(staticAssert: OCCppStaticAssert?) {
        super.visitStaticAssert(staticAssert)
    }

    override fun visitPragma(pragma: OCPragma?) {
        super.visitPragma(pragma)
    }

    override fun visitGenericParameter(parameter: OCGenericParameter?) {
        super.visitGenericParameter(parameter)
    }

    override fun visitGenericParametersList(parametersList: OCGenericParametersList?) {
        super.visitGenericParametersList(parametersList)
    }

    override fun visitGenericArgument(parameter: OCGenericArgument?) {
        super.visitGenericArgument(parameter)
    }

    override fun visitGenericArgumentsList(argumentsList: OCGenericArgumentsList?) {
        super.visitGenericArgumentsList(argumentsList)
    }

    override fun visitVariadicPackExpression(expression: OCVariadicPackExpression?) {
        super.visitVariadicPackExpression(expression)
    }

    override fun visitCppTypeIdExpression(expression: OCCppTypeidExpression?) {
        super.visitCppTypeIdExpression(expression)
    }

    override fun visitFoldExpression(expression: OCFoldExpression?) {
        super.visitFoldExpression(expression)
    }
}