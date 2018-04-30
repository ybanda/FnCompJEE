/**
 * 
 */
package com.mastertutorial.mvc.batch;

import org.springframework.batch.item.ItemProcessor;

import com.mastertutorial.mvc.model.BatchResult;

/**
 * @author Yashwanth
 *
 */
public class BatchItemProcessor implements ItemProcessor<BatchResult, BatchResult>{

	@Override
	public BatchResult process(BatchResult item) throws Exception {
		
		System.out.println(item.toString());
		
		return item;
	}
	

	
}
