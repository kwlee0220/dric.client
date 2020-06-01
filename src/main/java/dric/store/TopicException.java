package dric.store;

/**
 * 
 * @author Kang-Woo Lee (ETRI)
 */
public class TopicException extends DrICDataStoreException {
	private static final long serialVersionUID = 1L;

	public TopicException(String details) {
		super(details);
	}

	public TopicException(String brokerUrl, String userId) {
		this(String.format("broker=%s, user=%d", brokerUrl, userId));
	}
}
