package dric.store;

import org.apache.avro.generic.GenericRecord;

/**
 * 
 * @author Kang-Woo Lee (ETRI)
 */
public interface Topic {
	public void publish(GenericRecord data);
}
