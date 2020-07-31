package dric.dataset.mqtt;

import org.apache.avro.Schema;
import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;

import marmot.RecordSchema;
import marmot.RecordStream;
import marmot.avro.AvroUtils;
import marmot.dataset.AbstractDataSet;
import marmot.dataset.DataSetException;
import marmot.dataset.DataSetInfo;

/**
 * 
 * @author Kang-Woo Lee (ETRI)
 */
public class MqttAvroDataSet extends AbstractDataSet {
	private final String m_brokerHost;
	private final int m_brokerPort;
	private final String m_clientId;
	private final String m_topicName;
	private final RecordSchema m_schema;
	private final Schema m_avroSchema;
	
	public MqttAvroDataSet(DataSetInfo dsInfo, String host, int port, String clientId, String topicName) {
		super(dsInfo);
		
		m_brokerHost = host;
		m_brokerPort = port;
		m_clientId = clientId;
		m_topicName = topicName;
		m_schema = dsInfo.getRecordSchema();
		m_avroSchema = AvroUtils.toSchema(m_schema);
	}

	@Override
	public long getLength() {
		return Long.MAX_VALUE;
	}

	@Override
	public RecordStream read() {
		return new MqttAvroRecordReader(m_brokerHost, m_brokerPort, m_clientId, m_topicName,
										m_schema, m_avroSchema).read();
	}

	@Override
	public long write(RecordStream stream) {
		return new MqttAvroRecordWriter(m_brokerHost, m_brokerPort, m_clientId, m_topicName, m_schema,
										m_avroSchema).write(stream);
	}
	
	public static IMqttClient openMqttSession(String host, int port, String topic) {
		try {
			String brokerUrl = String.format("tcp://%s:%d", host, port);
			
			IMqttClient client = new MqttClient(brokerUrl, topic);
			MqttConnectOptions options = new MqttConnectOptions();
			options.setAutomaticReconnect(true);
			options.setCleanSession(true);
			options.setConnectionTimeout(10);
			client.connect(options);
			
			return client;
		}
		catch ( MqttException e ) {
			String details = String.format("fails to open an MQTT session: host=%s, port=%d, topic=%s",
											host, port, topic);
			throw new DataSetException(details, e);
		}
	}
}
