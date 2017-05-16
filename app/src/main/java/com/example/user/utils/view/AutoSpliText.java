package com.example.user.utils.view;

import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.widget.TextView;

/**
 * Created by Developer-X on 2016/5/27.
 * 解决TextView显示自动换行问题
 */
public class AutoSpliText {
    public  int itemWidth = 0;

    private  String autoSplitText(final TextView tv, int width) {
        final String rawText = tv.getText().toString(); //原始文本
        final Paint tvPaint = tv.getPaint(); //paint，包含字体等信息
        final float tvWidth = width - tv.getPaddingLeft() - tv.getPaddingRight(); //控件可用宽度

        //将原始文本按行拆分
        String[] rawTextLines = rawText.replaceAll("\r", "").split("\n");
        StringBuilder sbNewText = new StringBuilder();
        for (String rawTextLine : rawTextLines) {
            if (tvPaint.measureText(rawTextLine) <= tvWidth) {
                //如果整行宽度在控件可用宽度之内，就不处理了
                sbNewText.append(rawTextLine);
            } else {
                //如果整行宽度超过控件可用宽度，则按字符测量，在超过可用宽度的前一个字符处手动换行
                float lineWidth = 0;
                for (int cnt = 0; cnt != rawTextLine.length(); ++cnt) {
                    char ch = rawTextLine.charAt(cnt);
                    lineWidth += tvPaint.measureText(String.valueOf(ch));
                    if (lineWidth <= tvWidth) {
                        sbNewText.append(ch);
                    } else {
                        sbNewText.append("\n");
                        lineWidth = 0;
                        --cnt;
                    }
                }
            }
            sbNewText.append("\n");
        }

        //把结尾多余的\n去掉
        if (!rawText.endsWith("\n")) {
            sbNewText.deleteCharAt(sbNewText.length() - 1);
        }

        return sbNewText.toString();
    }

    /**
     * TextView不换行
     * @param tv
     */
    public void autoText(final TextView tv) {
        if (itemWidth == 0) {
            tv.post(new Runnable() {
                @Override
                public void run() {
                    Drawable ds[] = tv.getCompoundDrawables();
                    Drawable left = ds[0];
                    Drawable right = ds[2];

                    itemWidth = tv.getWidth() - (left==null?0:left.getIntrinsicWidth()+tv.getCompoundDrawablePadding()) - (right==null?0:right.getIntrinsicWidth()+tv.getCompoundDrawablePadding())  ;
                    final String newText = autoSplitText(tv, itemWidth);
                    tv.setText(newText);

                }
            });
        } else {
            final String newText = autoSplitText(tv, itemWidth);
            tv.setText(newText);
        }

    }
}
