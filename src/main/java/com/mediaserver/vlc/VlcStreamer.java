package com.mediaserver.vlc;


import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;
import uk.co.caprica.vlcj.binding.LibVlc;
import uk.co.caprica.vlcj.player.MediaPlayerFactory;
import uk.co.caprica.vlcj.player.headless.HeadlessMediaPlayer;
import uk.co.caprica.vlcj.runtime.RuntimeUtil;

/**
 * An example of how to stream a media file over HTTP.
 * <p>
 * The client specifies an MRL of <code>http://127.0.0.1:5555</code>
 */
public class VlcStreamer {

    public static final String STREAM_HOST = "127.0.0.1";
    public static final int STREAM_IP = 5555;

    public static final String VLC_PATH = "C:\\Program Files\\VideoLAN\\VLC";
    public static final String TEST_CONTENT_VIDEO_FILE = "content/bunney.mp4";


    public static void main(String[] args) throws Exception {

        NativeLibrary.addSearchPath(
                RuntimeUtil.getLibVlcLibraryName(), VLC_PATH
        );
        Native.loadLibrary(RuntimeUtil.getLibVlcLibraryName(), LibVlc.class);

        String media = TEST_CONTENT_VIDEO_FILE;
        if(args.length == 1) {
            System.out.println("Specify a single MRL to stream if not default one will be used.");
            media = args[0];
        }

        String options = formatHttpStream(STREAM_HOST, STREAM_IP);

        System.out.println("Streaming '" + media + "' to '" + options + "'");

        MediaPlayerFactory mediaPlayerFactory = new MediaPlayerFactory(args);
        HeadlessMediaPlayer mediaPlayer = mediaPlayerFactory.newHeadlessMediaPlayer();


        mediaPlayer.playMedia(media, options, " :input-repeat=-1");
        //mediaPlayer.setRepeat(true);

        // Don't exit
        Thread.currentThread().join();
    }

    private static String formatHttpStream(String serverAddress, int serverPort) {
        StringBuilder sb = new StringBuilder(60);
        sb.append(":sout=#duplicate{dst=std{access=http,mux=ts,");
        sb.append("dst=");
        sb.append(serverAddress);
        sb.append(':');
        sb.append(serverPort);
        sb.append("}}");
        return sb.toString();
    }
}