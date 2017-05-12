package com.example.user.utils.media;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Environment;
import android.os.Handler;
import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;

/**
 * 录音工具类
 */
public class AudioRecoderUtils {

    //文件路径
    private String filePath;
    //文件夹路径
    private String FolderPath;

    private MediaRecorder mMediaRecorder;
    private final String TAG = AudioRecoderUtils.class.getSimpleName();
    public static final int MAX_LENGTH = 1000 * 60 * 10;// 最大录音时长1000*60*10;

    private OnAudioStatusUpdateListener audioStatusUpdateListener;

    private long startTime;
    private long endTime;
    private MediaPlayer mPlayer;

    /**
     * 文件存储默认sdcard/record
     */
    public AudioRecoderUtils() {

        //默认保存路径为/sdcard/record/下
        this(Environment.getExternalStorageDirectory() + "/MyAudio/");
    }

    public AudioRecoderUtils(String filePath) {
        this.mPlayer = new MediaPlayer();
        File path = new File(filePath);
        if (!path.exists())
            path.mkdirs();
        this.FolderPath = filePath;
    }

    /**
     * 播放本地音频
     *
     * @param context
     * @param path
     */
    public void start(Context context, String path) {
        try {
            if (mPlayer == null) {
                mPlayer = new MediaPlayer();
            }
            AudioManager audioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
            audioManager.setMode(AudioManager.MODE_NORMAL);
            mPlayer.setAudioStreamType(AudioManager.STREAM_RING);
            audioManager.setSpeakerphoneOn(true);
            mPlayer.reset();
            FileInputStream fis = new FileInputStream(new File(path));
            mPlayer.setDataSource(fis.getFD());
            mPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer arg0) {
                    arg0.start();
                }
            });
            mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    mediaPlayer.stop();
                    mediaPlayer.release();
                    mPlayer = null;
                }
            });
            mPlayer.prepare();
            //播放
//            mPlayer.start();
        } catch (Exception e) {
            Log.e(TAG, "prepare() failed");
            e.printStackTrace();
        }
    }

    /**
     * 播放网络音频
     *
     * @param url
     */
    public void start(String url) {
        try {
            if (mPlayer == null) {
                mPlayer = new MediaPlayer();
            }
            mPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);// 设置媒体流类型
            mPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mediaPlayer) {
                    mediaPlayer.start();
                }
            });
            mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    mediaPlayer.stop();
                    mediaPlayer.release();
                    mPlayer = null;
                }
            });
            Log.e(TAG, "音乐播放开始>>" + url);
            mPlayer.reset();
            mPlayer.setDataSource(url); // 设置数据源
            mPlayer.prepare(); // prepare自动播放
