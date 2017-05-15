package com.example.user.utils.sys;

import android.content.Context;
import android.widget.TextView;

import com.example.user.utils.R;
import com.jzxiang.pickerview.TimePickerDialog;
import com.jzxiang.pickerview.data.Type;
import com.jzxiang.pickerview.listener.OnDateSetListener;

/**
 * 项目名称：Utils
 * 类描述：TimePickUtils 描述:
 * 创建人：songlijie
 * 创建时间：2017/5/15 10:24
 * 邮箱:814326663@qq.com
 */
public class TimePickUtils {
    public static int ALLTIME = 0;//年月日时分
    public static int YEAR_MONTH_DAY = 1;//年月日
    public static int HOURS_MINS = 2;//时分
    public static int MONTH_DAY_HOUR_MIN = 3;//月日时分
    public static int YEAR_MONTH = 4;//年月
    public static int YEAR = 5;//年
    /**
     * 时间选择器 包含有全部时间选择
     *
     * @param context  上下文
     * @param textView 显示时间的空间
     * @return TimePickerDialog 返回一个选择器
     */
    public static TimePickerDialog showDateTimePop(final Context context, final TextView textView) {
        long tenYears = 10L * 365 * 1000 * 60 * 60 * 24L;
        TimePickerDialog mDialogAll = new TimePickerDialog.Builder()
                .setCancelStringId("取消")
                .setSureStringId("确定")
                .setTitleStringId("请选择会议时间")
                .setYearText("年")
                .setMonthText("月")
                .setDayText("日")
                .setHourText("时")
                .setMinuteText("分")
                .setCyclic(true)
                .setMinMillseconds(System.currentTimeMillis())
                .setMaxMillseconds(System.currentTimeMillis() + tenYears)
                .setCurrentMillseconds(System.currentTimeMillis())
                .setThemeColor(context.getResources().getColor(R.color.timepicker_toolbar_bg))
                .setType(Type.ALL)
                .setWheelItemTextNormalColor(context.getResources().getColor(R.color.timetimepicker_default_text_color))
                .setWheelItemTextSelectorColor(context.getResources().getColor(R.color.timepicker_toolbar_bg))
                .setWheelItemTextSize(14)
                .setCallBack(new OnDateSetListener() {
                    @Override
                    public void onDateSet(TimePickerDialog timePickerView, long millseconds) {
                        textView.setText(DataUtils.longToStringH(millseconds));
                    }
                })
                .build();
        return mDialogAll;
    }

