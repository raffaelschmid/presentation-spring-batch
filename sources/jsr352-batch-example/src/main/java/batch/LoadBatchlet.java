package batch;

import javax.batch.api.Batchlet;
import javax.batch.runtime.context.JobContext;
import javax.batch.runtime.context.StepContext;
import javax.inject.Inject;

public class LoadBatchlet implements Batchlet {

	@Inject
	JobContext jobContext;
	
	@Inject
	StepContext stepContext;

	@Override
	public String process() throws Exception {
		return "SUCCESS";
	}

	@Override
	public void stop() throws Exception {
		
	}
}