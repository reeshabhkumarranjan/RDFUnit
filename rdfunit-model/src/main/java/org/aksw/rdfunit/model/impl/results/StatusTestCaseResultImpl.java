package org.aksw.rdfunit.model.impl.results;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.aksw.rdfunit.enums.RLOGLevel;
import org.aksw.rdfunit.enums.TestCaseResultStatus;
import org.aksw.rdfunit.model.interfaces.TestCase;
import org.aksw.rdfunit.model.interfaces.results.StatusTestCaseResult;
import org.apache.jena.datatypes.xsd.XSDDateTime;
import org.apache.jena.rdf.model.Resource;


/**
 * @author Dimitris Kontokostas
 * @since 1 /6/14 3:26 PM

 */
@ToString
@EqualsAndHashCode(exclude = "element")
public class StatusTestCaseResultImpl extends BaseTestCaseResultImpl implements StatusTestCaseResult {
    private final TestCaseResultStatus status;

    public StatusTestCaseResultImpl(TestCase testCase, TestCaseResultStatus status) {
        this(testCase.getElement(), testCase.getLogLevel(), testCase.getResultMessage(), status);
    }

    public StatusTestCaseResultImpl(Resource testCaseUri, RLOGLevel severity, String message, TestCaseResultStatus status) {
        super(testCaseUri, severity, message);
        this.status = status;
    }

    public StatusTestCaseResultImpl(Resource element, Resource testCaseUri, RLOGLevel severity, String message, XSDDateTime timestamp, TestCaseResultStatus status) {
        super(element, testCaseUri, severity, message, timestamp);
        this.status = status;
    }

    @Override
    public TestCaseResultStatus getStatus() {
        return status;
    }
}