    /**
     * 时间选择器 包含有年月
     *
     * @param context  上下文
     * @param textView 显示时间的空间
     * @return mDialogYearMonth 返回一个选择器
     */
    public static TimePickerDialog showYearMothPop(final Context context, final TextView textView) {
        TimePickerDialog mDialogYearMonth = new TimePickerDialog.Builder()
                .setType(Type.YEAR_MONTH)
                .setCancelStringId("取消")
                .setSureStringId("确定")
                .setTitleStringId("请选择会议时间")
                .setThemeColor(context.getResources().getColor(R.color.timepicker_toolbar_bg))
                .setWheelItemTextNormalColor(context.getResources().getColor(R.color.timetimepicker_default_text_color))
                .setWheelItemTextSelectorColor(context.getResources().getColor(R.color.timepicker_toolbar_bg))
                .setWheelItemTextSize(14)
                .setCallBack(new OnDateSetListener() {
                    @Override
                    public void onDateSet(TimePickerDialog timePickerView, long millseconds) {
                        textView.setText(DataUtils.longToStringH(millseconds));
                    }
                })
                .build();
        return mDialogYearMonth;
    }
    /**
     * 时间选择器 包含有年月日
     *
     * @param context  上下文
     * @param textView 显示时间的空间
     * @return mDialogYearMonth 返回一个选择器
     */
    public static TimePickerDialog showYearMothDayPop(final Context context, final TextView textView) {
        TimePickerDialog mDialogYearMonth = new TimePickerDialog.Builder()
                .setType(Type.YEAR_MONTH_DAY)
                .setCancelStringId("取消")
                .setSureStringId("确定")
                .setTitleStringId("请选择会议时间")
                .setThemeColor(context.getResources().getColor(R.color.timepicker_toolbar_bg))
                .setWheelItemTextNormalColor(context.getResources().getColor(R.color.timetimepicker_default_text_color))
                .setWheelItemTextSelectorColor(context.getResources().getColor(R.color.timepicker_toolbar_bg))
                .setWheelItemTextSize(14)
                .setCallBack(new OnDateSetListener() {
                    @Override
                    public void onDateSet(TimePickerDialog timePickerView, long millseconds) {
                        textView.setText(DataUtils.longToStringH(millseconds));
                    }
                })
                .build();
        return mDialogYearMonth;
    }
    /**
     * 时间选择器 包含有月日时分
     *
     * @param context  上下文
     * @param textView 显示时间的空间
     * @return mDialogYearMonth 返回一个选择器
     */
    public static TimePickerDialog showMothDayHourMinPop(final Context context, final TextView textView) {
        TimePickerDialog mDialogYearMonth = new TimePickerDialog.Builder()
                .setType(Type.MONTH_DAY_HOUR_MIN)
                .setCancelStringId("取消")
                .setSureStringId("确定")
                .setTitleStringId("请选择会议时间")
                .setThemeColor(context.getResources().getColor(R.color.timepicker_toolbar_bg))
                .setWheelItemTextNormalColor(context.getResources().getColor(R.color.timetimepicker_default_text_color))
                .setWheelItemTextSelectorColor(context.getResources().getColor(R.color.timepicker_toolbar_bg))
                .setWheelItemTextSize(14)
                .setCallBack(new OnDateSetListener() {
                    @Override
                    public void onDateSet(TimePickerDialog timePickerView, long millseconds) {
                        textView.setText(DataUtils.longToStringH(millseconds));
                    }
                })
                .build();
        return mDialogYearMonth;
    }
    /**
     * 时间选择器 包含有时分
     *
     * @param context  上下文
     * @param textView 显示时间的空间
     * @return mDialogYearMonth 返回一个选择器
     */
    public static TimePickerDialog showHourMinPop(final Context context, final TextView textView) {
        TimePickerDialog mDialogYearMonth = new TimePickerDialog.Builder()
                .setType(Type.HOURS_MINS)
                .setCancelStringId("取消")
                .setSureStringId("确定")
                .setTitleStringId("请选择会议时间")
                .setThemeColor(context.getResources().getColor(R.color.timepicker_toolbar_bg))
                .setWheelItemTextNormalColor(context.getResources().getColor(R.color.timetimepicker_default_text_color))
                .setWheelItemTextSelectorColor(context.getResources().getColor(R.color.timepicker_toolbar_bg))
                .setWheelItemTextSize(14)
                .setCallBack(new OnDateSetListener() {
                    @Override
                    public void onDateSet(TimePickerDialog timePickerView, long millseconds) {
                        textView.setText(DataUtils.longToStringH(millseconds));
                    }
                })
                .build();
        return mDialogYearMonth;
    }
    /**
     * 时间选择器 包含有年
     *
     * @param context  上下文
     * @param textView 显示时间的空间
     * @return mDialogYearMonth 返回一个选择器
     */
    public static TimePickerDialog showYearPop(final Context context, final TextView textView) {
        TimePickerDialog mDialogYearMonth = new TimePickerDialog.Builder()
                .setType(Type.YEAR)
                .setCancelStringId("取消")
                .setSureStringId("确定")
                .setTitleStringId("请选择会议时间")
                .setThemeColor(context.getResources().getColor(R.color.timepicker_toolbar_bg))
                .setWheelItemTextNormalColor(context.getResources().getColor(R.color.timetimepicker_default_text_color))
                .setWheelItemTextSelectorColor(context.getResources().getColor(R.color.timepicker_toolbar_bg))
                .setWheelItemTextSize(14)
                .setCallBack(new OnDateSetListener() {
                    @Override
                    public void onDateSet(TimePickerDialog timePickerView, long millseconds) {
                        textView.setText(DataUtils.longToStringH(millseconds));
                    }
                })
                .build();
        return mDialogYearMonth;
    }

