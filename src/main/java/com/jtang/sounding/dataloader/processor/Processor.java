package com.jtang.sounding.dataloader.processor;

import com.jtang.sounding.dataloader.exception.DataProcessingException;

public interface Processor<I, O> {
	
	O process(I input) throws DataProcessingException;

}