//            mPlayer.start();//播放
        } catch (Exception e) {
            Log.e(TAG, "prepare() failed");
            e.printStackTrace();
        }
    }


    public void stop() {
        if (mPlayer != null) {
            mPlayer.stop();
            mPlayer.release();
            mPlayer = null;
        }
    }

    /**
     * 开始录音 使用amr格式
     * 录音文件
     *
     * @return
     */
    public void startRecord() {
        // 开始录音
        /* ①Initial：实例化MediaRecorder对象 */
        if (mMediaRecorder == null)
            mMediaRecorder = new MediaRecorder();
        try {
            mMediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
            mMediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.AMR_NB);
            mMediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
            mMediaRecorder.setAudioChannels(1); // MONO
            mMediaRecorder.setAudioSamplingRate(8000); // 8000Hz
            mMediaRecorder.setAudioEncodingBitRate(64); // seems if change this to
            // 128, still got same file
            // size.
//            /* ②setAudioSource/setVedioSource */
//            mMediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);// 设置麦克风
//            /* ②设置音频文件的编码：AAC/AMR_NB/AMR_MB/Default 声音的（波形）的采样 */
//            mMediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.DEFAULT);
//            /*
//             * ②设置输出文件的格式：THREE_GPP/MPEG-4/RAW_AMR/Default THREE_GPP(3gp格式
//             * ，H263视频/ARM音频编码)、MPEG-4、RAW_AMR(只支持音频且音频编码要求为AMR_NB)
//             */
//            mMediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
            filePath = FolderPath + getCurrentTime() + ".amr";
            /* ③准备 */
            mMediaRecorder.setOutputFile(filePath);
            mMediaRecorder.setMaxDuration(MAX_LENGTH);
            mMediaRecorder.prepare();
            /* ④开始 */
            mMediaRecorder.start();
            // AudioRecord audioRecord.
            /* 获取开始时间* */
            startTime = System.currentTimeMillis();
            updateMicStatus();
            Log.e(TAG, "startTime" + startTime);
        } catch (IllegalStateException e) {
            Log.i(TAG, "call startAmr(File mRecAudioFile) failed!" + e.getMessage());
        } catch (IOException e) {
            Log.i(TAG, "call startAmr(File mRecAudioFile) failed!" + e.getMessage());
        }
    }

    /**
     * 停止录音
     */
    public long stopRecord() {
        if (mMediaRecorder == null)
            return 0L;
        endTime = System.currentTimeMillis();
        mMediaRecorder.stop();
        mMediaRecorder.reset();
        mMediaRecorder.release();
        mMediaRecorder = null;
        audioStatusUpdateListener.onStop(filePath);
        filePath = "";
        return endTime - startTime;
    }

    /**
     * 取消录音
     */
    public void cancelRecord() {

        mMediaRecorder.stop();
        mMediaRecorder.reset();
        mMediaRecorder.release();
        mMediaRecorder = null;
        File file = new File(filePath);
        if (file.exists())
            file.delete();

        filePath = "";

    }

    private final Handler mHandler = new Handler();
    private Runnable mUpdateMicStatusTimer = new Runnable() {
        public void run() {
            updateMicStatus();
        }
    };


    private int BASE = 1;
    private int SPACE = 100;// 间隔取样时间

    public void setOnAudioStatusUpdateListener(OnAudioStatusUpdateListener audioStatusUpdateListener) {
        this.audioStatusUpdateListener = audioStatusUpdateListener;
    }

    /**
     * 更新麦克状态
     */
    private void updateMicStatus() {

        if (mMediaRecorder != null) {
            double ratio = (double) mMediaRecorder.getMaxAmplitude() / BASE;
            double db = 0;// 分贝
            if (ratio > 1) {
                db = 20 * Math.log10(ratio);
                if (null != audioStatusUpdateListener) {
                    audioStatusUpdateListener.onUpdate(db, System.currentTimeMillis() - startTime);
                }
            }
            mHandler.postDelayed(mUpdateMicStatusTimer, SPACE);
        }
    }

    public interface OnAudioStatusUpdateListener {
        /**
         * 录音中...
         *
         * @param db   当前声音分贝
         * @param time 录音时长
         */
        public void onUpdate(double db, long time);

        /**
         * 停止录音
         *
         * @param filePath 保存路径
         */
        public void onStop(String filePath);
    }

    //毫秒转秒
    public String long2String(long time) {

        //毫秒转秒
        int sec = (int) time / 1000;
        int min = sec / 60;    //分钟
        sec = sec % 60;        //秒
        if (min < 10) {    //分钟补0
            if (sec < 10) {    //秒补0
                return "0" + min + ":0" + sec;
            } else {
                return "0" + min + ":" + sec;
            }
        } else {
            if (sec < 10) {    //秒补0
                return min + ":0" + sec;
            } else {
                return min + ":" + sec;
            }
        }

    }

    /**
     * 返回当前时间的格式为 yyyy-MM-dd HH:mm:ss
     *
     * @return
     */
    private String getCurrentTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        return sdf.format(System.currentTimeMillis());
    }
}