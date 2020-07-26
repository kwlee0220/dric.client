protoc -I=src/main/resources/proto/ -I=../../marmot/marmot.data/src/main/proto ^
		--java_out=src/main/proto/java ^
		src/main/resources/proto/dric.proto

protoc --plugin=C:\local\protoc-gen-grpc-java ^
		-I=src/main/resources/proto/ -I=../../marmot/marmot.data/src/main/proto/ ^
		--grpc-java_out=src/main/proto/grpc ^
		--proto_path=src/main/resources/proto/ ^
		src/main/resources/proto/dric.proto
