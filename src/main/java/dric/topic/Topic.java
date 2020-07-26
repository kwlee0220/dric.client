package dric.topic;

import dric.type.AvroSerializable;

/**
 * 
 * @author Kang-Woo Lee (ETRI)
 */
public interface Topic<T extends AvroSerializable> {
	public void publish(T data) throws TopicException;
	public void subscribe(TopicSubscriber<T> subscriber)
		throws TopicException;
}