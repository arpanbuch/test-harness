package stepDefinition;

import cucumber.api.Scenario;
import cucumber.api.java.*;

public class baseReport {

	private String scenarioName;
	private String scenarioResult;
	private String scenarioURI;
	private String scenarioRequest;
	private String scenarioResponse;

	@After
	public void createReportFrame(Scenario scenario) {

		if (scenario.isFailed()) {
			System.out.println(scenario.getName() + " :: FAIL");
		} else {
			System.out.println(scenario.getName() + " :: PASS");
		}
	}

}