    /**
     * 时间选择器
     * @param context           上下文对象
     * @param textView          显示时间的控件
     * @param cancleString      取消按钮的文字 传null使用默认
     * @param sureString        确定按钮显示的文字 传null使用默认
     * @param titleString       标题  传null使用默认
     * @param type              类型 0代表全部时间(即年月日时分,选择{@link TimePickUtils.ALLTIME}),
     *                                1代表年月日(选择{@link TimePickUtils.YEAR_MONTH_DAY}),
     *                                2代表时分(选择{@link TimePickUtils.HOURS_MINS}),
     *                                3代表月日时分(选择{@link TimePickUtils.MONTH_DAY_HOUR_MIN}),
     *                                4代表年月(选择{@link TimePickUtils.YEAR_MONTH}),
     *                                5代表年(选择{@link TimePickUtils.YEAR})
     * @param textNumalColor    显示字体的默认颜色 如果使用默认颜色则传0
     * @param textselectColor   显示字体的选中颜色 如果使用默认颜色则传0
     * @param themeColor        主题颜色 如果使用默认颜色则传0
     * @param textSize          显示字体大小 如果使用默认字体则传0
     * @param isCyclic          是否循环 默认不循环  传false 不循环 true 循环
     * @return TimePickerDialog 返回一个时间选择器  显示方法 mDialog.show(getSupportFragmentManager(),"all");
     *              括号内第二个参数可传 "all"(全部),"year_month"(年月),"year_month_day"(年月日),"month_day_hour_minute"(月日时分),"hour_minute"(时分),"year"(年)
     *              需要对应所传的type类型
     */
    public static TimePickerDialog showTimePickerPop(final Context context, final TextView textView, String cancleString, String sureString, String titleString, final int type, int textNumalColor, int textselectColor, int themeColor, int textSize, boolean isCyclic) {
        long tenYears = 10L * 365 * 1000 * 60 * 60 * 24L;
        TimePickerDialog.Builder builder = new TimePickerDialog.Builder()
                .setCancelStringId(cancleString == null ? "取消" : cancleString)//取消按钮的文字
                .setSureStringId(sureString == null ? "确定" : sureString)//确定按钮的文字
                .setTitleStringId(titleString == null ? "选择时间" : titleString)//标题
                .setCyclic(isCyclic ? false : isCyclic);//是否可以循环  默认不循环
        builder.setWheelItemTextNormalColor(context.getResources().getColor(textNumalColor == 0 ? R.color.timetimepicker_default_text_color : textNumalColor))
                .setWheelItemTextSelectorColor(context.getResources().getColor(textselectColor == 0 ? R.color.timepicker_toolbar_bg : textselectColor))
                .setThemeColor(context.getResources().getColor(themeColor == 0 ? R.color.timepicker_toolbar_bg : themeColor))
                .setWheelItemTextSize(textSize==0 ? 12 : textSize);
        switch (type){
            case 0://全部
                builder.setMinMillseconds(System.currentTimeMillis())
                        .setMaxMillseconds(System.currentTimeMillis() + tenYears)
                        .setCurrentMillseconds(System.currentTimeMillis())
                        .setType(Type.ALL);
                break;
            case 1://年月日
                builder.setType(Type.YEAR_MONTH_DAY);
                break;
            case 2://时分
                builder.setType(Type.HOURS_MINS);
                break;
            case 3://月日时分
                builder.setType(Type.MONTH_DAY_HOUR_MIN);
                break;
            case 4://年月
                builder.setType(Type.YEAR_MONTH);
                break;
            case 5://年
                builder.setType(Type.YEAR);
                break;
        }
        builder.setCallBack(new OnDateSetListener() {
            @Override
            public void onDateSet(TimePickerDialog timePickerView, long millseconds) {
                textView.setText(DataUtils.longToStringH(millseconds,type));
            }
        });


        TimePickerDialog mDialogAll = builder.build();
        return mDialogAll;
    }
}
