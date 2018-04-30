/**
 * 
 */
package com.mastertutorial.mvc.batch;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

import com.mastertutorial.mvc.model.BatchResult;

/**
 * @author Yashwanth
 *
 */
public class BatchFieldSetMapper implements FieldSetMapper<BatchResult>{

	@Override
	public BatchResult mapFieldSet(FieldSet fieldSet) throws BindException {
		BatchResult batchResult = new BatchResult();
		batchResult.setBatchId(fieldSet.readString(0));
		batchResult.setBatchName(fieldSet.readString(2));
		//batchResult.setDatets(DateFormatter.parseDate(fieldSet.readString(3), AppConstants.DATE_FORMAT_INPUT).toString());
		batchResult.setDatets(fieldSet.readString(3));
		batchResult.setProcessingTime(fieldSet.readString(1));
		System.out.println("BatchFieldSetMapper ::"+batchResult.toString());
		return batchResult;
	}

	
}
