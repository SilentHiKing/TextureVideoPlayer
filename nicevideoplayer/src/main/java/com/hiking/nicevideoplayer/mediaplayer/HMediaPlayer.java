package com.hiking.nicevideoplayer.mediaplayer;

import android.content.Context;
import android.media.AudioManager;
import android.net.Uri;
import android.view.Surface;
import android.view.SurfaceHolder;

import com.hiking.nicevideoplayer.utils.LogUtil;

import java.io.FileDescriptor;
import java.io.IOException;
import java.util.Map;

import tv.danmaku.ijk.media.player.AndroidMediaPlayer;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
import tv.danmaku.ijk.media.player.MediaInfo;
import tv.danmaku.ijk.media.player.misc.IMediaDataSource;
import tv.danmaku.ijk.media.player.misc.ITrackInfo;

/**
 * Created by Administrator on 2018/3/27.
 */

public class HMediaPlayer implements IMediaPlayer{
    /**
     * IjkPlayer
     **/
    public static final int TYPE_IJK = 111;
    /**
     * MediaPlayer
     **/
    public static final int TYPE_NATIVE = 222;

    private volatile IMediaPlayer mMediaPlayer;

    public HMediaPlayer(int mPlayerType){
        switch (mPlayerType) {
            case TYPE_NATIVE:
                mMediaPlayer = new AndroidMediaPlayer();
                break;
            case TYPE_IJK:
            default:
                mMediaPlayer = new IjkMediaPlayer();
                break;
        }
        mMediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
    }

    @Override
    public void setDisplay(SurfaceHolder surfaceHolder) {

    }

    @Override
    public void setDataSource(Context context, Uri uri) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {
        mMediaPlayer.setDataSource(context,uri);
    }

    @Override
    public void setDataSource(Context context, Uri uri, Map<String, String> map) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {
        mMediaPlayer.setDataSource(context,uri,map);
    }

    @Override
    public void setDataSource(FileDescriptor fileDescriptor) throws IOException, IllegalArgumentException, IllegalStateException {
        mMediaPlayer.setDataSource(fileDescriptor);
    }

    @Override
    public void setDataSource(String s) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {
        mMediaPlayer.setDataSource(s);
    }

    @Override
    public String getDataSource() {
        return mMediaPlayer.getDataSource();
    }

    @Override
    public void prepareAsync() throws IllegalStateException {
        mMediaPlayer.prepareAsync();
    }

    @Override
    public void start() throws IllegalStateException {
        mMediaPlayer.start();
    }

    @Override
    public void stop() throws IllegalStateException {
        mMediaPlayer.stop();
    }

    @Override
    public void pause() throws IllegalStateException {
        mMediaPlayer.stop();
    }

    @Override
    public void setScreenOnWhilePlaying(boolean b) {
        mMediaPlayer.setScreenOnWhilePlaying(b);
    }

    @Override
    public int getVideoWidth() {
        return mMediaPlayer.getVideoWidth();
    }

    @Override
    public int getVideoHeight() {
        return mMediaPlayer.getVideoWidth();
    }

    @Override
    public boolean isPlaying() {
        return mMediaPlayer.isPlaying();
    }

    @Override
    public void seekTo(long l) throws IllegalStateException {
        mMediaPlayer.seekTo(l);
    }

    @Override
    public long getCurrentPosition() {
        return mMediaPlayer.getCurrentPosition();
    }

    @Override
    public long getDuration() {
        return mMediaPlayer.getDuration();
    }

    @Override
    public void release() {
        mMediaPlayer.release();
    }

    @Override
    public void reset() {
        mMediaPlayer.reset();
    }

    @Override
    public void setVolume(float v, float v1) {
        mMediaPlayer.setVolume(v, v1);
    }

    @Override
    public int getAudioSessionId() {
        return mMediaPlayer.getAudioSessionId();
    }

    @Override
    public MediaInfo getMediaInfo() {
        return mMediaPlayer.getMediaInfo();
    }

    @Override
    public void setLogEnabled(boolean b) {
        mMediaPlayer.setLogEnabled(b);
    }

    @Override
    public boolean isPlayable() {
        return mMediaPlayer.isPlayable();
    }

