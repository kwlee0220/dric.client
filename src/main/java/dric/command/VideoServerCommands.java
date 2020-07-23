package dric.command;

import dric.DrICClient;
import dric.command.VideoServerCommands.AddCamera;
import dric.command.VideoServerCommands.ListCameraAll;
import dric.command.VideoServerCommands.RemoveCamera;
import dric.proto.CameraInfo;
import dric.video.PBDrICVideoServerProxy;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;
import utils.PicocliSubCommand;

/**
 * 
 * @author Kang-Woo Lee (ETRI)
 */
@Command(name="video_server",
		subcommands= {
			ListCameraAll.class,
			AddCamera.class,
			RemoveCamera.class,
		},
		description="DrICVideoServer related commands")
public class VideoServerCommands extends PicocliSubCommand<DrICClient> {
	@Command(name="list", description="list all camera information")
	public static class ListCameraAll extends PicocliSubCommand<DrICClient> {
		@Option(names={"--csv"}, description={"print in CSV format"})
		private boolean m_csv = false;
		
		@Override
		public void run(DrICClient client) throws Exception {
			try ( PBDrICVideoServerProxy vserver = client.getVideoServer() ) {
				vserver.getCameraAll()
						.forEach(this::printCamera);
			}
		}
		
		private void printCamera(CameraInfo camera) {
			if ( m_csv ) {
				System.out.printf("%s,%s%n", camera.getId(), camera.getRtspUrl());
			}
			else {
				System.out.printf("id=%s, rtsp=%s%n", camera.getId(), camera.getRtspUrl());
			}
		}
	}
	
	@Command(name="add", description="register a camera")
	public static class AddCamera extends PicocliSubCommand<DrICClient> {
		@Parameters(paramLabel="camera-id", index="0", description={"camera id"})
		private String m_cameraId;
		
		@Parameters(paramLabel="rtps_url", index="1", description={"RTPS url"})
		private String m_rtpsUrl;
		
		@Override
		public void run(DrICClient client) throws Exception {
			CameraInfo info = CameraInfo.newBuilder()
										.setId(m_cameraId)
										.setRtspUrl(m_rtpsUrl)
										.build();
			
			try ( PBDrICVideoServerProxy vserver = client.getVideoServer() ) {
				vserver.addCamera(info);
			}
		}
	}
	
	@Command(name="remove", description="unregister a camera")
	public static class RemoveCamera extends PicocliSubCommand<DrICClient> {
		@Parameters(paramLabel="camera-id", index="0", description={"camera id"})
		private String m_cameraId;
		
		@Override
		public void run(DrICClient client) throws Exception {
			try ( PBDrICVideoServerProxy vserver = client.getVideoServer() ) {
				vserver.removeCamera(m_cameraId);
			}
		}
	}
	
	@Override
	public void run(DrICClient initialContext) throws Exception { }
}
