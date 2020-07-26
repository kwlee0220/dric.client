protoc -I=src/proto/resources/ -I=../../marmot/marmot.data/src/main/proto ^
		--java_out=src/proto/java ^
		src/proto/resources/dric.proto

protoc --plugin=C:\local\protoc-gen-grpc-java ^
		-I=src/proto/resources/ -I=../../marmot/marmot.data/src/main/proto ^
		--grpc-java_out=src/proto/grpc ^
		--proto_path=src/proto/resources/ ^
		src/proto/resources/dric.proto