    @Override
    public void setOnPreparedListener(OnPreparedListener onPreparedListener) {
        mMediaPlayer.setOnPreparedListener(onPreparedListener);
    }

    @Override
    public void setOnCompletionListener(OnCompletionListener onCompletionListener) {
        mMediaPlayer.setOnCompletionListener(onCompletionListener);
    }

    @Override
    public void setOnBufferingUpdateListener(OnBufferingUpdateListener onBufferingUpdateListener) {
        mMediaPlayer.setOnBufferingUpdateListener(onBufferingUpdateListener);
    }

    @Override
    public void setOnSeekCompleteListener(OnSeekCompleteListener onSeekCompleteListener) {
        mMediaPlayer.setOnSeekCompleteListener(onSeekCompleteListener);
    }

    @Override
    public void setOnVideoSizeChangedListener(OnVideoSizeChangedListener onVideoSizeChangedListener) {
        mMediaPlayer.setOnVideoSizeChangedListener(onVideoSizeChangedListener);
    }

    @Override
    public void setOnErrorListener(OnErrorListener onErrorListener) {
        mMediaPlayer.setOnErrorListener(onErrorListener);
    }

    @Override
    public void setOnInfoListener(OnInfoListener onInfoListener) {
        mMediaPlayer.setOnInfoListener(onInfoListener);
    }

    @Override
    public void setOnTimedTextListener(OnTimedTextListener onTimedTextListener) {
        mMediaPlayer.setOnTimedTextListener(onTimedTextListener);
    }

    @Override
    public void setAudioStreamType(int i) {
        mMediaPlayer.setAudioStreamType(i);
    }

    @Override
    public void setKeepInBackground(boolean b) {
        mMediaPlayer.setKeepInBackground(b);
    }

    @Override
    public int getVideoSarNum() {
        return mMediaPlayer.getVideoSarNum();
    }

    @Override
    public int getVideoSarDen() {
        return mMediaPlayer.getVideoSarDen();
    }

    @Override
    public void setWakeMode(Context context, int i) {
        mMediaPlayer.setWakeMode(context, i);
    }

    @Override
    public void setLooping(boolean b) {
        mMediaPlayer.setLooping(b);
    }

    @Override
    public boolean isLooping() {
        return mMediaPlayer.isLooping();
    }

    @Override
    public ITrackInfo[] getTrackInfo() {
        return new ITrackInfo[0];
    }

    @Override
    public void setSurface(Surface surface) {
        mMediaPlayer.setSurface(surface);
    }

    @Override
    public void setDataSource(IMediaDataSource iMediaDataSource) {
        mMediaPlayer.setDataSource(iMediaDataSource);
    }

    public void setSpeed(float speed) {
        if (mMediaPlayer instanceof IjkMediaPlayer) {
            ((IjkMediaPlayer) mMediaPlayer).setSpeed(speed);
        } else {
            LogUtil.d("只有IjkPlayer才能设置播放速度");
        }
    }

    public float getSpeed(float speed) {
        if (mMediaPlayer instanceof IjkMediaPlayer) {
            return ((IjkMediaPlayer) mMediaPlayer).getSpeed(speed);
        }
        return 0;
    }

    public long getTcpSpeed() {
        if (mMediaPlayer instanceof IjkMediaPlayer) {
            return ((IjkMediaPlayer) mMediaPlayer).getTcpSpeed();
        }
        return 0;
    }


    public interface HOnVideoSizeChangedListener extends IMediaPlayer.OnVideoSizeChangedListener{
    }

    public interface HOnSeekCompleteListener extends IMediaPlayer.OnSeekCompleteListener{
    }

    public interface HOnBufferingUpdateListener extends IMediaPlayer.OnBufferingUpdateListener{
    }

    public interface HOnCompletionListener extends IMediaPlayer.OnCompletionListener{
    }

    public interface HOnPreparedListener extends IMediaPlayer.OnPreparedListener{
    }

    public interface HOnErrorListener extends IMediaPlayer.OnErrorListener{}

    public interface HOnInfoListener extends IMediaPlayer.OnInfoListener{}

}
