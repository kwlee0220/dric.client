package dric.type;

import dric.store.DrICDataStoreException;

/**
 * 
 * @author Kang-Woo Lee (ETRI)
 */
public class SchemaNotFoundException extends DrICDataStoreException {
	private static final long serialVersionUID = 1L;

	public SchemaNotFoundException(String details) {
		super(details);
	}
}
