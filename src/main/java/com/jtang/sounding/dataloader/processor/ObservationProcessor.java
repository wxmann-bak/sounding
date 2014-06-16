package com.jtang.sounding.dataloader.processor;

import com.jtang.sounding.domain.Observation;
import com.jtang.sounding.domain.config.ObservationConfig;

public interface ObservationProcessor<I> extends Processor<I, Observation> {
	
	void setObservationConfig(ObservationConfig config);

}
