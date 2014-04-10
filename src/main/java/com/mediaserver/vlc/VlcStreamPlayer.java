package com.mediaserver.vlc;

import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;
import uk.co.caprica.vlcj.binding.LibVlc;
import uk.co.caprica.vlcj.component.EmbeddedMediaPlayerComponent;
import uk.co.caprica.vlcj.runtime.RuntimeUtil;

import javax.swing.*;

/**
 * Test player to test stream. Also stream can be tested with VLC directly, by opening URL:
 * "http://" + VlcStreamer.STREAM_HOST + ":" + VlcStreamer.STREAM_IP
 */
public class VlcStreamPlayer {

    public static final String MEDIA_FILE = "rtp://" + VlcStreamer.STREAM_HOST + ":" + VlcStreamer.STREAM_IP;
    private final EmbeddedMediaPlayerComponent mediaPlayerComponent;

    private VlcStreamPlayer(String mediaFile) {
        JFrame frame = new JFrame("Stream from: " + VlcStreamer.STREAM_HOST + ":" + VlcStreamer.STREAM_IP);

        mediaPlayerComponent = new EmbeddedMediaPlayerComponent();

        frame.setContentPane(mediaPlayerComponent);

        frame.setLocation(100, 100);
        frame.setSize(1050, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        mediaPlayerComponent.getMediaPlayer().playMedia(mediaFile);
    }

    public static void main(final String[] args) {

        NativeLibrary.addSearchPath(
                RuntimeUtil.getLibVlcLibraryName(), VlcStreamer.VLC_PATH
        );
        Native.loadLibrary(RuntimeUtil.getLibVlcLibraryName(), LibVlc.class);

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new VlcStreamPlayer(MEDIA_FILE);
            }
        });
    }

}
