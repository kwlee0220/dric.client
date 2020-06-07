package dric.topic;

import com.google.protobuf.MessageLite;

import dric.type.PBSerializable;

/**
 * 
 * @author Kang-Woo Lee (ETRI)
 */
public interface Topic<T extends PBSerializable<? extends MessageLite>> {
	public void publish(T data) throws TopicException;
	public void subscribe(TopicSubscriber<T> subscriber)
		throws TopicException;
}