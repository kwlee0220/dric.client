package dric.type;

import com.google.protobuf.Message;

/**
 * 
 * @author Kang-Woo Lee (ETRI)
 */
public interface PBSerializable<T extends Message> {
	public T toProto();
//	public static U fromProto(T proto);
}
