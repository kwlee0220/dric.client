package dric.topic;

/**
 * 
 * @author Kang-Woo Lee (ETRI)
 */
public interface TopicSubscriber<T> {
	public void onMessageArrived(String topic, T msg);
}
