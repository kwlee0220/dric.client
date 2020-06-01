package dric.store;

import org.apache.avro.generic.GenericRecord;

/**
 * 
 * @author Kang-Woo Lee (ETRI)
 */
public interface TopicMessageListener {
	public void onMessageArrived(String topic, GenericRecord msg);
}
